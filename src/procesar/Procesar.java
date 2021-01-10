package procesar;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import punto.Punto;

public class Procesar {
    
    private Vector datos=new Vector();
    private static final String RUTA_CSV = "datosBarranquilla.csv";
    private int i = 0;
    
    //CSVFORMAT, CSVParser y CSVRecord son clases de la librería Commons de Apache
    public Vector procesarRegresion() throws IOException{
        
        try (
                Reader reader = Files.newBufferedReader(Paths.get(RUTA_CSV));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
                
                ){
        
            for (CSVRecord csvRecord : csvParser) {
                Punto temp = new Punto();
                temp.setIdFecha(i);
                temp.setTemperatura(Float.parseFloat(csvRecord.get(1)));
                i++;
                datos.add(temp);
            }
            return datos;
        }
        

    }
    
}
