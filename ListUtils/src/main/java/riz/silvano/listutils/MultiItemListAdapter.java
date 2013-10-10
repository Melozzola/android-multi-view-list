package riz.silvano.listutils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Implementation of a {@link android.widget.BaseAdapter} capable to handle multi views.
 * <p/>
 * Created by mele on 07/09/2013.
 */
public class MultiItemListAdapter extends BaseAdapter implements Observer
{

    // The data
    private ObservableList<ItemWrapper> data;

    // View types supported by the adapter
    private ViewTypes viewTypes;

    private LayoutInflater inflater;

    private RowHolderFacade rowHolderFacade;

    /**
     * Constructor.
     *
     * @param viewTypes The {@link riz.silvano.listutils.ViewTypes} supported by the adapter
     */
    public MultiItemListAdapter(ViewTypes viewTypes, LayoutInflater inflater, RowHolderFacade rowHolderFacade)
    {
        super();
        this.data = new ObservableList<ItemWrapper>();
        this.data.addObserver(this);
        this.viewTypes = viewTypes;
        this.inflater = inflater;
        this.rowHolderFacade = rowHolderFacade;
    }

    /**
     * Adds items
     *
     * @param items the items
     */
    public void addItems(List<ItemWrapper> items)
    {
        this.data.addAll(items);
    }

    /**
     * Adds an item to the list
     *
     * @param item The item to add
     */
    public void addItem(ItemWrapper item)
    {
        this.data.add(item);
    }

    /**
     * Clears the list
     */
    public void clearItems()
    {
        this.data.clear();
    }

    /**
     * Removes the idx-element
     *
     * @param idx The index of the element to remove.
     */
    public void deleteItem(int idx){
        this.data.remove(idx);
    }

    /**
     * Resets the list, initializing it with the new items
     *
     * @param items The new items
     */
    public void reset(List<ItemWrapper> items)
    {
        this.data.silentClear();
        this.data.addAll(items);
    }

    @Override
    public ItemWrapper getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public void update(Observable observable, Object data)
    {
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return viewTypes.getType(data.get(position).getItem().getClass());
    }

    @Override
    public int getViewTypeCount()
    {
        return viewTypes.getCount();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View row = convertView;
        ItemWrapper iw = getItem(position);
        int itemType = getItemViewType(position);
        RowHolder rh;

        if (row == null)
        {
            row = inflater.inflate(viewTypes.getRes(itemType), parent, false);
            rh = rowHolderFacade.newRowHolder(itemType);
            row.setTag(rh);
        } else
        {
            rh = (RowHolder) row.getTag();
        }

        Class itemClass = viewTypes.getItemClass(itemType);
        rh.init(itemClass.cast(iw.getItem()), row);

        return row;
    }
}