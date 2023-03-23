package com.act.moneytransferapi.repositories;

import com.act.moneytransferapi.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {}
