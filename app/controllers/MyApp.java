package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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
        return Results.redirect(routes.Application.index());
    }
}
