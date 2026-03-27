/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.google.cloud.spanner.AbstractResultSet.LazyByteArray;
import java.util.Base64;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LazyByteArrayTest {

  @Test
  public void testEqualsAndHashCode() {
    Random random = new Random();
    byte[] bytes1 = new byte[random.nextInt(300) + 300];
    // Make sure the second byte array has a different length than the first to be absolutely sure
    // that they can never contain the same value.
    byte[] bytes2 = new byte[bytes1.length + 1];
    random.nextBytes(bytes1);
    random.nextBytes(bytes2);

    LazyByteArray lazyByteArray1 = new LazyByteArray(Base64.getEncoder().encodeToString(bytes1));
    LazyByteArray lazyByteArray2 = new LazyByteArray(Base64.getEncoder().encodeToString(bytes2));
    LazyByteArray lazyByteArray3 = new LazyByteArray(Base64.getEncoder().encodeToString(bytes1));

    assertEquals(lazyByteArray1, lazyByteArray3);
    assertNotEquals(lazyByteArray1, lazyByteArray2);
    assertNotEquals(lazyByteArray2, lazyByteArray3);

    assertEquals(lazyByteArray1.hashCode(), lazyByteArray3.hashCode());
  }
}
