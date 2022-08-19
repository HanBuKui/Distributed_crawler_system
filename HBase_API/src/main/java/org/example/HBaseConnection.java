package org.example;

import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;


import java.io.IOException;


public class HBaseConnection {
    //多线程连接 类似单例模式（符合官方推荐使用
    //声明一个静态属性
    public static Connection connection;

    static{
        //1. 创建连接  默认使用同步连接
        try {
            //使用读取本地文件的方式添加参数
            connection = ConnectionFactory.createConnection();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void closeConnection() throws IOException {
        //判断连接是否为NULL
        if(connection != null){
            connection.close();
        }

    }

    public static void main(String[] args) throws IOException {



        //直接使用创建好的连接，不在main线程里面单独创建
        System.out.println(HBaseConnection.connection);

        //main 现场最后关闭连接
        HBaseConnection.closeConnection();

    }

}
