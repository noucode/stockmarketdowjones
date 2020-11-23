package com.example.stockmarketdowjones.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.stockmarketdowjones.model.ComposedId;
import com.example.stockmarketdowjones.model.DowJonesData;


@Repository
public interface DowJonesDataRepository extends JpaRepository<DowJonesData, ComposedId>  {
	
	List<DowJonesData> findByStock(String stock);

}
