package com.infosys.training.tdd.service;

import com.infosys.training.tdd.dao.SettlementInstructionDaoImpl;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SettlementInstructionBusinessImplStubTest {


    /**
     * 1. Response of an API contains empty  element.
     * 2. Response of an API contains null element.
     * 3. Response of an API itself is null.
     *
     * **/

    @Test
    public void validateWhenResponseAPIContainsAnEmptyElement(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionServiceStub, settlementInstructionDao);
        String futureEffectiveSIController = "emptyValue";
        String modelName = "modelName";
        String date = "date";
        Boolean isVerifed = settlementInstructionBusiness.validate(new SettlementInstruction(futureEffectiveSIController,
                modelName, date));

        assertEquals(Boolean.FALSE,isVerifed);

    }

    @Test
    public void validateWhenResponseAPIContainsAnNullElement(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionServiceStub,settlementInstructionDao);
        String futureEffectiveSIController = "nullValue";
        String modelName = "modelName";
        String date = "date";
        Boolean isVerifed = settlementInstructionBusiness.validate(new SettlementInstruction(futureEffectiveSIController,
                modelName, date));

        assertEquals(Boolean.FALSE,isVerifed);

    }

    @Test(expected = NullPointerException.class)
    public void validateWhenResponseAPIisNull(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();

        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionServiceStub,settlementInstructionDao);
        String futureEffectiveSIController = "null";
        String modelName = "modelName";
        String date = "date";
        Boolean isVerifed = settlementInstructionBusiness.validate(new SettlementInstruction(futureEffectiveSIController,
                modelName, date));
        assertEquals(Boolean.FALSE,isVerifed);
    }

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsValid(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        SettlementInstructionDaoImpl settlementInstructionDao =
                Mockito.mock(SettlementInstructionDaoImpl.class);

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub,settlementInstructionDao);
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }


}