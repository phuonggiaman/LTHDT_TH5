package bai1;

public abstract class PhongHoc {
	protected String maPhong;
	protected String dayNha;
	protected double dienTich;
	protected int soBongDen;
	
	abstract boolean xetDatChuan();
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) throws Exception {
		if(maPhong.length() > 0)
			this.maPhong = maPhong;
		else
			throw new Exception("Ma phong khong duoc de trong!");
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) throws Exception {
		if(dayNha.length() > 0)
			this.dayNha = dayNha;
		else
			throw new Exception("Day nha khong duoc de trong!");
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) throws Exception {
		if(dienTich >= 50)
			this.dienTich = dienTich;
		else
			throw new Exception("Dien tich khong duoc be hon 50!");
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) throws Exception {
		if(soBongDen > 0)
			this.soBongDen = soBongDen;
		else
			throw new Exception("So bong den phai lon hon 0!");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}
	
	public PhongHoc() {
		super();
	}
	
	public boolean duAnhSang()
	{
		if(dienTich/soBongDen > 10)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("|"+"%-15s"+"|"+"%-10s"+"|"+"%15.0f"+"|"+"%15d"+"|", maPhong, dayNha, dienTich, soBongDen);
	}
}
