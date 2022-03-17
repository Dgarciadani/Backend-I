package Dao;

import java.util.List;

public interface IDao<T> {

    public T register(T t);

    public T search(int id);

    public void delete(int id);

    public T update(int id, T t);

    public List<T> searchAll();


}
