package com.learn.tdd.service;

public class SettlementInstructionBusinessImplTest {

    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;

/* As a developer I need to think what actually I need to develop.
1. I need to verify / validate inputted values.
2. Its a Service logic.
3. So I need to create a Service class if it doesnt exists.
4. Instantiate Service class in test class.
5. Now define that method in test class, it will fail/ show error, fix it.
6. As aware we need to define these three inputted values which will be received from frontEnd application.
 *//*

    @Before
    public void setUp(){

        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
    }

    @Test
    public void validateData() {
        *//* Faking, Triangulation, three laws ..
        **
        * Fake It Until You Make IT" TDD approach
        * You first create a unit test for new functionality that does not exist.
        * Now, you have a unit test to a non existing method.
        * You then create that method that doesn't do anything and your unit test compiles, but of course, fails.
        * You then go on building your method, underlying functionality etc until your unit test succeeds.
        * That's (kind of) test driven development.
        * *//*
        // Scenario two and Scenario 3.
        // Advance and Database Unit testing ..

        //Validate not null functionality
        String futureEffectiveSICOntroller=null;
        String settlementModelName=null;
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfFutureEffectiveIsNotNullButModelNameIsNull(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName=null;
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfFutureEffectiveAndModelIsNotNullButSettlmentDateIsNull(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfAllValuesExists(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateRegex(){
        assertEquals(Boolean.FALSE, "@34eiodjioedjio".matches(Common.FUTURE_EFFECTIVE_PATTERN));
        assertEquals(Boolean.TRUE, "abcABC".matches(Common.FUTURE_EFFECTIVE_PATTERN));
        assertEquals(Boolean.FALSE, "!@@$$!!@!#$(*^".matches(Common.FUTURE_EFFECTIVE_PATTERN));

    }
    @Test
    public void validateFutureEffectiveSIControllerWithSpecialCharactersAndInvalidScenarios(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest123@";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);

        futureEffectiveSICOntroller="!@$*9@";

        isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateRegexSettlementModelName(){
        assertEquals(Boolean.FALSE, "@34eiodjioedjio".matches(Common.MODEL_NAME_PATTERN));
        assertEquals(Boolean.TRUE, "abcABC123".matches(Common.MODEL_NAME_PATTERN));
        assertEquals(Boolean.FALSE, "!@@$$!!@!#$(*^".matches(Common.MODEL_NAME_PATTERN));

    }
    @Test
    public void validateFutureEffectiveSIControllerWithValidScenario(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateSettlementModelNameWithSpecialCharactersAndInvalidScenarios(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);

        settlementModelName="!@$*9@";

        isVerified = settlementInstructionBusinessImpl.validate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }*/



}