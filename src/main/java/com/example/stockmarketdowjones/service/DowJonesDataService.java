package com.example.stockmarketdowjones.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.example.stockmarketdowjones.model.DowJonesData;

public interface DowJonesDataService {
    public String store(MultipartFile file) ;
    public List<DowJonesData> findAll() ;
    public List<DowJonesData> findByStock(String stock) ;

}
