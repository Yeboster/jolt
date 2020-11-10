package com.bazaarvoice.jolt.modifier.function;

import com.bazaarvoice.jolt.common.Optional;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("deprecated")
public class DatesTest extends AbstractTester {

    @DataProvider(parallel = true)
    public Iterator<Object[]> getTestCases() {
        List<Object[]> testCases = new LinkedList<>();

        // TODO: Add missing tests
        Function FORMAT_ISO_DATE_TO = new Dates.formatIsoDateTo();

        testCases.add(new Object[] { "format-valid-date-utc", FORMAT_ISO_DATE_TO,
                new Object[] { "yyyy-MM-dd", "2020-10-13T10:14:34Z" }, Optional.of("2020-10-13") });

        testCases.add(new Object[] { "format-valid-date-with-timezone", FORMAT_ISO_DATE_TO,
                new Object[] { "yyyy-MM-dd", "2020-10-13T10:14:34+0200" }, Optional.of("2020-10-13") });

        return testCases.iterator();
    }
}
