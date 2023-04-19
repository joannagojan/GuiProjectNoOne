package Railway.Functionalities.CarRelated;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TransportedMaterials {
    private static final AtomicInteger cargoIDCounter = new AtomicInteger(0);
    private final Integer cargoID;

    private String name;
    private Integer securityLevel;


    public TransportedMaterials(String name, Integer securityLevel) {
        this.name = name;
        this.securityLevel = securityLevel;
        this.cargoID = cargoIDCounter.incrementAndGet();
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
