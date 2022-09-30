package com.readingisgood.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class VersionUtil {

    private int TWO_PARTS_VERSION = 2;
    private int THREE_PARTS_VERSION = 3;

    private int BINARY_LEFT_OPERAND = 16;
    private int BINARY_RIGHT_OPERAND = 8;

    public boolean isUpdateAvailable(final String remoteVersion,
        final String currentVersion) {
        final int version = v2i(currentVersion);
        return version != -1 && version > v2i(remoteVersion);
    }

    public boolean isUpdateMandatory(final String remoteVersion,
        final String minVersion) {
        final int version = v2i(minVersion);
        return version != -1 && version > v2i(remoteVersion);
    }

    private int v2i(final String version) {

        if (StringUtils.isEmpty(version)) {
            return -1;
        }

        final String[] numbers = version.split("\\.");

        int a = Integer.parseInt(numbers[0]);
        int b = 0;
        int c = 0;

        if (numbers.length >= THREE_PARTS_VERSION) {
            b = Integer.parseInt(numbers[1]);
            c = Integer.parseInt(numbers[2]);
        } else if (numbers.length >= TWO_PARTS_VERSION) {
            b = Integer.parseInt(numbers[1]);
        }

        return (a << BINARY_LEFT_OPERAND) + (b << BINARY_RIGHT_OPERAND) + c;
    }
}
