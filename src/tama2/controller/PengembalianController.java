/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tama2.controller;

import tama2.dao.AnggotaDao;
import tama2.dao.BukuDao;
import tama2.dao.PeminjamanDao;
import tama2.dao.PengembalianDao;
import tama2.model.Anggota;
import tama2.model.Buku;
import tama2.model.Peminjaman;
import tama2.model.Pengembalian;
import tama2.view.FormPengembalian;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS
 */
public class PengembalianController {

    private FormPengembalian formPengembalian;
    private Pengembalian pengembalian;
    private Peminjaman peminjaman;
    private PengembalianDao dao;
    private PeminjamanDao peminjamanDao;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;

    public PengembalianController(FormPengembalian formPengembalian) {
        this.formPengembalian = formPengembalian;
        dao = new PengembalianDao();
        peminjamanDao = new PeminjamanDao();
        anggotaDao = new AnggotaDao();
        bukuDao = new BukuDao();
    }

    public void clearScreen() {
        anggotaCodeOption();
        bukuCodeOption();
        formPengembalian.getFieldId().setText("");
        formPengembalian.getFieldTglPinjam().setText("");
        formPengembalian.getFieldTglKembali().setText("");
        formPengembalian.getFieldTgldikembalikan().setText("");
        formPengembalian.getFieldTerlambat().setText("");
        formPengembalian.getFieldDenda().setText("");
    }

