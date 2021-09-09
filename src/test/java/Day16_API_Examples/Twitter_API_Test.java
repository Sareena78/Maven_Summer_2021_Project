package Day16_API_Examples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Twitter_API_Test {
    String consumerKey = "ZfgHMDiE4a4kfVT6Ad1TwsvWx";
    String consumerSecret = "HdjEfJGA7Zs3Q6ZHMxVuzmWs0IL7mWEusUZ2DX3yTLrU9Tmk3s";
    String accessToken = "1064659366278766592-u4ACPI2x6b7iDCdJ5LVYDRMZwSHFpu";
    String tokenSecret = "1bIQVhXrUyRUueggrq4ORYD0gpnpsN6h5SpVOJf4BVYjD";
    String id = "";

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/";
    }//end of set up

    @Test
    public void postAStatus() {
        Response response =
                given().
                        auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                        queryParam("status", "My 2nd post through api automation")
                        .when().post("update.json")
                        .then().extract().response();

        if (response.statusCode() == 200) {
            System.out.println("Status code is 200 as expected");
        } else {
            System.out.println("Actual status code is " + response.statusCode());
        }
        //verify the id and the text after posting
        String resp = response.asString();
        JsonPath json = new JsonPath(resp);
        //id
        String id = json.getString("id");
        //text
        String actualText = json.getString("text");

        System.out.println("My id is " + id + " and text is " + actualText);

    }//end of post a status method

    @Test(dependsOnMethods = "postAStatus")
    public void deleteRecentPost() {
        Response response =
                given()
                        .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                        queryParam("id", id)
                        .when().post("destroy.json")
                        .then().extract().response();
        //verify the id and the text after posting
        String resp = response.asString();
        JsonPath json = new JsonPath(resp);
        //id
        String id = json.getString("id");
        //text
        String actualText = json.getString("text");

        System.out.println("My id is " + id + " and text is " + actualText);


    }//end of delete recent post







}//end of class
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;

//verify the id and the text after posting
//String resp = response.asString();
//JsonPath json = new JsonPath(resp);
//id
//String id = json.getString("id");
//text
//String actualText = json.getString("text");

// System.out.println("My id is " + id + " and text is " + actualText);

