package com.learn.tdd.controller;
import com.learn.tdd.service.SettlementInstructionBusinessImpl;
import com.learn.tdd.vo.SettlementInstruction;
import org.junit.Test;

import org.mockito.Mockito;

import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SettlementInstructionControllerTest {

    @Test
    public void verifyDetailsWithValidationAsPassed() throws Exception {

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);

        //settlementInstructionController = new SettlementInstructionController(settlementInstructionBusinessImpl);
        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));

        String futureSIController = "abc";
        String modelName = "abc";
        String date = "date";

        /*SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureSIController, modelName, date);*/
        SettlementInstruction settlementInstruction =
                mock(SettlementInstruction.class);

        Mockito.doReturn(settlementInstruction).when(settlementInstructionController).
                getSettlementInstruction(futureSIController,modelName,date);

        Mockito.when(settlementInstructionBusinessImpl
                .validate(settlementInstruction))
                .thenReturn(Boolean.TRUE);

        ResponseEntity<?> response = settlementInstructionController.
                verifyDetails(futureSIController, modelName, date);

        assertEquals(200,response.getStatusCode().value());
    }

    @Test
    public void verifyDetailsWithValidationAsFailed() {
        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);

        //settlementInstructionController = new SettlementInstructionController(settlementInstructionBusinessImpl);
        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));

        String futureSIController = "abc@@@";
        String modelName = "abc";
        String date = "date";

        /*SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureSIController, modelName, date);*/
        SettlementInstruction settlementInstruction =
                mock(SettlementInstruction.class);

        Mockito.doReturn(settlementInstruction).when(settlementInstructionController).
                getSettlementInstruction(futureSIController,modelName,date);

        Mockito.when(settlementInstructionBusinessImpl
                .validate(settlementInstruction))
                .thenReturn(Boolean.FALSE);

        ResponseEntity<?> response = settlementInstructionController.
                verifyDetails(futureSIController, modelName, date);

        assertEquals(422,response.getStatusCode().value());
    }
}