package Model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> danhSachThiSinh;
	private String luaChon;
	private String tenFile;

	public QLSVModel() {
		this.danhSachThiSinh = new ArrayList<ThiSinh>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QLSVModel(ArrayList<ThiSinh> danhSachThiSinh) {
		this.danhSachThiSinh = danhSachThiSinh;
	}

	public ArrayList<ThiSinh> getDanhSachThiSinh() {
		return danhSachThiSinh;
	}

	public void setDanhSachThiSinh(ArrayList<ThiSinh> danhSachThiSinh) {
		this.danhSachThiSinh = danhSachThiSinh;
	}
	
	public void insert(ThiSinh thiSinh) {
		this.danhSachThiSinh.add(thiSinh);
	}
	
	public void delete(ThiSinh thiSinh) {
		this.danhSachThiSinh.remove(thiSinh);
	}
	
	public void update(ThiSinh thiSinh) {
		this.danhSachThiSinh.remove(thiSinh);
		this.danhSachThiSinh.add(thiSinh);
		//Nếu tồn tại sẵn thì chỉ cần xoá thí sinh sẽ tự động sẽ infor cũ, add lại sẽ thêm vào infor mới.
		//Hoặc: Xoá bạn thí sinh cũ, thêm bạn thí sinh mới.
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : danhSachThiSinh) {
			if(thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
				return true;
			}
		}
		return false;
	}
}