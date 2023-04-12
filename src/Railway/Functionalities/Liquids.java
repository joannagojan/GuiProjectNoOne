package Railway.Functionalities;

public class Liquids extends TransportedMaterials {
    private Integer volume;
    private Integer density;

    public Liquids(String name, Integer securityLevel, Integer volume, Integer density) {
        super(name, securityLevel);
        this.volume = volume;
        this.density = density;
    }
    public Integer getLiquidWeight() {
        return volume*density;
    }
}