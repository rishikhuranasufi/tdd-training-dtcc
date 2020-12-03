package com.infosys.training.tdd.service;

import com.infosys.training.tdd.dao.SettlementInstructionDaoImpl;
import com.infosys.training.tdd.exception.IssueWhileExecutingQuery;
import com.infosys.training.tdd.vo.SettlementInstruction;
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

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,
                        settlementInstructionDao);

        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);

        Mockito.when(settlementInstructionDao.insert(settlementInstruction))
        .thenReturn(1);
        Boolean isDetailsSaved = settlementInstructionBusinessImpl.saveDetails(settlementInstruction);
        assertEquals(Boolean.TRUE, isDetailsSaved);


    }

    @Test
    public void saveDetailsWithQueryReturnOtherThanOne() throws Exception {

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,
                        settlementInstructionDao);

        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);

        Mockito.when(settlementInstructionDao.insert(settlementInstruction))
        .thenReturn(-1);
        Boolean isDetailsSaved = settlementInstructionBusinessImpl.saveDetails(settlementInstruction);
        assertEquals(Boolean.FALSE, isDetailsSaved);


    }

    @Test(expected = IssueWhileExecutingQuery.class)
    public void saveDetailsWithQueryReturnException() throws Exception {

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,
                        settlementInstructionDao);

        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);

        Mockito.when(settlementInstructionDao.insert(settlementInstruction))
        .thenThrow(new Exception());
        Boolean isDetailsSaved = settlementInstructionBusinessImpl.saveDetails(settlementInstruction);
        assertEquals(Boolean.FALSE, isDetailsSaved);


    }


    @Test
    public void deleteDetailsWithQueryReturningOne() throws Exception {

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,
                        settlementInstructionDao);

        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);

        Mockito.when(settlementInstructionDao.delete(settlementInstruction))
                .thenReturn(1);
        Boolean isDetailsDeleted = settlementInstructionBusinessImpl.deleteDetails(settlementInstruction);
        assertEquals(Boolean.TRUE, isDetailsDeleted);
    }

    @Test
    public void deleteDetailsWithQueryReturningOtherThanOne() throws Exception {

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,
                        settlementInstructionDao);

        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);

        Mockito.when(settlementInstructionDao.delete(settlementInstruction))
                .thenReturn(-2);
        Boolean isDetailsDeleted = settlementInstructionBusinessImpl.deleteDetails(settlementInstruction);
        assertEquals(Boolean.FALSE, isDetailsDeleted);
    }

    @Test(expected = IssueWhileExecutingQuery.class)
    public void deleteDetailsWithQueryReturningException() throws Exception {

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService,
                        settlementInstructionDao);

        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);

        Mockito.when(settlementInstructionDao.delete(settlementInstruction))
                .thenThrow(new Exception());
        Boolean isDetailsDeleted = settlementInstructionBusinessImpl.deleteDetails(settlementInstruction);
        assertEquals(Boolean.FALSE, isDetailsDeleted);
    }

}