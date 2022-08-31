package com.ssmpemp.service.impl;

import com.ssmpemp.mapper.DeptMapper;
import com.ssmpemp.pojo.Dept;
import com.ssmpemp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper dm;


    @Override
    public List<Dept> getall() {
        return dm.selectList(null);
    }
}
