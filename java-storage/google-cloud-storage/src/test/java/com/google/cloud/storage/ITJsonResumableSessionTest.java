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

import static com.google.cloud.storage.ByteSizeConstants._1MiB;
import static com.google.cloud.storage.ByteSizeConstants._1MiBL;
import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.ByteSizeConstants._256KiBL;
import static com.google.cloud.storage.ByteSizeConstants._512KiB;
import static com.google.cloud.storage.ByteSizeConstants._512KiBL;
import static com.google.cloud.storage.ByteSizeConstants._768KiBL;
import static com.google.common.truth.Truth.assertThat;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_RANGE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.RANGE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.SERVICE_UNAVAILABLE;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.FakeHttpServer.HttpRequestHandler;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.grpc.netty.shaded.io.netty.buffer.ByteBuf;
import io.grpc.netty.shaded.io.netty.buffer.Unpooled;
import io.grpc.netty.shaded.io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpRequest;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public final class ITJsonResumableSessionTest {
  private static final GsonFactory gson = GsonFactory.getDefaultInstance();
  private static final NetHttpTransport transport = new NetHttpTransport.Builder().build();
  private static final HttpResponseStatus RESUME_INCOMPLETE =
      HttpResponseStatus.valueOf(308, "Resume Incomplete");
  private static final RetrierWithAlg RETRIER =
      new DefaultRetrier(
              UnaryOperator.identity(),
              RetryingDependencies.simple(
                  NanoClock.getDefaultClock(),
                  RetrySettings.newBuilder().setMaxAttempts(3).build()))
          .withAlg(StorageRetryStrategy.getUniformStorageRetryStrategy().getIdempotentHandler());
  private HttpClientContext httpClientContext;

  @Rule public final TemporaryFolder temp = new TemporaryFolder();

  @Before
  public void setUp() throws Exception {
    httpClientContext =
        HttpClientContext.of(transport.createRequestFactory(), new JsonObjectParser(gson));
  }

  @Test
  public void rewindWillQueryStatusOnlyWhenDirty() throws Exception {
    HttpContentRange range1 = HttpContentRange.of(ByteRangeSpec.explicit(0L, _512KiBL));
    HttpContentRange range2 = HttpContentRange.query();
    HttpContentRange range3 = HttpContentRange.of(ByteRangeSpec.explicit(_256KiBL, _512KiBL));

    final List<HttpRequest> requests = Collections.synchronizedList(new ArrayList<>());
    HttpRequestHandler handler =
        req -> {
          requests.add(req);
          String contentRange = req.headers().get(CONTENT_RANGE);
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
          if (range1.getHeaderValue().equals(contentRange)) {
            return new DefaultFullHttpResponse(req.protocolVersion(), SERVICE_UNAVAILABLE);
          } else if (range2.getHeaderValue().equals(contentRange)) {
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _256KiBL).getHttpRangeHeader());
          } else {
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _512KiBL).getHttpRangeHeader());
          }
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler);
        TmpFile tmpFile =
            DataGenerator.base64Characters().tempFile(temp.newFolder().toPath(), _512KiBL)) {
      String uploadUrl =
          fakeHttpServer
              .createUri(
                  "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()))
              .toString();

      JsonResumableWrite resumableWrite =
          JsonResumableWrite.of(null, ImmutableMap.of(), uploadUrl, 0);
      JsonResumableSession session =
          new JsonResumableSession(httpClientContext, RETRIER, resumableWrite);

      ResumableOperationResult<@Nullable StorageObject> operationResult =
          session.put(RewindableContent.of(tmpFile.getPath()), range1);
      StorageObject call = operationResult.getObject();
      assertThat(call).isNull();
      assertThat(operationResult.getPersistedSize()).isEqualTo(_512KiBL);
    }

    List<String> actual =
        requests.stream().map(r -> r.headers().get(CONTENT_RANGE)).collect(Collectors.toList());

    List<String> expected =
        ImmutableList.of(range1.getHeaderValue(), range2.getHeaderValue(), range3.getHeaderValue());

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void retryAttemptWillReturnQueryResultIfPersistedSizeMatchesSpecifiedEndOffset()
      throws Exception {
    HttpContentRange range1 = HttpContentRange.of(ByteRangeSpec.explicit(0L, _512KiBL));
    HttpContentRange range2 = HttpContentRange.query();
    HttpContentRange range3 = HttpContentRange.of(ByteRangeSpec.explicit(_512KiBL, _768KiBL));

    final List<HttpRequest> requests = Collections.synchronizedList(new ArrayList<>());
    HttpRequestHandler handler =
        req -> {
          requests.add(req);
          String contentRange = req.headers().get(CONTENT_RANGE);
          DefaultFullHttpResponse resp;
          if (range1.getHeaderValue().equals(contentRange)) {
            resp = new DefaultFullHttpResponse(req.protocolVersion(), SERVICE_UNAVAILABLE);
          } else if (range2.getHeaderValue().equals(contentRange)) {
            resp = new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _512KiBL).getHttpRangeHeader());
          } else {
            resp = new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers()
                .set(RANGE, ByteRangeSpec.explicit(_512KiBL, _768KiBL).getHttpRangeHeader());
          }
          return resp;
        };

    ByteBuffer buf1 = DataGenerator.base64Characters().genByteBuffer(_512KiB);
    ByteBuffer buf2 = DataGenerator.base64Characters().genByteBuffer(_256KiB);

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      String uploadUrl =
          fakeHttpServer
              .createUri(
                  "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()))
              .toString();

      JsonResumableWrite resumableWrite =
          JsonResumableWrite.of(null, ImmutableMap.of(), uploadUrl, 0);
      JsonResumableSession session =
          new JsonResumableSession(httpClientContext, RETRIER, resumableWrite);

      ResumableOperationResult<@Nullable StorageObject> operationResult1 =
          session.put(RewindableContent.of(buf1), range1);
      StorageObject call1 = operationResult1.getObject();
      assertThat(call1).isNull();
      assertThat(operationResult1.getPersistedSize()).isEqualTo(_512KiBL);

      ResumableOperationResult<@Nullable StorageObject> operationResult2 =
          session.put(RewindableContent.of(buf2), range3);
      StorageObject call2 = operationResult2.getObject();
      assertThat(call2).isNull();
      assertThat(operationResult2.getPersistedSize()).isEqualTo(_768KiBL);
    }

    List<String> actual =
        requests.stream().map(r -> r.headers().get(CONTENT_RANGE)).collect(Collectors.toList());

    List<String> expected =
        ImmutableList.of(range1.getHeaderValue(), range2.getHeaderValue(), range3.getHeaderValue());

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void rewindOfContentIsRelativeToItsBeginOffsetOfTheOverallObject() throws Exception {
    HttpContentRange range1 = HttpContentRange.of(ByteRangeSpec.explicit(0L, _512KiBL));
    HttpContentRange range2 = HttpContentRange.of(ByteRangeSpec.explicit(_512KiBL, _768KiBL));
    HttpContentRange range3 = HttpContentRange.query();

    final AtomicBoolean fail = new AtomicBoolean(true);
    final List<HttpRequest> requests = Collections.synchronizedList(new ArrayList<>());
    HttpRequestHandler handler =
        req -> {
          requests.add(req);
          String contentRange = req.headers().get(CONTENT_RANGE);
          DefaultFullHttpResponse resp;
          if (range1.getHeaderValue().equals(contentRange)
              || range3.getHeaderValue().equals(contentRange)) {
            resp = new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _512KiBL).getHttpRangeHeader());
          } else if (range2.getHeaderValue().equals(contentRange)) {
            if (fail.getAndSet(false)) {
              resp = new DefaultFullHttpResponse(req.protocolVersion(), SERVICE_UNAVAILABLE);
            } else {
              resp = new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
              resp.headers()
                  .set(RANGE, ByteRangeSpec.explicit(_512KiBL, _768KiBL).getHttpRangeHeader());
            }
          } else {
            resp = new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers()
                .set(RANGE, ByteRangeSpec.explicit(_512KiBL, _768KiBL).getHttpRangeHeader());
          }
          return resp;
        };

    ByteBuffer buf1 = DataGenerator.base64Characters().genByteBuffer(_512KiB);
    ByteBuffer buf2 = DataGenerator.base64Characters().genByteBuffer(_256KiB);

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      String uploadUrl =
          fakeHttpServer
              .createUri(
                  "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()))
              .toString();

      JsonResumableWrite resumableWrite =
          JsonResumableWrite.of(null, ImmutableMap.of(), uploadUrl, 0);
      JsonResumableSession session =
          new JsonResumableSession(httpClientContext, RETRIER, resumableWrite);

      ResumableOperationResult<@Nullable StorageObject> operationResult1 =
          session.put(RewindableContent.of(buf1), range1);
      StorageObject call1 = operationResult1.getObject();
      assertThat(call1).isNull();
      assertThat(operationResult1.getPersistedSize()).isEqualTo(_512KiBL);

      ResumableOperationResult<@Nullable StorageObject> operationResult2 =
          session.put(RewindableContent.of(buf2), range2);
      StorageObject call2 = operationResult2.getObject();
      assertThat(call2).isNull();
      assertThat(operationResult2.getPersistedSize()).isEqualTo(_768KiBL);
    }

    List<String> actual =
        requests.stream().map(r -> r.headers().get(CONTENT_RANGE)).collect(Collectors.toList());

    List<String> expected =
        ImmutableList.of(
            range1.getHeaderValue(),
            range2.getHeaderValue(),
            range3.getHeaderValue(),
            range2.getHeaderValue());

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void finalChunkContainsCorrectCrc32cHeader() throws Exception {
    ChecksummedTestContent ctc = ChecksummedTestContent.gen(_512KiB);
    String expectedHashHeader = "crc32c=" + ctc.getCrc32cBase64();
    List<ChecksummedTestContent> chunks = ctc.chunkup(_256KiB);
    ChecksummedTestContent chunk1 = chunks.get(0);
    ChecksummedTestContent chunk2 = chunks.get(1);

    AtomicReference<String> capturedInitialHash = new AtomicReference<>();
    AtomicReference<String> capturedFinalHash = new AtomicReference<>();

    HttpRequestHandler handler =
        req -> {
          String contentRange = req.headers().get(CONTENT_RANGE);
          String currentHash = req.headers().get("x-goog-hash");

          if (contentRange.contains("/*")) { // First chunk (non-final)
            capturedInitialHash.set(currentHash);
            FullHttpResponse resp =
                new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers()
                .set(
                    HttpHeaderNames.RANGE,
                    ByteRangeSpec.explicit(0L, _256KiBL).getHttpRangeHeader());
            return resp;
          } else { // Second chunk (final)
            capturedFinalHash.set(currentHash);

            StorageObject so =
                new StorageObject().setName("object").setSize(BigInteger.valueOf(_512KiBL));
            ByteBuf buf = Unpooled.wrappedBuffer(gson.toByteArray(so));
            FullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
            resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
            return resp;
          }
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      String uploadUrl =
          fakeHttpServer
              .createUri(
                  "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()))
              .toString();

      JsonResumableWrite resumableWrite =
          JsonResumableWrite.of(
              null, ImmutableMap.of(), uploadUrl, 0, Hasher.enabled(), Crc32cValue.zero());
      JsonResumableSession session =
          new JsonResumableSession(httpClientContext, RETRIER, resumableWrite);

      ResumableOperationResult<@Nullable StorageObject> put1 =
          session.put(
              RewindableContent.of(chunk1.asByteBuffer()),
              HttpContentRange.of(ByteRangeSpec.explicit(0L, _256KiBL)));
      assertThat(put1.getObject()).isNull();
      assertThat(put1.getPersistedSize()).isEqualTo(_256KiBL);

      ResumableOperationResult<@Nullable StorageObject> put2 =
          session.put(
              RewindableContent.of(chunk2.asByteBuffer()),
              HttpContentRange.of(ByteRangeSpec.explicit(0L, _256KiBL), ctc.length()));
      assertThat(put2.getObject()).isNotNull();
      assertThat(put2.getPersistedSize()).isEqualTo(_512KiBL);

      assertThat(capturedInitialHash.get()).isNull();
      assertThat(capturedFinalHash.get()).isEqualTo(expectedHashHeader);
    }
  }

  @Test
  public void retriesOfPartiallyConsumedBytesChecksumCorrectly() throws Exception {
    ChecksummedTestContent ctc = ChecksummedTestContent.gen(_1MiB);
    String expectedFullHashHeader = "crc32c=" + ctc.getCrc32cBase64();
    ChecksummedTestContent chunk1 = ctc.slice(0, _256KiB);
    ChecksummedTestContent chunk2 = ctc.slice(_256KiB, _256KiB);
    ChecksummedTestContent chunk3 = ctc.slice(_512KiB, _512KiB);
    HttpContentRange expectedContentRange1 =
        HttpContentRange.of(ByteRangeSpec.explicit(0L, (long) chunk1.length()));
    HttpContentRange expectedContentRange2 =
        HttpContentRange.of(ByteRangeSpec.explicit(_256KiBL, _256KiBL + chunk2.length()));
    HttpContentRange expectedContentrange3 =
        HttpContentRange.of(ByteRangeSpec.explicit(_512KiBL, (long) ctc.length()), ctc.length());
    HttpContentRange retriedFullContentRange =
        HttpContentRange.of(ByteRangeSpec.explicit(_768KiBL, (long) ctc.length()), ctc.length());

    AtomicLong requestCount = new AtomicLong(0);
    List<String> hashes = Collections.synchronizedList(new ArrayList<>());

    HttpRequestHandler handler =
        req -> {
          requestCount.incrementAndGet();
          HttpContentRange contentRange =
              HttpContentRange.parse(req.headers().get("Content-Range"));
          String hashHeader = req.headers().get("x-goog-hash");
          if (hashHeader != null) {
            hashes.add(hashHeader);
          }

          if (expectedContentRange1.equals(contentRange)) {
            DefaultFullHttpResponse resp =
                new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _256KiBL).getHttpRangeHeader());
            return resp;
          } else if (expectedContentRange2.equals(contentRange)) {
            DefaultFullHttpResponse resp =
                new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _512KiBL).getHttpRangeHeader());
            return resp;
          } else if (expectedContentrange3.equals(contentRange)) {
            // simulate a broken connection -- except instead of breaking the connection (which is
            // very difficult to do with netty) return a 503.
            return new DefaultFullHttpResponse(
                req.protocolVersion(), HttpResponseStatus.SERVICE_UNAVAILABLE);
          } else if (HttpContentRange.query().equals(contentRange)) {
            DefaultFullHttpResponse resp =
                new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
            resp.headers().set(RANGE, ByteRangeSpec.explicit(0L, _768KiBL).getHttpRangeHeader());
            return resp;
          } else if (retriedFullContentRange.equals(contentRange)) {
            StorageObject so =
                new StorageObject().setName("object").setSize(BigInteger.valueOf(_1MiB));
            ByteBuf buf = Unpooled.wrappedBuffer(gson.toByteArray(so));
            DefaultFullHttpResponse resp =
                new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
            resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
            return resp;
          }
          return new DefaultFullHttpResponse(
              req.protocolVersion(), HttpResponseStatus.INTERNAL_SERVER_ERROR);
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      String uploadUrl =
          fakeHttpServer
              .createUri(
                  "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()))
              .toString();

      JsonResumableWrite resumableWrite =
          JsonResumableWrite.of(
              null, ImmutableMap.of(), uploadUrl, 0, Hasher.enabled(), Crc32cValue.zero());
      JsonResumableSession session =
          new JsonResumableSession(httpClientContext, RETRIER, resumableWrite);

      ResumableOperationResult<@Nullable StorageObject> result1 =
          session.put(
              RewindableContent.of(chunk1.asByteBuffer()),
              HttpContentRange.of(ByteRangeSpec.explicit(0L, _256KiBL)));
      assertThat(result1.getObject()).isNull();
      assertThat(result1.getPersistedSize()).isEqualTo(_256KiBL);
      ResumableOperationResult<@Nullable StorageObject> result2 =
          session.put(
              RewindableContent.of(chunk2.asByteBuffer()),
              HttpContentRange.of(ByteRangeSpec.explicit(_256KiBL, _512KiBL)));
      assertThat(result2.getObject()).isNull();
      assertThat(result2.getPersistedSize()).isEqualTo(_512KiBL);
      ResumableOperationResult<@Nullable StorageObject> result3 =
          session.put(
              RewindableContent.of(chunk3.asByteBuffer()),
              HttpContentRange.of(ByteRangeSpec.explicit(_512KiBL, _1MiBL), ctc.length()));
      assertThat(result3.getObject()).isNotNull();
      assertThat(result3.getPersistedSize()).isEqualTo(_1MiBL);

      assertThat(requestCount.get()).isEqualTo(5);
      assertThat(hashes)
          .isEqualTo(ImmutableList.of(expectedFullHashHeader, expectedFullHashHeader));
    }
  }
}
