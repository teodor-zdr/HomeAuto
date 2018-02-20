import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) {
        String jsonLine = "{\"source\":\"40\",\"account\":{\"firstName\":\"sad\",\"lastName\":\"nad\",\"email\":\"tested@testeded.com\",\"password\":\"1234qwert\",\"confirmPassword\":\"1234qwert\",\"dateOfBirth\":\"1999-05-11\"},\"subscription\":{\"serviceID\":[\"100\"],\"consents\":[{\"consentType\":\"AMF\",\"consentValue\":false}]},\"profile\":{\"consumerAttributes\":[]},\"countryOfSite\":\"FI\",\"communicationLanguage\":\"fi\",\"reCaptchaResponse\":\"03AMPJSYUou_V7Qb2GcESkvLuAL39yr_CCkUqw2ZbfiE3hSuD4i6oOHpVhwQXVdGrndr_hlQW0oNr9GZ-HkwAHDPkFxz_t-mhLyhee2aMx00ujSW-icATzALjhff0xlePDsD_FOmmPmtLYPVbF9KtQTK-opVX_ZBExUVdKksizFGsiDtL07Z9tk6QC-m9Jj4T557M3dE_BajAiBMMV_Xldi0-V4Gxqg_3-LKtkeCxio4Wd-_1e4T9ApQ_mKOJ0CukgJvRHmIU2r9kb5kZPByjFYDdAW3GrIlKifsRg0rv74ykE-TOzSe9NLMgt4o7DaFheHbsMp2EQMpe5\",\"pfStartSSOURL\":\"https://dev.cp.adidas.fi/idp/startSSO.ping\",\"idpAdapterId\":\"adidasIdP10\",\"partnerSpId\":\"sp:demandware\",\"detectionCookie\":\"eCom|fi_FI|dev.cp.adidas.fi|null\",\"targetResource\":\"https://www.test.development.adidas.fi/on/demandware.store/Sites-adidas-FI-Site/fi_FI/MyAccount-ResumeRegister?target=account\",\"inErrorResource\":\"https://www.test.development.adidas.fi/on/demandware.store/Sites-adidas-FI-Site/fi_FI/null\",\"loginUrl\":\"https://www.test.development.adidas.fi/on/demandware.store/Sites-adidas-FI-Site/fi_FI/MyAccount-CreateOrLogin\"}";
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("subscription");
        JsonArray jarray = jobject.getAsJsonArray("consents");
        jobject = jarray.get(0).getAsJsonObject();
        String result = jobject.get("consentValue").getAsString();

        System.out.println(result);
    }
}
