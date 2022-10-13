package utility;

import java.util.*;
import java.util.regex.*;
import dao.DBHandler;
import exception.InvalidPackageIdException;

import java.io.*;
import java.sql.*;
import model.Package;

public class TravelAgency {
	public List<Package> generatePackageCost(String filePath){
		List<Package> list=new ArrayList<Package>();
		try {
			Reader read=new FileReader(filePath);
			BufferedReader br = new BufferedReader(read);
			String str="";
			while((str=br.readLine())!= null) {
				Package pobj=new Package();
				String[] strarr=str.split(",");
				String packageId = strarr[0];
				try {   
					if(validate(packageId)) {
						pobj.setPackageId(strarr[0]);
						pobj.setSourcePlace(strarr[1]);
						pobj.setDestinationPlace(strarr[2]);
						pobj.setBasicFare((Double.parseDouble(strarr[3])));
						pobj.setNoOfDays(Integer.parseInt(strarr[4]));
						pobj.calculatePackageCost();
						list.add(pobj);
					}
				}
				catch (InvalidPackageIdException e) {
					System.out.println(e.getMessage() + packageId);
				}
			}
			br.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public boolean validate(String packageId) throws InvalidPackageIdException {
		Pattern pattern = Pattern.compile("[0-9a-zA-Z]{3}[\\/]{1}[0-9a-zA-Z]{3}");
		Matcher match = pattern.matcher(packageId);
		if(match.matches())return true;
		else throw new InvalidPackageIdException("Invalid Pacakge Id");
	}
	public List<Package> findPackagesWithMinimumNumberOfDays(){
		List<Package> list=new ArrayList<Package>();
		Connection con=DBHandler.establishConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from package_details where no_of_days in (select min(no_of_days) from package_details)");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Package pobj = new Package();
				pobj.setPackageId(rs.getString(1));
				pobj.setSourcePlace(rs.getString(2));
				pobj.setDestinationPlace(rs.getString(3));
				pobj.setNoOfDays(rs.getInt(4));
				pobj.setPackageCost(rs.getDouble(5));
				list.add(pobj);
			}
			con.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
