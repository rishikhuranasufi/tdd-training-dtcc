package com.infosys.training.tdd.service;

import com.infosys.training.tdd.helper.Common;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(value = "settlementInstructionBusinessImpl")
public class SettlementInstructionBusinessImpl {

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionBusinessImpl.class);

    public Boolean validate(SettlementInstruction settlementInstruction) {
        return null;
    }
}
