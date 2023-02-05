package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Platform;

/**
 *
 * @author guillermo
 */
public class metodos {

    //Función salir aplicación
    public static void salir() {
        Platform.exit();
    }

    //Función conectar BD
    public static Connection conectaBD(Connection conexion) {

        //Establecemos conexión con la BD
        String baseDatos = "jdbc:hsqldb:hsql://localhost:9001/DataBaseTest";
        String usuario = "sa";
        String clave = "";

        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            conexion = DriverManager.getConnection(baseDatos, usuario, clave);
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        } catch (SQLException sqle) {
            System.err.println("No se pudo conectar a BD");
            System.exit(1);
        } catch (java.lang.InstantiationException | IllegalAccessException sqlex) {
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
        
        return conexion;
    }

    //Desconectar BD
    public static void stop() throws Exception {
        try {
            DriverManager.getConnection("jdbc:hsqldb:hsql://localhost;shutdown=true");
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexion a la BD");
        }
    }

    
}
