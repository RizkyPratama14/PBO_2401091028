/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ervan.dao;

import ervan.model.Anggota;
import ervan.model.Buku;
import ervan.model.Peminjaman;
import ervan.model.Pengembalian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labor p1
 */
public class PengembalianDao {

    public void insert(Pengembalian pengembalian) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "insert into pengembalian values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getPeminjaman().getAnggota().getKodeanggota());
        ps.setString(2, pengembalian.getPeminjaman().getBuku().getKode());
        ps.setString(3, pengembalian.getPeminjaman().getTglpinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
        ps.setInt(6, pengembalian.getDenda());
        ps.executeUpdate();
    }

    public void update(Pengembalian pengembalian) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql
                = "update peminjaman set tgldikembalikan=?, terlambat=?, denda=? where kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getTgldikembalikan());
        ps.setInt(2, pengembalian.getTerlambat());
        ps.setInt(3, pengembalian.getDenda());
        ps.setString(4, pengembalian.getPeminjaman().getAnggota().getKodeanggota());
        ps.setString(5, pengembalian.getPeminjaman().getBuku().getKode());
        ps.setString(6, pengembalian.getPeminjaman().getTglpinjam());
        ps.executeUpdate();
    }

    public void delete(Pengembalian pengembalian) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "delete from pengembalian where kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getPeminjaman().getAnggota().getKodeanggota());
        ps.setString(2, pengembalian.getPeminjaman().getBuku().getKode());
        ps.setString(3, pengembalian.getPeminjaman().getTglpinjam());
        ps.executeUpdate();
    }

    public Pengembalian getPengembalian(String kodeanggota, String kodebuku, String tglpinjam) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from pengembalian "
                + "where kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        PeminjamanDao peminjamanDao = new PeminjamanDao();
        if (rs.next()) {
            pengembalian = new Pengembalian();
            Peminjaman peminjaman = peminjamanDao
                .getPeminjaman(rs.getString(1), rs.getString(2), rs.getString(3));
            pengembalian.setPeminjaman(peminjaman);
            pengembalian.setTgldikembalikan(rs.getString(4));
            pengembalian.setTerlambat(rs.getInt(4));
            pengembalian.setDenda(rs.getInt(5));
        }
        return pengembalian;
    }

    public List<Pengembalian> getAllPengembalian() throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from pengembalian";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pengembalian> pengembalianList = new ArrayList<>();
        Pengembalian pengembalian = null;
        PeminjamanDao peminjamanDao = new PeminjamanDao();
        while (rs.next()) {
            pengembalian = new Pengembalian();
            Peminjaman peminjaman = peminjamanDao
                 .getPeminjaman(rs.getString(1), rs.getString(2), rs.getString(3));
            pengembalian.setPeminjaman(peminjaman);
            pengembalian.setTgldikembalikan(rs.getString(4));
            pengembalian.setTerlambat(rs.getInt(4));
            pengembalian.setDenda(rs.getInt(5));
            pengembalianList.add(pengembalian);
        }
        return pengembalianList;
    }
}
