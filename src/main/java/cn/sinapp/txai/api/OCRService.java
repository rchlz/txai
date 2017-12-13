package cn.sinapp.txai.api;

import java.io.UnsupportedEncodingException;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.sinapp.txai.domain.ApiResult;


@Service("ocrService")
public class OCRService extends BaseApiService {
	
	private static final String creditcardocrUrl = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_creditcardocr";
	
	public ApiResult<Gson> creditcardocr(String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("image", base64Image);
		
		ApiResult<Gson> apiResult = postApi(creditcardocrUrl, params);

		return apiResult;
	}
	

}
