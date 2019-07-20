package com.springboot.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.springboot.constanst.Constanst;
import com.springboot.entity.HttpParame;
import com.springboot.service.WeiXinService;
import com.springboot.utils.AesUtil;
import com.springboot.utils.DateUtil;
import com.springboot.utils.PropertiesUtil;
/**
 * 1.微信登录的业务逻辑层实现类
 * 项目名称：springboot-wexin 
 * 类名称：WeiXinServiceImpl
 * 开发者：Lenovo
 * 开发时间：2019年7月20日上午11:08:25
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {

	/**
	 * 1.微信扫码登录地址,生成二维码信息
	 * @return
	 */
	@Override
	public String getLoginUrl() {
		String content = Constanst.PWD_MD5+ DateUtil.getYYYYMMdd();
		
		//进行数据加密
		byte[] encrypt = AesUtil.encrypt(content, AesUtil.PASSWORD_SECRET_KEY, 16);
		
		//将二进制转换成16进制
		String parseByte2HexStr = AesUtil.parseByte2HexStr(encrypt);
		
		//网页授权回调地址
		String url = HttpParame.AUTHORIZATION_URL;

		url = url.replaceAll("APPID", PropertiesUtil.getValue(HttpParame.APPID));
		try {
			url = url.replaceAll("REDIRECT_URI", URLEncoder.encode(
					PropertiesUtil.getValue(HttpParame.REDIRECT_URI),"UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		url = url.replaceAll("SCOPE", "snsapi_login");
		
		System.out.println("微信的请求地址====[{}]"+url);
		
		//加密state进行验证 回调地址当天有效 防止恶意攻击
		url = url.replace("STATE", parseByte2HexStr);	
		
		//返回url
		return url;
	}
}
