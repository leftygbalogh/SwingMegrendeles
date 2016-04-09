/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pepe
 */
public class DBModel implements IModel {
    private Connection conn;
    private PreparedStatement getSzemelyek;
    private PreparedStatement updateSzemelyek;
    private PreparedStatement removeSzemelyek;
    private PreparedStatement addSzemelyek;
    private PreparedStatement getRendelesek;
    private PreparedStatement updateRendelesek;
    private PreparedStatement removeRendelesek;
    private PreparedStatement addRendelesek;
    public DBModel(Connection conn) throws SQLException {
        this.conn = conn;
        getSzemelyek=conn.prepareStatement("SELECT * FROM szemely ORDER BY nev");
        updateSzemelyek=conn.prepareCall("UPDATE szemely SET nev=?,email=? WHERE id=?");
        removeSzemelyek=conn.prepareStatement("DELETE FROM szemely WHERE id=?");
        addSzemelyek=conn.prepareStatement("INSERT INTO szemely (nev, email) VALUES (?,?)");
        getRendelesek=conn.prepareStatement("SELECT * FROM rendeles ORDER BY rendeloid");
        updateRendelesek=conn.prepareStatement("UPDATE rendeles SET rendeloid=?, osszeg=?, darabszam=? WHERE id=?");
        removeRendelesek=conn.prepareStatement("DELETE FROM rendeles WHERE id=?");
        addRendelesek=conn.prepareStatement("INSERT INTO rendeles (rendeloid, osszeg, darabszam) VALUES (?,?,?)");
    }
    
    
    
    @Override
    public List<Szemely> getSzemelyek() throws SQLException {
        List<Szemely> szemelyek =new ArrayList<>();
        ResultSet rs = getSzemelyek.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nev = rs.getString("nev");
            String email = rs.getString("email");
            
            Szemely sz = new Szemely(id, nev, email);
            szemelyek.add(sz);
        }
        return szemelyek;
    }

    @Override
    public int updateSzemely(Szemely szemely) throws SQLException {
        updateSzemelyek.setString(1, szemely.getNev());
        updateSzemelyek.setString(2, szemely.getEmail());
        updateSzemelyek.setInt(3, szemely.getId());
        
        return updateSzemelyek.executeUpdate();
    }

    @Override
    public int removeSzemely(Szemely szemely) throws SQLException {
        removeSzemelyek.setInt(1, szemely.getId());
        return removeSzemelyek.executeUpdate();
    }

    @Override
    public int addSzemely(Szemely szemely) throws SQLException {
        addSzemelyek.setString(1, szemely.getNev());
        addSzemelyek.setString(2, szemely.getEmail());
        return addSzemelyek.executeUpdate();
    }

    @Override
    public List<Rendeles> getRendelesek() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRendeles(Rendeles rendeles) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeRendeles(Rendeles rendeles) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addRendeles(Rendeles rendeles) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
