package cn.sinapp.txai.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.sinapp.meutils.util.HttpUtil;
import cn.sinapp.txai.domain.WeixinSession;


@Service("weixinAuthService")
public class WeixinAuthService {
	
	protected static String AppID = "";
	protected static String AppKey = "";
	
	private static String jscode2sessionUrl = "https://api.weixin.qq.com/sns/jscode2session?";
	
	void init() throws IOException{
		Properties prop = new Properties();  
        
        prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));  
        
        AppID   = prop.getProperty("weixin.appid");
        AppKey = prop.getProperty("weixin.appkey");
              
	}
	
	public WeixinSession jscode2session(String code){
		
		Map<String,String> params = new HashMap<String,String>();
		
		params.put("appid", AppID);
		params.put("secret", AppKey);
		params.put("js_code", code);
		params.put("grant_type", "authorization_code");
		
		StringBuilder sb = new StringBuilder(jscode2sessionUrl);
		for(Iterator it = params.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			String value = params.get(key);
			sb.append(key).append("=").append(value).append("&");
			
		}
		
		String url = sb.toString();
		url = url.substring(0, url.length() - 1);
		String httpResult = HttpUtil.get(url);

		Gson gson = new Gson();
		WeixinSession weixinSession = gson.fromJson(httpResult, WeixinSession.class);
		return weixinSession;

	}
	

}
