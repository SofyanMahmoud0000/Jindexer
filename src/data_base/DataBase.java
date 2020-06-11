package data_base;

import java.sql.*;

public class DataBase {
    static Connection connection=null;


    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATA_BASE_NAME ="";
    static final String DB_URL = "jdbc:mysql://localhost:3306/"+DATA_BASE_NAME+"?createDatabaseIfNotExist=true";


    //  Database credentials
    static final String USER = "";
    static final String PASS = "";


    public static final String Document     ="document";
    public static final String WordDocument ="word_document";
    public static final String Image        ="image";
    public static final String Index        ="word_index";
    public static final String CrawlerURLS  ="crawler_urls";
    public static final String Hosts        ="hosts_popularity";



    static final String documentTableCreate = "CREATE TABLE IF NOT EXISTS "+Document+
            "(id int auto_increment, " +
            "hyper_link VARCHAR(255) not NULL unique, " +
            "CountryCode VARCHAR(255), " +
            "data_modified  DATE ,"+
            "brief TEXT ,"+
            "popularity FLOAT ,"+
            "Title VARCHAR(255),"+
            "PRIMARY KEY (id));";

    static final String documentWordTableCreate = "CREATE TABLE IF NOT EXISTS  "+WordDocument+
            "(id int auto_increment," +
            "word_name VARCHAR(255) not NULL, " +
            "document_hyper_link_id  int not null, "+
            "tf float ,"+
            "FOREIGN KEY (document_hyper_link_id) REFERENCES document(id),"+
            "primary key (id),"+
            "unique(word_name,document_hyper_link_id));";



    static final String imageTableCreate = "CREATE TABLE IF NOT EXISTS "+Image+
            "(id int auto_increment, " +
            "image_url Text ,"+
            "caption Text,"+
            "stemmed Text,"+
            "PRIMARY KEY (id));";


    static final String indexTableCreate = "CREATE TABLE IF NOT EXISTS  "+Index+
            "(id int auto_increment, " +
            "word_name VARCHAR(255) not NULL, " +
            "document_id INT NOT NULL,"+
            "word_position INT NOT NULL,"+
            "FOREIGN KEY (word_name) REFERENCES word_document(word_name),"+
            "FOREIGN KEY (document_id) REFERENCES document(id),"+
            "unique(word_name,document_id,word_position),"+
            "PRIMARY KEY (id));";


    static final String crawlerTableCreate = "CREATE TABLE IF NOT EXISTS " + CrawlerURLS +"( "+
            "url_id bigint(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,"+
            "url varchar(2048) NOT NULL UNIQUE,"+
            "done tinyint default 0"+
            ");";


    static final String hosstsTableCreate = "CREATE TABLE IF NOT EXISTS "+ Hosts + "( " +
            "host_id bigint(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,"+
            "host_name varchar(300) COLLATE utf16_unicode_ci NOT NULL UNIQUE,"+
            "host_ref_times int(11) NOT NULL DEFAULT 0"+
            ");";


    public void createTables() throws SQLException {
        Statement stmt= connection.createStatement();
        stmt.executeUpdate(documentTableCreate);
        stmt.executeUpdate(documentWordTableCreate);
        stmt.executeUpdate(imageTableCreate);
        stmt.executeUpdate(indexTableCreate);
        stmt.executeUpdate(crawlerTableCreate);
        stmt.executeUpdate(hosstsTableCreate);
        stmt.close();
    }

    public void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
        connection=con;
    }
    public ResultSet selectQuerydb(String sqlStatement) throws SQLException {
        Statement stmt= connection.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStatement);
        return rs;
    }
    public int insertdb(String sqlStatement) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        return generatedKey;

    }
    public int deletedb(String sqlStatement) throws SQLException {
        Statement stmt= connection.createStatement();
        int rs = stmt.executeUpdate(sqlStatement);
        return rs;
    }
    public int updatedb(String sqlStatement) throws SQLException {
        Statement stmt= connection.createStatement();
        int rs = stmt.executeUpdate(sqlStatement);
        return rs;
    }

    public void CreateDataBase(){
        DataBase db = new DataBase();
        try {
            db.createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            db.createTables();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args){
        DataBase db = new DataBase();
        db.CreateDataBase();
    }
}