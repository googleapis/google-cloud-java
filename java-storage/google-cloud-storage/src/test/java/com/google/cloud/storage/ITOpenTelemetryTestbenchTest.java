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

import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.otel.TestExporter;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.TEST_BENCH,
    transports = {Transport.HTTP, Transport.GRPC})
public class ITOpenTelemetryTestbenchTest {
  @Inject public Transport transport;
  @Inject public Generator generator;
  @Inject public BucketInfo testBucket;
  @Inject public Storage storage;
  private SpanExporter exporter;
  private static final byte[] helloWorldTextBytes = "hello world".getBytes();
  private BlobId blobId;
  private static final Path tmpDir = Paths.get(System.getProperty("java.io.tmpdir"));

  @Before
  public void setUp() {
    exporter = new TestExporter();
    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();
    StorageOptions options =
        storage.getOptions().toBuilder().setOpenTelemetry(openTelemetrySdk).build();
    storage = options.getService();
    String objectString = generator.randomObjectName();
    blobId = BlobId.of(testBucket.getName(), objectString);
  }

  @After
  public void tearDown() throws Exception {
    if (storage != null) {
      storage.close();
    }
  }

  @Test
  public void runCreateBucket() {
    String bucket = "random-bucket" + UUID.randomUUID();
    storage.create(BucketInfo.of(bucket));
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
  }

  @Test
  public void runCreateBlob() {
    byte[] content = "Hello, World!".getBytes(UTF_8);
    BlobId toCreate = BlobId.of(testBucket.getName(), generator.randomObjectName());
    storage.create(BlobInfo.newBuilder(toCreate).build(), content);
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("create")));
  }

  @Test
  public void runReadAllBytes() {
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    storage.create(blobInfo, helloWorldTextBytes);
    byte[] read = storage.readAllBytes(blobId);
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("readAllBytes")));
  }

  @Test
  public void runCreateFrom() throws IOException {
    Path helloWorldTxtGz = File.createTempFile(blobId.getName(), ".txt.gz").toPath();
    storage.createFrom(BlobInfo.newBuilder(blobId).build(), helloWorldTxtGz);
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("createFrom")));
  }

  @Test
  public void runDownloadToPath() throws IOException {
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    storage.create(blobInfo, helloWorldTextBytes);
    try (TmpFile file = TmpFile.of(tmpDir, "download-to", ".txt")) {
      storage.downloadTo(blobId, file.getPath());
      TestExporter testExported = (TestExporter) exporter;
      List<SpanData> spanData = testExported.getExportedSpans();
      checkCommonAttributes(spanData);
      Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("downloadTo")));
    }
  }

  @Test
  public void runDownloadToOutputStream() {
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    storage.create(blobInfo, helloWorldTextBytes);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    storage.downloadTo(blobId, baos);
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("downloadTo")));
  }

  @Test
  public void runCopy() {
    BlobInfo info =
        BlobInfo.newBuilder(testBucket, generator.randomObjectName() + "copy/src").build();
    Blob cpySrc = storage.create(info, helloWorldTextBytes, BlobTargetOption.doesNotExist());
    BlobInfo dst =
        BlobInfo.newBuilder(testBucket, generator.randomObjectName() + "copy/dst").build();
    CopyRequest copyRequest =
        CopyRequest.newBuilder()
            .setSource(cpySrc.getBlobId())
            .setSourceOptions(BlobSourceOption.generationMatch(cpySrc.getGeneration()))
            .setTarget(dst, BlobTargetOption.doesNotExist())
            .build();
    CopyWriter copyWriter = storage.copy(copyRequest);
    BlobInfo result = copyWriter.getResult();
    assertThat(result).isNotNull();
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("copy")));
  }

  @Test
  public void runWriter() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(testBucket, generator.randomObjectName()).build();
    try (WriteChannel writer = storage.writer(info)) {
      // Do nothing
    }
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("writer")));
  }

  @Test
  public void runReader() throws IOException {
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    storage.create(blobInfo, helloWorldTextBytes);
    try (ReadChannel reader = storage.reader(blobId)) {
      // Do nothing
    }
    TestExporter testExported = (TestExporter) exporter;
    List<SpanData> spanData = testExported.getExportedSpans();
    checkCommonAttributes(spanData);
    Assert.assertTrue(spanData.stream().anyMatch(x -> x.getName().contains("reader")));
  }

  private void checkCommonAttributes(List<SpanData> spanData) {
    for (SpanData span : spanData) {
      Assert.assertEquals("Storage", getAttributeValue(span, "gcp.client.service"));
      Assert.assertEquals("googleapis/java-storage", getAttributeValue(span, "gcp.client.repo"));
      Assert.assertEquals(
          "com.google.cloud:google-cloud-storage", getAttributeValue(span, "gcp.client.artifact"));
      Assert.assertEquals(transport.name().toLowerCase(), getAttributeValue(span, "rpc.system"));
    }
  }

  private String getAttributeValue(SpanData spanData, String key) {
    return spanData.getAttributes().get(AttributeKey.stringKey(key)).toString();
  }
}
