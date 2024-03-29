package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.project.domain.HoaDon;
import com.hotel.project.repository.HoaDonRepository;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class TestPhongThang extends JFrame {

	/**
	 * Create the panel.
	 */
	
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelDSHoaDon;
	private JTable table;
	private JTextField textField_1;
	private JButton btnThngK;
	private HoaDonRepository hoaDonRepository;
	private ThongKeTheoNam thongKeTheoNam;
	private List<HoaDon> listHoaDon;
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	
	public TestPhongThang() {

		setBounds(359, 0, 1543, 1008);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblThngKDoanh = new JLabel("THỐNG KÊ DOANH THU");
		lblThngKDoanh.setForeground(Color.RED);
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblThngKDoanh.setBounds(255, 0, 1014, 90);
		getContentPane().add(lblThngKDoanh);
		
		JLabel lblThngKTheo = new JLabel("Thống kê theo:");
		lblThngKTheo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblThngKTheo.setBounds(314, 83, 165, 56);
		getContentPane().add(lblThngKTheo);
		ButtonGroup group= new ButtonGroup();
		
		btnThngK = new JButton("Thống kê");
		btnThngK.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnThngK.setBounds(942, 83, 129, 43);
		getContentPane().add(btnThngK);
		
		JLabel lblDanhSchHa = new JLabel("Danh sách hóa đơn");
		lblDanhSchHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchHa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDanhSchHa.setBounds(12, 406, 472, 38);
		getContentPane().add(lblDanhSchHa);
		
		//----------------------- Hiện thị danh sách hóa đơn -------------------
		
		String[] colHeader = { "STT", "Mã hóa đơn", "Ngày lập","Mã phòng","Loại phòng","Giá phòng"};
		modelDSHoaDon = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelDSHoaDon);	
		listHoaDon=getListHoaDon();	
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		scrollPane.setBounds(111, 455, 1289, 390);
		getContentPane().add(scrollPane);
		
		JButton btnXutExcel = new JButton("Xuất Excel");
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXutExcel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnXutExcel.setBounds(1218, 870, 145, 38);
		getContentPane().add(btnXutExcel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(610, 83, 92, 41);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2017","2018","2019","2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBox_1.setBounds(800, 83, 99, 42);
		getContentPane().add(comboBox_1);
		
		JLabel lblThng = new JLabel("Tháng");
		lblThng.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblThng.setBounds(509, 98, 92, 26);
		getContentPane().add(lblThng);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNm.setBounds(724, 98, 64, 26);
		getContentPane().add(lblNm);
		
		/*
		 * JButton btnQuayV = new JButton("Quay về"); btnQuayV.setFont(new
		 * Font("Times New Roman", Font.PLAIN, 32)); btnQuayV.setBounds(86, 671, 174,
		 * 56); add(btnQuayV);
		 */
		
		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THỐNG KÊ DOANH THU");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);
		Box b = Box.createVerticalBox();
		b.add(lblTieuDe);
		
		table.setModel(modelDSHoaDon);
		scrollPane.setViewportView(table);
		
		JButton btnDuLieu = new JButton("Biểu đồ");
		btnDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDuLieu.setBounds(968, 870, 193, 41);
		getContentPane().add(btnDuLieu);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
		table.setRowHeight(40);
		table.setSelectionBackground(new Color(232,57,95));
		table.setSelectionForeground(new Color(255,255,255));
		table.setBackground(new Color(255,255,255));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 199, 313, 160);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTngDanhThu = new JLabel("Số lượng loại phòng đặt nhiều nhất");
		lblTngDanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngDanhThu.setBounds(-18, 13, 275, 34);
		panel.add(lblTngDanhThu);
		
		label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label.setBounds(58, 60, 199, 43);
		panel.add(label);
		
		label6 = new JLabel("");
		label6.setBounds(57, 107, 200, 31);
		label6.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(label6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(427, 199, 313, 160);
		getContentPane().add(panel_1);
		
		JLabel lblSLng = new JLabel("Số lượng phòng đã sử dụng");
		lblSLng.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng.setBounds(0, 13, 301, 34);
		panel_1.add(lblSLng);
		
		label1 = new JLabel("");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label1.setBounds(53, 60, 199, 43);
		panel_1.add(label1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(800, 199, 313, 160);
		getContentPane().add(panel_1_1);
		
		JLabel lblSLng_1 = new JLabel("Phòng có số lượng đặt nhiều nhất");
		lblSLng_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng_1.setBounds(0, 13, 289, 34);
		panel_1_1.add(lblSLng_1);
		
		label2 = new JLabel("");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label2.setBounds(28, 49, 199, 40);
		panel_1_1.add(label2);
		
		label4 = new JLabel("");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label4.setBounds(28, 102, 222, 31);
		panel_1_1.add(label4);
		
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(1169, 199, 313, 160);
		getContentPane().add(panel_1_2);
		
		JLabel lblSLng_2 = new JLabel("Phòng có số lượng đặt ít nhất");
		lblSLng_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng_2.setBounds(-15, 13, 289, 40);
		panel_1_2.add(lblSLng_2);
		
		label3 = new JLabel("");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label3.setBounds(34, 61, 199, 34);
		panel_1_2.add(label3);
		
		
		label5 = new JLabel("");
		label5.setBounds(34, 98, 199, 34);
		label5.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel_1_2.add(label5);
	}
	public static void main(String[] args) {
		test2 test2=new test2();
		test2.setVisible(true);
	}
}
