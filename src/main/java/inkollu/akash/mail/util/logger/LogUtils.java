package inkollu.akash.mail.util.logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.*;

public abstract class LogUtils {

    public static Logger getLogger() {
        return LogManager.getLogger();
    }


    public static Logger getLogger(MessageFactory messageFactory) {
        return LogManager.getLogger(messageFactory);
    }

    public static Logger getCustomizationLogger() {
        return LogManager.getLogger(CustomizationParameterizedMessage.INSTANCE);
    }


    public static String confusion(String rawString) {
        if (StringUtils.isBlank(rawString)) {
            return rawString;
        }
        return rawString;
    }

    public static class CustomizationParameterizedMessage extends AbstractMessageFactory {

        private static final CustomizationParameterizedMessage INSTANCE = new CustomizationParameterizedMessage();


        @Override
        public Message newMessage(final String message, final Object... params) {
            return new ParameterizedMessage(message, params);
        }


        @Override
        public Message newMessage(final String message, final Object p0) {
            return new ParameterizedMessage(message, p0);
        }

        @Override
        public Message newMessage(final String message, final Object p0, final Object p1) {
            return new ParameterizedMessage(message, p0, p1);
        }

        @Override
        public Message newMessage(final String message, final Object p0, final Object p1, final Object p2) {
            return new ParameterizedMessage(message, p0, p1, p2);
        }

        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3) {
            return new ParameterizedMessage(message, p0, p1, p2, p3);
        }

        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3,
                                  final Object p4) {
            return new ParameterizedMessage(message, p0, p1, p2, p3, p4);
        }

        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3,
                                  final Object p4,
                                  final Object p5) {
            return new ParameterizedMessage(message, p0, p1, p2, p3, p4, p5);
        }

        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3,
                                  final Object p4,
                                  final Object p5,
                                  final Object p6) {
            return new ParameterizedMessage(message, p0, p1, p2, p3, p4, p5, p6);
        }

        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3,
                                  final Object p4,
                                  final Object p5,
                                  final Object p6,
                                  final Object p7) {
            return new ParameterizedMessage(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }


        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3,
                                  final Object p4,
                                  final Object p5,
                                  final Object p6,
                                  final Object p7,
                                  final Object p8) {
            return new ParameterizedMessage(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }


        @Override
        public Message newMessage(final String message,
                                  final Object p0,
                                  final Object p1,
                                  final Object p2,
                                  final Object p3,
                                  final Object p4,
                                  final Object p5,
                                  final Object p6,
                                  final Object p7,
                                  final Object p8,
                                  final Object p9) {
            return new ParameterizedMessage(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }

    }


}