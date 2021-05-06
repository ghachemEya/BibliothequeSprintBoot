package com.biblio.bibliotheque.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.String;


@Entity
@Table(name="auteur")
public class Auteur {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

    @Column(name="nationalite")
    private String nationalite;

   public Auteur() {


    }

  public Auteur(String name, String lastname, String natinalite){
        this.firstName =  name;
        this.lastName = lastname;
        this.nationalite = natinalite;
    }


    public String getName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getNationalite(){
        return nationalite;
    }

    public void setName(String name){
        this.firstName = name;
    }

    public void setLastName(String lastname){
        this.lastName = lastname;
    }    

    public void setNationalite(String natio){
        this.nationalite = natio;
    }

    @Override
	public String toString() {
		return "Auteur [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nationalite=" + nationalite + "]";
	} 


}
