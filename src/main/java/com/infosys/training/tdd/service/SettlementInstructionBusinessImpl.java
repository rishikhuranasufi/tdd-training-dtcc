package com.infosys.training.tdd.service;

import com.infosys.training.tdd.helper.Common;
import com.infosys.training.tdd.service.stub.SettlementInstructionService;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(value = "settlementInstructionBusinessImpl")
public class SettlementInstructionBusinessImpl {

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionBusinessImpl.class);

    @Autowired
    private final SettlementInstructionService settlementInstructionService;

    public SettlementInstructionBusinessImpl(SettlementInstructionService settlementInstructionService){
        this.settlementInstructionService = settlementInstructionService;
    }


    /*public boolean verifyDataFromUI(SettlementInstruction settlementInstruction) {
        if (StringUtils.isEmpty(settlementInstruction.getFutureEffectiveSICOntroller()) ||
              StringUtils.isEmpty(settlementInstruction.getSettlementModelName())

        ){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }*/

/*    public Boolean validateData(SettlementInstruction settlementInstruction) {
        return validate(settlementInstruction);
    }*/

/*    private Boolean validate(SettlementInstruction settlementInstruction) {

        if (settlementInstruction.getSettlementDate().trim().equals("") ||
                settlementInstruction.getSettlementModelName().trim().equals("") ||
                settlementInstruction.getFutureEffectiveSICOntroller().trim().equals("")){
            return Boolean.FALSE;
        }else{
            Pattern futureEffectivePattern = Pattern.compile("[a-zA-Z0-9]*");
            Matcher matcher = futureEffectivePattern.matcher(settlementInstruction.getFutureEffectiveSICOntroller());
            if (!matcher.matches()) {
                logger.error("string '"+settlementInstruction.getFutureEffectiveSICOntroller() + "' contains special character");
                return Boolean.FALSE;
            }
            logger.info(settlementInstruction.getFutureEffectiveSICOntroller() + "' doesn't contains special character");

            Pattern settlementModelNamePattern = Pattern.compile("[a-zA-Z0-9]*");
            Matcher settlementModelNameMatcher = settlementModelNamePattern.matcher(settlementInstruction.getSettlementModelName());
            if (!settlementModelNameMatcher.matches()) {
                logger.error(settlementInstruction.getSettlementModelName() + "' contains special character");
                return Boolean.FALSE;
            }
            logger.info(settlementInstruction.getSettlementModelName() + "' doesn't contains special character");
            try{// ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
                LocalDate.parse(settlementInstruction.getSettlementDate(),
                DateTimeFormatter.ofPattern("uuuu-M-d")
                           .withResolverStyle(ResolverStyle.STRICT));
                logger.info(settlementInstruction.getSettlementDate()+" is valid date format");
                }
                catch (DateTimeParseException e){
                    *//* Date format is invalid *//*
                    logger.error(settlementInstruction.getSettlementDate()+" is Invalid Date format");
                    return Boolean.FALSE;
            }
            return Boolean.TRUE;
            // Next Steps :
            // Find Defect in code
            // Test Case using TDD
        }
    }*/

    /*
    public Boolean verifyUIInputedData(SettlementInstruction settlementInstruction) {
        if(StringUtils.isEmpty(settlementInstruction.getFutureEffectiveSICOntroller()) ||
            StringUtils.isEmpty(settlementInstruction.getSettlementModelName()) ||
            StringUtils.isEmpty(settlementInstruction.getSettlementDate()))
            return Boolean.FALSE;

        Pattern futureEffectiveControllerPattern = Pattern.compile(Common.FUTURE_EFFECTIVE_PATTERN);
        Matcher futureEffectiveMatcher = futureEffectiveControllerPattern.matcher(settlementInstruction.getFutureEffectiveSICOntroller());

        if(!futureEffectiveMatcher.matches())
            return Boolean.FALSE;

        Pattern settlementModelNamePattern = Pattern.compile(Common.MODEL_NAME_PATTERN);
        Matcher settlmentModelNameMatcher = settlementModelNamePattern.matcher(settlementInstruction.getSettlementModelName());

        if(!settlmentModelNameMatcher.matches())
            return Boolean.FALSE;

        return Boolean.TRUE;
    }*/


    //STUB Example

   /* public Boolean  verifyUIInputedData(SettlementInstruction settlementInstruction) {
        List<String> responseFromSettlementServiceDetails =
                settlementInstructionService.validateInstructionUsingAPI(settlementInstruction);
        boolean returnedResponse = true;
        for(String response : responseFromSettlementServiceDetails ){
            if(StringUtils.isEmpty(response) || response.contains("false")) {
                returnedResponse = false;
                break;
            }
        }
        return returnedResponse;
    }*/

    /*
    * What is stub ?
    * How and where stub is required ?
    * Live example in traditional way .
    * Using TDD approach
    * Disadvantages of Stub
    *
    * Mockito :
    * Same example using Mockito
    * Different ways how use Mockito?
    * One basic and advance(List) implementation using Mockito.
    * Some limitation with Mockito like static methods and Constructors cannot be unit tested.
    * Using Power mock to over come it.
    *
    * */

    public Boolean verifyUIInputedData(SettlementInstruction settlementInstruction) {
        List<String> response = settlementInstructionService.validateInstructionUsingAPI(settlementInstruction);
        if (response == null){
            throw new NullPointerException();
        }
        for(String stringVal : response){
            if(stringVal.contains("_false"))
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        }




        return Boolean.TRUE;

        /*List<String> response =
                settlementInstructionService.validateInstructionUsingAPI(settlementInstruction);
        boolean returnedValue = true;
        if (response == null)
            throw new NullPointerException();

        for(String res : response){
            //4 test cases around this one
            // First one with ==
            // Second one with StringUtils
            // Third one with string.contains()
            // Fourth one with null
            if (StringUtils.isEmpty(res) || res.contains("_false")) {
                returnedValue = false;
                break;
            }
        }
        return returnedValue;*/
    }
}
