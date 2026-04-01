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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.hashMapOf;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobInfo.ObjectContexts;
import com.google.cloud.storage.BlobInfo.ObjectCustomContextPayload;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ITNestedUpdateMaskTest.NestedUpdateMaskParametersProvider;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * A set of tests to specifically test scenarios related to update handling of {@link
 * BlobInfo#getMetadata()} and {@link BucketInfo#getLabels()} and the various permutations which can
 * be used to add and remove keys.
 */
@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.PROD,
    transports = {Transport.HTTP, Transport.GRPC})
@Parameterized(NestedUpdateMaskParametersProvider.class)
public final class ITNestedUpdateMaskTest {

  @Inject public Generator generator;

  @Inject public Storage storage;

  @Inject public BucketInfo bucket;

  @Parameter public Param param;

  public static final class NestedUpdateMaskParametersProvider implements ParametersProvider {
    private static final Map<String, String> empty = ImmutableMap.of();
    private static final Map<String, String> k1a = ImmutableMap.of("k1", "a");
    private static final Map<String, String> k2b = ImmutableMap.of("k2", "b");
    private static final Map<String, String> k1z = ImmutableMap.of("k1", "z");
    private static final Map<String, String> k1a_k2b = ImmutableMap.of("k1", "a", "k2", "b");
    private static final Map<String, String> k1z_k2b = ImmutableMap.of("k1", "z", "k2", "b");
    private static final Map<String, String> k1a_k2null = hashMapOf("k1", "a", "k2", null);
    private static final Map<String, String> k1null = hashMapOf("k1", null);
    private static final Map<String, String> k2null = hashMapOf("k2", null);
    private static final Map<String, String> k1null_k2null = hashMapOf("k1", null, "k2", null);

    /**
     *
     *
     * <pre>
     * | base                | update               | expected            |
     * |---------------------|----------------------|---------------------|
     * | null                | {"k1":"a"}           | {"k1":"a"}          |
     * | {}                  | {"k1":"a"}           | {"k1":"a"}          |
     * | {"k1":"a"}          | {"k1":"a","k2":"b"}  | {"k1":"a","k2":"b"} |
     * | {"k1":"a"}          | {"k2":"b"}           | {"k1":"a","k2":"b"} |
     * | {"k1":"a","k2":"b"} | {"k1":"z","k2":"b"}  | {"k1":"z","k2":"b"} |
     * | {"k1":"a","k2":"b"} | {"k1":"z"}           | {"k1":"z","k2":"b"} |
     * | {"k1":"a","k2":"b"} | {"k1":"a","k2":null} | {"k1":"a"}          |
     * | {"k1":"a","k2":"b"} | {"k2":null}          | {"k1":"a"}          |
     * | {"k1":"a"}          | {}                   | null                |
     * | {"k1":"a"}          | {"k1":null}          | null                |
     * | {"k1":"a","k2":"b"} | null                 | null                |
     * | {"k1":"a","k2":"b"} | {"k1":null,"k2":null}| null                |
     * </pre>
     */
    @Override
    public ImmutableList<Param> parameters() {
      return ImmutableList.of(
          new Param("null to 1", null, k1a, k1a),
          new Param("empty to 1", empty, k1a, k1a),
          new Param("1 to 2 set", k1a, k1a_k2b, k1a_k2b),
          new Param("1 to 2 add", k1a, k2b, k1a_k2b),
          new Param("2 keys, modify 1 value (full)", k1a_k2b, k1z_k2b, k1z_k2b),
          new Param("2 keys, modify 1 value (fine)", k1a_k2b, k1z, k1z_k2b),
          new Param("2 keys, modify 1 null (full)", k1a_k2b, k1a_k2null, k1a),
          new Param("2 keys, modify 1 null (fine)", k1a_k2b, k2null, k1a),
          new Param("1 key, set empty", k1a, empty, null),
          new Param("1 key, null key", k1a, k1null, null),
          new Param("2 keys, set null (full)", k1a_k2b, null, null),
          new Param("2 keys, set null (fine)", k1a_k2b, k1null_k2null, null));
    }
  }

