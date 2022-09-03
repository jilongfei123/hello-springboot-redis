package cn.kgc.controller;

import cn.kgc.entities.Emp;
import cn.kgc.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class EmpController {
    @Resource
    private EmpService empService;

    @PostMapping("/emp/")
    public String add(Emp emp){
        empService.add(emp);
        return "success";
    }

    @GetMapping("/emp/{id}")
    public Object getEmpById(@PathVariable("id") Integer id){
        ExecutorService es = Executors.newFixedThreadPool(200);
        for(int i=0;i<500;i++){
            es.submit(new Runnable() {
                @Override
                public void run() {
                    empService.getEmpById(id);
                }
            });
        }
        return empService.getEmpById(id);
    }
}
