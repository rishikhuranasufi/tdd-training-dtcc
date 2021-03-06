package com.infosys.training.tdd.service;

import com.infosys.training.tdd.helper.Common;
import com.infosys.training.tdd.vo.SettlementInstruction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettlementInstructionBusinessImplTest {

    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;

/* As a developer I need to think what actually I need to develop.
1. I need to verify / validate inputted values.
2. Its a Service logic.
3. So I need to create a Service class if it doesnt exists.
4. Instantiate Service class in test class.
5. Now define that method in test class, it will fail/ show error, fix it.
6. As aware we need to define these three inputted values which will be received from frontEnd application.
 */

    /*@Before
    public void setUp(){

        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
    }

    @Test
    public void validateData() {
        // Faking, Triangulation, three laws ..
        *//*
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
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfFutureEffectiveIsNotNullButModelNameIsNull(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName=null;
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfFutureEffectiveAndModelIsNotNullButSettlmentDateIsNull(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfAllValuesExists(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
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
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);

        futureEffectiveSICOntroller="!@$*9@";

        isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
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
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateSettlementModelNameWithSpecialCharactersAndInvalidScenarios(){
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl();
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);

        settlementModelName="!@$*9@";

        isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }*/

    @Test
    public void validateSettlementModelUsingSerivceAPICall(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="abc";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    // Response list string may be empty.
    // Any of String in Response list contains _false
    // Any of String in Response list contains _true
    // Any of String in Response list wrong random values i.e. abcxyz.
    // Any of String in Response list wrong random values i.e. 12345.
    // May be whole list retured in null.

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsEmpty(){
        SettlementInstructionServiceStubV2 settlementInstructionServiceStubV2 =
                new SettlementInstructionServiceStubV2();
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl(settlementInstructionServiceStubV2);
        String futureEffectiveSICOntroller="rishi";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean siVerified = settlementInstructionBusinessImpl.
                verifyUIInputedData(new SettlementInstruction(
                        futureEffectiveSICOntroller,settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, siVerified);
        /*SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="rishi";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);*/
    }



    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsNull(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="demo";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsInvalid(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="123";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateSettlementModelUsingSerivceAPICallWithAnyOfStringAsValid(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test(expected = NullPointerException.class)
    public void validateSettlementModelUsingSerivceAPICallWithListAsNull(){
        SettlementInstructionServiceStub settlementInstructionServiceStub =
                new SettlementInstructionServiceStub();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="null";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test(expected = NullPointerException.class)
    public void validateSettlementModelUsingSerivceAPICallWithListAsNullV2(){
        SettlementInstructionServiceStubV2 settlementInstructionServiceStub =
                new SettlementInstructionServiceStubV2();
        settlementInstructionBusinessImpl =
                new SettlementInstructionBusinessImpl(settlementInstructionServiceStub);
        String futureEffectiveSICOntroller="demo";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        settlementInstructionBusinessImpl.verifyUIInputedData(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));

    }

}