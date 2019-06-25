package com.qingfeng.breeze.api.base;

import com.qingfeng.breeze.api.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author qingfeng
 * @description: 基础controller
 * @date 2019/4/24 11:52
 */
@RestController
public class BaseController<T> {

    @Autowired
    private BaseService<T> service;

    @GetMapping(value = "{id}")
    public R<T> selectById(@PathVariable("id") Integer id) {
        return service.selectByPrimaryKey(id);
    }

    @DeleteMapping(value = "{id}")
    public R<T> deleteById(@PathVariable("id") Integer id) {
        return service.deleteByPrimaryKey(id);
    }

    @PostMapping()
    public R<T> insert(@RequestBody T record) {
        return service.insert(record);
    }

    @PutMapping()
    public R<T> update(@RequestBody T record) {
        return service.updateByPrimaryKey(record);
    }

    @PostMapping(value = "/list")
    public R<T> listByPage (@RequestBody Map<String, Object> map){
        return service.listByPage(map);
    }
}
