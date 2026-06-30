/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2;

import static com.google.common.truth.Truth.assertAbout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import io.grpc.Metadata;
import javax.annotation.Nullable;

/** Utility class to test key-value pairs in {@link io.grpc.Metadata}. */
public final class MetadataSubject extends Subject {

  @Nullable private final Metadata actual;

  public static Factory<MetadataSubject, Metadata> metadata() {
    return MetadataSubject::new;
  }

  private MetadataSubject(FailureMetadata metadata, @Nullable Metadata actual) {
    super(metadata, actual);
    this.actual = actual;
  }

  public static MetadataSubject assertThat(@Nullable Metadata actual) {
    return assertAbout(metadata()).that(actual);
  }

  public void containsAtLeast(String... keyValuePairs) {
    assert actual != null;
    for (int i = 0; i < keyValuePairs.length; i += 2) {
      check("containsAtLeast()")
          .that(actual.get(Metadata.Key.of(keyValuePairs[i], Metadata.ASCII_STRING_MARSHALLER)))
          .isEqualTo(keyValuePairs[i + 1]);
    }
  }

  public void doesNotContainKeys(String... keys) {
    assert actual != null;
    for (String key : keys) {
      check("doesNotContainKeys()")
          .that(actual.containsKey(Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER)))
          .isFalse();
    }
  }
}
