package cn.sinapp.txai.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import cn.sinapp.meutils.util.HttpUtil;
import cn.sinapp.meutils.util.RandomUtil;
import cn.sinapp.txai.domain.ApiResult;
import cn.sinapp.txai.util.AuthSingature;


public class BaseApiService {
	
	protected static String AppID = "";
	
	protected static String AppKey = "";
	
	void init() throws IOException{
		Properties prop = new Properties();  
        
        prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));  
        
        AppID   = prop.getProperty("txai.appid");
        AppKey = prop.getProperty("txai.appkey");
              
	}
	
	/**
	 * 构建公共参数（不包含签名参数sign）
	 * @return 返回公共参数（不包含签名参数sign）
	 */
	protected Map<String,String> buildCommonParam(){
		
		Map<String,String> params = new HashMap<String,String>();
		
		String timeStamp = String.valueOf(System.currentTimeMillis()/1000);
		
		params.put("app_id", AppID);
		params.put("time_stamp", timeStamp);
		params.put("nonce_str", RandomUtil.generateRandomString(16));
		
		return params;
	}
	
	protected ApiResult postApi(String url, Map<String,String> params) throws UnsupportedEncodingException{
		
		if(StringUtils.isEmpty(url)){
			return null;
		}
		
		if(params == null || params.size() <= 3){
			return null;
		}else{
			//如果sign参数不存在，那就签名并且加上sign参数
			if(params.get("sign") == null){
				String sign = AuthSingature.sign(AppKey, params);
				params.put("sign", sign);
			}	
		}
		
		String jsonStr = HttpUtil.post(url, params);
		
		Gson gson = new Gson();
		
		return gson.fromJson(jsonStr, ApiResult.class);
		
	} 
	
	

}
