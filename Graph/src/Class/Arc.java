package Class;

import java.util.Objects;

public class Arc {

	private int poids;
	private Sommet s1;
	private Sommet s2;
	private boolean oriente;

	/**
	 * Constructeur Arc 4 paramètres
	 * @param s1 sommet de départ
	 * @param s2 sommet d'arrivée
	 * @param poids
	 * @param oriente vrai si orienté faux sinon
	 */
	public Arc(Sommet s1, Sommet s2, int poids, boolean oriente)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.poids = poids; 
		this.oriente = oriente;
	}


	/**
	 * Constructeur 3 paramètres, orienté par défaut
	 * @param s1 sommet de départ
	 * @param s2 sommet de d'arrivée
	 * @param poids sommet de départ
	 */
	public Arc(Sommet s1, Sommet s2, int poids)
	{
		this(s1, s2 , poids, true);
	}



	/**
	 * Constructeur 3 paramètres sans poids
	 * @param s1 sommet de départ
	 * @param s2 sommet de d'arrivée
	 * @param oriente
	 */
	public Arc(Sommet s1, Sommet s2, boolean oriente)
	{
		this(s1,s2,0,oriente);
	}



	/**
	 * Constructeur 2 paramètres, sans poids et orienté par défaut
	 * @param s1 sommet de départ
	 * @param s2 sommet de d'arrivée
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
	 * Récupère le poids de l'arc
	 * @return poids
	 */
	public int getPoids() {
		return poids;
	}


	/**
	 * Récupère le sommet de départ
	 * @return s1 (sommet de départ)
	 */
	public Sommet getS1() {
		return s1;
	}


	/**
	 * Récupère le sommet de d'arrivée
	 * @return s2 (sommet  d'arrivée')
	 */
	public Sommet getS2() {
		return s2;
	}

	/**
	 * Retourne vrai si l'arc est orienté, faux sinon
	 * @return oriente
	 */
	public boolean isOriente() {
		return oriente;
	}
	
	/*
	 * ---------------------Setters------------------------
	 * ----------------------------------------------------
	 */

	/**
	 * Modifie le poids de l'arc
	 * @param poids la nouvelle valeur du poid de l'arc
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}


	/**
	 * Modifie le sommet de départ
	 * @param s1 le nouveau sommets de départ
	 */
	public void setS1(Sommet s1) {
		this.s1 = s1;
	}


	/**
	 * Modifie le sommet d'arrivée
	 * @param s2 le nouveau sommets d'arrivée
	 */
	public void setS2(Sommet s2) {
		this.s2 = s2;
	}

	/**
	 * Modifie si l'orientation de l'arc
	 * @param oriente
	 */
	public void setOriente(boolean oriente) {
		this.oriente = oriente;
	}
	



	@Override
	public int hashCode() {
		return Objects.hash(oriente, poids, s1, s2);
	}

	/**
	 * vérifie si deux arcs sont identiques :
	 * il compare que les deux arcs possèdent la même référence mémoire et sont donc en fait le même arc.
	 * @param obj
	 * @return vrai si arcs identiques, faux sinon
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
	 * Affiche un arc selon sont cas orienté ou non
	 * @return une chaine de caractère qui représente l'arc orienté ou non orienté
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
