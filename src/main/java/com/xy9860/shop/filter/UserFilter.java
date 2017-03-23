package com.xy9860.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断session 是否有用户信息
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		if (req.getSession().getAttribute("forder")==null) {
			req.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		if (req.getSession().getAttribute("user")==null) {
			//这里显示被过滤器被拦截的路径
//			req.getContextPath()		项目名称
//			req.getRealPath("/")		本地路径
//			req.getServletPath()		项目地址(不包括项目名)
//			req.getQueryString()		参数地址
			String goURL=req.getServletPath();
			String parematr=req.getQueryString();
			if (parematr!=null) {
				goURL=goURL+"?"+parematr;
			}
			req.getSession().setAttribute("goURL", goURL);
			//非法请求,跳转登陆页面
			req.getSession().setAttribute("error", "非法请求,请先登陆");
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
			return;
		}{
			//如果有下一个过滤器则跳转,否则直接到目标页面
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
