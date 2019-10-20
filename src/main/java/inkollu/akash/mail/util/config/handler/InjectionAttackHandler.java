package inkollu.akash.mail.util.config.handler;

/*
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 11:37 AM
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface InjectionAttackHandler {


    boolean isInjectionAttack(String rawCharacters);

    boolean isInjectionAttack(String parameters, String[] ignoreStrings);

    boolean isSqlInjectionAttack(String rawCharacters);

    boolean isSqlInjectionAttack(String rawCharacters, String[] ignoreStrings);

    boolean isXSSInjectionAttack(String rawCharacters);

    boolean isXSSInjectionAttack(String rawCharacters, String[] ignoreStrings);

    boolean isSpecialCharactersInjectionAttack(String rawCharacters);

    boolean isSpecialCharactersInjectionAttack(String rawCharacters, String[] ignoreStrings);

    String filter(String rawCharacters);

    String filterSqlInjection(String rawCharacters);

    String filterXSSInjection(String rawCharacters);

    String filterSpecialCharacters(String rawCharacters);

    void attackHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            String parameters
    ) throws IOException;


}