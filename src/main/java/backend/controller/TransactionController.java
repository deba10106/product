package backend.controller;

import backend.dto.TransactionDTO;
import backend.model.Transaction;
import backend.service.TransactionService;
import backend.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	private Date Today;
	private Object YearMonth;

	@GetMapping("/transactions")
	List<TransactionDTO> all() {
		TransactionDTO transactionDTO = new TransactionDTO();

		transactionDTO.setCreatedDate(Today);
		transactionDTO.setCreatedBy("transactionwmaker");
		transactionDTO.setLastUpdateBy("transactioncheker");
		transactionDTO.setLastUpdateDate(Today);


		List<TransactionDTO> list = new ArrayList<TransactionDTO>();
		list.add(transactionDTO);
		return list;
	}
	

	
}