    public void insert() {
        try {
            pengembalian = new Pengembalian();

            String kodeAnggota = formPengembalian.getOptionKodeAnggota()
                    .getSelectedItem().toString().split("-")[0];
            String kodeBuku = formPengembalian.getOptionKodeBuku()
                    .getSelectedItem().toString();

            Anggota anggota = anggotaDao.getAnggota(kodeAnggota);
            Buku buku = bukuDao.getBuku(kodeBuku);

            Peminjaman pinjam = new Peminjaman();

            pinjam.setAnggota(anggota);
            pinjam.setBuku(buku);
            pinjam.setTglpinjam(formPengembalian.getFieldTglPinjam().getText());

            pengembalian.setPeminjaman(pinjam);

            pengembalian.setTgldikembalikan(formPengembalian.getFieldTgldikembalikan().getText());
            pengembalian.setTerlambat(Integer.parseInt(formPengembalian.getFieldTerlambat().getText()));
            pengembalian.setDenda((int) Long.parseLong(formPengembalian.getFieldDenda().getText()));

            dao.insert(pengembalian);

        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(formPengembalian, "Gagal menyimpan data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void update() {
        try {
            int idPengembalian = Integer.parseInt(formPengembalian.getFieldId().getText());
            pengembalian.setId(idPengembalian);
            
            
            String kodeAnggota = formPengembalian.getOptionKodeAnggota()
                    .getSelectedItem().toString().split("-")[0];
            String kodeBuku = formPengembalian.getOptionKodeBuku()
                    .getSelectedItem().toString();
            
            Anggota anggota = anggotaDao.getAnggota(kodeAnggota);
            Buku buku = bukuDao.getBuku(kodeBuku);
            
            Peminjaman pinjam = new Peminjaman();
            
            pinjam.setAnggota(anggota);
            pinjam.setBuku(buku);
            pinjam.setTglpinjam(formPengembalian.getFieldTglPinjam().getText());

            pengembalian.setPeminjaman(pinjam);

            pengembalian.setTgldikembalikan(formPengembalian.getFieldTgldikembalikan().getText());
            pengembalian.setTerlambat(Integer.parseInt(formPengembalian.getFieldTerlambat().getText()));
            pengembalian.setDenda((int) Long.parseLong(formPengembalian.getFieldDenda().getText()));
            
            try {
                dao.update(pengembalian);
                JOptionPane.showMessageDialog(formPengembalian, "Update Data Ok!");
            } catch (Exception ex) {
                Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        try {
            String idPengembalian = formPengembalian.getFieldId().getText();

            int id = Integer.parseInt(idPengembalian);
            Pengembalian pengembalian = new Pengembalian();
            pengembalian.setId(id);

            if (pengembalian != null) {
                dao.delete(pengembalian);
            } else {
                JOptionPane.showMessageDialog(formPengembalian, "Data Not Found");
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void anggotaCodeOption() {
        try {
            List<Anggota> anggotaList = anggotaDao.getAllAnggota();
            formPengembalian.getOptionKodeAnggota().removeAllItems();
            for (Anggota anggota : anggotaList) {
                formPengembalian.getOptionKodeAnggota().addItem(anggota.getKode() + "-" + anggota.getNama());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bukuCodeOption() {
        try {
            List<Buku> bukuList = bukuDao.getAllBuku();
            formPengembalian.getOptionKodeBuku().removeAllItems();
            for (Buku buku : bukuList) {
                formPengembalian.getOptionKodeBuku().addItem(buku.getKode());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchPeminjaman() {
        String kodeAnggota = formPengembalian.getOptionKodeAnggota()
                .getSelectedItem().toString().split("-")[0];
        String kodeBuku = formPengembalian.getOptionKodeBuku().getSelectedItem().toString();
        String tglPinjam = formPengembalian.getFieldTglPinjam().getText();

        try {
            peminjaman = peminjamanDao.getPeminjaman(kodeAnggota, kodeBuku, tglPinjam);

            if (peminjaman != null) {
                formPengembalian.getFieldTglKembali().setText(peminjaman.getTglkembali());
            } else {
                JOptionPane.showMessageDialog(formPengembalian, "Data Not Found!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchPengembalian() {
        int idPengembalian = Integer.parseInt(formPengembalian.getFieldId().getText());

        try {
            pengembalian = dao.getPengembalian(idPengembalian);

            if (pengembalian != null) {
                formPengembalian.getOptionKodeAnggota().setSelectedItem(
                        pengembalian.getPeminjaman().getAnggota().getKode() + "-" + 
                                pengembalian.getPeminjaman().getAnggota().getNama()
                );
                formPengembalian.getOptionKodeBuku().setSelectedItem(
                        pengembalian.getPeminjaman().getBuku().getKode()
                );
                formPengembalian.getFieldTglPinjam().setText(pengembalian.getPeminjaman().getTglpinjam());
                formPengembalian.getFieldTglKembali().setText(pengembalian.getPeminjaman().getTglkembali());
                formPengembalian.getFieldTgldikembalikan().setText(pengembalian.getTgldikembalikan());
                formPengembalian.getFieldTerlambat().setText(String.valueOf(pengembalian.getTerlambat()));
                formPengembalian.getFieldDenda().setText(String.valueOf(pengembalian.getDenda()));
            } else {
                JOptionPane.showMessageDialog(formPengembalian, "Data Not Found");
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void proses() {
        String tglKembali = formPengembalian.getFieldTglKembali().getText();
        String tglDikembalikan = formPengembalian.getFieldTgldikembalikan().getText();

        try {
            int hasil = dao.getKurangTanggal(tglDikembalikan, tglKembali);

            pengembalian = new Pengembalian();
            pengembalian.setPeminjaman(peminjaman);
            pengembalian.setTerlambat(hasil);
            pengembalian.setDenda(pengembalian.getDenda());
            formPengembalian.getFieldTerlambat().setText("" + hasil);
            formPengembalian.getFieldDenda().setText("" + pengembalian.getDenda());
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewData() {

        try {
            DefaultTableModel model = (DefaultTableModel) formPengembalian.getTabelPengembalian().getModel();

            model.setNumRows(0);
            List<Pengembalian> list = dao.getAllPengembalian();
            for (Pengembalian pengembalian : list) {
                Object[] data = {
                    pengembalian.getId(),
                    pengembalian.getPeminjaman().getAnggota().getNama(),
                    pengembalian.getPeminjaman().getBuku().getJudul(),
                    pengembalian.getPeminjaman().getTglpinjam(),
                    pengembalian.getPeminjaman().getTglkembali(),
                    pengembalian.getTgldikembalikan(),
                    pengembalian.getTerlambat(),
                    pengembalian.getDenda()
                };
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
