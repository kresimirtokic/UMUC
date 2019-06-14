/*
 * Author: Kresimir Tokic
 * Date: 5/1/19
 * Filename: DirectedGraph.java
 * About: UMUC CMSC350 Project 4
 * Creates DirectedGraph, Searches it, returns output string
 */

import java.util.*;

public class DirectedGraph {
	
	//variables
	private static HashMap<String, Integer> vertexMap = new HashMap<>();//could use T instead of string
	private static ArrayList<LinkedList<Integer>> adjacencyList;
	private static int vertexCount = 0;
	private StringBuilder recompOrder = new StringBuilder();
	private List<Integer> adjacentVertex = new ArrayList<>();
	private int startingPoint;
	private int endingPoint;


	// default constructor
	public DirectedGraph() {
		vertexMap = new HashMap<String, Integer>(); 
		adjacencyList = new ArrayList<LinkedList<Integer>>();
	}
	
	// method creates directed graph
	public static DirectedGraph createDirectedGraph(String[] lines) { 
		DirectedGraph theGraph = new DirectedGraph();
		String[] words = null;
		for (String tl : lines) {
			words = tl.split(" ");
			for (int i = 0; i < words.length; i++) {
				createVertexMap(words[i]);
				if (i != 0) {
					theGraph.addEdge(words[0], words[i]);
				}
			}
		}
		return theGraph;
	}

	//this one
	// method parses the data from the file
	private static void createVertexMap(String vertexName) { 
		if (!vertexMap.containsKey(vertexName)) {
			vertexMap.put(vertexName, vertexCount); //vertexNumber
			LinkedList<Integer> adjacent = new LinkedList<>();
			adjacencyList.add(vertexCount, adjacent);
			vertexCount++;
		}
	}

	// this one
	//method adds edges 
	private void addEdge(String source, String destination) {
		startingPoint = vertexMap.get(source); //try parseInt
		endingPoint = vertexMap.get(destination);//try parseInt
		adjacencyList.get(startingPoint).add(endingPoint);
	}
	
	// this one
	// method gets key values
	private String getKey(int value) {
		for (String elementsOf : vertexMap.keySet()) {
			if (vertexMap.get(elementsOf).equals(value)) {
				return elementsOf;
			}
		}
		return null;
	}

	//method for topology button, starts recursive depth first search and starts output string
	public String topology(String startingPoint) throws CycleException {
		recompOrder = new StringBuilder();
		adjacentVertex = new ArrayList<>();
		depthFirstSearch(vertexMap.get(startingPoint));
		return recompOrder.toString();
	}
	
	//this one
	//method for depth first search
	private void depthFirstSearch(int vertexNum) throws CycleException {
		recompOrder.append(getKey(vertexNum)).append(" ");
		for (Integer i : adjacencyList.get(vertexNum)) {
			if (adjacentVertex.contains(i)) {
				throw new CycleException("Cycle Detected");
			}
			adjacentVertex.add(i);
			depthFirstSearch(i);
		}
		
	}

}
