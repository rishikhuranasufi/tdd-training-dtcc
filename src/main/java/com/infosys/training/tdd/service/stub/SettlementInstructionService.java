package com.infosys.training.tdd.service.stub;

import com.infosys.training.tdd.vo.SettlementInstruction;

import java.util.HashMap;
import java.util.List;

public interface SettlementInstructionService {

    //String return for True value is  value_true
    //String return for false value is value_false
    public List<String> validateInstructionUsingAPI(SettlementInstruction settlementInstruction);
}
