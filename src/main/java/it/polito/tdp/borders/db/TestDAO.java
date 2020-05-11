package it.polito.tdp.borders.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

		System.out.println("Lista di tutte le nazioni:");
	//	List<Country> countries = dao.loadAllCountries();
		Map<Integer,Country> idMap = new HashMap<Integer,Country>();
	//	idMap=null;
		dao.getCountryPairs(1825, idMap);
//		System.out.println(idMap.values().size());
		System.out.println(dao.getArchi(1825,idMap).size());
		
		
	}
}
