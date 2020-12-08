package com.learn.tdd.service;

import com.learn.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "settlementInstructionBusinessImpl")
public class SettlementInstructionBusinessImpl {

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionBusinessImpl.class);

    public Boolean validate(SettlementInstruction settlementInstruction) {
        return null;
    }
}
