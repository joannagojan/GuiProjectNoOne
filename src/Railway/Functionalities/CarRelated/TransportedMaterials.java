package Railway.Functionalities.CarRelated;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TransportedMaterials extends AllTypesTransported {
    private String name;
    private Integer securityLevel;


    public TransportedMaterials(String description, String name, Integer securityLevel) {
        super(description);
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
