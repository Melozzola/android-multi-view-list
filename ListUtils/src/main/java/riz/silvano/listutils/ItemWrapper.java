package riz.silvano.listutils;

/**
 * Defines a uniform item to use in the {@link riz.silvano.listutils.MultiItemListAdapter}
 * It allows to store the actual item, extract them and identify the view type.
 * <p/>
 * Created by mele on 06/09/2013.
 */
public class ItemWrapper
{

    private Object item;

    /**
     * Constructs a new ItemWrapper
     *
     * @param item The actual item to wrap
     */
    public ItemWrapper(Object item)
    {
        this.item = item;
    }

    public Object getItem()
    {
        return item;
    }

}
