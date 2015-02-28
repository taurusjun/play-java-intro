package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.MyDto;
import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.*;

import java.util.Map;

import static play.mvc.Results.redirect;

/**
 * Created by I306067 on 2/27/2015.
 */
public class MyApp {
    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPersonBatch(){
        JsonNode jsonNode= toJSON();
        //Can be mapped to DTO when request body format is JSON
        MyDto myDto= toDTO();
        return Results.ok(jsonNode);
    }

    public static Result addPersonBatchWithFormData(){
        final Map<String, String[]> values = toMap();
        MyDto myDto= toDTO();
        //return redirect(controllers.routes.Application.index());
        return Results.ok(Json.toJson(myDto));
    }

    /**
     * Mapping request data to JSON format
     * @return
     */
    private static JsonNode toJSON(){
      return Controller.request().body().asJson();
    }

    /**
     * Manully create json
     */

    private static JsonNode manuallyJSON(){
        /* Here to demo how to return a json object  */
        ObjectNode jsonObject= Json.newObject();
        jsonObject.put("field1",1);
        jsonObject.put("field2",2);
        ArrayNode arrayNode=jsonObject.putArray("arrayField");
        ObjectNode anNode1=Json.newObject();
        anNode1.put("arrayField1",3);
        arrayNode.add(anNode1);

        return  jsonObject;
    }

    /**
     * Mapping request data to dto model
     * @return
     */
    private static MyDto toDTO(){
        return Form.form(MyDto.class).bindFromRequest().get();
    }

    /**
     * Get request data map
     * @return
     */
    private static Map<String, String[]> toMap(){
        return Controller.request().body().asFormUrlEncoded();
    }
}
