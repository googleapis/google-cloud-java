/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test for {@link EndToEndChecksumHandler}. */
@RunWith(JUnit4.class)
public class EndToEndChecksumHandlerTest {
  private final byte[] payloadBytes =
      "This is a long string with numbers 1234, 134.56 ".getBytes(UTF_8);
  private final byte[] payloadForUnsignedLongChecksum = "aaa".getBytes(UTF_8);
  private final String unsignedLongChecksum = "3818383321";

  @Test
  public void validateChecksum_correctChecksum() {
    String computed = EndToEndChecksumHandler.computeChecksum(payloadBytes);
    assertTrue(EndToEndChecksumHandler.validateChecksum(computed, payloadBytes));
  }

  @Test
  public void computeChecksum_returnsUnsignedLongAsStringValue() {
    String computed = EndToEndChecksumHandler.computeChecksum(payloadForUnsignedLongChecksum);
    assertEquals("computeChecksum return value", unsignedLongChecksum, computed);
  }

  @Test
  public void validateChecksum_incorrectChecksum() {
    String computed = EndToEndChecksumHandler.computeChecksum("random string".getBytes(UTF_8));
    assertFalse(EndToEndChecksumHandler.validateChecksum(computed, payloadBytes));
  }

  @Test
  public void validateChecksum_nullChecksum() {
    assertFalse(EndToEndChecksumHandler.validateChecksum(null, payloadBytes));
  }

  @Test
  public void validateChecksum_emptyChecksum() {
    assertFalse(EndToEndChecksumHandler.validateChecksum("", payloadBytes));
  }

  @Test
  public void validateChecksum_nullPayload() {
    assertFalse(EndToEndChecksumHandler.validateChecksum("foo", null));
  }

  @Test
  public void validateChecksum_emptyPayload() {
    assertFalse(EndToEndChecksumHandler.validateChecksum("foo", new byte[0]));
  }

  @Test
  public void computeChecksum_nullInputBytes() {
    assertNull(EndToEndChecksumHandler.computeChecksum(null));
  }

  @Test
  public void computeChecksum_emptyArrayForInputBytes() {
    assertNull(EndToEndChecksumHandler.computeChecksum(new byte[0]));
  }
}
