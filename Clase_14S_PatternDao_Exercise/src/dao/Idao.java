package dao;

import java.util.List;

public interface Idao<T> {

    public T register(T t);

    public void delete(long id);

    public T search(long id);

    public List<T> searchAll();

}
