package com.hotel.project.gui.home.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.gui.home.view.QLThanhToanGUI;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Button;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

@Component
public class HoaDonGUI extends JFrame {
	
		private  String Ngayjdo ;
		private JTable tableDichVu;
		private JTable tablePhong;
		private JTextField txtTen;
		private JTextField txtSDT;
		private JTextField txtCMND;
		private JTextField txtNhanPhong;
		private JTextField txtTheCanCuoc;
		private JTextField txtTienPhong;
		private JTextField txtTongTien;
		private JPanel contentPane;
		private DefaultTableModel modelDichVu;
		private DefaultTableModel modelPhong;
		private String theCanCuoc ="", thoiGianThueDau="";
		private JLabel lblTieuDe;
		static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		
		@Autowired
		private QLThanhToanGUI qLThanhToanGUI;
		
		
		
		public JLabel getLblTieuDe() {
			return lblTieuDe;
		}

		public void setLblTieuDe(JLabel lblTieuDe) {
			this.lblTieuDe = lblTieuDe;
		}

		
		@Autowired
		private HoaDonRepository hoaDonRepository;
		private List<HoaDon> list;
		private String ngayLap;
		private List<ChiTietHoaDon> listPhong;
		private List<ChiTietDichVu> listDichVu;
		private int xxx;
		private int r;
		private double TongTienHD;
		private JLabel lblNewLabel;
		private JTextField txtNgayLapHD;
		
		/**
		 * Create the panel.
		 */
		public HoaDonGUI() {
			
}
		
		@PostConstruct
		public void preparePanel() {
		
		
			setBounds(359, 0, 1543, 1008);
			
			
			setBackground(Color.WHITE);
			setLayout(null);
				
			JLabel lblDichVu = new JLabel("HOÁ ĐƠN");
			lblDichVu.setForeground(new Color(255, 69, 0));
			lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblDichVu.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblDichVu, BorderLayout.NORTH);
			
			JPanel panel = new JPanel();
			
			
			panel.setBorder(null);
			panel.setBackground(SystemColor.menu);
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			Panel panel_1 = new Panel();
			panel_1.setBounds(49, 94, 536, 42);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			txtTen = new JTextField();
			panel_1.add(txtTen, BorderLayout.CENTER);
			txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtTen.setColumns(10);
			txtTen.setEditable(false);
			
			
			JLabel lblNewLabel = new JLabel("Tên khách hàng ");
			panel_1.add(lblNewLabel, BorderLayout.WEST);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			Panel panel_1_2 = new Panel();
			panel_1_2.setBounds(49, 32, 536, 42);
			panel.add(panel_1_2);
			panel_1_2.setLayout(new BorderLayout(0, 0));
			
			txtCMND = new JTextField();
			panel_1_2.add(txtCMND, BorderLayout.CENTER);
			txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtCMND.setColumns(10);
			txtCMND.setEditable(false);
			
			JLabel lblSLng = new JLabel("Số CMND          ");
			panel_1_2.add(lblSLng, BorderLayout.WEST);
			lblSLng.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			Panel panel_1_3 = new Panel();
			panel_1_3.setBounds(49, 152, 536, 42);
			panel.add(panel_1_3);
			panel_1_3.setLayout(new BorderLayout(0, 0));
			
			JLabel lblnGi = new JLabel("Số điện thoại      ");
			panel_1_3.add(lblnGi, BorderLayout.WEST);
			lblnGi.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			txtSDT = new JTextField();
			panel_1_3.add(txtSDT, BorderLayout.CENTER);
			txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setEditable(false);
			
			JButton btnNewButton = new JButton("In hoá đơn");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnNewButton.setBounds(1258, 849, 159, 42);
			panel.add(btnNewButton);
			
			Panel panel_1_1_1 = new Panel();
			panel_1_1_1.setBounds(812, 32, 507, 42);
			panel.add(panel_1_1_1);
			panel_1_1_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Thời Gian Nhận Phòng ");
			lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_1_1.add(lblNewLabel_1_1_1, BorderLayout.WEST);
			
			Panel panel_1_1_1_1 = new Panel();
			panel_1_1_1.add(panel_1_1_1_1, BorderLayout.SOUTH);
			panel_1_1_1_1.setLayout(new BorderLayout(0, 0));
			
			txtNhanPhong = new JTextField();
			panel_1_1_1.add(txtNhanPhong, BorderLayout.CENTER);
			txtNhanPhong.setColumns(10);
			txtNhanPhong.setEditable(false);
			
			Panel panel_1_2_1 = new Panel();
			panel_1_2_1.setBounds(812, 94, 507, 42);
			panel.add(panel_1_2_1);
			panel_1_2_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày lập hoá đơn          ");
			lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_2_1.add(lblNewLabel_1_1_1_1, BorderLayout.WEST);
			
			txtNgayLapHD = new JTextField();
			txtNgayLapHD.setText((String) null);
			txtNgayLapHD.setEditable(false);
			txtNgayLapHD.setColumns(10);
			panel_1_2_1.add(txtNgayLapHD, BorderLayout.CENTER);
			
		
			
