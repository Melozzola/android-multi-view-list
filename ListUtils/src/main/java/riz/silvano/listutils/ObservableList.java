package riz.silvano.listutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

/**
 * An {@link java.util.Observable} List.
 * <p/>
 * Created by mele on 06/09/2013.
 */
public class ObservableList<T> extends Observable implements List<T>
{

    private List<T> localList;

    public ObservableList()
    {
        localList = new ArrayList<T>();
    }

    @Override
    public void add(int location, T object)
    {
        localList.add(location, object);
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean add(T object)
    {
        boolean ret = localList.add(object);
        setChanged();
        notifyObservers();
        return ret;
    }

    @Override
    public boolean addAll(int location, Collection<? extends T> collection)
    {
        boolean ret = localList.addAll(location, collection);
        if (ret)
        {
            setChanged();
            notifyObservers(collection);
        }
        return ret;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection)
    {
        boolean ret = localList.addAll(collection);
        if (ret)
        {
            setChanged();
            notifyObservers();
        }
        return ret;
    }

    @Override
    public void clear()
    {
        localList.clear();
        setChanged();
        notifyObservers();
    }

    public void silentClear()
    {
        localList.clear();
    }

    @Override
    public boolean contains(Object object)
    {
        return localList.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return localList.containsAll(collection);
    }

    @Override
    public T get(int location)
    {
        return localList.get(location);
    }

    @Override
    public int indexOf(Object object)
    {
        return localList.indexOf(object);
    }

    @Override
    public boolean isEmpty()
    {
        return localList.isEmpty();
    }

    @Override
    public Iterator<T> iterator()
    {
        return localList.iterator();
    }

    @Override
    public int lastIndexOf(Object object)
    {
        return localList.lastIndexOf(object);
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return localList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int location)
    {
        return localList.listIterator(location);
    }

    @Override
    public T remove(int location)
    {
        T ret = localList.remove(location);
        setChanged();
        notifyObservers(ret);
        return ret;
    }

    @Override
    public boolean remove(Object object)
    {
        boolean ret = localList.remove(object);
        if (ret)
        {
            setChanged();
            notifyObservers();
        }
        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> collection)
    {
        boolean ret = localList.retainAll(collection);
        if (ret)
        {
            setChanged();
            notifyObservers();
        }
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> collection)
    {
        boolean ret = localList.retainAll(collection);
        if (ret)
        {
            setChanged();
            notifyObservers();
        }
        return ret;
    }

    @Override
    public T set(int location, T object)
    {
        T ret = localList.set(location, object);
        setChanged();
        notifyObservers(object);
        return ret;
    }

    @Override
    public int size()
    {
        return localList.size();
    }

    @Override
    public List<T> subList(int start, int end)
    {
        return localList.subList(start, end);
    }

    @Override
    public Object[] toArray()
    {
        return localList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] array)
    {
        return localList.toArray(array);
    }
}
