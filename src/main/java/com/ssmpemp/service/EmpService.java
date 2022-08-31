package com.ssmpemp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmpemp.pojo.Emp;
import com.ssmpemp.pojo.MyPage;

import java.util.List;

public interface EmpService {
    public List<Emp> getAll();
    public Emp getOne(Integer empno);
    public int update(Emp emp);
    public int save(Emp emp);
    public int delete(Integer empno);
    public IPage<Emp> getAllByPage(Integer pageno);
    public MyPage<Emp> getAllByMyPage(Integer pageno, Integer pagesize);


}
