package org.cassell.veikozz.common.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class AesUtil {

    private static final String ENCODE_RULE = "tomSun28HaHaHaHa";

    private static final String SUPPORTED_ALGORITHMS_STR = "AES/CBC/PKCS5Padding";

    private static final String AES = "AES";

    private static String SECRET_KEY = ENCODE_RULE;



}
