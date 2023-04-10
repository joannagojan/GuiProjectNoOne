
public class LiquidMatCar extends BasicFreightCar{
    private Integer liquidPackageWeight;
    private String[] typesOfLiquid = {"gasoline", "oil", "milk"};
    private String liquidType;
    //is flammable


    public LiquidMatCar(String securityInformation, Integer netWeight,
                        Integer shipperNumber, Integer standardPackageWeight,
                        String liquidType) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
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
        if (liquidType.equals("gasoline")) {
            liquidPackageWeight = 20;
        }
        if (liquidType.equals("oil")) {
            liquidPackageWeight = 40;
        }
        if (liquidType.equals("milk")) {
            liquidPackageWeight = 30;
        }
        return liquidPackageWeight;
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
