package bai1;

public class PhongMayTinh extends PhongHoc {
	private int soMayTinh;
	
	@Override
	boolean xetDatChuan() {
		if(duAnhSang() && dienTich/soMayTinh <= 1.5)
			return true;
		return false;
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) throws Exception {
		if(soMayTinh > 0)
			this.soMayTinh = soMayTinh;
		else
			throw new Exception("So may tinh phai lon hon 0!");
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public PhongMayTinh() {
		super();
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	@Override
	public String toString() {
		String danhGia;
		if(xetDatChuan())
			danhGia = "Dat chuan";
		else
			danhGia = "Khong dat chuan";
		
		return super.toString()+String.format("%15d"+"|"+"%-15s"+"|", soMayTinh, danhGia);
	}
}
