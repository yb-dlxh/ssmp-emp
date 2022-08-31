package com.ssmpemp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmpemp.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    public List<Emp> getAllEmps();
    public List<Emp> getAllEmpsByPage(@Param("index") int startIndex, @Param("count") int count);
}
