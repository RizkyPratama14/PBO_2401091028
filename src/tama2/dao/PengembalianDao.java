/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tama2.dao;

import tama2.model.Peminjaman;
import tama2.model.Pengembalian;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class PengembalianDao {
    public void insert(Pengembalian pengembalian) throws Exception {
        Peminjaman peminjaman = pengembalian.getPeminjaman();
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "INSERT INTO pengembalian (kode_anggota, kode_buku, tgl_pinjam, tgl_dikembalikan, terlambat, denda) "
                + "VALUES (?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKode());
        ps.setString(2, peminjaman.getBuku().getKode());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
        ps.setLong(6, pengembalian.getDenda());
        ps.executeUpdate();
    }
    
    public void update(Pengembalian pengembalian) throws Exception{
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "update pengembalian set tgl_dikembalikan=?, terlambat=?, denda=? where id_pengembalian=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getTgldikembalikan());
        ps.setInt(2, pengembalian.getTerlambat());
        ps.setLong(3, pengembalian.getDenda());
        ps.setInt(4, (int) pengembalian.getId());
        
        
        ps.executeUpdate();
    }
    
    public void delete(Pengembalian pengembalian) throws Exception {
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "delete from pengembalian where id_pengembalian=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, (int) pengembalian.getId());
        

        ps.executeUpdate();
    }
    
    public Pengembalian getPengembalian(int idPengembalian) throws Exception{
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "select * from pengembalian"
                + " where id_pengembalian=? ";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPengembalian);
        ResultSet rs = ps.executeQuery();
        
        Pengembalian pengembalian = null;
        PeminjamanDao peminjamanDao = new PeminjamanDao();
        
        if(rs.next()){
            pengembalian = new Pengembalian();
            pengembalian.setId(idPengembalian);
            
            String kodeAnggota = rs.getString(2);
            String kodeBuku = rs.getString(3);
            String tglPinjam = rs.getString(4);
            
            
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(kodeAnggota, kodeBuku, tglPinjam);
            pengembalian.setPeminjaman(peminjaman);
            pengembalian.setTgldikembalikan(rs.getString(5));
            pengembalian.setTerlambat(rs.getInt(6));
            pengembalian.setDenda((int) rs.getLong(7));
        }
        
        return pengembalian;
        
    }
    
    
    public List<Pengembalian> getAll() throws Exception{
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "select * from pengembalian";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        PeminjamanDao peminjamanDao = new PeminjamanDao();
        
        List<Pengembalian> pengembalianAll = new ArrayList<>();
        while (rs.next()) {
            pengembalian = new Pengembalian();
            pengembalian.setId(rs.getInt(1));
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(rs.getString(2), rs.getString(3), rs.getString(4));
            pengembalian.setPeminjaman(peminjaman);
            pengembalian.setTgldikembalikan(rs.getString(5));
            pengembalian.setTerlambat(rs.getInt(6));
            pengembalian.setDenda((int) rs.getLong(7));
            pengembalianAll.add(pengembalian);
        }
        return pengembalianAll;
    }
    
    
    public int getKurangTanggal(String tgl1, String tgl2) throws SQLException, Exception{
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "select datediff(?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tgl1);
        ps.setString(2, tgl2);
        
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
          
    }
}
