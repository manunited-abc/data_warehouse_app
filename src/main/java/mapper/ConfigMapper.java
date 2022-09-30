package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Config;

public class ConfigMapper implements RowMapper<Config> {

	@Override
	public Config mapRow(ResultSet rs) {
		try {
			Config config = new Config();
			config.setId(rs.getInt("id"));
			config.setSouceDate(rs.getString("source_data"));
			config.setIp(rs.getString("ip"));
			config.setAuthor(rs.getString("author"));
			return config;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
