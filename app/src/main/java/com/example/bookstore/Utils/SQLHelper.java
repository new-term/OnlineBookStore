package com.example.bookstore.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class SQLHelper {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://pgm-wz9124t34v0s603rho.pg.rds.aliyuncs.com:1921/bookstoreinfo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "bookstore";
    private static final String PASSWORD = "Shou123456!";

    private static String parseWhereClause(String whereClause, String[] values){
        StringBuilder ret = new StringBuilder();
        String[] Args = whereClause.split("\\?");
        for(int i = 0; i < Args.length; i++){
            ret.append(Args[i]);
            ret.append("'").append(values[i]).append("'");
        }
        return ret.toString();
    }

    /**
     * 获取MySQL的Statement用以执行sql语句
     * @return
     */
    public static Statement getStatement(){
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    /**
     * 执行查询查询，支持表连接查询
     * @param projection sql语句中需要投影的列
     * @param tableNames sql需要查询的表
     * @param whereClause sql中的选择语句，格式"attr1=?,attr2=?"
     * @param values sql中whereClause中所对应的值
     * @return 返回结果集
     * @throws SQLException
     */
    public static ResultSet query(String[] projection, String[] tableNames, String whereClause, String[] values) throws SQLException {
        StringBuilder sql = new StringBuilder("select ");
        for(String item : projection){
            sql.append(item);
            sql.append(",");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 1));

        sql.append(" from ");
        for(String tableName : tableNames){
            sql.append(tableName);
            sql.append(",");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 1));

        sql.append(" where ");
        sql.append(parseWhereClause(whereClause, values));

        Statement statement = getStatement();
        return statement.executeQuery(sql.toString());
    }

    /**
     * 执行插入操作
     * @param tableName 要插入数据的表名称
     * @param valueMap 要插入的数据的键值对，键位列名，值为列名对应的值
     * @return 是否成功插入
     * @throws SQLException
     */
    public static boolean insert(String tableName, Map<String, String> valueMap) throws SQLException {
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (Map.Entry<String, String> entry : valueMap.entrySet()) {
            columns.append(entry.getKey()).append(',');
            values.append("'").append(entry.getValue()).append("'").append(',');
        }
        columns = new StringBuilder(columns.substring(0, columns.length() - 1));
        values = new StringBuilder(values.substring(0, values.length() - 1));
        columns.append(')');
        values.append(')');

        String sql = "INSERT INTO " + tableName + columns + " VALUES " + values;
        Statement statement = getStatement();
        return statement.execute(sql);
    }

    /**
     * 执行删除操作
     * @param tableName 要删除数据的表名
     * @param whereClause sql中的选择语句，格式"attr1=?,attr2=?"
     * @param values sql中whereClause中所对应的值
     * @return 是否成功删除
     * @throws SQLException
     */
    public static boolean delete(String tableName, String whereClause, String[] values) throws SQLException {
        return getStatement().execute("delete from " + tableName + " where " + parseWhereClause(whereClause, values));
    }

    /**
     * 执行更新操作
     * @param tableName 要更新数据的表名
     * @param newValue 要更新的数据键值对，键为列名，值为对应列名的新值
     * @param whereClause sql中的选择语句，格式"attr1=?,attr2=?"
     * @param values sql中whereClause中所对应的值
     * @return 返回成功更新的行数
     * @throws SQLException
     */
    public static int update(String tableName, Map<String, String> newValue, String whereClause, String[] values) throws SQLException {
        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        StringBuilder updateData = new StringBuilder();
        for(Map.Entry<String, String> entry : newValue.entrySet()){
            updateData.append(entry.getKey()).append(" = ").append(entry.getValue()).append(",");
        }
        updateData = new StringBuilder(updateData.substring(0, updateData.length() - 1));
        sql.append(updateData + " " + parseWhereClause(whereClause, values));
        return getStatement().executeUpdate(sql.toString());
    }

}
