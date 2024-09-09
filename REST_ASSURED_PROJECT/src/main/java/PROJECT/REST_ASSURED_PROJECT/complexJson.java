package PROJECT.REST_ASSURED_PROJECT;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
 
	 
	 


public class complexJson {

	public static void main(String[] args) {
		String jsom = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		JsonPath js = new JsonPath(jsom);
		int coursecount=js.getInt("courses.size()");//total courses
		System.out.println(coursecount);
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");//purchase amount
		System.out.println(purchaseAmt);
		String firstcoursetitle=js.getString("courses[0].title");//print title of first course
		System.out.println(firstcoursetitle);
		
		// print courses AND RESPECTIVE PRICES
		
	    for(int i=0; i<coursecount ;i++) {
	    	System.out.println( js.get("courses["+i+"].title").toString()+"  "+js.get("courses["+i+"].price").toString());
	    }
		
		//print copies  number of RPA
	    for(int i=0; i<coursecount ;i++) {
	    	if(js.get("courses["+i+"].title").toString().equalsIgnoreCase("RPA")) {
	    		System.out.println(js.getInt("courses["+i+"].copies"));
	    	}
	    }
	    
	//    6. Verify if Sum of all Course prices matches with Purchase Amount
	    int sum =0;
	    
	    for(int i=0; i<coursecount ;i++) {
	    int	mul = js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
	    	sum =sum + mul;
	    	
	    }
	     System.out.println(sum);
	    if(js.getInt("dashboard.purchaseAmount") == sum) {
	    	System.out.println("matches");
	    }
	    else {
	    	System.out.println("not matches");
	    }
		
	}

}
