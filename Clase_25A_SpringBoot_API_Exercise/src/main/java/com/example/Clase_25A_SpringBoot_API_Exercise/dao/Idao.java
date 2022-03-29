package com.example.Clase_25A_SpringBoot_API_Exercise.dao;

import java.util.List;

public interface Idao<T> {

    public T register(T t);

    public void delete(int id);

    public T search(int id);

    public T update(int id, T t);

    public List<T> searchAll();

}
