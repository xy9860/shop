package com.xy9860.shop.action;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.TreeMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Category;

@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

	public String queryJoinAccount(){
		pageMap =new TreeMap<String, Object>();//用来存储分页的数据
		List<Category> categorys= categoryService.queryJoinAccount(model.getCtype(), page, rows);//根据关键字和分页参数查询相应的数据
		Long total=categoryService.getCount(model.getCtype());//根据关键字和分页参数查询相应的数据的条数
		pageMap.put("total", total);
		pageMap.put("rows", categorys);
		return "jsonMap";
	}
	
	public String deleteByIds(){
		
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());//返回为 true 
		
		return "stream";
	}
	
	public void save(){
		categoryService.save(model);
	}
	
	public void update(){
		categoryService.update(model);
	}
	/*private Category category;*/
//	private CategoryService categoryService;
	/*public void setCategory(Category category) {
		this.category = category;
	}*/
	
	/*private Integer id;
	private Integer id1;*/
	/*public void setId(Integer id) {
		this.id = id;
	}
	public void setId1(Integer id1) {
		this.id1 = id1;
	}*/
	/*public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}*/
	
	//public String query(){
		//System.out.println(ActionContext.getContext().getValueStack().getRoot());//显示值栈中的Root对象
		
//		 List<Category> categorys=categoryService.query();
		 //方案1 获得***map的方式取代内置对象,这样与jsp无依赖
		 /*ActionContext.getContext().getSession().put("categorys", categorys);//session
		 ActionContext.getContext().getApplication().put("categoryService.query();", categorys);//application
		 ActionContext.getContext().put("categorys", categorys);//request
*/		 
		 //方案2实现接口 implements SessionAware ,ApplicationAware,RequestAware
		 
		//return SUCCESS;
	//}
	/*public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		request.put("categorys", categoryService.query());
	}
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		application.put("categorys", categoryService.query());
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		session.put("categorys", categoryService.query());
	}
	public Category getModel() {
		Category category=new Category();
		return category;
	}*/
//	public String update(){
//		System.out.println(ActionContext.getContext().getValueStack().getRoot());//显示值栈中的Root对象
//		System.out.println("model"+model);//model是从父类使用反射获得的泛型对象
/*		System.out.println(id);
		System.out.println(id1);*/
		//return SUCCESS;
//	}
}
