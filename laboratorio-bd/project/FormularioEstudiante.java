

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormularioEstudiante {
public static void main(String[] args) {

    String matricula = JOptionPane.showInputDialog(null, "Ingresa la Matrícula Escolar del Alumno:");
    String nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre Completo:"); String apellido = JOptionPane.showInputDialog(null, "Ingresa el Apellido Paterno/Materno:");
    String correo = JOptionPane.showInputDialog(null, "Ingresa el Correo Electrónico Institucional:");

    if (matricula == null || nombre == null || apellido == null || matricula.trim().isEmpty() || nombre.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error Crítico: Los campos obligatorios no pueden estar vacíos.");
        return;
    }

    String instruccionSQL = "INSERT INTO estudiantes (matricula, nombre, apellido, correo) VALUES (?, ?, ?, ?)";

    try (Connection con = ConexionDB.obtenerConexion();
        PreparedStatement pstmt = con.prepareStatement(instruccionSQL)) {

        pstmt.setString(1, matricula);
        pstmt.setString(2, nombre);
        pstmt.setString(3, apellido);
        pstmt.setString(4, correo);

        int filasAfectadas = pstmt.executeUpdate();
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "¡Conexión de Red y Registro Exitoso! Estudiante guardado.");
        }
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Fallo Crítico al Conectar o EjecutarSentencia SQL: " + ex.getMessage());
       ex.printStackTrace();
        }
    }
}
