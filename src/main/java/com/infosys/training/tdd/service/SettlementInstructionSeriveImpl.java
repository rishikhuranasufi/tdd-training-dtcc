package com.infosys.training.tdd.service;

import com.infosys.training.tdd.service.stub.SettlementInstructionService;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SettlementInstructionSeriveImpl implements SettlementInstructionService {
    @Override
    public List<String> validateInstructionUsingAPI(SettlementInstruction settlementInstruction) {
    /*    List<String> response = new ArrayList<String>();
        response.add("rishi_false");*/
        return null;
    }
}
