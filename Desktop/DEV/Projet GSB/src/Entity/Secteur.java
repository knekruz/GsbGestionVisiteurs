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
public class Secteur {
    
    private int codeSecteur;
    private String nomSecteur;

    public Secteur(int codeSecteur, String nomSecteur) {
        this.nomSecteur = nomSecteur;
        this.codeSecteur = codeSecteur;
    }

    public Secteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }
    
    
    

    /**
     * @return the codeSecteur
     */
    public int getCodeSecteur() {
        return codeSecteur;
    }

    /**
     * @return the nomSecteur
     */
    public String getNomSecteur() {
        return nomSecteur;
    }
    
    
}
