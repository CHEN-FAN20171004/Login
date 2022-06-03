package jp.co.aforce.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB接続のサンプルクラス
 *
 * @author s.akama
 *
 */
public class ConnectSample {

	// データベース(MySQL)にアクセスする為の基本情報
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "login_db";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			// 実行するSQL
			String sql = "SELECT * FROM login";

			conn = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println("社員ID：" + rs.getString("emp_id"));
				System.out.println("社員名：" + rs.getString("name"));
				System.out.println("誕生日：" + rs.getString("birthday"));
				System.out.println("給料：" + rs.getString("salary"));
				System.out.println("部署名：" + rs.getString("dep_id"));
				System.out.println("---*---*---");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// リザルトセットのクローズ
				if (rs != null) {
					rs.close();
				}
				// ステートメントのクローズ
				if (stmt != null) {
					stmt.close();
				}
				// コネクションのクローズ
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}






















