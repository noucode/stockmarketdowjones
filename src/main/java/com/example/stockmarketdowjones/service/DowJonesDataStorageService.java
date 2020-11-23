package com.example.stockmarketdowjones.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.stockmarketdowjones.exception.StorageException;
import com.example.stockmarketdowjones.model.DowJonesData;
import com.example.stockmarketdowjones.property.StorageProperties;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


@Service
public class DowJonesDataStorageService implements StorageService  {

    private final Path rootLocation;

    @Autowired
    public DowJonesDataStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage location", e);
        }
    }

    
    @Override
    public String storeFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);                
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }

        return filename;
    }
    
    

    @Override
    public List<DowJonesData> storetoDB(MultipartFile file) {

        // parse CSV file to create a list of `User` objects
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) 
        {

            // create csv bean reader
            CsvToBean<DowJonesData> csvToBean = new CsvToBeanBuilder<DowJonesData>(reader)
                    .withType(DowJonesData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert CsvToBean object to list of DowJonesData objects
            List<DowJonesData> dowonesdatas = csvToBean.parse();
            return dowonesdatas ;

        } 
        catch (IOException e) {
            throw new StorageException("Failed to store file " + "filename", e);
        }
    	
    }    

}





