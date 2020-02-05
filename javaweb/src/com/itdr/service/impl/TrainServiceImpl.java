package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.TrainDao;
import com.itdr.pojo.Train;
import com.itdr.service.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {
    private TrainDao traindao=new TrainDao();
    @Override
    public ResponseCode getAllTrain() {
        List<Train> allTrain=traindao.getAllTrain();
        return ResponseCode.toSuccess(allTrain);
    }

    @Override
    public ResponseCode fuzzySearch(String key) {
        //非空判断
        if(com.mysql.jdbc.StringUtils.isNullOrEmpty(key)){
            return ResponseCode.toDefeated("参数非法！");
        }
        List<Train> allTrain=traindao.fuzzySearch(key);
        return ResponseCode.toSuccess(allTrain);
    }

    @Override
    public ResponseCode toDelete(String id) {
        //非空判断
        if(id==null||"".equals(id)){
            return ResponseCode.toDefeated("参数非法");
        }
        int i=Integer.parseInt(id);
        //查看车次是否存在
        Train t=TrainDao.selectById(i);
        if(t==null){
            return ResponseCode.toDefeated("商品不存在");
        }
        int i2=TrainDao.deleteById(id);
        if(i2!=1){
            return ResponseCode.toDefeated("删除失败");
        }
        return ResponseCode.toSuccess(i2);
    }

    @Override
    public ResponseCode addTrains(String train_number, String train_type, String start_station, String last_station, String start_time, String last_time, String seat_type, String price, String inventory) {
        //查看车次是否处在
        Train t=TrainDao.select(train_number,train_type,seat_type);
        if(t==null){
            return ResponseCode.toDefeated("商品不存在");
        }
        int i=TrainDao.addTrains(train_number,train_type,start_station,last_station,start_time,last_time,seat_type,price,inventory);
        return null;
    }
}
