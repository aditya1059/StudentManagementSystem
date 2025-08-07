package students;

import databaseHelper.DatabaseHelper;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDAO {
    public void addStudent(Student s)  {
        try (Connection con = DatabaseHelper.getConnection(); Statement st = Objects.requireNonNull(con).createStatement()) {
            st.execute("use studentdb");
            System.out.println("Adding a new Student...");
            PreparedStatement ps = con.prepareStatement("INSERT INTO student(name,city,deptno) VALUES (?, ?, ?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getCity());
            ps.setInt(3, s.getDeptNo());
            ps.executeUpdate();
            System.out.println("Student added Successfully!");
        } catch (SQLException e) {
            System.out.println("Some problem occurred "+e.getMessage());
        }

    }

    public List<Student> getAllStudents(){
        List<Student> list = new ArrayList<>();
        try(Connection con = DatabaseHelper.getConnection();
            Statement st = Objects.requireNonNull(con).createStatement()) {
            st.execute("use studentdb");
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                Student s = new Student();
                s.setRoll(rs.getInt("roll"));
                s.setName(rs.getString("name"));
                s.setCity(rs.getString("city"));
                s.setDeptNo(rs.getInt("deptno"));
                list.add(s);
            }

        }
        catch(SQLException e){
            System.out.println("Some problem occurred "+e.getMessage());
        }
        return list;
    }

    public void updateStudent(Student s)  {

        try(Connection con = DatabaseHelper.getConnection();
            Statement st= Objects.requireNonNull(con).createStatement()) {
            st.execute("use studentdb");
            PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, city=?, deptno=? WHERE roll=?");
            ps.setString(1, s.getName());
            ps.setString(2, s.getCity());
            ps.setInt(3, s.getDeptNo());
            ps.setInt(4, s.getRoll());
            ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Some problem occurred "+e.getMessage());
        }
    }

    public void deleteStudent(int roll) {
        try(Connection con = DatabaseHelper.getConnection();
            Statement st= Objects.requireNonNull(con).createStatement()) {
            st.execute("use studentdb");
            PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE roll=?");
            ps.setInt(1, roll);
            ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Some problem occurred "+e.getMessage());
        }
    }
}
