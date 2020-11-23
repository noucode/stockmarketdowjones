DROP TABLE dow_jones_index_data IF EXISTS;

CREATE TABLE dow_jones_index_data  (
    quarter VARCHAR(1) ,
    stock VARCHAR(5),
    date VARCHAR(10),
    open VARCHAR(10),
    high VARCHAR(10),
    low VARCHAR(10),    
    close VARCHAR(10),
    volume VARCHAR(15),   
    percent_change_price VARCHAR(10),
    percent_change_volume_over_last_wk VARCHAR(15),
    percent_change_next_weeks_price VARCHAR(10),
    days_to_next_dividend VARCHAR(3),
    percent_return_next_dividend VARCHAR(10),
    PRIMARY KEY(quarter, stock, date)
);


