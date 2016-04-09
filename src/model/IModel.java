/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * 
 */
public interface IModel {
    public List<Szemely> getSzemelyek() throws SQLException;
    public int updateSzemely(Szemely szemely) throws SQLException;
    public int removeSzemely(Szemely szemely) throws SQLException;
    public int addSzemely(Szemely szemely) throws SQLException;

    public List<Rendeles> getRendelesek() throws SQLException;
    public int updateRendeles(Rendeles rendeles) throws SQLException;
    public int removeRendeles(Rendeles rendeles) throws SQLException;
    public int addRendeles(Rendeles rendeles) throws SQLException;
}
