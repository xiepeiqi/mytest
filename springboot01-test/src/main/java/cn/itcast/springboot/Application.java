package cn.itcast.springboot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot的启动类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年8月18日 上午9:09:29
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages={"cn.itcast.springboot"}) // 指明该类为启动类
public class Application {

	public static void main(String[] args) {
		/** 运行SpringBoot的应用  (第一种方式)*/
		//SpringApplication.run(Application.class, args);
		
		/** 运行SpringBoot的应用，去掉Banner横幅 (第二种方式)*/
		SpringApplication springApplication = new SpringApplication(Application.class);
		/** 设置Banner横幅的模式为关闭 */
		springApplication.setBannerMode(Mode.OFF);
		/** 运行 */
		springApplication.run(args);
	}
}