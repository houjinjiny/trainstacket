package com.itdr.dao;

import com.itdr.pojo.Train;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TrainDao {

    //查看全部车次
    public List<Train> getAllTrain() {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM g_train";
        List<Train> query=null;
        try {
            query=qr.query(sql,new BeanListHandler<Train>(Train.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
//根据车号查询
    public List<Train> fuzzySearch(String key) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM g_train WHERE train_number=?";
        List<Train> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<Train>(Train.class),key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    //根据id查询
    public static Train selectById(int i) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM g_train WHERE id=?";
        Train t=null;
        try {
            t=qr.query(sql,new BeanHandler<>(Train.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    //根据id删除
    public static int deleteById(String id) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="DELETE FROM g_train WHERE id=?";
        int update =0;
        try {
            update = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;
    }
    //
    public static Train select(String train_number, String train_type, String seat_type) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM g_train WHERE train_number=? And train_type=? And seat_type=?";
        Train t =null;
        try {
            t = qr.query(sql, new BeanHandler<Train>(Train.class),train_number,train_type,seat_type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    //
    public static int addTrains(String train_number, String train_type, String start_station, String last_station, String start_time, String last_time, String seat_type, String price, String inventory) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="INSERT INTO g_train VALUES(?,?,?,?,?,?,?,?,？) ";
        int update =0;
        try {
            update = qr.update(sql,train_number,train_type,start_station,last_station,start_time,last_time,seat_type,price,inventory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
