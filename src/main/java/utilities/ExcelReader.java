package utilities;

import com.poiji.bind.Poiji;
import models.CredentialModels;

import java.io.File;
import java.util.List;

public class ExcelReader {

    private final String EXCEL_PATH = "src/test/resources/data/testData.xlsx";
    private final Logs log = new Logs();

    public List<CredentialModels> getCredentials(){
        log.debug("Leyendo las credenciales desde: "+EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH),CredentialModels.class);
    }

}
