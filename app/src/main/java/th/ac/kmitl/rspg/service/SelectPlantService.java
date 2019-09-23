package th.ac.kmitl.rspg.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.request.SelectPlantRequest;
import th.ac.kmitl.rspg.response.SelectPlantResponse;

public class SelectPlantService {

    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/SelectPlant";
    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_ID = "id";

    public static SelectPlantResponse getPlant(SelectPlantRequest request){
        SelectPlantResponse response = null;
        String result = "";
        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.SELECT_PLANT);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId().toString());
        propertyInfo1.setType(String.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_ID);
        propertyInfo2.setValue(request.getId().toString());
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        ObjectMapper mapper = new ObjectMapper();
        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            response = mapper.readValue(result, SelectPlantResponse.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
