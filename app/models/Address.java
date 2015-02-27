package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by I306067 on 2/15/2015.
 */
@Entity
public class Address extends Model {
    @Id
    Long id;

    String addressDetails;

    @ManyToOne
    Person person;

}
