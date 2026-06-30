/*
 * Copyright 2025 Google LLC
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
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.Conversions.Codec;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.Test;

public final class GrpcUtilsTest {

  @Test
  public void closeAll_noNpeIfNullStream() throws IOException {
    GrpcUtils.closeAll(Collections.singletonList(null));
  }

  @Test
  public void projectNumberResourceCodec_simple() {
    Codec<@NonNull BigInteger, @NonNull String> codec = Utils.projectNumberResourceCodec;

    String encode = codec.encode(new BigInteger("34567892123"));
    assertThat(encode).isEqualTo("projects/34567892123");

    BigInteger decode = codec.decode(encode);
    assertThat(decode).isEqualTo(new BigInteger("34567892123"));
  }

  @Test
  public void projectNumberResourceCodec_decode_illegalArgumentException_whenUnParsable() {
    String bad = "not-a-projects/123081892932";
    IllegalArgumentException iae =
        assertThrows(
            IllegalArgumentException.class, () -> Utils.projectNumberResourceCodec.decode(bad));

    assertThat(iae).hasMessageThat().contains(bad);
  }

  @Test
  public void projectNumberResourceCodec_decode_nonNull() {
    assertThrows(NullPointerException.class, () -> Utils.projectNumberResourceCodec.decode(null));
  }

  @Test
  public void projectNumberResourceCodec_encode_nonNull() {
    assertThrows(NullPointerException.class, () -> Utils.projectNumberResourceCodec.encode(null));
  }

  @Test
  public void projectNumberResourceCodec_decode_notProjectNumber() {
    String bad = "projects/not-a-number";
    assertThrows(NumberFormatException.class, () -> Utils.projectNumberResourceCodec.decode(bad));
  }
}
