package GUI;

import BUS.AuthorBUS;
import BUS.BookBUS;
import BUS.BookCategoryBUS;
import BUS.BookShelfBUS;
import BUS.PublishBUS;
import DAL.AuthorDAL;
import DAL.BookDAL;
import DAL.PublishDAL;
import DAL.ReaderDAL;
import DAL.StaffDAL;
import DTO.AuthorDTO;
import DTO.BookCategoryDTO;
import DTO.BookDTO;
import DTO.BookShelfDTO;
import DTO.PublishDTO;
import DTO.ReaderDTO;
import DTO.StaffDTO;
import static GUI.FrameTableBook.listbook;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class BookGUI extends javax.swing.JPanel {

    BookCategoryDTO category;
    private String image = "";
    AuthorBUS authorBUS = new AuthorBUS();
    BookCategoryBUS categoryBUS = new BookCategoryBUS();
    BookShelfBUS bookshelfBUS = new BookShelfBUS();
    PublishBUS publishBUS = new PublishBUS();
    File fileimagebook;
    BookDTO bookdto = new BookDTO();
    AuthorDTO authordto = new AuthorDTO();
    AuthorDTO authordtos;
    BookCategoryDTO categorydto = new BookCategoryDTO();
    PublishDTO publishdto = new PublishDTO();
    BookShelfDTO shelfdto = new BookShelfDTO();
    private ArrayList<BookDTO> booklist;
    private DefaultTableModel tableModel;
    BookDAL bookdao = new BookDAL();
    BookBUS bookbus = new BookBUS();
//    DefaultComboBoxModel model;

    public static void main(String[] args) {
        BookGUI b = new BookGUI();
        b.setVisible(true);

    }

    public BookGUI() {
        initComponents();
        tableModel = (DefaultTableModel) jTable1.getModel();
//        model = (DefaultComboBoxModel) cbPublish.getModel();
        loadBook();
        add();
        // thêm sách
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAuthor = (String) cbAuthor.getSelectedItem();
                if (jTextField2.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "không được để trống tên sách");
                    return;
                }
                if (selectedAuthor.equals("0-chọn tác giả")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] authorstring = selectedAuthor.split("-");
                int author = Integer.parseInt(authorstring[0]);

                String selectedCategory = (String) jComboBox2.getSelectedItem();
                if (selectedCategory.equals("0-chọn loại")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] categorystring = selectedCategory.split("-");
                int category = Integer.parseInt(categorystring[0]);

                String selectedShelf = (String) jComboBox3.getSelectedItem();
                if (selectedShelf.equals("0-chọn kệ")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn kệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] shelfstring = selectedShelf.split("-");
                int shelfid = Integer.parseInt(shelfstring[0]);

                String selectedPublish = (String) cbPublish.getSelectedItem();
                if (selectedPublish.equals("0-chọn nhà xuất bản")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà xuất bản", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] publishstring = selectedPublish.split("-");
                int publishid = Integer.parseInt(publishstring[0]);
                String bookname = jTextField2.getText();
                int publishyear = jYearChooser1.getYear();
                if (image == null || image.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lỗi", "Bạn chưa chọn ảnh", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    jLabel9.setText("");
                }
                int quantity;
                try {
                    quantity = Integer.parseInt(jTextField4.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "số lượng sách phải là số");
                    return;
                }

                BookDTO book = new BookDTO(0, bookname, category, author, publishid, publishyear, quantity, image, "1", shelfid);
                int j = bookbus.insert(book);
                if (j > 0) {
                    loadBook();

                }

            }

        });
        // sửa
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = jTable1.getSelectedRow();
                if (i > -1) {
                    int bookid = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
                    String selectedAuthor = (String) cbAuthor.getSelectedItem();
                    if (jTextField2.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "không được để trống tên sách");
                        return;
                    }
                    if (selectedAuthor.equals("0-chọn tác giả")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String[] authorstring = selectedAuthor.split("-");
                    int author = Integer.parseInt(authorstring[0]);

                    String selectedCategory = (String) jComboBox2.getSelectedItem();
                    if (selectedCategory.equals("0-chọn loại")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String[] categorystring = selectedCategory.split("-");
                    int category = Integer.parseInt(categorystring[0]);

                    String selectedShelf = (String) jComboBox3.getSelectedItem();
                    if (selectedShelf.equals("0-chọn kệ")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn kệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String[] shelfstring = selectedShelf.split("-");
                    int shelfid = Integer.parseInt(shelfstring[0]);

                    String selectedPublish = (String) cbPublish.getSelectedItem();
                    if (selectedPublish.equals("0-chọn nhà xuất bản")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà xuất bản", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String[] publishstring = selectedPublish.split("-");
                    int publishid = Integer.parseInt(publishstring[0]);
                    String bookname = jTextField2.getText();
                    int publishyear = jYearChooser1.getYear();
                    if (image == null || image.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lỗi", "Bạn chưa chọn ảnh", JOptionPane.ERROR_MESSAGE);
                         return;
                    } else {
                        jLabel9.setText("");
                       
                    }
                    int quantity;
                    try {
                        quantity = Integer.parseInt(jTextField4.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "số lượng sách phải là số");
                        return;
                    }

                    BookDTO book = new BookDTO(bookid, bookname, category, author, publishid, publishyear, quantity, image, "1", shelfid);
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        int j = bookbus.update(book);
                        if (j > 0) {
                            loadBook();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "bạn chưa chọn sách nào");

                }
            }

        });
        // xóa 
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = jTable1.getSelectedRow();
                if (i > -1) {
                    int bookid = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
                    String selectedAuthor = (String) cbAuthor.getSelectedItem();
                    String[] authorstring = selectedAuthor.split("-");
                    int author = Integer.parseInt(authorstring[0]);

                    String selectedCategory = (String) jComboBox2.getSelectedItem();
                    String[] categorystring = selectedCategory.split("-");
                    int category = Integer.parseInt(categorystring[0]);

                    String selectedShelf = (String) jComboBox3.getSelectedItem();
                    String[] shelfstring = selectedShelf.split("-");
                    int shelfid = Integer.parseInt(shelfstring[0]);

                    String selectedPublish = (String) cbPublish.getSelectedItem();
                    String[] publishstring = selectedPublish.split("-");
                    int publishid = Integer.parseInt(publishstring[0]);

                    String bookname = jTextField2.getText();
                    int publishyear = jYearChooser1.getStartYear();
                    int quantity;
                    try {
                        quantity = Integer.parseInt(jTextField4.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "số lượng phải là số");
                        return;
                    }
//                    Image image = icon.getImage();

                    BookDTO book = new BookDTO(bookid, bookname, category, author, publishid, publishyear, quantity, image, "", shelfid);
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa", "", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        int j = bookbus.deleteBook(book);
                        if (j > 0) {
                            loadBook();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "bạn chưa chọn sách nào");
                }
            }

        });
        // hoàn tác
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBook();
                loadauthor();
                loadpublish();
            }

        });
        // tìm kiếm
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (jTextField1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập vào nội dung !");
                        loadBook();
                        return;
                    }
                    int id;
                    String s = jTextField1.getText().toLowerCase();
                    if (isNumeric(s)) {
                        // Nếu chuỗi nhập vào là số, thì tìm kiếm theo mã sách
                        id = Integer.parseInt(s);
                    } else {
                        // Nếu chuỗi nhập vào không phải là số, thì tìm kiếm theo tên sách
                        id = -1; // Đặt id = -1 để không tìm kiếm theo mã sách
                    }
                    listbook = null;
                    listbook = BookDAL.getAllBook();
                    tableModel.setRowCount(0);
                    for (BookDTO bk : booklist) {
                        if (id == -1 && bk.getBookname().toLowerCase().contains(s)) {
                            // Tìm kiếm theo tên sách
                            Vector<Object> vec = new Vector<Object>();
                            vec.add(bk.getBookid());
                            vec.add(bk.getBookname());
                            vec.add(bk.getAuthorid());
                            vec.add(bk.getPublishid());
                            vec.add(bk.getCategoryid());
                            vec.add(bk.getPublishyear());
                            vec.add(bk.getQuantity());
                            vec.add(bk.getBookshelfid());
                            vec.add(bk.getImage());
                            tableModel.addRow(vec);
                        } else if (id != -1 && id == bk.getBookid()) {
                            // Tìm kiếm theo mã sách
                            Vector<Object> vec = new Vector<Object>();
                            vec.add(bk.getBookid());
                            vec.add(bk.getBookname());
                            vec.add(bk.getAuthorid());
                            vec.add(bk.getPublishid());
                            vec.add(bk.getCategoryid());
                            vec.add(bk.getPublishyear());
                            vec.add(bk.getQuantity());
                            vec.add(bk.getBookshelfid());
                            vec.add(bk.getImage());
                            tableModel.addRow(vec);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        // table
        jTable1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = jTable1.getSelectedRow();
                if (i > -1) {
                    jTextField2.setText(tableModel.getValueAt(i, 1).toString());

                    int author = Integer.parseInt(tableModel.getValueAt(i, 2).toString());

                    String authorData = tableModel.getValueAt(i, 2).toString();

//                    if(isItemExists(jComboBox1, author))
//                    {
//                        jComboBox1.setSelectedItem(author);
//                    }else{
//                        jComboBox1.setSelectedIndex(0);
//                    }
                    String category = tableModel.getValueAt(i, 4).toString();
                    jComboBox2.setSelectedItem(category);

                    int birthYear = Integer.parseInt(tableModel.getValueAt(i, 5).toString());
                    jYearChooser1.setYear(birthYear);

                    String shelf = tableModel.getValueAt(i, 6).toString();
                    jComboBox3.setSelectedItem(shelf);

                    String publish = tableModel.getValueAt(i, 3).toString();
                    cbPublish.setSelectedItem(publish);

                    jTextField4.setText(tableModel.getValueAt(i, 7).toString());
                    image = tableModel.getValueAt(i, 8).toString();
                    jLabel9.setIcon(getimage(image));

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        // chọn ảnh
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectimage();
            }

        });

        //lbl thêm category
        lblcategory.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                digCategory f = new digCategory();
                f.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadcategory();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                    }

                });
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        // lbl thêm shelf
        lblshelf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                digBookShelf f = new digBookShelf();
                f.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadshelf();

                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                    }

                });
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            public void windowClosed(WindowEvent e) {
                // DigBookShelf đã được đóng
                // Gọi phương thức reloadComboBoxData() để load lại dữ liệu vào JComboBox

            }
        });

    }

    public void add() {
        loadcategory();
        loadauthor();
        loadshelf();
        loadpublish();
//        listenForDataChanges();

    }

    // function 
    public boolean isnumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // load jcombobox category
    public void loadcategory() {
        jComboBox2.removeAllItems();
        ArrayList<BookCategoryDTO> categoryarr = categoryBUS.getAll();
        jComboBox2.addItem("0-chọn loại");
        for (BookCategoryDTO category : categoryarr) {
            jComboBox2.addItem(category.getCategoryid() + "-" + category.getCategoryName());
        }
    }
    public static ArrayList<AuthorDTO> authorlist = new ArrayList<AuthorDTO>();

    // load jcombobox author
    public void loadauthor() {
        cbAuthor.removeAllItems();
        authorlist = authorBUS.getAll();
        cbAuthor.addItem("0-chọn tác giả");
        for (AuthorDTO author : authorlist) {
            cbAuthor.addItem(author.getAuthorid() + "-" + author.getAuthorname());
        }
    }

    private void listenForDataChanges() {
        javax.swing.Timer timer = new javax.swing.Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadauthor();
                loadpublish();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    // load jcombobox shelf
    public void loadshelf() {
        jComboBox3.removeAllItems();
        ArrayList<BookShelfDTO> shelfarr = bookshelfBUS.getAllBookShelf();
        jComboBox3.addItem("0-chọn kệ");
        for (BookShelfDTO shelf : shelfarr) {
            jComboBox3.addItem(shelf.getBookshelfid() + "-" + shelf.getLocation());
        }
    }

    // load jcombobox publish
    public void loadpublish() {
        cbPublish.removeAllItems();
        ArrayList<PublishDTO> publisharr = publishBUS.getAllPublish();
        cbPublish.addItem("0-chọn nhà xuất bản");
        for (PublishDTO publ : publisharr) {
            cbPublish.addItem(publ.getPublishid() + "-" + publ.getPublishname());
        }

    }

    // loadbook
    public void loadBook() {
        booklist = new BookBUS().getAllBook();
        tableModel.setRowCount(0);
        for (BookDTO dtoo : booklist) {
            Vector vec = new Vector();
            vec.add(dtoo.getBookid());
            vec.add(dtoo.getBookname());
            vec.add(dtoo.getAuthorid());
            vec.add(dtoo.getPublishid());
            vec.add(dtoo.getCategoryid());
            vec.add(dtoo.getPublishyear());
            vec.add(dtoo.getQuantity());
            vec.add(dtoo.getBookshelfid());
            vec.add(dtoo.getImage());
            tableModel.addRow(vec);
        }
    }

    // 
    private ImageIcon getimage(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        // Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File("img/book/" + src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("img/book/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileimagebook = new File("img/book/" + src);
        } catch (IOException e) {
            fileimagebook = new File("img/book/default.png");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

            return new ImageIcon(dimg);
        }
        return null;
    }

    // chọn ảnh
    public void selectimage() {
        JFileChooser fileChooser = new JFileChooser("img/book/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String name = fileChooser.getSelectedFile().getName();
            image = name;
            jLabel9.setIcon(getimage(name));
            System.out.println(name);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        cbAuthor = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        cbPublish = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblcategory = new javax.swing.JLabel();
        lblshelf = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Mã Tác Giả", "Mã Nhà Xuất Bản", "Mã Loại", "Năm Xuất Bản", "Số Lương", "Mã kệ", "Ảnh"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11_add.png"))); // NOI18N
        jButton1.setText("Thêm");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/15_update.png"))); // NOI18N
        jButton2.setText("Sửa");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/14_delete.png"))); // NOI18N
        jButton3.setText("Xóa");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/13_reset.png"))); // NOI18N
        jButton4.setText("Hoàn Tác");

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/12_search.png"))); // NOI18N
        jButton5.setText("Tim Kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(27, 27, 27))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Tên Sách");

        jLabel3.setText("Mã Tác Giả");

        jLabel2.setText("Mã Loại");

        jLabel4.setText("Năm Sản Xuất");

        cbAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAuthorActionPerformed(evt);
            }
        });

        cbPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPublishActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Số Lượng");

        jLabel7.setText("Nhà Xuất Bản");

        jLabel6.setText("Mã Kệ");

        lblcategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addd.png"))); // NOI18N

        lblshelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addd.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblshelf)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 184, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(415, 415, 415))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblshelf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 204));
        jLabel8.setText("Quản Lý Sách");

        jButton6.setText("Chọn Ảnh");

        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void cbPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPublishActionPerformed

    }//GEN-LAST:event_cbPublishActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAuthorActionPerformed

    }//GEN-LAST:event_cbAuthorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbAuthor;
    private javax.swing.JComboBox<String> cbPublish;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lblshelf;
    // End of variables declaration//GEN-END:variables
}
