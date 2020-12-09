package com.learn.tdd.controller;

import com.learn.tdd.payload.ApiResponse;
import com.learn.tdd.service.SettlementInstructionBusinessImpl;
import com.learn.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SettlementInstructionController {

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionController.class);

    @Autowired
    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;

    public SettlementInstructionController(SettlementInstructionBusinessImpl settlementInstructionBusinessImpl){
        this.settlementInstructionBusinessImpl
                = settlementInstructionBusinessImpl;
    }

    @GetMapping("/")
    public String index() {
        return "This is TDD Simulation Application for training purpose.";
    }

    //First STORY
    @RequestMapping(value = "/v1/validateFESICDetailsAvailability/{user}", method = RequestMethod.GET)
    public ResponseEntity<?> validateFESICDetailsAvailability(@PathVariable String user) throws Exception {
        if (settlementInstructionBusinessImpl.validateFESICDetailsForUser(user))
            return ResponseEntity.ok(new ApiResponse(true,"FESIC Details available for user"));
        else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiResponse(false,"Details Not Available"));
    }

    //Second Story
    @RequestMapping(value = "/v1/verifyFutureEffectiveController/{futureEffectiveSICOntroller}/{settlementModelName}/{settlementDate}", method = RequestMethod.GET)
    public ResponseEntity<?> verifyFutureEffectiveController(@PathVariable String futureEffectiveSICOntroller,
                                            @PathVariable String settlementModelName, @PathVariable String settlementDate) {

        logger.info("Inside verifyFutureEffectiveController Details");
        if (settlementInstructionBusinessImpl.validateFutureEffectiveController(getSettlementInstruction(futureEffectiveSICOntroller, settlementModelName, settlementDate)))
            return ResponseEntity.ok(new ApiResponse(true,"Details Verified successfully"));
        else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiResponse(false,"Details Not processed/ Validated Successfully"));

        //return ResponseEntity.ok(new ApiResponse(false,"Details Not processed/ Validated Successfully"));
    }

    //Third Story
    @RequestMapping(value = "/v1/verifySettlementModelName/{futureEffectiveSICOntroller}/{settlementModelName}/{settlementDate}", method = RequestMethod.GET)
    public ResponseEntity<?> verifySettlementModelName(@PathVariable String futureEffectiveSICOntroller,
                                            @PathVariable String settlementModelName, @PathVariable String settlementDate) {

        logger.info("Inside verifySettlementModelName Details");
        if (settlementInstructionBusinessImpl.validateModelName(getSettlementInstruction(futureEffectiveSICOntroller, settlementModelName, settlementDate)))
            return ResponseEntity.ok(new ApiResponse(true,"Details Verified successfully"));
        else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiResponse(false,"Details Not processed/ Validated Successfully"));
    }

    //Fourth Story
    @RequestMapping(value = "/v1/verifySettlementDate/{futureEffectiveSICOntroller}/{settlementModelName}/{settlementDate}", method = RequestMethod.GET)
    public ResponseEntity<?> verifySettlementDate(@PathVariable String futureEffectiveSICOntroller,
                                            @PathVariable String settlementModelName, @PathVariable String settlementDate) throws ParseException {

        logger.info("Inside verifySettlementDate Details");
        if (settlementInstructionBusinessImpl.validateSettlementDate(getSettlementInstruction(futureEffectiveSICOntroller, settlementModelName, settlementDate)))
            return ResponseEntity.ok(new ApiResponse(true,"Details Verified successfully"));
        else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiResponse(false,"Details Not processed/ Validated Successfully"));
    }

    SettlementInstruction getSettlementInstruction(String futureEffectiveSICOntroller, String settlementModelName, String settlementDate) {
        return new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName, settlementDate);
    }


}
