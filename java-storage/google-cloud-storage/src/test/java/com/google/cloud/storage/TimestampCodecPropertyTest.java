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

import static com.google.cloud.storage.JqwikTest.report;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Conversions.Codec;
import com.google.cloud.storage.jqwik.StorageArbitraries;
import com.google.protobuf.Timestamp;
import java.time.OffsetDateTime;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ArbitrarySupplier;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.providers.TypeUsage;

final class TimestampCodecPropertyTest {

  @Example
  void edgeCases() {
    report(TypeUsage.of(Timestamp.class), StorageArbitraries.timestamp());
  }

  @Property
  void timestampCodecShouldRoundTrip(@ForAll(supplier = Supp.class) Timestamp ts) {
    Codec<OffsetDateTime, Timestamp> codec = GrpcConversions.INSTANCE.timestampCodec;
    OffsetDateTime decode = codec.decode(ts);
    Timestamp encode = codec.encode(decode);

    assertThat(encode).isEqualTo(ts);
  }

  private static final class Supp implements ArbitrarySupplier<Timestamp> {
    @Override
    public Arbitrary<Timestamp> get() {
      return StorageArbitraries.timestamp();
    }
  }
}
