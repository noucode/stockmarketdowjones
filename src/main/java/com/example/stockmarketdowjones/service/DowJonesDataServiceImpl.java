package com.example.stockmarketdowjones.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.example.stockmarketdowjones.model.DowJonesData;
import com.example.stockmarketdowjones.repository.DowJonesDataRepository;


@Service
public class DowJonesDataServiceImpl  implements DowJonesDataService{
    
    @Autowired
    private DowJonesDataRepository repository;

    @Autowired
    private StorageService storageService;

    @Transactional
    public String store(MultipartFile file) {
	    String name = storageService.storeFile(file);
	    List<DowJonesData> dowjonesdatas = storageService.storetoDB(file) ;
	    
		//dowjonesdatas.stream().forEach(item -> repository.save(item));
		repository.saveAll(dowjonesdatas);
	      
	    return name ;	
    }
        
    @Override
    public List<DowJonesData> findAll() {

        return  (List<DowJonesData>) repository.findAll();
    }

    @Override
    public List<DowJonesData> findByStock(String stock) {

        return repository.findByStock(stock);
    }
    
}

