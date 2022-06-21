package utilities;

import models.CredentialModels;

public class DataProviders {

    private final Logs log = new Logs();
    public static final String BAD_PERSONAL_INFO_DP = "Bad Personal Info Data Provider";

    public CredentialModels getLockedCredentials(){
        log.debug("Cogiendo las credenciales invalidas");
        var credentialMap = new MapParser().getCredentialsMap();
        return credentialMap.get("locked");
    }

    public CredentialModels getValidCredentials(){
        log.debug("Cogiendo las credenciales invalidas");
        var credentialMap = new MapParser().getCredentialsMap();
        return credentialMap.get("valid");
    }

}
