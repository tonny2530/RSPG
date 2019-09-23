package th.ac.kmitl.rspg.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import th.ac.kmitl.rspg.constant.MainConstant;
import th.ac.kmitl.rspg.request.InsertCreatureRequest;
import th.ac.kmitl.rspg.response.InsertResponse;
import th.ac.kmitl.rspg.util.StringUtil;

public class InsertCreatureService {
    private final static String URL = "http://161.246.58.128/rspg_service/WebService.asmx?WSDL";
    private final static String NAMESPACE = "http://tempuri.org/";
    private final static String SOAP_ACTION = "http://tempuri.org/InsertCreature";
    private final static String PARAMETER_LOG_USER_ID = "log_user_id";
    private final static String PARAMETER_SN = "sn";
    private final static String PARAMETER_TYPE_ID = "type_id";
    private final static String PARAMETER_VERNACULAR_NAME = "vernacular_name";
    private final static String PARAMETER_SCIENTIFIC_NAME = "scientific_name";
    private final static String PARAMETER_FAMILY_NAME = "family_name";
    private final static String PARAMETER_COMMON_NAME = "common_name";
    private final static String PARAMETER_CHARACTER = "character";
    private final static String PARAMETER_ORIGINAL = "original";
    private final static String PARAMETER_DISTRIBUTION = "distribution";
    private final static String PARAMETER_ECOLOGY = "ecology";
    private final static String PARAMETER_IUCN = "iucn";
    private final static String PARAMETER_OTHER = "other";
    private final static String PARAMETER_USER_ID = "user_id";

    public static InsertResponse insertCreature(InsertCreatureRequest request){
        InsertResponse response = null;
        String result = "";

        SoapObject soapObject = new SoapObject(NAMESPACE, MainConstant.INSERT_CREATURE);

        PropertyInfo propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName(PARAMETER_LOG_USER_ID);
        propertyInfo1.setValue(request.getLogUserId());
        propertyInfo1.setType(int.class);

        soapObject.addProperty(propertyInfo1);

        PropertyInfo propertyInfo2 = new PropertyInfo();
        propertyInfo2.setName(PARAMETER_SN);
        propertyInfo2.setValue(request.getSn());
        propertyInfo2.setType(String.class);

        soapObject.addProperty(propertyInfo2);

        PropertyInfo propertyInfo3 = new PropertyInfo();
        propertyInfo3.setName(PARAMETER_VERNACULAR_NAME);
        propertyInfo3.setValue(StringUtil.checkNullOrEmpty(request.getVernacularName()));
        propertyInfo3.setType(String.class);

        soapObject.addProperty(propertyInfo3);

        PropertyInfo propertyInfo4 = new PropertyInfo();
        propertyInfo4.setName(PARAMETER_SCIENTIFIC_NAME);
        propertyInfo4.setValue(StringUtil.checkNullOrEmpty(request.getScientificName()));
        propertyInfo4.setType(String.class);

        soapObject.addProperty(propertyInfo4);

        PropertyInfo propertyInfo5 = new PropertyInfo();
        propertyInfo5.setName(PARAMETER_COMMON_NAME);
        propertyInfo5.setValue(StringUtil.checkNullOrEmpty(request.getCommonName()));
        propertyInfo5.setType(String.class);

        soapObject.addProperty(propertyInfo5);

        PropertyInfo propertyInfo6 = new PropertyInfo();
        propertyInfo6.setName(PARAMETER_CHARACTER);
        propertyInfo6.setValue(StringUtil.checkNullOrEmpty(request.getCharacter()));
        propertyInfo6.setType(String.class);

        soapObject.addProperty(propertyInfo6);

        PropertyInfo propertyInfo7 = new PropertyInfo();
        propertyInfo7.setName(PARAMETER_OTHER);
        propertyInfo7.setValue(StringUtil.checkNullOrEmpty(request.getOther()));
        propertyInfo7.setType(String.class);

        soapObject.addProperty(propertyInfo7);

        PropertyInfo propertyInfo8 = new PropertyInfo();
        propertyInfo8.setName(PARAMETER_USER_ID);
        propertyInfo8.setValue(request.getUserId());
        propertyInfo8.setType(int.class);

        soapObject.addProperty(propertyInfo8);

        PropertyInfo propertyInfo9 = new PropertyInfo();
        propertyInfo9.setName(PARAMETER_TYPE_ID);
        propertyInfo9.setValue(StringUtil.checkNullOrEmpty(request.getTypeId()));
        propertyInfo9.setType(String.class);

        soapObject.addProperty(propertyInfo9);

        PropertyInfo propertyInfo10 = new PropertyInfo();
        propertyInfo10.setName(PARAMETER_FAMILY_NAME);
        propertyInfo10.setValue(StringUtil.checkNullOrEmpty(request.getFamilyName()));
        propertyInfo10.setType(String.class);

        soapObject.addProperty(propertyInfo10);

        PropertyInfo propertyInfo11 = new PropertyInfo();
        propertyInfo11.setName(PARAMETER_ORIGINAL);
        propertyInfo11.setValue(StringUtil.checkNullOrEmpty(request.getOriginal()));
        propertyInfo11.setType(String.class);

        soapObject.addProperty(propertyInfo11);

        PropertyInfo propertyInfo12 = new PropertyInfo();
        propertyInfo12.setName(PARAMETER_DISTRIBUTION);
        propertyInfo12.setValue(StringUtil.checkNullOrEmpty(request.getDistribution()));
        propertyInfo12.setType(String.class);

        soapObject.addProperty(propertyInfo12);

        PropertyInfo propertyInfo13 = new PropertyInfo();
        propertyInfo13.setName(PARAMETER_ECOLOGY);
        propertyInfo13.setValue(StringUtil.checkNullOrEmpty(request.getEcology()));
        propertyInfo13.setType(String.class);

        soapObject.addProperty(propertyInfo13);

        PropertyInfo propertyInfo14 = new PropertyInfo();
        propertyInfo14.setName(PARAMETER_IUCN);
        propertyInfo14.setValue(StringUtil.checkNullOrEmpty(request.getIucn()));
        propertyInfo14.setType(String.class);

        soapObject.addProperty(propertyInfo14);

        SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        envelope.dotNet = true;
        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        ObjectMapper mapper = new ObjectMapper();
        try {
            httpTransportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
            result = soapPrimitive.toString();

//            response = mapper.readValue(result, InsertResponse.class);
            response = new InsertResponse();
            response.setResult(result);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


}


