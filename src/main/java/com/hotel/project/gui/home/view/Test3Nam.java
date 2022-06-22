package com.hotel.project.gui.home.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Test3Nam extends JFrame {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelDSHoaDon;
	private JTable table;
	private JTextField textField_1;
	private JButton btnThngK;
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	public Test3Nam() {

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
		btnThngK.setBounds(835, 83, 129, 43);
		getContentPane().add(btnThngK);
		
		JLabel lblDanhSchHa = new JLabel("Danh sách hóa đơn");
		lblDanhSchHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchHa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDanhSchHa.setBounds(12, 406, 472, 38);
		getContentPane().add(lblDanhSchHa);
		
		//----------------------- Hiện thị danh sách hóa đơn -------------------
		
		String[] colHeader = { "STT", "Mã hóa đơn", "Ngày lập","Người lập","Tổng tiền"};
		modelDSHoaDon = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelDSHoaDon);	
		//listHoaDon=getListHoaDon();	
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2017","2018","2019","2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBox_1.setBounds(680, 83, 99, 42);
		getContentPane().add(comboBox_1);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNm.setBounds(581, 98, 64, 26);
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
		
		JLabel lblTngDanhThu = new JLabel("Tổng danh thu trong tháng");
		lblTngDanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngDanhThu.setBounds(-18, 13, 275, 34);
		panel.add(lblTngDanhThu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(58, 60, 199, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(427, 199, 313, 160);
		getContentPane().add(panel_1);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng.setBounds(0, 13, 155, 34);
		panel_1.add(lblSLng);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(35, 47, 199, 43);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(800, 199, 313, 160);
		getContentPane().add(panel_1_1);
		
		JLabel lblSLng_1 = new JLabel("Doanh thu cao nhất của 1 ngày");
		lblSLng_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng_1.setBounds(0, 13, 289, 34);
		panel_1_1.add(lblSLng_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(28, 49, 199, 40);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(28, 102, 222, 31);
		panel_1_1.add(lblNewLabel_4);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(1169, 199, 313, 160);
		getContentPane().add(panel_1_2);
		
		JLabel lblSLng_2 = new JLabel("Số lượng đơn hàng cao nhất của 1 ngày");
		lblSLng_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng_2.setBounds(-15, 13, 289, 40);
		panel_1_2.add(lblSLng_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(34, 61, 199, 34);
		panel_1_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(34, 98, 199, 34);
		panel_1_2.add(lblNewLabel_5);
	}
	
}
