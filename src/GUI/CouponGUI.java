/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CouponBUS;
import BUS.CouponDetailBUS;
import DAL.CouponDAL;
import DAL.CouponDetailDAL;
import DTO.CouponDTO;
import DTO.CouponDetailDTO;
import Export.ExportExcel;
import Export.ImportExcel;
import Export.WritePDF;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoangtuan
 */
public class CouponGUI extends javax.swing.JPanel {

    DefaultTableModel dftCoupon;
    DefaultTableModel dftCouponDetail;
    private CouponBUS couponBUS = new CouponBUS();
     private CouponDetailBUS couponDetailBUS= new CouponDetailBUS();
    /**
     * Creates new form CouponGUI
     */
    public CouponGUI() {
        initComponents();
        dftCoupon = (DefaultTableModel) tbCoupon.getModel();
        dftCouponDetail = (DefaultTableModel) tbCouponDetail.getModel();
        loadCoupon();
        loadCouponDetail();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        txtSupplierId = new javax.swing.JTextField();
        dateChooserImport = new com.toedter.calendar.JDateChooser();
        btnAddCoupon = new javax.swing.JButton();
        btnDeleteCoupon = new javax.swing.JButton();
        btnEditCoupon = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnClickStaffId = new javax.swing.JButton();
        btnSupplierId = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCouponId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCoupon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSearchCoupon = new javax.swing.JTextField();
        btnSearchCoupon = new javax.swing.JButton();
        btnPrintPDF = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBookIdCoupon = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnSelectBookId = new javax.swing.JButton();
        btnAddCouponDetail = new javax.swing.JButton();
        btnEditCouponDetail = new javax.swing.JButton();
        btnDeleteCouponDetal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCouponDetail = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu Nhập"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mã Nhân Viên");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel2.setText("Mã NCC");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 105, -1, -1));

        jLabel3.setText("Ngày Nhập");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 139, -1, -1));
        jPanel1.add(txtStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 144, -1));

        txtSupplierId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtSupplierId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 144, -1));
        jPanel1.add(dateChooserImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, -1));

        btnAddCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11_add.png"))); // NOI18N
        btnAddCoupon.setText("Thêm ");
        btnAddCoupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCouponActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddCoupon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnDeleteCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/14_delete.png"))); // NOI18N
        btnDeleteCoupon.setText("Xóa");
        btnDeleteCoupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCouponActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteCoupon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        btnEditCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/15_update.png"))); // NOI18N
        btnEditCoupon.setText("Sửa");
        btnEditCoupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCouponActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditCoupon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/13_reset.png"))); // NOI18N
        jButton4.setText("Tải Lại");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 90, -1));

        btnClickStaffId.setText("Chọn");
        btnClickStaffId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickStaffIdActionPerformed(evt);
            }
        });
        jPanel1.add(btnClickStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        btnSupplierId.setText("Chọn");
        btnSupplierId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierIdActionPerformed(evt);
            }
        });
        jPanel1.add(btnSupplierId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        jLabel8.setText("Mã Phiếu Nhập");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        jPanel1.add(txtCouponId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 140, -1));

        tbCoupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã NV", "Mã NCC", "Ngày Mượn"
            }
        ));
        tbCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCouponMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCoupon);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Tìm Kiếm");

        btnSearchCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/12_search.png"))); // NOI18N
        btnSearchCoupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCouponActionPerformed(evt);
            }
        });

        btnPrintPDF.setText("In PDF");
        btnPrintPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintPDFActionPerformed(evt);
            }
        });

        jButton9.setText("Xuất Excel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Nhập Excel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addComponent(txtSearchCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnPrintPDF)
                .addGap(49, 49, 49)
                .addComponent(jButton9)
                .addGap(41, 41, 41)
                .addComponent(jButton10)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSearchCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrintPDF)
                            .addComponent(jButton9)
                            .addComponent(jButton10)))
                    .addComponent(btnSearchCoupon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Phiếu Nhập"));

        jLabel5.setText("Mã Sách");

        jLabel6.setText("Giá Nhập");

        jLabel7.setText("Số Lượng");

        txtBookIdCoupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIdCouponActionPerformed(evt);
            }
        });

        btnSelectBookId.setText("Chọn");
        btnSelectBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectBookIdActionPerformed(evt);
            }
        });

        btnAddCouponDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11_add.png"))); // NOI18N
        btnAddCouponDetail.setText("Thêm ");
        btnAddCouponDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCouponDetailActionPerformed(evt);
            }
        });

        btnEditCouponDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/15_update.png"))); // NOI18N
        btnEditCouponDetail.setText("Sửa");
        btnEditCouponDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCouponDetailActionPerformed(evt);
            }
        });

        btnDeleteCouponDetal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/14_delete.png"))); // NOI18N
        btnDeleteCouponDetal.setText("Xóa");
        btnDeleteCouponDetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCouponDetalActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/13_reset.png"))); // NOI18N
        jButton1.setText("Tải lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteCouponDetal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddCouponDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditCouponDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(23, 23, 23)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(27, 27, 27)
                                    .addComponent(txtBookIdCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectBookId)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBookIdCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectBookId))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCouponDetail)
                    .addComponent(btnEditCouponDetail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteCouponDetal)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        tbCouponDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã CTPN", "Mã PN", "Mã Sách", "Giá Nhập", "Số Lượng", "Thành Tiền"
            }
        ));
        tbCouponDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCouponDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCouponDetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSupplierIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierIdActionPerformed

    private void txtBookIdCouponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIdCouponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIdCouponActionPerformed

    private void btnAddCouponDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCouponDetailActionPerformed
        if (txtBookIdCoupon.getText().isEmpty()) {
            thongbao("Mã sách");
            return;
        }
        if (!isNumber(txtQuantity.getText())) {
            JOptionPane.showMessageDialog(null, "Số lượng phải nhập số");
            return;
        }
        if (txtQuantity.getText().isEmpty()) {
            thongbao("Số lượng");
            return;
        }
        if (!isNumber(txtPrice.getText())) {
            JOptionPane.showMessageDialog(null, "Giá nhập phải là số");
            return;
        }
        if (txtPrice.getText().isEmpty()) {
            thongbao("Giá nhập");
            return;
        }

        int masach = Integer.parseInt(txtBookIdCoupon.getText());
        int sl = Integer.parseInt(txtQuantity.getText());
        int gia = Integer.parseInt(txtPrice.getText());
        CouponDetailDTO ct = new CouponDetailDTO(0, Integer.parseInt(txtCouponId.getText()), masach, gia, sl, sl * gia);
        int j = couponDetailBUS.addCouponDetail(ct);
        if (j > 0) {
            loadCouponDetail();
        }
    }//GEN-LAST:event_btnAddCouponDetailActionPerformed

    private void btnDeleteCouponDetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCouponDetalActionPerformed
        int i = tbCouponDetail.getSelectedRow();
        if (i >= 0) {

            int masach = Integer.parseInt(txtBookIdCoupon.getText());
            int sl = Integer.parseInt(txtQuantity.getText());
            int gia = Integer.parseInt(txtPrice.getText());
            int mactpn = Integer.parseInt(dftCouponDetail.getValueAt(i, 0).toString());
            int mapn = Integer.parseInt(dftCouponDetail.getValueAt(i, 1).toString());
            CouponDetailDTO ct = new CouponDetailDTO(mactpn, mapn, masach, gia, sl, sl * gia);
            int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá", "", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int j = couponDetailBUS.deleteCouponDetail(ct);
                if (j > 0) {
                    loadCouponDetail();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn vào table");
        }
    }//GEN-LAST:event_btnDeleteCouponDetalActionPerformed

    private void btnAddCouponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCouponActionPerformed
        if (txtStaffId.getText().isEmpty()) {
            thongbao("Mã nhân viên");
            return;
        }
        if (txtSupplierId.getText().isEmpty()) {
            thongbao("Mã NCC");
            return;
        }
        if (dateChooserImport.getDate() == null) {
            thongbao("Ngày Nhập");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngaynhap = sdf.format(dateChooserImport.getDate());
        int Manv = Integer.parseInt(txtStaffId.getText());
        int Mancc = Integer.parseInt(txtSupplierId.getText());
        CouponDTO pn = new CouponDTO(0, Mancc, Manv, ngaynhap);
        int j = couponBUS.addCoupon(pn);
        if (j > 0) {
            loadCoupon();
        }
    }//GEN-LAST:event_btnAddCouponActionPerformed

    private void btnDeleteCouponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCouponActionPerformed
        int i = tbCoupon.getSelectedRow();
        if (i >= 0) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int vitri = Integer.parseInt(dftCoupon.getValueAt(i, 0).toString());
            String ngaynhap = sdf.format(dateChooserImport.getDate());
            int Manv = Integer.parseInt(txtStaffId.getText());
            int Mancc = Integer.parseInt(txtSupplierId.getText());
            CouponDTO pn = new CouponDTO(vitri, Mancc, Manv, ngaynhap);
            int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá", "", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int j = couponBUS.deleteCoupon(pn);
                if (j > 0) {
                    loadCoupon();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn vào table");
        }
    }//GEN-LAST:event_btnDeleteCouponActionPerformed

    private void btnEditCouponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCouponActionPerformed
        int i = tbCoupon.getSelectedRow();
        if (i >= 0) {
            if (txtStaffId.getText().isEmpty()) {
                thongbao("Mã nhân viên");
                return;
            }
            if (txtSupplierId.getText().isEmpty()) {
                thongbao("Mã NCC");
                return;
            }
            if (dateChooserImport.getDate() == null) {
                thongbao("Ngày Nhập");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int vitri = Integer.parseInt(dftCoupon.getValueAt(i, 0).toString());
            String ngaynhap = sdf.format(dateChooserImport.getDate());
            int Manv = Integer.parseInt(txtStaffId.getText());
            int Mancc = Integer.parseInt(txtSupplierId.getText());
            CouponDTO pn = new CouponDTO(vitri, Mancc, Manv, ngaynhap);
            int j = couponBUS.editCoupon(pn);
            if (j > 0) {
                loadCoupon();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn vào table");
        }

    }//GEN-LAST:event_btnEditCouponActionPerformed

    private void btnEditCouponDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCouponDetailActionPerformed
        int i = tbCouponDetail.getSelectedRow();
        if (i >= 0) {
            if (txtBookIdCoupon.getText().isEmpty()) {
                thongbao("Mã sách");
                return;
            }
            if (!isNumber(txtQuantity.getText())) {
                JOptionPane.showMessageDialog(null, "Số lượng phải nhập số");
                return;
            }
            if (txtQuantity.getText().isEmpty()) {
                thongbao("Số lượng");
                return;
            }
            if (!isNumber(txtPrice.getText())) {
                JOptionPane.showMessageDialog(null, "Giá nhập phải là số");
                return;
            }
            if (txtPrice.getText().isEmpty()) {
                thongbao("Giá nhập");
                return;
            }
            int masach = Integer.parseInt(txtBookIdCoupon.getText());
            int sl = Integer.parseInt(txtQuantity.getText());
            int gia = Integer.parseInt(txtPrice.getText());
            int mactpn = Integer.parseInt(dftCouponDetail.getValueAt(i, 0).toString());
            int mapn = Integer.parseInt(dftCouponDetail.getValueAt(i, 1).toString());
            CouponDetailDTO ct = new CouponDetailDTO(mactpn, mapn, masach, gia, sl, sl * gia);
            int j = couponDetailBUS.editCouponDetail(ct);
            if (j > 0) {
                loadCouponDetail();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn vào table");
        }
    }//GEN-LAST:event_btnEditCouponDetailActionPerformed

    private void tbCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCouponMouseClicked
        int i = tbCoupon.getSelectedRow();
        if (i >= 0) {
//            mapn = Integer.parseInt(dftCoupon.getValueAt(i, 0).toString());
            txtCouponId.setText(dftCoupon.getValueAt(i, 0).toString());
            txtStaffId.setText(dftCoupon.getValueAt(i, 0).toString());
            txtSupplierId.setText(dftCoupon.getValueAt(i, 1).toString());
            Date date2;
            try {
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dftCoupon.getValueAt(i, 3).toString());
                dateChooserImport.setDate(date2);

            } catch (Exception ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
            listCouponDetail = CouponDetailDAL.getListCouponDetail();
            dftCouponDetail = (DefaultTableModel) tbCouponDetail.getModel();
            dftCouponDetail.setRowCount(0);
            for (int k = 0; k < listCouponDetail.size(); k++) {
                if (listCouponDetail.get(k).getCoupon_id() == Integer.parseInt(dftCoupon.getValueAt(i, 0).toString())) {
                    Vector<Object> vec = new Vector<Object>();
                    vec.add(listCouponDetail.get(k).getCouponDetail_id());
                    vec.add(listCouponDetail.get(k).getCoupon_id());
                    vec.add(listCouponDetail.get(k).getBook_id());
                    vec.add(listCouponDetail.get(k).getPrice());
                    vec.add(listCouponDetail.get(k).getQuantity());
                    vec.add(listCouponDetail.get(k).getTotal());
                    dftCouponDetail.addRow(vec);
                }
            }
        }
    }//GEN-LAST:event_tbCouponMouseClicked

    private void btnClickStaffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClickStaffIdActionPerformed
        FrameTableStaffGUI staff = new FrameTableStaffGUI();
        staff.setVisible(true);
        staff.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnClickStaffIdActionPerformed

    private void btnSupplierIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierIdActionPerformed
        FrameTableSuperlierGUI supplier = new FrameTableSuperlierGUI();
        supplier.setVisible(true);
        supplier.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSupplierIdActionPerformed

    private void btnSearchCouponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCouponActionPerformed
        if (!isNumber(txtSearchCoupon.getText())) {
            JOptionPane.showMessageDialog(null, "Mã Phiếu Nhập Phải Là Số");
            return;
        }
        int id = Integer.parseInt(txtSearchCoupon.getText());
        CouponDTO pn = couponBUS.getCoupon(id);
        if (pn != null) {
            dftCoupon.setRowCount(0);
            Vector<Object> vec = new Vector<Object>();
            vec.add(pn.getCoupon_id());
            vec.add(pn.getSuperlier_id());
            vec.add(pn.getStaff_id());
            vec.add(pn.getDate_add());
            dftCoupon.addRow(vec);

        }
    }//GEN-LAST:event_btnSearchCouponActionPerformed

    private void btnPrintPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintPDFActionPerformed
        int i = tbCoupon.getSelectedRow();
        if (i > -1) {
            int ma = Integer.parseInt(dftCoupon.getValueAt(i, 0).toString());
            WritePDF wpdf = new WritePDF();
            wpdf.xuatPDFPhieuNhap(tbCouponDetail, ma);

        } else {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Click Vào Table Để Xuất Hoá Đơn");
        }
    }//GEN-LAST:event_btnPrintPDFActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loadCoupon();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ExportExcel ex = new ExportExcel();
        ex.xuatExcel(tbCoupon);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ImportExcel ix = new ImportExcel();
        ix.nhapExcel(tbCoupon);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tbCouponDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCouponDetailMouseClicked
        int i = tbCouponDetail.getSelectedRow();
        if (i >= 0) {
//            txt.setText("Mã Phiếu Nhập " + dtmchitietphieunhap.getValueAt(i, 1).toString());
            txtBookIdCoupon.setText(dftCouponDetail.getValueAt(i, 2).toString());
            txtQuantity.setText(dftCouponDetail.getValueAt(i, 3).toString());
            txtPrice.setText(dftCouponDetail.getValueAt(i, 4).toString());

        }
    }//GEN-LAST:event_tbCouponDetailMouseClicked

    private void btnSelectBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectBookIdActionPerformed
        FrameTableBook book = new FrameTableBook();
        book.setVisible(true);
        book.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSelectBookIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadCouponDetail();
    }//GEN-LAST:event_jButton1ActionPerformed
    public static ArrayList<CouponDTO> listcoupon = new ArrayList<CouponDTO>();

    public void loadCoupon() {
        listcoupon = null;
        listcoupon = CouponDAL.getListCoupon();

        dftCoupon.setRowCount(0);

        for (CouponDTO pn : listcoupon) {

            Vector<Object> vec = new Vector<Object>();
            vec.add(pn.getCoupon_id());
            vec.add(pn.getSuperlier_id());
            vec.add(pn.getStaff_id());
            vec.add(pn.getDate_add());
            dftCoupon.addRow(vec);

        }
    }
    public static ArrayList<CouponDetailDTO> listCouponDetail = new ArrayList<CouponDetailDTO>();

    public void loadCouponDetail() {
        listCouponDetail = null;
        listCouponDetail = CouponDetailDAL.getListCouponDetail();

        dftCouponDetail.setRowCount(0);

        for (CouponDetailDTO pn : listCouponDetail) {

            Vector<Object> vec = new Vector<Object>();
            vec.add(pn.getCouponDetail_id());
            vec.add(pn.getCoupon_id());
            vec.add(pn.getBook_id());
            vec.add(pn.getPrice());
            vec.add(pn.getQuantity());
            vec.add(pn.getTotal());
            vec.add(pn.getDate_add());
            vec.add(pn.getBook_name());
            dftCouponDetail.addRow(vec);
        }
    }

    public static void thongbao(String s) {
        JOptionPane.showMessageDialog(null, s + " không được bỏ trống");
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCoupon;
    private javax.swing.JButton btnAddCouponDetail;
    private javax.swing.JButton btnClickStaffId;
    private javax.swing.JButton btnDeleteCoupon;
    private javax.swing.JButton btnDeleteCouponDetal;
    private javax.swing.JButton btnEditCoupon;
    private javax.swing.JButton btnEditCouponDetail;
    private javax.swing.JButton btnPrintPDF;
    private javax.swing.JButton btnSearchCoupon;
    private javax.swing.JButton btnSelectBookId;
    private javax.swing.JButton btnSupplierId;
    private com.toedter.calendar.JDateChooser dateChooserImport;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCoupon;
    private javax.swing.JTable tbCouponDetail;
    public static javax.swing.JTextField txtBookIdCoupon;
    private javax.swing.JTextField txtCouponId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearchCoupon;
    public static javax.swing.JTextField txtStaffId;
    public static javax.swing.JTextField txtSupplierId;
    // End of variables declaration//GEN-END:variables
}
