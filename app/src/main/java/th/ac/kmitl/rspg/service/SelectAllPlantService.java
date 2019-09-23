package th.ac.kmitl.rspg.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import th.ac.kmitl.rspg.request.SelectAllPlantRequest;
import th.ac.kmitl.rspg.response.SelectAllPlantResponse;

public class SelectAllPlantService {

    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/SelectAllPlant";
    private final static String METHOD_NAME = "SelectAllPlant";

    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_SN = "sn";
    private final static String PARAMETER_TYPE_ID = "type_id";
    private final static String PARAMETER_VERNACULAR_NAME = "vernacular_name";
    private final static String PARAMETER_SCIENTIFIC_NAME = "scientific_name";
    private final static String PARAMETER_FAMILY_NAME = "family_name";
    private final static String PARAMETER_COMMON_NAME = "common_name";
    private final static String PARAMETER_HABITAT_LATITUDE = "habitat_latitude";
    private final static String PARAMETER_HABITAT_LONGITUDE = "habitat_longitude";
    private final static String PARAMETER_START_ROWNUM = "start_rownum";
    private final static String PARAMETER_END_ROWNUM = "end_rownum";

    public static List<SelectAllPlantResponse> getAllPlant(SelectAllPlantRequest request){
        List<SelectAllPlantResponse> plantList = null;
        String result = "";

        SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId());
        propertyInfo1.setType(String.class);
        soapObject.addProperty(propertyInfo1);
        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_SN);
        propertyInfo2.setValue(null);
        propertyInfo2.setType(String.class);
        soapObject.addProperty(propertyInfo2);
        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_TYPE_ID);
        propertyInfo3.setValue(null);
        propertyInfo3.setType(String.class);
        soapObject.addProperty(propertyInfo3);
        PropertyInfo propertyInfo4 = new PropertyInfo();
        propertyInfo4.setName(PARAMETER_VERNACULAR_NAME);
        propertyInfo4.setValue(null);
        propertyInfo4.setType(String.class);
        soapObject.addProperty(propertyInfo4);
        PropertyInfo propertyInfo5 = new PropertyInfo();
        propertyInfo5.setName(PARAMETER_SCIENTIFIC_NAME);
        propertyInfo5.setValue(null);
        propertyInfo5.setType(String.class);
        soapObject.addProperty(propertyInfo5);
        PropertyInfo propertyInfo6 = new PropertyInfo();
        propertyInfo6.setName(PARAMETER_FAMILY_NAME);
        propertyInfo6.setValue(null);
        propertyInfo6.setType(String.class);
        soapObject.addProperty(propertyInfo6);
        PropertyInfo propertyInfo7 = new PropertyInfo();
        propertyInfo7.setName(PARAMETER_COMMON_NAME);
        propertyInfo7.setValue(null);
        propertyInfo7.setType(String.class);
        soapObject.addProperty(propertyInfo7);
        PropertyInfo propertyInfo8 = new PropertyInfo();
        propertyInfo8.setName(PARAMETER_HABITAT_LATITUDE);
        propertyInfo8.setValue(null);
        propertyInfo8.setType(String.class);
        soapObject.addProperty(propertyInfo8);
        PropertyInfo propertyInfo9 = new PropertyInfo();
        propertyInfo9.setName(PARAMETER_HABITAT_LONGITUDE);
        propertyInfo9.setValue(null);
        propertyInfo9.setType(String.class);
        soapObject.addProperty(propertyInfo9);
        PropertyInfo propertyInfo10 = new PropertyInfo();
        propertyInfo10.setName(PARAMETER_START_ROWNUM);
        propertyInfo10.setValue(null);
        propertyInfo10.setType(String.class);
        soapObject.addProperty(propertyInfo10);
        PropertyInfo propertyInfo11 = new PropertyInfo();
        propertyInfo11.setName(PARAMETER_END_ROWNUM);
        propertyInfo11.setValue(null);
        propertyInfo11.setType(String.class);
        soapObject.addProperty(propertyInfo11);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
        ObjectMapper mapper = new ObjectMapper();

        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            plantList = mapper.readValue(result,new TypeReference<List<SelectAllPlantResponse>>(){});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return plantList;
    }
}
