/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tama2.dao;

import tama2.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labor p1
 */
public class BukuDao {
    public void insert(Buku buku) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "insert into buku values(?,?,?,?,5)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKode());
        ps.setString(2, buku.getJudul());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.setInt(5, buku.getTahun());
        ps.executeUpdate();
    }
    
    public void update(Buku buku) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = 
           "update buku set judul=?, pengarang=?, penerbit=?, tahun=? where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getJudul());
        ps.setString(2, buku.getPengarang());
        ps.setString(3, buku.getPenerbit());
        ps.setInt(4, buku.getTahun());
        ps.setString(5, buku.getKode());
        ps.executeUpdate();
    }
    
    public void delete(Buku buku) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "delete from buku where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKode());
        ps.executeUpdate();
    }
    
    public Buku getBuku(String kode) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from buku where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Buku buku = null;
        if(rs.next()){
            buku = new Buku();
            buku.setKode(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            buku.setTahun(rs.getInt(5));
        }
        return buku;
    }
    
    public List<Buku> getAllBuku() throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from buku";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Buku> anggotaList = new ArrayList<>();
        Buku buku;
        while(rs.next()){
            buku = new Buku();
            buku.setKode(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            buku.setTahun(rs.getInt(5));
            anggotaList.add(buku);
        }
        return anggotaList;
    }
}
