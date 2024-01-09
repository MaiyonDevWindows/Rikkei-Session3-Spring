package com.maiyon.javasession3.DAO;

import com.maiyon.javasession3.model.Student;
import com.maiyon.javasession3.utils.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp {
    public List<Student> findAll(){
        List<Student> students = new ArrayList<>();
        Connection conn = DbConnection.openConnection();
        try {
            CallableStatement call = conn.prepareCall("select * from student");
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getLong("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getBoolean("gender"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbConnection.closeConnection(conn);
        }
        return students;
    }
}
