package shop;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.service.CategoryService;
import com.xy9860.shop.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class SSH_Test {

	/*@Resource
	private Date data;
	
	@Resource
	private CategoryService categoryService;
	@Test
	public void testSpingIoc() {
		System.out.println(data);
	}
	@Test
	public void testHibernate(){
		CategoryServiceImpl s=new CategoryServiceImpl();
		Category c=new Category();
		c.setType("3333");
		c.setHot(true);
//		c.setId(4);
		s.save(c);
	}

	@Test
	public void testHibernateAndSpring(){
		Category category=new Category();
		category.setId(1);
		category.setHot(false);
		category.setType("你ewq二大爷");
		categoryService.update(category);
	}*/
}
