package com.biblio.bibliotheque.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="livre")
public class Livre {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="titre")
    private String titre;

    @Column(name = "langue")
    private String langue;

    @Column(name= "date_edition")
    private Date dateEdition;


    public Livre(){

    }

    public Livre(String name, String langue, Date d){
        this.titre= name;
        this.langue = langue;
        this.dateEdition = d;
    }

    public String getTitre(){
        return titre;
    }

    public String getLangue(){
        return langue;
    }

    public Date getDateEdition(){
        return dateEdition;
    }

    public void setTitre(String titre){
        this.titre=titre;
    }

    public void setLangue(String langue ){
        this.langue = langue;
    }

    public void setDateEdition(Date d){
        this.dateEdition = d;
    }
    

    @Override
	public String toString() {
		return "Livre [id=" + id + ", Titre=" + titre + ", langue=" + langue + ", Date edition=" + dateEdition + "]";
	}


    
}
