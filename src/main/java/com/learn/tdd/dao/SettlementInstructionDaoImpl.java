package com.learn.tdd.dao;

import com.learn.tdd.vo.SettlementInstruction;
import org.apache.commons.dbutils.QueryRunner;

public class SettlementInstructionDaoImpl implements SettlementInstructionDao{

    QueryRunner queryRunner;

    public SettlementInstructionDaoImpl(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public static final String INSERT_QUERY = "INSERT INTO SETTLEMENT_INSTRUCTION (FE_SIC,S_MN,S_DATE) VALUES (?,?,?)";
    @Override
    public int insert(SettlementInstruction settlementInstruction) throws Exception {
        return 1;
    }

    @Override
    public int delete(SettlementInstruction settlementInstruction) throws Exception {
        return 0;
    }

    /*public int insert(SettlementInstruction settlementInstruction) throws Exception{

        int insertedRecords = 0;
        try {
            insertedRecords = queryRunner.update(SQLiteJDBC.getConnection(),
                    INSERT_QUERY,
                    settlementInstruction.getFutureEffectiveSICOntroller()
                    ,settlementInstruction.getSettlementModelName(),
                    settlementInstruction.getSettlementDate());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(insertedRecords + " record(s) inserted");
        return insertedRecords;

    }*/
}
