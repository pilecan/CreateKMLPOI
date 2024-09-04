package build;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Poi;

public class BuildPlacemark {
	private static final Map<String, String> ICON_MAP;
	static {
		Map<String, String> aMap = new HashMap<>();
		aMap.put("Canyon", "http://maps.google.com/mapfiles/kml/shapes/hiker.png");
		aMap.put("church", "http://maps.google.com/mapfiles/kml/paddle/ylw-stars.png");
		aMap.put("city", "http://maps.google.com/mapfiles/kml/paddle/wht-stars.png");
		aMap.put("cathedral", "http://maps.google.com/mapfiles/kml/paddle/ylw-diamond.png");
		aMap.put("Cap", "http://maps.google.com/mapfiles/kml/shapes/trail.png");
		aMap.put("TRAIL", "http://maps.google.com/mapfiles/kml/shapes/trail.png");
		aMap.put("CAMP", "http://maps.google.com/mapfiles/kml/shapes/campground.png");
		aMap.put("Chalet", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("Cove", "http://maps.google.com/mapfiles/kml/shapes/marina.png");
		aMap.put("Historic", "http://maps.google.com/mapfiles/kml/shapes/info_circle.png");
		aMap.put("Hostel", "http://maps.google.com/mapfiles/kml/shapes/lodging.png");
		aMap.put("Lake", "http://maps.google.com/mapfiles/kml/shapes/fishing.png");
		aMap.put("Lighthouse", "http://maps.google.com/mapfiles/kml/shapes/target.png");
		aMap.put("Pavillon", "http://maps.google.com/mapfiles/kml/shapes/ranger_station.png");
		aMap.put("Plane", "http://maps.google.com/mapfiles/kml/shapes/flag.png");
		aMap.put("Port", "http://maps.google.com/mapfiles/kml/shapes/ferry.png");
		aMap.put("tor", "http://maps.google.com/mapfiles/kml/shapes/placemark_square.png");
		aMap.put("Pourvoirie", "http://maps.google.com/mapfiles/kml/shapes/ranger_station.png");
		aMap.put("Reserve", "http://maps.google.com/mapfiles/kml/shapes/parks.png");
		aMap.put("PARK", "http://maps.google.com/mapfiles/kml/shapes/parks.png");
		aMap.put("PPARK", "http://maps.google.com/mapfiles/kml/shapes/picnic.png");
		aMap.put("SKI", "http://maps.google.com/mapfiles/kml/shapes/ski.png");
		aMap.put("Waterfall", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("BCH", "http://maps.google.com/mapfiles/kml/shapes/swimming.png");
		aMap.put("CHAN", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("FALL", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("TRUCK", "http://maps.google.com/mapfiles/kml/shapes/truck.png");
		aMap.put("BRIDG", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("ISL", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("ANCH", "http://maps.google.com/mapfiles/kml/shapes/marina.png");
		aMap.put("RAP", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("LAKE", "http://maps.google.com/mapfiles/kml/shapes/sailing.png");
		aMap.put("FOR", "http://maps.google.com/mapfiles/kml/shapes/parks.png");
		aMap.put("RIV", "http://maps.google.com/mapfiles/kml/shapes/fishing.png");
		aMap.put("HYDR", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("SITE", "http://maps.google.com/mapfiles/kml/shapes/parks.png");
		aMap.put("RIVF", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("Wreck", "http://maps.google.com/mapfiles/kml/shapes/poi.png");
		aMap.put("River", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("SEA", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("SEAF", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("BAY", "http://maps.google.com/mapfiles/kml/shapes/marina.png");
		aMap.put("SEAU", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("SPRG", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("VEGL", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("SHL", "http://maps.google.com/mapfiles/kml/shapes/water.png");
		aMap.put("Castle", "http://maps.google.com/mapfiles/kml/shapes/ranger_station.png");
		aMap.put("GEOG", "http://maps.google.com/mapfiles/kml/shapes/ranger_station.png");
		aMap.put("Village", "http://maps.google.com/mapfiles/kml/shapes/square.png");
		aMap.put("Church", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("Abbey", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("", "http://maps.google.com/mapfiles/kml/paddle/ltblu-blank.png");
		aMap.put("VILG", "http://maps.google.com/mapfiles/kml/paddle/wht-blank.png");
		aMap.put("CITY", "http://maps.google.com/mapfiles/kml/paddle/wht-blank.png");
		aMap.put(null, "http://maps.google.com/mapfiles/kml/paddle/wht-blank.png");
		aMap.put("minor", "http://maps.google.com/mapfiles/kml/paddle/blu-stars.png");
		aMap.put("TER", "http://maps.google.com/mapfiles/kml/paddle/blu-stars.png");
		aMap.put("admin", "http://maps.google.com/mapfiles/kml/paddle/pink-stars.png");
		aMap.put("primary", "http://maps.google.com/mapfiles/kml/paddle/ylw-stars.png");
		aMap.put("volcano", "http://maps.google.com/mapfiles/kml/shapes/volcano.png");
		aMap.put("vor", "http://maps.google.com/mapfiles/kml/shapes/polygon.png");
		aMap.put("ndb", "http://maps.google.com/mapfiles/kml/shapes/triangle.png");
		aMap.put("airport", "http://maps.google.com/mapfiles/kml/shapes/airports.png");
		aMap.put("AIR", "http://maps.google.com/mapfiles/kml/shapes/airports.png");
		aMap.put("mountain", "http://maps.google.com/mapfiles/kml/shapes/hiker.png");
		aMap.put("Summit", "http://maps.google.com/mapfiles/kml/shapes/hiker.png");
		aMap.put("MTN", "http://maps.google.com/mapfiles/kml/shapes/hiker.png");
		aMap.put("CLF", "http://maps.google.com/mapfiles/kml/shapes/hiker.png");
		aMap.put("CRAT", "http://maps.google.com/mapfiles/kml/shapes/poi.png");
		aMap.put("VALL", "http://maps.google.com/mapfiles/kml/shapes/poi.png");
		aMap.put("CAVE", "http://maps.google.com/mapfiles/kml/shapes/poi.png");
		aMap.put("RES", "http://maps.google.com/mapfiles/kml/shapes/poi.png");
		aMap.put("GLAC", "http://maps.google.com/mapfiles/kml/shapes/snowflake_simple.png");
		aMap.put("CAPE", "http://maps.google.com/mapfiles/kml/shapes/camera.png");
		aMap.put("PLN", "http://maps.google.com/mapfiles/kml/shapes/camera.png");
		aMap.put("camera", "http://maps.google.com/mapfiles/kml/shapes/camera.png");
		aMap.put("HAM", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("HAM", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("TOWN", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("IR", "http://maps.google.com/mapfiles/kml/shapes/target.png");
		aMap.put("MAR", "http://maps.google.com/mapfiles/kml/shapes/ferry.png");
		aMap.put("MISC", "http://maps.google.com/mapfiles/kml/pushpin/wht-pushpin.png");
		aMap.put("MIL", "http://maps.google.com/mapfiles/kml/shapes/police.png");
		aMap.put("MUN1", "http://maps.google.com/mapfiles/kml/pushpin/wht-pushpin.png");
		aMap.put("MUN2", "http://maps.google.com/mapfiles/kml/pushpin/wht-pushpin.png");
		aMap.put("PROV", "http://maps.google.com/mapfiles/kml/paddle/ylw-stars.png");
		aMap.put("RAIL", "http://maps.google.com/mapfiles/kml/shapes/rail.png");
		aMap.put("RECR", "http://maps.google.com/mapfiles/kml/shapes/play.png");
		aMap.put("UNP", "http://maps.google.com/mapfiles/kml/shapes/ranger_station.png");
		aMap.put("ROAD", "http://maps.google.com/mapfiles/kml/shapes/truck.png");
		aMap.put("house", "http://maps.google.com/mapfiles/kml/shapes/homegardenbusiness.png");
		aMap.put("webcam", "http://maps.google.com/mapfiles/kml/shapes/webcam.png");
		aMap.put("star", "http://maps.google.com/mapfiles/kml/shapes/star.png");

		aMap.put("01d", "http://maps.google.com/mapfiles/kml/shapes/sunny.png");
		aMap.put("01n", "http://maps.google.com/mapfiles/kml/shapes/sunny.png");

		aMap.put("02d", "http://maps.google.com/mapfiles/kml/shapes/partly_cloudy.png");
		aMap.put("02n", "http://maps.google.com/mapfiles/kml/shapes/partly_cloudy.png");

		aMap.put("04d", "http://maps.google.com/mapfiles/kml/shapes/shaded_dot.png");
		aMap.put("04n", "http://maps.google.com/mapfiles/kml/shapes/shaded_dot.png");

		aMap.put("09d", "http://maps.google.com/mapfiles/kml/shapes/partly_cloudy.png");
		aMap.put("09n", "http://maps.google.com/mapfiles/kml/shapes/partly_cloudy.png");

		aMap.put("03d", "http://maps.google.com/mapfiles/kml/shapes/rainy.png");
		aMap.put("03n", "http://maps.google.com/mapfiles/kml/shapes/rainy.png");

		aMap.put("10d", "http://maps.google.com/mapfiles/kml/shapes/rainy.png");
		aMap.put("10n", "http://maps.google.com/mapfiles/kml/shapes/rainy.png");

		aMap.put("11d", "http://maps.google.com/mapfiles/kml/shapes/rainy.png");
		aMap.put("11n", "http://maps.google.com/mapfiles/kml/shapes/rainy.png");

		aMap.put("13d", "http://maps.google.com/mapfiles/kml/shapes/snowflake_simple.png");
		aMap.put("13n", "http://maps.google.com/mapfiles/kml/shapes/snowflake_simple.png");

		aMap.put("50d", "http://maps.google.com/mapfiles/kml/shapes/shaded_dot.png");
		aMap.put("50n", "http://maps.google.com/mapfiles/kml/shapes/shaded_dot.png");

		ICON_MAP = Collections.unmodifiableMap(aMap);
	}
	
	private static String wikipedia = "http://en.wikipedia.org/wiki/Special:Search?search=";
	private static String google = "https://www.google.com/search?q=";
	private static String ventusky = "https://www.ventusky.com/?p=";
	private static String decoration = "style=\"a:visited:color:red; text-decoration: none;background-color:white;\" onMouseOver=\"this.style.backgroundColor='#999999'\" onMouseOut=\"this.style.backgroundColor='#FFFFFF'\"";

	
	static public void createKML(ArrayList<Poi> pois, String title,String kmlfile) {
		Writer writer = null;
		try {
			// writer = new BufferedWriter(new OutputStreamWriter(new
			// FileOutputStream("g:\\addons\\work\\castel_czech.kml"), "utf-8"));

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(kmlfile), "utf-8"));

			writer.write(createKMLHeader(pois.size(), title));

			for (int i = 0; i < pois.size(); i++) {
				writer.write(buildPlaceMark(pois.get(i)));
				// System.out.println(buildXML(cities.get(i)));
				//writer.write(buildCityPlaceMark(cities.get(i)));
			}

			writer.write("</Folder></Document></kml>");

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}
	
	}

	static public String buildPlaceMark(Poi poi) {

	//	String description = buildCityDescriptionLink(poi);
		String description = poi.getName();
		
		description = "Google: <a " + decoration + " href=\"" +google+ poi.getName()+" "+poi.getRegion()+ "\">" + poi.getName() + "</a></br>";
		description += "Weather: <a " + decoration + " href=\"" +ventusky+ poi.getLatx()+","+poi.getLony()+ ";8&l=radar\">"+poi.getRegion()+"</a>";
		
		String icone = "<Style id=\"silo\"><IconStyle><Icon><href>" + ICON_MAP.get(selectIcon(poi.getName()))
				+ "</href></Icon></IconStyle></Style>";

		return "<Placemark><name>" + poi.getName() + "</name>\n" + "<description><![CDATA[" + description
				+ "]]></description>\n" + icone + "<Point><coordinates>" + poi.getCoordinates()
				+ "</coordinates></Point>\n" + "</Placemark>\n";
	}
	
	private static String createKMLHeader(int total, String title) {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">"
				+ "<Document>" + "<Folder>" + "<name>" + title + "</name>" + "<description><div>" + total + " " + title
				+ "</div>"
				// + "<div>"+fligthSimPage+"</div>"
				+ "<div>KML file create by PlanetIsCalling</div>" + " </description>";
	}
	
	private static String selectIcon(String name) {
		String icon = "";
		
		if (name.toLowerCase().indexOf("lighthouse") != -1) {
			icon = "Lighthouse";
		} else if (name.toLowerCase().indexOf("castle") != -1) {
			icon = "Castle";
		} else if (name.toLowerCase().indexOf("ahomegardenbusinessirfield") != -1) {
			icon = "airport";
		} else if (name.toLowerCase().indexOf("house") != -1) {
			icon = "house";
		} else if (name.toLowerCase().indexOf("antenna") != -1) {
			icon = "Lighthouse";
		} else if (name.toLowerCase().indexOf("hotel") != -1) {
			icon = "house";
		} else if (name.toLowerCase().indexOf("viaduct") != -1) {
			icon = "BRIDG";
		} else if (name.toLowerCase().indexOf("tor") != -1) {
			icon = "tor";
		} else if (name.toLowerCase().indexOf("hall") != -1) {
			icon = "Castle";
		} else if (name.toLowerCase().indexOf("bridge") != -1) {
			icon = "BRIDG";
		} else if (name.toLowerCase().indexOf("fort") != -1) {
			icon = "Castle";
		} else if (name.toLowerCase().indexOf("tower") != -1) {
			icon = "IR";
		} else if (name.toLowerCase().indexOf("observatory") != -1) {
			icon = "webcam";
		} else if (name.toLowerCase().indexOf("railway") != -1) {
			icon = "RAIL";
		} else if (name.toLowerCase().indexOf("monument") != -1) {
			icon = "star";
		} else if (name.toLowerCase().indexOf("temple") != -1) {
			icon = "TER";
		} else if (name.toLowerCase().indexOf("cathedral") != -1) {
			icon = "cathedral";
		} else if (name.toLowerCase().indexOf("summit") != -1) {
			icon = "Summit";
		} else if (name.toLowerCase().indexOf("dam") != -1) {
			icon = "BRIDG";
		}  else if (name.toLowerCase().indexOf("beacon") != -1) {
			icon = "Lighthouse";
		}  else if (name.toLowerCase().indexOf("radar") != -1) {
			icon = "webcam";
		}  else if (name.toLowerCase().indexOf("church") != -1) {
			icon = "church";
		}  else if (name.toLowerCase().indexOf("chapel") != -1) {
			icon = "church";
		}  else if (name.toLowerCase().indexOf("basilica") != -1) {
			icon = "church";
		}  else {
			icon = "camera";
		}
	  
		  
		  
		  
		
		return icon;
	}



}
