package riz.silvano.listutils;

import android.view.View;

/**
 * A row holder
 * <p/>
 * Created by mele on 08/09/2013.
 */
public interface RowHolder<T>
{

    /**
     * Initializes the view
     *
     * @param item The actual item.
     * @param row  The view
     */
    public void init(T item, View row);

}
