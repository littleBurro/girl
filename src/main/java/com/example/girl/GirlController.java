package com.example.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private  GirlRepository girlRepository;

    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/addGirl")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/getGirl")
    public Girl getGirl(@RequestParam("id") Integer id){
        return girlRepository.findOne(id);
    }
}
