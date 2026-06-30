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

import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.ifNonNull;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.Conversions.Codec;
import com.google.cloud.storage.jqwik.StorageArbitraries;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.Object;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ArbitrarySupplier;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

final class BlobIdPropertyTest {

  @Property
  void codecRoundTrip(@ForAll(supplier = ObjectRefs.class) Object message) {
    Codec<BlobId, Object> codec = Conversions.grpc().blobId();
    BlobId model = codec.decode(message);
    Object proto = codec.encode(model);

    assertThat(proto).isEqualTo(message);
  }

  @Property
  void codecCompatibilityRoundTrip(@ForAll(supplier = ObjectRefs.class) Object p) {
    Codec<BlobId, Object> codecG = Conversions.grpc().blobId();
    Codec<BlobId, StorageObject> codecA = Conversions.json().blobId();

    BlobId model = codecG.decode(p);

    StorageObject apiary = codecA.encode(model);
    BlobId model2 = codecA.decode(apiary);

    Object actual = codecG.encode(model2);

    assertThat(actual).isEqualTo(p);
  }

  private static final class ObjectRefs implements ArbitrarySupplier<Object> {

    @Override
    public Arbitrary<Object> get() {
      return Combinators.combine(
              StorageArbitraries.objects().name(),
              StorageArbitraries.buckets().name(),
              StorageArbitraries.generation().injectNull(0.5))
          .as(
              (n, b, g) -> {
                Object.Builder out = Object.newBuilder();
                ifNonNull(n, out::setName);
                ifNonNull(b, BucketName::toString, out::setBucket);
                ifNonNull(g, out::setGeneration);
                return out.build();
              });
    }
  }
}
