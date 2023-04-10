public class LiquidMatCar extends BasicFreightCar{
    private Integer basicPackageWeight = 20;
    private String[] typesOfLiquid = {"gasoline", "oil", "milk"};
    private String liquidType;
    //is flammable


    public LiquidMatCar(String securityInformation, Integer netWeight,
                        Integer shipperNumber, Integer standardPackageWeight,
                        Integer basicPackageWeight, String liquidType) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
        this.basicPackageWeight = basicPackageWeight;
        if (availableLiquidType(liquidType)) {
            this.liquidType = liquidType;
        } else {
            throw new IllegalArgumentException("Invalid liquid type: " + liquidType);
        }
    }


    private boolean availableLiquidType(String liquidType) {
        String[] availableLiquidTypes = {"gasoline", "oil", "milk"};
        for (String color : availableLiquidTypes) {
            if (color.equals(liquidType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer getPackageWeight() {
        return basicPackageWeight;

    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }

    @Override
    public Integer getTotalWeightOfPackages() {
        return super.getTotalWeightOfPackages();
    }
}
