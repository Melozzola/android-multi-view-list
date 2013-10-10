package riz.silvano.listutils;

/**
 * Interface that defines the type of views handled by a {@link riz.silvano.listutils.MultiItemListAdapter}
 * <p/>
 * Created by mele on 07/09/2013.
 */
public interface ViewTypes
{

    /**
     * Returns the number of different rows
     *
     * @return The number of different rows
     */
    public int getCount();

    /**
     * Returns the class of the item of the specific type
     *
     * @param type the item type
     * @return The class of the item of type type.
     */
    public Class<?> getItemClass(int type);

    /**
     * Returns the layout resource id for the view for the specific type
     *
     * @param type the item type
     * @return the layout resource id
     */
    public int getRes(int type);

    /**
     * Returns the type for a specific class
     *
     * @param clazz The item class
     * @return te type.
     */
    public int getType(Class<?> clazz);

}