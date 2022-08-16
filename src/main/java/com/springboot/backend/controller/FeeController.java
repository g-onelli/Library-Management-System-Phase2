package com.springboot.backend.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.FeeDto;
import com.springboot.backend.dto.UserInfoDto;
import com.springboot.backend.model.Fee;
import com.springboot.backend.model.Patron;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.FeeRepository;
import com.springboot.backend.repository.PatronRepository;

@RestController
public class FeeController {
	
	@Autowired
	private FeeRepository feeRepository;
	@Autowired
	private PatronRepository patronRepository;
	
	//Insert a new fee with the attached patron ID
	@PostMapping("/fee/{pid}")
	public Fee postFee(@RequestBody Fee fee, @PathVariable("pid") Integer pid) {
		Optional<Patron> optional = patronRepository.findById(pid);
		if(!optional.isPresent()) {
			throw new RuntimeException("Patron ID is invalid");
		}
		Patron patron = optional.get();
		fee.setPatron(patron);
		return feeRepository.save(fee);
	}
	
	//Return all fees
	@GetMapping("/fee")
	public List<FeeDto> getAllFees() {
		List<Fee> list = feeRepository.findAll();
		List<FeeDto> listDto = new ArrayList<>();
		list.stream().forEach(p->{
			FeeDto dto = new FeeDto();
			dto.setId(p.getId());
			dto.setDatePaid(p.getDatePaid());
			dto.setFeeType(p.getFeeType());
			dto.setTotal(p.getTotal());
			dto.setPatronName(p.getPatron().getName());
			listDto.add(dto);
		});
		return listDto;
	}
	
	//Return fee based on ID
	@GetMapping("/fee/{id}")
	public Fee getFeeByPatronID(@PathVariable("id") Integer id) {
		Optional<Fee> optional = feeRepository.findById(id);
		if(!optional.isPresent()) {
			throw new RuntimeException("Fee Id is invalid");
		}
		return optional.get();
	}
	
	@GetMapping("/fee/patron")
	public List<FeeDto> login(Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			Patron info = patronRepository.getByUsername(username);
			List<Fee> list = feeRepository.findByFeeId(info.getId());
			List<FeeDto> listDto = new ArrayList<>();
			list.stream().forEach(p->{
				FeeDto dto = new FeeDto();
				dto.setId(p.getId());
				dto.setPatronName(p.getPatron().getName());
				dto.setDatePaid(p.getDatePaid());
				dto.setFeeType(p.getFeeType());
				dto.setTotal(p.getTotal());
				listDto.add(dto);
			});
			if(list.size() == 0) {
				FeeDto dto = new FeeDto();
				dto.setPatronBalance(info.getBalance());
				listDto.add(dto);
			}
			return listDto;
		}
		return null;
	}

	@PutMapping("/fee/{id}")
	public Fee updateFee(@PathVariable("id") Integer id, @RequestBody Fee newFee) {
		Optional<Fee> optional = feeRepository.findById(id);
		if(!optional.isPresent()) {
			throw new RuntimeException("Fee ID is invalid");
		}
		Fee existingFee = optional.get();
		existingFee.setTotal(newFee.getTotal());
		existingFee.setFeeType(newFee.getFeeType());
		existingFee.setDatePaid(LocalDate.now());
		return feeRepository.save(existingFee);
	}
	@GetMapping("/fee/all")
	public List<FeeDto> getFees() {
		List<Fee> list = feeRepository.findUnpaid();
		List<FeeDto> listDto = new ArrayList<>();
		list.stream().forEach(p->{
			FeeDto dto = new FeeDto();
			dto.setId(p.getId());
			dto.setFeeType(p.getFeeType());
			dto.setTotal(p.getTotal());
			dto.setDatePaid(p.getDatePaid());
			dto.setPatronName(p.getPatron().getName());
			listDto.add(dto);
		});
		return listDto;
	}
	
}
