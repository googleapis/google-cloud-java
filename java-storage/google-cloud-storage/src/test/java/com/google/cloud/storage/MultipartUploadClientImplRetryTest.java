/*
 * Copyright 2026 Google LLC
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
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CompletedMultipartUpload;
import com.google.cloud.storage.multipartupload.model.CompletedPart;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsRequest;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsResponse;
import com.google.cloud.storage.multipartupload.model.ListPartsRequest;
import com.google.cloud.storage.multipartupload.model.ListPartsResponse;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.function.UnaryOperator;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Hermetic tests verifying {@link MultipartUploadClientImpl} retries retryable HTTP status codes
 * returned by the XML API, and replays identical request bodies on retry.
 */
public final class MultipartUploadClientImplRetryTest {

  private static final int MAX_ATTEMPTS = 6;
  private static final int[] RETRYABLE_CODES = {408, 429, 500, 502, 503, 504};
  private static final int[] NON_RETRYABLE_CODES = {400, 403, 404};

  private static final String ETAG = "\"af1ed31420542285653c803a34aa839a\"";

  @Rule public final TemporaryFolder temp = new TemporaryFolder();

  @Test
  public void listParts_retryableStatus_thenSuccess() throws Exception {
    for (int code : RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), listPartsOk());
      ListPartsResponse response = client(transport).listParts(listPartsRequest());
      assertSucceededAfterOneRetry(code, transport, response);
      assertThat(response.bucket()).isEqualTo("test-bucket");
    }
  }

  @Test
  public void abortMultipartUpload_retryableStatus_thenSuccess() throws Exception {
    for (int code : RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), noContent());
      client(transport)
          .abortMultipartUpload(
              AbortMultipartUploadRequest.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build());
      assertWithMessage("requests for status %s", code).that(transport.requests).hasSize(2);
    }
  }

  @Test
  public void completeMultipartUpload_retryableStatus_thenSuccess() throws Exception {
    for (int code : RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), completeOk());
      CompleteMultipartUploadResponse response =
          client(transport).completeMultipartUpload(completeRequest());
      assertSucceededAfterOneRetry(code, transport, response);
      assertThat(response.etag()).isEqualTo(ETAG);
      // the same request body must be sent on each attempt
      assertThat(transport.requests.get(1).body).isEqualTo(transport.requests.get(0).body);
    }
  }

  @Test
  public void uploadPart_retryableStatus_thenSuccess() throws Exception {
    byte[] bytes = "hello world".getBytes(StandardCharsets.UTF_8);
    for (int code : RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), uploadPartOk());
      UploadPartResponse response =
          client(transport).uploadPart(uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(bytes)));
      assertSucceededAfterOneRetry(code, transport, response);
      assertThat(response.eTag()).isEqualTo(ETAG);
      assertThat(transport.requests.get(0).body).isEqualTo(bytes);
      assertThat(transport.requests.get(1).body).isEqualTo(bytes);
    }
  }

  @Test
  public void listMultipartUploads_retryableStatus_thenSuccess() throws Exception {
    for (int code : RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), listUploadsOk());
      ListMultipartUploadsResponse response =
          client(transport)
              .listMultipartUploads(
                  ListMultipartUploadsRequest.builder().bucket("test-bucket").build());
      assertSucceededAfterOneRetry(code, transport, response);
      assertThat(response.bucket()).isEqualTo("test-bucket");
    }
  }

  @Test
  public void createMultipartUpload_503_isNotRetried() throws Exception {
    ScriptedTransport transport = new ScriptedTransport(error(503), createOk());
    StorageException e =
        assertThrows(
            StorageException.class,
            () ->
                client(transport)
                    .createMultipartUpload(
                        CreateMultipartUploadRequest.builder()
                            .bucket("test-bucket")
                            .key("test-key")
                            .build()));
    assertAll(
        () -> assertThat(e.getCode()).isEqualTo(503),
        () -> assertThat(transport.requests).hasSize(1));
  }

  @Test
  public void uploadPart_nonRetryableStatus_isNotRetried() throws Exception {
    for (int code : NON_RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), uploadPartOk());
      StorageException e =
          assertThrows(
              StorageException.class,
              () ->
                  client(transport)
                      .uploadPart(
                          uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(new byte[] {1}))));
      assertNotRetried(code, transport, e);
    }
  }

  @Test
  public void listParts_nonRetryableStatus_isNotRetried() throws Exception {
    for (int code : NON_RETRYABLE_CODES) {
      ScriptedTransport transport = new ScriptedTransport(error(code), listPartsOk());
      StorageException e =
          assertThrows(
              StorageException.class, () -> client(transport).listParts(listPartsRequest()));
      assertNotRetried(code, transport, e);
    }
  }

  @Test
  public void uploadPart_singleByteBuffer_replaysIdenticalBytesAndChecksum() throws Exception {
    byte[] bytes = DataGenerator.base64Characters().genBytes(64 * 1024 + 7);
    assertReplaysIdentically(RequestBody.of(ByteBuffer.wrap(bytes)), bytes);
  }

  @Test
  public void uploadPart_multiByteBufferWithOffsets_replaysIdenticalBytesAndChecksum()
      throws Exception {
    byte[] a = DataGenerator.base64Characters().genBytes(1024);
    byte[] b = DataGenerator.base64Characters().genBytes(2048);
    byte[] c = DataGenerator.base64Characters().genBytes(512);
    ByteBuffer bufA = ByteBuffer.wrap(a);
    bufA.position(10);
    ByteBuffer bufB = ByteBuffer.wrap(b);
    bufB.position(100);
    ByteBuffer bufC = ByteBuffer.wrap(c);
    bufC.position(1);

    ByteArrayOutputStream expected = new ByteArrayOutputStream();
    expected.write(a, 10, a.length - 10);
    expected.write(b, 100, b.length - 100);
    expected.write(c, 1, c.length - 1);

    assertReplaysIdentically(RequestBody.of(bufA, bufB, bufC), expected.toByteArray());
  }

  @Test
  public void uploadPart_path_replaysIdenticalBytesAndChecksum() throws Exception {
    byte[] bytes = DataGenerator.base64Characters().genBytes(32 * 1024 + 5);
    Path path = temp.newFile("part").toPath();
    Files.write(path, bytes);
    assertReplaysIdentically(RequestBody.of(path), bytes);
  }

  @Test
  public void uploadPart_emptyPath_replaysIdenticalBytesAndChecksum() throws Exception {
    Path path = temp.newFile("empty-part").toPath();
    assertReplaysIdentically(RequestBody.of(path), new byte[0]);
  }

  @Test
  public void uploadPart_alwaysRetryable_exhaustsBudget() throws Exception {
    List<MockLowLevelHttpResponse> responses = new ArrayList<>();
    for (int i = 0; i < MAX_ATTEMPTS + 2; i++) {
      responses.add(error(503));
    }
    ScriptedTransport transport =
        new ScriptedTransport(responses.toArray(new MockLowLevelHttpResponse[0]));
    StorageException e =
        assertThrows(
            StorageException.class,
            () ->
                client(transport)
                    .uploadPart(
                        uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(new byte[] {1, 2}))));
    String messages = TestUtils.messagesToText(e);
    assertAll(
        () -> assertThat(e.getCode()).isEqualTo(503),
        () -> assertThat(transport.requests).hasSize(MAX_ATTEMPTS),
        () -> assertThat(messages).contains("attempt budget"));
  }

  private void assertReplaysIdentically(RequestBody body, byte[] expected) throws Exception {
    ScriptedTransport transport = new ScriptedTransport(error(503), error(503), uploadPartOk());
    UploadPartResponse response = client(transport).uploadPart(uploadPartRequest(), body);
    assertThat(response.eTag()).isEqualTo(ETAG);
    assertThat(transport.requests).hasSize(3);
    RecordedRequest first = transport.requests.get(0);
    for (RecordedRequest r : transport.requests) {
      assertAll(
          () -> assertThat(r.body).isEqualTo(expected),
          () -> assertThat(r.xGoogHash).isEqualTo(first.xGoogHash));
    }
  }

  private static void assertSucceededAfterOneRetry(
      int code, ScriptedTransport transport, Object response) {
    assertWithMessage("response for status %s", code).that(response).isNotNull();
    assertWithMessage("requests for status %s", code).that(transport.requests).hasSize(2);
  }

  private static void assertNotRetried(int code, ScriptedTransport transport, StorageException e)
      throws Exception {
    assertAll(
        () -> assertThat(e.getCode()).isEqualTo(code),
        () -> assertThat(e.getMessage()).contains("message for " + code),
        () -> assertThat(transport.requests).hasSize(1));
  }

  private static MultipartUploadClientImpl client(ScriptedTransport transport) {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(MAX_ATTEMPTS)
            .setInitialRetryDelayDuration(Duration.ofMillis(1))
            .setMaxRetryDelayDuration(Duration.ofMillis(5))
            .setRetryDelayMultiplier(1.0)
            .setTotalTimeoutDuration(Duration.ofSeconds(30))
            .build();
    return new MultipartUploadClientImpl(
        new DefaultRetrier(
            UnaryOperator.identity(),
            RetryingDependencies.simple(NanoClock.getDefaultClock(), retrySettings)),
        new MultipartUploadHttpRequestManager(
            transport.createRequestFactory(),
            new XmlObjectParser(new XmlMapper()),
            FixedHeaderProvider.create(ImmutableMap.of()),
            URI.create("http://localhost/")),
        new HttpRetryAlgorithmManager(DefaultStorageRetryStrategy.INSTANCE));
  }

  private static ListPartsRequest listPartsRequest() {
    return ListPartsRequest.builder()
        .bucket("test-bucket")
        .key("test-key")
        .uploadId("test-upload-id")
        .build();
  }

  private static UploadPartRequest uploadPartRequest() {
    return UploadPartRequest.builder()
        .bucket("test-bucket")
        .key("test-key")
        .uploadId("test-upload-id")
        .partNumber(1)
        .build();
  }

  private static CompleteMultipartUploadRequest completeRequest() {
    return CompleteMultipartUploadRequest.builder()
        .bucket("test-bucket")
        .key("test-key")
        .uploadId("test-upload-id")
        .multipartUpload(
            CompletedMultipartUpload.builder()
                .parts(
                    ImmutableList.of(
                        CompletedPart.builder().partNumber(1).eTag("\"etag1\"").build()))
                .build())
        .build();
  }

  private static MockLowLevelHttpResponse error(int code) {
    return new MockLowLevelHttpResponse()
        .setStatusCode(code)
        .setReasonPhrase("status " + code)
        .setContentType("application/xml; charset=UTF-8")
        .setContent(
            "<?xml version='1.0' encoding='UTF-8'?><Error><Code>Code"
                + code
                + "</Code><Message>message for "
                + code
                + "</Message></Error>");
  }

  private static MockLowLevelHttpResponse xmlOk(String xml) {
    return new MockLowLevelHttpResponse()
        .setStatusCode(200)
        .setContentType("application/xml; charset=UTF-8")
        .setContent(xml);
  }

  private static MockLowLevelHttpResponse noContent() {
    return new MockLowLevelHttpResponse().setStatusCode(204);
  }

  private static MockLowLevelHttpResponse createOk() {
    return xmlOk(
        "<InitiateMultipartUploadResult><Bucket>test-bucket</Bucket><Key>test-key</Key>"
            + "<UploadId>test-upload-id</UploadId></InitiateMultipartUploadResult>");
  }

  private static MockLowLevelHttpResponse listPartsOk() {
    return xmlOk(
        "<ListPartsResult><Bucket>test-bucket</Bucket><Key>test-key</Key>"
            + "<UploadId>test-upload-id</UploadId></ListPartsResult>");
  }

  private static MockLowLevelHttpResponse listUploadsOk() {
    return xmlOk(
        "<ListMultipartUploadsResult><Bucket>test-bucket</Bucket></ListMultipartUploadsResult>");
  }

  private static MockLowLevelHttpResponse completeOk() {
    return xmlOk(
        "<CompleteMultipartUploadResult><Bucket>test-bucket</Bucket><Key>test-key</Key>"
            + "<ETag>"
            + ETAG
            + "</ETag></CompleteMultipartUploadResult>");
  }

  private static MockLowLevelHttpResponse uploadPartOk() {
    return new MockLowLevelHttpResponse().setStatusCode(200).addHeader("ETag", ETAG);
  }

  private static final class RecordedRequest {
    private final String method;
    private final String url;
    private final byte[] body;
    private final @Nullable String xGoogHash;

    private RecordedRequest(String method, String url, byte[] body, @Nullable String xGoogHash) {
      this.method = method;
      this.url = url;
      this.body = body;
      this.xGoogHash = xGoogHash;
    }

    @Override
    public String toString() {
      return method + " " + url + " (" + body.length + " bytes)";
    }
  }

  /** A transport which returns a scripted sequence of responses and records each request. */
  private static final class ScriptedTransport extends MockHttpTransport {
    private final Deque<MockLowLevelHttpResponse> responses;
    private final List<RecordedRequest> requests = Collections.synchronizedList(new ArrayList<>());

    private ScriptedTransport(MockLowLevelHttpResponse... responses) {
      this.responses = new ArrayDeque<>(ImmutableList.copyOf(responses));
    }

    @Override
    public LowLevelHttpRequest buildRequest(String method, String url) {
      return new MockLowLevelHttpRequest(url) {
        @Override
        public LowLevelHttpResponse execute() throws IOException {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          if (getStreamingContent() != null) {
            getStreamingContent().writeTo(baos);
          }
          requests.add(
              new RecordedRequest(
                  method, url, baos.toByteArray(), getFirstHeaderValue("x-goog-hash")));
          MockLowLevelHttpResponse next = responses.poll();
          if (next == null) {
            throw new IllegalStateException("no more scripted responses for " + method + " " + url);
          }
          return next;
        }
      };
    }
  }
}
