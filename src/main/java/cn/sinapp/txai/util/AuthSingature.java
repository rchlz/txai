package cn.sinapp.txai.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;

public class AuthSingature {
	
	public static String sign(String appKey, Map<String,String> params) throws UnsupportedEncodingException{
		
		// 对参数名进行字典排序
		String[] keyArray = params.keySet().toArray(new String[0]);
		Arrays.sort(keyArray);
		
		// 拼接有序的参数名-值串
		StringBuilder stringBuilder = new StringBuilder();
		for (String key : keyArray){
			
			String value = URLEncoder.encode(params.get(key));
			
		    stringBuilder.append(key).append("=").append(value).append("&");
		}
		stringBuilder.append("app_key=").append(appKey);
		String codes = stringBuilder.toString();

		String sign = DigestUtils.md5Hex(codes).toUpperCase();
		
		return sign;

	}
	
	public static String sign(String appKey, List<NameValuePair> nvps) throws UnsupportedEncodingException{
		
		Map<String,String> params = new HashMap<String,String>();
		
		if(nvps != null){
			for(NameValuePair nvp : nvps){
				params.put(nvp.getName(), nvp.getValue());
			}
			
		}
		
		return sign(appKey,params);

	}

}
