package utilities;

import models.CredentialModels;

import java.util.HashMap;

public class MapParser {

    private final Logs log = new Logs();

    public HashMap<String, CredentialModels> getCredentialsMap(){
        log.debug("Creando el map de las credenciales");
        var map = new HashMap<String,CredentialModels>();
        var credentialList = new ExcelReader().getCredentials();

        for(var credential:credentialList){
            map.put(credential.getKey(),credential);
        }

        return map;
    }

}
