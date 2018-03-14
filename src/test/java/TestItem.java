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

		for (int i = 0; i < 4; i++) {
			User user = new User();
			user.setName("100" + i);
			user.setPassword("123");
			user.setNickname("二虎" + i);
			user.setUser_id("0001"+i);
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
			jokeBean.setJoke_user_id("0000");
			jokeBean.setTitle("登岳阳楼");
			jokeBean.setContent("昔闻洞庭水，今上岳阳楼。\r\n" + 
					"吴楚东南坼，乾坤日夜浮。\r\n" + 
					"亲朋无一字，老病有孤舟。\r\n" + 
					"戎马关山北，凭轩涕泗流。");
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
