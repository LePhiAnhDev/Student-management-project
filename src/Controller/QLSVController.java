package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import Model.ThiSinh;
import Model.Tinh;
import View.QLSVView;

public class QLSVController implements ActionListener{
	public QLSVView qlsvView;
	
	public QLSVController(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmt = e.getActionCommand();
//		JOptionPane.showMessageDialog(qlsvView, "Bạn vừa nhấn vào: "+ cmt);
		if(cmt.equals("Thêm")) {
			this.qlsvView.xoaForm();
			this.qlsvView.model.setLuaChon("Thêm");
		}else if(cmt.equals("Lưu")) {
			try {
				this.qlsvView.thucHienThemThiSinh();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(cmt.equals("Cập nhật")) {
			this.qlsvView.hienThiThongTinSinhVienDaChon();
		}else if(cmt.equals("Xoá")) {
			this.qlsvView.thucHienXoa();
		}else if(cmt.equals("Huỷ bỏ")) {
			this.qlsvView.xoaForm();
		}else if(cmt.equals("Tìm kiếm")) {
			this.qlsvView.thucHienTim();
		}else if(cmt.equals("Huỷ tìm")) {
			this.qlsvView.thucHienTaiLaiDuLieu();
		}else if(cmt.equals("About Me")) {
			this.qlsvView.hienThiAbout();
		}else if(cmt.equals("Exit")) {
			this.qlsvView.thoatKhoiChuongTrinh();
		}else if(cmt.equals("Save")) {
			this.qlsvView.thucHienSaveFile();
		}else if(cmt.equals("Open")) {
			this.qlsvView.thucHienOpenFile();
		}	
	}
}
