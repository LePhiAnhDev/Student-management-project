package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.ThiSinh;
import Model.Tinh;
import database.JDBCUtil;

public class ThiSinhDAO {
	public boolean insert(ThiSinh thiSinh) {
	    try (Connection conn = JDBCUtil.getConnection()) {
	        String sql = "INSERT INTO thisinh (maThiSinh, tenThiSinh, queQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3, maLop) "
	                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, thiSinh.getMaThiSinh());
	        pstmt.setString(2, thiSinh.getTenThiSinh());
	        pstmt.setInt(3, thiSinh.getQueQuan().getMaTinh());
	        pstmt.setDate(4, new java.sql.Date(thiSinh.getNgaySinh().getTime()));
	        pstmt.setBoolean(5, thiSinh.getGioiTinh());
	        pstmt.setFloat(6, thiSinh.getDiemMon1());
	        pstmt.setFloat(7, thiSinh.getDiemMon2());
	        pstmt.setFloat(8, thiSinh.getDiemMon3());
	        pstmt.setString(9, thiSinh.getMaLop());
	        return pstmt.executeUpdate() > 0; // Trả về true nếu thành công
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log lỗi để kiểm tra
	    }
	    return false;
	}

    public boolean delete(int maThiSinh) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM thisinh WHERE maThiSinh = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maThiSinh);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ThiSinh thiSinh) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "UPDATE thisinh SET tenThiSinh = ?, queQuan = ?, ngaySinh = ?, gioiTinh = ?, diemMon1 = ?, diemMon2 = ?, diemMon3 = ?, maLop = ? "
                       + "WHERE maThiSinh = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, thiSinh.getTenThiSinh());
            pstmt.setInt(2, thiSinh.getQueQuan().getMaTinh());
            pstmt.setDate(3, new java.sql.Date(thiSinh.getNgaySinh().getTime()));
            pstmt.setBoolean(4, thiSinh.getGioiTinh());
            pstmt.setFloat(5, thiSinh.getDiemMon1());
            pstmt.setFloat(6, thiSinh.getDiemMon2());
            pstmt.setFloat(7, thiSinh.getDiemMon3());
            pstmt.setString(8, thiSinh.getMaLop());
            pstmt.setInt(9, thiSinh.getMaThiSinh());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
