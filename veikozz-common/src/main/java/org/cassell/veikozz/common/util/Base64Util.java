package org.cassell.veikozz.common.util;

import com.google.common.base.Strings;
import lombok.experimental.UtilityClass;

import java.util.Base64;

@UtilityClass
public class Base64Util {

    public static boolean checkIfValidBase64(String data) {
        if (Strings.isNullOrEmpty(data)) {
            return false;
        }

        try {
            return Base64.getDecoder().decode(data) != null;
        } catch (Exception e) {
            return false;
        }
    }

}
