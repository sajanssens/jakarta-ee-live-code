package com.infosupport.repositories;

import java.util.List;

public interface Repo<T> {
    List<T> findAll();

    T add(T aangifte);

    void remove(int id);

    T update(T aangifte);

    T get(int id);
}
