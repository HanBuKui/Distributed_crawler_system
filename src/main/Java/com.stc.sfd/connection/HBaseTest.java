package com.stc.sfd.connection;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;


public class HBaseTest {
    public static Configuration conf;

    public static Connection connection;

    public static void getconnect() throws IOException {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","node2");
        conf.set("hbase.zookeeper.property.clientPort","2181");

        try {
            connection = ConnectionFactory.createConnection(conf);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void createTable(String tableName, String... cf1) throws IOException {
        Admin admin = connection.getAdmin();

        TableName tbName = TableName.valueOf(tableName);

        if (admin.tableExists(tbName)) {
            System.out.println("table is exist");
        }

        HTableDescriptor HTD = new HTableDescriptor(tbName);

        for (String cf : cf1) {
            HColumnDescriptor HCD = new HColumnDescriptor(cf);
            HTD.addFamily(HCD);

        }

        admin.createTable(HTD);

        System.out.println("success");
    }


    public static void main(String[] args) throws IOException {
        createTable("test", "id", "name");

    }


}
