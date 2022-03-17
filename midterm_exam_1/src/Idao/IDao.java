package Idao;

import java.util.List;

public interface IDao<T> {
    public T register(T t);

    public T search(Long license_id);

    public void delete(Long license_id);

    public List<T> searchAll();

}
