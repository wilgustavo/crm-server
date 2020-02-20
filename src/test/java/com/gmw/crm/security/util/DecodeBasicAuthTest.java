package com.gmw.crm.security.util;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.BadCredentialsException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DecodeBasicAuthTest {

    @Test
    public void shouldThrowsErrorsIfEmpty() {
        assertThrows(BadCredentialsException.class, () -> {
           String[] result = DecodeBasicAuth.decode("");
        });
    }

    @Test
    public void shouldThrowsErrorsIfNotStartWithBearer() {
        assertThrows(BadCredentialsException.class, () -> {
            String[] result = DecodeBasicAuth.decode("abc123");
        });
    }

    @Test
    public void shouldThrowsErrorsIfNotEncryptWithBase64() {
        assertThrows(BadCredentialsException.class, () -> {
            String[] result = DecodeBasicAuth.decode("Basic abc123");
        });
    }

    @Test
    public void shouldThrowErrorIfNoSeparator() {
        assertThrows(BadCredentialsException.class, () -> {
            String[] result = DecodeBasicAuth.decode("Basic YWJjMTIz");
        });
    }

    @Test
    public void shouldReturnUserAndPassword() {
        assertThat(DecodeBasicAuth.decode("Basic VVNFUjphYmMxMjM"), is(new String[] {"USER", "abc123"}));
        assertThat(DecodeBasicAuth.decode("Basic VVNFUjo"), is(new String[] {"USER", ""}));
        assertThat(DecodeBasicAuth.decode("Basic OmFiYzEyMw"), is(new String[] {"", "abc123"}));
        assertThat(DecodeBasicAuth.decode("Basic VVNFUjphYmM6MTIz"), is(new String[] {"USER", "abc:123"}));
        assertThat(DecodeBasicAuth.decode("Basic VVNFUjrjgZPjgpPjgavjgaHjga/kuJbnlYw"), is(new String[] {"USER", "こんにちは世界"}));
    }

}