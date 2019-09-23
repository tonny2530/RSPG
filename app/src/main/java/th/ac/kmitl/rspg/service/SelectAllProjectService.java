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

import th.ac.kmitl.rspg.request.SelectAllProjectRequest;
import th.ac.kmitl.rspg.response.SelectAllNewsResponse;
import th.ac.kmitl.rspg.response.SelectAllProjectResponse;

public class SelectAllProjectService {

    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/SelectAllProject";
    private final static String METHOD_NAME = "SelectAllProject";

    private final static String PARAM_LOG_USER_ID = "log_user_id";
    private final static String PARAM_SN = "sn";
    private final static String PARAM_THNAME = "thname";
    private final static String PARAM_ENNAME = "enname";
    private final static String PARAM_THRESEARCH = "thresearch";
    private final static String PARAM_ENRESEARCH = "enresearch";
    private final static String PARAM_CHARACTER = "character";
    private final static String PARAM_STARTDATE = "startdate";
    private final static String PARAM_ENDDATE = "enddate";
    private final static String PARAM_GROUP = "group";
    private final static String PARAM_KEYWORD = "keyword";
    private final static String PARAM_TYPE = "type";
    private final static String PARAM_TYPE_PLANT_CREATURE = "type_plant_creature";
    private final static String PARAM_STATUS = "status";
    private final static String PARAM_START_ROWNUM = "start_rownum";
    private final static String PARAM_END_ROWNUM = "end_rownum";


    public static List<SelectAllProjectResponse> getAllProject(SelectAllProjectRequest request){
        List<SelectAllProjectResponse> projectList = null;
        String result = null;

        SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_LOG_USER_ID);
        propertyInfo.setValue(request.getLogUserId());
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_SN);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_THNAME);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_ENNAME);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_THRESEARCH);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_ENRESEARCH);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_CHARACTER);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_STARTDATE);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_ENDDATE);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_GROUP);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_KEYWORD);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_TYPE);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_TYPE_PLANT_CREATURE);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_STATUS);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_START_ROWNUM);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        propertyInfo = new PropertyInfo();
        propertyInfo.setName(PARAM_END_ROWNUM);
        propertyInfo.setValue(null);
        propertyInfo.setType(String.class);

        soapObject.addProperty(propertyInfo);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        ObjectMapper mapper = new ObjectMapper();

        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

            projectList =  mapper.readValue(result,new TypeReference<List<SelectAllProjectResponse>>(){});


        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectList;
    }

}
