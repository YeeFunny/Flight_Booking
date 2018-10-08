package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Airplane;
import exception.DatabaseException;
import exception.FileException;
import util.DatabaseUtil;

public class AirplaneDaoImpl implements AirplaneDao{

	@Override
	public Airplane getAirplaneById(int airplaneId) throws FileException, DatabaseException {
		Airplane airplane = null;
		ResultSet set = null;
		String sql = "select airplane_id as id, producer, firstclass_capacity as firstcap, "
				+ "economyclass_capacity as economycap from airplane where airplane_id = ?";
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, airplaneId);
			set = ps.executeQuery();
			if (set.next()) {
				airplane = new Airplane(set.getInt("id"), set.getInt("firstcap"), 
						set.getInt("economycap"), set.getString("producer"));
			}
			if (set != null)
				set.close();
		} catch (SQLException e) {
			throw new DatabaseException("Unable to query admin information: " + e.getMessage());
		}
		return airplane;
	}

	@Override
	public List<Airplane> getAirplaceList() throws FileException, DatabaseException {
		List<Airplane> airplaneList = new ArrayList<>();
		ResultSet set = null;
		String sql = "select airplane_id as id, producer, firstclass_capacity as firstcap, "
				+ "economyclass_capacity as economycap from airplane";
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			set = ps.executeQuery();
			while (set.next()) {
				Airplane airplane = new Airplane(set.getInt("id"), set.getInt("firstcap"), 
						set.getInt("economycap"), set.getString("producer"));
				airplaneList.add(airplane);
			}
			if (set != null)
				set.close();
		} catch (SQLException e) {
			throw new DatabaseException("Unable to query admin information: " + e.getMessage());
		}
		return airplaneList;
	}

}
