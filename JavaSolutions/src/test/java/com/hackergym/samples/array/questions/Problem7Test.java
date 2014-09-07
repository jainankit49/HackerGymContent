package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem7Test {

    Problem7 compressor = new Problem7();

    @Test
    public void testCompress() throws Exception {

        assertThat(compressor.compress("aabafgaacaaaa"), is("2a1b1a1f1g2a1c4a"));
        assertThat(compressor.compress("HackerGym"), is("1H1a1c1k1e1r1G1y1m"));
        assertThat(compressor.compress("aaaaaaaaaa"), is("10a"));
    }

    @Test
    public void testDecompress() throws Exception {
        assertThat(compressor.decompress("2a1b1a1f1g2a1c4a"), is("aabafgaacaaaa"));
        assertThat(compressor.decompress("1H1a1c1k1e1r1G1y1m"), is("HackerGym"));
        assertThat(compressor.decompress("10a"), is("aaaaaaaaaa"));
        assertThat(compressor.decompress("10a11b12c"), is("aaaaaaaaaabbbbbbbbbbbcccccccccccc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecompressInvalidCompressedString() throws Exception {
        compressor.decompress("10ab");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecompressInvalidCompressedStringStart() throws Exception {
        compressor.decompress("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecompressInvalidCompressedStringEnd() throws Exception {
        compressor.decompress("a2");
    }

    @Test
    public void testCompressCustom() throws Exception {

        assertThat(compressor.compressCustom("aabafgaacaaaa"), is("2a1b1a1f1g2a1c4a"));
        assertThat(compressor.compressCustom("HackerGym"), is("1H1a1c1k1e1r1G1y1m"));
        assertThat(compressor.compressCustom("aaaaaaaaaa"), is("10a"));
    }

    @Test
    public void testDecompressCustom() throws Exception {
        assertThat(compressor.decompressCustom("2a1b1a1f1g2a1c4a"), is("aabafgaacaaaa"));
        assertThat(compressor.decompressCustom("1H1a1c1k1e1r1G1y1m"), is("HackerGym"));
        assertThat(compressor.decompressCustom("10a"), is("aaaaaaaaaa"));
        assertThat(compressor.decompressCustom("10a11b12c"), is("aaaaaaaaaabbbbbbbbbbbcccccccccccc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecompressCustomInvalidCompressedString() throws Exception {
        compressor.decompressCustom("10ab");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecompressCustomInvalidCompressedStringStart() throws Exception {
        compressor.decompressCustom("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecompressCustomInvalidCompressedStringEnd() throws Exception {
        compressor.decompressCustom("a2");
    }
}