			Panel panel_1_2_1_2 = new Panel();
			panel_1_2_1_2.setBounds(798, 849, 435, 42);
			panel.add(panel_1_2_1_2);
			panel_1_2_1_2.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_2_2 = new JLabel("Thành Tiền  ");
			lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_2_1_2.add(lblNewLabel_1_2_2, BorderLayout.WEST);
			
			txtTongTien = new JTextField();
			txtTongTien.setColumns(10);
			panel_1_2_1_2.add(txtTongTien, BorderLayout.CENTER);
			txtTongTien.setEditable(false);
			
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin Ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			panel_2.setBounds(49, 271, 658, 561);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(23, 32, 602, 431);
			panel_2.add(scrollPane_1);
			
			modelPhong = new DefaultTableModel(
					new String[] {
							"STT", "Mã Phòng", "Khách Hàng","Thời Gian Ở", "Đớn Giá", "Thành Tiền"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			tablePhong = new JTable();
			tablePhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tablePhong.setModel(modelPhong);
			scrollPane_1.setViewportView(tablePhong);
			tablePhong.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
			tablePhong.getTableHeader().setOpaque(false);
			tablePhong.getTableHeader().setBackground(new Color(32,136,203));
			tablePhong.getTableHeader().setForeground(new Color(255,255,255));
			tablePhong.getTableHeader().setPreferredSize(new Dimension(scrollPane_1.getWidth(), 40));
			tablePhong.setRowHeight(40);
			tablePhong.setSelectionBackground(new Color(232,57,95));
			tablePhong.setSelectionForeground(new Color(255,255,255));
			tablePhong.setBackground(new Color(255,255,255));
			
			
			Panel panel_1_6 = new Panel();
			panel_1_6.setBounds(173, 469, 455, 39);
			panel_2.add(panel_1_6);
			panel_1_6.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền Phòng ");
			lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_6.add(lblNewLabel_1_2, BorderLayout.WEST);
			
			txtTienPhong = new JTextField();
			txtTienPhong.setColumns(10);
			txtTienPhong.setEditable(false);
			panel_1_6.add(txtTienPhong, BorderLayout.CENTER);
			
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin D\u1ECBch V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panel_3.setBounds(753, 271, 698, 534);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(47, 35, 616, 431);
			panel_3.add(scrollPane);
			
			modelDichVu = new DefaultTableModel(
					new String[] {
							"STT", "Phòng", "Tên Dịch Vụ","Số Lượng", "Đớn Giá", "Thành Tiền"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			tableDichVu = new JTable();
			tableDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableDichVu.setModel(modelDichVu);
			scrollPane.setViewportView(tableDichVu);
			tableDichVu.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
			tableDichVu.getTableHeader().setOpaque(false);
			tableDichVu.getTableHeader().setBackground(new Color(32,136,203));
			tableDichVu.getTableHeader().setForeground(new Color(255,255,255));
			tableDichVu.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
			tableDichVu.setRowHeight(40);
			tableDichVu.setSelectionBackground(new Color(232,57,95));
			tableDichVu.setSelectionForeground(new Color(255,255,255));
			tableDichVu.setBackground(new Color(255,255,255));
//			String str = "2020-11-29T17:23:35.110+00:00"; 
//			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//			//listPhong = hoaDonRepository.findChiTietHD(dateTime);
//			System.out.println(dateTime);
//			listPhong = hoaDonRepository.findChiTietHD("0893478340");
			//System.out.println("AAAA   "+zxx +"   AAAAA");
			
//			docDLVaoBangPhong(listPhong);
//			tablePhong.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					r = tablePhong.getSelectedRow();
//					String maphong = modelPhong.getValueAt(r, 1).toString();
//					 if(tablePhong.getSelectedRow()>=0) {
//					xxx= tablePhong.getSelectedRow();
//					listDichVu = hoaDonRepository.findChiTietDichVu(maphong);
//					
//					docDLVaoBangDichVu(listDichVu);
//					 }
//				}
//			});
			
			tablePhong.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row = tablePhong.getSelectedRow();
					String maphong =(modelPhong.getValueAt(row, 1).toString());
					//txtCMND.setText(modelPhong.getValueAt(row, 2).toString());
					listDichVu = hoaDonRepository.findChiTietDichVu(maphong);
					
					//XoaHetDuLieuTrenTableModel();
					docDLVaoBangDichVu(listDichVu,maphong);
				}
			});
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
					LocalDateTime localDate = LocalDateTime.parse(txtNgayLapHD.getText(), formatter);
					System.out.println("\n AAAAA "+localDate+" BBBBBB");
					hoaDonRepository.updateTongTien(txtCMND.getText(), localDate,Double.parseDouble(txtTongTien.getText()));
					hoaDonRepository.updateTGTP(txtCMND.getText(), localDate, LocalDateTime.now());
					hoaDonRepository.updateTrangThai(txtCMND.getText(), localDate);
					
					
					JOptionPane.showMessageDialog(null, "Thanh Cong");
					
				}
			});
			
		}
		
		
		
		public void dienThongtin(String theCanCuoc,LocalDate thoiGianThueDau) {
			HoaDon hd_hienthi =  hoaDonRepository.findHoaDonTheoTheCanCuoc( theCanCuoc, thoiGianThueDau) ;
					//findByTCCMaPhongTT(theCanCuoc, thoiGianThueDau);
					txtCMND.setText(hd_hienthi.getKhachHang().getTheCanCuoc());
					txtNhanPhong.setText(hd_hienthi.getThoiGianNP().toString());
					txtSDT.setText(hd_hienthi.getKhachHang().getSoDienThoai().toString());
					txtTen.setText(hd_hienthi.getKhachHang().getTenKhachHang());
					txtNgayLapHD.setText(hd_hienthi.getThoiGianLHD().toString());
					int ngay= hd_hienthi.getThoiGianTheuCuoi().compareTo(hd_hienthi.getThoiGianTheuDau());
					double tienPhong = 0 ;
					int i =1;
					resetPhong();
					for(ChiTietHoaDon h :hd_hienthi.getListHoaDon()) {
						List<ChiTietDichVu> listdichvu = hoaDonRepository.findChiTietDichVu(h.getMaPhong());
								for(ChiTietDichVu p :listdichvu) {
									if(h.getMaPhong().equals(p.getPhongDichVu()))
									tienPhong += p.tinhThanhTien();				
						}
								modelPhong.addRow(new Object[] {
									i, h.getMaPhong(),h.getTenKhachHang(),ngay, h.getDonGia(),tienPhong+(h.tinhThanhTien()*ngay)
							});						
						TongTienHD+=tienPhong+h.tinhThanhTien();
						i++;
					}
					modelDichVu.addRow(new Object[] {
							1, 0,0,0,0,0
					});	
					txtTongTien.setText(String.valueOf(TongTienHD));
					tableDichVu.setModel(modelDichVu);
					tablePhong.setModel(modelPhong);	
					TongTienHD=0;
		}
		
