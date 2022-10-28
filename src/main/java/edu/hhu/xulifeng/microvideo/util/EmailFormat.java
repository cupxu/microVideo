package edu.hhu.xulifeng.microvideo.util;

import java.util.regex.Pattern;

/**
 * @description:
 * @author: cupxu
 * @create: 2022-10-27 21:32
 **/
public class EmailFormat {
    public static boolean isValidEmail(String email) {
        if ((email != null) && (!email.isEmpty())) {
            return Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email);
        }
        return false;
    }
}
