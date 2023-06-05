package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.CustomerBean;

public class CustomerDAO extends DAO{

	public CustomerBean search(String login,String password)
			throws Exception{

		CustomerBean customer=null;
		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement("select * from login where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			customer = new CustomerBean();
			customer.setId(rs.getString("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return customer;

	}


}
