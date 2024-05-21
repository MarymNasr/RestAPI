import Requests.CommentsRequests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateCommentsTest {
String id= "" ; //ASK WHY NOT INTEGER
//String post_id="";
@Test
        public void createCommentTest() {
    String post_id = "100982";
    String name = "Ali ";
    String email = "ali@test.com";
    String body = "Hello maryoma.";
    Response response = CommentsRequests.createComment(post_id, name, email, body);
    response.prettyPrint();
    response.then().statusCode(201);
    JsonPath jsonPath = response.jsonPath();
    id = jsonPath.get("id").toString();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertNotNull(jsonPath.get("id"),"Resource not found");
    CommentsRequests.deleteSingleComment("id");
    softAssert.assertAll();
}

@Test
     public void validateFieldsNotNull(){
     Response response = CommentsRequests.createComment("","","",""); //CAN post_id BE A STRING INSTEAD
     response.then().statusCode(422);
     JsonPath jsonPath = response.jsonPath();
    SoftAssert softy = new SoftAssert();
     for(int loopOnFields=0;loopOnFields<4;loopOnFields++){
         softy.assertTrue(jsonPath.getString("["+loopOnFields+"].message").contains("can't be blank, is invalid"),
                 "message is not as expected");
     }
    //softy.assertAll(); //ASK WHY IT GIVES AN ERROR
}

}
