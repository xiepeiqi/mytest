package cn.itcast.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.springboot.service.UserService;


/**
 * HelloController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年8月18日 上午9:26:26
 * @version 1.0
 */
@Controller
public class HelloController {
	
	@Autowired
	private UserService userService;
	/** 定义Environment封装application.properties */
	@Autowired
	private Environment environment; 
	/** 注入application.properties属性文件中的属性 */
	@Value("${name}")
	private String name;
	@Value("${url}")
	private String url;
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(){
		userService.save();
		System.out.println(environment.getProperty("name"));
		System.out.println(environment.getProperty("url"));
		
		System.out.println(name + "===" + url);
		return "Hello World";
	}
	
	/** 请求静态的html页面，注意请求地址/user1不能与/user.html同名 */
	@GetMapping("/user")
	public String user(){
		
		return "/user/user.html";
	}
	
	
}
