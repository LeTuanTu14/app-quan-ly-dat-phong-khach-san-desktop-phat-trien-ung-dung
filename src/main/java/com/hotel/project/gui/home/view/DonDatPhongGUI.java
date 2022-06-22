package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.NhanVien;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.impl.HoaDonRepositoryImpl;
import com.hotel.project.repository.impl.KhachHangRepositoryImpl;
import com.hotel.project.repository.impl.LoaiPhongRepositoryImpl;
import com.hotel.project.repository.impl.NhanVienRepositoryImpl;
import com.hotel.project.repository.impl.PhongRepositoryImpl;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

@Component
public class DonDatPhongGUI extends JFrame {
	private JTable table;
	private JTable table1;
	private JTextField txtTenKH;
	private JTextField textcmnd;
	private JTextField txtsdt;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JButton btnThem;
	private JComboBox<String> cbLoaiPhong, cbThue_ngay, cbThue_thang, cbThue_nam, cbTra_ngay, cbTra_thang, cbTra_nam;
	private JPanel contentPane;
	private DefaultTableModel model, model1;
	private List<Phong> listPhong = new ArrayList<Phong>();
	private List<String> listPhongDaDat = new ArrayList<String>();
	private KhachHang kh = new KhachHang();
	
	
	@Autowired
	private QLDatPhongGUI qldp;
	@Autowired
	private NhanVienRepositoryImpl nhanvienrepo;
	@Autowired
	private KhachHangRepositoryImpl khachhangrepo;
	@Autowired
	private PhongRepositoryImpl phongrepo;
	@Autowired
	private HoaDonRepositoryImpl hoadonrepo;
	@Autowired
	private LoaiPhongRepositoryImpl loaiphongrepo;
	
	
	
	
	public JTextField getTxtMaNV() {
		return txtMaNV;
	}

	public void setTxtMaNV(JTextField txtMaNV) {
		this.txtMaNV = txtMaNV;
	}

	public JTextField getTxtTenNV() {
		return txtTenNV;
	}

	public void setTxtTenNV(JTextField txtTenNV) {
		this.txtTenNV = txtTenNV;
	}

	/**
	 * Create the frame.
	 */
	public DonDatPhongGUI() {

	}
	
