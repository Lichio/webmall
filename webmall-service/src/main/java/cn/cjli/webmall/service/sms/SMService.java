package cn.cjli.webmall.service.sms;

import cn.cjli.webmall.service.domain.SmscodeType;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * webmall cn.cjli.webmall.service.sms
 *
 * @author Lichaojie
 * @version 2019/5/22 17:06
 */
public class SMService {
	public static boolean sendSms(String phoneNumber, String code, String type){
		String templateCode = "";
		if (type != null && type.equals(SmscodeType.LOGIN.getValue())){
			templateCode = "SMS_166868089";
		}else if (type != null && type.equals(SmscodeType.REGISTER.getValue())){
			templateCode = "SMS_166080032";
		}else if (type != null && type.equals(SmscodeType.CHANGE_PASSWORD.getValue())){
			templateCode = "SMS_166779702";
		}

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
		request.putQueryParameter("TemplateCode", templateCode);
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

	public static String randomCode(){
		return RandomStringUtils.randomNumeric(6);
	}

	public static void main(String[] args){
		System.out.println(sendSms("18706811105","1214", "register"));
	}
}
