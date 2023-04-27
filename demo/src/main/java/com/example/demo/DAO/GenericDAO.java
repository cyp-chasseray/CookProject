package com.example.demo.DAO;

import java.util.List;

public interface GenericDAO<T> {

    public T create(T object);
    public List<T> fetchAll();
    public T fetchOne(int id);
    public void update(int id, T object);
    public void delete(int id);
}
