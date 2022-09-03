package cn.kgc.service;

import cn.kgc.entities.Emp;

public interface EmpService {
    public void add(Emp emp);

    public Object getEmpById(Integer id);
}
