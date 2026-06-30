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

import com.google.cloud.storage.Conversions.Codec;
import com.google.cloud.storage.jqwik.StorageArbitraries;
import com.google.protobuf.Duration;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ArbitrarySupplier;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

final class DurationCodecPropertyTest {

  @Property
  void timestampCodecShouldRoundTrip(@ForAll(supplier = Supp.class) Duration ts) {
    Codec<java.time.Duration, Duration> codec = GrpcConversions.INSTANCE.durationCodec;
    java.time.Duration decode = codec.decode(ts);
    Duration encode = codec.encode(decode);

    assertThat(encode).isEqualTo(ts);
  }

  private static final class Supp implements ArbitrarySupplier<Duration> {
    @Override
    public Arbitrary<Duration> get() {
      return StorageArbitraries.duration();
    }
  }
}
