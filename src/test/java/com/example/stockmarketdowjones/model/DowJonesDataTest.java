package com.example.stockmarketdowjones.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.Year;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class DowJonesDataTest {

	private static Validator validator;
	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	void whenAllFieldsCorrectThenValidationSucceeds() {
		DowJonesData dowjonesdata = new DowJonesData("9","BABA","2/24/2011","$79.52","$80.30","$68.35","$70.07","18834664","0.93633","-48.05394212","36258120","$70.86","$71.68", "1.15721", "26", "0.599401");
		Set<ConstraintViolation<DowJonesData>> violations = validator.validate(dowjonesdata);
		assertThat(violations).isEmpty();
	}
	
}

