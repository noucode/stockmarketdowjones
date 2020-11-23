package com.example.stockmarketdowjones.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.stockmarketdowjones.model.DowJonesData;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DowJonesDataRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DowJonesDataRepository repository;
    
    @Test
    public void saveCar() {
    	DowJonesData dowJonesData = new DowJonesData("6", "ABCD", "2/4/2011", "$16.18", "$17.39", "$16.18", "$17.14", "154387761", "5.93325", "1.987451735", "151379173", "$17.33", "$17.37", "0.230814", "97", "0.175029");
	entityManager.persistAndFlush(dowJonesData);
	assertThat(dowJonesData.getStock()).isNotNull();
    }

    @Test
    public void findAll() {
    	DowJonesData dowJonesData = new DowJonesData("6", "ABCD", "2/4/2011", "$16.18", "$17.39", "$16.18", "$17.14", "154387761", "5.93325", "1.987451735", "151379173", "$17.33", "$17.37", "0.230814", "97", "0.175029");
        List<DowJonesData> dowJonesDatas = repository.findAll();
		entityManager.persistAndFlush(dowJonesData);
		assertThat(dowJonesDatas.size()).isNotNull(); 
    }

    @Test
    public void deleteCars() {
        entityManager.persistAndFlush(new DowJonesData("7", "ABC", "4/4/2011", "$16.18", "$17.39", "$16.18", "$17.14", "154387761", "5.93325", "1.987451735", "151379173", "$17.33", "$17.37", "0.230814", "97", "0.175029"));
        entityManager.persistAndFlush(new DowJonesData("8", "ACD", "8/8/2011", "$16.18", "$17.39", "$16.18", "$17.14", "154387761", "5.93325", "1.987451735", "151379173", "$17.33", "$17.37", "0.230814", "97", "0.175029"));
        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
