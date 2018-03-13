import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.mapper.JokeMapper;
import com.ycat.mapper.UserMapper;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.User;

public class TestItem {

	@Test
	public void getItemBy() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		UserMapper mapper = context.getBean(UserMapper.class);

		for (int i = 0; i < 15; i++) {
			User user = new User();
			user.setName("1" + i);
			user.setPassword("123");
			user.setNickname("二虎" + i);
			user.setUser_id("0001");
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

	@Test
	public void deleteUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		UserMapper mapper = context.getBean(UserMapper.class);

		mapper.deleteUser("haha");
	}

	@Test
	public void addJoke() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		JokeMapper mapper = context.getBean(JokeMapper.class);

			JokeBean jokeBean = new JokeBean();
			jokeBean.setJoke_id("100");
			jokeBean.setJoke_user_id("1000");
			jokeBean.setTitle("吵架");
			jokeBean.setContent("朋友和媳妇吵架了，想买条项链，给她个惊喜求她原谅，但是他又不知道媳妇带多大的，于是就半夜起来用绳子量一下，没想到她醒了……");
			jokeBean.setPost_time(new Date());
			mapper.addJoke(jokeBean);
		
	}

	@Test
	public void getJokeList() {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		JokeMapper mapper = context.getBean(JokeMapper.class);

		PageHelper.startPage(1, 10);
		List<JokeBean> list = mapper.getJokeList();

		for (JokeBean item : list) {
			System.out.println(item.getTitle());
		}

		PageInfo<JokeBean> pageInfo = new PageInfo<JokeBean>(list);

		int total = (int) pageInfo.getTotal();

		System.out.println("总数量:" + total);

	}

}
