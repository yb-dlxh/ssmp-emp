package com.ssmpemp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmpemp.mapper.DeptMapper;
import com.ssmpemp.mapper.EmpMapper;
import com.ssmpemp.pojo.Emp;
import com.ssmpemp.pojo.MyPage;
import com.ssmpemp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper em;
    @Autowired
    private DeptMapper dm;
    @Override
    public List<Emp> getAll() {
        return em.getAllEmps();
    }
    @Override
    public Emp getOne(Integer empno) {
        return em.selectById(empno);
    }
    @Override
    public int update(Emp emp) {
        return em.updateById(emp);
    }
    @Override
    public int save(Emp emp) {
        if(em.selectById(emp.getEmpno()) == null) {
            return em.insert(emp);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(Integer empno) {
        return em.deleteById(empno);
    }

    @Override
    public IPage<Emp> getAllByPage(Integer pageno) {
        int no = pageno != null ? pageno : 1;// 页面判断
        IPage<Emp> iPage = new Page<>(no, 5);
        IPage<Emp> info = em.selectPage(iPage, null);
        List<Emp> list = info.getRecords();
        for(Emp e : list){
            e.setDept(dm.selectById(e.getDeptno()));
        }
        return info;

    }

    @Override
    public MyPage<Emp> getAllByMyPage(Integer pageno, Integer pagesize) {
        int pno = pageno == null ? 1 : pageno;
        int psize = pagesize == null ? 5 : pagesize;
        MyPage<Emp> mypage = new MyPage<>();
        mypage.setCurrent(pno);
        mypage.setSize(psize);
        mypage.setTotal(em.selectCount(null));
        List<Emp> list = em.getAllEmpsByPage((pno-1)*psize , psize);
        mypage.setList(list);
        return mypage;
    }
}
