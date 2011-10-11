package com.jsing.common.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTrimmerTest {

    @Test
    public void testGetAfterNext() {
        assertEquals("ccc", new StringTrimmer("aaaBBBccc").getAfterNext("BBB").toString());
    }

    @Test
    public void testGetBeforeNext() {
        assertEquals("aaa", new StringTrimmer("aaaBBBccc").getBeforeNext("BBB").toString());
        assertEquals("aaaBBB", new StringTrimmer("aaaBBBccc").getBeforeNext("ccc").toString());
    }

}
