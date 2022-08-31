package com.ssmpemp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmpemp.pojo.Emp;
import com.ssmpemp.pojo.MyPage;
import com.ssmpemp.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmpEmpApplicationTests {
	@Autowired
	private EmpService es;
	public void test(){

	}
	@Test
	void contextLoads() {
		System.out.println(es.getAll());
		System.out.println("---------------------------");
		Emp e = es.getOne(7698);
		System.out.println(e);
		System.out.println("---------------------------");
		e.setEmpno(2222);
		System.out.println("save:" + es.save(e));
		System.out.println("---------------------------");
		e.setSal(9999);
		System.out.println("update:" + es.update(e));
	}

	@Test
	void contextLoads2() {
		IPage<Emp> info = es.getAllByPage(2);
		info.getRecords().forEach(System.out::println);
	}

	@Test
	void contextLoads3() {
		MyPage<Emp> page = es.getAllByMyPage(3,5);
		System.out.println(page);
	}

}
