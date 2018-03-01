import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.mapper.UserMapper;
import com.ycat.pojo.User;

public class TestItem {
	@Autowired
	UserMapper userMapper;

	@Test
	public void getItemBy() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		UserMapper mapper = context.getBean(UserMapper.class);

		for (int i = 0; i < 25; i++) {
			User user = new User();
			user.setName("hehe"+i);
			user.setPassword("1231");
			user.setNickname("jake"+i);
			mapper.addUser(user);

		}
	}

	@Test
	public void getItemList() {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		UserMapper mapper = context.getBean(UserMapper.class);

		PageHelper.startPage(1, 10);
		List<User> list = mapper.getUserList();

		for (User item : list) {
			System.out.println(item.getName());
		}

		PageInfo<User> pageInfo = new PageInfo<User>(list);

		int total = (int) pageInfo.getTotal();

		System.out.println("总数量:" + total);

	}

}
