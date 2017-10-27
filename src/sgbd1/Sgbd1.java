/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd1;

import java.sql.*;



/**
 *
 * @author Langenoir
 */
public class Sgbd1 {

    public static void main(String[] args) {
        
      String urlBaseDeDonnees = "jdbc:mysql://localhost:3306/sgbd"; 
    // base de données à exploiter
      String table = "etudiant";
      String table1 = "cours";
    
        Connection connect = null; // connexion avec la base
        Connection connect1 = null; // connexion avec la base
        Connection connect2 = null; // connexion avec la base
        Connection connect3 = null; // connexion avec la base
        Connection connect4 = null; // connexion avec la base
        Connection connect5 = null; // connexion avec la base
        
        Statement S = null; // objet d'émission des requêtes
        Statement S1 = null; // objet d'émission des requêtes
        Statement S2 = null; // objet d'émission des requêtes
        Statement S3 = null; // objet d'émission des requêtes
        Statement S4 = null; // objet d'émission des requêtes
        Statement S5 = null; // objet d'émission des requêtes
        
        ResultSet RS = null; // table résultat d'une requête
        ResultSet RS1 = null; // table résultat d'une requête
        ResultSet RS2 = null; // table résultat d'une requête
        ResultSet RS3 = null; // table résultat d'une requête
        ResultSet RS4 = null; // table résultat d'une requête
        ResultSet RS5 = null; // table résultat d'une requête
        try {
// connexion à la base
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection( urlBaseDeDonnees, "root", "");
            connect1 = DriverManager.getConnection( urlBaseDeDonnees, "root", "");
            connect2 = DriverManager.getConnection( urlBaseDeDonnees, "root", "");
            connect3 = DriverManager.getConnection( urlBaseDeDonnees, "root", "");
            connect4 = DriverManager.getConnection( urlBaseDeDonnees, "root", "");
            connect5 = DriverManager.getConnection( urlBaseDeDonnees, "root", "");
            System.out.println("Connexion avec la base  établie");
            
// création d'un objet Statement
            S = connect.createStatement();
            S1 = connect.createStatement();
            S2 = connect.createStatement();
            S3 = connect.createStatement();
            S4 = connect.createStatement();
            S5 = connect.createStatement();
// exécution d'une requête select
            RS = S.executeQuery("select * from " + table);
            RS1 = S1.executeQuery("select * from " + table+ " INNER JOIN cours WHERE " + table +".id =  "+table1+".id");
            RS2 = S2.executeQuery("select * from " + table+ " INNER JOIN cours WHERE " + table+ ".nom_cours = "+table1+".nom_cours");
            RS3 = S3.executeQuery("select nom_cours from " + table);
            RS4 = S4.executeQuery("select nom_cours from " + table1);
            RS5 = S5.executeQuery("select * from " + table1);
            System.out.println("ok");
// exploitation de la table des résultats
            while (RS.next()) { 
// tant qu'il y a une ligne à exploiter
// on l'affiche à l'écran
                System.out.println(RS.getString("id") + ","
                        + RS.getString("nom") + ","
                        + RS.getString("prenom") + ","
                        + RS.getString("nom_cours") + ";");
                System.out.println("ok1");}
            while (RS1.next()) { 
                System.out.println(RS1.getString("id") + ","                        
                        + RS1.getString("nombre_heure") + ","
                        + RS1.getString("nom_cours") + ","
                        + RS1.getString("nom_prof")+";");
                                System.out.println("ok1");}
while (RS2.next()) { 
                System.out.println(RS2.getString("etudiant.id") + ","
                        + RS2.getString("etudiant.nom") + ","
                        + RS2.getString("etudiant.prenom") + ","
                        + RS2.getString("etudiant.nom_cours") + ","
                          + RS2.getString("cours.id") + ","
                        + RS2.getString("cours.nom_cours") + ","
                        + RS2.getString("cours.nombre_heure") + ","
                        + RS2.getString("cours.nom_prof") + ";");
                                System.out.println("ok2");}
while (RS3.next()) { 
                System.out.println(RS3.getString("nom_cours") );
                                System.out.println("ok3");}
while (RS4.next()) { 
                System.out.println(RS4.getString("nom_cours"));
                                System.out.println("ok4");}
while (RS5.next()) { 
                System.out.println(RS5.getString("id") + ","
                        + RS5.getString("nom_cours") + ","
                        + RS5.getString("nombre_heure") + ","
                        + RS5.getString("nom_prof") + ";");
                                System.out.println("ok5");}

            // ligne suivante
        } catch (Exception e) {
            erreur("Erreur " + e, 2);
        }
// fermeture de la base
        try {
            connect.close();
            System.out.println("Base " + table + " fermée");
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }// main

    public static void erreur(String msg, int exitCode) {
        System.err.println(msg);
        System.exit(exitCode);
    }
}


