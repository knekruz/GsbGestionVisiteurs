/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Region;
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
public class ModelRegion extends AbstractTableModel
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
    
    public void loadDatasStatistiques(ArrayList<Region> lesRegions)
    {
        rows = new Vector<>();
        nomsColonnes = new String[]{"Nom de la Region", "Nombre de secteurs"};
        for (Region r : lesRegions)
        {
            rows.add(new String[]{r.getNomRegion(),String.valueOf(r.getNbSecteurParRegion())});
        }
        fireTableChanged(null);
    }
    
    public void loadDatasRegion(ArrayList<Region> lesRegions)
    {
        rows = new Vector<>();
        nomsColonnes = new String[]{"Numero region", "Nom de la Region", "Nom du Secteur"};
        for (Region r : lesRegions)
        {
            rows.add(new String[]{String.valueOf(r.getCodeRegion()),r.getNomRegion(), r.getSecteur().getNomSecteur()});
        }
        fireTableChanged(null);
    }
    
}