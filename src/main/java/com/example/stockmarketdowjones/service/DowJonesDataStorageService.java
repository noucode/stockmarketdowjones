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
import org.springframework.beans.factory.annotation.Value;
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
    
	@Value("${error.store.file}")
	private String fileError;
    
	@Value("${error.store.emptyfile}")
	private String emptyfileError;
    
	@Value("${error.storage.location}")
	private String storageLocationError;
    
	@Value("${error.store.relative.path}")
	private String relativePathError;
    
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
            throw new StorageException(storageLocationError, e);
        }
    }

	   
    @Override
    public String storeFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException(emptyfileError + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException(relativePathError + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);                
            }
        }
        catch (IOException e) {
            throw new StorageException(emptyfileError + filename, e);
        }

        return filename;
    }
    
    

    @Override
    public List<DowJonesData> storetoDB(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        /** parse CSV file to create a list of DowJonesData objects  */
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) 
        {

            /** create csv bean reader  */
            CsvToBean<DowJonesData> csvToBean = new CsvToBeanBuilder<DowJonesData>(reader)
                    .withType(DowJonesData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            /** convert CsvToBean object to list of DowJonesData objects  */
            List<DowJonesData> dowonesdatas = csvToBean.parse();
            return dowonesdatas ;

        } 
        catch (IOException e) {
            throw new StorageException(emptyfileError + filename, e);
        }
    	
    }    

}

