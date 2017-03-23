package com.xy9860.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xy9860.shop.model.FileImage;
import com.xy9860.shop.service.AccountService;
import com.xy9860.shop.service.CategoryService;
import com.xy9860.shop.service.ForderService;
import com.xy9860.shop.service.ProductService;
import com.xy9860.shop.service.SorderService;
import com.xy9860.shop.service.UserService;
import com.xy9860.shop.util.FileUpload;
/**
 * Struts 执行流程:
 * 先创建Action 再调用拦截器,拦截器访问成功再 调用Action的方法
 * 
 * 项目启动的时候Struts过滤器,已经把相应的内置对象,还有对应的Map存入了 ActionContext和值栈中 在过滤器StrutsPrepareAndExecuteFilter中实现
 * 如果实现了****Aware接口,就可以从ActionContext获取相应的Map进行传入  实现的拦截器为:servletConfig
 * 
 * 
 * servletConfig 通过约定好的方法 取出 对应的*** 调用Set方法
 * 
 * ModelDriven 接口 实现getModel方法后 会自己把返回值压进栈顶 
 * */

@Controller
@Scope("prototype")//设置为多例模式
public class BaseAction<T> extends ActionSupport implements SessionAware ,ApplicationAware,RequestAware,ModelDriven<T>  {

	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;//直接放在这里因为service是单列的 系统启动时已经加载了 不损耗资源  而且方便调用
	@Resource
	protected ProductService productService;
	@Resource
	protected FileUpload fileUpload;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected ForderService forderService;
	@Resource
	protected UserService userService;

	protected Class clazz;
	protected T model;
	
	protected FileImage fileImage;

	protected Integer page;//这两个是分页所需要的 两个值
	protected Integer rows;
	
	protected Map<String, Object> pageMap=null;//分页数据存储的 map
	protected List<T> jsonList=null;
	
	protected String ids;//获取的需要操作的多个id
	protected InputStream inputStream;//设置 返回为流的方式

	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;

	/*	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}*///注解替代这个作用

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	public T getModel() {
		// TODO Auto-generated method stub
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();//获得当前调用这个构造方法的父类信息(包括泛型)
		clazz=(Class)type.getActualTypeArguments()[0];//获取泛型类的信息 0表示第一个参数
		try {
			model=(T) clazz.newInstance();
		} catch (Exception e) {
			new RuntimeException();
		} 
		/*Map<String, Object> temp=ActionContext.getContext().getValueStack().getContext();
		Iterator iter = temp.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println(entry.getKey() +"----"+entry.getValue());
		}*/
		return model;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public List<T> getJsonList() {
		return jsonList;
	}
	public FileImage getFileImage() {
		return fileImage;
	}
	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

}
