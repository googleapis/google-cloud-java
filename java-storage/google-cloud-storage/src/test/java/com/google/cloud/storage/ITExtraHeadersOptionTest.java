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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.paging.Page;
import com.google.cloud.ReadChannel;
import com.google.cloud.ServiceOptions;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.AssertRequestHeaders;
import com.google.cloud.storage.it.AssertRequestHeaders.FilteringPolicy;
import com.google.cloud.storage.it.GrpcRequestAuditing;
import com.google.cloud.storage.it.RequestAuditing;
import com.google.cloud.storage.it.TemporaryBucket;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteStreams;
import com.google.common.truth.IterableSubject;
import io.grpc.ClientInterceptor;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITExtraHeadersOptionTest {

  private static final String HEADER_NAME = "x-my-header";
  private static final String HEADER_VALUE = "value";
  private static final ImmutableMap<String, String> EXTRA_HEADERS =
      ImmutableMap.of(HEADER_NAME, HEADER_VALUE);
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;
  @Inject public Storage baseStorage;
  @Inject public Transport transport;

  private Storage storage;
  private AssertRequestHeaders headers;

  @Before
  public void setUp() throws Exception {
    switch (transport) {
      case HTTP:
        RequestAuditing requestAuditing = new RequestAuditing();
        headers = requestAuditing;
        storage =
            ((HttpStorageOptions) baseStorage.getOptions())
                .toBuilder()
                    .setTransportOptions(requestAuditing)
                    // we're counting requests, disable retries so that if a request fails it won't
                    // show up as a bad assertion of the test itself
                    .setRetrySettings(ServiceOptions.getNoRetrySettings())
                    .build()
                    .getService();
        break;
      case GRPC:
        GrpcRequestAuditing grpcRequestAuditing = new GrpcRequestAuditing();
        headers = grpcRequestAuditing;
        GrpcStorageOptions grpcStorageOptions = (GrpcStorageOptions) baseStorage.getOptions();
        GrpcInterceptorProvider grpcInterceptorProvider =
            grpcStorageOptions.getGrpcInterceptorProvider();
        storage =
            grpcStorageOptions.toBuilder()
                // we're counting requests, disable retries so that if a request fails it won't
                // show up as a bad assertion of the test itself
                .setRetrySettings(ServiceOptions.getNoRetrySettings())
                .setGrpcInterceptorProvider(
                    () -> {
                      List<ClientInterceptor> interceptors =
                          grpcInterceptorProvider.getInterceptors();
                      return ImmutableList.<ClientInterceptor>builder()
                          .addAll(interceptors)
                          .add(grpcRequestAuditing)
                          .build();
                    })
                .build()
                .getService();
        break;
    }
  }

  @After
  public void tearDown() throws Exception {
    if (storage != null) {
      storage.close();
    }
  }

  @Test
  public void simpleUnary() throws Exception {
    Bucket gen1 = storage.get(bucket.getName(), BucketGetOption.extraHeaders(EXTRA_HEADERS));

    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);
    assertAll(() -> subject.containsExactly(HEADER_VALUE));
  }

  @Test
  public void pageObjects() throws Exception {
    String baseName = generator.randomObjectName();
    Blob blob1 = storage.create(BlobInfo.newBuilder(bucket, baseName + "1").build());
    Blob blob2 = storage.create(BlobInfo.newBuilder(bucket, baseName + "2").build());

    headers.clear();
    ImmutableList<String> expectedNames = ImmutableList.of(blob1.getName(), blob2.getName());
    Page<Blob> page =
        storage.list(
            bucket.getName(),
            BlobListOption.prefix(baseName),
            BlobListOption.pageSize(1),
            BlobListOption.extraHeaders(EXTRA_HEADERS));

    List<String> collect = page.streamAll().map(BlobInfo::getName).collect(Collectors.toList());
    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);
    assertAll(
        () -> assertThat(collect).hasSize(2),
        () -> assertThat(collect).containsExactlyElementsIn(expectedNames),
        () -> subject.containsExactly(HEADER_VALUE, HEADER_VALUE));
  }

  @Test
  public void pageBucket() throws Exception {
    String baseName = generator.randomBucketName();
    BucketInfo info1 = BucketInfo.of(baseName + "1");
    BucketInfo info2 = BucketInfo.of(baseName + "2");
    try (TemporaryBucket tmp1 =
            TemporaryBucket.newBuilder().setBucketInfo(info1).setStorage(storage).build();
        TemporaryBucket tmp2 =
            TemporaryBucket.newBuilder().setBucketInfo(info2).setStorage(storage).build()) {
      headers.clear();
      Page<Bucket> page =
          storage.list(
              BucketListOption.prefix(baseName),
              BucketListOption.pageSize(1),
              BucketListOption.extraHeaders(EXTRA_HEADERS));

      List<String> collect = page.streamAll().map(BucketInfo::getName).collect(Collectors.toList());
      IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);
      assertAll(
          () -> assertThat(collect).containsExactly(info1.getName(), info2.getName()),
          () -> subject.containsExactly(HEADER_VALUE, HEADER_VALUE));
    }
  }

  @Test
  public void readAllBytes() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    Blob gen1 =
        storage.create(
            BlobInfo.newBuilder(bucket, generator.randomObjectName()).build(),
            expected,
            BlobTargetOption.doesNotExist());

    headers.clear();
    byte[] actual =
        storage.readAllBytes(
            gen1.getBlobId(),
            BlobSourceOption.generationMatch(),
            BlobSourceOption.extraHeaders(EXTRA_HEADERS));
    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);
    String actualXxd = xxd(actual);

    assertAll(
        () -> subject.containsExactly(HEADER_VALUE),
        () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  public void reader() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    Blob gen1 =
        storage.create(
            BlobInfo.newBuilder(bucket, generator.randomObjectName()).build(),
            expected,
            BlobTargetOption.doesNotExist());

    headers.clear();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ReadChannel reader =
        storage.reader(
            gen1.getBlobId(),
            BlobSourceOption.generationMatch(),
            BlobSourceOption.extraHeaders(EXTRA_HEADERS))) {
      ByteStreams.copy(reader, Channels.newChannel(baos));
    }
    byte[] actual = baos.toByteArray();
    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);
    String actualXxd = xxd(actual);

    assertAll(
        () -> subject.containsExactly(HEADER_VALUE),
        () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  public void directUpload() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    headers.clear();
    Blob gen1 =
        storage.create(
            info,
            expected,
            BlobTargetOption.doesNotExist(),
            BlobTargetOption.extraHeaders(EXTRA_HEADERS));
    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);

    byte[] actual = storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.generationMatch());
    String actualXxd = xxd(actual);

    assertAll(
        () -> subject.containsExactly(HEADER_VALUE),
        () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  public void resumableUpload() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    try (WriteChannel writer =
        storage.writer(
            info, BlobWriteOption.doesNotExist(), BlobWriteOption.extraHeaders(EXTRA_HEADERS))) {
      writer.setChunkSize(256 * 1024);
      writer.write(ByteBuffer.wrap(Arrays.copyOfRange(expected, 0, 256 * 1024)));
      writer.write(ByteBuffer.wrap(Arrays.copyOfRange(expected, 256 * 1024, 512 * 1024)));
      writer.write(ByteBuffer.wrap(Arrays.copyOfRange(expected, 512 * 1024, expected.length)));
    }
    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);

    byte[] actual = storage.readAllBytes(info.getBlobId());
    String actualXxd = xxd(actual);
    assertAll(
        () -> subject.containsExactly(HEADER_VALUE, HEADER_VALUE, HEADER_VALUE, HEADER_VALUE),
        () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  @CrossRun.Exclude(transports = Transport.GRPC)
  public void batch() throws Exception {
    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo info2 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo info3 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    storage.create(info1, BlobTargetOption.doesNotExist());
    storage.create(info2, BlobTargetOption.doesNotExist());
    storage.create(info3, BlobTargetOption.doesNotExist());

    headers.clear();
    OffsetDateTime now = Clock.systemUTC().instant().atOffset(ZoneOffset.UTC);

    StorageBatch batch = storage.batch();
    String batchHeaderKey = "x-batch-key";
    StorageBatchResult<Blob> r1 =
        batch.get(
            info1.getBlobId(), BlobGetOption.extraHeaders(ImmutableMap.of(batchHeaderKey, "v1")));
    StorageBatchResult<Blob> r2 =
        batch.update(
            info2.toBuilder().setCustomTimeOffsetDateTime(now).build(),
            BlobTargetOption.extraHeaders(ImmutableMap.of(batchHeaderKey, "v2")));
    StorageBatchResult<Boolean> r3 =
        batch.delete(
            info3.getBlobId(),
            BlobSourceOption.extraHeaders(ImmutableMap.of(batchHeaderKey, "v3")));

    batch.submit();
    assertAll(
        () -> assertThat(r1).isNotNull(),
        () ->
            assertThat(r2.get().getCustomTimeOffsetDateTime().truncatedTo(ChronoUnit.MILLIS))
                .isEqualTo(now.truncatedTo(ChronoUnit.MILLIS)),
        () -> assertThat(r3.get()).isTrue(),
        () -> {
          IterableSubject subject = headers.assertRequestHeader(batchHeaderKey);
          subject.containsExactly("v1", "v2", "v3");
        });
  }

  @Test
  public void rewrite() throws Exception {
    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo info2 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo gen1 = storage.create(info1, BlobTargetOption.doesNotExist());

    CopyRequest copyRequest =
        CopyRequest.newBuilder()
            .setSource(gen1.getBlobId())
            .setSourceOptions(
                BlobSourceOption.extraHeaders(ImmutableMap.of("x-header-source", HEADER_VALUE)))
            .setTarget(
                info2,
                BlobTargetOption.doesNotExist(),
                BlobTargetOption.extraHeaders(ImmutableMap.of("x-header-target", HEADER_VALUE)))
            .build();
    headers.clear();
    CopyWriter copyWriter = storage.copy(copyRequest);
    copyWriter.getResult();
    assertAll(
        () -> {
          IterableSubject subject = headers.assertRequestHeader("x-header-source");
          subject.containsExactly(HEADER_VALUE);
        },
        () -> {
          IterableSubject subject = headers.assertRequestHeader("x-header-target");
          subject.containsExactly(HEADER_VALUE);
        });
  }

  @Test
  public void compose() throws Exception {
    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo info2 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo gen1 = storage.create(info1, BlobTargetOption.doesNotExist());

    ComposeRequest composeRequest =
        ComposeRequest.newBuilder()
            .addSource(gen1.getBlobId().getName())
            .setTarget(info2)
            .setTargetOptions(
                BlobTargetOption.doesNotExist(), BlobTargetOption.extraHeaders(EXTRA_HEADERS))
            .build();
    headers.clear();
    Blob blob2 = storage.compose(composeRequest);
    assertThat(blob2).isNotNull();
    IterableSubject subject = headers.assertRequestHeader(HEADER_NAME, FilteringPolicy.NO_FILTER);
    subject.containsExactly(HEADER_VALUE);
  }
}
