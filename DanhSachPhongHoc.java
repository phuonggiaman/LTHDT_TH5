package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachPhongHoc {
	ArrayList<PhongHoc> listPH;
	
	public DanhSachPhongHoc()
	{
		listPH = new ArrayList<PhongHoc>();
	}
	
	public ArrayList<PhongHoc> getAllPH()
	{
		return listPH;
	}
	
	public boolean themPhongHoc(PhongHoc ph) throws Exception
	{
		if(listPH.contains(ph))
			throw new Exception("Trung ma phong hoc!");
		else
			listPH.add(ph);
		return true;
	}
	
	public void xoaPH(PhongHoc ph)
	{
		listPH.remove(ph);
	}
	
	public void suaThongTinPH(PhongHoc ph)
	{
		int vt = listPH.indexOf(ph);
		if(vt>=0)
			listPH.set(vt, ph);
	}
	
	public PhongHoc timPH(String ma)
	{
		for (PhongHoc ph : listPH) {
			if(ph.maPhong.equalsIgnoreCase(ma))
				return ph;
		}
		return null;
	}
	
	public ArrayList<PhongHoc> timPHDatChuan()
	{
		int dem = 0;
		ArrayList<PhongHoc> list = new ArrayList<PhongHoc>();
		for (PhongHoc ph : listPH) {
			if(ph.xetDatChuan())
			{
				list.add(ph);
				dem++;
			}
		}
		if(dem==0)
			return null;
		return list;
	}
	
	public ArrayList<PhongHoc> timPHTheoSoMayTinh(int soBongDen)
	{
		int dem = 0;
		ArrayList<PhongHoc> list = new ArrayList<PhongHoc>();
		for (PhongHoc ph : listPH) {
			if(ph instanceof PhongMayTinh)
			{
				if(ph.getSoBongDen() >= soBongDen)
				{
					list.add(ph);
					dem++;
				}
			}
		}
		if(dem==0)
			return null;
		return list;
	}
	
	public void sapXepDayNha()
	{
		Collections.sort(listPH, new Comparator<PhongHoc>(){
			public int compare(PhongHoc ph1, PhongHoc ph2) 
			{
				return ph1.getDayNha().compareToIgnoreCase(ph2.getDayNha());
			}
		});
	}
	
	public void sapXepDienTichGiamDan()
	{
		Collections.sort(listPH, new Comparator<PhongHoc>() {
			public int compare(PhongHoc ph1, PhongHoc ph2)
			{
				if(ph1.getDienTich() == ph2.getDienTich())
					return 0;
				else if(ph1.getDienTich() < ph2.getDienTich())
					return 1;
				else
					return -1;
			}
		});
	}
	
	public void sapXepBongDenTangDan()
	{
		Collections.sort(listPH, new Comparator<PhongHoc>() {
			public int compare(PhongHoc ph1, PhongHoc ph2)
			{
				Integer i1 = new Integer(ph1.getSoBongDen());
				Integer i2 = new Integer(ph2.getSoBongDen());
				return i1.compareTo(i2);
			}
		});
	}
	
	public int tongPhongHoc()
	{
		int sum = 0;
		for (PhongHoc ph : listPH)
		{
			sum++;
		}
		return sum;
	}
	
	public int tongPhongHocLT()
	{
		int sum = 0;
		for (PhongHoc ph : listPH)
		{
			if(ph instanceof PhongLyThuyet)
				sum++;
		}
		return sum;
	}
	
	public int tongPhongHocMT()
	{
		int sum = 0;
		for (PhongHoc ph : listPH)
		{
			if(ph instanceof PhongMayTinh)
				sum++;
		}
		return sum;
	}
	
	public int tongPhongHocTN()
	{
		int sum = 0;
		for (PhongHoc ph : listPH)
		{
			if(ph instanceof PhongThiNghiem)
				sum++;
		}
		return sum;
	}
}
