package com.example.SqlConnection.controller;

import com.example.SqlConnection.dao.EmpRepo;
import com.example.SqlConnection.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {
    @Autowired
    EmpRepo repo;

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }
    @PostMapping("/emp")
    public Emp addEmp(@RequestBody Emp emp)
    {
        repo.save(emp);
        return emp;
    }

    @PutMapping("/emp")
    public Emp SaveOrUpdateEmp(@RequestBody Emp emp)
    {
        repo.save(emp);
        return emp;
    }

    @DeleteMapping("/emp/{eid}")
    public String deleteEmp(@PathVariable int eid)
    {
        Emp e = repo.getOne(eid);
        repo.delete(e);
        return "deleted";
    }

//    @GetMapping("/getEmp")
//    public ModelAndView getEmp(@RequestParam int eid) {
//        ModelAndView mv = new ModelAndView("showEmp");
//        Emp emp = repo.findById(eid).orElse(new Emp());
//        mv.addObject(emp);
//        return mv;
//    }

    @GetMapping("/emps")
    public List<Emp> getEmps()
    {
        return repo.findAll();
    }

    @RequestMapping("/emp/{eid}")
    public Optional<Emp> getEmp(@PathVariable("eid")int eid)
    {
        return repo.findById(eid);
    }
}
