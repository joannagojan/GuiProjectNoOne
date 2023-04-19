package Railway.Functionalities.CarRelated;

public class Liquids extends TransportedMaterials {
    private Integer volume;
    private Integer weight; // Liquid weight in liters

    public Liquids(String name, Integer securityLevel, Integer volume, Integer weight) {
        super(name, securityLevel);
        this.volume = volume;
        this.weight = weight;
    }
    public Integer getLiquidDensity() {
        return weight/volume;
    }
}