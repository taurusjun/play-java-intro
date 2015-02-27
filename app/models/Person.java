package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by I306067 on 2/13/2015.
 */
@Entity
public class Person extends Model {
    @Id
    public String id;

    public String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Address> addressList=new ArrayList<Address>();

    public static Finder<String, Person> find=new Finder<String, Person>(String.class,Person.class);
}
