package dao;

import domain.Student;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class StudentJdbcDAO implements StudentDAO {

	private  String jdbcURL = "jdbc:h2:tcp://localhost/students;IFEXISTS=TRUE";

	public StudentJdbcDAO() {
	}

	public StudentJdbcDAO(String url) {
		jdbcURL = url;
	}

	@Override
	public void save(Student aStudent) {

		String sql = "merge into students (id, name, major) values (?,?,?)";

		try (
				// get connection to database
				Connection dbConn = JdbcConnection.getConnection(jdbcURL);
				// create the SQL statement
				PreparedStatement stmt = dbConn.prepareStatement(sql);
			) {

			// copy the data from the student domain object into the statement
			stmt.setInt(1, aStudent.getId());
			stmt.setString(2, aStudent.getName());
			stmt.setString(3, aStudent.getMajor());

			// execute the statement
			stmt.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	public void delete(Student aStudent) {

		String sql = "delete from students where id = ?";

		try (
				Connection dbConn = JdbcConnection.getConnection(jdbcURL);
				PreparedStatement stmt = dbConn.prepareStatement(sql);
			) {

			stmt.setInt(1, aStudent.getId());
			stmt.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<Student> getAll() {

		String sql = "select * from students order by id";

		try (
				// get a connection to the database
				Connection dbCon = JdbcConnection.getConnection(jdbcURL);
				// create the statement
				PreparedStatement stmt = dbCon.prepareStatement(sql);
			) {

			// execute the query
			ResultSet rs = stmt.executeQuery();

			// Create a collection for holding the student we get from the query.
			// We are using a List in order to preserve the order in which
			// the data was returned from the query.
			List<Student> students = new ArrayList<>();

			// iterate through the query results
			while (rs.next()) {

				// get the data out of the query
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String major = rs.getString("major");

				// use the data to create a student object
				Student s = new Student(id, name, major);

				// and put it in the collection
				students.add(s);
			}

			return students;

		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}

	}

	@Override
	public Collection<String> getMajors() {

		String sql = "select distinct major from students order by major";

		try (
				Connection dbConn = JdbcConnection.getConnection(jdbcURL);
				PreparedStatement stmt = dbConn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
			) {

			Collection<String> majors = new ArrayList<>();

			while (rs.next()) {
				String major = rs.getString("major");
				majors.add(major);
			}

			return majors;

		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	public Student getByID(Integer studentID) {

		String sql = "select * from students where id = ?";

		try (
				Connection connection = JdbcConnection.getConnection(jdbcURL);
				PreparedStatement stmt = connection.prepareStatement(sql);
			) {

			stmt.setInt(1, studentID);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String maj = rs.getString("major");

				return new Student(id, name, maj);

			} else {
				// no student matches given ID so return null
				return null;
			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<Student> getByMajor(String major) {

		String sql = "select * from students where major = ? order by id";

		try (
				// get a connection to the database
				Connection dbCon = JdbcConnection.getConnection(jdbcURL);
				// create the statement
				PreparedStatement stmt = dbCon.prepareStatement(sql);
			) {

			// provide value for major parameter
			stmt.setString(1, major);

			// execute the query
			ResultSet rs = stmt.executeQuery();

			// Create a collection for holding the student we get from the query.
			// We are using a List in order to preserve the order in which
			// the data was returned from the query.
			List<Student> students = new ArrayList<>();

			// iterate through the query results
			while (rs.next()) {

				// get the data out of the query
				Integer id = rs.getInt("id");
				String name = rs.getString("name");

				// use the data to create a student object
				Student s = new Student(id, name, major);

				// and put it in the collection
				students.add(s);
			}

			return students;

		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

}
