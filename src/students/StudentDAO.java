package students;

import databaseHelper.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student s) throws Exception {
        Connection con = DatabaseHelper.getConnection();
        Statement st= con.createStatement();
        st.execute("use studentdb");
        PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");
        ps.setInt(1, s.getRoll());
        ps.setString(2, s.getName());
        ps.setString(3, s.getCity());
        ps.setInt(4, s.getDeptno());
        ps.executeUpdate();
        con.close();
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        Statement st = con.createStatement();
        st.execute("use studentdb");
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            Student s = new Student();
            s.setRoll(rs.getInt("roll"));
            s.setName(rs.getString("name"));
            s.setCity(rs.getString("city"));
            s.setDeptno(rs.getInt("deptno"));
            list.add(s);
        }
        con.close();
        return list;
    }

    public void updateStudent(Student s) throws Exception {
        Connection con = DatabaseHelper.getConnection();
        Statement st= con.createStatement();
        st.execute("use studentdb");
        PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, city=?, deptno=? WHERE roll=?");
        ps.setString(1, s.getName());
        ps.setString(2, s.getCity());
        ps.setInt(3, s.getDeptno());
        ps.setInt(4, s.getRoll());
        ps.executeUpdate();
        con.close();
    }

    public void deleteStudent(int roll) throws Exception {
        Connection con = DatabaseHelper.getConnection();
        Statement st= con.createStatement();
        st.execute("use studentdb");
        PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE roll=?");
        ps.setInt(1, roll);
        ps.executeUpdate();
        con.close();
    }
}
