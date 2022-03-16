package Dao;

public interface IDao<T> {

    public T register(T t);

    public T search(int id);

    public void delete(int id);

    public T update(int i, Object o);


}
