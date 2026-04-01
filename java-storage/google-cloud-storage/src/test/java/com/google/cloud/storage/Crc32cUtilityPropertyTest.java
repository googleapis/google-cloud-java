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

import static com.google.common.truth.Truth.assertThat;

import com.google.common.hash.Hashing;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class Crc32cUtilityPropertyTest {
  @Property
  public void testCrc32cCombinePropertyTest(
      @ForAll byte[] firstObject, @ForAll byte[] secondObject) {
    int firstPartHash = Hashing.crc32c().hashBytes(firstObject).asInt();
    int secondPartHash = Hashing.crc32c().hashBytes(secondObject).asInt();
    int expected =
        Hashing.crc32c().newHasher().putBytes(firstObject).putBytes(secondObject).hash().asInt();
    int actual = Crc32cUtility.concatCrc32c(firstPartHash, secondPartHash, secondObject.length);
    assertThat(actual).isEqualTo(expected);
  }
}
