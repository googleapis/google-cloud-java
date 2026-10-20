/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.Base64;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class UnauthenticatedExceptionTest {

  /**
   * An {@link UnauthenticatedException} with message "serialized by released gax", no cause, an
   * empty stack trace, retryable {@code true} and a {@link SerializableStatusCode} of
   * UNAUTHENTICATED, Java-serialized with the released gax 2.87.0 jar.
   */
  private static final String SERIALIZED_BY_GAX_2_87_0 =
      "rO0ABXNyAC9jb20uZ29vZ2xlLmFwaS5nYXgucnBjLlVuYXV0aGVudGljYXRlZEV4Y2VwdGlvbmC+YDhKxcJlAgAAeHIAI2NvbS5nb29nbGUuYXBpLmdheC5ycGMuQXBpRXhjZXB0aW9uw0h4sCzSVFQCAANaAAlyZXRyeWFibGVMAAxlcnJvckRldGFpbHN0ACVMY29tL2dvb2dsZS9hcGkvZ2F4L3JwYy9FcnJvckRldGFpbHM7TAAKc3RhdHVzQ29kZXQAI0xjb20vZ29vZ2xlL2FwaS9nYXgvcnBjL1N0YXR1c0NvZGU7eHIAGmphdmEubGFuZy5SdW50aW1lRXhjZXB0aW9unl8GRwo0g+UCAAB4cgATamF2YS5sYW5nLkV4Y2VwdGlvbtD9Hz4aOxzEAgAAeHIAE2phdmEubGFuZy5UaHJvd2FibGXVxjUnOXe4ywMABEwABWNhdXNldAAVTGphdmEvbGFuZy9UaHJvd2FibGU7TAANZGV0YWlsTWVzc2FnZXQAEkxqYXZhL2xhbmcvU3RyaW5nO1sACnN0YWNrVHJhY2V0AB5bTGphdmEvbGFuZy9TdGFja1RyYWNlRWxlbWVudDtMABRzdXBwcmVzc2VkRXhjZXB0aW9uc3QAEExqYXZhL3V0aWwvTGlzdDt4cHB0ABpzZXJpYWxpemVkIGJ5IHJlbGVhc2VkIGdheHVyAB5bTGphdmEubGFuZy5TdGFja1RyYWNlRWxlbWVudDsCRio8PP0iOQIAAHhwAAAAAHNyAB9qYXZhLnV0aWwuQ29sbGVjdGlvbnMkRW1wdHlMaXN0ergXtDynnt4CAAB4cHgBcHNyAEpjb20uZ29vZ2xlLmFwaS5nYXgucnBjLlVuYXV0aGVudGljYXRlZEV4Y2VwdGlvblRlc3QkU2VyaWFsaXphYmxlU3RhdHVzQ29kZQAAAAAAAAABAgABTAAEY29kZXQAKExjb20vZ29vZ2xlL2FwaS9nYXgvcnBjL1N0YXR1c0NvZGUkQ29kZTt4cH5yACZjb20uZ29vZ2xlLmFwaS5nYXgucnBjLlN0YXR1c0NvZGUkQ29kZQAAAAAAAAAAEgAAeHIADmphdmEubGFuZy5FbnVtAAAAAAAAAAASAAB4cHQAD1VOQVVUSEVOVElDQVRFRA==";

  /** A serializable {@link StatusCode}, since the transport implementations are not. */
  static final class SerializableStatusCode implements StatusCode, Serializable {
    private static final long serialVersionUID = 1L;
    private final Code code;

    SerializableStatusCode(Code code) {
      this.code = code;
    }

    @Override
    public Code getCode() {
      return code;
    }

    @Override
    public Object getTransportCode() {
      return code.name();
    }
  }

  @Test
  void publicConstructors_areNotChannelRefreshed() {
    StatusCode statusCode = FakeStatusCode.of(StatusCode.Code.UNAUTHENTICATED);
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(Collections.emptyList()).build();

    assertThat(new UnauthenticatedException(null, statusCode, true).isChannelRefreshed()).isFalse();
    assertThat(new UnauthenticatedException("msg", null, statusCode, true).isChannelRefreshed())
        .isFalse();
    assertThat(
            new UnauthenticatedException(null, statusCode, true, errorDetails).isChannelRefreshed())
        .isFalse();
    assertThat(
            new UnauthenticatedException("msg", null, statusCode, true, errorDetails)
                .isChannelRefreshed())
        .isFalse();
  }

  @Test
  void withChannelRefreshed_preservesFields() {
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(Collections.emptyList()).build();
    IllegalStateException cause = new IllegalStateException("root cause");
    StatusCode statusCode = FakeStatusCode.of(StatusCode.Code.UNAUTHENTICATED);
    UnauthenticatedException original =
        new UnauthenticatedException("Expired cert", cause, statusCode, false, errorDetails);
    original.setStackTrace(
        new StackTraceElement[] {new StackTraceElement("foo", "bar", "Baz.java", 123)});
    RuntimeException suppressed = new RuntimeException("suppressed");
    original.addSuppressed(suppressed);

    UnauthenticatedException refreshed = original.withChannelRefreshed();

    assertThat(refreshed).isNotSameInstanceAs(original);
    assertThat(refreshed.isChannelRefreshed()).isTrue();
    assertThat(original.isChannelRefreshed()).isFalse();
    assertThat(refreshed.getMessage()).isEqualTo(original.getMessage());
    assertThat(refreshed.getCause()).isSameInstanceAs(cause);
    assertThat(refreshed.getStatusCode()).isSameInstanceAs(statusCode);
    assertThat(refreshed.getErrorDetails()).isSameInstanceAs(errorDetails);
    assertThat(refreshed.getStackTrace()).isEqualTo(original.getStackTrace());
    assertThat(refreshed.getSuppressed()).asList().containsExactly(suppressed);
  }

  @Test
  void withChannelRefreshed_keepsIsRetryable() {
    StatusCode statusCode = FakeStatusCode.of(StatusCode.Code.UNAUTHENTICATED);

    assertThat(
            new UnauthenticatedException("msg", null, statusCode, false)
                .withChannelRefreshed()
                .isRetryable())
        .isFalse();
    assertThat(
            new UnauthenticatedException("msg", null, statusCode, true)
                .withChannelRefreshed()
                .isRetryable())
        .isTrue();
  }

  @Test
  void serialVersionUID_matchesReleasedValue() {
    // gax 2.83.0 to 2.87.0 did not declare a serialVersionUID; this is the value the JVM computed
    // for them. Keeping it avoids InvalidClassException across versions.
    assertThat(ObjectStreamClass.lookup(UnauthenticatedException.class).getSerialVersionUID())
        .isEqualTo(6971115068105015909L);
  }

  @Test
  void deserializesExceptionSerializedByReleasedGax() throws Exception {
    Object deserialized = deserialize(Base64.getDecoder().decode(SERIALIZED_BY_GAX_2_87_0));

    assertThat(deserialized).isInstanceOf(UnauthenticatedException.class);
    UnauthenticatedException ex = (UnauthenticatedException) deserialized;
    assertThat(ex.getMessage()).isEqualTo("serialized by released gax");
    assertThat(ex.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAUTHENTICATED);
    assertThat(ex.isRetryable()).isTrue();
    assertThat(ex.isChannelRefreshed()).isFalse();
  }

  @Test
  void withChannelRefreshed_flagNotSerialized() throws Exception {
    UnauthenticatedException refreshed =
        new UnauthenticatedException(
                "msg", null, new SerializableStatusCode(StatusCode.Code.UNAUTHENTICATED), false)
            .withChannelRefreshed();

    UnauthenticatedException roundTripped =
        (UnauthenticatedException) deserialize(serialize(refreshed));

    assertThat(roundTripped.getMessage()).isEqualTo("msg");
    assertThat(roundTripped.isRetryable()).isFalse();
    assertThat(roundTripped.isChannelRefreshed()).isFalse();
  }

  private static byte[] serialize(Object object) throws Exception {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream out = new ObjectOutputStream(bytes)) {
      out.writeObject(object);
    }
    return bytes.toByteArray();
  }

  private static Object deserialize(byte[] bytes) throws Exception {
    try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
      return in.readObject();
    }
  }
}
