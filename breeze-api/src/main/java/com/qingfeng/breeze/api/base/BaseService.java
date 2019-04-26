package com.qingfeng.breeze.api.base;

import com.qingfeng.breeze.api.util.R;

import java.util.Map;

public interface BaseService<T> {

    R<T> deleteByPrimaryKey(Integer id);

    R<T> insert(T record);

    R<T> selectByPrimaryKey(Integer id);

    R<T> updateByPrimaryKey(T record);

    R<T> listByPage(Map<String, Object> map);
}
