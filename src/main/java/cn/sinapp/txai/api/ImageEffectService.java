package cn.sinapp.txai.api;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.sinapp.txai.domain.ApiResult;


@Service("imageEffectService")
public class ImageEffectService extends BaseApiService {
	
	private static final String facemergeUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facemerge";
	
	private static final String facestickerUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facesticker";
	
	private static final String facedecorationUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facedecoration";
	
	private static final String imgfilterUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_imgfilter";
	
	private static final String facecosmeticUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facecosmetic";
	
	
	
	public ApiResult<Gson> facemerge(int modelId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("model", String.valueOf(modelId));
		params.put("image", base64Image);
		
		ApiResult<Gson> apiResult = postApi(facemergeUrl, params);
		
		
		return apiResult;
		
	}
	
	
	public ApiResult<Gson> facesticker(int stickerId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("sticker", String.valueOf(stickerId));
		params.put("image", base64Image);
		
		ApiResult<Gson> apiResult = postApi(facestickerUrl, params);
		
		return apiResult;
		
	}
	
	public ApiResult<Gson> facedecoration(int decorationId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("decoration", String.valueOf(decorationId));
		params.put("image", base64Image);
		
		ApiResult<Gson> apiResult = postApi(facedecorationUrl, params);
		
		return apiResult;
		
	}
	
	public ApiResult<Gson> imgfilter(int filterId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("filter", String.valueOf(filterId));
		params.put("image", base64Image);
		
		ApiResult<Gson> apiResult = postApi(imgfilterUrl, params);
		
		return apiResult;
		
	}
	
	public ApiResult<Gson> facecosmetic(int cosmeticId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("filter", String.valueOf(cosmeticId));
		params.put("image", base64Image);
		
		ApiResult<Gson> apiResult = postApi(facecosmeticUrl, params);
		
		return apiResult;
		
	}
	

}
