package com.learn.tdd.dao;

import com.learn.tdd.vo.SettlementInstruction;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.mockito.Mockito;

import static com.learn.tdd.dao.SettlementInstructionDaoImpl.INSERT_QUERY;
import static org.junit.Assert.*;

public class SettlementInstructionDaoImplTest {

    @Test
    public void insert() throws Exception {

        QueryRunner queryRunner = Mockito.mock(QueryRunner.class);

        SettlementInstructionDaoImpl settlementInstructionDao =
                new SettlementInstructionDaoImpl(queryRunner);
        String futureEffectiveSIController="abcTest";
        String modelName="abcTest";
        String date="1998-10-10";
        SettlementInstruction settlementInstruction =
                new SettlementInstruction(futureEffectiveSIController, modelName, date);


        Mockito.when(queryRunner.update(SQLiteJDBC.getConnection(),
                INSERT_QUERY,
                settlementInstruction.getFutureEffectiveSICOntroller()
                ,settlementInstruction.getSettlementModelName(),
                settlementInstruction.getSettlementDate())).thenReturn(1);

        int isInserted = settlementInstructionDao.insert(settlementInstruction);
        assertEquals(1,isInserted);

    }
}