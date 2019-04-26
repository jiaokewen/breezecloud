package com.qingfeng.breeze.api.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(T record);

    List<T> listByPage(Map<String, Object> map);
}
