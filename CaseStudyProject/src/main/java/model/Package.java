package model;

public class Package {
	String packageId;
	String sourcePlace;
	String destinationPlace;
	double basicFare;
	int noOfDays;
	double packageCost;
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	public String getPackageId() {
		return packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	
	public void calculatePackageCost() {
		double val=basicFare*noOfDays;
		if(noOfDays<=5)
			this.packageCost = val;
		else if(noOfDays>5 && noOfDays<=8)
			this.packageCost = val*0.97;
		else if(noOfDays>8 && noOfDays<=10)
			this.packageCost = val*0.95;
		else if(noOfDays>5)
			this.packageCost = val*0.93;
	}
}
