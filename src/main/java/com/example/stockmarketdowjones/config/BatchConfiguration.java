package com.example.stockmarketdowjones.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.example.stockmarketdowjones.helper.JobCompletionNotificationListener;
import com.example.stockmarketdowjones.model.DowJonesData;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<DowJonesData> reader() {
	  return new FlatFileItemReaderBuilder<DowJonesData>()
	    .name("dowjonesdataItemReader")
	    .resource(new ClassPathResource("dow_jones_index,csv"))
	    .delimited()
	    .names(new String[]{"quarter", "stock", "date", "open", "high", "low", "close", "volume", "percent_change_price", "percent_change_volume_over_last_wk", "previous_weeks_volume", "next_weeks_open", "next_weeks_close", "percent_change_next_weeks_price", "days_to_next_dividend", "percent_return_next_dividend"})
	    .fieldSetMapper(new BeanWrapperFieldSetMapper<DowJonesData>() {{
	      setTargetType(DowJonesData.class);
	    }})
	    .build();
	}

	
	@Bean
	public JdbcBatchItemWriter<DowJonesData> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<DowJonesData>()
	    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	    .sql("INSERT INTO dow_jones_index_data (quarter, stock, date, open, high, low, close, volume, percent_change_price, percent_change_volume_over_last_wk, previous_weeks_volume, next_weeks_open, next_weeks_close, percent_change_next_weeks_price, days_to_next_dividend, percent_return_next_dividend) VALUES (:quarter, :stock, :date, :open, :high, :low, :close, :volume, :percent_change_price, :percent_change_volume_over_last_wk, :previous_weeks_volume, :next_weeks_open, :next_weeks_close, :percent_change_next_weeks_price, :days_to_next_dividend, :percent_return_next_dividend)")
	    .dataSource(dataSource)
	    .build();
	}
	
	
	@Bean
	public Job importDowJonesDataJob(JobCompletionNotificationListener listener, Step step1) {
	  return jobBuilderFactory.get("importDowJonesDataJob")
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<DowJonesData> writer) {
	  return stepBuilderFactory.get("step1")
	    .<DowJonesData, DowJonesData> chunk(10)
	    .reader(reader())
	    .writer(writer)
	    .build();
	}	
}
