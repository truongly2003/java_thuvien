package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MenuleftGUI extends JFrame {

    private JPanel contentPane;
    private CardLayout cardlayout;
    private JPanel menuleft;
    private JLabel lblhome;
    private JLabel lblbook;
    private JLabel lblauthor;
    private JLabel lblcategory;
    private JLabel lbllogout;
    private JLabel lblpublish;
    private JLabel lblstatis;
    private JLabel lblstaff;
    private JLabel lblreader;
    private JLabel lblborrow;
    private JLabel lblimport;
    private JPanel panelBook;
    private JPanel panelHome;
    private JPanel panelAuthor;
    private JPanel panelstaff;
    private JPanel panelreader;
    private JPanel panelPublish;
    private JLabel jLabelright;
    private final JPanel panelStatis;
    private final JPanel panelBorrow;
    private final JPanel panelCoupon;

    // trưởng : home, book, author
    public MenuleftGUI() {
       
        setUndecorated(true);
        setBounds(50, 50, 1200, 650);
        contentPane = new JPanel();
        cardlayout = new CardLayout();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        contentPane.setBackground(new Color(0, 0, 209));
        setLocationRelativeTo(null);

        // JPanel Home
        panelHome = new JPanel();
        HomeGUI home = new HomeGUI();
        panelHome.setLayout(new BorderLayout());
        panelHome.add(home, BorderLayout.CENTER);
        // JPanel Book
        panelBook = new JPanel();
        BookGUI book = new BookGUI();
        panelBook.setLayout(new BorderLayout());
        panelBook.add(book, BorderLayout.CENTER);
        // Jpanel Author
        panelAuthor = new JPanel();
        AuthorGUI author = new AuthorGUI();
        panelAuthor.setLayout(new BorderLayout());
        panelAuthor.add(author, BorderLayout.CENTER);
        // staff
        panelstaff=new JPanel();
        StaffGUI staff=new StaffGUI();
        panelstaff.setLayout(new BorderLayout());
        panelstaff.add(staff,BorderLayout.CENTER);
        // reader
        panelreader=new JPanel();
        ReaderGUI reader=new ReaderGUI();
        panelreader.setLayout(new BorderLayout());
        panelreader.add(reader,BorderLayout.CENTER);
        // Jpanel Publish
        panelPublish = new JPanel();
        PublishGUI publish = new PublishGUI();
        panelPublish.setLayout(new BorderLayout());
        panelPublish.add(publish, BorderLayout.CENTER);
        // Jpanel Statistical
        panelStatis = new JPanel();
        StatisticalGUI statis = new StatisticalGUI();
        panelStatis.setLayout(new BorderLayout());
        panelStatis.add(statis,BorderLayout.CENTER);
        // Jpanel Borrow
        panelBorrow = new JPanel();
        BorrowGUI borrow = new BorrowGUI();
        panelBorrow.setLayout(new BorderLayout());
        panelBorrow.add(borrow,BorderLayout.CENTER);
        // Jpanel Coupon
        panelCoupon = new JPanel();
        CouponGUI coupon = new CouponGUI();
        panelCoupon.setLayout(new BorderLayout());
        panelCoupon.add(coupon,BorderLayout.CENTER);
        createMenuLeft();
        
        // card layout
        JPanel cardPanel = new JPanel(cardlayout);
        cardPanel.add(panelHome, "home");
        cardPanel.add(panelBook, "book");
        cardPanel.add(panelAuthor, "author");
        cardPanel.add(panelstaff,"staff");
        cardPanel.add(panelreader, "reader");
        cardPanel.add(panelPublish, "publish"); 
        cardPanel.add(panelStatis, "statis"); 
        cardPanel.add(panelBorrow, "borrow"); 
        cardPanel.add(panelCoupon, "coupon"); 
        contentPane.add(cardPanel, BorderLayout.CENTER);

        // Home
        lblhome.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "home");
                lblhome.setBackground(Color.GRAY);
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
                 lblhome.setBackground(new Color(0, 206, 209));
               
            }
        });
        // Book
        lblbook.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "book");
                  lblbook.setBackground(Color.GRAY);
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
                lblbook.setBackground(new Color(0, 206, 209));
            }
        });
        // author
        lblauthor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "author");
                lblauthor.setBackground(Color.GRAY);
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
                  lblauthor.setBackground(new Color(0, 206, 209));
            }
        });
        // staff
        lblstaff.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "staff");
                 lblstaff.setBackground(Color.GRAY);
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
                lblstaff.setBackground(new Color(0, 206, 209));
            }
        });
        // publish
        lblpublish.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "publish");
                 lblpublish.setBackground(Color.GRAY);
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
                lblpublish.setBackground(new Color(0, 206, 209));
            }
        });
        // reader
        lblreader.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "reader");
                 lblreader.setBackground(Color.GRAY);
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
                lblreader.setBackground(new Color(0, 206, 209));
            }
        });
        //statistcal
        lblstatis.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "statis");
                 lblstatis.setBackground(Color.GRAY);
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
                lblstatis.setBackground(new Color(0, 206, 209));
            }
        });
        //borrow
        lblborrow.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "borrow");
                 lblborrow.setBackground(Color.GRAY);
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
                lblborrow.setBackground(new Color(0, 206, 209));
            }
        });
        lblimport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(cardPanel, "coupon");
                 lblimport.setBackground(Color.GRAY);
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
                lblimport.setBackground(new Color(0, 206, 209));
            }
        });
        title();
    }

    // thanh menuleft
    public void title() {
        JPanel jPanelTitle = new JPanel(new BorderLayout());

        JLabel jLabelleft = new JLabel("Quản Lý Thư Viện");
        jLabelleft.setFont(new Font("Tahome", Font.ITALIC, 20));
        jLabelleft.setForeground(Color.black);
        jPanelTitle.add(jLabelleft, BorderLayout.WEST);

        jLabelright = new JLabel();
        jLabelright.setIcon(new ImageIcon(getClass().getResource("/img/black.png")));
        jLabelright.setForeground(Color.WHITE);
        jLabelright.setFont(new Font("tahome", Font.BOLD, 20));
        jPanelTitle.add(jLabelright, BorderLayout.EAST);

        jPanelTitle.setBorder(new EmptyBorder(0, 10, 0, 10));
        jPanelTitle.setBackground(new Color(0, 206, 209));
        jPanelTitle.setPreferredSize(new Dimension(180, 40));
        contentPane.add(jPanelTitle, BorderLayout.NORTH);
        // thoát
        jLabelright.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                 System.exit(0);
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
    }

    public void createMenuLeft() {
        menuleft = new JPanel();
        // Menu bar on the left
        menuleft.setPreferredSize(new Dimension(180, 650));
        menuleft.setBackground(new Color(0, 206, 209));
        contentPane.add(menuleft, BorderLayout.WEST);
        menuleft.setLayout(null);
        menuleft.setBorder(new EmptyBorder(20, 20, 0, 20));

        JPanel panel = new JPanel();
        Border border = BorderFactory.createMatteBorder(20, 20, 0, 0, Color.white);
        panel.setBorder(border);
        panel.setBounds(0, 0, 180, 2);
        menuleft.add(panel);

        // Home
        lblhome = new JLabel("Trang Chủ");
        lblhome.setBackground(new Color(64, 64, 64));
        lblhome.setOpaque(true);
        lblhome.setForeground(Color.white);
        lblhome.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblhome.setIcon(new ImageIcon(getClass().getResource("/img/1_home.png")));
        lblhome.setBackground(new Color(0, 206, 209));
        lblhome.setBounds(0, 55, 180, 50);
        lblhome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblhome);
        // book
        lblbook = new JLabel("Sách");
        lblbook.setBackground(new Color(64, 64, 64));
        lblbook.setOpaque(true);
        lblbook.setForeground(Color.white);
        lblbook.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblbook.setIcon(new ImageIcon(getClass().getResource("/img/5_book.png")));
        lblbook.setBackground(new Color(0, 206, 209));
        lblbook.setBounds(0, 110, 180, 50);
        lblbook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblbook);
        // author
        lblauthor = new JLabel("Tác Giả");
        lblauthor.setBackground(new Color(64, 64, 64));
        lblauthor.setOpaque(true);
        lblauthor.setForeground(Color.white);
        lblauthor.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblauthor.setIcon(new ImageIcon(getClass().getResource("/img/7_author.png")));
        lblauthor.setBackground(new Color(0, 206, 209));
        lblauthor.setBounds(0, 165, 180, 50);
        lblauthor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblauthor);
        // staff nhân viên
        lblstaff = new JLabel("Nhân Viên");
        lblstaff.setBackground(new Color(64, 64, 64));
        lblstaff.setOpaque(true);
        lblstaff.setForeground(Color.white);
        lblstaff.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblstaff.setIcon(new ImageIcon(getClass().getResource("/img/4_staff.png")));
        lblstaff.setBackground(new Color(0, 206, 209));
        lblstaff.setBounds(0, 220, 180, 50);
        lblstaff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblstaff);
        // publish
        lblpublish = new JLabel("Nhà Xuất Bản");
        lblpublish.setBackground(new Color(64, 64, 64));
        lblpublish.setOpaque(true);
        lblpublish.setForeground(Color.white);
        lblpublish.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblpublish.setIcon(new ImageIcon(getClass().getResource("/img/10_publish.png")));
        lblpublish.setBackground(new Color(0, 206, 209));
        lblpublish.setBounds(0, 275, 180, 50);
        lblpublish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblpublish);
        // reader
        lblreader = new JLabel("Độc Giả");
        lblreader.setBackground(new Color(64, 64, 64));
        lblreader.setOpaque(true);
        lblreader.setForeground(Color.white);
        lblreader.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblreader.setIcon(new ImageIcon(getClass().getResource("/img/2_reader.png")));
        lblreader.setBackground(new Color(0, 206, 209));
        lblreader.setBounds(0, 330, 180, 50);
        lblreader.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblreader);
        // statis thống kê
        lblstatis = new JLabel("Thống Kê");
        lblstatis.setBackground(new Color(64, 64, 64));
        lblstatis.setOpaque(true);
        lblstatis.setForeground(Color.white);
        lblstatis.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblstatis.setIcon(new ImageIcon(getClass().getResource("/img/4_staff.png")));
        lblstatis.setBackground(new Color(0, 206, 209));
        lblstatis.setBounds(0, 385, 180, 50);
        lblstatis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblstatis);
        // borrow
        lblborrow = new JLabel("Phiếu Mượn");
        lblborrow.setBackground(new Color(64, 64, 64));
        lblborrow.setOpaque(true);
        lblborrow.setForeground(Color.white);
        lblborrow.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblborrow.setIcon(new ImageIcon(getClass().getResource("/img/6_borrow.png")));
        lblborrow.setBackground(new Color(0, 206, 209));
        lblborrow.setBounds(0, 440, 180, 50);
        lblborrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblborrow);
        //import phiếu nhập
        lblimport = new JLabel("Phiếu Nhập");
        lblimport.setBackground(new Color(64, 64, 64));
        lblimport.setOpaque(true);
        lblimport.setForeground(Color.white);
        lblimport.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblimport.setIcon(new ImageIcon(getClass().getResource("/img/8_import.png")));
        lblimport.setBackground(new Color(0, 206, 209));
        lblimport.setBounds(0, 495, 180, 50);
        lblimport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuleft.add(lblimport);
      

        //
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MenuleftGUI m = new MenuleftGUI();
                    m.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }
}
