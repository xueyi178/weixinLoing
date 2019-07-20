package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.service.WeiXinService;

/**
 * 1. 微信登录的controller
 * 项目名称：springboot-wexin 
 * 类名称：WeiXinLogin
 * 开发者：Lenovo
 * 开发时间：2019年7月20日上午10:53:48
 */
@Controller
public class WeiXinLogin {
	
	@Autowired
	private WeiXinService weiXinService;
	

	/**
	 * 1.请求index页面
	 * @return
	 */
	@RequestMapping(value= "/")
	public ModelAndView root() {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		view.addObject("title", "扫码登录测试");
		return view;
	}
	
	/**
	 * 2.重定到微信二维码登录地址
	 * @return
	 */
	@RequestMapping("/weixinLogin")
	public String weixinLogin() {
		return "redirect:"+weiXinService.getLoginUrl();
	}
}
