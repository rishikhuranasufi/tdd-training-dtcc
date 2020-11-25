package com.infosys.training.tdd.service;

import com.infosys.training.tdd.helper.Common;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettlementInstructionBusinessImplTest {

    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;

/* As a developer I need to think what actually I need to develop.
1. I need to verify / validate inputed values.
2. Its a Service logic.
3. So I need to create a Service class if it doesnt exists.
4. Instantiate Service class in test class.
5. Now define that method in test class, it will fail/ show error, fix it.
6. As aware we need to define these three inputted values which will be received from frontEnd application.
 */

    @Before
    public void setUp(){

        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
    }

    @Test
    public void validateData() {
        /* Faking, Triangulation, three laws ..
        **
        * Fake It Until You Make IT" TDD approach
        * You first create a unit test for new functionality that does not exist.
        * Now, you have a unit test to a non existing method.
        * You then create that method that doesn't do anything and your unit test compiles, but of course, fails.
        * You then go on building your method, underlying functionality etc until your unit test succeeds.
        * That's (kind of) test driven development.
        * */
    }
}