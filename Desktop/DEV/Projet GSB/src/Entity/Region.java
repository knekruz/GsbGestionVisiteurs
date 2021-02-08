/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author kayum
 */
public class Region {
    
    private int codeRegion, codeSecteur, nbSecteurParRegion;
    private String nomRegion;
    private Secteur secteur;

    public Region(int codeRegion,String nomRegion, Secteur secteur) {
        this.codeRegion = codeRegion;
        this.secteur = secteur;
        this.nomRegion = nomRegion;
    }

    public Region(String nomRegion, int nbSecteurParRegion) {
        this.nbSecteurParRegion = nbSecteurParRegion;
        this.nomRegion = nomRegion;
    }

    public Region(int codeRegion, String nomRegion) {
        this.nomRegion = nomRegion;
        this.codeRegion = codeRegion;
    }
    
    

    /**
     * @return the codeRegion
     */
    public int getCodeRegion() {
        return codeRegion;
    }

    /**
     * @return the codeSecteur
     */
    public int getCodeSecteur() {
        return codeSecteur;
    }

    /**
     * @return the nomRegion
     */
    public String getNomRegion() {
        return nomRegion;
    }

    /**
     * @return the nbSecteurParRegion
     */
    public int getNbSecteurParRegion() {
        return nbSecteurParRegion;
    }

    /**
     * @return the secteur
     */
    public Secteur getSecteur() {
        return secteur;
    }
    
    
}
