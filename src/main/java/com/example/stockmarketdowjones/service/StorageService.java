package com.example.stockmarketdowjones.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.example.stockmarketdowjones.model.DowJonesData;


public interface StorageService {

    void init();
    String storeFile(MultipartFile file);
    List<DowJonesData> storetoDB(MultipartFile file) ;

}
