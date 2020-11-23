package com.infosys.training.tdd.vo;

public class SettlementInstruction {

    String futureEffectiveSICOntroller;
    String settlementModelName;
    String settlementDate;

    public SettlementInstruction(String futureEffectiveSICOntroller, String settlementModelName, String settlementDate) {
        this.futureEffectiveSICOntroller = futureEffectiveSICOntroller;
        this.settlementModelName = settlementModelName;
        this.settlementDate = settlementDate;
    }

    public String getFutureEffectiveSICOntroller() {
        return futureEffectiveSICOntroller;
    }

    public String getSettlementModelName() {
        return settlementModelName;
    }

    public String getSettlementDate() {
        return settlementDate;
    }
}
