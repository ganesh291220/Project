package controller;

import java.util.List;
import model.Package;
import utility.TravelAgency;

public class MainApp {
	public static void main(String[] args){
		TravelAgency ta=new TravelAgency();
		try {
			List<Package> list=ta.findPackagesWithMinimumNumberOfDays();
			for(Package p: list) {
				System.out.println(p.getPackageId()+" "+p.getSourcePlace()+" "+p.getDestinationPlace()+" "+p.getNoOfDays()+" "+p.getPackageCost());
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
