package com.springboot.service;
/**
 * 1. 微信登录的业务逻辑层接口
 * 项目名称：springboot-wexin 
 * 类名称：WeiXinService
 * 开发者：Lenovo
 * 开发时间：2019年7月20日上午11:07:16
 */
public interface WeiXinService {

	/**
	 * 1.微信扫码登录地址,生成二维码信息
	 * @return
	 */
	public String getLoginUrl();
}
