/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Visiteurs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.Vector;
import java.util.function.Function;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JacquesBuffeteau
 */
public class ModelVisiteur extends AbstractTableModel
{
    private String[] nomsColonnes;
    private Vector<String[]> rows;
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nomsColonnes[column];
    }
    
    public void loadDatasVisiteur(ArrayList<Visiteurs> lesVisiteurs)
    {
        rows = new Vector<>();
        nomsColonnes = new String[]{"Matricule", "Nom", "Prénom", "Adresse", "Code Postal", "Ville", "Date d'embauche", "Laboratoire", "Secteur"};
        for (Visiteurs v : lesVisiteurs)
        {
            rows.add(new String[]{String.valueOf(v.getvMat()), String.valueOf(v.getvNom()),
                v.getvPrenom(), v.getvAdresse(), String.valueOf(v.getvCp()), v.getvVille(), String.valueOf(v.getDateEmbauche()), v.getLabo().getNomLabo(), v.getSecteur().getNomSecteur()});
        }
        fireTableChanged(null);
    }
    public void loadDatasVisiteurRegions(ArrayList<Visiteurs> lesVisiteurs)
    {
        rows = new Vector<>();
        nomsColonnes = new String[]{"Matricule", "Nom", "Prénom"};
        for (Visiteurs v : lesVisiteurs)
        {
            rows.add(new String[]{String.valueOf(v.getvMat()), String.valueOf(v.getvNom()),
                v.getvPrenom()});
        }
        fireTableChanged(null);
    }
    
    public void loadDatasStatistiques(ArrayList<Visiteurs> lesVisiteurs)
    {
        rows = new Vector<>();
        nomsColonnes = new String[]{"Nom du secteur", "Nombre de visiteurs", "Pourcentage"};
        for (Visiteurs v : lesVisiteurs)
        {
            rows.add(new String[]{String.valueOf(v.getSecteur().getNomSecteur()),
                String.valueOf(v.getNbVisiteur()), String.valueOf(v.getPourcentageVisiteurs())});
        }
        fireTableChanged(null);
    }
    
}