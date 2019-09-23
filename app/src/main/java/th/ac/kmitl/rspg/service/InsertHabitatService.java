package th.ac.kmitl.rspg.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.request.InsertHabitatRequest;
import th.ac.kmitl.rspg.response.HabitatResponse;
import th.ac.kmitl.rspg.util.StringUtil;

public class InsertHabitatService {

    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/InsertHabitat";
    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_PLANT_ID = "plant_id";
    private final static String PARAMETER_CREATURE_ID = "creature_id";
    private final static String PARAMETER_LATITUDE = "latitude";
    private final static String PARAMETER_LONGITUDE = "longitude";
    private final static String PARAMETER_AREA = "area";

    public static HabitatResponse insertHabitat(InsertHabitatRequest request){
        HabitatResponse response = null;
        String result = "";

        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.INSERT_HABITAT);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId());
        propertyInfo1.setType(int.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_PLANT_ID);
        if(request.getPlantId() == null){
            propertyInfo2.setValue("");
        }else{
            propertyInfo2.setValue(String.valueOf(request.getPlantId()));
        }
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_LATITUDE);
        propertyInfo3.setValue(String.valueOf(request.getLatitude()));
        propertyInfo3.setType(String.class);

        soapObject.addProperty(propertyInfo3);

        PropertyInfo propertyInfo4 = new PropertyInfo();
        propertyInfo4.setName(PARAMETER_LONGITUDE);
        propertyInfo4.setValue(String.valueOf(request.getLongitude()));
        propertyInfo4.setType(String.class);

        soapObject.addProperty(propertyInfo4);

        PropertyInfo propertyInfo5 = new PropertyInfo();
        propertyInfo5.setName(PARAMETER_CREATURE_ID);
        if(request.getCreatureId() == null){
            propertyInfo5.setValue("");
        }else{
            propertyInfo5.setValue(String.valueOf(request.getCreatureId()));
        }
        propertyInfo5.setType(int.class);

        soapObject.addProperty(propertyInfo5);

        PropertyInfo propertyInfo6 = new PropertyInfo();
        propertyInfo6.setName(PARAMETER_AREA);
        propertyInfo6.setValue(StringUtil.checkNullOrEmpty(request.getArea()));
        propertyInfo6.setType(String.class);

        soapObject.addProperty(propertyInfo6);


        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        ObjectMapper mapper = new ObjectMapper();
        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            response = new HabitatResponse();
            response.setId(Integer.parseInt(result));
        }catch (Exception e) {

            e.printStackTrace();
        }

        return response;
    }

    public static HabitatResponse insertCreatureHabitat(InsertHabitatRequest request){
        HabitatResponse response = null;
        String result = "";

        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.INSERT_HABITAT);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId());
        propertyInfo1.setType(int.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_PLANT_ID);
        propertyInfo2.setValue("");
        propertyInfo2.setType(int.class);

        soapObject.addProperty(propertyInfo2);

        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_LATITUDE);
        propertyInfo3.setValue(request.getLatitude());
        propertyInfo3.setType(double.class);

        soapObject.addProperty(propertyInfo3);

        PropertyInfo propertyInfo4 = new PropertyInfo();
        propertyInfo4.setName(PARAMETER_LONGITUDE);
        propertyInfo4.setValue(request.getLongitude());
        propertyInfo4.setType(double.class);

        soapObject.addProperty(propertyInfo4);

        PropertyInfo propertyInfo5 = new PropertyInfo();
        propertyInfo5.setName(PARAMETER_CREATURE_ID);
        propertyInfo5.setValue(request.getCreatureId());
        propertyInfo5.setType(int.class);

        soapObject.addProperty(propertyInfo5);

        PropertyInfo propertyInfo6 = new PropertyInfo();
        propertyInfo6.setName(PARAMETER_AREA);
        propertyInfo6.setValue("");
        propertyInfo6.setType(String.class);

        soapObject.addProperty(propertyInfo6);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        ObjectMapper mapper = new ObjectMapper();
        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            response = mapper.readValue(result, HabitatResponse.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


}
