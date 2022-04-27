package Class;

import java.util.Objects;

public class Arc {

	private int poids;
	private Sommet s1;
	private Sommet s2;
	private boolean oriente;

	/**
	 * @brief Constructeur Arc avec 4 parametres
	 * @param s1 Sommet de depart
	 * @param s2 Sommet d'arrivee
	 * @param poids Poids de l'arc
	 * @param oriente true si oriente, false sinon
	 */
	public Arc(Sommet s1, Sommet s2, int poids, boolean oriente)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.poids = poids; 
		this.oriente = oriente;
	}


	/**
	 * @brief Constructeur avec 3 parametres, oriente par defaut
	 * @param s1 Sommet de depart
	 * @param s2 Sommet de d'arrivee
	 * @param poids Poids de l'arc
	 */
	public Arc(Sommet s1, Sommet s2, int poids)
	{
		this(s1, s2 , poids, true);
	}



	/**
	 * @brief Constructeur avec 3 parametres sans poids
	 * @param s1 Sommet de depart
	 * @param s2 Sommet de d'arrivee
	 * @param oriente true si oriente, false sinon
	 */
	public Arc(Sommet s1, Sommet s2, boolean oriente)
	{
		this(s1,s2,0,oriente);
	}



	/**
	 * @brief Constructeur avec 2 parametres, sans poids et oriente par defaut
	 * @param s1 Sommet de depart
	 * @param s2 Sommet de d'arrivee
	 */
	public Arc(Sommet s1, Sommet s2)
	{
		this(s1, s2, 0, true);
	}
	
	/*
	 * --------------------Getters------------------------
	 * ---------------------------------------------------
	 */

	/**
	 * @brief Recupere le poids de l'arc
	 * @return poids
	 */
	public int getPoids() {
		return poids;
	}


	/**
	 * @brief Recupere le sommet de depart
	 * @return s1 (sommet de depart)
	 */
	public Sommet getS1() {
		return s1;
	}


	/**
	 * @brief Recupere le sommet d'arrivee
	 * @return s2 (sommet d'arrivee)
	 */
	public Sommet getS2() {
		return s2;
	}

	/**
	 * @brief Test de l'orientation de l'arc
	 * @return true si l'arc est oriente, false sinon
	 */
	public boolean isOriente() {
		return oriente;
	}
	
	/*
	 * ---------------------Setters------------------------
	 * ----------------------------------------------------
	 */

	/**
	 * @brief Modifie le poids de l'arc
	 * @param poids Nouveau poids de l'arc
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}


	/**
	 * @brief Modifie le sommet de depart
	 * @param s1 Nouveau sommet de depart
	 */
	public void setS1(Sommet s1) {
		this.s1 = s1;
	}


	/**
	 * @brief Modifie le sommet d'arrivee
	 * @param s2 Nouveau sommet d'arrivee
	 */
	public void setS2(Sommet s2) {
		this.s2 = s2;
	}

	/**
	 * @brief Modifie l'orientation de l'arc
	 * @param oriente Nouvelle orientation
	 */
	public void setOriente(boolean oriente) {
		this.oriente = oriente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(oriente, poids, s1, s2);
	}

	/**
	 * @brief Surcharge de l'operateur equals vérifiant que deux ars sont identiques
	 * @param obj Object
	 * @return true si les arcs sont identiques, false sinon
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arc other = (Arc) obj;
		return oriente == other.oriente && poids == other.poids && s1.equals(other.s1)
				&& s2.equals(other.s2);
	}

	/**
	 * @brief Affiche un arc
	 * @return String
	 */
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append('['+ s1.toString() + ','+ s2.toString()+ "] : "+ poids);
		if(oriente == true)
		{
			str.append(", oriente");
		}
		else 
		{
			str.append(", non oriente");
		}
		return str.toString();
		
	}

}
