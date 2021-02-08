/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;


/**
 *
 * @author kayum
 */
public class Visiteurs {
    
    private int vMat, vCp, codeLabo, codeSecteur, labos, secteurs,nbVisiteur;
    private float pourcentageVisiteurs;
    private String vNom, vPrenom, vAdresse, vVille, dateEmbauche;
    private Labo labo;
    private Secteur secteur;

    public Visiteurs(int vMat,String vNom, String vPrenom, String vAdresse, int vCp, String vVille, String dateEmbauche, Labo labo, Secteur secteur) {
        this.vCp = vCp;
        this.vNom = vNom;
        this.vPrenom = vPrenom;
        this.vAdresse = vAdresse;
        this.vVille = vVille;
        this.dateEmbauche = dateEmbauche;
        this.labo = labo;
        this.secteur = secteur;
        this.vMat = vMat;
    }
    public Visiteurs(String vNom, String vPrenom, String vAdresse, int vCp, String vVille, String dateEmbauche) {
        this.vCp = vCp;
        this.vNom = vNom;
        this.vPrenom = vPrenom;
        this.vAdresse = vAdresse;
        this.vVille = vVille;
        this.dateEmbauche = dateEmbauche;
    }

    public Visiteurs(Secteur secteur, int nbVisiteur, float pourcentageVisiteur) {
        this.secteur = secteur;
        this.nbVisiteur = nbVisiteur;
        this.pourcentageVisiteurs = pourcentageVisiteur;
    }

    
    
    /**
     * @return the vMat
     */
    public int getvMat() {
        return vMat;
    }

    /**
     * @param vMat the vMat to set
     */
    public void setvMat(int vMat) {
        this.vMat = vMat;
    }

    /**
     * @return the vCp
     */
    public int getvCp() {
        return vCp;
    }

    /**
     * @param vCp the vCp to set
     */
    public void setvCp(int vCp) {
        this.vCp = vCp;
    }

    /**
     * @return the codeLabo
     */
    public int getCodeLabo() {
        return codeLabo;
    }

    /**
     * @param codeLabo the codeLabo to set
     */
    public void setCodeLabo(int codeLabo) {
        this.codeLabo = codeLabo;
    }

    /**
     * @return the codeSecteur
     */
    public int getCodeSecteur() {
        return codeSecteur;
    }

    /**
     * @param codeSecteur the codeSecteur to set
     */
    public void setCodeSecteur(int codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    /**
     * @return the vNom
     */
    public String getvNom() {
        return vNom;
    }

    /**
     * @param vNom the vNom to set
     */
    public void setvNom(String vNom) {
        this.vNom = vNom;
    }

    /**
     * @return the vPrenom
     */
    public String getvPrenom() {
        return vPrenom;
    }

    /**
     * @param vPrenom the vPrenom to set
     */
    public void setvPrenom(String vPrenom) {
        this.vPrenom = vPrenom;
    }

    /**
     * @return the vAdresse
     */
    public String getvAdresse() {
        return vAdresse;
    }

    /**
     * @param vAdresse the vAdresse to set
     */
    public void setvAdresse(String vAdresse) {
        this.vAdresse = vAdresse;
    }

    /**
     * @return the vVille
     */
    public String getvVille() {
        return vVille;
    }

    /**
     * @param vVille the vVille to set
     */
    public void setvVille(String vVille) {
        this.vVille = vVille;
    }


    /**
     * @return the labo
     */
    public Labo getLabo() {
        return labo;
    }

    /**
     * @return the secteur
     */
    public Secteur getSecteur() {
        return secteur;
    }

    /**
     * @return the nbVisiteur
     */
    public int getNbVisiteur() {
        return nbVisiteur;
    }

    /**
     * @return the pourcentageVisiteurs
     */
    public float getPourcentageVisiteurs() {
        return pourcentageVisiteurs;
    }

    /**
     * @return the dateEmbauche
     */
    public String getDateEmbauche() {
        return dateEmbauche;
    }
    
    
}
