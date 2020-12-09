package com.learn.tdd.dao;

import com.learn.tdd.vo.SettlementInstruction;

public interface SettlementInstructionDAO {

    Boolean findByUserName(String user) throws Exception;

    // 1 means success and other than 1 means failed to insert or delete.
    int insert(SettlementInstruction settlementInstruction) throws Exception;
    int delete(SettlementInstruction settlementInstruction) throws Exception;
}
