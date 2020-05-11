package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries() {

		String sql = "SELECT ccode, StateAbb, StateNme FROM country ORDER BY StateAbb";
		List<Country> result = new ArrayList<Country>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public void getCountryPairs(int anno, Map<Integer,Country> idMap) {
		String sql = "SELECT dyad, state1no, country.StateNme,state1ab, state2no,state2ab,year " + 
				"FROM contiguity, country " + 
				"WHERE conttype = 1 && YEAR<=? && country.CCode=contiguity.state1no "+ 
				"ORDER BY state1no";
		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String abb = rs.getString("state1ab") ;
				int codice = rs.getInt("state1no");
				String nome = rs.getString("country.StateNme");
				if(!idMap.containsKey(codice)) {
					Country nuovo = new Country(abb,codice,nome);
					idMap.put(codice, nuovo);
				}
				
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}

	}

	public List<Border> getArchi(int anno, Map<Integer,Country> idMap) {
		String sql =  "SELECT dyad, state1no, country.StateNme,state1ab, state2no,state2ab,year " + 
				"FROM contiguity, country " + 
				"WHERE conttype = 1 && YEAR<=? && country.CCode=contiguity.state1no "+
				"GROUP BY dyad "+
				"ORDER BY state1no";
		List<Border> result = new ArrayList<Border>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int codice = rs.getInt("dyad");
				int year = rs.getInt("year");
				int stato1 = rs.getInt("state1no");
				int stato2 = rs.getInt("state2no");
				Border nuovo = new Border(codice,year,idMap.get(stato1),idMap.get(stato2));
				result.add(nuovo);
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
		
	}

}
