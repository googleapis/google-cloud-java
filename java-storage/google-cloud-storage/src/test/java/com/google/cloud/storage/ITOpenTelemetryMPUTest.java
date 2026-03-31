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

import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompletedMultipartUpload;
import com.google.cloud.storage.multipartupload.model.CompletedPart;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import com.google.cloud.storage.otel.TestExporter;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.PROD,
    transports = {Transport.HTTP})
public final class ITOpenTelemetryMPUTest {

  @Inject public Storage storage;

  @Inject public BucketInfo bucket;

  @Inject public Generator generator;
  @Inject public Transport transport;

  @Test
  public void checkMPUInstrumentation() throws Exception {
    TestExporter exporter = new TestExporter();

    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();

    HttpStorageOptions httpStorageOptions = (HttpStorageOptions) storage.getOptions();
    StorageOptions storageOptions =
        httpStorageOptions.toBuilder().setOpenTelemetry(openTelemetrySdk).build();

    String objectName = generator.randomObjectName();

    try (Storage storage = storageOptions.getService()) {
      MultipartUploadClient mpuClient =
          MultipartUploadClient.create(
              MultipartUploadSettings.of((HttpStorageOptions) storage.getOptions()));

      CreateMultipartUploadResponse create =
          mpuClient.createMultipartUpload(
              CreateMultipartUploadRequest.builder()
                  .bucket(bucket.getName())
                  .key(objectName)
                  .build());

      byte[] data = "Hello, World!".getBytes(StandardCharsets.UTF_8);
      RequestBody body = RequestBody.of(ByteBuffer.wrap(data));
      UploadPartResponse upload =
          mpuClient.uploadPart(
              UploadPartRequest.builder()
                  .bucket(bucket.getName())
                  .key(objectName)
                  .uploadId(create.uploadId())
                  .partNumber(1)
                  .build(),
              body);

      mpuClient.completeMultipartUpload(
          CompleteMultipartUploadRequest.builder()
              .bucket(bucket.getName())
              .key(objectName)
              .uploadId(create.uploadId())
              .multipartUpload(
                  CompletedMultipartUpload.builder()
                      .parts(
                          ImmutableList.of(
                              CompletedPart.builder().partNumber(1).eTag(upload.eTag()).build()))
                      .build())
              .build());

      mpuClient.listMultipartUploads(
          ListMultipartUploadsRequest.builder().bucket(bucket.getName()).build());
    }

    List<SpanData> spans = exporter.getExportedSpans();
    assertThat(spans).hasSize(4);

    SpanData createSpan = spans.get(0);
    assertThat(createSpan.getName())
        .isEqualTo("com.google.cloud.storage.MultipartUploadClient/createMultipartUpload");
    assertThat(createSpan.getAttributes().get(AttributeKey.stringKey("gsutil.uri")))
        .isEqualTo(String.format("gs://%s/%s", bucket.getName(), objectName));

    SpanData uploadSpan = spans.get(1);
    assertThat(uploadSpan.getName())
        .isEqualTo("com.google.cloud.storage.MultipartUploadClient/uploadPart");
    assertThat(uploadSpan.getAttributes().get(AttributeKey.stringKey("gsutil.uri")))
        .isEqualTo(String.format("gs://%s/%s", bucket.getName(), objectName));
    assertThat(uploadSpan.getAttributes().get(AttributeKey.longKey("partNumber"))).isEqualTo(1);

    SpanData completeSpan = spans.get(2);
    assertThat(completeSpan.getName())
        .isEqualTo("com.google.cloud.storage.MultipartUploadClient/completeMultipartUpload");
    assertThat(completeSpan.getAttributes().get(AttributeKey.stringKey("gsutil.uri")))
        .isEqualTo(String.format("gs://%s/%s", bucket.getName(), objectName));

    SpanData listSpan = spans.get(3);
    assertThat(listSpan.getName())
        .isEqualTo("com.google.cloud.storage.MultipartUploadClient/listMultipartUploads");
    assertThat(listSpan.getAttributes().get(AttributeKey.stringKey("gsutil.uri")))
        .isEqualTo(String.format("gs://%s/", bucket.getName()));
  }
}
