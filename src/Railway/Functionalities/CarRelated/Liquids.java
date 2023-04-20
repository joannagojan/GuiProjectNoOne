package Railway.Functionalities.CarRelated;

public class Liquids extends TransportedMaterials {
    private Integer volume;



    public Liquids(String description, String name, Integer securityLevel, Integer volume, Integer weight) {
        super(description, name, securityLevel, weight);
        this.volume = volume;
    }

    public Integer getLiquidDensity() {
        return weight/volume;
    }
    public Integer getLiquidTotalWeight() {return weight;}
    public Integer getVolume() {return volume;}

}