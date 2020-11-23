package com.infosys.training.tdd.service;

import com.infosys.training.tdd.helper.Common;
import com.infosys.training.tdd.service.stub.SettlementInstructionService;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class SettlementInstructionServiceStub implements SettlementInstructionService {
    @Override
    public List<String> validateInstructionUsingAPI(SettlementInstruction settlementInstruction) {
        List<String> response = new ArrayList<String>();
        if(settlementInstruction.getFutureEffectiveSICOntroller().contains("rishi")){
            response.add("");
            return response;
        }
        if(settlementInstruction.getFutureEffectiveSICOntroller().contains("demo")){
            response.add(null);
            return response;
        }

        if(settlementInstruction.getFutureEffectiveSICOntroller().contains("null")){

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
