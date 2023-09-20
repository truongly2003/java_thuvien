package GUI;

import BUS.ReaderBUS;
import DTO.ReaderDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReaderGUI extends javax.swing.JPanel {
    ReaderBUS readerBUS = new ReaderBUS();
    private static ButtonGroup genderGroup;
    private DefaultTableModel dftReader;
    public ReaderDTO reader;

    private ArrayList<ReaderDTO> rd = new ArrayList<ReaderDTO>();

    public ReaderGUI() {
        initComponents();
        dftReader = (DefaultTableModel) tblReader.getModel();
        genderGroup = new ButtonGroup();
        genderGroup.add(rdNam);
        genderGroup.add(rdNu);
        loadReader();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        lblTiltle = new javax.swing.JLabel();
        pnTop = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemote = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        pnSounth = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReader = new javax.swing.JTable();
        pnCenter = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        lblTiltle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTiltle.setForeground(new java.awt.Color(0, 153, 153));
        lblTiltle.setText("QUẢN LÝ ĐỘC GIẢ");

        pnTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("TÊN ĐỘC GIẢ:");

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGender.setText("GIỚI TÍNH:");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("ĐỊA CHỈ:");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("SỐ ĐIỆN THOẠI:");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11_add.png"))); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/15_update.png"))); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/14_delete.png"))); // NOI18N
        btnRemote.setText("XÓA");
        btnRemote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoteActionPerformed(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/13_reset.png"))); // NOI18N
        btnRefesh.setText("TẢI LẠI");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        rdNam.setText("NAM");

        rdNu.setText("NỮ");

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblGender)
                    .addComponent(lblAddress)
                    .addComponent(lblPhone))
                .addGap(28, 28, 28)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addGap(69, 69, 69)
                                .addComponent(rdNu)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd)
                                .addGap(61, 61, 61)
                                .addComponent(btnEdit)
                                .addGap(61, 61, 61)))
                        .addComponent(btnRemote)
                        .addGap(61, 61, 61)
                        .addComponent(btnRefesh)
                        .addGap(50, 50, 50))))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefesh)
                            .addComponent(btnEdit)
                            .addComponent(btnAdd))
                        .addGap(18, 18, 18)))
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblReader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblReader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ ĐỘC GIẢ", "HỌ VÀ TÊN", "GIỚI TÍNH", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ"
            }
        ));
        tblReader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReaderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReader);

        pnCenter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearch.setText("TÌM KIẾM:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/12_search.png"))); // NOI18N
        btnSearch.setText("TÌM KIẾM");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblSearch)
                .addGap(55, 55, 55)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnSounthLayout = new javax.swing.GroupLayout(pnSounth);
        pnSounth.setLayout(pnSounthLayout);
        pnSounthLayout.setHorizontalGroup(
            pnSounthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSounthLayout.createSequentialGroup()
                .addComponent(pnCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        pnSounthLayout.setVerticalGroup(
            pnSounthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSounthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSounth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(lblTiltle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTiltle)
                .addGap(24, 24, 24)
                .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSounth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoteActionPerformed
        // TODO add your handling code here:
        int i = tblReader.getSelectedRow();
        if (i >= 0) {
            int index = Integer.parseInt(dftReader.getValueAt(i, 0).toString());
            String gender = genderReader();
            reader = new ReaderDTO(index, txtName.getText(), gender, txtAddress.getText(), txtPhone.getText());
            int a = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa???", "", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int j = readerBUS.remoteReader(reader);
                if (j > 0) {
                    loadReader();
                }
            } else {
                JOptionPane.showMessageDialog(null, "bạn chưa chọn nhân viên cần xóa! ");
            }
        }
    }//GEN-LAST:event_btnRemoteActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        // TODO add your handling code here:
        loadReader();
    }//GEN-LAST:event_btnRefeshActionPerformed

    public String genderReader() {
        if (rdNam.isSelected()) {
            return "NAM";
        } else if (rdNu.isSelected()) {
            return "NỮ";
        }
        return null;
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String gender = genderReader();
        reader = new ReaderDTO(0, txtName.getText(), gender,
                txtAddress.getText(), txtPhone.getText());
        int j = readerBUS.AddReader(reader);
        if (j > 0) {
            loadReader();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int i = tblReader.getSelectedRow();
        if (i > -1) {
            int index = Integer.parseInt(dftReader.getValueAt(i, 0).toString());
            String gender = genderReader();
            reader = new ReaderDTO(index, txtName.getText(), gender,
                    txtAddress.getText(), txtPhone.getText());

            int j = readerBUS.editReader(reader);
            if (j > 0) {
                loadReader();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên nào hết");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblReaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReaderMouseClicked
        int selectedRow = tblReader.getSelectedRow();
        String readerName = tblReader.getValueAt(selectedRow, 1).toString();
        String gender = tblReader.getValueAt(selectedRow, 2).toString();
        String phone = tblReader.getValueAt(selectedRow, 3).toString();
        String address = tblReader.getValueAt(selectedRow, 4).toString();

        // Gán giá trị vào các JTextField tương ứng
        txtName.setText(readerName);

        if (gender.equals("NAM")) {
            rdNam.setSelected(true);
            rdNu.setSelected(false);
        }
        if (gender.equals("NỮ")) {
            rdNam.setSelected(false);
            rdNu.setSelected(true);
        }
        txtPhone.setText(phone);
        txtAddress.setText(address);

    }//GEN-LAST:event_tblReaderMouseClicked
    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!isNumber(txtSearch.getText())) {
            JOptionPane.showMessageDialog(null, "Phải nhập số");
            return;
        }
        int id = Integer.parseInt(txtSearch.getText());
         ReaderDTO reader1 = readerBUS.searchReader(id);

        if (reader1 == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin");
        } else {
            dftReader.setRowCount(0);
            Vector<Object> vec = new Vector<Object>();
            vec.add(reader1.getReader_id());
            vec.add(reader1.getReaderName());
            vec.add(reader1.getGender());
            vec.add(reader1.getPhoneNumber());
            vec.add(reader1.getAddress());
            dftReader.addRow(vec);
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnRemote;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTiltle;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnSounth;
    private javax.swing.JPanel pnTop;
    public static javax.swing.JRadioButton rdNam;
    public javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblReader;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void loadReader() {

        ReaderBUS rdbus = new ReaderBUS();

        rd = rdbus.getListReader();
        dftReader.setRowCount(0);
        for (ReaderDTO rd : rd) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(rd.getReader_id());
            vec.add(rd.getReaderName());
            vec.add(rd.getGender());
            vec.add(rd.getPhoneNumber());
            vec.add(rd.getAddress());

            dftReader.addRow(vec);
        }
    }
}
