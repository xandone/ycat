import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.config.Config;
import com.ycat.mapper.ImageMapper;
import com.ycat.mapper.JokeMapper;
import com.ycat.mapper.UserMapper;
import com.ycat.pojo.CommentBean;
import com.ycat.pojo.HeadArticleBean;
import com.ycat.pojo.ImageBean;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;
import com.ycat.pojo.User;
import com.ycat.utils.FtpClientUtils;
import com.ycat.utils.IDUtils;

public class TestItem {

	@Test
	public void addUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		UserMapper mapper = context.getBean(UserMapper.class);

		User user = new User();
		user.setName("100");
		user.setPassword("123");
		user.setNickname("二虎");
		user.setUser_id("0001");
		mapper.addUser(user);

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
	public void changeUserIcon() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		UserMapper mapper = context.getBean(UserMapper.class);

		Map<String, String> map = new HashMap();
		map.put("user_icon",
				"https://upload-images.jianshu.io/upload_images/2518499-87cb6cb05233b36d.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
		map.put("user_id", "152138655864350");

		mapper.changeUserIcon(map);
	}

	@Test
	public void addJoke() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		JokeMapper mapper = context.getBean(JokeMapper.class);

		JokeBean jokeBean = new JokeBean();
		jokeBean.setJoke_id("152138655864341");
		jokeBean.setJoke_user_id("152146249752110");
		jokeBean.setTitle("兵车行");
		jokeBean.setContent("车辚辚，马萧萧，行人弓箭各在腰。\n\n" + "爷娘妻子走相送，尘埃不见咸阳桥。\n" + "\n" + "牵衣顿足拦道哭，哭声直上干云霄。\n" + "\n"
				+ "道傍过者问行人，行人但云点行频。\n" + "\n" + "或从十五北防河，便至四十西营田。\n" + "\n" + "去时里正与裹头，归来头白还戍边。\n" + "\n"
				+ "边庭流血成海水，武皇开边意未已。\n" + "\n" + "君不闻汉家山东二百州，千村万落生荆杞。\n" + "\n" + "纵有健妇把锄犁，禾生陇亩无东西。\n" + "\n"
				+ "况复秦兵耐苦战，被驱不异犬与鸡。\n" + "\n" + "长者虽有问，役夫敢申恨？\n" + "\n" + "且如今年冬，未休关西卒。\n" + "\n" + "县官急索租，租税从何出？\n"
				+ "\n" + "信知生男恶，反是生女好。\n" + "\n" + "生女犹得嫁比邻，生男埋没随百草。\n" + "\n" + "君不见，青海头，古来白骨无人收。\n" + "\n"
				+ "新鬼烦冤旧鬼哭，天阴雨湿声啾啾！");
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

	@Test
	public void selectJokeLikeById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JokeMapper mapper = context.getBean(JokeMapper.class);

		List<JokeLikeBean> list = mapper.selectJokeLikeById("1113");

		for (JokeLikeBean a : list) {
			System.out.println(a.getJoke_user_id());
		}
	}

	@Test
	public void thumbsJoke() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JokeMapper mapper = context.getBean(JokeMapper.class);

		JokeLikeBean jokeLikeBean = new JokeLikeBean();
		jokeLikeBean.setJoke_id("11111");
		jokeLikeBean.setJoke_user_id("23444");

		mapper.thumbsJoke(jokeLikeBean);
	}

	@Test
	public void addComment() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JokeMapper mapper = context.getBean(JokeMapper.class);

		CommentBean commentBean = new CommentBean();
		commentBean.setComment_id(IDUtils.RandomId());
		commentBean.setJoke_id("152112021530410");
		commentBean.setComment_user_id("152112021530406");
		commentBean.setComment_details("写得好");
		commentBean.setComment_date(new Date());

		mapper.addComment(commentBean);
	}

	@Test
	public void addPic() throws FileNotFoundException {
		
		FileInputStream inputStream = new FileInputStream(new File("D:\\1.jpg"));
		String path = "www/images/";
//		String path = "home/ftpuser/www/images/";//使用这个路径，上传的图片停留在home/ftpuser，changeWorkingDirectory永远返回false
		String filename = "bcd.jpg"; // 获得原始的文件名
		System.out.println("------------上传文件名-----------" + filename);
		FtpClientUtils a = new FtpClientUtils();
		FTPClient ftp = a.getConnectionFTP(Config.FTP_IP, 21, "ftpuser", "@@22xiao");
		a.uploadFile(ftp, path, filename, inputStream);
		a.closeFTP(ftp);
		
	}
	
	@Test
	public void addImageList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		ImageMapper mapper = context.getBean(ImageMapper.class);
		
		ImageBean imageBean = new ImageBean();
		imageBean.setImgId(IDUtils.RandomId());
		imageBean.setImgUrl("www.baidu,ccc");
		imageBean.setUserId("1234335");
		imageBean.setPageViews("0");
		imageBean.setUpTime(new Date());
		mapper.addImage(imageBean);
	}

	
	@Test
	public void addArticleList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JokeMapper mapper = context.getBean(JokeMapper.class);
		
		HeadArticleBean head = new HeadArticleBean();
		head.setUserId("1");
		head.setArticelId("2");
		head.setArticleUrl("dsfdf");
		head.setImgUrl("1234335");
		head.setTitle("标题呵呵");
		head.setPageViews(12);
		head.setUpTime(new Date());
		mapper.addAticle(head);
	}


}
