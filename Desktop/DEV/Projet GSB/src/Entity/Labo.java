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
public class Labo {
    
    private int codeLabo;
    private String nomLabo, chefLabo;

    public Labo(String nomLabo) {
        this.nomLabo = nomLabo;
    }

    public Labo(int codeLabo, String nomLabo, String chefLabo) {
        this.codeLabo = codeLabo;
        this.nomLabo = nomLabo;
        this.chefLabo = chefLabo;
    }
    
    
    
    /**
     * @return the codeLabo
     */
    public int getCodeLabo() {
        return codeLabo;
    }

    /**
     * @return the nomLabo
     */
    public String getNomLabo() {
        return nomLabo;
    }

    /**
     * @return the chefLabo
     */
    public String getChefLabo() {
        return chefLabo;
    }
    
    
}
