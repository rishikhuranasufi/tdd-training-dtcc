package com.infy.tdd.training.db.core;

import com.infy.tdd.training.db.model.Addition;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.*;
import java.util.List;

public class SQLiteJDBC {
    final static Logger logger = Logger.getLogger(SQLiteJDBC.class);
    private static Connection connection = null;
    private static SQLiteDataSource ds = null;

    static{
        try {
            //Class.forName("org.sqlite.JDBC");
            ds = new SQLiteDataSource();
            //ds.setUrl("jdbc:sqlite:test.db");
            ds.setUrl("jdbc:sqlite");
            //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection = ds.getConnection();

            if (checkTableExists()) {
                logger.info("Table Exists !!!");
            } else {
                createTableOnConnection();
            }
        } catch ( Exception e ) {
            logger.error( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
        logger.info("Opened database successfully");
    }

    private static boolean checkTableExists() {
        try{
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeQuery( "SELECT * FROM ADDITION;" );
            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    private static void createTableOnConnection() throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        String sqlCreateTable = "CREATE TABLE ADDITION " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                " F_NUM           INT    NOT NULL, " +
                " S_NUM            INT     NOT NULL, " +
                " OUTPUT        INT, " +
                " USER         CHAR(50))";
        stmt.executeUpdate(sqlCreateTable);
        //stmt.close();
        logger.info("Table with name ADDITION created Successfully !!");

        /*String sqlInsertDummyData = "INSERT INTO ADDITION (F_NUM,S_NUM,OUTPUT,USER) " +
                "VALUES (10, 21, 31, 'rishi.khurana' );";
        stmt.executeUpdate(sqlInsertDummyData);

        sqlInsertDummyData = "INSERT INTO ADDITION (F_NUM,S_NUM,OUTPUT,USER) " +
                "VALUES (21, 21, 42, 'rishi.khurana' );";
        stmt.executeUpdate(sqlInsertDummyData);*/

        logger.info("DummyData Inserted");

        List<Addition> p = getDBObject( Addition.class, "SELECT * FROM ADDITION");

        for (Addition addition: p) {
            logger.info( "ID = " + addition.getID());
            logger.info( "FirstNumber = " + addition.getF_NUM() );
            logger.info( "Second number = " + addition.getS_NUM() );
            logger.info( "Output = " + addition.getOUTPUT() );
            logger.info( "User Details = " + addition.getUSER());
            logger.info("USER DETAILS with Name "+addition.getUSER()+" Field COMPLETED ");
        }
        stmt.close();
    }

    /**
     * It requires two parameters
     * @param classType : Type of Object query will return like Addition.
     * @param sqlQuery : SQL Query to be executed.
     * @throws SQLException
     * **/
    public static <T, list> List<T> getDBObject(Class classType, String sqlQuery) throws SQLException {
        QueryRunner run = new QueryRunner(ds);
        List<?> list = null;
        ResultSetHandler<list> h = new BeanListHandler<>(classType);
        return (List<T>) run.query(sqlQuery, h);
    }


    /**
     * It requires two parameters
     * @param classType : Type of Object query will return like Addition.
     * @param sqlQuery : SQL Query to be executed.
     * @throws SQLException
     * **/
    public static <T, list> List<T> updateDBObject(Class classType, String sqlQuery, Object params) throws SQLException {
        QueryRunner run = new QueryRunner(ds);
        List<?> list = null;
        ResultSetHandler<list> h = new BeanListHandler<>(classType);
        return (List<T>) run.insert(sqlQuery, h, params);
    }

    private SQLiteJDBC(){
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
            File myObj = new File("test.db");
            if (myObj.delete()) {
                logger.info("DataBase file deleted: " + myObj.getName());
            } else {
                logger.error("Failed to delete DataBase file " + myObj.getName());
            }
            logger.info("Connection Closed !!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}

