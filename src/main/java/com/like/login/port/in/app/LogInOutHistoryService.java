package com.like.login.port.in.app;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.like.login.adapter.out.db.jpa.LogInOutHistoryRepository;
import com.like.login.domain.LogInOutHistory;
import com.like.login.domain.LoginSuccessEvent;
import com.like.login.domain.LogInOutHistory.LOG_TYPE;

@Transactional
@Service
public class LogInOutHistoryService {

	private LogInOutHistoryRepository repository;
	
	public LogInOutHistoryService(LogInOutHistoryRepository repository) {
		this.repository = repository;
	}
	
	public void saveLogInOutHistory(LogInOutHistory entity) {
		repository.save(entity);
	}
	
	@Async
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void loginSuccessRegist(LoginSuccessEvent event) {
		LogInOutHistory entity = new LogInOutHistory(event.userId(),LOG_TYPE.LOGIN, event.clientIp(), true);
		this.repository.save(entity);
	}
}
