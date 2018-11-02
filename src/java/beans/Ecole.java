/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author LAZAARYAHYA
 */
@Entity
public class Ecole {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String adresse;
    private String tel;
    private int nbrEtudiant;

    public Ecole() {
    }

    public Ecole(String nom, String adresse, String tel, int nbrEtudiant) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.nbrEtudiant = nbrEtudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getNbrEtudiant() {
        return nbrEtudiant;
    }

    public void setNbrEtudiant(int nbrEtudiant) {
        this.nbrEtudiant = nbrEtudiant;
    }

}
