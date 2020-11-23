package com.infosys.training.tdd.controller;

import com.infosys.training.tdd.payload.ApiResponse;
import com.infosys.training.tdd.service.SettlementInstructionBusinessImpl;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SettlementInstructionController {

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionController.class);

    @Autowired
    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;

    @GetMapping("/")
    public String index() {
        return "This is TDD Simulation Application for training purpose.";
    }

    @RequestMapping(value = "/v1/verifyDetails/{futureEffectiveSICOntroller}/{settlementModelName}/{settlementDate}", method = RequestMethod.GET)
    public ResponseEntity<?> verifyDetails(@PathVariable String futureEffectiveSICOntroller,
                                            @PathVariable String settlementModelName, @PathVariable String settlementDate) {

        logger.info("Inside Save Details");
        if (settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName, settlementDate)))
            return ResponseEntity.ok(new ApiResponse(true,"Details Verified successfully"));
        else
            return ResponseEntity.ok(new ApiResponse(false,"Details Not processed/ Validated Successfully"));

        //return ResponseEntity.ok(new ApiResponse(false,"Details Not processed/ Validated Successfully"));
    }



}
