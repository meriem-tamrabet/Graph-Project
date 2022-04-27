package Class;

import java.util.Objects;

public class Arc {

	private int poids;
	private Sommet s1;
	private Sommet s2;
	private boolean oriente;

	/**
	 * Constructeur Arc 4 parametres
	 * @param s1 sommet de depart
	 * @param s2 sommet d'arrivee
	 * @param poids
	 * @param oriente vrai si oriente faux sinon
	 */
	public Arc(Sommet s1, Sommet s2, int poids, boolean oriente)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.poids = poids; 
		this.oriente = oriente;
	}


	/**
	 * Constructeur 3 parametres, oriente par defaut
	 * @param s1 sommet de depart
	 * @param s2 sommet de d'arrivee
	 * @param poids sommet de depart
	 */
	public Arc(Sommet s1, Sommet s2, int poids)
	{
		this(s1, s2 , poids, true);
	}



	/**
	 * Constructeur 3 parametres sans poids
	 * @param s1 sommet de depart
	 * @param s2 sommet de d'arrivee
	 * @param oriente
	 */
	public Arc(Sommet s1, Sommet s2, boolean oriente)
	{
		this(s1,s2,0,oriente);
	}



	/**
	 * Constructeur 2 parametres, sans poids et oriente par defaut
	 * @param s1 sommet de depart
	 * @param s2 sommet de d'arrivee
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
	 * Recupere le poids de l'arc
	 * @return poids
	 */
	public int getPoids() {
		return poids;
	}


	/**
	 * Recupere le sommet de depart
	 * @return s1 (sommet de depart)
	 */
	public Sommet getS1() {
		return s1;
	}


	/**
	 * Recupere le sommet de d'arrivee
	 * @return s2 (sommet  d'arrivee)
	 */
	public Sommet getS2() {
		return s2;
	}

	/**
	 * Retourne vrai si l'arc est oriente, faux sinon
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
	 * @param poids le nouveau poid de l'arc
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}


	/**
	 * Modifie le sommet de depart
	 * @param s1 le nouveau sommet de depart
	 */
	public void setS1(Sommet s1) {
		this.s1 = s1;
	}


	/**
	 * Modifie le sommet d'arrivee
	 * @param s2 le nouveau sommet d'arrivee
	 */
	public void setS2(Sommet s2) {
		this.s2 = s2;
	}

	/**
	 * Modifie l'orientation de l'arc
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
	 * verifie que deux arcs sont identiques :
	 * compare si les deux arcs possedent la meme reference memoire et sont donc en fait le meme arc
	 * ou qu ils ont les memes valeurs
	 * @param obj
	 * @return vrai si arcs identiques ou egaux, faux sinon
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
	 * Affiche un arc selon sont cas oriente ou non
	 * @return une chaine de caractere qui represente l'arc oriente ou non oriente
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
