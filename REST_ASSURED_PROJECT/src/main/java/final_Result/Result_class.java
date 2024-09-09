package final_Result;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import my_POJO.all_Objects;

import static io.restassured.RestAssured.*;
public class Result_class {

	public static void main(String[] args) {
		
	String response=	given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.then().extract().response().asString();
		
		
		System.out.println(response);
		
		
	   JsonPath js = new JsonPath(response);
	   String access_token=  js.getString("access_token");
	   System.out.println("access token "+access_token);
	   
	   all_Objects obj = given().queryParams("access_token",access_token)
	   .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(all_Objects.class);
		
	   
	  System.out.println(obj.getInstructor());
 		
		
	}

}
