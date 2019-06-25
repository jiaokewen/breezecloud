package com.qingfeng.breeze.api.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author qingfeng
 * @description: 基础service实现
 * @date 2019/4/24 11:53
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T>{

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseMapper<T> mapper;

    @Override
    public R deleteByPrimaryKey(Integer id) {
        try {
            mapper.deleteByPrimaryKey(id);
            return R.success(ResponseConsts.SUCCESS,"删除成功");
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return R.fail(ResponseConsts.ERROR,"删除失败");
        }
    }

    @Override
    public R insert(T record) {
        try {
            mapper.insert(record);
            return R.success(ResponseConsts.SUCCESS,"新增成功");
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return R.fail(ResponseConsts.ERROR,"新增失败");
        }
    }

    @Override
    public R<T> selectByPrimaryKey(Integer id) {
        try {
            T record = mapper.selectByPrimaryKey(id);
            return R.success(ResponseConsts.SUCCESS,"获取数据成功",record);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return R.fail(ResponseConsts.ERROR,"获取数据失败");
        }
    }

    @Override
    public R updateByPrimaryKey(T record) {
        try {
            mapper.updateByPrimaryKey(record);
            return R.success(ResponseConsts.SUCCESS,"更新成功",record);
        }catch (Exception e) {
            return R.fail(ResponseConsts.ERROR,"更新失败");
        }
    }

    @Override
    public R<T> listByPage(Map<String, Object> map) {
        try {
            int page =(int)map.get("page");
            int rows = (int)map.get("rows");
            PageHelper.startPage(page,rows);
            List<T> list = mapper.listByPage(map);
            PageInfo<T> pageInfo = new PageInfo<>(list);
            return R.success(ResponseConsts.SUCCESS,"获取数据成功",
                    list,pageInfo.getTotal());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return R.fail(ResponseConsts.ERROR,"获取数据失败");
        }
    }
}
