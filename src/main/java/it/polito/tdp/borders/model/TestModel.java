package it.polito.tdp.borders.model;

import it.polito.tdp.borders.db.BordersDAO;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		BordersDAO dao = new BordersDAO();
		model.creaGrafo(1825);
		for (Supporto s : model.elencoStati()) {
			System.out.println(s+"\n");
		}

//		System.out.println("Creo il grafo relativo al 2000");
//		model.createGraph(2000);

//		List<Country> countries = model.getCountries();
//		System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());

//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		

	}

}
