package th.ac.kmitl.rspg.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectUserResponse;

public class UserService {

    private final static String HTTP = "http://";
//    Old IP
//    private final static String FullURL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
//    Update New IP @23/09/2019
    private final static String FullURL = "http://161.246.34.253/rspg_service/WebService.asmx?WSDL";
    private final static String URL = "/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION_LOGIN_USER_SERVICE = "http://tempuri.org/LoginUser";m
    private final static String SOAP_ACTION_GET_DOMAIN_URL_SERVICE = "http://tempuri.org/GetDomainURL";
    private final static String METHOD_NAME_LOGIN_USER_SERVICE = "LoginUser";
    private final static String SOAP_ACTION_SELECT_USER_SERVICE = "http://tempuri.org/SelectUser";
    private final static String METHOD_NAME_SELECT_USER_SERVICE = "SelectUser";
    private final static String PARAMETER_USERNAME = "username";
    private final static String PARAMETER_PASSWORD = "password";
    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_ID = "id";

    public static String getUrl(){
        String result = "";
        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.GET_DOMAIN_URL);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;

        HttpTransportSE httpTransportSE = new HttpTransportSE(FullURL);

        try {
            httpTransportSE.call(SOAP_ACTION_GET_DOMAIN_URL_SERVICE, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static SelectUserResponse login(String url,String username, String password){
        String result = "";
        LoginUserResponse userInfo = null;

        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.LOGIN_USER);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_USERNAME);
        propertyInfo1.setValue(username);
        propertyInfo1.setType(String.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_PASSWORD);
        propertyInfo2.setValue(password);
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;

        HttpTransportSE httpTransportSE = new HttpTransportSE(HTTP+url+URL);
        httpTransportSE.setTimeout(50000);
        try {
            httpTransportSE.call(SOAP_ACTION_LOGIN_USER_SERVICE, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            ObjectMapper mapper = new ObjectMapper();
            userInfo = new LoginUserResponse();
            userInfo = mapper.readValue(result,LoginUserResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        result = "";
        SelectUserResponse selectUserInfo = null;

        soapObject = new SoapObject(NAMESPACE, MainConstant.SELECT_USER);

        propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(userInfo.getId());
        propertyInfo1.setType(String.class);

        soapObject.addProperty(propertyInfo1);

        propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_ID);
        propertyInfo2.setValue(userInfo.getId());
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;

        httpTransportSE = new HttpTransportSE(HTTP+url+URL);

        try {
            httpTransportSE.call(SOAP_ACTION_SELECT_USER_SERVICE, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            ObjectMapper mapper = new ObjectMapper();
            selectUserInfo = new SelectUserResponse();
            selectUserInfo = mapper.readValue(result,SelectUserResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return selectUserInfo;
    }


}
