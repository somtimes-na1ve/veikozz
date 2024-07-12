package org.cassell.veikozz.common.util;

import com.google.common.base.Strings;
import lombok.experimental.UtilityClass;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.util.InetAddressUtils;

import java.util.regex.Pattern;

@UtilityClass
@Slf4j
public class IpAddressUtil {

    public static final String IPV4 = "4";
    public static final String IPV6 = "6";

    private static final String LOCALHOST = "localhost";

    private static final Pattern DOMAIN_PATTERN = Pattern.compile("^[-\\w]+(\\.[-\\w]+)*$");
    private static final Pattern DOMAIN_SCHEMA_PATTERN =
            Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://){1}[^\\s]*");

    public static String detectIPVersion(String address) {
        if (Strings.isNullOrEmpty(address)) {
            return null;
        } else if (InetAddressUtils.isIPv4Address(address)) {
            return IPV4;
        } else if (InetAddressUtils.isIPv6Address(address)) {
            return IPV6;
        } else {
            log.warn("Unrecognized ip address: {}, cannot detect is protocol version.", address);
            return null;
        }
    }

    public static boolean checkIfValidDomain(String domain) {
        if (Strings.isNullOrEmpty(domain)) {
            return false;
        }

        return LOCALHOST.equalsIgnoreCase(domain)
                || InetAddressUtils.isIPv4Address(domain)
                || InetAddressUtils.isIPv6Address(domain)
                || DOMAIN_PATTERN.matcher(domain).matches();
    }

}
