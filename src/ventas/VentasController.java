package ventas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import facturas.FacturasController;
import static facturas.FacturasController.conexion;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class VentasController implements Initializable {

    //Componentes
    @FXML
    private JFXTextField numeroTF;
    @FXML
    private JFXButton generarBtn;

    //Variables
    public static Connection conexion = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conexion = metodos.metodos.conectaBD(conexion);
    }    
    
    @FXML
    public void generar(){
        generaInforme();
    }
    
    public void generaInforme() {
                
        try {
            JasperReport jr = null;
            try {
                jr = (JasperReport) JRLoader.loadObject(VentasController.class.getResource("Ventas.jasper"));
            } catch (JRException ex) {
                Logger.getLogger(VentasController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Map de parámetros
            Map parametros = new HashMap();

            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }   
    
}
