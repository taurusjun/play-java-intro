package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.*;

import java.util.Map;

/**
 * Created by I306067 on 2/27/2015.
 */
public class MyApp {
    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPersonBatch(){
        JsonNode jsonNode= Controller.request().body().asJson();
        /* Here to demo how to return a json object  */
        ObjectNode jsonObject= Json.newObject();
        jsonObject.put("field1",1);
        jsonObject.put("field2",2);
        ArrayNode arrayNode=jsonObject.putArray("arrayField");
        ObjectNode anNode1=Json.newObject();
        anNode1.put("arrayField1",3);
        arrayNode.add(anNode1);

        //return Results.redirect(controllers.routes.Application.index());
        return Results.ok(jsonNode);
    }
}
