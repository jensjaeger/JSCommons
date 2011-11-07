package com.jsing.common.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTrimmerTest {

    @Test
    public void testGetAfterNext() {
        assertEquals("ccc", new StringTrimmer("aaaBBBccc").getAfterNext("BBB").toString());
        assertEquals("", new StringTrimmer("aaaBBBccc").getAfterNext("xxx").toString());
        assertEquals("", new StringTrimmer("aaaBBBccc").getAfterNext("ccc").toString());
        assertEquals("", new StringTrimmer("aaaBBBccc").getAfterNext(null).toString());
        assertEquals(null, new StringTrimmer(null).getAfterNext("xxx").toString());
        assertEquals("ccc", new StringTrimmer("aaaBBBccc").getAfterNext("aaa").getAfterNext("BBB").toString());
    }

    @Test
    public void testGetBeforeNext() {
        assertEquals("aaa", new StringTrimmer("aaaBBBcccaaaccc").getBeforeNext("BBB").toString());
        assertEquals("aaaBBBccc", new StringTrimmer("aaaBBBccc").getBeforeNext("xxx").toString());
        assertEquals("", new StringTrimmer("aaaBBBcccaaa").getBeforeNext("aaa").toString());
        assertEquals("aaaBBBccc", new StringTrimmer("aaaBBBccc").getBeforeNext(null).toString());
        assertEquals(null, new StringTrimmer(null).getBeforeNext("xxx").toString());
        assertEquals("aaa", new StringTrimmer("aaaBBBcccaaa").getBeforeNext("ccc").getBeforeNext("BBB").toString());
        assertEquals("aaa", new StringTrimmer("aaa).', ;").getBeforeNext(")").getBeforeNext(".").toString());
    }
    
    @Test
    public void testGetBeforeLast() {
        assertEquals("aaaBBBccc", new StringTrimmer("aaaBBBcccBBBccc").getBeforeLast("BBB").toString());
        assertEquals("aaaBBBccc", new StringTrimmer("aaaBBBccc").getBeforeLast("xxx").toString());
        assertEquals("", new StringTrimmer("aaaBBBccc").getBeforeLast("aaa").toString());
        assertEquals("aaaBBBccc", new StringTrimmer("aaaBBBccc").getBeforeLast(null).toString());
        assertEquals(null, new StringTrimmer(null).getBeforeLast("xxx").toString());
        assertEquals("aaa", new StringTrimmer("aaaBBBccc").getBeforeLast("ccc").getBeforeLast("BBB").toString());
        assertEquals("aBBBc", new StringTrimmer("aaaBBBccc").getAfterNext("aa").getBeforeLast("cc").toString());
    }

}
