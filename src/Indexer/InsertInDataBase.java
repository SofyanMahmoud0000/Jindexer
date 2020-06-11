package Indexer;

import data_base.DataBase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class InsertInDataBase {
    private DataBase db;


    public InsertInDataBase() throws SQLException {

        this.db = new DataBase();
        db.CreateDataBase();

        // Delete all rows in crawler and popularity
        String Query = "delete from crawler_urls";
        db.deletedb(Query);

        Query = "delete from hosts_popularity";
        db.deletedb(Query);

        Query = "delete from word_index";
        db.deletedb(Query);

        Query = "delete from word_document";
        db.deletedb(Query);

        Query = "Delete from document";
        db.deletedb(Query);

        Query = "Delete from image";
        db.deletedb(Query);


        // The code to add some urls and their hosts
        ArrayList<String> links= new ArrayList<>();
        links.add("https://www.geeksforgeeks.org/java/");

        HashMap<String,Integer> hosts = new HashMap<String , Integer>();
        hosts.put("geeksforgeeks.org",1);
        /////////////////////////////////////////////////////////////


        for(String s :links){
            Query = "insert into crawler_urls(url) values('"+ s +"')";

            db.insertdb(Query);
        }
        for(String s :hosts.keySet()){
            Query = "insert into hosts_popularity(host_name,host_ref_times) values('"+ s +"', '" + hosts.get(s) +"')";
            db.insertdb(Query);
        }
    }

    public static void main(String[] args) throws SQLException{
        InsertInDataBase I = new InsertInDataBase();
    }
}
