package com.learn.tdd.service;

import com.learn.tdd.dao.SettlementInstructionDAO;
import com.learn.tdd.exception.IssueWhileExecutingQuery;
import com.learn.tdd.vo.SettlementInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(value = "settlementInstructionBusinessImpl")
public class SettlementInstructionBusinessImpl {

    public static final String DATE_FORMATTER = "uuuu-M-d";
    public static final String DATE_FORMATTER_02 = "uuuu-MM-dd";

    public SettlementInstructionBusinessImpl(SettlementInstructionDAO settlementInstructionDAO) {
        this.settlementInstructionDAO = settlementInstructionDAO;
    }

    @Autowired
    SettlementInstructionDAO settlementInstructionDAO;

    private static final Logger logger = LoggerFactory.getLogger(SettlementInstructionBusinessImpl.class);

    public Boolean validateFutureEffectiveController(SettlementInstruction settlementInstruction){
        if(StringUtils.isEmpty(settlementInstruction.getFutureEffectiveSICOntroller())){
            return Boolean.FALSE;
        }else{
            if (checkFutureEffectiveSIController(settlementInstruction)) return Boolean.FALSE;
            logger.info(settlementInstruction.getFutureEffectiveSICOntroller() + "' doesn't contains special character");
            return Boolean.TRUE;
        }
    }

    public Boolean validateModelName(SettlementInstruction settlementInstruction){
        if(StringUtils.isEmpty(settlementInstruction.getSettlementModelName())){
            return Boolean.FALSE;
        }else{
            if (checkSettlementModelName(settlementInstruction)) return Boolean.FALSE;
            logger.info(settlementInstruction.getSettlementModelName() + "' doesn't contains special character");
            return Boolean.TRUE;
        }
    }

/*    public Boolean validate(SettlementInstruction settlementInstruction) {
        if (StringUtils.isEmpty(settlementInstruction.getSettlementDate()) ||
                StringUtils.isEmpty(settlementInstruction.getSettlementModelName()) ||
                StringUtils.isEmpty(settlementInstruction.getFutureEffectiveSICOntroller())){
            return Boolean.FALSE;
        }else{
            if (checkFutureEffectiveSIController(settlementInstruction)) return Boolean.FALSE;
            logger.info(settlementInstruction.getFutureEffectiveSICOntroller() + "' doesn't contains special character");

            if (checkSettlementModelName(settlementInstruction)) return Boolean.FALSE;
            logger.info(settlementInstruction.getSettlementModelName() + "' doesn't contains special character");
            return Boolean.TRUE;
        }
    }*/

    private boolean checkSettlementModelName(SettlementInstruction settlementInstruction) {
        if(settlementInstruction.getSettlementModelName().length()>30)
            return Boolean.TRUE;

        Pattern settlementModelNamePattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher settlementModelNameMatcher = settlementModelNamePattern.matcher(settlementInstruction.getSettlementModelName());
        if (!settlementModelNameMatcher.matches()) {
            logger.error(settlementInstruction.getSettlementModelName() + "' contains special character");
            return true;
        }
        return false;
    }

    private boolean checkFutureEffectiveSIController(SettlementInstruction settlementInstruction) {
        if(settlementInstruction.getFutureEffectiveSICOntroller().length()>50)
            return Boolean.TRUE;

        Pattern futureEffectivePattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = futureEffectivePattern.matcher(settlementInstruction.getFutureEffectiveSICOntroller());
        if (!matcher.matches()) {
            logger.error("string '"+settlementInstruction.getFutureEffectiveSICOntroller() + "' contains special character");
            return true;
        }
        return false;
    }

    public Boolean validateFESICDetailsForUser(String user) throws Exception {

        Boolean isExists;
        try{
            isExists = settlementInstructionDAO.findByUserName(user);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IssueWhileExecutingQuery();
        }
        return isExists;

    }

    public Boolean validateSettlementDate(SettlementInstruction settlementInstruction) throws ParseException {
        if (StringUtils.isEmpty(settlementInstruction.getSettlementDate())) {
            return Boolean.FALSE;
        }else{
            if (checkDateFormating(settlementInstruction)) return Boolean.FALSE;

            return Boolean.TRUE;
        }
    }

    private boolean checkDateFormating(SettlementInstruction settlementInstruction) {
        try{// ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(settlementInstruction.getSettlementDate(),
                    DateTimeFormatter.ofPattern(DATE_FORMATTER)
                            .withResolverStyle(ResolverStyle.STRICT));
            logger.info(settlementInstruction.getSettlementDate()+" is valid date format");

            Date settlementDate =
                    Date.from(getDateFRomString(settlementInstruction)
                            .atStartOfDay(ZoneId.systemDefault()).toInstant());

            Date currentDate =
                    Date.from(getCurrentDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            if(settlementDate.compareTo(currentDate) < 0) {
                logger.error("settlementDate occurs before current date");
                return Boolean.TRUE;
            }
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime nintyDaysAgo = now.plusDays(90);

            if (settlementDate.toInstant().isAfter(nintyDaysAgo.toInstant())) {
                return Boolean.TRUE;
            }
        }
        catch (DateTimeParseException e){
            /* Date format is invalid */
            logger.error(settlementInstruction.getSettlementDate()+" is Invalid Date format");
            return true;
        }
        return false;
    }

    private LocalDate getDateFRomString(SettlementInstruction settlementInstruction){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMATTER_02);
        return LocalDate.parse(settlementInstruction.getSettlementDate(),
                dtf);
    }

    private LocalDate getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMATTER_02);
        LocalDateTime now = LocalDateTime.now();
        return LocalDate.parse(dtf.format(now));
    }
}
