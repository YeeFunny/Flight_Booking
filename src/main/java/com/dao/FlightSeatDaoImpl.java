package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.FlightSeat;
import com.exception.DatabaseException;
import com.exception.FileException;
import com.util.DatabaseUtil;

public class FlightSeatDaoImpl implements FlightSeatDao{

	@Override
	public FlightSeat getFlightSeatById(int flightId) throws DatabaseException, FileException {
		ResultSet set = null;
		FlightSeat flightSeat = null;
		String sql = "select firstclass_left, economyclass_left, businessclass_left, version "
				+ "from flight_seat where flight_id = ?";
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, flightId);
			set = ps.executeQuery();
			if (set.next()) {
				flightSeat = new FlightSeat(flightId, set.getInt("businessclass_left"), 
						set.getInt("firstclass_left"), set.getInt("economyclass_left"), 
						set.getInt("version"));
			}
			if (set != null)
				set.close();
		} catch (SQLException e) {
			throw new DatabaseException("Unable to get flight seat information: " + e.getMessage());
		}
		return flightSeat;
	}

	@Override
	public int addFlightSeat(FlightSeat flightSeat) throws DatabaseException, FileException {
		int row = 0;
		String sql = "insert into flight_seat(flight_id, businessclass_left, firstclass_left, economyclass_left, version, "
				+ "values (?, ?, ?, ?, ?, ?)";
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, flightSeat.getFlightId());
			ps.setInt(2, flightSeat.getBusinessLeft());
			ps.setInt(3, flightSeat.getFirstLeft());
			ps.setInt(4, flightSeat.getEconomyLeft());
			ps.setInt(5, flightSeat.getVersion());
			row = ps.executeUpdate();
			if (row == 0) {
				throw new DatabaseException("Unable to insert flight seat information.");
			}
		} catch (SQLException e) {
			throw new DatabaseException("Unable to insert flight information: " + e.getMessage());
		}
		return row;
	}

}
