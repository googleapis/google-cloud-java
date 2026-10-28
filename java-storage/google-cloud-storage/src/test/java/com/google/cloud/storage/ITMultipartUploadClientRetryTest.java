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
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.SERVICE_UNAVAILABLE;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.FakeHttpServer.HttpRequestHandler;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CompletedMultipartUpload;
import com.google.cloud.storage.multipartupload.model.CompletedPart;
import com.google.cloud.storage.multipartupload.model.ListPartsRequest;
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
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Verify {@link MultipartUploadClient} (as constructed via the public factory) retries retryable
 * HTTP status codes returned by the XML API.
 */
@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
@ParallelFriendly
public final class ITMultipartUploadClientRetryTest {

  private static final String ETAG = "\"af1ed31420542285653c803a34aa839a\"";

  @Test
  public void uploadPart_503ThenSuccess_retriesWithIdenticalBody() throws Exception {
    byte[] contentBytes = "hello world".getBytes(StandardCharsets.UTF_8);
    int failures = 2;
    AtomicInteger count = new AtomicInteger(0);
    List<byte[]> bodies = new CopyOnWriteArrayList<>();
    HttpRequestHandler handler =
        req -> {
          bodies.add(readBody(req));
          if (count.incrementAndGet() <= failures) {
            return xmlError(req, SERVICE_UNAVAILABLE, "ServiceUnavailable", "try again");
          }
          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set("ETag", ETAG);
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadClient client =
          MultipartUploadClient.create(
              MultipartUploadSettings.of(fakeHttpServer.getHttpStorageOptions()));
      UploadPartResponse response =
          client.uploadPart(
              UploadPartRequest.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .partNumber(1)
                  .build(),
              RequestBody.of(ByteBuffer.wrap(contentBytes)));

      assertThat(response.eTag()).isEqualTo(ETAG);
      assertThat(count.get()).isEqualTo(failures + 1);
      for (byte[] body : bodies) {
        assertThat(body).isEqualTo(contentBytes);
      }
    }
  }

  @Test
  public void completeMultipartUpload_503ThenSuccess_retries() throws Exception {
    AtomicInteger count = new AtomicInteger(0);
    HttpRequestHandler handler =
        req -> {
          if (count.incrementAndGet() == 1) {
            return xmlError(req, SERVICE_UNAVAILABLE, "ServiceUnavailable", "try again");
          }
          String xml =
              "<CompleteMultipartUploadResult><Bucket>test-bucket</Bucket><Key>test-key</Key>"
                  + "<ETag>"
                  + ETAG
                  + "</ETag></CompleteMultipartUploadResult>";
          ByteBuf buf = Unpooled.wrappedBuffer(xml.getBytes(StandardCharsets.UTF_8));
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadClient client =
          MultipartUploadClient.create(
              MultipartUploadSettings.of(fakeHttpServer.getHttpStorageOptions()));
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
                                  CompletedPart.builder().partNumber(1).eTag("\"etag1\"").build()))
                          .build())
                  .build());

      assertThat(response.etag()).isEqualTo(ETAG);
      assertThat(count.get()).isEqualTo(2);
    }
  }

  @Test
  public void listParts_404_isNotRetried() throws Exception {
    AtomicInteger count = new AtomicInteger(0);
    HttpRequestHandler handler =
        req -> {
          count.incrementAndGet();
          return xmlError(req, NOT_FOUND, "NoSuchUpload", "The requested upload was not found.");
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadClient client =
          MultipartUploadClient.create(
              MultipartUploadSettings.of(fakeHttpServer.getHttpStorageOptions()));
      StorageException e =
          assertThrows(
              StorageException.class,
              () ->
                  client.listParts(
                      ListPartsRequest.builder()
                          .bucket("test-bucket")
                          .key("test-key")
                          .uploadId("test-upload-id")
                          .build()));

      assertThat(e.getCode()).isEqualTo(404);
      assertThat(e.getMessage()).contains("The requested upload was not found.");
      assertThat(count.get()).isEqualTo(1);
    }
  }

  private static byte[] readBody(HttpRequest req) {
    if (!(req instanceof FullHttpRequest)) {
      return new byte[0];
    }
    ByteBuf content = ((FullHttpRequest) req).content();
    byte[] bytes = new byte[content.readableBytes()];
    content.getBytes(content.readerIndex(), bytes);
    return bytes;
  }

  private static FullHttpResponse xmlError(
      HttpRequest req, HttpResponseStatus status, String code, String message) {
    String xml =
        "<?xml version='1.0' encoding='UTF-8'?><Error><Code>"
            + code
            + "</Code><Message>"
            + message
            + "</Message></Error>";
    ByteBuf buf = Unpooled.wrappedBuffer(xml.getBytes(StandardCharsets.UTF_8));
    DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), status, buf);
    resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
    return resp;
  }
}
