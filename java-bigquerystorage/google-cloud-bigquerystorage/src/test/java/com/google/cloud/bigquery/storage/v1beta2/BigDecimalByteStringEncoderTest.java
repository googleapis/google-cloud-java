/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.protobuf.ByteString;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BigDecimalByteStringEncoderTest {
  @Test
  void testEncodeBigDecimalandEncodeByteString() {
    BigDecimal testBD = new BigDecimal("0"); // expected result bd
    ByteString testBS =
        BigDecimalByteStringEncoder.encodeToNumericByteString(testBD); // convert expected to bs
    BigDecimal resultBD =
        BigDecimalByteStringEncoder.decodeNumericByteString(testBS); // convert bs to bd
    assertEquals(0, resultBD.compareTo(testBD)); // ensure converted bd is equal to expected bd

    testBD = new BigDecimal("1.2");
    testBS = BigDecimalByteStringEncoder.encodeToNumericByteString(testBD);
    resultBD = BigDecimalByteStringEncoder.decodeNumericByteString(testBS);
    assertEquals(0, resultBD.compareTo(testBD)); // ensure converted bd is equal to expected bd

    testBD = new BigDecimal("-1.2");
    testBS = BigDecimalByteStringEncoder.encodeToNumericByteString(testBD);
    resultBD = BigDecimalByteStringEncoder.decodeNumericByteString(testBS);
    assertEquals(0, resultBD.compareTo(testBD)); // ensure converted bd is equal to expected bd

    testBD = new BigDecimal("99999999999999999999999999999.999999999");
    testBS = BigDecimalByteStringEncoder.encodeToNumericByteString(testBD);
    resultBD = BigDecimalByteStringEncoder.decodeNumericByteString(testBS);
    assertEquals(0, resultBD.compareTo(testBD)); // ensure converted bd is equal to expected bd

    testBD = new BigDecimal("-99999999999999999999999999999.999999999");
    testBS = BigDecimalByteStringEncoder.encodeToNumericByteString(testBD);
    resultBD = BigDecimalByteStringEncoder.decodeNumericByteString(testBS);
    assertEquals(0, resultBD.compareTo(testBD)); // ensure converted bd is equal to expected bd
  }
}
