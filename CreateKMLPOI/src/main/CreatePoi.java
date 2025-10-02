package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import build.BuildCVS;
import model.Poi;

public class CreatePoi {
	
	private static 	ArrayList<Poi> pois =   new ArrayList<Poi>();
	
	private static String source;
	private static String filename;
	private static String kmlfile;
	private static String cvsfile;

	public static void main(String[] args) {

		source = "g:\\addons\\work\\japan_update-2\\";
		kmlfile = source+"japan_POIs_update 20.kml";
		cvsfile = source+"japan_POIs_update 20.cvs";
		filename = "japan_POIs_update 20.txt";
		
		pois = readFile(source , filename);
		
		pois.forEach((n) -> System.out.println(n.toString())); 
		
		System.out.println("size : "+pois.size());
		
	//	BuildPlacemark.createKML(pois, "MSFS World Update XVIII",kmlfile);
		
		BuildCVS.createCVS(pois, "MSFS Update 20", "Japan", cvsfile);
	}
	
	 static public ArrayList <Poi>  readFile(String source , String filename) {
		ArrayList<Poi> pois =  new ArrayList<Poi>();
		 String[] line;
		 String string = null;
		 String region = null;
		 String[] coord = null;
		 Poi poi;
		    try {
		        File myObj = new File(source+"\\"+filename);
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		        	poi = new Poi();
		        	
		        	string = myReader.nextLine();
		        	line = string.split("\\|");
		        	
		        	if (line[1].equals("region")) {
		        		region = line[0];
		        		System.out.println(region);
		        	} else {
			        	poi.setName(line[0]);
			        	
			        	coord = line[1].split(",");
			        	poi.setCoordinates(coord[1]+","+coord[0]);
			        	poi.setLatx(coord[0]);
			        	poi.setLony(coord[1]);
			        	poi.setRegion(region);
			        	
			        	pois.add(poi);
		        		
		        	}
		        	
		        }
		        myReader.close();
		      } catch (FileNotFoundException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      } catch (ArrayIndexOutOfBoundsException e) {
				System.err.println(string);
			}

		    return pois;
		    
	 }	
	 
	 



}
