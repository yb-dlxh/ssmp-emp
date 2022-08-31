package com.ssmpemp.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dept")
public class Dept {
    @TableId("deptno")
    private Integer deptno;
    private String dname;
    private String loc;
}
