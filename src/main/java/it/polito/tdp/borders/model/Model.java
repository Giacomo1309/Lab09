package it.polito.tdp.borders.model;

import it.polito.tdp.borders.db.*;

import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.DefaultEdge;

public class Model {

	private SimpleGraph<Country, DefaultEdge> grafo;
	private Map<Integer, Country> idMap;
	private BordersDAO dao;

	public Model() {
		idMap = new HashMap<Integer, Country>();
		dao = new BordersDAO();

	}

	public void creaGrafo(int anno) {
		this.dao.getCountryPairs(anno, this.idMap); // riempio la mappa dei vertici
		this.grafo = new SimpleGraph<>(DefaultEdge.class);
		Graphs.addAllVertices(this.grafo, this.idMap.values());

		// aggiungo gli archi (UNA LISTA)
		for (Border b : dao.getArchi(anno, this.idMap)) {
			this.grafo.addEdge(b.getStato1(), b.getStato2());
			// non so se devo aggiungere anche da stato2 a stato1
		}
	}

	public List<Supporto> elencoStati() {
		List<Supporto> supporto = new ArrayList<Supporto>();
		for (Country c : this.grafo.vertexSet()) {
			Supporto s = new Supporto(c,this.grafo.degreeOf(c));
			supporto.add(s);
			
		}
		return supporto;
	}
	public Collection<Country> popoloTendina () {
		
		return this.grafo.vertexSet();
	}

}
