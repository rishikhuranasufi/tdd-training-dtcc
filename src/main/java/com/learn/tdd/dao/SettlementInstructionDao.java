package com.learn.tdd.dao;

import com.learn.tdd.vo.SettlementInstruction;

public interface SettlementInstructionDao {

    public int insert(SettlementInstruction settlementInstruction) throws Exception;
    public int delete(SettlementInstruction settlementInstruction) throws Exception;
}
