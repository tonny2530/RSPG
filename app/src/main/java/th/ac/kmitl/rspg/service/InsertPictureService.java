package th.ac.kmitl.rspg.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.request.InsertPictureRequest;
import th.ac.kmitl.rspg.response.InsertResponse;
import th.ac.kmitl.rspg.util.StringUtil;

public class InsertPictureService {
    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/InsertPicture";
    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_BASE64ENCODE = "base64encode";
    private final static String PARAMETER_NAME = "name";
    private final static String PARAMETER_DETAIL = "detail";
    private final static String PARAMETER_FIRST = "first";
    private final static String PARAMETER_PLANT_ID = "plant_id";
    private final static String PARAMETER_CREATURE_ID = "creature_id";
    private final static String PARAMETER_NEWS_ID = "news_id";

    public static InsertResponse insertPicture(InsertPictureRequest request){
        InsertResponse response = null;
        String result = "";

        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.INSERT_PICTURE);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId());
        propertyInfo1.setType(int.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_BASE64ENCODE);
        propertyInfo2.setValue(request.getBase64encode());
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_CREATURE_ID);
        if(request.getCreatureId() == null){
            propertyInfo3.setValue("");
        }else{
            propertyInfo3.setValue(String.valueOf(request.getCreatureId()));
        }
        propertyInfo3.setType(int.class);

        soapObject.addProperty(propertyInfo3);

        PropertyInfo propertyInfo4 = new PropertyInfo();
        propertyInfo4.setName(PARAMETER_NEWS_ID);
        if(request.getNewsId() == null){
            propertyInfo4.setValue("");
        }else{
            propertyInfo4.setValue(String.valueOf(request.getNewsId()));
        }
        propertyInfo4.setType(int.class);

        soapObject.addProperty(propertyInfo4);

        PropertyInfo propertyInfo5 = new PropertyInfo();
        propertyInfo5.setName(PARAMETER_DETAIL);
        propertyInfo5.setValue(StringUtil.checkNullOrEmpty(request.getDetail()));
        propertyInfo5.setType(String.class);

        soapObject.addProperty(propertyInfo5);

        PropertyInfo propertyInfo6 = new PropertyInfo();
        propertyInfo6.setName(PARAMETER_FIRST);
        propertyInfo6.setValue(StringUtil.checkNullOrEmpty(request.getFirst()));
        propertyInfo6.setType(int.class);

        soapObject.addProperty(propertyInfo6);

        PropertyInfo propertyInfo7 = new PropertyInfo();
        propertyInfo7.setName(PARAMETER_PLANT_ID);
        if(request.getPlantId() == null){
            propertyInfo7.setValue("");
        }else{
            propertyInfo7.setValue(StringUtil.checkNullOrEmpty(String.valueOf(request.getPlantId())));
        }
        propertyInfo7.setType(int.class);

        soapObject.addProperty(propertyInfo7);

        PropertyInfo propertyInfo8 = new PropertyInfo();
        propertyInfo8.setName(PARAMETER_NAME);
        propertyInfo8.setValue(StringUtil.checkNullOrEmpty(request.getName()));
        propertyInfo8.setType(String.class);

        soapObject.addProperty(propertyInfo8);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            response = new InsertResponse();
            response.setResult(result);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
