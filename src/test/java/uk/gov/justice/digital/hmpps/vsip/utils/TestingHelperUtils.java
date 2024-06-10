package uk.gov.justice.digital.hmpps.vsip.utils;

import java.util.Arrays;
import java.util.List;

public class TestingHelperUtils {
    public static List<String> stringToListOfStrings(String val) {
        return Arrays.stream(val.split(",")).toList();
    }
}
