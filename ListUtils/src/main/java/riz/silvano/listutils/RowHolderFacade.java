package riz.silvano.listutils;

/**
 * Interface defining the facade for Row holders
 * <p/>
 * Created by mele on 08/09/2013.
 */
public interface RowHolderFacade
{

    /**
     * Creates a new row holder based on the view type.
     *
     * @param viewType the view type
     * @return The {@link riz.silvano.listutils.RowHolder} for the specific view type
     */
    public RowHolder<?> newRowHolder(int viewType);

}
