/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author kayum
 */
public class Travailler {
    
    private int vMat, codeRegion;
    private Date dateEmbauche;
    private String role;
    private Visiteurs visiteur;
    private Region region;

    public Travailler(Region region) {
        this.region = region;
    }

    public Travailler(Date dateEmbauche, String role, Visiteurs visiteur, Region region) {
        this.dateEmbauche = dateEmbauche;
        this.role = role;
        this.visiteur = visiteur;
        this.region = region;
    }
    
    
    

    /**
     * @return the vMat
     */
    public int getvMat() {
        return vMat;
    }

    /**
     * @return the codeRegion
     */
    public int getCodeRegion() {
        return codeRegion;
    }

    /**
     * @return the dateEmbauche
     */
    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * @return the visiteur
     */
    public Visiteurs getVisiteur() {
        return visiteur;
    }

    /**
     * @param visiteur the visiteur to set
     */
    public void setVisiteur(Visiteurs visiteur) {
        this.visiteur = visiteur;
    }
    
    
}
