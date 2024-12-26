package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.QLSVModel;
import Model.ThiSinh;
import Model.Tinh;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import Controller.QLSVController;
import DAO.ThiSinhDAO;

import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import javax.swing.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QLSVView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public QLSVModel model;
    public JTextField textField_MaSinhVien_TimKiem;
    public JTable table;
    public JTextField textField_ID;
    public JTextField textField_HoVaTen;
    public JTextField textField_NgaySinh;
    public JTextField textField_Mon1;
    public JTextField textField_1_Mon2;
    public JTextField textField_3_Mon3;
    public ButtonGroup btGroup_GioiTinh;
    public JComboBox comboBox_QueQuan_TimKiem;
    public JComboBox comboBox_QueQuan;
    public JRadioButton jRadioButton_Nam;
    public JRadioButton jRadioButton_Nu;
    public JTextField textField_MaLop_TimKiem;
    private JTextField textField_MaLop;
    public Object jBT_Them;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QLSVView frame = new QLSVView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QLSVView() {
        this.model = new QLSVModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 991, 680);

        URL urlIcon = QLSVView.class.getResource("app_icon.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
        this.setIconImage(img);

        ActionListener aL = new QLSVController(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu jMenu_File = new JMenu("File");
        jMenu_File.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuBar.add(jMenu_File);

        JMenuItem jMenuItem_Open = new JMenuItem("Open");
        jMenuItem_Open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLSVView.class.getResource("open_icon.png")).getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        jMenuItem_Open.addActionListener(aL);
        jMenuItem_Open.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jMenu_File.add(jMenuItem_Open);

        JMenuItem jMenuItem_Save = new JMenuItem("Save");
        jMenuItem_Save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLSVView.class.getResource("save_icon.png")).getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        jMenuItem_Save.addActionListener(aL);
        jMenuItem_Save.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jMenu_File.add(jMenuItem_Save);

        JSeparator separator = new JSeparator();
        jMenu_File.add(separator);

        JMenuItem jMenuItem_Exit = new JMenuItem ("Exit");
        jMenuItem_Exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLSVView.class.getResource("close_icon.png")).getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        jMenuItem_Exit.addActionListener(aL);
        jMenuItem_Exit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jMenu_File.add(jMenuItem_Exit);

        JMenu jMenu_About = new JMenu("About");
        jMenu_About.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuBar.add(jMenu_About);

        JMenuItem jMenu_AboutMe = new JMenuItem("About Me");
        jMenu_AboutMe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLSVView.class.getResource("about_me_icon.png")).getScaledInstance(14, 14, Image.SCALE_SMOOTH)));
        jMenu_AboutMe.addActionListener(aL);
        jMenu_AboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jMenu_About.add(jMenu_AboutMe);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 239, 245));
        
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 965, 50); // Kích thước header (tuỳ chỉnh theo bố cục)
        headerPanel.setBackground(new Color(0, 102, 153)); // Màu xanh đậm
        headerPanel.setLayout(new BorderLayout());

        contentPane.add(headerPanel);
        
                JLabel lblTitle = new JLabel("QUẢN LÝ SINH VIÊN", SwingConstants.CENTER);
                headerPanel.add(lblTitle, BorderLayout.CENTER);
                lblTitle.setForeground(Color.WHITE); // Màu chữ trắng
                lblTitle.setFont(new Font("SansSerif", Font.BOLD, 28));

        JLabel jLB_QueQuan = new JLabel("Quê quán");
        jLB_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_QueQuan.setBounds(10, 74, 86, 34);
        contentPane.add(jLB_QueQuan);

        JLabel jLB_MaSinhVien = new JLabel("Mã sinh viên");
        jLB_MaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_MaSinhVien.setBounds(307, 72, 115, 34);
        contentPane.add(jLB_MaSinhVien);

        textField_MaSinhVien_TimKiem = new JTextField();
        textField_MaSinhVien_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_MaSinhVien_TimKiem.setColumns(10);
        textField_MaSinhVien_TimKiem.setBounds(419, 74, 105, 34);
        contentPane.add(textField_MaSinhVien_TimKiem);

        JButton jBT_TimKiem = new JButton("Tìm kiếm");
        jBT_TimKiem.addActionListener(aL);
        jBT_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_TimKiem.setBounds(735, 75, 115, 32);
        contentPane.add(jBT_TimKiem);

        textField_MaLop_TimKiem = new JTextField();
        textField_MaLop_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_MaLop_TimKiem.setColumns(10);
        textField_MaLop_TimKiem.setBounds(600, 74, 105, 34);
        contentPane.add(textField_MaLop_TimKiem);

        comboBox_QueQuan_TimKiem = new JComboBox();
        ArrayList<Tinh> listTinh = Tinh.getDanhSachTinh();
        comboBox_QueQuan_TimKiem.addItem("");
        for (Tinh tinh : listTinh) {
            comboBox_QueQuan_TimKiem.addItem(tinh.getTenTinh());
        }
        comboBox_QueQuan_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox_QueQuan_TimKiem.setBounds(106, 74, 191, 34);
        contentPane.add(comboBox_QueQuan_TimKiem);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 121, 955, 2);
        contentPane.add(separator_1);

        JLabel jLB_DanhSachSinhVien = new JLabel("Danh sách sinh viên");
        jLB_DanhSachSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 21));
        jLB_DanhSachSinhVien.setBounds(10, 134, 189, 19);
        contentPane.add(jLB_DanhSachSinhVien);

        table = new JTable();
        table.setFont(new Font(" Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Mã thí sinh", "Họ và tên", "Quê quán", "Ngày sinh", "Giới tính", "Mã lớp", "Điểm môn 1", "Điểm môn 2", "Điểm môn 3",
            }
        ));
        table.setRowHeight(23);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 164, 955, 224);
        contentPane.add(scrollPane);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(10, 399, 955, 2);
        contentPane.add(separator_1_1);

        JLabel jLB_ThongTinSinhVien = new JLabel("Thông tin sinh viên");
        jLB_ThongTinSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 21));
        jLB_ThongTinSinhVien.setBounds(10, 412, 189, 25);
        contentPane.add(jLB_ThongTinSinhVien);

        JLabel jLB_MaSinhVien_1 = new JLabel("Mã sinh viên");
        jLB_MaSinhVien_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_MaSinhVien_1.setBounds(10, 445, 105, 23);
        contentPane.add(jLB_MaSinhVien_1);

        textField_ID = new JTextField();
        textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_ID.setColumns(10);
        textField_ID.setBounds(135, 443, 135, 28);
        contentPane.add(textField_ID);

        JLabel jLB_HoVaTen = new JLabel("Họ và tên");
        jLB_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_HoVaTen.setBounds(10, 481, 81, 23);
        contentPane.add(jLB_HoVaTen);

        textField_HoVaTen = new JTextField();
        textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_HoVaTen.setColumns(10);
        textField_HoVaTen.setBounds(135, 479, 135, 28);
        contentPane.add(textField_HoVaTen);

        JLabel jLB_QueQuan_1 = new JLabel("Quê quán");
        jLB_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_QueQuan_1.setBounds(369, 486, 83, 23);
        contentPane.add(jLB_QueQuan_1);

        comboBox_QueQuan = new JComboBox();
        listTinh = Tinh.getDanhSachTinh();
        comboBox_QueQuan.addItem("");
        for (Tinh tinh : listTinh) {
            comboBox_QueQuan.addItem(tinh.getTenTinh());
        }
        comboBox_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox_QueQuan.setBounds(494, 478, 135, 33);
        contentPane.add(comboBox_QueQuan);

        JLabel jLB_NgaySinh = new JLabel("Ngày sinh");
        jLB_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_NgaySinh.setBounds(369, 522, 83, 23);
        contentPane.add(jLB_NgaySinh);

        textField_NgaySinh = new JTextField();
        textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_NgaySinh.setColumns(10);
        textField_NgaySinh.setBounds(494, 522, 135, 28);
        contentPane.add(textField_NgaySinh);

        JLabel jLB_GioiTinh = new JLabel("Giới tính");
        jLB_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_GioiTinh.setBounds(369, 445, 86, 23);
        contentPane.add(jLB_GioiTinh);

        jRadioButton_Nam = new JRadioButton("Nam");
        jRadioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jRadioButton_Nam.setBounds(491, 447, 72, 23);
        contentPane.add(jRadioButton_Nam);

        jRadioButton_Nu = new JRadioButton("Nữ");
        jRadioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jRadioButton_Nu.setBounds(565, 447, 72, 23);
        contentPane.add(jRadioButton_Nu);

        btGroup_GioiTinh = new ButtonGroup();
        btGroup_GioiTinh.add(jRadioButton_Nam);
        btGroup_GioiTinh.add(jRadioButton_Nu);

        JLabel jLB_Mon1 = new JLabel("Môn 1");
        jLB_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_Mon1.setBounds(724, 444, 52, 23);
        contentPane.add(jLB_Mon1);

        textField_Mon1 = new JTextField();
        textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Mon1.setColumns(10);
        textField_Mon1.setBounds(816, 442, 135, 28);
        contentPane.add(textField_Mon1);

        JLabel jLB_Mon2 = new JLabel("Môn 2");
        jLB_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_Mon2.setBounds(724, 483, 52, 23);
        contentPane.add(jLB_Mon2);

        textField_1_Mon2 = new JTextField();
        textField_1_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_1_Mon2.setColumns(10);
        textField_1_Mon2.setBounds(816, 481, 135, 28);
        contentPane.add(textField_1_Mon2);

        JLabel jLB_Mon3 = new JLabel("Môn 3");
        jLB_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_Mon3.setBounds(724, 519, 52, 23);
        contentPane.add(jLB_Mon3);

        textField_3_Mon3 = new JTextField();
        textField_3_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_3_Mon3.setColumns(10);
        textField_3_Mon3.setBounds(816, 517, 135, 28);
        contentPane.add(textField_3_Mon3);

        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setBounds(10, 561, 955, 6);
        contentPane.add(separator_1_1_1);

        JButton jBT_Them = new JButton("Thêm");
        jBT_Them.addActionListener(aL);
        jBT_Them.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_Them.setBounds(10, 572, 123, 32);
        contentPane.add(jBT_Them);

        JButton jBT_Xoa = new JButton("Xoá");
        jBT_Xoa.addActionListener(aL);
        jBT_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_Xoa.setBounds(222, 572, 123, 32);
        contentPane.add(jBT_Xoa);

        JButton jBT_CapNhat = new JButton("Cập nhật");
        jBT_CapNhat.addActionListener(aL);
        jBT_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_CapNhat.setBounds(431, 572, 123, 32);
        contentPane.add(jBT_CapNhat);

        JButton jBT_Luu = new JButton("Lưu");
        jBT_Luu.addActionListener(aL);
        jBT_Luu.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_Luu.setBounds(635, 572, 123, 32);
        contentPane.add(jBT_Luu);

        JButton jBT_HuyBo = new JButton("Huỷ bỏ");
        jBT_HuyBo.addActionListener(aL);
        jBT_HuyBo.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_HuyBo.setBounds(842, 572, 123, 32);
        contentPane.add(jBT_HuyBo);

        JButton jBT_HuyTim = new JButton("Huỷ tìm");
        jBT_HuyTim.addActionListener(aL);
        jBT_HuyTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jBT_HuyTim.setBounds(860, 75, 105, 32);
        contentPane.add(jBT_HuyTim);

        JLabel jLB_MaLop = new JLabel("Mã lớp");
        jLB_MaLop.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_MaLop.setBounds(534, 72, 63, 34);
        contentPane.add(jLB_MaLop);

        JLabel jLB_MaLop_1 = new JLabel("Mã lớp");
        jLB_MaLop_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jLB_MaLop_1.setBounds(10, 517, 83, 23);
        contentPane.add(jLB_MaLop_1);

        textField_MaLop = new JTextField();
        textField_MaLop.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_MaLop.setColumns(10);
        textField_MaLop.setBounds(135, 515, 135, 28);
        contentPane.add(textField_MaLop);

        this.setVisible(true);
    }

    private void TableModel(Object[][] objects, String[] strings) {
        // TODO Auto-generated method stub
    }

    public void xoaForm() {
        textField_ID.setText("");
        textField_HoVaTen.setText("");
        textField_NgaySinh.setText("");
        textField_Mon1.setText("");
        textField_1_Mon2.setText("");
        textField_3_Mon3.setText("");
        textField_MaLop.setText(""); // Reset mã lớp
        comboBox_QueQuan.setSelectedIndex(-1);
        btGroup_GioiTinh.clearSelection();
    }

    public void themSinhVienVaoTable(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(
            new Object[] {
                ts.getMaThiSinh() + "",
                ts.getTenThiSinh(),
                ts.getQueQuan().getTenTinh(),
                ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/" + (ts.getNgaySinh().getYear() + 1900),
                (ts.getGioiTinh() ? "Nam" : "Nữ"),
                ts.getMaLop(), // Đảm bảo rằng mã lớp được thêm vào đây
                ts.getDiemMon1() + "",
                ts.getDiemMon2() + "",
                ts.getDiemMon3() + "",
            });
    }

    public void themHoacCapNhatThiSinh(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if (!this.model.kiemTraTonTai(ts)) {
            this.model.insert(ts);
            this.themSinhVienVaoTable(ts);
        } else {
            this.model.update(ts);
            int soLuongDong = model_table.getRowCount();
            for (int i = 0; i < soLuongDong; i++) {
                String id = model_table.getValueAt(i, 0) + "";
                if (id.equals(ts.getMaThiSinh() + "")) {
                    model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
                    model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
                    model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
                    model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/" + (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
                    model_table.setValueAt(ts.getGioiTinh() ? "Nam" : "Nữ" + "", i, 4);
                    model_table.setValueAt(ts.getMaLop(), i, 5); // Cập nhật mã lớp
                    model_table.setValueAt(ts.getDiemMon1() + "", i, 6);
                    model_table.setValueAt(ts.getDiemMon2() + "", i, 7);
                    model_table.setValueAt(ts.getDiemMon3() + "", i, 8);
                }
            }
        }
    }

    public ThiSinh getThiSinhDangChon() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
        String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
        Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
        String s_ngaySinh = model_table.getValueAt(i_row, 3) + "/";
        Date ngaySinh = new Date(s_ngaySinh);
        String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
        Boolean gioiTinh = textGioiTinh.equals("Nam");
        float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
        float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
        float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 8) + "");
        String maLop = model_table.getValueAt(i_row, 5) + ""; // Lấy mã lớp từ bảng

        ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3, maLop);
        return ts;
    }

    public void hienThiThongTinSinhVienDaChon() {
        ThiSinh ts = getThiSinhDangChon();

        this.textField_ID.setText(ts.getMaThiSinh() + "");
        this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
        this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
        
        // Định dạng ngày sinh trước khi hiển thị
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String s_ngaySinh = sdf.format(ts.getNgaySinh());
        this.textField_NgaySinh.setText(s_ngaySinh + "");
        
        if (ts.getGioiTinh()) {
            jRadioButton_Nam.setSelected(true);
        } else {
            jRadioButton_Nu.setSelected(true);
        }
        this.textField_Mon1.setText(ts.getDiemMon1() + "");
        this.textField_1_Mon2.setText(ts.getDiemMon2() + "");
        this.textField_3_Mon3.setText(ts.getDiemMon3() + "");
        this.textField_MaLop.setText(ts.getMaLop()); // Hiển thị mã lớp
    }

    public void thucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();  //Đang chọn dòng nào
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá dòng đã chọn ?");
        if(luaChon == JOptionPane.YES_OPTION) {  //Chọn nút xoá
            ThiSinh ts = getThiSinhDangChon();
            this.model.delete(ts);
            model_table.removeRow(i_row);
        }
    }

    public void thucHienThemThiSinh() {
    	if (textField_ID.getText().isEmpty() || textField_HoVaTen.getText().isEmpty() || textField_NgaySinh.getText().isEmpty() || textField_Mon1.getText().isEmpty() || textField_1_Mon2.getText().isEmpty() || textField_3_Mon3.getText().isEmpty() ||  textField_MaLop.getText().isEmpty() || comboBox_QueQuan.getSelectedIndex() == 0) 
    		{
    		    JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
    		    return;
    		}

        // Get dữ liệu
        int maThiSinh = Integer.valueOf(this.textField_ID.getText());
        String tenThiSinh = this.textField_HoVaTen.getText();
        int queQuan = this.comboBox_QueQuan.getSelectedIndex() - 1;
        Tinh tinh = Tinh.getTinhByID(queQuan);
        
        // Sử dụng SimpleDateFormat để phân tích ngày sinh
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinh = null;
        try {
            ngaySinh = sdf.parse(this.textField_NgaySinh.getText());
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy");
            return; // Trả về nếu ngày sinh không hợp lệ
        }
        
        Boolean gioiTinh = this.jRadioButton_Nam.isSelected();
        float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
        float diemMon2 = Float.valueOf(this.textField_1_Mon2.getText());
        float diemMon3 = Float.valueOf(this.textField_3_Mon3.getText());
        String maLop = this.textField_MaLop.getText(); // Lấy mã lớp từ trường nhập liệu

        ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3, maLop); // Thêm maLop vào đây
        this.themHoacCapNhatThiSinh(ts);
        
     // Gọi ThiSinhDAO để lưu vào CSDL
        ThiSinhDAO dao = new ThiSinhDAO();
        if (dao.insert(ts)) {
            JOptionPane.showMessageDialog(this, "Lưu thí sinh thành công!");
            this.themHoacCapNhatThiSinh(ts); // Cập nhật vào bảng giao diện
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu thí sinh vào cơ sở dữ liệu.");
        }
    }

    public void thucHienTim() {
        // Lấy các giá trị từ các ô nhập liệu
        int queQuan = this.comboBox_QueQuan_TimKiem.getSelectedIndex() - 1;
        String maThiSinhTimKiem = this.textField_MaSinhVien_TimKiem.getText().trim();
        String maLopTimKiem = this.textField_MaLop_TimKiem.getText().trim(); // Lấy mã lớp từ ô nhập liệu

        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int soLuongDong = model_table.getRowCount();

        // Tạo một tập hợp để lưu trữ ID của sinh viên không đáp ứng tiêu chí tìm kiếm
        Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();

        // Kiểm tra quê quán
        if (queQuan >= 0) {
            Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
            for (int i = 0; i < soLuongDong; i++) {
                String tenTinh = model_table.getValueAt(i, 2) + "";
                String id = model_table.getValueAt(i, 0) + "";
                if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
                    idCuaThiSinhCanXoa.add(Integer.valueOf(id));
                }
            }
        }

        // Kiểm tra mã sinh viên
        if (!maThiSinhTimKiem.isEmpty()) {
            for (int i = 0; i < soLuongDong; i++) {
                String id = model_table.getValueAt(i, 0) + "";
                if (!id.equals(maThiSinhTimKiem)) {
                    idCuaThiSinhCanXoa.add(Integer.valueOf(id));
                }
            }
        }

        // Kiểm tra mã lớp
        if (!maLopTimKiem.isEmpty()) {
            for (int i = 0; i < soLuongDong; i++) {
                String maLop = model_table.getValueAt(i, 5) + ""; // Giả sử cột mã lớp là cột thứ 5
                if (!maLop.equals(maLopTimKiem)) {
                    idCuaThiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0) + ""));  //Xoá những bạn không cùng mã lớp tìm kiếm
                }
            }
        }

        // Xóa những sinh viên không đáp ứng tiêu chí tìm kiếm
        for (Integer idCanXoa : idCuaThiSinhCanXoa) {
            for (int i = 0; i < soLuongDong; i++) {
                String idTrongTable = model_table.getValueAt(i, 0) + "";
                if (idTrongTable.equals(idCanXoa.toString())) {
                    try {
                        model_table.removeRow(i);
                        break; // Thoát khỏi vòng lặp sau khi xóa
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void thucHienTaiLaiDuLieu() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                model_table.removeRow(0);
            }
        }
        for (ThiSinh ts : this.model.getDanhSachThiSinh()) {
            this.themSinhVienVaoTable(ts);
        }
    }

    public void hienThiAbout() {
        JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã tin tưởng và sử dụng phần mềm của tôi!\n"
                + "Nếu bạn có bất kỳ câu hỏi hay cần hỗ trợ, đừng ngần ngại liên hệ với tôi.\n"
                + "Chúc bạn luôn thành công và trải nghiệm tuyệt vời với phần mềm của tôi!\n"
                + "Trân trọng,\n"
                + "[Lê Phi Anh]");
    }

    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Thoát khỏi chương trình ?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {  //Chọn nút xoá
            System.exit(0);
        }
    }

    public void saveFile(String path) {
        try {
            this.model.setTenFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (ThiSinh ts : this.model.getDanhSachThiSinh()) {
                oos.writeObject(ts);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFile(File file) {
        ArrayList<ThiSinh> danhSach = new ArrayList<>();
        try {
            this.model.setTenFile(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    ThiSinh ts = (ThiSinh) ois.readObject();
                    danhSach.add(ts);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.model.setDanhSachThiSinh(danhSach);
    }

    public void thucHienSaveFile() {
        if (this.model.getTenFile().length() > 0) {  //Kiểm tra đã có tên của tệp chưa
            saveFile(this.model.getTenFile());
        } else {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                saveFile(file.getAbsolutePath());
            }
        }
    }

    public void thucHienOpenFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file);
            thucHienTaiLaiDuLieu();
        }
    }
}

