/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.storage;

import com.google.common.hash.Hashing;
import org.junit.Assert;
import org.junit.Test;

public class Crc32cUtilityTest {
  @Test
  public void testCrc32cCombine() {
    // crc32c("helloworld") -> 0x3D082299
    int expected = 0x56CBB480;
    // crc32c("hello") -> 0x9A71BB4C
    int object1_hash = 0x9A71BB4C;
    // crc32c("world") -> 0x31AA814E
    int object2_hash = 0x31AA814E;
    // length("world") -> 5
    int object2_size = 5;
    int combined = Crc32cUtility.concatCrc32c(object1_hash, object2_hash, object2_size);
    Assert.assertEquals(expected, combined);
  }

  @Test
  public void testCrc32cCombineGuavaValues() {
    final String hello = "hello";
    final String world = "world";
    final String helloWorld = hello + world;
    int expected = Hashing.crc32c().hashBytes(helloWorld.getBytes()).asInt();
    int object1Hash = Hashing.crc32c().hashBytes(hello.getBytes()).asInt();
    int object2Hash = Hashing.crc32c().hashBytes(world.getBytes()).asInt();
    int combined = Crc32cUtility.concatCrc32c(object1Hash, object2Hash, world.length());
    Assert.assertEquals(expected, combined);
  }
}
