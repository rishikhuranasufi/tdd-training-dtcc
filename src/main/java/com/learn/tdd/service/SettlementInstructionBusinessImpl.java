package com.learn.tdd.service;

import com.learn.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(value = "settlementInstructionBusinessImpl")
public class SettlementInstructionBusinessImpl {

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionBusinessImpl.class);

    public Boolean validate(SettlementInstruction settlementInstruction) {

        if (StringUtils.isEmpty(settlementInstruction.getSettlementDate()) ||
                StringUtils.isEmpty(settlementInstruction.getSettlementModelName()) ||
                StringUtils.isEmpty(settlementInstruction.getFutureEffectiveSICOntroller())){
            return Boolean.FALSE;
        }else{
            if (checkFutureEffectiveSIController(settlementInstruction)) return Boolean.FALSE;
            logger.info(settlementInstruction.getFutureEffectiveSICOntroller() + "' doesn't contains special character");

            if (checkSettlementModelName(settlementInstruction)) return Boolean.FALSE;
            logger.info(settlementInstruction.getSettlementModelName() + "' doesn't contains special character");
            return Boolean.TRUE;
        }
    }

    private boolean checkSettlementModelName(SettlementInstruction settlementInstruction) {
        Pattern settlementModelNamePattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher settlementModelNameMatcher = settlementModelNamePattern.matcher(settlementInstruction.getSettlementModelName());
        if (!settlementModelNameMatcher.matches()) {
            logger.error(settlementInstruction.getSettlementModelName() + "' contains special character");
            return true;
        }
        return false;
    }

    private boolean checkFutureEffectiveSIController(SettlementInstruction settlementInstruction) {
        Pattern futureEffectivePattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = futureEffectivePattern.matcher(settlementInstruction.getFutureEffectiveSICOntroller());
        if (!matcher.matches()) {
            logger.error("string '"+settlementInstruction.getFutureEffectiveSICOntroller() + "' contains special character");
            return true;
        }
        return false;
    }
}