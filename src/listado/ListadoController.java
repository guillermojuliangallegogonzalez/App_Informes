package listado;


import facturas.FacturasController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ListadoController implements Initializable {
    
    //Componentes
    @FXML
    private JFXTextField numeroTF;
    @FXML
    private JFXButton generarBtn;

    //Variables
    public static Connection conexion = null;

    /**
     * Initializes the controller class.
     */
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
                jr = (JasperReport) JRLoader.loadObject(ListadoController.class.getResource("Lista.jasper"));
            } catch (JRException ex) {
                Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperReport jr1 = null;
            try {
                jr1 = (JasperReport) JRLoader.loadObject(ListadoController.class.getResource("Cliente.jasper"));
            } catch (JRException ex) {
                Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Map de parámetros
            Map parametros = new HashMap();
            
            parametros.put("ADDRESSIDP", jr1);

            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } 
    
}
