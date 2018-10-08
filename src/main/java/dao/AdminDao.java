package dao;

import exception.DatabaseException;
import exception.FileException;

public interface AdminDao {

	public String adminLogin(String username, String password) throws FileException, DatabaseException;
}
