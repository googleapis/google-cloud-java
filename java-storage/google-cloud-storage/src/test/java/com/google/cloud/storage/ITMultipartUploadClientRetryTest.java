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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.SERVICE_UNAVAILABLE;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.FakeHttpServer.HttpRequestHandler;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
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
import io.grpc.netty.shaded.io.netty.buffer.ByteBuf;
import io.grpc.netty.shaded.io.netty.buffer.Unpooled;
import io.grpc.netty.shaded.io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpRequest;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpRequest;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Verifies that {@link MultipartUploadClient} operations classify XML API error responses by their
 * HTTP status code, retrying transient errors for idempotent operations.
 */
@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
@ParallelFriendly
public final class ITMultipartUploadClientRetryTest {

  private static final byte[] PART_CONTENT = "hello world".getBytes(StandardCharsets.UTF_8);
  private static final String ETAG = "\"af1ed31420542285653c803a34aa839a\"";

  @Test
  public void uploadPart_retriesOn503_andResendsFullBody() throws Exception {
    List<byte[]> receivedBodies = new CopyOnWriteArrayList<>();
    FailFirst handler =
        new FailFirst(
            2,
            SERVICE_UNAVAILABLE,
            req -> {
              DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
              resp.headers().set("ETag", ETAG);
              return resp;
            },
            receivedBodies);

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      UploadPartResponse response =
          client.uploadPart(uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(PART_CONTENT)));

