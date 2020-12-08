package com.learn.tdd.service;

import com.learn.tdd.vo.SettlementInstruction;
import org.junit.Test;

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

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSIController = "emptyValue";
        String modelName = "modelName";
        String date = "date";
        Boolean isVerified = settlementInstructionBusiness.validate(new SettlementInstruction(futureEffectiveSIController,
                modelName, date));

        assertEquals(Boolean.FALSE,isVerified);

    }

    @Test
    public void validateWhenResponseAPIContainsAnNullElement(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSIController = "nullValue";
        String modelName = "modelName";
        String date = "date";
        Boolean isVerified = settlementInstructionBusiness.validate(new SettlementInstruction(futureEffectiveSIController,
                modelName, date));

        assertEquals(Boolean.FALSE,isVerified);

    }

    @Test(expected = NullPointerException.class)
    public void validateWhenResponseAPIisNull(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();

        SettlementInstructionBusinessImpl settlementInstructionBusiness = new
                SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSIController = "null";
        String modelName = "modelName";
        String date = "date";
        Boolean isVerified = settlementInstructionBusiness.validate(new SettlementInstruction(futureEffectiveSIController,
                modelName, date));
        assertEquals(Boolean.FALSE,isVerified);
    }

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsValid(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }


}