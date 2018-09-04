package restadduredtest;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
	public static String baseURI = "http://wddcesamapi01:18929";

	@Test
	public void Test() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = baseURI;

		given()
				.param("ContactId", "40916942").
				param("SubsidiaryCode", "MX").
				param("Culture", "es-MX")
				.param("OrderType", "1").
				param("OrderSourceId", "2").
				param("carttype", "1").
		when().get("/orders/Active").
		then().		
				assertThat().
				statusCode(200).
				and().contentType(ContentType.JSON).
				and().body("RequestContactId",equalTo(40916942));

		System.out.println("get services responded corectly");

	}

}
