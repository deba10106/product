package backend.service;

import backend.dto.TransactionDTO;
import backend.model.Transaction;
import backend.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	public void create(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionDTO, transaction);
		transactionRepository.save(transaction);
	}
}
