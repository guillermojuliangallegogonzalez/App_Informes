package appinforme;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class AppInformeController implements Initializable {

    //Componentes interfaz
    @FXML
    private JFXButton facturasBtn;
    @FXML
    private JFXButton ventasBtn;
    @FXML
    private JFXButton clienteBtn;
    @FXML
    private JFXButton listadoBtn;
    @FXML
    private JFXButton salirBtn;
    @FXML
    private BorderPane pantallaPrincipal;

    //Variables
    public static Connection conexion = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //metodos.metodos.conectaBD(conexion);
    }

    //Botón Salir
    @FXML
    private void salir() throws Exception {
        metodos.metodos.stop();
        metodos.metodos.salir();
    }

    //Botón Facturas
    @FXML
    private void cargarFacturas() throws IOException {

        cargarEscenas("/facturas/Facturas.fxml");

    }
    
    //Botón Ventas
    @FXML
    private void cargarVentas() throws IOException {

        cargarEscenas("/ventas/Ventas.fxml");

    }
    
    //Botón Clientes
    @FXML
    private void cargarClientes() throws IOException {

        cargarEscenas("/clientes/Clientes.fxml");

    }
    
    //Botón LIstados
    @FXML
    private void cargarListado() throws IOException {

        cargarEscenas("/listado/Listado.fxml");

    }

    //Carga fxml
    private void cargarEscenas(String fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        BorderPane vista = (BorderPane) fxmlLoader.load();

        pantallaPrincipal.getChildren().clear();
        pantallaPrincipal.getChildren().add(vista);

    }

}
