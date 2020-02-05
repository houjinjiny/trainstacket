package com.itdr.service;

import com.itdr.common.ResponseCode;

public interface TrainService {
    ResponseCode getAllTrain();

    ResponseCode fuzzySearch(String key);

    ResponseCode toDelete(String id);

    ResponseCode addTrains(String train_number, String train_type, String start_station, String last_station, String start_time, String last_time, String seat_type, String price, String inventory);
}
