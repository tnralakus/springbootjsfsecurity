package example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: TTTALAKUS
 * Date: 04.06.2015
 * Time: 09:25
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@Table(name = "PERSON")
public class Person implements Serializable
{
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    private String email;

    public Person()
    {
    }

    public Person(int id, String username, String email)
    {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public String toString()
    {
        return " id : " + this.id + " username : " + this.username + " e-mail : " + this.email;
    }
}