      assertThat(response.eTag()).isEqualTo(ETAG);
      assertThat(handler.attempts()).isEqualTo(3);
      // every attempt, including the retries, must send the complete part content
      assertThat(receivedBodies).hasSize(3);
      for (byte[] body : receivedBodies) {
        assertThat(body).isEqualTo(PART_CONTENT);
      }
    }
  }

  @Test
  public void uploadPart_retriesAllRetryableStatusCodes() throws Exception {
    ImmutableList<HttpResponseStatus> retryable =
        ImmutableList.of(
            HttpResponseStatus.REQUEST_TIMEOUT,
            HttpResponseStatus.TOO_MANY_REQUESTS,
            HttpResponseStatus.INTERNAL_SERVER_ERROR,
            HttpResponseStatus.BAD_GATEWAY,
            SERVICE_UNAVAILABLE,
            HttpResponseStatus.GATEWAY_TIMEOUT);
    // Share a single server across all status codes; the handler reads the status to fail with
    // from currentStatus, and attempts is reset before each iteration.
    AtomicReference<HttpResponseStatus> currentStatus = new AtomicReference<>();
    AtomicInteger attempts = new AtomicInteger();
    HttpRequestHandler handler =
        req -> {
          if (attempts.incrementAndGet() == 1) {
            HttpResponseStatus status = currentStatus.get();
            ByteBuf buf =
                Unpooled.wrappedBuffer(status.reasonPhrase().getBytes(StandardCharsets.UTF_8));
            FullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), status, buf);
            resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
            return resp;
          }
          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set("ETag", ETAG);
          return resp;
        };

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);
      for (HttpResponseStatus status : retryable) {
        currentStatus.set(status);
        attempts.set(0);

        UploadPartResponse response =
            client.uploadPart(uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(PART_CONTENT)));

        assertWithMessage("status %s", status).that(response.eTag()).isEqualTo(ETAG);
        assertWithMessage("status %s", status).that(attempts.get()).isEqualTo(2);
      }
    }
  }

  @Test
  public void uploadPart_exhaustsRetries_surfacesHttpStatusCode() throws Exception {
    FailFirst handler = new FailFirst(Integer.MAX_VALUE, SERVICE_UNAVAILABLE, null);

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      StorageException e =
          assertThrows(
              StorageException.class,
              () ->
                  client.uploadPart(
                      uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(PART_CONTENT))));

      assertThat(e.getCode()).isEqualTo(503);
      // FakeHttpServer configures maxAttempts = 6
      assertThat(handler.attempts()).isEqualTo(6);
    }
  }

  @Test
  public void uploadPart_doesNotRetryClientError_surfacesHttpStatusCode() throws Exception {
    FailFirst handler = new FailFirst(Integer.MAX_VALUE, BAD_REQUEST, null);

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      StorageException e =
          assertThrows(
              StorageException.class,
              () ->
                  client.uploadPart(
                      uploadPartRequest(), RequestBody.of(ByteBuffer.wrap(PART_CONTENT))));

      assertThat(e.getCode()).isEqualTo(400);
      assertThat(handler.attempts()).isEqualTo(1);
    }
  }

  @Test
  public void listParts_retriesOn503() throws Exception {
    FailFirst handler =
        new FailFirst(
            2,
            SERVICE_UNAVAILABLE,
            xml(
                "<ListPartsResult><Bucket>test-bucket</Bucket><Key>test-key</Key>"
                    + "<UploadId>test-upload-id</UploadId></ListPartsResult>"));

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      ListPartsResponse response =
          client.listParts(
              ListPartsRequest.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build());

      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(handler.attempts()).isEqualTo(3);
    }
  }

  @Test
  public void abortMultipartUpload_retriesOn503() throws Exception {
    FailFirst handler =
        new FailFirst(
            2,
            SERVICE_UNAVAILABLE,
            req -> new DefaultFullHttpResponse(req.protocolVersion(), NO_CONTENT));

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      client.abortMultipartUpload(
          AbortMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .build());

      assertThat(handler.attempts()).isEqualTo(3);
    }
  }

  @Test
  public void completeMultipartUpload_retriesOn503() throws Exception {
    FailFirst handler =
        new FailFirst(
            2,
            SERVICE_UNAVAILABLE,
            xml(
                "<CompleteMultipartUploadResult><Bucket>test-bucket</Bucket><Key>test-key</Key>"
                    + "<ETag>"
                    + ETAG
                    + "</ETag></CompleteMultipartUploadResult>"));

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      CompleteMultipartUploadResponse response =
          client.completeMultipartUpload(
              CompleteMultipartUploadRequest.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .multipartUpload(
                      CompletedMultipartUpload.builder()
                          .parts(
                              ImmutableList.of(
                                  CompletedPart.builder().partNumber(1).eTag(ETAG).build()))
                          .build())
                  .build());

      assertThat(response.etag()).isEqualTo(ETAG);
      assertThat(handler.attempts()).isEqualTo(3);
    }
  }

  @Test
  public void listMultipartUploads_retriesOn503() throws Exception {
    FailFirst handler =
        new FailFirst(
            2,
            SERVICE_UNAVAILABLE,
            xml(
                "<ListMultipartUploadsResult><Bucket>test-bucket</Bucket>"
                    + "</ListMultipartUploadsResult>"));

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      ListMultipartUploadsResponse response =
          client.listMultipartUploads(
              ListMultipartUploadsRequest.builder().bucket("test-bucket").build());

      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(handler.attempts()).isEqualTo(3);
    }
  }

  @Test
  public void createMultipartUpload_isNonIdempotent_doesNotRetry_surfacesHttpStatusCode()
      throws Exception {
    FailFirst handler = new FailFirst(Integer.MAX_VALUE, SERVICE_UNAVAILABLE, null);

    try (FakeHttpServer server = FakeHttpServer.of(handler)) {
      MultipartUploadClient client = newClient(server);

      StorageException e =
          assertThrows(
              StorageException.class,
              () ->
                  client.createMultipartUpload(
                      CreateMultipartUploadRequest.builder()
                          .bucket("test-bucket")
                          .key("test-key")
                          .build()));

      assertThat(e.getCode()).isEqualTo(503);
      assertThat(handler.attempts()).isEqualTo(1);
    }
  }

  private static MultipartUploadClient newClient(FakeHttpServer server) {
    return MultipartUploadClient.create(MultipartUploadSettings.of(server.getHttpStorageOptions()));
  }

  private static UploadPartRequest uploadPartRequest() {
    return UploadPartRequest.builder()
        .bucket("test-bucket")
        .key("test-key")
        .uploadId("test-upload-id")
        .partNumber(1)
        .build();
  }

  private static HttpRequestHandler xml(String body) {
    return req -> {
      ByteBuf buf = Unpooled.wrappedBuffer(body.getBytes(StandardCharsets.UTF_8));
      DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
      resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
      return resp;
    };
  }

  /**
   * Responds to the first {@code failures} requests with {@code status}, then delegates to {@code
   * success}. Optionally records the body of every request received.
   */
  private static final class FailFirst implements HttpRequestHandler {
    private final int failures;
    private final HttpResponseStatus status;
    private final HttpRequestHandler success;
    private final List<byte[]> receivedBodies;
    private final AtomicInteger attempts = new AtomicInteger();

    private FailFirst(int failures, HttpResponseStatus status, HttpRequestHandler success) {
      this(failures, status, success, new CopyOnWriteArrayList<>());
    }

    private FailFirst(
        int failures,
        HttpResponseStatus status,
        HttpRequestHandler success,
        List<byte[]> receivedBodies) {
      this.failures = failures;
      this.status = status;
      this.success = success;
      this.receivedBodies = receivedBodies;
    }

    @Override
    public FullHttpResponse apply(HttpRequest req) throws Exception {
      int attempt = attempts.incrementAndGet();
      if (req instanceof FullHttpRequest) {
        ByteBuf content = ((FullHttpRequest) req).content();
        byte[] body = new byte[content.readableBytes()];
        content.getBytes(content.readerIndex(), body);
        receivedBodies.add(body);
      }
      if (attempt <= failures) {
        ByteBuf buf =
            Unpooled.wrappedBuffer(status.reasonPhrase().getBytes(StandardCharsets.UTF_8));
        FullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), status, buf);
        resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
        return resp;
      }
      return success.apply(req);
    }

    private int attempts() {
      return attempts.get();
    }
  }
}
