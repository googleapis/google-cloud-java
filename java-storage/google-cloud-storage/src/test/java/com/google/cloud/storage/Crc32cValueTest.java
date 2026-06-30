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

import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthUnknown;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import net.jqwik.api.Example;
import org.checkerframework.checker.nullness.qual.NonNull;

final class Crc32cValueTest {

  @Example
  public void ensureConcatenationOfTwoValuesOnlyWorksWhenTheLengthIsKnownForRightHandSide() {
    Crc32cValue.of(1).concat(Crc32cValue.of(2, 1L));
  }

  @Example
  public void ensureConcatSatisfiesTheLeftDistributedProperty() {
    HashFunction f = Hashing.crc32c();

    int expected =
        f.hashBytes(
                new byte[] {
                  0x00, 0x01, 0x02, 0x03,
                  0x04, 0x05, 0x06, 0x07,
                  0x08, 0x09, 0x0a, 0x0b,
                  0x0c, 0x0d, 0x0e, 0x0f
                })
            .asInt();
    int a = f.hashBytes(new byte[] {0x00, 0x01, 0x02, 0x03}).asInt();
    int b = f.hashBytes(new byte[] {0x04, 0x05, 0x06, 0x07}).asInt();
    int c = f.hashBytes(new byte[] {0x08, 0x09, 0x0a, 0x0b}).asInt();
    int d = f.hashBytes(new byte[] {0x0c, 0x0d, 0x0e, 0x0f}).asInt();

    Crc32cLengthUnknown A = Crc32cValue.of(a);
    Crc32cLengthKnown B = Crc32cValue.of(b, 4);
    Crc32cLengthKnown C = Crc32cValue.of(c, 4);
    Crc32cLengthKnown D = Crc32cValue.of(d, 4);

    Crc32cLengthKnown BC = B.concat(C);
    Crc32cLengthKnown BCD = BC.concat(D);
    Crc32cLengthUnknown ABCD = A.concat(BCD);

    Crc32cValue<?> chain = A.concat(B).concat(C).concat(D);
    Crc32cValue<?> nesting = A.concat(B.concat(C.concat(D)));
    Crc32cValue<?> mixed = A.concat(B.concat(C)).concat(D);

    assertThat(ABCD.getValue()).isEqualTo(expected);
    assertThat(chain.getValue()).isEqualTo(expected);
    assertThat(nesting.getValue()).isEqualTo(expected);
    assertThat(mixed.getValue()).isEqualTo(expected);
  }

  @Example
  void zeroDoesNotTransform() {
    Crc32cLengthKnown base =
        Hasher.enabled().hash(DataGenerator.base64Characters().genByteBuffer(64));

    assertThat(base.concat(Crc32cValue.zero())).isSameInstanceAs(base);
    assertThat(Crc32cValue.zero().concat(base)).isSameInstanceAs(base);
  }

  @Example
  void nullSafeConcat_isAlwaysNull() {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(2 * 1024 * 1024));

    Crc32cLengthKnown actual =
        testContent.chunkup(373).stream()
            .map(Crc32cValueTest::toCrc32cValue)
            .reduce(null, Hasher.enabled()::nullSafeConcat);

    assertThat(actual).isNull();
  }

  private static @NonNull Crc32cLengthKnown toCrc32cValue(ChecksummedTestContent testContent) {
    return Crc32cValue.of(testContent.getCrc32c(), testContent.getBytes().length);
  }
}
