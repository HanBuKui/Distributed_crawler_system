package org.example;

import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;

public class HBaseDDL {
    //声明一个静态属性
    public static Connection connection = HBaseConnection.connection;

    /**
     * 创建命名空间
     * @param namespace 命名空间名称
     */
    public static void createNamespace(String namespace) throws IOException {
        //1. 获取admin
        // admin的连接是轻量级的，不是线程安全的 不推荐池化或者缓存这个连接
        // 要用时获取，不用时关闭
        Admin admin = connection.getAdmin();
        System.out.println(admin);

        //2. 调用方法创建命名空间
        //代码相对shell更加底层 所以shell能实现的代码一定能实现
        //需要填写完整的命名空间描述

        //2.1 创建命名空间描述的建造者
        NamespaceDescriptor.Builder builder = NamespaceDescriptor.create(namespace);

        //2.2 给命名空间添加需求
        builder.addConfiguration("user","crawlSystem");

        //2.3 使用builder构造出对应的添加完参数对象 完成创建
        admin.createNamespace(builder.build());

        //3. 关闭admin
        admin.close();

    }

    public static void main(String[] args) throws IOException {
        //判断连接是否成功
        System.out.println(HBaseConnection.connection);


        System.out.println("测试创建命名空间：");
        //测试创建命名空间
        createNamespace("crawlSystem");

        //其他代码
        System.out.println("其他代码");

        //关闭HBase的连接
        HBaseConnection.closeConnection();

    }
}
