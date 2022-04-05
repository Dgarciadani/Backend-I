package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository;

import java.util.List;

public interface Idao<T> {

    public T register(T t);

    public T search(Integer id);

    public T update(Integer id, T t);

    public void delete(Integer id);

    public List<T> searchAll();

}
