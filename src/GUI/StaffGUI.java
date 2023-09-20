package GUI;

import BUS.StaffBUS;
import DAL.StaffDAL;
import DTO.StaffDTO;
import static GUI.BorrowGUI.liststaff;
import com.toedter.calendar.JYearChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StaffGUI extends javax.swing.JPanel {

    StaffBUS staffBUS = new StaffBUS();
    private ButtonGroup genderGroup;
    StaffDTO staff;
    private DefaultTableModel dftStaff;

    /**
     * Creates new form StaffGUI
     */
    private ArrayList<StaffDTO> nv = new ArrayList<StaffDTO>();
  
    public StaffGUI() {
        initComponents();
        dftStaff = (DefaultTableModel) tblStaff.getModel();
        genderGroup = new ButtonGroup();
        genderGroup.add(rdNam);
        genderGroup.add(rdNu);
        loadStaff();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        pnTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnXuLy = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblBirthYear = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAddStaff = new javax.swing.JButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        yearChoooser = new com.toedter.calendar.JYearChooser();
        pnTable = new javax.swing.JPanel();
        jcpStaff = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 204, 204));
        lblTitle.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
                pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnTitleLayout.createSequentialGroup()
                                .addGap(343, 343, 343)
                                .addComponent(lblTitle)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTitleLayout.setVerticalGroup(
                pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnTitleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 0));
        lblName.setText("TÊN:");

        lblBirthYear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBirthYear.setForeground(new java.awt.Color(0, 0, 0));
        lblBirthYear.setText("NĂM SINH:");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(0, 0, 0));
        lblAddress.setText("ĐỊA CHỈ:");

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGender.setForeground(new java.awt.Color(0, 0, 0));
        lblGender.setText("GIỚI TÍNH:");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblPhone.setText("SĐT:");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/14_delete.png"))); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/15_update.png"))); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/13_reset.png"))); // NOI18N
        btnRefesh.setText("TẢI LẠI");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(0, 0, 0));
        lblSearch.setText("TÌM KIẾM:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/12_search.png"))); // NOI18N
        btnSearch.setText("TÌM KIẾM");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11_add.png"))); // NOI18N
        btnAddStaff.setText("THÊM");
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        rdNam.setText("Nam");
        rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });

        rdNu.setText("Nữ");

        javax.swing.GroupLayout pnXuLyLayout = new javax.swing.GroupLayout(pnXuLy);
        pnXuLy.setLayout(pnXuLyLayout);
        pnXuLyLayout.setHorizontalGroup(
                pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblBirthYear)
                                        .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblGender, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(30, 30, 30)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                                .addComponent(rdNam)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addComponent(yearChoooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(83, 83, 83)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                                                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(144, 144, 144)
                                                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                                                .addComponent(lblSearch)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSearch)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(144, 144, 144)
                                                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnXuLyLayout.setVerticalGroup(
                pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnXuLyLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblBirthYear)
                                                .addComponent(btnAddStaff)
                                                .addComponent(btnEdit))
                                        .addComponent(yearChoooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblGender)
                                                .addComponent(rdNam))
                                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAddress)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRefesh)
                                        .addComponent(btnDelete))
                                .addGap(18, 18, 18)
                                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPhone)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSearch)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        tblStaff.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "Mã", "Tên Nhân Viên", "Năm Sinh", "Giới Tính", "Địa Chỉ", "SĐT"
                }
        ));
        tblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffMouseClicked(evt);
            }
        });
        jcpStaff.setViewportView(tblStaff);

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
                pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcpStaff)
        );
        pnTableLayout.setVerticalGroup(
                pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnTableLayout.createSequentialGroup()
                                .addComponent(jcpStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnXuLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
// thêm nhân viên

    public String genderStaff() {
        if (rdNam.isSelected()) {
            return "Nam";
        } else if (rdNu.isSelected()) {
            return "Nữ";
        }
        return null;
    }

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        String gender = genderStaff();
        int yearChooser = yearChoooser.getYear();
        String strYear = String.valueOf(yearChooser);
        staff = new StaffDTO(0, txtName.getText(), strYear, gender,
                txtPhone.getText(), txtAddress.getText());
        int j = staffBUS.addStaff(staff);
        if (j > 0) {
            loadStaff();
        }

    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int i = tblStaff.getSelectedRow();
        int yearChooser = yearChoooser.getYear();
        String strYear = String.valueOf(yearChooser);
        if (i >= 0) {
            int index = Integer.parseInt(dftStaff.getValueAt(i, 0).toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String gender = genderStaff();
            staff = new StaffDTO(index, txtName.getText(), strYear, gender, txtPhone.getText(), txtAddress.getText());
            int a = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa???", "", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int j = staffBUS.remoteStaff(staff);
                if (j > 0) {
                    loadStaff();
                }
            } else {
                JOptionPane.showMessageDialog(null, "bạn chưa chọn nhân viên cần xóa! ");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int i = tblStaff.getSelectedRow();
        int yearChooser = yearChoooser.getYear();
        String strYear = String.valueOf(yearChooser);
        if (i > -1) {
            int index = Integer.parseInt(dftStaff.getValueAt(i, 0).toString());
            // JOptionPane.showMessageDialog(contentPane, vitri);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String gender = genderStaff();
            staff = new StaffDTO(index, txtName.getText(), strYear, gender,
                    txtPhone.getText(), txtAddress.getText());

            int j = staffBUS.editStaff(staff);
            if (j > 0) {
                loadStaff();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưua chọn nhân viên nào hết");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        // TODO add your handling code here:
        loadStaff();
    }//GEN-LAST:event_btnRefeshActionPerformed

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            if (txtSearch.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập vào nội dung !");
                loadStaff();
                return;
            }
         
            int id;
            String s = txtSearch.getText().toLowerCase();
            if (isNumeric(s)) {
                // Nếu chuỗi nhập vào là số, thì tìm kiếm theo mã sách
                id = Integer.parseInt(s);
            } else {
                // Nếu chuỗi nhập vào không phải là số, thì tìm kiếm theo tên sách
                id = -1; // Đặt id = -1 để không tìm kiếm theo mã sách
            }
            nv = null;
            nv = StaffDAL.getListStaff();
            dftStaff.setRowCount(0);
            for (StaffDTO staff : nv) {
                if (id == -1 && staff.getStaff_name().toLowerCase().contains(s)) {
                    // Tìm kiếm theo tên sách
                    Vector<Object> vec = new Vector<Object>();
                    vec.add(staff.getStaff_id());
                    vec.add(staff.getStaff_name());
                    vec.add(staff.getBirthYear());
                    vec.add(staff.getGender());
                    vec.add(staff.getAddress());
                    vec.add(staff.getPhoneNumber());
                   
                    dftStaff.addRow(vec);
                } else if (id != -1 && id == staff.getStaff_id()) {
                    // Tìm kiếm theo mã sách
                   Vector<Object> vec = new Vector<Object>();
                    vec.add(staff.getStaff_id());
                    vec.add(staff.getStaff_name());
                    vec.add(staff.getBirthYear());
                    vec.add(staff.getGender());
                    vec.add(staff.getAddress());
                    vec.add(staff.getPhoneNumber());
                   
                    dftStaff.addRow(vec);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    //khi click vào sẽ tự hiện thông tin vào txt
    private void tblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblStaff.getSelectedRow();
        //String staff_id = tblStaff.getValueAt(selectedRow, 0).toString();
        String staffName = tblStaff.getValueAt(selectedRow, 1).toString();
        int birthYear = Integer.parseInt(tblStaff.getValueAt(selectedRow, 2).toString());
        String gender = tblStaff.getValueAt(selectedRow, 3).toString();
        String address = tblStaff.getValueAt(selectedRow, 4).toString();
        String phone = tblStaff.getValueAt(selectedRow, 5).toString();

        // Gán giá trị vào các JTextField tương ứng
        txtName.setText(staffName);

        yearChoooser.setYear(birthYear);

        if (gender.equals("Nam")) {
            rdNam.setSelected(true);
            rdNu.setSelected(false);
        }
        if (gender.equals("Nữ")) {
            rdNam.setSelected(false);
            rdNu.setSelected(true);
        }
        txtAddress.setText(address);
        txtPhone.setText(phone);

    }//GEN-LAST:event_tblStaffMouseClicked

    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JScrollPane jcpStaff;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthYear;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnTable;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JPanel pnXuLy;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private com.toedter.calendar.JYearChooser yearChoooser;
    // End of variables declaration//GEN-END:variables

    public void loadStaff() {

        StaffBUS nvbus = new StaffBUS();

        nv = nvbus.getListStaff();
        dftStaff.setRowCount(0);
        for (StaffDTO nv : nv) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(nv.getStaff_id());
            vec.add(nv.getStaff_name());
            vec.add(nv.getBirthYear());
            vec.add(nv.getGender());
            vec.add(nv.getAddress());
            vec.add(nv.getPhoneNumber());
            dftStaff.addRow(vec);
        }
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
