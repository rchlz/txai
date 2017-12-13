package cn.sinapp.txai.api;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.sinapp.txai.domain.ApiResult;


@Service("imageEffectService")
public class ImageEffectService extends BaseApiService {
	
	private static final String facemergeUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facemerge";
	
	private static final String facestickerUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facesticker";
	
	private static final String facedecorationUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facedecoration";
	
	private static final String imgfilterUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_imgfilter";
	
	private static final String facecosmeticUrl = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facecosmetic";
	
	
	
	public ApiResult<Map> facemerge(int modelId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("model", String.valueOf(modelId));
		params.put("image", base64Image);
		
		ApiResult<Map> apiResult = postApi(facemergeUrl, params);
		
		
		return apiResult;
		
	}
	
	
	public ApiResult<Map> facesticker(int stickerId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("sticker", String.valueOf(stickerId));
		params.put("image", base64Image);
		
		ApiResult<Map> apiResult = postApi(facestickerUrl, params);
		
		return apiResult;
		
	}
	
	public ApiResult<Map> facedecoration(int decorationId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("decoration", String.valueOf(decorationId));
		params.put("image", base64Image);
		
		ApiResult<Map> apiResult = postApi(facedecorationUrl, params);
		
		return apiResult;
		
	}
	
	public ApiResult<Map> imgfilter(int filterId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("filter", String.valueOf(filterId));
		params.put("image", base64Image);
		
		ApiResult<Map> apiResult = postApi(imgfilterUrl, params);
		
		return apiResult;
		
	}
	
	public ApiResult<Map> facecosmetic(int cosmeticId, String base64Image) throws UnsupportedEncodingException{
		
		Map<String,String> params = buildCommonParam();
		
		params.put("filter", String.valueOf(cosmeticId));
		params.put("image", base64Image);
		
		ApiResult<Map> apiResult = postApi(facecosmeticUrl, params);
		
		return apiResult;
		
	}
	

}
