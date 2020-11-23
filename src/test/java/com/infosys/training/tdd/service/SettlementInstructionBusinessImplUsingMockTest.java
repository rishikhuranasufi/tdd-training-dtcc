package com.infosys.training.tdd.service;

import com.infosys.training.tdd.service.stub.SettlementInstructionService;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SettlementInstructionBusinessImplUsingMockTest {

    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;

    @Test
    public void validateSettlementModelUsingSerivceAPICall(){

        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);

        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService);
        String futureEffectiveSICOntroller="abc";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        SettlementInstruction settlementInstruction = new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate);

        List<String> returnedList = new ArrayList<String>();
        returnedList.add("abc_false");

        Mockito.when(settlementInstructionService.
                validateInstructionUsingAPI(settlementInstruction)).thenReturn(returnedList);

        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(settlementInstruction);
        assertEquals(Boolean.FALSE, isVerified);
    }


    @Test
    public void validateSettlementModelUsingSerivceAPICallV2(){
        /*SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();*/
        SettlementInstructionService settlementInstructionService =
                Mockito.mock(SettlementInstructionService.class);
        String futureEffectiveSICOntroller="abc";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        SettlementInstruction settlementInstruction = new SettlementInstruction
                (futureEffectiveSICOntroller, settlementModelName, settlementDate);
        List<String> response = new ArrayList<String>();
        response.add("abc_true");
        Mockito.when(
                settlementInstructionService.
                        validateInstructionUsingAPI(settlementInstruction)).
                thenReturn(response);

        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionService);

        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(settlementInstruction);
        assertEquals(Boolean.TRUE, isVerified);
    }

}