  @Test
  public void testBucketLabels() throws Exception {
    BucketInfo bucket = newBucketInfo(param.initial);
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucket).setStorage(storage).build()) {
      BucketInfo gen1 = tempB.getBucket();
      BucketInfo modified = gen1.toBuilder().setLabels(param.update).build();
      Bucket gen2 = storage.update(modified, BucketTargetOption.metagenerationMatch());
      assertThat(gen2.getLabels()).isEqualTo(param.expected);
    }
  }

  @Test
  public void testBlobMetadata() {
    BlobInfo blob = newBlobInfo(param.initial);
    Blob gen1 = storage.create(blob, BlobTargetOption.doesNotExist());
    BlobInfo modified = gen1.toBuilder().setMetadata(param.update).build();
    Blob gen2 = storage.update(modified, BlobTargetOption.metagenerationMatch());
    assertThat(gen2.getMetadata()).isEqualTo(param.expected);
  }

  @Test
  public void testBlobContexts() {
    ObjectContexts initial = contextsFromMap(param.initial);
    ObjectContexts update = contextsFromMap(param.update);
    ObjectContexts expected = contextsFromMap(param.expected);

    String blobName = generator.randomObjectName();
    BlobInfo.Builder builder = BlobInfo.newBuilder(bucket, blobName);
    if (initial != null) {
      builder.setContexts(initial);
    }
    BlobInfo info = builder.build();
    Blob gen1 = storage.create(info, BlobTargetOption.doesNotExist());

    BlobInfo modified = gen1.toBuilder().setContexts(update).build();
    Blob gen2 = storage.update(modified, BlobTargetOption.metagenerationMatch());
    assertContextsWithEqualValues(gen2.getContexts(), expected);
  }

  @Test
  public void testBlob_metadataAndContext() {
    ObjectContexts initial = contextsFromMap(param.initial);
    ObjectContexts update = contextsFromMap(param.update);
    ObjectContexts expected = contextsFromMap(param.expected);

    String blobName = generator.randomObjectName();
    BlobInfo.Builder builder = BlobInfo.newBuilder(bucket, blobName);
    if (initial != null) {
      builder.setContexts(initial);
    }
    if (param.initial != null) {
      builder.setMetadata(param.initial);
    }

    BlobInfo info = builder.build();
    Blob gen1 = storage.create(info, BlobTargetOption.doesNotExist());

    BlobInfo modified = gen1.toBuilder().setContexts(update).setMetadata(param.update).build();
    Blob gen2 = storage.update(modified, BlobTargetOption.metagenerationMatch());
    assertContextsWithEqualValues(gen2.getContexts(), expected);
    assertThat(gen2.getMetadata()).isEqualTo(param.expected);
  }

  private static void assertContextsWithEqualValues(
      @Nullable ObjectContexts actual, @Nullable ObjectContexts expected) {
    if (expected != null && !expected.getCustom().isEmpty() && actual != null) {
      Map<String, ObjectCustomContextPayload> actualCustom = actual.getCustom();
      Map<String, ObjectCustomContextPayload> expectedCustom = expected.getCustom();

      Map<String, String> actualValues =
          Maps.transformValues(actualCustom, ObjectCustomContextPayload::getValue);
      Map<String, String> expectedValues =
          Maps.transformValues(expectedCustom, ObjectCustomContextPayload::getValue);

      assertThat(actualValues).isEqualTo(expectedValues);
    } else {
      assertThat(actual).isEqualTo(expected);
    }
  }

  private BlobInfo newBlobInfo(Map<String, String> metadata) {
    String blobName = generator.randomObjectName();
    BlobInfo.Builder builder = BlobInfo.newBuilder(bucket, blobName);
    if (metadata != null) {
      builder.setMetadata(metadata);
    }
    return builder.build();
  }

  private BucketInfo newBucketInfo(Map<String, String> metadata) {
    BucketInfo.Builder builder = BucketInfo.newBuilder(generator.randomBucketName());
    if (metadata != null) {
      builder.setLabels(metadata);
    }
    return builder.build();
  }

  private @Nullable ObjectContexts contextsFromMap(
      @Nullable Map<@NonNull String, @Nullable String> m) {
    if (m == null) {
      return null;
    }
    Map<@NonNull String, ObjectCustomContextPayload> transformed =
        Maps.transformValues(
            m, v -> v == null ? null : ObjectCustomContextPayload.newBuilder().setValue(v).build());
    return ObjectContexts.newBuilder().setCustom(transformed).build();
  }

  private static final class Param {
    private final String description;
    @Nullable private final Map<@NonNull String, @Nullable String> initial;
    @Nullable private final Map<@NonNull String, @Nullable String> update;
    @Nullable private final Map<@NonNull String, @Nullable String> expected;

    private Param(
        String description,
        @Nullable Map<@NonNull String, @Nullable String> initial,
        @Nullable Map<@NonNull String, @Nullable String> update,
        @Nullable Map<@NonNull String, @Nullable String> expected) {
      requireNonNull(description, "description must be non null");
      this.description = description;
      this.initial = initial;
      this.update = update;
      this.expected = expected;
    }

    @Override
    public String toString() {
      return description;
    }
  }
}
