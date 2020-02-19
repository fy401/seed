package net.fengyu.controller;

import net.fengyu.service.DemoService;
import net.fengyu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;



@RestController
@RequestMapping("/demo")

public class DemoController {

    @Autowired
    private DemoService demoService;

//    @Value("${spring.profiles.active}")
//    private String profile;
    /**
     * 最简单的demo，验证浏览器能够访问到系统
     */
    @GetMapping("/helloworld")
    public Map<String, Object> helloWorld() {
        return Collections.singletonMap("message", "Hello World");
    }


    /**
     * 获得当前系统的打包部署环境
     * @return
     */
    @RequestMapping("/currentProfile")
    @ResponseBody
    public String currentProfile() {
        return demoService.getCurrentProfile();
    }


    @PostMapping("/visit")
    public String visit(@RequestBody User user) {

        if(demoService.visit(user)) {
            return "OK";
        } else {
            return "WRONG";
        }
    }

    @RequestMapping("/insertUser")
    public boolean insertUser(@RequestParam(value = "userid", required = true) int userid,
                              @RequestParam(value = "username", required = true) String username,
                              @RequestParam(value = "city", required = true) String city,
                              @RequestParam(value = "gender", required = true) int gender) {

        //验证参数？
        return demoService.insertUser(userid,username,city,gender);
    }
}
