/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Region;
import Entity.Travailler;
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
public class ModelTravailler extends AbstractTableModel
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
    
    public void loadDatas(ArrayList<Travailler> lesTravailleurs)
    {
        rows = new Vector<>();
        nomsColonnes = new String[]{"Matricule", "Nom", "Prénom", "Date", "Région", "Rôle"};
        for (Travailler t : lesTravailleurs)
        {
            rows.add(new String[]{String.valueOf(t.getVisiteur().getvMat()),t.getVisiteur().getvNom(), t.getVisiteur().getvPrenom(), String.valueOf(t.getDateEmbauche()), t.getRegion().getNomRegion(), t.getRole()});
        }
        fireTableChanged(null);
    }
    
}