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

import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.request.SearchAllRequest;
import th.ac.kmitl.rspg.response.SearchAllResponse;
import th.ac.kmitl.rspg.response.SelectAllPlantResponse;
import th.ac.kmitl.rspg.util.StringUtil;

public class SearchService {

    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/SearchAll";
    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_KEYWORD= "keyword";
    private final static String PARAMETER_TYPE= "type";
    private final static String PARAMETER_START_ROWNUM= "start_rownum";
    private final static String PARAMETER_END_ROWNUM= "end_rownum";

    public static List<SearchAllResponse> search(SearchAllRequest request){
        List<SearchAllResponse> response = null;
        String result = "";
        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.SEARCH_ALL);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId().toString());
        propertyInfo1.setType(String.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_KEYWORD);
        propertyInfo2.setValue(request.getKeyword());
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_TYPE);
        propertyInfo3.setValue(request.getType());
        propertyInfo3.setType(String.class);

        soapObject.addProperty(propertyInfo3);

        PropertyInfo propertyInfo10 = new PropertyInfo();
        propertyInfo10.setName(PARAMETER_START_ROWNUM);
        propertyInfo10.setValue(StringUtil.checkNullOrEmpty(request.getStartRownum()));
        propertyInfo10.setType(String.class);

        soapObject.addProperty(propertyInfo10);

        PropertyInfo propertyInfo11 = new PropertyInfo();
        propertyInfo11.setName(PARAMETER_END_ROWNUM);
        propertyInfo11.setValue(StringUtil.checkNullOrEmpty(request.getEndRownum()));
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

            response = mapper.readValue(result,new TypeReference<List<SearchAllResponse>>(){});
        }catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
