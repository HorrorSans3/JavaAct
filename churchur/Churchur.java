/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package churchur;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author AICS-CEBU
 */
public class Churchur {

    
    
    /**
     * @param args the command line arguments
     */
    public static void objects(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ID:");
        int id = in.nextInt();
        System.out.println("Enter First Name:");
        String fname = in.next();
        System.out.println("Enter Last Name:");
        String lname = in.next();
        System.out.println("Enter Rank:");
        int rnk = in.nextInt();
        
        
        System.out.println("Enter Position:");
        String pos = in.next();
        System.out.println("Enter Department:");
        String dep = in.next();
        Double sal;
        if(rnk == 1){
             sal = 25000.00;
        }
        else if(rnk == 2){
             sal = 15000.00;
        }
        else if(rnk == 3){
             sal = 12000.00;
        }
        else{
            sal = 0.00;
        }
        
        insert(id,fname,lname,rnk,pos,dep,sal);
        System.exit(0);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        objects();
    }
    
    static void insert(int id, String fname, String lname, int rank, String pos, String dep, Double sal){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/churchdb","root","")){
            Statement st = con.createStatement();
            String sql = "insert into tbemp values ("+id+",'"+fname+"','"+lname+"',"+rank+",'"+pos+"','"+dep+"',"+sal+")";
            
            st.executeUpdate(sql);
            con.close();
            }
        
        
        }catch(Exception e){System.out.print(e);}
       
    }
}


