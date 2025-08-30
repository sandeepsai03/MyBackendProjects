package com.excelr.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.PassengerInfo;
import com.excelr.entity.Ticketinfo;

@RestController
public class TicketRestController {

	@PostMapping("/data")
	public ResponseEntity<Ticketinfo> bookTicket(@RequestBody PassengerInfo request){
		
		Ticketinfo tinfo=new Ticketinfo();
		tinfo.setPnr(request.getTrainNum());
		
		Random random=new Random();
		int ticketId=1000+random.nextInt(9000);
		
		tinfo.setTicketId(ticketId);
		tinfo.setName(request.getName());
		tinfo.setTicketStatus("success");
	return new ResponseEntity<>(tinfo,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> UpdateTicket(@RequestBody PassengerInfo request){
		
		return new ResponseEntity<>("ticket is updated",HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable Integer ticketId){
		
		return new ResponseEntity<>("ticket is deleted",HttpStatus.OK);
	}	
	
	@GetMapping("/get/{ticketId}")
	public ResponseEntity<Ticketinfo> getTicket(@PathVariable Integer ticketId){
		
		Ticketinfo t1=new Ticketinfo();
		t1.setTicketId(ticketId);
		t1.setPnr(123456);//sample PNR,replace with actual data retrival logic
		t1.setName("saisandeep");//sample name,replace with actual data
		t1.setTicketStatus("Booked");//sample status,replace with actual status
		return new ResponseEntity<>(t1,HttpStatus.OK);
	}	
}
