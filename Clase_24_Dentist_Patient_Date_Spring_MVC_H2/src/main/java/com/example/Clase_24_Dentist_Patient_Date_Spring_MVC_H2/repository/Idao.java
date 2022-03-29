package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository;

import java.util.List;

public interface Idao<T> {

    public T register(T t);

    public T search(int id);

    public T update(int id, T t);

    public void delete(int id);

    public List<T> searchAll();

}
