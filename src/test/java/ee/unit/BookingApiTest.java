package ee.unit;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class BookingApiTest {

    @Test
    public void shouldGet200WhenPerformingGet() {
        get("http://hotel-test.equalexperts.io/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldGetBookingIdResponse() {
        String jsonPayload =
            "{\"firstname\":\"ee-fname\"," +
            "\"lastname\":\"ee-sname\"," +
            "\"totalprice\":\"500\"," +
            "\"depositpaid\":\"true\"," +
            "\"bookingdates\":{" +
                "\"checkin\":\"2019-11-15\"," +
                "\"checkout\":\"2019-11-16\"}" +
            "}";
        given()
                .contentType("application/json")
                .body(jsonPayload)
                .when()
                .request("POST", "http://hotel-test.equalexperts.io/booking")
                .then()
                .statusCode(200);
    }
}


