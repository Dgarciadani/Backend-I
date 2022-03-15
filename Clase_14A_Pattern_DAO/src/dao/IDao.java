package dao;

import java.util.List;

public interface IDao<T> {

    public T register(T t);

    public void delete(Long id);

    public T search(Long id);

    public List<T> findAll();
}
