package com.learn.tdd.service;

import com.learn.tdd.dao.SettlementInstructionDaoImpl;
import com.learn.tdd.exception.IssueWhileExecutingQuery;
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

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

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
                SettlementInstructionBusinessImpl(settlementInstructionService,settlementInstructionDao);

        Boolean isVerifed = settlementInstructionBusiness.validate(settlementInstruction);

        assertEquals(Boolean.FALSE,isVerifed);

    }


    @Test
    public void validateWhenResponseAPIContainsAnNullElement(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionService,settlementInstructionDao);
        String futureEffectiveSIController = "nullValue";
        String modelName = "modelName";
        String date = "date";
        List<String> response = new ArrayList<>();
        response.add(null);
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);
        Mockito.when(settlementInstructionService.validateUsingAPI(settlementInstruction)).
                thenReturn(response);
        Boolean isVerifed = settlementInstructionBusiness.validate(settlementInstruction);

        assertEquals(Boolean.FALSE,isVerifed);

    }

    @Test(expected = NullPointerException.class)
    public void validateWhenResponseAPIisNull(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionService,settlementInstructionDao);
        String futureEffectiveSIController = "null";
        String modelName = "modelName";
        String date = "date";

        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);
        Mockito.when(settlementInstructionService.validateUsingAPI(settlementInstruction)).
                thenReturn(null);
        Boolean isVerifed = settlementInstructionBusiness.validate(settlementInstruction);
        assertEquals(Boolean.FALSE,isVerifed);
    }

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsValid(){
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,settlementInstructionDao);
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

    @Test
    public void saveDetailsWithQueryReturnOne() throws Exception {

    }

    @Test
    public void saveDetailsWithQueryReturnOtherThanOne() throws Exception {
    }

    //@Test(expected = IssueWhileExecutingQuery.class)
    public void saveDetailsWithQueryReturnException() throws Exception {

    }


    @Test
    public void deleteDetailsWithQueryReturningOne() throws Exception {

    }

    @Test
    public void deleteDetailsWithQueryReturningOtherThanOne() throws Exception {

    }

    //@Test(expected = IssueWhileExecutingQuery.class)
    public void deleteDetailsWithQueryReturningException() throws Exception {


    }

}