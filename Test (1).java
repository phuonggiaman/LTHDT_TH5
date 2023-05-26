package bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	static DanhSachPhongHoc listPH = new DanhSachPhongHoc();
	public static void main(String[] args) throws Exception {
		System.out.println(" CHUONG TRINH NHAP XUAT VA XU LY THONG TIN PHONG HOC");
		
		nhapCung();
		
		int chon = -1;
		do
		{
			chon = menu();
			switch (chon)
			{
			case 1:				
				try {
					nhapDuLieu();
					System.out.println("Them phong hoc thanh cong ! ");
					xuatDanhSach(listPH.getAllPH());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				xuatDanhSach(listPH.getAllPH());
				break;
			case 3:
				System.out.println("Danh sach cac phong hoc dat chuan :");
				xuatDanhSach(listPH.timPHDatChuan());
				break;
			case 4:
				xuatDSTheoSoMayTinh();
				break;
			case 5:
				listPH.sapXepDayNha();
				xuatDanhSach(listPH.getAllPH());
				break;
			case 6:
				listPH.sapXepDienTichGiamDan();
				xuatDanhSach(listPH.getAllPH());
				break;
			case 7:
				listPH.sapXepBongDenTangDan();
				xuatDanhSach(listPH.getAllPH());
				break;
			case 8:
				System.out.println("Tong so phong hoc hien co la: "+listPH.tongPhongHoc());
				break;
			case 9:
				System.out.println("Tong so phong hoc ly thuyet hien co la: "+listPH.tongPhongHocLT());
				break;
			case 10:
				System.out.println("Tong so phong hoc may tinh hien co la: "+listPH.tongPhongHocMT());
				break;
			case 11:
				System.out.println("Tong so phong hoc thi nghiem hien co la: "+listPH.tongPhongHocTN());
				break;
			case 12:
				timKiemPH();
				break;
			case 13:
				xoaPH();
				break;
			case 14:
				capNhatSoMayTinh();
				break;
			}
		}while(chon != 0);
	}
	
	public static int menu()
	{
		Scanner nhap = new Scanner(System.in);
		System.out.println("");
		System.out.println("___________ MENU _____________");
		System.out.println("                                             ");
		System.out.println(" 1.  Them phong hoc                         ");
		System.out.println(" 2.  In thong tin tat ca phong hoc           ");
		System.out.println(" 3.  In thong tin tat ca phong hoc dat chuan ");
		System.out.println(" 4.  In thong tin phong hoc co n may tinh    ");
		System.out.println(" 5.  Sap xep theo day nha tang dan           ");
		System.out.println(" 6.  Sap xep theo dien tich giam dan         ");
		System.out.println(" 7.  Sap xep theo so bong den tang dan       ");
		System.out.println(" 8.  Tong so phong hoc                      ");
		System.out.println(" 9.  Tong so phong hoc ly thuyet             ");
		System.out.println(" 10. Tong so phong hoc may tinh             ");
		System.out.println(" 11. Tong so phong hoc thi nghiem           ");
		System.out.println(" 12. Tim kiem phong hoc                      ");
		System.out.println(" 13. Xoa phong hoc                           ");
		System.out.println(" 14. Cap nhat so may tinh                   ");
		System.out.println(" 0.  Thoat                                ");
		System.out.println("                                             ");
		System.out.println("Vui long chon :");
		int chon = nhap.nextInt();
		return chon;
	}
	
	public static void nhapCung() throws Exception
	{
		PhongHoc ph1 = new PhongLyThuyet("PH001", "Day A", 150, 10, true);
		listPH.themPhongHoc(ph1);
		PhongHoc ph2 = new PhongLyThuyet("PH002", "Day A", 200, 20, true);
		listPH.themPhongHoc(ph2);
		PhongHoc ph3 = new PhongLyThuyet("PH003", "Day B", 150, 17, false);
		listPH.themPhongHoc(ph3);
		PhongHoc ph4 = new PhongLyThuyet("PH004", "Day C", 200, 25, true);
		listPH.themPhongHoc(ph4);
		
		PhongHoc ph5 = new PhongMayTinh("PH005", "Day B", 50, 10, 34);
		listPH.themPhongHoc(ph5);
		PhongHoc ph6 = new PhongMayTinh("PH006", "Day B", 100, 10, 70);
		listPH.themPhongHoc(ph6);
		PhongHoc ph7 = new PhongMayTinh("PH007", "Day C", 100, 10, 30);
		listPH.themPhongHoc(ph7);
		PhongHoc ph8 = new PhongMayTinh("PH008", "Day C", 50, 10, 35);
		listPH.themPhongHoc(ph8);
		
		PhongHoc ph9 = new PhongThiNghiem("PH009", "Day D", 200, 20, 150, true);
		listPH.themPhongHoc(ph9);
		PhongHoc ph10 = new PhongThiNghiem("PH010", "Day D", 200, 20, 150, false);
		listPH.themPhongHoc(ph10);
		PhongHoc ph11 = new PhongThiNghiem("PH011", "Day D", 200, 20, 150, true);
		listPH.themPhongHoc(ph11);
		PhongHoc ph12 = new PhongThiNghiem("PH012", "Day D", 200, 15, 150, true);
		listPH.themPhongHoc(ph12);
	}
	
	public static void nhapDuLieu() throws Exception
	{
		String maPhong, dayNha;
		int soBongDen, soMayTinh, sucChua, loaiPH, chon;
		double dienTich;
		boolean mayChieu, bonRua;
		
		PhongHoc ph1 = new PhongLyThuyet();
		PhongHoc ph2 = new PhongMayTinh();
		PhongHoc ph3 = new PhongThiNghiem();
		
		Scanner nhap = new Scanner(System.in);
		
		try {
			System.out.println("Nhap ma phong hoc:");
			maPhong = nhap.nextLine();
			if(listPH.timPH(maPhong)==null)
			{
				System.out.println("Nhap day nha:");
				dayNha = nhap.nextLine();
				System.out.println("Nhap dien tich:");
				dienTich = nhap.nextDouble();
				System.out.println("Nhap so bong denn:");
				soBongDen = nhap.nextInt();
				System.out.println("Chon loai phong hoc:");
				System.out.println("	1.  Phong ly thuyet");
				System.out.println("	2.  Phong may tinh");
				System.out.println("	3.  Phong thi nghiem");
				loaiPH = nhap.nextInt();
				switch (loaiPH)
				{
				case 1:
					System.out.println("Phong co trang bi may chieu khong?");
					System.out.println("	1.  Co");
					System.out.println("	2.  Khong");
					chon = nhap.nextInt();
					if(chon == 1)
						mayChieu = true;
					else
						mayChieu = false;
					try {
						ph1.setMaPhong(maPhong);
						ph1.setDayNha(dayNha);
						ph1.setDienTich(dienTich);
						ph1.setSoBongDen(soBongDen);
					} catch (Exception e) {
						throw new Exception(e.getMessage());
					}
					ph1 = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, mayChieu);
					listPH.themPhongHoc(ph1);
					break;
				case 2:
					System.out.println("Nhap so may tinh:");
					soMayTinh = nhap.nextInt();
					try {
						ph2.setMaPhong(maPhong);
						ph2.setDayNha(dayNha);
						ph2.setDienTich(dienTich);
						ph2.setSoBongDen(soBongDen);
					} catch (Exception e) {
						throw new Exception(e.getMessage());
					}
					ph2 = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
					listPH.themPhongHoc(ph2);
					break;
				case 3:
					System.out.println("Nhap suc chua:");
					sucChua = nhap.nextInt();
					System.out.println("Phong co bon rua khong?");
					System.out.println("	1.  Co");
					System.out.println("	2.  Khong");
					chon = nhap.nextInt();
					if(chon == 1)
						bonRua = true;
					else
						bonRua = false;
					try {
						ph3.setMaPhong(maPhong);
						ph3.setDayNha(dayNha);
						ph3.setDienTich(dienTich);
						ph3.setSoBongDen(soBongDen);
					} catch (Exception e) {
						throw new Exception(e.getMessage());
					}
					ph3 = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, sucChua, bonRua);
					listPH.themPhongHoc(ph3);
					break;
				}
			}
			else
				throw new Exception("Ma phong hoc da ton tai!");
		} catch (Exception e) {
			System.out.println("Loi: "+e.getMessage());
			throw new Exception("Them khong thanh cong!");
		}
	}
	
	public static void xuatTieuDePhongLT()
	{
		inGachNgang1();
		System.out.printf("|%-15s|%-10s|%-15s|%-15s|%-15s|%-15s|\n", "Ma phong hoc", "Day nha", "Dien tich(m^2)", "So bong den", "May chieu", "Danh gia");
		inGachNgang1();
	}
	
	public static void xuatTieuDePhongMT()
	{
		inGachNgang1();
		System.out.printf("|%-15s|%-10s|%-15s|%-15s|%-15s|%-15s|\n","Ma phong hoc", "Day nha", "Dien tich(m^2)", "So bong den", "May chieu", "Danh gia");
		inGachNgang1();
	}
	
	public static void xuatTieuDePhongTN()
	{
		inGachNgang2();
		System.out.printf("|%-15s|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Ma phong hoc", "Day nha", "Dien tich(m^2)", "So bong den", "Suc chua","Bon rua", "Danh gia");
		inGachNgang2();
	}
	
	public static void inGachNgang1()
	{
		for(int i = 0; i < 92; i++)
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	public static void inGachNgang2()
	{
		for(int i = 0; i < 108; i++)
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	public static void xuatDanhSach(ArrayList<PhongHoc> list)
	{
		System.out.println("Danh sach tat ca cac phong hoc:");
		System.out.println("Phong ly thuyet:");
		xuatTieuDePhongLT();
		for (PhongHoc ph : list) 
		{
			if(ph instanceof PhongLyThuyet)
			{
				System.out.println(ph);
				inGachNgang1();
			}
		}
		
		System.out.println("Phong may tinh:");
		xuatTieuDePhongMT();
		for (PhongHoc ph : list) 
		{
			if(ph instanceof PhongMayTinh)
			{
				System.out.println(ph);
				inGachNgang1();
			}
		}
		
		System.out.println("Phong thi nghiem:");
		xuatTieuDePhongTN();
		for (PhongHoc ph : list) 
		{
			if(ph instanceof PhongThiNghiem)
			{
				System.out.println(ph);
				inGachNgang2();
			}
		}
	}
	
	public static void timKiemPH()
	{
		Scanner nhap = new Scanner(System.in);
		String ma;
		System.out.println("Nhap ma phong hoc can tim:");
		ma = nhap.nextLine();
		PhongHoc phTim = listPH.timPH(ma);
		if(phTim==null)
			System.out.println("Ma phong hoc khong ton tai!");
		else
		{
			if(phTim instanceof PhongLyThuyet)
			{
				xuatTieuDePhongLT();
				System.out.println(phTim);
				inGachNgang1();
			}
			else if(phTim instanceof PhongMayTinh)
			{
				xuatTieuDePhongMT();
				System.out.println(phTim);
				inGachNgang1();
			}
			else
			{
				xuatTieuDePhongTN();
				System.out.println(phTim);
				inGachNgang2();
			}
		}
	}
	
	public static void xoaPH() 
	{
		int chon;
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhap ma phong hoc can xoa:");
		String ma = nhap.nextLine();
		PhongHoc phXoa = listPH.timPH(ma);
		if(phXoa!=null)
		{
			System.out.println("Ban co chac chan muon xoa ?");
			System.out.println("	1.  Co");
			System.out.println("	2.  Khong");
			chon = nhap.nextInt();
			if(chon == 1)
			{
				listPH.xoaPH(phXoa);
				System.out.println("Xoa thanh cong!");
				System.out.println("Danh sach phong hoc sau khi xoa:");
				xuatDanhSach(listPH.getAllPH());
			}
			else
				System.out.println("Ban da huy thao tac xoa!");
		}
		else
			System.out.println("Ma phong hoc khong ton tai!");
	}
	
	public static void capNhatSoMayTinh() throws Exception
	{
		String ma;
		int soMay;
		
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhap ma phong hoc can cap nhat:");
		ma = nhap.nextLine();
		PhongHoc phTim = listPH.timPH(ma);
		if(phTim==null)
			System.out.println("Ma phong hoc khong ton tai!");
		else if(phTim instanceof PhongMayTinh)
		{
			System.out.println("Thong tin phong hoc truoc khi cap nhat:");
			xuatTieuDePhongMT();
			System.out.println(phTim);
			inGachNgang1();
			System.out.println("Nhap so luong may tinh:");
			soMay = nhap.nextInt();
			((PhongMayTinh) phTim).setSoMayTinh(soMay);
			System.out.println("Cap nhat thanh cong!");
			System.out.println("Thong tin phong hoc sau khi cap nhat:");
			xuatTieuDePhongMT();
			System.out.println(phTim);
			inGachNgang1();
		}
		else
			System.out.println("Khong phai ma phong may tinh!");
	}
	
	public static void xuatDSTheoSoMayTinh()
	{
		int soMay;
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.println("Nhap so luong may tinh:");
		soMay = nhap.nextInt();
		ArrayList<PhongHoc> list = listPH.timPHTheoSoMayTinh(soMay);
		System.out.println("Danh sach cac phong may tinh co so may tu "+soMay+" tro len:");
		xuatTieuDePhongMT();
		for (PhongHoc ph : list) {
			{
				System.out.println(ph);
				inGachNgang1();
			}
		}
	}
}
