class Package implements CustomerLoad {
    private Integer packageWeight;
    private Integer packageWidth;
    private Integer packageHeight;
    private Integer packageLength;


    public Package(Integer packageWeight, Integer packageWidth, Integer packageHeight, Integer packageLength) {
       if (!isPackageSizeWeightValid(packageWeight, packageWidth, packageHeight, packageLength))  {
           throw new IllegalArgumentException("Package size is too big, maximum size available on this train: " +
                   Cars.getCarWidth() + "cmx"+ Cars.getCarHeight() +"cmx" + Cars.getCarLength() +
                   "cm, the weight cannot exceed: " + Cars.getStandardMaxCarLoad() + "tons.");}
       this.packageWeight = packageWeight;
        this.packageWidth = packageWidth;
        this.packageHeight = packageHeight;
        this.packageLength = packageLength;
    }

    public boolean isPackageSizeWeightValid(Integer packageWeight, Integer packageWidth, Integer packageHeight, Integer packageLength) {
        if (packageWidth <= Cars.getCarWidth() && packageHeight <= Cars.getCarHeight()
                && packageLength <= Cars.getCarLength() && packageWeight <= Cars.getStandardMaxCarLoad()) {return true;}
        else {return false;}
    }


    public int calculatePackageVolume() {
        return packageWidth * packageHeight * packageLength;
    }
    public String getPackageType() {
        int packageVolume = calculatePackageVolume();
        if (packageWeight <= 50 && packageVolume <= 9000) {
            return "Letter";
        } else if (packageWeight <= 5000 && packageVolume <= 1000000) {
            return "Small";
        } else if (packageWeight <= 10000 && packageVolume <= 5000000) {
            return "Medium";
        } else {
            return "Large";
        }
    }

    @Override
    public Integer getLoadWeight() {
        return packageWeight;
    }

    public void setPackageWeight(Integer packageWeight) {
        this.packageWeight = packageWeight;
    }

    public Integer getPackageWidth() {
        return packageWidth;
    }

    public void setPackageWidth(Integer packageWidth) {
        this.packageWidth = packageWidth;
    }

    public Integer getPackageHeight() {
        return packageHeight;
    }

    public void setPackageHeight(Integer packageHeight) {
        this.packageHeight = packageHeight;
    }

    public Integer getPackageLength() {
        return packageLength;
    }

    public void setPackageLength(Integer packageLength) {
        this.packageLength = packageLength;
    }
}