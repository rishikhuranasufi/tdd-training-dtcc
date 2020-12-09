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
    public void verifyFutureEffectiveSIControllerWithValidationAsPassed() throws Exception {

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);

        //settlementInstructionController = new SettlementInstructionController(settlementInstructionBusinessImpl);
        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));

        String futureSIController = "abc";
        String modelName = "abc";
        String date = "date";

        SettlementInstruction settlementInstruction =
                mock(SettlementInstruction.class);

        Mockito.doReturn(settlementInstruction).when(settlementInstructionController).
                getSettlementInstruction(futureSIController,modelName,date);

        Mockito.when(settlementInstructionBusinessImpl
                .validateFutureEffectiveController(settlementInstruction))
                .thenReturn(Boolean.TRUE);

        ResponseEntity<?> response = settlementInstructionController.
                verifyFutureEffectiveController(futureSIController, modelName, date);

        assertEquals(200,response.getStatusCode().value());
    }

    @Test
    public void verifyFutureEffectiveSIControllerWithValidationAsFailed() {
        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);


        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));

        String futureSIController = "abc@@@";
        String modelName = "abc";
        String date = "date";

        SettlementInstruction settlementInstruction =
                mock(SettlementInstruction.class);

        Mockito.doReturn(settlementInstruction).when(settlementInstructionController).
                getSettlementInstruction(futureSIController,modelName,date);

        Mockito.when(settlementInstructionBusinessImpl
                .validateFutureEffectiveController(settlementInstruction))
                .thenReturn(Boolean.FALSE);

        ResponseEntity<?> response = settlementInstructionController.
                verifyFutureEffectiveController(futureSIController, modelName, date);

        assertEquals(422,response.getStatusCode().value());
    }

    @Test
    public void verifySettlementModelNameWithValidationAsPassed() throws Exception {

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);

        //settlementInstructionController = new SettlementInstructionController(settlementInstructionBusinessImpl);
        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));

        String futureSIController = "abc";
        String modelName = "abc";
        String date = "date";

        SettlementInstruction settlementInstruction =
                mock(SettlementInstruction.class);

        Mockito.doReturn(settlementInstruction).when(settlementInstructionController).
                getSettlementInstruction(futureSIController,modelName,date);

        Mockito.when(settlementInstructionBusinessImpl
                .validateModelName(settlementInstruction))
                .thenReturn(Boolean.TRUE);

        ResponseEntity<?> response = settlementInstructionController.
                verifySettlementModelName(futureSIController, modelName, date);

        assertEquals(200,response.getStatusCode().value());
    }

    @Test
    public void verifySettlementModelNameWithValidationAsFailed() {
        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);


        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));

        String futureSIController = "abc@@@";
        String modelName = "abc";
        String date = "date";

        SettlementInstruction settlementInstruction =
                mock(SettlementInstruction.class);

        Mockito.doReturn(settlementInstruction).when(settlementInstructionController).
                getSettlementInstruction(futureSIController,modelName,date);

        Mockito.when(settlementInstructionBusinessImpl
                .validateModelName(settlementInstruction))
                .thenReturn(Boolean.FALSE);

        ResponseEntity<?> response = settlementInstructionController.
                verifySettlementModelName(futureSIController, modelName, date);

        assertEquals(422,response.getStatusCode().value());
    }

    @Test
    public void verifyWhenFESICDetailsAvailableForUser() throws Exception {

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);

        //settlementInstructionController = new SettlementInstructionController(settlementInstructionBusinessImpl);
        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));
        String user = "demoUser";
        Mockito.when(settlementInstructionBusinessImpl
                .validateFESICDetailsForUser(user))
                .thenReturn(Boolean.TRUE);

        ResponseEntity<?> response = settlementInstructionController.
                validateFESICDetailsAvailability(user);

        assertEquals(200,response.getStatusCode().value());
    }

    @Test
    public void verifyWhenFESICDetailsNOTAvailableForUser() throws Exception {

        SettlementInstructionBusinessImpl settlementInstructionBusinessImpl =
                Mockito.mock(SettlementInstructionBusinessImpl.class);

        SettlementInstructionController settlementInstructionController
                = Mockito.spy(new SettlementInstructionController(settlementInstructionBusinessImpl));
        String user = "demoUserWithoutFESIC";
        Mockito.when(settlementInstructionBusinessImpl
                .validateFESICDetailsForUser(user))
                .thenReturn(Boolean.FALSE);

        ResponseEntity<?> response = settlementInstructionController.
                validateFESICDetailsAvailability(user);

        assertEquals(422,response.getStatusCode().value());
    }
}