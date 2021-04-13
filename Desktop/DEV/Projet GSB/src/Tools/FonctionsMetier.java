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
import Tools.IMetier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JacquesBuffeteau
 */
public class FonctionsMetier implements IMetier
{    

    @Override
    public ArrayList<Visiteurs> getAllVisiteurs() {
        
        ArrayList<Visiteurs> lesVisiteurs = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select  vnom, vprenom, vadresse, vcp, vville, vdatemb, "
                    + "nomlabo, libsecteur, vmat from visiteur v, labo l, secteur s where l.codelabo = v.codelabo "
                    + "and s.codesecteur = v.codesecteur order by (vmat) ASC");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Labo l = new Labo(rs.getString(7));
                Secteur s = new Secteur(rs.getString(8));
                Visiteurs a = new Visiteurs(rs.getInt(9), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), l, s);
                lesVisiteurs.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVisiteurs;
    }
    
    @Override
    public ArrayList<Visiteurs> getPourcentageVisiteurs() {
        
        ArrayList<Visiteurs> lesVisiteurs = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT S.libsecteur, COUNT(A.codesecteur) AS Somme, "
                    + "(100 - COUNT(A.codesecteur)*100/T.nombreVisiteur) AS Pourcentage FROM visiteur A, secteur S, "
                    + "(SELECT COUNT(*) AS nombreVisiteur FROM visiteur) AS T where S.codesecteur = A.codesecteur GROUP BY A.codesecteur");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Secteur s = new Secteur(rs.getString(1));
                Visiteurs a = new Visiteurs(s, rs.getInt(2), rs.getFloat(3));
                lesVisiteurs.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVisiteurs;
    }
    
    @Override
    public ArrayList<Region> getAllRegions() {
        
        ArrayList<Region> lesRegions = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT coderegion, nomregion, s.libsecteur from region r, secteur s where r.codesecteur = s.codesecteur");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Secteur s = new Secteur(rs.getString(3));
                Region r = new Region(rs.getInt(1), rs.getString(2), s);
                lesRegions.add(r);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesRegions;
    }
    
    @Override
    public ArrayList<Secteur> getAllSecteurs() {
        
        ArrayList<Secteur> lesSecteurs = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select * from secteur");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Secteur s = new Secteur(rs.getInt(1), rs.getString(2));
                lesSecteurs.add(s);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesSecteurs;
    }

   
    @Override
    public ArrayList<Labo> getAllLabos() {
        
        ArrayList<Labo> lesLabos = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select * from labo");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Labo l = new Labo(rs.getInt(1), rs.getString(2), rs.getString(2));
                lesLabos.add(l);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesLabos;
    }

   @Override
    public void insertVisiteur(Visiteurs visiteur, int idLabo, int idSecteur) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into visiteur (vnom,vprenom,vadresse,vcp,vville,vdatemb,codelabo,codesecteur) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, visiteur.getvNom());
            ps.setString(2, visiteur.getvPrenom());
            ps.setString(3, visiteur.getvAdresse());
            ps.setInt(4, visiteur.getvCp());
            ps.setString(5, visiteur.getvVille());
            ps.setString(6, visiteur.getDateEmbauche());
            ps.setInt(7, idLabo);
            ps.setInt(8, idSecteur);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modifierAction(Visiteurs visiteur, int oldId, int labo, int secteur) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update visiteur set vnom = ?, vprenom = ?, vadresse = ?, vcp = ?, vville = ?, vdatemb = ?, codelabo = ?, codesecteur = ? where vmat = ?");
            ps.setString(1, visiteur.getvNom());
            ps.setString(2, visiteur.getvPrenom());
            ps.setString(3, visiteur.getvAdresse());
            ps.setInt(4, visiteur.getvCp());
            ps.setString(5, visiteur.getvVille());
            ps.setString(6, visiteur.getDateEmbauche());
            ps.setInt(7, labo);
            ps.setInt(8, secteur);
            ps.setInt(9, oldId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modifierRegion(String nom, int secteur, int id) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update region set codesecteur = ?, nomregion = ? where coderegion = ?");
            ps.setInt(1, secteur);
            ps.setString(2, nom);
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Override
    public void insertRegion(Region region, int idSecteur) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into region (coderegion, codesecteur, nomregion) values (?,?,?)");
            ps.setInt(1, region.getCodeRegion());
            ps.setInt(2, idSecteur);
            ps.setString(3, region.getNomRegion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insertTravailler(int idMat, String date, int idRegion, String role) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into travailler (vmat, date, coderegion,role) values (?,?,?,?)");
            ps.setInt(1, idMat);
            ps.setString(2, date);
            ps.setInt(3, idRegion);
            ps.setString(4, role);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getIdLaboByName(String name){
        int laboId = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select codelabo from labo where nomlabo = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            laboId = rs.getInt(1);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laboId;
    }
    
    public int getIdRegionByName(String name){
        int laboId = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select coderegion from region where nomregion = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            laboId = rs.getInt(1);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laboId;
    }
    
    
    public int getLastIdRegion(){
        int lastId = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select max(coderegion) as num from region");
            ResultSet rs = ps.executeQuery();
            rs.next();
            lastId = rs.getInt("num") + 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
    
    public int getIdSecteurByName(String name){
        int laboId = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select codesecteur from secteur where libsecteur = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            laboId = rs.getInt(1);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laboId;
    }
    
    
    public ArrayList<Region> getAllRegionsParNbSecteur(){
    
    ArrayList<Region> lesRegions = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select nomregion, count(codesecteur) as nbsecteurparregion FROM region GROUP BY nomregion");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Region r = new Region(rs.getString(1), rs.getInt(2));
                lesRegions.add(r);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesRegions;
    }
    
    public ArrayList<Region> getRegionAvecLePlusdeV(){
    
    ArrayList<Region> laRegionAveclePlusdeVisiteur = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT r.nomregion, COUNT(*) FROM region r, travailler t WHERE r.coderegion = t.coderegion GROUP BY r.nomregion having count(*) >= ALL (SELECT COUNT(*) FROM region r, travailler t WHERE r.coderegion = t.coderegion GROUP BY r.nomregion) ");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Region r = new Region(rs.getString(1));
                laRegionAveclePlusdeVisiteur.add(r);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laRegionAveclePlusdeVisiteur;
    }
    
    public ArrayList<Region> getRegionAvecLeMoinsDeV(){
    
    ArrayList<Region> laRegionAvecleMoinsdeVisiteur = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT r.nomregion, COUNT(*) FROM region r, travailler t WHERE r.coderegion = t.coderegion GROUP BY r.nomregion having count(*) <= ALL (SELECT COUNT(*) FROM region r, travailler t WHERE r.coderegion = t.coderegion GROUP BY r.nomregion) ");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Region r = new Region(rs.getString(1));
                laRegionAvecleMoinsdeVisiteur.add(r);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laRegionAvecleMoinsdeVisiteur;
    }
    

    @Override
    public ArrayList<Travailler> getAllTravailleurs() {
        
        ArrayList<Travailler> lesTravailleurs = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT v.vmat, vnom, vprenom, t.date, r.nomregion, role "
                    + "FROM region r, travailler t, visiteur v "
                    + "WHERE v.vmat = t.vmat "
                    + "AND t.coderegion = r.coderegion order by (vmat) ASC");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Visiteurs v = new Visiteurs(rs.getInt(1),rs.getString(2),rs.getString(3));
                Region r = new Region(rs.getString(5));
                Travailler t = new Travailler(rs.getDate(4), rs.getString(6), v, r);
                lesTravailleurs.add(t);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTravailleurs;
    }

    
    }
   

