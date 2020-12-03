package com.infosys.training.tdd.dao;

import com.infosys.training.tdd.vo.SettlementInstruction;

public interface SettlementInstructionDao {

    public int insert(SettlementInstruction settlementInstruction) throws Exception;
    public int delete(SettlementInstruction settlementInstruction) throws Exception;
}
