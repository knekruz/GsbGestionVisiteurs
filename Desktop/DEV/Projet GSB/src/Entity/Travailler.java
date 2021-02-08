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
    private Region region;

    public Travailler(Region region) {
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
    
    
}
