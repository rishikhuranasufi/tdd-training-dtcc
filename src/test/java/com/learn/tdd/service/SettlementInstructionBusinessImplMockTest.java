package com.learn.tdd.service;

import com.learn.tdd.vo.SettlementInstruction;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SettlementInstructionBusinessImplMockTest {

    /**
     * 1. Response of an API contains empty  element.
     * 2. Response of an API contains null element.
     * 3. Response of an API itself is null.
     *
     * **/

    @Test
    public void validateWhenResponseAPIContainsAnEmptyElement(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);
        String futureEffectiveSIController = "emptyValue";
        String modelName = "modelName";
        String date = "date";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);
        List<String> response = new ArrayList<>();
        response.add("");
        Mockito.when(settlementInstructionService.validateUsingAPI(settlementInstruction)).
                thenReturn(response);
        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionService);

        Boolean isVerified = settlementInstructionBusiness.validate(settlementInstruction);

        assertEquals(Boolean.FALSE,isVerified);

    }


    @Test
    public void validateWhenResponseAPIContainsAnNullElement(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionService);
        String futureEffectiveSIController = "nullValue";
        String modelName = "modelName";
        String date = "date";
        List<String> response = new ArrayList<>();
        response.add(null);
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);
        Mockito.when(settlementInstructionService.validateUsingAPI(settlementInstruction)).
                thenReturn(response);
        Boolean isVerified = settlementInstructionBusiness.validate(settlementInstruction);

        assertEquals(Boolean.FALSE,isVerified);

    }

    @Test(expected = NullPointerException.class)
    public void validateWhenResponseAPIisNull(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionService);
        String futureEffectiveSIController = "null";
        String modelName = "modelName";
        String date = "date";

        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);
        Mockito.when(settlementInstructionService.validateUsingAPI(settlementInstruction)).
                thenReturn(null);
        Boolean isVerified = settlementInstructionBusiness.validate(settlementInstruction);
        assertEquals(Boolean.FALSE,isVerified);
    }

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsValid(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);
        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService);
        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        List<String> response = new ArrayList<>();
        response.add("abcTest_true");
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);
        Mockito.when(settlementInstructionService.validateUsingAPI(settlementInstruction)).
                thenReturn(response);
        Boolean isVerified = settlementInstructionBusinessImpl.validate(settlementInstruction);
        assertEquals(Boolean.TRUE, isVerified);
    }

}