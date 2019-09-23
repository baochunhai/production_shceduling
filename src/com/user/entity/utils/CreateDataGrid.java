package com.user.entity.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CreateDataGrid {
	private String packageOutPath = "com.user.entity";//指定实体生成所在包的路径
    private String authorName = "***";//作者名字
    private String tablename = "log";//表名
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private String[] comments;//注释
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
    private static final String URL ="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
    private static final String NAME = "wisdom";
    private static final String PASS = "tiger";
    private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	 
        HashMap<String, Object> computer_mall = (HashMap<String, Object>) getAllTableColumn();
 
        Set<String> tableNames = computer_mall.keySet();
        System.out.println("一共有表：" + tableNames.size() + "张");
        for (String tableName : tableNames) {
            System.out.println("===========================\r\n");
            System.out.println("表名：" + tableName);
 
            // <字段名,类型>  HashMap 集合
            HashMap<String, String> columnNames = (HashMap<String, String>) computer_mall.get(tableName);
 
            Set<String> columns = columnNames.keySet();
 
            for (String column : columns) {
                System.out.println("字段名：" + column + " 类型：" + columnNames.get(column));
            }
 
            System.out.println("===========================\r\n");
        }
 
 
    }
 
    public static Map getAllTableColumn () throws SQLException, ClassNotFoundException {
 
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/test";
        String username = "root";
        String password = "root";
        Map<String, Object> tableNameMap = new HashMap();
 
 
        //加载驱动
        Class.forName(DRIVER);
 
        //获得数据库连接
        Connection connection = DriverManager.getConnection(URL, NAME, PASS);
        //获得元数据
        DatabaseMetaData metaData = connection.getMetaData();
        //获得表信息
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
 
        while (tables.next()) {
            Map<String, String> columnNameMap = new HashMap<>(); //保存字段名
 
            //获得表名
            String table_name = tables.getString("TABLE_NAME");
            //通过表名获得所有字段名
            ResultSet columns = metaData.getColumns(null, null, table_name, "%");
            //获得所有字段名
            while (columns.next()) {
                //获得字段名
                String column_name = columns.getString("COLUMN_NAME");
                //获得字段类型
                String type_name = columns.getString("TYPE_NAME");
//获得字段注释   注意： 对于此列，SQL Server 始终会返回 Null。
                String remarks = columns.getString("REMARKS");
//   https://docs.microsoft.com/zh-cn/sql/connect/jdbc/reference/getcolumns-method-sqlserverdatabasemetadata?view=sql-server-2017
//                System.out.println(table_name+":"+column_name+":"+remarks);
 
                columnNameMap.put(column_name, type_name);
            }
 
            tableNameMap.put(table_name, columnNameMap);
 
        }
 
        return tableNameMap;
    }
 
 
}
