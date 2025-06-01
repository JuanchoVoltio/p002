package com.heading.cospawnautgo.global.service;

import java.util.List;

public interface BasicCrudService<E, ID> {
    E create(E entity);
    E read(ID id);
    List<E> readAll();
    E update(E entity);
    boolean delete(E entity);

}