	@PostConstruct
	public void preparePane() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(359, 0, 1543, 1008);
		setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JLabel lblTieuDe = new JLabel("ĐƠN ĐẶT PHÒNG");
		lblTieuDe.setBounds(1, 12, 1525, 36);
		lblTieuDe.setForeground(new Color(255, 69, 0));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTieuDe);
		
		JPanel pnND = new JPanel();
		pnND.setBounds(0, 36, 1525, 925);
		pnND.setBorder(null);
		pnND.setBackground(Color.WHITE);
		getContentPane().add(pnND);
		pnND.setLayout(null);
		
		JButton btnDatPhong = new JButton("Đặt Phòng");
		btnDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDatPhong.setBounds(1357, 870, 123, 42);
		pnND.add(btnDatPhong);
		
		JPanel pnPhongTrong = new JPanel();
		pnPhongTrong.setBackground(Color.WHITE);
		pnPhongTrong.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u00F2ng Tr\u1ED1ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnPhongTrong.setBounds(30, 318, 715, 535);
		pnND.add(pnPhongTrong);
		pnPhongTrong.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(12, 81, 691, 431);
		pnPhongTrong.add(scrollPane_1);
		
		model1 = new DefaultTableModel(
				new String[] {
						"STT", "Mã Phòng", "Loại Phòng", "Đơn Giá"
				}, 0){
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		 };
		 
		 table1 = new JTable();
		 table1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  table1.setModel(model1);
		  scrollPane_1.setViewportView(table1);
		  table1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		  table1.getTableHeader().setOpaque(false);
		  table1.getTableHeader().setBackground(new Color(32,136,203));
		  table1.getTableHeader().setForeground(new Color(255,255,255));
		  table1.getTableHeader().setPreferredSize(new Dimension(scrollPane_1.getWidth(), 40));
		  table1.setRowHeight(40);
		  table1.setSelectionBackground(new Color(232,57,95));
		  table1.setSelectionForeground(new Color(255,255,255));
		  table1.setBackground(new Color(255,255,255));
		
		Panel pnLoaiPhong = new Panel();
		pnLoaiPhong.setBounds(12, 26, 282, 42);
		pnPhongTrong.add(pnLoaiPhong);
		pnLoaiPhong.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLoaiPhong = new JLabel("Lọc Loại Phòng            ");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnLoaiPhong.add(lblLoaiPhong, BorderLayout.WEST);
		
		cbLoaiPhong = new JComboBox();
		pnLoaiPhong.add(cbLoaiPhong, BorderLayout.EAST);
		cbLoaiPhong.setBackground(Color.WHITE);
		cbLoaiPhong.setModel(new DefaultComboBoxModel(new String[] {"THƯỜNG", "VIP", "GIA ĐÌNH",""}));
		cbLoaiPhong.setSelectedIndex(3);
		cbLoaiPhong.setMaximumRowCount(3);
		cbLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(580, 26, 123, 42);
		pnPhongTrong.add(btnThem);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLoad.setBounds(300, 26, 87, 42);
		pnPhongTrong.add(btnLoad);
		
		JPanel pnPhongThue = new JPanel();
		pnPhongThue.setBackground(Color.WHITE);
		pnPhongThue.setForeground(Color.BLACK);
		pnPhongThue.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u00F2ng Thu\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnPhongThue.setBounds(757, 318, 743, 535);
		pnND.add(pnPhongThue);
		pnPhongThue.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 84, 719, 431);
		pnPhongThue.add(scrollPane);
		
		model = new DefaultTableModel(
				new String[] {
						"STT", "Mã Phòng", "Loại Phòng", "Đơn Giá"
				}, 0){
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		
		  table = new JTable();
		  table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  table.setModel(model);
		  scrollPane.setViewportView(table);
		  table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		  table.getTableHeader().setOpaque(false);
		  table.getTableHeader().setBackground(new Color(32,136,203));
		  table.getTableHeader().setForeground(new Color(255,255,255));
		  table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
		  table.setRowHeight(40);
		  table.setSelectionBackground(new Color(232,57,95));
		  table.setSelectionForeground(new Color(255,255,255));
		  table.setBackground(new Color(255,255,255));
		  scrollPane.setViewportView(table);
		  
		
		
		JPanel pnMaNV = new JPanel();
		pnMaNV.setBackground(Color.WHITE);
		pnMaNV.setBounds(1076, 40, 389, 40);
		pnND.add(pnMaNV);
		pnMaNV.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên      ");
		lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnMaNV.add(lblMaNV, BorderLayout.WEST);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBackground(Color.WHITE);
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaNV.setColumns(10);
		pnMaNV.add(txtMaNV, BorderLayout.CENTER);
		
		JPanel pnTenNV = new JPanel();
		pnTenNV.setBackground(Color.WHITE);
		pnTenNV.setBounds(1076, 98, 389, 42);
		pnND.add(pnTenNV);
		pnTenNV.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTenNV = new JLabel("Tên Nhân Viên     ");
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnTenNV.add(lblTenNV, BorderLayout.WEST);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setBackground(Color.WHITE);
		txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenNV.setColumns(10);
		pnTenNV.add(txtTenNV, BorderLayout.CENTER);
		
		JPanel pnTTDP = new JPanel();
		pnTTDP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pnTTDP.setBackground(Color.WHITE);
		pnTTDP.setBounds(30, 16, 997, 294);
		pnND.add(pnTTDP);
		pnTTDP.setLayout(null);
		
		cbThue_ngay = new JComboBox();
		cbThue_ngay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbThue_ngay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbThue_ngay.setBounds(659, 26, 43, 31);
		pnTTDP.add(cbThue_ngay);
		
		cbThue_nam = new JComboBox();
		cbThue_nam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbThue_nam.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		cbThue_nam.setBounds(897, 23, 62, 35);
		pnTTDP.add(cbThue_nam);
		
		cbThue_thang = new JComboBox();
		cbThue_thang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbThue_thang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbThue_thang.setBounds(789, 26, 43, 31);
		pnTTDP.add(cbThue_thang);
		
		Panel pnCMND = new Panel();
		pnCMND.setBounds(22, 22, 421, 42);
		pnTTDP.add(pnCMND);
		pnCMND.setLayout(new BorderLayout(0, 0));
		
		textcmnd = new JTextField();
		pnCMND.add(textcmnd, BorderLayout.CENTER);
		textcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textcmnd.setColumns(10);
		
		JLabel lblcmnd = new JLabel("Số CMND           ");
		pnCMND.add(lblcmnd, BorderLayout.WEST);
		lblcmnd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBounds(321, 81, 123, 42);
		pnTTDP.add(btnTim);
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		Panel pnTenKH = new Panel();
		pnTenKH.setBounds(22, 140, 421, 42);
		pnTTDP.add(pnTenKH);
		pnTenKH.setLayout(new BorderLayout(0, 0));
		
		txtTenKH = new JTextField();
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setEditable(false);
		pnTenKH.add(txtTenKH, BorderLayout.CENTER);
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng ");
		pnTenKH.add(lblTenKH, BorderLayout.WEST);
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		Panel pnSDT = new Panel();
		pnSDT.setBounds(22, 199, 421, 42);
		pnTTDP.add(pnSDT);
		pnSDT.setLayout(new BorderLayout(0, 0));
		
		JLabel lblsdt = new JLabel("Số điện thoại      ");
		pnSDT.add(lblsdt, BorderLayout.WEST);
		lblsdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtsdt = new JTextField();
		txtsdt.setBackground(Color.WHITE);
		txtsdt.setEditable(false);
		pnSDT.add(txtsdt, BorderLayout.CENTER);
		txtsdt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtsdt.setColumns(10);
		
		JLabel lblThue_ngay = new JLabel("Ngày");
		lblThue_ngay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblThue_ngay.setBackground(Color.WHITE);
		lblThue_ngay.setBounds(601, 23, 49, 38);
		pnTTDP.add(lblThue_ngay);
		
		JLabel lblTra = new JLabel("Ngày Trả:");
		lblTra.setBounds(484, 78, 98, 42);
		pnTTDP.add(lblTra);
		lblTra.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblThue = new JLabel("Ngày Thuê:");
		lblThue.setBounds(483, 23, 99, 38);
		pnTTDP.add(lblThue);
		lblThue.setBackground(Color.WHITE);
		lblThue.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblThue_thang = new JLabel("Tháng");
		lblThue_thang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblThue_thang.setBackground(Color.WHITE);
		lblThue_thang.setBounds(716, 23, 58, 38);
		pnTTDP.add(lblThue_thang);
		
		JLabel lblThue_nam = new JLabel("Năm");
		lblThue_nam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblThue_nam.setBackground(Color.WHITE);
		lblThue_nam.setBounds(845, 25, 44, 38);
		pnTTDP.add(lblThue_nam);
		
		JLabel lblTra_ngay = new JLabel("Ngày");
		lblTra_ngay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTra_ngay.setBackground(Color.WHITE);
		lblTra_ngay.setBounds(601, 79, 49, 38);
		pnTTDP.add(lblTra_ngay);
		
		cbTra_ngay = new JComboBox();
		cbTra_ngay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbTra_ngay.setSelectedIndex(0);
		cbTra_ngay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbTra_ngay.setBounds(659, 82, 43, 31);
		pnTTDP.add(cbTra_ngay);
		
		JLabel lblTra_thang = new JLabel("Tháng");
		lblTra_thang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTra_thang.setBackground(Color.WHITE);
		lblTra_thang.setBounds(716, 79, 58, 38);
		pnTTDP.add(lblTra_thang);
		
		cbTra_thang = new JComboBox();
		cbTra_thang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbTra_thang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbTra_thang.setBounds(789, 82, 43, 31);
		pnTTDP.add(cbTra_thang);
		
		JLabel lblTra_nam = new JLabel("Năm");
		lblTra_nam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTra_nam.setBackground(Color.WHITE);
		lblTra_nam.setBounds(844, 81, 44, 38);
		pnTTDP.add(lblTra_nam);
		
		cbTra_nam = new JComboBox();
		cbTra_nam.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		cbTra_nam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbTra_nam.setBounds(897, 79, 62, 35);
		pnTTDP.add(cbTra_nam);
		
		JPanel pnTTNV = new JPanel();
		pnTTNV.setBounds(1042, 15, 458, 295);
		pnND.add(pnTTNV);
		pnTTNV.setLayout(null);
		pnTTNV.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pnTTNV.setBackground(Color.WHITE);
		
		/**
		 * Doc du lieu vao bang
		 */
		//List<Phong> list1 = phongrepo.findAllByTenLoai("THUONG");
		//docDLVaoBang(list1, "THƯỜNG");
		table1.setEnabled(false);
		cbLoaiPhong.setEnabled(false);
		
		/**
		 * load danh sach phong
		 */
		cbThue_nam.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	table1.setEnabled(false);
				cbLoaiPhong.setEnabled(false);;
				btnThem.setEnabled(false);
				cbLoaiPhong.setSelectedIndex(3);
				reset(model);
				reset(model1);
				listPhongDaDat = new ArrayList<String>();
				
				
				
		    }
		});
		cbThue_thang.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	table1.setEnabled(false);
				cbLoaiPhong.setEnabled(false);;
				btnThem.setEnabled(false);
				cbLoaiPhong.setSelectedIndex(3);
				reset(model);
				reset(model1);
				listPhongDaDat = new ArrayList<String>();
				
				
		    }
		});
		cbThue_ngay.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	table1.setEnabled(false);
				cbLoaiPhong.setEnabled(false);;
				btnThem.setEnabled(false);
				cbLoaiPhong.setSelectedIndex(3);
				reset(model);
				reset(model1);
				listPhongDaDat = new ArrayList<String>();
				
				
		    }
		});
		cbTra_nam.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	table1.setEnabled(false);
				cbLoaiPhong.setEnabled(false);;
				btnThem.setEnabled(false);
				cbLoaiPhong.setSelectedIndex(3);
				reset(model);
				reset(model1);
				listPhongDaDat = new ArrayList<String>();
				
				
		    }
		});
		cbTra_thang.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	table1.setEnabled(false);
				cbLoaiPhong.setEnabled(false);;
				btnThem.setEnabled(false);
				cbLoaiPhong.setSelectedIndex(3);
				reset(model);
				reset(model1);
				listPhongDaDat = new ArrayList<String>();
				
				
		    }
		});
		cbTra_ngay.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	table1.setEnabled(false);
				cbLoaiPhong.setEnabled(false);;
				btnThem.setEnabled(false);
				cbLoaiPhong.setSelectedIndex(3);
				reset(model);
				reset(model1);
				listPhongDaDat = new ArrayList<String>();
				
		    }
		});
		btnLoad.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	int ngay_thue = Integer.parseInt(cbThue_ngay.getSelectedItem().toString());
				int thang_thue = Integer.parseInt(cbThue_thang.getSelectedItem().toString());
				int nam_thue = Integer.parseInt(cbThue_nam.getSelectedItem().toString());
				int ngay_tra = Integer.parseInt(cbTra_ngay.getSelectedItem().toString());
				int thang_tra = Integer.parseInt(cbTra_thang.getSelectedItem().toString());
				int nam_tra = Integer.parseInt(cbTra_nam.getSelectedItem().toString());
				
				if(kiemtraNgay(ngay_thue, thang_thue, nam_thue) == true && 
						kiemtraNgay(ngay_tra, thang_tra, nam_tra) == true) {
					LocalDate ngayTra = LocalDate.of(Integer.parseInt(cbTra_nam.getSelectedItem().toString()), 
							Integer.parseInt(cbTra_thang.getSelectedItem().toString()), 
							Integer.parseInt(cbTra_ngay.getSelectedItem().toString()));
					LocalDate ngayThue = LocalDate.of(Integer.parseInt(cbThue_nam.getSelectedItem().toString()), 
							Integer.parseInt(cbThue_thang.getSelectedItem().toString()), 
							Integer.parseInt(cbThue_ngay.getSelectedItem().toString()));
					if(kiemtraNgayDP(ngayThue, ngayTra)) {
						table1.setEnabled(true);
						table.setEnabled(true);
						cbLoaiPhong.setEnabled(true);
						timListPhongDaDat(ngayThue, ngayTra);
						List<Phong> list1 = phongrepo.findAllByTenLoai("THUONG");
						cbLoaiPhong.setSelectedIndex(0);
						docDLVaoBang(list1, "THƯỜNG");
						
						//Tim phong trong
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
				}
		    	
				table1.setEnabled(true);
				cbLoaiPhong.setEditable(true);
		    }
		});
		
		
		/**
		 * Loc phong theo loai phong
		 */
		cbLoaiPhong.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String lp = "";
		    	lp = cbLoaiPhong.getSelectedItem().toString();
		    	reset(model1);
		        if(lp.equalsIgnoreCase("")) {
		        	reset(model1);
		        }else {
		        	List<Phong> list2 = phongrepo.findAllByTenLoai(getTenLoaiPhongTuCB(lp));
			        docDLVaoBang(list2, lp);
		        }
		       
		        
		    }
		});
		
		/**
		 * Tim kiem khach hang
		 */
		btnTim.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String key = "";
		    	key = textcmnd.getText();
		    	if(key.equalsIgnoreCase("")) {
		    		JOptionPane.showMessageDialog(null, "Vui lòng điển số CMND/thẻ căn cước của khách hàng");
		    	}else {
		    		kh = khachhangrepo.findByTheCanCuoc(key);
		    		if(kh == null) {
		    			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
		    		}else {
		    			txtTenKH.setText(kh.getTenKhachHang());
		    			txtsdt.setText(kh.getSoDienThoai());
		    		}
		    	}
		    }
		});
		
		/**
		 * Hien thi nhan vien
		 * 
		 */
		
		//txtTenNV.setText(nhanvien.getTenNhanVien());
		//txtMaNV.setText(nhanvien.getMaNhanVien());
		
		/**
		 * Them phong trong
		 * 
		 */
		btnThem.setEnabled(false);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				themPhongVaoBang();
			}
		});
		
		/*
		 * Mo khoa nut them dich vu
		 * 
		 * */
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnThem.setEnabled(true);
			}
		});
		
		/*
		 * Tao hoa don
		 * 
		 * */
		btnDatPhong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				datPhong();
				qldp.hienthiPhong();
				
			}
		});
		
	}
	
	//Doc du lieu vao bang
	public void docDLVaoBang(List<Phong> list, String lp) {
		int i =1;
		int dem = 0;
		reset(model1);
		/*for(Phong p: list) {
			model1.addRow(new Object[] {
					i, p.getMaPhong(), lp, p.getGiaPhong()
			});
			i++;
		}*/
		
		for(Phong p :list) {
			//Phong trong thoi diem hien tai
			for(String pdd :listPhongDaDat) {
				if(p.getMaPhong().equalsIgnoreCase(pdd)==true) {
					dem++;
				}
			}
			if(dem == 0) {
				model1.addRow(new Object[] {
						i, p.getMaPhong(), lp, p.getGiaPhong()
				});
				i++;
			}
			dem=0;
		}
		table1.setModel(model1);
		
	}
	//Lay ten loai phong tu cb
	public String getTenLoaiPhongTuCB(String tr) {
		String lp = "GIADINH";
		if(tr.equalsIgnoreCase("THƯỜNG")) {
			lp="THUONG";
		}else if(tr.equalsIgnoreCase("VIP")) {
			lp="VIP";
		}
		return lp;
	}
	
	//Lay ten loai phong tu json
	public String getTenLoaiPhongTuJson(String tr) {
		String lp = "GIA ĐÌNH";
		if(tr.equalsIgnoreCase("THUONG")) {
			lp="THƯỜNG";
		}else if(tr.equalsIgnoreCase("VIP")) {
			lp="VIP";
		}
		return lp;
	}
	
	//Tao trang thai tren bang
	public String getTT(boolean tt) {
		if(tt==true) {
			return "Trống";
		}
		return "Đang ở";
	}
	
	//Xoa bang
	public  void reset(DefaultTableModel m)
	{
		m.setRowCount(0);
	}
	
	//Them phong vao bang
	public void themPhongVaoBang() {
		int row = table1.getSelectedRow();
		int i_dau = table.getRowCount();
		
		if(timPhongDaThem(model1.getValueAt(row, 1).toString())) {
			model.addRow(new Object[] {
					i_dau+1, model1.getValueAt(row, 1).toString() , 
					model1.getValueAt(row, 2).toString(), 
					model1.getValueAt(row, 3).toString()
			});
			
			Phong pp = phongrepo.findByMaPhong(model1.getValueAt(row, 1).toString());
			pp.setSoNguoiToiDa(0);
			listPhong.add(pp);
		}
		
	}
	
	//Tim phong da them
	public boolean timPhongDaThem(String maphong) {
		for(Phong ppp:listPhong) {
			if(ppp.getMaPhong().equalsIgnoreCase(maphong)){
				JOptionPane.showMessageDialog(null, "Đã thêm phòng "+maphong);
				return false;
			}
			
		}
		return true;
	}
	
	//Kiem tra ngay dat phong
	public boolean kiemtraNgayDP(LocalDate thue, LocalDate tra) {
		if(thue.isBefore(LocalDate.now())){
			return false;
		}
		if(thue.isAfter(tra)){
			return false;
		}	
		return true;
	}
	//Kiem tra ngay 
	public boolean kiemtraNgay(int ngay, int thang, int nam) {
		if(thang == 1 ||thang == 3 ||thang == 5 ||thang ==7 ||thang == 8 ||thang == 10 ||thang == 12 ) {
			if(ngay > 31)
				return false;
		}
		if(thang == 4 ||thang == 6 ||thang == 9 ||thang ==11) {
			if(ngay > 30)
				return false;
		}
		if(thang == 2) {
			if(nam == 2020 && ngay > 29)
				return false;
			if(nam == 2021 && ngay > 28)
				return false;
		}
		
		return true;
	}
	//Dat phong
	public void datPhong(){
		int ngay_thue = Integer.parseInt(cbThue_ngay.getSelectedItem().toString());
		int thang_thue = Integer.parseInt(cbThue_thang.getSelectedItem().toString());
		int nam_thue = Integer.parseInt(cbThue_nam.getSelectedItem().toString());
		int ngay_tra = Integer.parseInt(cbTra_ngay.getSelectedItem().toString());
		int thang_tra = Integer.parseInt(cbTra_thang.getSelectedItem().toString());
		int nam_tra = Integer.parseInt(cbTra_nam.getSelectedItem().toString());
		
		if(kiemtraNgay(ngay_thue, thang_thue, nam_thue) == true && 
				kiemtraNgay(ngay_tra, thang_tra, nam_tra) == true) {
			LocalDate ngayTra = LocalDate.of(Integer.parseInt(cbTra_nam.getSelectedItem().toString()), 
					Integer.parseInt(cbTra_thang.getSelectedItem().toString()), 
					Integer.parseInt(cbTra_ngay.getSelectedItem().toString()));
			LocalDate ngayThue = LocalDate.of(Integer.parseInt(cbThue_nam.getSelectedItem().toString()), 
					Integer.parseInt(cbThue_thang.getSelectedItem().toString()), 
					Integer.parseInt(cbThue_ngay.getSelectedItem().toString()));
			if(kiemtraNgayDP(ngayThue, ngayTra)) {
				if(txtTenKH.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Chưa có khách hàng");
				}else if(listPhong.size() == 0){
					JOptionPane.showMessageDialog(null, "Chưa chọn phòng");
				}else {
					HoaDon hd = new HoaDon(LocalDateTime.now(), 
							null, null, ngayThue, ngayTra, false);
					hd.setKhachHang(kh);
					
					
					List<ChiTietHoaDon> chiTietList=new ArrayList<ChiTietHoaDon>();
					for(Phong ppp : listPhong) {
						LoaiPhong loaiPhongTim=loaiphongrepo.findLoaiByMaPhong(ppp.getMaPhong());
						
						ChiTietHoaDon chiTiet=new ChiTietHoaDon(ppp.getMaPhong(),loaiPhongTim.getTenLoai(),ppp.getSoGiuong(),ppp.getSoNguoiToiDa(),ppp.getGiaPhong());		
						chiTiet.setThoiGianTheuDau(null);
						chiTiet.setThoiGianTheuCuoi(null);	
						chiTiet.setTheCanCuoc("");
						chiTiet.setTenKhachHang("");
						chiTiet.setSoDienThoai("");
						chiTiet.setGiaPhong(chiTiet.getDonGia());
						chiTietList.add(chiTiet);
						
						
					}
					
					List<ChiTietDichVu> chiTietDichVuList=new ArrayList<ChiTietDichVu>();	
					hd.setListHoaDon(chiTietList);
					hd.setListDichVu(chiTietDichVuList);
					hd.setNhanVien(nhanvienrepo.findByMaNhanVien(txtMaNV.getText()));
					// tạo ra một hóa đơn mới
					hoadonrepo.addHoaDon(hd);
					
					listPhong = new ArrayList<Phong>();
					JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
					this.dispose();
					resetJframe();
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
		}
		
	}
	//Reset jframe
	public void resetJframe() {
		txtTenKH.setText("");
		txtsdt.setText("");
		textcmnd.setText("");
		cbLoaiPhong.setSelectedIndex(0);
		reset(model1);
		btnThem.setEnabled(false);
		cbThue_nam.setSelectedIndex(0);
		cbThue_ngay.setSelectedIndex(0);
		cbThue_thang.setSelectedIndex(0);
		cbTra_nam.setSelectedIndex(0);
		cbTra_ngay.setSelectedIndex(0);
		cbTra_thang.setSelectedIndex(0);
		listPhongDaDat = new ArrayList<String>();
		
	}
	
	//Tim list phong da dat
	public void timListPhongDaDat(LocalDate ngTh, LocalDate ngTr){
		listPhongDaDat = new ArrayList<String>();
		List<HoaDon> listDonDat = hoadonrepo.findAllByTrangThaiThanhToan();
		for(HoaDon d: listDonDat) {
			if(((d.getThoiGianTheuDau().isEqual(ngTh)==true || d.getThoiGianTheuDau().isAfter(ngTh)==true) && (d.getThoiGianTheuCuoi().isEqual(ngTr)==true || d.getThoiGianTheuCuoi().isBefore(ngTr)==true))||
					(d.getThoiGianTheuDau().isBefore(ngTh)==true && (d.getThoiGianTheuCuoi().isEqual(ngTh)==true || d.getThoiGianTheuCuoi().isAfter(ngTh)==true))||
					(d.getThoiGianTheuCuoi().isAfter(ngTr)==true && (d.getThoiGianTheuDau().isEqual(ngTr)==true||d.getThoiGianTheuDau().isBefore(ngTr)==true))){
				
				
				for(ChiTietHoaDon cthd:d.getListHoaDon()) {
					listPhongDaDat.add(cthd.getMaPhong());
					
				}
				
			}
			
		}
		
	}
	
	//Kiem tra phong
	public boolean kiemtraPhong(String maPhong) {
		for(String ma :listPhongDaDat) {
			if(maPhong.equalsIgnoreCase(ma)) {
				return false;
			}
		}
		
		return true;
	}
		
}
