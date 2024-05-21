package Requests;

import Utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CommentsRequests {
    public static Response createComment (String post_id, String name, String email, String body){
        return RestAssured.given().log().all().
                contentType(ContentType.JSON).
                headers(Constants.generalHeaders())
                .body("{\n" +
                        "    \"post_id\": \""+post_id+"\",\n" +
                        "    \"name\": \""+name+"\",\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"body\": \""+body+"\"\n" +
                        "}").post(Constants.baseURL+ Constants.userEndPoint);
    }

    public static Response getComment(String id){
        return RestAssured.given().log().all().headers(Constants.generalHeaders())
                .get(Constants.baseURL + Constants.userEndPoint + id);
    }

    public static Response deleteSingleComment (String id){
        return RestAssured.given().log().all()
                .headers(Constants.generalHeaders())
                .delete(Constants.baseURL +Constants.userEndPoint +id);
    }
}
