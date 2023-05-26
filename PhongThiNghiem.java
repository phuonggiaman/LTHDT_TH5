package bai1;

public class PhongThiNghiem extends PhongHoc {
	private int sucChua;
	private boolean bonRua;
	
	@Override
	boolean xetDatChuan() {
		if(duAnhSang() && bonRua == true)
			return true;
		return false;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) throws Exception {
		if(sucChua > 50)
			this.sucChua = sucChua;
		else
			throw new Exception("Suc chua khong duoc be hon 50!");
	}

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, int sucChua, boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}

	public PhongThiNghiem() {
		super();
	}

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}
	

	@Override
	public String toString() {
		String danhGia, bonRua;
		if(xetDatChuan())
			danhGia = "Dat chuan";
		else
			danhGia = "Khong dat chuan";
		
		if(this.bonRua)
			bonRua = "Co";
		else
			bonRua = "Khong";
		
		return super.toString()+String.format("%15d"+"|"+"%-15s"+"|"+"%-15s"+"|", sucChua, bonRua, danhGia);
	}
}
