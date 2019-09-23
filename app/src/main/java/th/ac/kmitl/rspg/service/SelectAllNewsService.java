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

import th.ac.kmitl.rspg.request.SelectAllNewsRequest;
import th.ac.kmitl.rspg.response.SelectAllNewsResponse;
import th.ac.kmitl.rspg.util.StringUtil;

public class SelectAllNewsService {
//    Update New IP @23/09/2019
    private final static String URL = "http://161.246.34.253/rspg_service/WebService.asmx?WSDL";
//     private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/SelectAllNews";
    private final static String METHOD_NAME = "SelectAllNews";

    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_STARTDATE = "start_date";
    private final static String PARAMETER_ENDDATE = "end_date";
    private final static String PARAMETER_NAME = "name";
    private final static String PARAMETER_DETAIL = "detail";
    private final static String PARAMETER_PROJECT_ID = "project_id";
    private final static String PARAMETER_START_ROWNUM = "start_rownum";
    private final static String PARAMETER_END_ROWNUM = "end_rownum";
    private final static String PARAMETER_PUBLIC = "_public";

    public static List<SelectAllNewsResponse> getAllNews(SelectAllNewsRequest request){
        List<SelectAllNewsResponse> newsList = null;
        String result = null;

        SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId());
        propertyInfo1.setType(String.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_STARTDATE);
        propertyInfo2.setValue(request.getStartdate());
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_ENDDATE);
        propertyInfo3.setValue(request.getEnddate());
        propertyInfo3.setType(String.class);

        soapObject.addProperty(propertyInfo3);

        PropertyInfo propertyInfo4 = new PropertyInfo();
        propertyInfo4.setName(PARAMETER_NAME);
        propertyInfo4.setValue(null);
        propertyInfo4.setType(String.class);

        soapObject.addProperty(propertyInfo4);

        PropertyInfo propertyInfo5 = new PropertyInfo();
        propertyInfo5.setName(PARAMETER_DETAIL);
        propertyInfo5.setValue(null);
        propertyInfo5.setType(String.class);

        soapObject.addProperty(propertyInfo5);

        PropertyInfo propertyInfo6 = new PropertyInfo();
        propertyInfo6.setName(PARAMETER_PROJECT_ID);
        propertyInfo6.setValue(StringUtil.checkNullOrEmpty(request.getProjectId()));
        propertyInfo6.setType(String.class);

        soapObject.addProperty(propertyInfo6);

        PropertyInfo propertyInfo7 = new PropertyInfo();
        propertyInfo7.setName(PARAMETER_START_ROWNUM);
        propertyInfo7.setValue(null);
        propertyInfo7.setType(String.class);

        soapObject.addProperty(propertyInfo7);

        PropertyInfo propertyInfo8 = new PropertyInfo();
        propertyInfo8.setName(PARAMETER_END_ROWNUM);
        propertyInfo8.setValue(null);
        propertyInfo8.setType(String.class);

        soapObject.addProperty(propertyInfo8);

        PropertyInfo propertyInfo9 = new PropertyInfo();
        propertyInfo9.setName(PARAMETER_PUBLIC);
        propertyInfo9.setValue(null);
        propertyInfo9.setType(String.class);

        soapObject.addProperty(propertyInfo9);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        ObjectMapper mapper = new ObjectMapper();

        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            newsList =  mapper.readValue(result,new TypeReference<List<SelectAllNewsResponse>>(){});


        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }

}
