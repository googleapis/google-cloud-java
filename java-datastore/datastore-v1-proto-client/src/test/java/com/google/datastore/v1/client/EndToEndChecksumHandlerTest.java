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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static java.nio.charset.StandardCharsets.UTF_8;





import org.junit.jupiter.api.Test;



/** Test for {@link EndToEndChecksumHandler}. */

class EndToEndChecksumHandlerTest {
  private final byte[] payloadBytes =
      "This is a long string with numbers 1234, 134.56 ".getBytes(UTF_8);
  private final byte[] payloadForUnsignedLongChecksum = "aaa".getBytes(UTF_8);
  private final String unsignedLongChecksum = "3818383321";

  @Test
  void validateChecksum_correctChecksum() {
    String computed = EndToEndChecksumHandler.computeChecksum(payloadBytes);
    assertTrue(EndToEndChecksumHandler.validateChecksum(computed, payloadBytes));
  }

  @Test
  void computeChecksum_returnsUnsignedLongAsStringValue() {
    String computed = EndToEndChecksumHandler.computeChecksum(payloadForUnsignedLongChecksum);
    assertEquals(unsignedLongChecksum, computed, "computeChecksum return value");
  }

  @Test
  void validateChecksum_incorrectChecksum() {
    String computed = EndToEndChecksumHandler.computeChecksum("random string".getBytes(UTF_8));
    assertFalse(EndToEndChecksumHandler.validateChecksum(computed, payloadBytes));
  }

  @Test
  void validateChecksum_nullChecksum() {
    assertFalse(EndToEndChecksumHandler.validateChecksum(null, payloadBytes));
  }

  @Test
  void validateChecksum_emptyChecksum() {
    assertFalse(EndToEndChecksumHandler.validateChecksum("", payloadBytes));
  }

  @Test
  void validateChecksum_nullPayload() {
    assertFalse(EndToEndChecksumHandler.validateChecksum("foo", null));
  }

  @Test
  void validateChecksum_emptyPayload() {
    assertFalse(EndToEndChecksumHandler.validateChecksum("foo", new byte[0]));
  }

  @Test
  void computeChecksum_nullInputBytes() {
    assertNull(EndToEndChecksumHandler.computeChecksum(null));
  }

  @Test
  void computeChecksum_emptyArrayForInputBytes() {
    assertNull(EndToEndChecksumHandler.computeChecksum(new byte[0]));
  }
}
