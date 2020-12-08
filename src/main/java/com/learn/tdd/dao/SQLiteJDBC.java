package com.learn.tdd.dao;

import com.learn.tdd.vo.SettlementInstruction;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SQLiteJDBC {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SQLiteJDBC.class);
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
                logger.info("Table needs to be created  !!!");
                //createTableOnConnection();
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
            stmt.executeQuery( "SELECT * FROM SETTLEMENT_INSTRUCTION;" );
            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    private static void createTableOnConnection() throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        String sqlCreateTable = "CREATE TABLE SETTLEMENT_INSTRUCTION " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                " FE_SIC           CHAR(50)    NOT NULL, " +
                " S_MN            CHAR(50)     NOT NULL, " +
                " S_DATE        CHAR(50), )";
        stmt.executeUpdate(sqlCreateTable);
        //stmt.close();
        logger.info("Table with name SETTLEMENT_INSTRUCTION created Successfully !!");

        /*String sqlInsertDummyData = "INSERT INTO ADDITION (F_NUM,S_NUM,OUTPUT,USER) " +
                "VALUES (10, 21, 31, 'rishi.khurana' );";
        stmt.executeUpdate(sqlInsertDummyData);*/

        String sqlInsertDummyData = "INSERT INTO ADDITION (FE_SIC,S_MN,S_DATE) " +
                "VALUES ('testAbc', 'testABC123', '12/12/20' );";
        stmt.executeUpdate(sqlInsertDummyData);

        logger.info("DummyData Inserted");

        List<SettlementInstruction> p = getDBObject( SettlementInstruction.class, "SELECT * FROM SETTLEMENT_INSTRUCTION");

        for (SettlementInstruction settlementInstruction: p) {
            logger.info( "Future Effective SIController = " + settlementInstruction.getFutureEffectiveSICOntroller());
            logger.info( "Model Name = " + settlementInstruction.getSettlementModelName() );
            logger.info( "Settlement Date = " + settlementInstruction.getSettlementDate() );
        }
        stmt.close();
    }

    /*
     * It requires two parameters
     * @param classType : Type of Object query will return like Addition.
     * @param sqlQuery : SQL Query to be executed.
     * @throws SQLException
     * */
    public static <T, list> List<T> getDBObject(Class classType, String sqlQuery) throws SQLException {
        QueryRunner run = new QueryRunner(ds);
        List<?> list = null;
        ResultSetHandler<list> h = new BeanListHandler<>(classType);
        return (List<T>) run.query(sqlQuery, h);
    }


    /*
     * It requires two parameters
     * @param classType : Type of Object query will return like Addition.
     * @param sqlQuery : SQL Query to be executed.
     * @throws SQLException
     * */
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

