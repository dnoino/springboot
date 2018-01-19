package com.yc.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.springboot.bean.User;

@Controller
//开启自动配置，然后通过SpringApplication.run(UserController.class);
//运行这个控制器；这种方式只运行一个控制器比较方便；
@EnableAutoConfiguration
public class HelloController {
	@RequestMapping(value="/get/{id}/{name}")
	@ResponseBody
	public User getUser(@PathVariable int id,@PathVariable String name){
		User user=new User();
		user.setId(id);
		user.setName(name);
		return user;
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	String hello() {
		System.out.println("进来了...");
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);  
	}
	
	//运行方式：在项目右键->Run As->Java Application->选择这个类即可
	//访问方式 http://127.0.0.1:8080/hello
}
