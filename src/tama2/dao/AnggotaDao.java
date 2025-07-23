/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tama2.dao;

import tama2.model.Anggota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labor p1
 */
public class AnggotaDao {
    public void insert(Anggota anggota) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "insert into anggota values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKode());
        ps.setString(2, anggota.getNama());
        ps.setString(3, anggota.getAlamat());
        ps.setString(4, anggota.getJekel());
        ps.executeUpdate();
    }
    
    public void update(Anggota anggota) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = 
           "update anggota set nama=?, alamat=?, jekel=? where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getNama());
        ps.setString(2, anggota.getAlamat());
        ps.setString(3, anggota.getJekel());
        ps.setString(4, anggota.getKode());
        ps.executeUpdate();
    }
    
    public void delete(Anggota anggota) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "delete from anggota where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKode());
        ps.executeUpdate();
    }
    
    public Anggota getAnggota(String kodeanggota) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from anggota where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ResultSet rs = ps.executeQuery();
        Anggota anggota = null;
        if(rs.next()){
            anggota = new Anggota();
            anggota.setKode(rs.getString(1));
            anggota.setNama(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJekel(rs.getString(4));
        }
        return anggota;
    }
    
    public List<Anggota> getAllAnggota() throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from anggota";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Anggota> anggotaList = new ArrayList<>();
        Anggota anggota;
        while(rs.next()){
            anggota = new Anggota();
            anggota.setKode(rs.getString(1));
            anggota.setNama(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJekel(rs.getString(4));
            anggotaList.add(anggota);
        }
        return anggotaList;
    }
    
    
    
}
