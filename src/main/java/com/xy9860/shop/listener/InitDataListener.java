package com.xy9860.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.service.CategoryService;
import com.xy9860.shop.service.ProductService;
/**
 * 项目启动时候的初始化
 * 
 * 监听器是v层的 不能交给spring 管理   实例化不能失败
 * */
public class InitDataListener implements ServletContextListener {

	private ProductService productService=null;
	private ApplicationContext context =null;
	private CategoryService categoryService=null;
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		//获取业务逻辑类查询商品
		//1.想获取业务逻辑类 不能靠注入  假设使用单元测试的方法注入  可以取得 但是spring中注入多次
		/*ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-*.xml");
		productService=(ProductService)context.getBean("productService");
		System.out.println(productService);*/
		//2.项目在启动的时候把spring配置文件通过xml通过监听器中,存在servletcontxt 只需要获取就可以了
		//WebApplicationContextUtils
		//直接到servletContext获取
		/*ApplicationContext context=(ApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		productService=(ProductService)context.getBean("productService");
		System.out.println(productService);*/
		//3.通过工具类添加
		context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		//System.out.println(sce.getServletContext().getInitParameter("contextConfigLocation"));
		productService=(ProductService)context.getBean("productService");
		categoryService=(CategoryService)context.getBean("categoryService");
		List<List<Product>> bigList=new ArrayList<List<Product>>();//存放所有商品的大集合
		//System.out.println(productService);
		for (Category category : categoryService.queryByChot(true)) {
			bigList.add(productService.queryByCid(category.getCid()));
		}
		sce.getServletContext().setAttribute("bigList", bigList);//放到Appliction中便于查询
	}

}
