package cn.cjli.webmall.service.sms;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * webmall cn.cjli.webmall.service.sms
 *
 * @author Lichaojie
 * @version 2019/5/22 17:06
 */
public class SMService {
	public static boolean sendSms(String phoneNumber, String code){
		JSONObject templateParamValue = new JSONObject();
		templateParamValue.put("code",code);

		DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIHxsxRWoWG5R2", "fFEsoheaapfh2csqc2ctBzBLfxR0fC");
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		//request.setProtocol(ProtocolType.HTTPS);
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("PhoneNumbers", phoneNumber);
		request.putQueryParameter("SignName", "WebMall商城");
		request.putQueryParameter("TemplateCode", "SMS_166080032");
		request.putQueryParameter("TemplateParam", templateParamValue.toJSONString());
		try {
			CommonResponse response = client.getCommonResponse(request);
			String result = response.getData();
			JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
			System.out.println(jsonObject.toJSONString());
			return "OK".equals(jsonObject.get("Code"));
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args){
		System.out.println(sendSms("18706811105","1214"));
	}
}
