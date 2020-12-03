package com.example.stockmarketdowjones.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.stockmarketdowjones.helper.FileResponse;
import com.example.stockmarketdowjones.helper.WriteCsvToResponse;
import com.example.stockmarketdowjones.model.DowJonesData;
import com.example.stockmarketdowjones.service.DowJonesDataService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
public class DowJonesDataController {

    @Autowired
    private DowJonesDataService dowjonesdataservice;

  
    @GetMapping(value = "/dowjonesdatas", produces = "text/csv")
    @ApiOperation(value = "List Dow Jones Data",notes = "List all Dow Jones Data")
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Dow Jones Data found"),
        @ApiResponse(code = 404,message = "Dow Jones Data not found"),
        @ApiResponse(code = 500, message = "Server error")
    })
    public void findDowJonesDatas(HttpServletResponse response) throws IOException {

    	List<DowJonesData> dowjonesdatas = (List<DowJonesData>) dowjonesdataservice.findAll();
    	WriteCsvToResponse.writeDowJonesDatas(response.getWriter(), dowjonesdatas);
    }
  

  	@GetMapping(value = "/dowjonesdatas/{stock}", produces = "text/csv")
    @ApiOperation(value = "Find Dow Jones Data",notes = "Find Dow Jones Data by Stock Ticker")
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Dow Jones Data found"),
        @ApiResponse(code = 404,message = "Dow Jones Data not found"),
        @ApiResponse(code = 500, message = "Server error")
    })
  	public void findDowJonesData(@PathVariable String stock, HttpServletResponse response) throws IOException {

  		List<DowJonesData> dowjonesdatas = dowjonesdataservice.findByStock(stock);
  		WriteCsvToResponse.writeDowJonesDatas(response.getWriter(), dowjonesdatas);
  	}
  

    @PostMapping("/upload-file")
    @ApiOperation(value = "Add new Dow Jones Data",notes = "It permits to upload and add Dow Jones Data in DB")
    @ApiResponses(value = {
        @ApiResponse(code = 201,message = "Dow Jones Data added successfully"),
        @ApiResponse(code = 400,message = "Invalid request"),
        @ApiResponse(code = 500, message = "Server error")
    })
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String name = dowjonesdataservice.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        return new FileResponse(name, uri, file.getContentType(), file.getSize());
    }

}
