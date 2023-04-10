abstract class Package {
    private Integer packageWeight;
    private Integer packageWidth;
    private Integer packageHeight;
    private Integer packageLength;
    Integer mailCarWidth = 240; // Baggage and Mail Car width in cm
    Integer mailCarHeight = 260; // Baggage and Mail Car height in cm
    Integer mailCarLength = 1500; // Baggage and Mail Car width in cm
    Integer maxMailCarWeight = 100; // Baggage and Mail Car maximum load in tons


    public Package(Integer packageWeight, Integer packageWidth, Integer packageHeight, Integer packageLength) {
       if (!isPackageSizeWeightValid(packageWeight, packageWidth, packageHeight, packageLength))  {
           throw new IllegalArgumentException("Package size is too big, maximum size available on this train: " +
                   this.mailCarWidth + "cmx"+ this.mailCarHeight +"cmx" + this.mailCarLength +
                   "cm, the weight cannot exceed: " + this.maxMailCarWeight + "tons.");}
       this.packageWeight = packageWeight;
        this.packageWidth = packageWidth;
        this.packageHeight = packageHeight;
        this.packageLength = packageLength;
    }

    public boolean isPackageSizeWeightValid(Integer packageWeight, Integer packageWidth, Integer packageHeight, Integer packageLength) {
        if (packageWidth <= this.mailCarWidth && packageHeight <= this.mailCarHeight
                && packageLength <= this.mailCarLength && packageWeight <= this.maxMailCarWeight) {return true;}
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