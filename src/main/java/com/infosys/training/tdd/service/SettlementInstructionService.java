package com.infosys.training.tdd.service;

import com.infosys.training.tdd.vo.SettlementInstruction;

import java.util.List;

public interface SettlementInstructionService {

    //Sample return value as value_true
    //Sample return value as value_false
    public List<String> validateUsingAPI(SettlementInstruction settlementInstruction);
}