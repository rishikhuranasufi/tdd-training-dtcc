package com.learn.tdd.service;

import com.learn.tdd.dao.SettlementInstructionDAOImpl;
import com.learn.tdd.exception.IssueWhileExecutingQuery;
import com.learn.tdd.helper.Common;
import com.learn.tdd.vo.SettlementInstruction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;

import static org.junit.Assert.*;

public class SettlementInstructionBusinessImplTest {

    SettlementInstructionBusinessImpl settlementInstructionBusinessImpl;
    SettlementInstructionDAOImpl settlementInstructionDAO;
/* As a developer I need to think what actually I need to develop.
1. I need to verify / validate inputted values.
2. Its a Service logic.
3. So I need to create a Service class if it doesnt exists.
4. Instantiate Service class in test class.
5. Now define that method in test class, it will fail/ show error, fix it.
6. As aware we need to define these three inputted values which will be received from frontEnd application.
 */

    @Before
    public void setUp(){
        settlementInstructionDAO =
                Mockito.mock(SettlementInstructionDAOImpl.class);
        settlementInstructionBusinessImpl = new SettlementInstructionBusinessImpl(settlementInstructionDAO);
    }

    @Test
    public void validateIfFutureEffectiveIsNull(){
        String futureEffectiveSICOntroller=null;
        String settlementModelName="abcTest123";
        String settlementDate="10-10-2020";
        Boolean isVerified = settlementInstructionBusinessImpl.validateFutureEffectiveController(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateDetailsIfModelNameisNull() {
        /* Faking, Triangulation, three laws ..
        **
        * Fake It Until You Make IT" TDD approach
        * You first create a unit test for new functionality that does not exist.
        * Now, you have a unit test to a non existing method.
        * You then create that method that doesn't do anything and your unit test compiles, but of course, fails.
        * You then go on building your method, underlying functionality etc until your unit test succeeds.
        * That's (kind of) test driven development.
        * */
        // Scenario two and Scenario 3.
        // Advance and Database Unit testing ..

        //Validate not null functionality
        String futureEffectiveSICOntroller=null;
        String settlementModelName=null;
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.validateModelName(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateIfModelNameAndDateIsNull(){
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName=null;
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.validateModelName(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }


    @Test
    public void validateIfValueExistsForFutureEffecticeSettlementController(){
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateFutureEffectiveController(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateIfValueExistsForModelName(){
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateModelName(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateRegexWithNumericValues(){
        assertEquals(Boolean.FALSE, "34eiodjioedjio".matches(Common.FUTURE_EFFECTIVE_PATTERN));
    }

    @Test
    public void validateRegexWithSpecialCharacters(){
        assertEquals(Boolean.FALSE, "!@@$$!!@!#$(*^".matches(Common.FUTURE_EFFECTIVE_PATTERN));

    }

    @Test
    public void validateRegexWithCorrectValue(){
        assertEquals(Boolean.TRUE, "abcABC".matches(Common.FUTURE_EFFECTIVE_PATTERN));
    }
    @Test
    public void validateFutureEffectiveSIControllerWithSpecialCharactersAndInvalidScenarios(){
        String futureEffectiveSICOntroller="abcTest123@";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateFutureEffectiveController(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);

        futureEffectiveSICOntroller="!@$*9@";

        isVerified = settlementInstructionBusinessImpl.validateFutureEffectiveController(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateFutureEffectiveSIControllerWithCharactersLengthMoreThan50(){
        String futureEffectiveSICOntroller="abcTestabcTestabcTestabcTestabcTestabcTestabcTestabcTestabcTestabcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateFutureEffectiveController(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateModelNameWithCharactersLengthMoreThan30(){
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTestabcTestabcTestabcTestabcTestabcTestabcTestabcTestabcTestabcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateModelName(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateRegexSettlementModelNameWithSpecialCharacters(){
        assertEquals(Boolean.FALSE, "!@@$$!!@!#$(*^".matches(Common.MODEL_NAME_PATTERN));

    }

    @Test
    public void validateRegexSettlementModelNameWithValidCharacters(){
        assertEquals(Boolean.TRUE, "abcABC123".matches(Common.MODEL_NAME_PATTERN));
    }

    @Test
    public void validateFutureEffectiveSIControllerWithValidScenario(){
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest123";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateFutureEffectiveController(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateSettlementModelNameWithSpecialCharactersAndInvalidScenarios(){
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-10-10";
        Boolean isVerified = settlementInstructionBusinessImpl.validateModelName(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);

        settlementModelName="!@$*9@";

        isVerified = settlementInstructionBusinessImpl.validateModelName(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateFESICDetailsForUserWithWrongUserName() throws Exception {
        String userName = "WRONG_USERNAME";
        Mockito.when(settlementInstructionDAO.findByUserName(userName)).
                thenReturn(Boolean.FALSE);
        Boolean isExists = settlementInstructionBusinessImpl.
                validateFESICDetailsForUser(userName);
        assertEquals(Boolean.FALSE, isExists);
    }

    @Test(expected = IssueWhileExecutingQuery.class)
    public void validateFESICDetailsForUserThrowsAnException() throws Exception {
        String userName = "WRONG_USERNAME";
        Mockito.when(settlementInstructionDAO.findByUserName(userName)).
                thenThrow(new IssueWhileExecutingQuery());
        Boolean isExists = settlementInstructionBusinessImpl.
                validateFESICDetailsForUser(userName);
        assertEquals(Boolean.FALSE, isExists);
    }

    @Test
    public void validateFESICDetailsForUserExists() throws Exception {
        String userName = "Correct_username";
        Mockito.when(settlementInstructionDAO.findByUserName(userName)).
                thenReturn(Boolean.TRUE);
        Boolean isExists = settlementInstructionBusinessImpl.
                validateFESICDetailsForUser(userName);
        assertEquals(Boolean.TRUE, isExists);
    }

    @Test
    public void validateSettlementInstructionDateWithValidValues() throws ParseException {
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="2020-12-27";
        Boolean isVerified = settlementInstructionBusinessImpl.validateSettlementDate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.TRUE, isVerified);
    }

    @Test
    public void validateSettlementInstructionDateisGreaterThan90Days() throws ParseException {
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="2021-12-12";
        Boolean isVerified = settlementInstructionBusinessImpl.validateSettlementDate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateSettlementInstructionDateisLessThanTodayDate() throws ParseException {
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="2020-12-05";
        Boolean isVerified = settlementInstructionBusinessImpl.validateSettlementDate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateSettlementInstructionDateisNull() throws ParseException {
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate=null;
        Boolean isVerified = settlementInstructionBusinessImpl.validateSettlementDate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateSettlementInstructionDateWithInValidValues() throws ParseException {
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="1998-30-30";
        Boolean isVerified = settlementInstructionBusinessImpl.validateSettlementDate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }

    @Test
    public void validateSettlementInstructionDateWithInValidValuesAsAlphabhets() throws ParseException {
        String futureEffectiveSICOntroller="abcTest";
        String settlementModelName="abcTest";
        String settlementDate="abcText";
        Boolean isVerified = settlementInstructionBusinessImpl.validateSettlementDate(new SettlementInstruction(futureEffectiveSICOntroller,
                settlementModelName,settlementDate));
        assertEquals(Boolean.FALSE, isVerified);
    }



}
