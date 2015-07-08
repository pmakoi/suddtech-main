package com.suddtech.easyshop.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.suddtech.easyshop.model.Offer;
import com.suddtech.easyshop.model.User;

public class  OfferRowMapper  implements RowMapper <Offer> {

	@Override
	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();
		user.setAuthority(rs.getString("email"));
		user.setEmail(rs.getString("email"));
		//user.setName(rs.getString("name"));
		user.setEnabled(true);
		user.setUsername(rs.getString("username"));
		Offer offer = new Offer();
		//offer.setUser(user);
		offer.setId(rs.getInt("id"));
		offer.setText(rs.getString("text"));
		return offer;
	}

}
