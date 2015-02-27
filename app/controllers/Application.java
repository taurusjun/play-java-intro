package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Address;
import models.Person;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;
import java.util.Map;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Hello,world."));
    }

    public static Result addPerson(){
        Person person= Form.form(Person.class).bindFromRequest().get();
        //Address address=new Model.Finder<>()
        person.save();
        return redirect(routes.Application.index());
    }

//    @BodyParser.Of(BodyParser.Json.class)
//    public static Result addPersonBatch(){
//        JsonNode jsonNode=Controller.request().body().asJson();
//        final Map<String, String[]> values = request().body().asFormUrlEncoded();
//        return redirect(routes.Application.index());
//    }

    public static Result getPersons(){
        List<Person> persons= new Model.Finder(String.class, Person.class).all();
        return  ok(toJson(persons));
    }

}
