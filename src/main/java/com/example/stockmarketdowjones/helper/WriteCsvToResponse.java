package com.example.stockmarketdowjones.helper;

import java.io.PrintWriter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.stockmarketdowjones.model.DowJonesData;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;


public class WriteCsvToResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

    public static void writeDowJonesDatas(PrintWriter writer, List<DowJonesData> dowjonesdatas) {

        try {
            ColumnPositionMappingStrategy<DowJonesData> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(DowJonesData.class);

            String[] columns = new String[]{"quarter", "stock", "date", "open", "high", "low", "close", "volume", "percent_change_price", "percent_change_volume_over_last_wk", "previous_weeks_volume", "next_weeks_open", "next_weeks_close", "percent_change_next_weeks_price", "days_to_next_dividend", "percent_return_next_dividend"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<DowJonesData> btcsv = new StatefulBeanToCsvBuilder<DowJonesData>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(dowjonesdatas);

        } 
        catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeDowJonesData(PrintWriter writer, DowJonesData dowjonesdata) {

        try {
            ColumnPositionMappingStrategy<DowJonesData> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(DowJonesData.class);

            String[] columns = new String[]{"quarter", "stock", "date", "open", "high", "low", "close", "volume", "percent_change_price", "percent_change_volume_over_last_wk", "previous_weeks_volume", "next_weeks_open", "next_weeks_close", "percent_change_next_weeks_price", "days_to_next_dividend", "percent_return_next_dividend"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<DowJonesData> btcsv = new StatefulBeanToCsvBuilder<DowJonesData>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(dowjonesdata);

        } 
        catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

}
