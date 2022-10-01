package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.CodeRegion;
import model.Config;

public class CodeRegionMapper implements RowMapper<CodeRegion> {

	@Override
	public CodeRegion mapRow(ResultSet rs) {
		try {
			CodeRegion codeRegion = new CodeRegion();
			codeRegion.setCode_region(rs.getInt("code_region"));
			codeRegion.setProvince(rs.getString("name_pr"));
			return codeRegion;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
