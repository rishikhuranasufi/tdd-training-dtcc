package com.learn.tdd.service;

import com.learn.tdd.helper.Common;
import com.learn.tdd.vo.SettlementInstruction;

import java.util.ArrayList;
import java.util.List;

public class SettlementInstructionServiceStub implements SettlementInstructionService{
    @Override
    public List<String> validateUsingAPI(SettlementInstruction settlementInstruction) {
        List<String> response = new ArrayList<>();
        if(settlementInstruction.getFutureEffectiveSICOntroller().equals("emptyValue")){
            response.add("");
            return response;
        }
        if(settlementInstruction.getFutureEffectiveSICOntroller().equals("nullValue")){
            response.add(null);
            return response;
        }

        if(settlementInstruction.getFutureEffectiveSICOntroller().equals("null")){
            return null;
        }

        boolean isFutureEffectiveSIControllerTrue =
                settlementInstruction.getFutureEffectiveSICOntroller().matches(Common.FUTURE_EFFECTIVE_PATTERN);
        if (isFutureEffectiveSIControllerTrue)
            response.add(settlementInstruction.getFutureEffectiveSICOntroller()+"_true");
        else //Add this else later on after making it pass
            response.add(settlementInstruction.getFutureEffectiveSICOntroller()+"_false");

        return response;
    }
}
