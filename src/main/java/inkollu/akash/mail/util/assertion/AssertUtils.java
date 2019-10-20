package inkollu.akash.mail.util.assertion;

/*
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 11:46 AM
 */

import inkollu.akash.mail.util.exception.*;
import org.springframework.validation.BindingResult;

import java.util.Objects;


public abstract class AssertUtils {



    public static void assertResourceNotFoundIsTrue ( boolean condition , String message ) throws
            ResourceNotFoundException {
        if ( condition ) {
            throw new ResourceNotFoundException( message );
        }

    }


    public static void assertCaptchaIsTrue ( boolean condition , String message ) throws
            CaptchaException {
        if ( condition ) {
            throw new CaptchaException( message );
        }
    }


    public static void assertPermissionIsTrue ( boolean condition , String message ) throws ForbiddenException {
        if ( condition ) {
            throw new ForbiddenException( message );
        }
    }

    public static void isTrue ( boolean condition , String message ) throws
            ServiceException {
        assertServiceException( condition , message );
    }


    public static void isTrue ( boolean condition , Throwable throwable ) throws Throwable {
        if ( condition ) {
            throw throwable;
        }
    }

    public static void assertDaoIsTrue ( boolean condition , String message ) throws
            DaoException {
        daoServiceException( condition , message );
    }


    private static void assertServiceException ( boolean condition , String message ) {
        if ( condition ) {
            throw new ServiceException( message );
        }
    }


    private static void daoServiceException ( boolean condition , String message ) {
        if ( condition ) {
            throw new DaoException( message );
        }
    }


    public static void bindingResult ( BindingResult result ) throws
            ValidatedIllegalArgumentException {
        if ( Objects.isNull( result ) ) {
            return;
        }
        if ( result.hasErrors() ) {
            throw new ValidatedIllegalArgumentException( result );
        }

    }
}
