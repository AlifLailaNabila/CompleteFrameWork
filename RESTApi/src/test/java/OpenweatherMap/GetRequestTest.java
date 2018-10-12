package OpenweatherMap;
import static io.restassured.RestAssured.*;

import base.CommonAPIOfFrameWork;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class GetRequestTest extends CommonAPIOfFrameWork {
    public static String url = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
    @Test
    public void testResponseCode(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        int status = get(url).getStatusCode();
        Assert.assertEquals(status,200);
    }
    @Test
    public void testResponseTime(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        long time = get(url).getTime();
        Assert.assertTrue(time > 0.0);
    }
    @Test
    public void testResponseCity(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        JsonPath jsonPathEvaluator = get(url).jsonPath();
        String city = jsonPathEvaluator.get("name");
        Assert.assertEquals(city,"London");
    }
    @Test
    public void testResponseID(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        JsonPath jsonPathEvaluator = get(url).jsonPath();
        int id = jsonPathEvaluator.get("id");
        Assert.assertEquals(id,2643743);
    }
    @Test
    public void testResponseCod(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        JsonPath jsonPathEvaluator = get(url).jsonPath();
        int cod = jsonPathEvaluator.get("cod");
        Assert.assertEquals(cod, 200);
    }
//    @Test
//    public void testResponseSysID(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        JsonPath jsonPathEvaluator = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22.sys.type").jsonPath();
//        int type = jsonPathEvaluator.get("type");
//        //System.out.println(type);
//        //Assert.assertEquals(type,1);
//    }
}
