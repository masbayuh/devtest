package org.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LogUtil {
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
