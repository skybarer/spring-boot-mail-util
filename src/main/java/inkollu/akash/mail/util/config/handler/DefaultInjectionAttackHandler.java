package inkollu.akash.mail.util.config.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 11:39 AM
 */
public class DefaultInjectionAttackHandler implements InjectionAttackHandler {

    public static InjectionAttackHandler getInstance() {
        return new DefaultInjectionAttackHandler();
    }

    @Override
    public boolean isInjectionAttack(String rawCharacters) {
        return false;
    }

    @Override
    public boolean isInjectionAttack(String parameters, String[] ignoreStrings) {
        return false;
    }

    @Override
    public boolean isSqlInjectionAttack(String rawCharacters) {
        return false;
    }

    @Override
    public boolean isSqlInjectionAttack(String rawCharacters, String[] ignoreStrings) {
        return false;
    }

    @Override
    public boolean isXSSInjectionAttack(String rawCharacters) {
        return false;
    }

    @Override
    public boolean isXSSInjectionAttack(String rawCharacters, String[] ignoreStrings) {
        return false;
    }

    @Override
    public boolean isSpecialCharactersInjectionAttack(String rawCharacters) {
        return false;
    }

    @Override
    public boolean isSpecialCharactersInjectionAttack(String rawCharacters, String[] ignoreStrings) {
        return false;
    }

    @Override
    public String filter(String rawCharacters) {
        return null;
    }

    @Override
    public String filterSqlInjection(String rawCharacters) {
        return null;
    }

    @Override
    public String filterXSSInjection(String rawCharacters) {
        return null;
    }

    @Override
    public String filterSpecialCharacters(String rawCharacters) {
        return null;
    }

    @Override
    public void attackHandle(HttpServletRequest request, HttpServletResponse response, String parameters) throws IOException {

    }
}