//		public void docDLVaoBangPhong(List<ChiTietHoaDon> list) {
//			//int soNgay = qLThanhToanGUI.truyenSoNgay();
//			
////			String str = qLThanhToanGUI.truyenNgay(); 
////			LocalDate dateTime = LocalDate.parse(str, formatter);
//			double tienPhong = 0 ;
//			int i =1;
//			resetPhong();
//			for(ChiTietHoaDon h :list) {
//				List<ChiTietDichVu> listdichvu = hoaDonRepository.findChiTietDichVu(h.getMaPhong());
//						for(ChiTietDichVu p :listdichvu) {
//							if(h.getMaPhong().equals(p.getPhongDichVu()))
//							tienPhong += p.tinhThanhTien();				
//				}
//						modelPhong.addRow(new Object[] {
//							i, h.getMaPhong(),h.getTenKhachHang(),h.laySoNgayO(), h.getDonGia(),tienPhong+h.tinhThanhTien()
//					});						
//				TongTienHD+=tienPhong+h.tinhThanhTien();
//				i++;
//			}
//			modelDichVu.addRow(new Object[] {
//					1, 0,0,0,0,0
//			});	
//			tableDichVu.setModel(modelDichVu);
//			tablePhong.setModel(modelPhong);
//			
//		}
		public void docDLVaoBangDichVu(List<ChiTietDichVu> list,String maPhong) {
			int i =1;
			resetDichVu();
			for(ChiTietDichVu h :list) {
				if(h.getPhongDichVu().equals(maPhong))
						modelDichVu.addRow(new Object[] {
							i, h.getPhongDichVu(),h.getTenDichVu(),h.getSoLuong(),h.getGia(),h.tinhThanhTien()
					});	
				i++;
			}
			tableDichVu.setModel(modelDichVu);
		}
		
		public  void resetPhong()
		{
			modelPhong.setRowCount(0);
		}
		
		public  void resetDichVu()
		{
			modelDichVu.setRowCount(0);
		}
		
		public  void XoaHetDuLieuTrenTableModel()
		{
			DefaultTableModel dm =(DefaultTableModel) modelDichVu;
			dm.getDataVector().removeAllElements();
			listDichVu.removeAll(listDichVu);
		}
		public HoaDon findByTCCMaPhongTT(String theCanCuoc, String ThoiGianThueDau) {
			HoaDon dd = new HoaDon();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(ThoiGianThueDau, format);
			List<HoaDon> listhdkhongtrong = hoaDonRepository.findAllByTrangThaiThanhToan();
			for(HoaDon hoadon : listhdkhongtrong) {
				if(hoadon.getKhachHang().getTheCanCuoc().equalsIgnoreCase(theCanCuoc) && hoadon.getThoiGianTheuDau()==localDate) {
							dd=hoadon;
						
				}
			}
			return dd;
		}	
	}

