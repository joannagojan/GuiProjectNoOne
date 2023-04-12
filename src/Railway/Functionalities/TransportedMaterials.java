package Railway.Functionalities;

import java.util.HashMap;

public abstract class TransportedMaterials {
    private String name;
    private Integer securityLevel;


    public TransportedMaterials(String name, Integer securityLevel) {
        this.name = name;
        this.securityLevel = securityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }
}
