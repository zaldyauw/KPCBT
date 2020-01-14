package com.cbt.dao;

import java.util.List;


public interface DaoService<T> {

    int addData(T object);

    int deleteData(T object);

    List<T> showAllData();

    int updateData(T object);
}
