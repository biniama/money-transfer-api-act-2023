package com.act.moneytransferapi.repositories;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.domains.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, String> {}
