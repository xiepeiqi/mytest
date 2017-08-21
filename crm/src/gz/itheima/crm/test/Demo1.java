package gz.itheima.crm.test;

import gz.itheima.crm.entity.User;
import gz.itheima.crm.service.UserService;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class Demo1 {
	@Resource(name="userService")
	private UserService userService;
	
	
	@Test
	public void test1(){
		User user = new User();
		user.setUser_code("m002");
		user.setUser_name("纯情小猪猪");
		user.setUser_password("123456");
		user.setUser_state("1");//在用
		
		userService.save(user);
		
	}

}
