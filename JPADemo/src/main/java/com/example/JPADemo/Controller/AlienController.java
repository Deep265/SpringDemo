package com.example.JPADemo.Controller;

import com.example.JPADemo.dao.AlienRepo;
import com.example.JPADemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public ModelAndView home(){
        System.out.println("Trigger HOme");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        return mv;
    }

    // Adding Data to DB
    /*
        We should not directly interact with a repository first we should add a service layer
        Since data coming to controller is from users and need to processed for security reasons
     */
    @RequestMapping("/addAlien")
    public ModelAndView addAlien(Alien alien){
        repo.save(alien);
        System.out.println("Entity Saved!!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        mv.addObject(alien);
        System.out.println(repo.findAnameSorted("Deep"));
        return mv;
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        Optional<Alien> alien = repo.findById(aid);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show.jsp");
        mv.addObject("alien",alien);
        return mv;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlien(Alien alien){
        Alien dbAlien = repo.findById(alien.getAid()).orElse(new Alien());
        ModelAndView mv = new ModelAndView();
        dbAlien.setAname(alien.getAname());
        repo.save(dbAlien);
        System.out.println("Updated!!");
        mv.setViewName("home.jsp");
        return mv;
    }

    @RequestMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid){
        repo.deleteById(aid);
        System.out.println("Deleted");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        return mv;
    }
}
