/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Laassili Oussama
 */
@Entity
public class Service {
    @Id
    @GeneratedValue
    private int id;
    private String nomService;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private double prix;

    public Service() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

   

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNomService() {
        return nomService;
    }

   

    public double getPrix() {
        return prix;
    }

    public Service(String nomService, Date date, double prix) {
        this.nomService = nomService;
        this.date = date;
        this.prix = prix;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
