package openLibrary;

import base.CommonAPIOfFrameWork;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.util.List;

import static io.restassured.RestAssured.get;

public class OpenLibraryRESTfulAPI extends CommonAPIOfFrameWork {
    @Test
    public void postTestinOpenLibrary() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        RequestSpecification rs = RestAssured.given();
        rs.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","alifnabila");
        jsonObject.put("password", "");
        rs.body(jsonObject.toJSONString());
        Response response = rs.post("https://openlibrary.org/account/login");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void testGet(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        RequestSpecification rs = RestAssured.given();
        rs.header("Content-Type", "application/json");
        Response response = rs.get("http://openlibrary.org/authors/OL1A.json");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void testResponseTimeInLogIn(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        long time = get("https://openlibrary.org/account/login").getTime();
        Assert.assertTrue(time > 0.0);
    }
    @Test
    public void testRevision(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        RequestSpecification rs = RestAssured.given();
        rs.header("Content-Type", "application/json");
        Response response = rs.get("http://openlibrary.org/authors/OL1A.json");
        JsonPath jp = response.jsonPath();
        int revision = jp.get("revision");
        Assert.assertEquals(revision,8);
    }
    @Test
    public void testName(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        RequestSpecification rs = RestAssured.given();
        rs.header("Content-Type", "application/json");
        Response response = rs.get("http://openlibrary.org/authors/OL1A.json");
        JsonPath jp = response.jsonPath();
        String name = jp.get("name");
        Assert.assertEquals(name, "Sachi Rautroy");
    }
    @Test
    public void testgetListName(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        RequestSpecification rs = RestAssured.given();
        rs.header("Content-Type", "application/json");
        Response response = rs.get("http://openlibrary.org/authors/OL1A.json");
        JsonPath jp = response.jsonPath();
        List<Object> name = jp.getList("alternate_names");
        System.out.println(jp.getList("alternate_names"));
    }
    @Test
    public void testDeatDate(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        RequestSpecification rs = RestAssured.given();
        rs.header("Content-Type", "application/json");
        Response response = rs.get("http://openlibrary.org/authors/OL1A.json");
        JsonPath jp = response.jsonPath();
        String deathDate = jp.get("death_date");
        Assert.assertEquals(deathDate, "2004");
    }

}
