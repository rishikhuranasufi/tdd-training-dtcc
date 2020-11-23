package com.infosys.training.tdd.service;

import com.infosys.training.tdd.service.stub.SettlementInstructionService;
import com.infosys.training.tdd.vo.SettlementInstruction;

import java.util.ArrayList;
import java.util.List;

public class SettlementInstructionServiceStubV2 implements SettlementInstructionService {
    @Override
    public List<String> validateInstructionUsingAPI(SettlementInstruction settlementInstruction) {
        List<String> response = new ArrayList<String>();
        if(settlementInstruction.getFutureEffectiveSICOntroller().equals("rishi")){
            response.add("rishi_true");
            return response;
        }
        if(settlementInstruction.getFutureEffectiveSICOntroller().equals("demo")){
            return null;
        }
        return null;
    }
}
