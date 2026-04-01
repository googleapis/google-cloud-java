/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.storage.ByteSizeConstants._256KiBL;
import static com.google.cloud.storage.ITJsonResumableSessionPutTaskTest.jsonResumableWrite;
import static com.google.common.truth.Truth.assertThat;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.FakeHttpServer.HttpRequestHandler;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.common.collect.ImmutableMap;
import io.grpc.netty.shaded.io.netty.buffer.ByteBuf;
import io.grpc.netty.shaded.io.netty.buffer.Unpooled;
import io.grpc.netty.shaded.io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus;
import java.math.BigInteger;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
@ParallelFriendly
public final class ITJsonResumableSessionQueryTaskTest {
  private static final GsonFactory gson = GsonFactory.getDefaultInstance();
  private static final NetHttpTransport transport = new NetHttpTransport.Builder().build();
  private static final HttpResponseStatus RESUME_INCOMPLETE =
      HttpResponseStatus.valueOf(308, "Resume Incomplete");
  private static final HttpResponseStatus APPEND_GREATER_THAN_CURRENT_SIZE =
      HttpResponseStatus.valueOf(503, "");

  private HttpClientContext httpClientContext;

  @Before
  public void setUp() throws Exception {
    httpClientContext =
        HttpClientContext.of(transport.createRequestFactory(), new JsonObjectParser(gson));
  }

  @Test
  public void successfulSession() throws Exception {
    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          so.setName("object-name").setSize(BigInteger.ZERO);
          ByteBuf buf = Unpooled.wrappedBuffer(gson.toByteArray(so));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      ResumableOperationResult<@Nullable StorageObject> result = task.call();
      StorageObject object = result.getObject();
      assertThat(object).isNotNull();
      assertThat(result.getPersistedSize()).isEqualTo(0L);
    }
  }

  @Test
  public void successfulSession_noObject() throws Exception {
    HttpRequestHandler handler =
        req -> {
          DefaultFullHttpResponse response = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          response.headers().set("X-Goog-Stored-Content-Length", 0);
          return response;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      ResumableOperationResult<@Nullable StorageObject> result = task.call();
      StorageObject object = result.getObject();
      assertThat(object).isNull();
      assertThat(result.getPersistedSize()).isEqualTo(0L);
    }
  }

  @Test
  public void incompleteSession() throws Exception {
    HttpRequestHandler handler =
        req -> {
          DefaultFullHttpResponse response =
              new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
          response
              .headers()
              .set(
                  HttpHeaderNames.RANGE,
                  ByteRangeSpec.relativeLength(0L, _256KiBL).getHttpRangeHeader());
          return response;
        };
    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      ResumableOperationResult<@Nullable StorageObject> result = task.call();
      assertThat(result.getPersistedSize()).isEqualTo(_256KiBL);
    }
  }

  @Test
  public void incompleteSession_missingRangeHeader() throws Exception {
    HttpRequestHandler handler =
        req -> new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      ResumableOperationResult<@Nullable StorageObject> result = task.call();
      assertThat(result.getPersistedSize()).isEqualTo(0);
      assertThat(result.getObject()).isNull();
    }
  }

  @Test
  public void successfulSession_noJson_noStoredContentLength() throws Exception {
    HttpRequestHandler handler = req -> new DefaultFullHttpResponse(req.protocolVersion(), OK);

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
    }
  }

  @Test
  public void successfulSession_noSize() throws Exception {
    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          so.setName("object-name");
          ByteBuf buf = Unpooled.wrappedBuffer(gson.toByteArray(so));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
    }
  }

  @Test
  public void query_badOffset() throws Exception {
    HttpRequestHandler handler =
        req -> {
          // error message from GCS circa 2023-02
          ByteBuf buf =
              Unpooled.wrappedBuffer(
                  "Invalid request. According to the Content-Range header, the upload offset is 524288 byte(s), which exceeds already uploaded size of 262144 byte(s)."
                      .getBytes(StandardCharsets.UTF_8));
          FullHttpResponse resp =
              new DefaultFullHttpResponse(
                  req.protocolVersion(), APPEND_GREATER_THAN_CURRENT_SIZE, buf);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("dataLoss");
    }
  }

  @Test
  public void _503_emptyBody() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), APPEND_GREATER_THAN_CURRENT_SIZE);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionQueryTask task =
          new JsonResumableSessionQueryTask(httpClientContext, jsonResumableWrite(uri));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(503);
    }
  }
}
