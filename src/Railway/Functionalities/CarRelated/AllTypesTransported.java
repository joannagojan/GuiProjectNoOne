package Railway.Functionalities.CarRelated;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AllTypesTransported {
    private static final AtomicInteger transportedIDCounter = new AtomicInteger(0);
    private Integer transportedID;
    private String description;


    public AllTypesTransported(String description) {
        this.transportedID = transportedIDCounter.incrementAndGet();
        this.description = description;
    }
}
