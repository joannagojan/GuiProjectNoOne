abstract class Package {
    private Integer packageWeight;
    private Integer packageWidth;
    private Integer packageHeight;
    private Integer packageLength;


    public Package(Integer packageWeight, Integer packageWidth, Integer packageHeight, Integer packageLength) {
       if (!isPackageSizeWeightValid(packageWeight, packageWidth, packageHeight, packageLength))  {
           throw new IllegalArgumentException("Package size is too big, maximum size available on this train: " +
                   carWidth + "cmx"+ this.carHeight +"cmx" + this.carLength +
                   "cm, the weight cannot exceed: " + this.carWeight + "tons.");}
       this.packageWeight = packageWeight;
        this.packageWidth = packageWidth;
        this.packageHeight = packageHeight;
        this.packageLength = packageLength;
    }

    public boolean isPackageSizeWeightValid(Integer packageWeight, Integer packageWidth, Integer packageHeight, Integer packageLength) {
        Integer mailCarWidth = Cars.getCarWidth();
        Integer mailCarHeight = Cars.getCarWidth();
        if (packageWidth <= mailCarWidth && packageHeight <= mailCarHeight
                && packageLength <= carLength && packageWeight <= maxCarWeight) {return true;}
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
    }}