/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Labo;
import Entity.Region;
import Entity.Secteur;
import Entity.Travailler;
import Entity.Visiteurs;
import java.util.ArrayList;

/**
 *
 * @author JacquesBuffeteau
 */
public interface IMetier
{
public ArrayList<Visiteurs> getAllVisiteurs();
public ArrayList<Travailler> getAllTravailleurs();
public ArrayList<Region> getAllRegions();
public ArrayList<Secteur> getAllSecteurs();
public ArrayList<Labo> getAllLabos();

public void modifierAction(Visiteurs visiteur, int oldId, int labo, int secteur);
public int getIdLaboByName(String name);
public int getIdRegionByName(String name);
public int getIdSecteurByName(String name);
public int getLastIdRegion();
public void modifierRegion(String nom, int secteur, int id);

// Statistiques
public ArrayList<Region> getAllRegionsParNbSecteur();
public ArrayList<Visiteurs> getPourcentageVisiteurs();
public ArrayList<Region> getRegionAvecLePlusdeV();
public ArrayList<Region> getRegionAvecLeMoinsDeV();

public void insertVisiteur(Visiteurs visiteur, int idLabo, int idSecteur);
public void insertRegion(Region region, int idSecteur);
public void insertTravailler(int idMat, String date, int idRegion, String role);
//public String getRegionAvecLePlusDeV();
//public String getRegionAvecLeMoinsDeV();
}
