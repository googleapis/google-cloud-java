/*
 * Copyright 2024 Google LLC
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
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.otel.TestExporter;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.PROD,
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITOpenTelemetryTest {

  static {
    OtelStorageDecorator.acoEnabled = true;
  }

  @Inject public Storage storage;

  @Inject public BucketInfo bucket;

  @Inject public Generator generator;
  @Inject public Transport transport;

  @Test
  public void checkInstrumentation() throws Exception {
    TestExporter exporter = new TestExporter();

    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();
    StorageOptions storageOptions =
        storage.getOptions().toBuilder().setOpenTelemetry(openTelemetrySdk).build();
    try (Storage storage = storageOptions.getService()) {
      storage.create(BlobInfo.newBuilder(bucket, generator.randomObjectName()).build());
    }

    SpanData spanData = exporter.getExportedSpans().get(0);
    assertAll(
        () -> assertThat(getAttributeValue(spanData, "gcp.client.service")).isEqualTo("Storage"),
        () ->
            assertThat(getAttributeValue(spanData, "gcp.client.repo"))
                .isEqualTo("googleapis/java-storage"),
        () ->
            assertThat(getAttributeValue(spanData, "gcp.client.artifact"))
                .isEqualTo("com.google.cloud:google-cloud-storage"),
        () ->
            assertThat(getAttributeValue(spanData, "rpc.system"))
                .isEqualTo(transport.name().toLowerCase()));
  }

  @Test
  public void testAcoSuccessFlow() throws Exception {
    TestExporter exporter = new TestExporter();

    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();
    StorageOptions storageOptions =
        storage.getOptions().toBuilder().setOpenTelemetry(openTelemetrySdk).build();
    try (Storage storage = storageOptions.getService()) {
      storage.create(BlobInfo.newBuilder(bucket, generator.randomObjectName()).build());
      pollUntilMetadataResolved((OtelStorageDecorator) storage, bucket.getName());
      storage.create(BlobInfo.newBuilder(bucket, generator.randomObjectName()).build());
    }

    assertThat(exporter.getExportedSpans().size()).isAtLeast(2);
    SpanData span1 = exporter.getExportedSpans().get(0);
    SpanData span2 = exporter.getExportedSpans().get(1);

    assertAll(
        () -> assertThat(getAttributeValue(span1, "gcp.client.service")).isEqualTo("Storage"),
        () ->
            assertThat(getAttributeValue(span1, "rpc.system"))
                .isEqualTo(transport.name().toLowerCase()),
        () -> assertThat(getAttributeValue(span2, "gcp.client.service")).isEqualTo("Storage"),
        () ->
            assertThat(getAttributeValue(span2, "gcp.resource.destination.id"))
                .contains("buckets/" + bucket.getName()),
        () ->
            assertThat(getAttributeValue(span2, "gcp.resource.destination.location"))
                .isNotEqualTo("global"));
  }

  @Test
  public void testAcoNonExistentBucketNoAttributes() throws Exception {
    TestExporter exporter = new TestExporter();
    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();
    StorageOptions storageOptions =
        storage.getOptions().toBuilder().setOpenTelemetry(openTelemetrySdk).build();
    String nonExistentBucket = "non-existent-bucket-" + generator.randomBucketName();

    try (Storage storage = storageOptions.getService()) {
      storage.get(nonExistentBucket);
      pollUntilMetadataEvicted((OtelStorageDecorator) storage, nonExistentBucket);
      storage.get(nonExistentBucket);
    }

    // We should have at least 2 get spans
    assertThat(exporter.getExportedSpans().size()).isAtLeast(2);
    SpanData getSpan1 = exporter.getExportedSpans().get(0);
    SpanData getSpan2 = exporter.getExportedSpans().get(1);

    assertAll(
        () -> assertThat(getAttributeValue(getSpan2, "gcp.resource.destination.id")).isNull(),
        () ->
            assertThat(getAttributeValue(getSpan2, "gcp.resource.destination.location")).isNull());
  }

  @Test
  public void testAcoForbiddenBucketFallbackAttributes() throws Exception {
    TestExporter exporter = new TestExporter();
    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();
    StorageOptions storageOptions =
        storage.getOptions().toBuilder().setOpenTelemetry(openTelemetrySdk).build();

    try (Storage storage = storageOptions.getService()) {
      try {
        storage.get("test");
      } catch (StorageException e) {
        // Expected 403 Forbidden
      }
      pollUntilMetadataResolved((OtelStorageDecorator) storage, "test");
      try {
        storage.get("test");
      } catch (StorageException e) {
        // Expected 403 Forbidden
      }
    }

    assertThat(exporter.getExportedSpans().size()).isAtLeast(2);
    SpanData getSpan1 = exporter.getExportedSpans().get(0);
    SpanData getSpan2 = exporter.getExportedSpans().get(1);

    assertAll(
        () ->
            assertThat(getAttributeValue(getSpan2, "gcp.resource.destination.id"))
                .isEqualTo("projects/_/buckets/test"),
        () ->
            assertThat(getAttributeValue(getSpan2, "gcp.resource.destination.location"))
                .isEqualTo("global"));
  }

  @Test
  public void noOpDoesNothing() {
    assertThat(storage.getOptions().getOpenTelemetry()).isSameInstanceAs(OpenTelemetry.noop());
    storage.create(BlobInfo.newBuilder(bucket, generator.randomObjectName()).build());
  }

  private static void pollUntilMetadataResolved(OtelStorageDecorator osd, String bucketName)
      throws Exception {
    for (int i = 0; i < 100; i++) {
      BucketMetadataCache cache = osd.acoContext.getCache();
      BucketMetadataCache.BucketMetadata meta = cache != null ? cache.get(bucketName) : null;
      if (meta != null && !meta.fetchPending) {
        return;
      }
      Thread.sleep(50);
    }
    throw new AssertionError(
        "Timeout waiting for ACO metadata prefetch to resolve for bucket: " + bucketName);
  }

  private static void pollUntilMetadataEvicted(OtelStorageDecorator osd, String bucketName)
      throws Exception {
    for (int i = 0; i < 100; i++) {
      BucketMetadataCache cache = osd.acoContext.getCache();
      if (cache == null || !cache.containsKey(bucketName)) {
        return;
      }
      Thread.sleep(50);
    }
    throw new AssertionError(
        "Timeout waiting for ACO metadata prefetch to evict for nonexistent bucket: " + bucketName);
  }

  @Test
  public void testAcoDisabledRetainsStandardInstrumentation() throws Exception {
    OtelStorageDecorator.acoEnabled = false;
    try {
      TestExporter exporter = new TestExporter();
      OpenTelemetrySdk openTelemetrySdk =
          OpenTelemetrySdk.builder()
              .setTracerProvider(
                  SdkTracerProvider.builder()
                      .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                      .build())
              .build();
      StorageOptions storageOptions =
          storage.getOptions().toBuilder().setOpenTelemetry(openTelemetrySdk).build();
      try (Storage storage = storageOptions.getService()) {
        storage.create(BlobInfo.newBuilder(bucket, generator.randomObjectName()).build());
      }

      assertThat(exporter.getExportedSpans().size()).isAtLeast(1);
      SpanData spanData = exporter.getExportedSpans().get(0);
      assertAll(
          () -> assertThat(getAttributeValue(spanData, "gcp.client.service")).isEqualTo("Storage"),
          () ->
              assertThat(getAttributeValue(spanData, "rpc.system"))
                  .isEqualTo(transport.name().toLowerCase()),
          () -> assertThat(getAttributeValue(spanData, "gcp.resource.destination.id")).isNull(),
          () ->
              assertThat(getAttributeValue(spanData, "gcp.resource.destination.location"))
                  .isNull());
    } finally {
      OtelStorageDecorator.acoEnabled = true;
    }
  }

  private static String getAttributeValue(SpanData spanData, String key) {
    return spanData.getAttributes().get(AttributeKey.stringKey(key));
  }
}
