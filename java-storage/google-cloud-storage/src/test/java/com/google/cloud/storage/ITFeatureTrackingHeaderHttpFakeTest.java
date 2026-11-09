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

import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_ENCODING;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_RANGE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.LOCATION;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.PERMANENT_REDIRECT;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.storage.model.ComposeRequest;
import com.google.api.services.storage.model.ComposeRequest.SourceObjects;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.FakeHttpServer.HttpRequestHandler;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Bytes;
import io.grpc.netty.shaded.io.netty.buffer.ByteBuf;
import io.grpc.netty.shaded.io.netty.buffer.Unpooled;
import io.grpc.netty.shaded.io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpRequest;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpMethod;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpRequest;
import io.grpc.netty.shaded.io.netty.handler.codec.http.QueryStringDecoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * End-to-end verification, against an in-process fake HTTP/JSON server, that a parallel composite
 * upload reports {@link TrackedFeature#PCU} on every request it issues, and that a default write
 * session reports nothing.
 */
public final class ITFeatureTrackingHeaderHttpFakeTest {

  /** URL-safe base64 of a mask with only {@link TrackedFeature#PCU} (bit 0) set. */
  private static final String PCU_HEADER_VALUE = "AAAAAQ==";

  private static final byte[] CONTENT = DataGenerator.base64Characters().genBytes(3 * _256KiB);
  private static final GsonFactory gson = GsonFactory.getDefaultInstance();

  private ExecutorService exec;

  @Before
  public void setUp() {
    exec = Executors.newCachedThreadPool();
  }

  @After
  public void tearDown() {
    exec.shutdownNow();
  }

  @Test
  public void pcuSession_everyRequestCarriesFeatureTrackingHeader() throws Exception {
    InMemoryJsonStorage fake = new InMemoryJsonStorage();
    ParallelCompositeUploadBlobWriteSessionConfig pcu =
        BlobWriteSessionConfigs.parallelCompositeUpload()
            .withExecutorSupplier(ExecutorSupplier.useExecutor(exec))
            // 3 parts of 256KiB each
            .withBufferAllocationStrategy(BufferAllocationStrategy.simple(_256KiB))
            .withPartCleanupStrategy(PartCleanupStrategy.always());

    try (FakeHttpServer fakeServer = FakeHttpServer.of(fake);
        Storage storage =
            fakeServer.getHttpStorageOptions().toBuilder()
                .setRetrySettings(ServiceOptions.getNoRetrySettings())
                .setBlobWriteSessionConfig(pcu)
                .build()
                .getService()) {

      BlobInfo result = null;
      Exception caught = null;
      try {
        result = write(storage, BlobInfo.newBuilder("b", "o").build());
      } catch (Exception e) {
        // stash the failure so the fake's own errors can be reported alongside it
        caught = e;
      }

      BlobInfo finalResult = result;
      Exception finalCaught = caught;
      assertAll(
          () -> {
            if (finalCaught != null) {
              fake.handlerErrors.forEach(finalCaught::addSuppressed);
              throw finalCaught;
            }
          },
          () -> assertThat(fake.handlerErrors).isEmpty(),
          () -> assertThat(fake.insertCount.get()).isEqualTo(3),
          () -> assertThat(fake.composeCount.get()).isEqualTo(1),
          () -> assertThat(fake.deleteCount.get()).isEqualTo(3),
          // every single request issued by the session (3 part inserts + 1 compose + 3 deletes)
          // carried the header with the PCU bit set
          () -> assertThat(fake.requestCount.get()).isEqualTo(7),
          () ->
              assertThat(fake.featureHeaders)
                  .containsExactlyElementsIn(Collections.nCopies(7, PCU_HEADER_VALUE)),
          () -> assertThat(finalResult.getName()).isEqualTo("o"),
          () -> assertThat(xxd(fake.objects.get("o"))).isEqualTo(xxd(CONTENT)));
    }
  }

  @Test
  public void defaultSession_doesNotSendFeatureTrackingHeader() throws Exception {
    InMemoryJsonStorage fake = new InMemoryJsonStorage();

    try (FakeHttpServer fakeServer = FakeHttpServer.of(fake);
        Storage storage =
            fakeServer.getHttpStorageOptions().toBuilder()
                .setRetrySettings(ServiceOptions.getNoRetrySettings())
                .setBlobWriteSessionConfig(BlobWriteSessionConfigs.getDefault())
                .build()
                .getService()) {

      BlobInfo result = write(storage, BlobInfo.newBuilder("b", "o").build());

      assertAll(
          () -> assertThat(fake.handlerErrors).isEmpty(),
          () -> assertThat(fake.requestCount.get()).isAtLeast(1),
          () ->
              assertThat(fake.featureHeaders)
                  .containsExactlyElementsIn(
                      Collections.nCopies(fake.requestCount.get(), (String) null)),
          () -> assertThat(result.getName()).isEqualTo("o"),
          () -> assertThat(xxd(fake.objects.get("o"))).isEqualTo(xxd(CONTENT)));
    }
  }

  private static BlobInfo write(Storage storage, BlobInfo info) throws Exception {
    BlobWriteSession session = storage.blobWriteSession(info);
    try (WritableByteChannel c = session.open()) {
      ByteBuffer buf = ByteBuffer.wrap(CONTENT);
      while (buf.hasRemaining()) {
        c.write(buf);
      }
    }
    return session.getResult().get(30, TimeUnit.SECONDS);
  }

  /**
   * Minimal in-memory JSON API object store: supports multipart insert, resumable upload, compose
   * and delete, which is everything a parallel composite upload or default write session needs.
   * Records the {@link FeatureTracking#HEADER} value (or {@code null}) of every request received.
   */
  private static final class InMemoryJsonStorage implements HttpRequestHandler {
    private static final byte[] CRLF_CRLF = "\r\n\r\n".getBytes(StandardCharsets.UTF_8);
    private static final String UPLOAD_PREFIX = "/upload/storage/v1/b/b/o";
    private static final String OBJECT_PREFIX = "/storage/v1/b/b/o/";

    private final Map<String, byte[]> objects = new ConcurrentHashMap<>();
    private final Map<String, StorageObject> resumableUploads = new ConcurrentHashMap<>();
    private final List<@Nullable String> featureHeaders = new CopyOnWriteArrayList<>();
    private final List<Exception> handlerErrors = new CopyOnWriteArrayList<>();
    private final AtomicLong generations = new AtomicLong(1);
    private final AtomicInteger requestCount = new AtomicInteger();
    private final AtomicInteger insertCount = new AtomicInteger();
    private final AtomicInteger composeCount = new AtomicInteger();
    private final AtomicInteger deleteCount = new AtomicInteger();

    @Override
    public FullHttpResponse apply(HttpRequest req) {
      requestCount.getAndIncrement();
      featureHeaders.add(req.headers().get(FeatureTracking.HEADER));
      try {
        return dispatch(req);
      } catch (Exception e) {
        handlerErrors.add(e);
        return new DefaultFullHttpResponse(req.protocolVersion(), INTERNAL_SERVER_ERROR);
      }
    }

    private FullHttpResponse dispatch(HttpRequest req) throws Exception {
      QueryStringDecoder uri = new QueryStringDecoder(req.uri());
      String path = uri.path();
      byte[] body = body(req);

      if (req.method().equals(HttpMethod.POST) && path.startsWith(UPLOAD_PREFIX)) {
        String uploadType = uri.parameters().get("uploadType").get(0);
        if ("multipart".equals(uploadType)) {
          insertCount.getAndIncrement();
          return multipartInsert(req, body);
        } else if ("resumable".equals(uploadType)) {
          return startResumable(req, body);
        }
      } else if (req.method().equals(HttpMethod.PUT) && path.startsWith(UPLOAD_PREFIX)) {
        return resumablePut(req, uri, body);
      } else if (req.method().equals(HttpMethod.POST) && path.endsWith("/compose")) {
        composeCount.getAndIncrement();
        return compose(req, path, body);
      } else if (req.method().equals(HttpMethod.DELETE) && path.startsWith(OBJECT_PREFIX)) {
        deleteCount.getAndIncrement();
        String name = decode(path.substring(OBJECT_PREFIX.length()));
        return objects.remove(name) == null
            ? new DefaultFullHttpResponse(req.protocolVersion(), NOT_FOUND)
            : new DefaultFullHttpResponse(req.protocolVersion(), NO_CONTENT);
      }
      return new DefaultFullHttpResponse(req.protocolVersion(), BAD_REQUEST);
    }

    private FullHttpResponse multipartInsert(HttpRequest req, byte[] body) throws Exception {
      String contentType = req.headers().get(CONTENT_TYPE);
      String boundary =
          contentType.substring(contentType.indexOf("boundary=") + "boundary=".length());
      byte[] delimiter = ("\r\n--" + boundary).getBytes(StandardCharsets.UTF_8);

      // part 1: json metadata
      int metadataStart = Bytes.indexOf(body, CRLF_CRLF) + CRLF_CRLF.length;
      int metadataEnd = indexOf(body, delimiter, metadataStart);
      StorageObject metadata =
          gson.fromString(
              new String(body, metadataStart, metadataEnd - metadataStart, StandardCharsets.UTF_8),
              StorageObject.class);
      // part 2: media
      int mediaStart = indexOf(body, CRLF_CRLF, metadataEnd) + CRLF_CRLF.length;
      int mediaEnd = indexOf(body, delimiter, mediaStart);
      byte[] media = Arrays.copyOfRange(body, mediaStart, mediaEnd);
      return json(req, put(metadata, media));
    }

    private FullHttpResponse startResumable(HttpRequest req, byte[] body) throws Exception {
      StorageObject metadata =
          gson.fromString(new String(body, StandardCharsets.UTF_8), StorageObject.class);
      String uploadId = "upload-" + generations.getAndIncrement();
      resumableUploads.put(uploadId, metadata);
      String host = req.headers().get("Host");
      FullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
      resp.headers()
          .set(
              LOCATION,
              "http://" + host + UPLOAD_PREFIX + "?uploadType=resumable&upload_id=" + uploadId);
      return resp;
    }

    private FullHttpResponse resumablePut(HttpRequest req, QueryStringDecoder uri, byte[] body)
        throws Exception {
      String uploadId = uri.parameters().get("upload_id").get(0);
      StorageObject metadata = resumableUploads.get(uploadId);
      String contentRange = req.headers().get(CONTENT_RANGE);
      if (contentRange == null || contentRange.endsWith("/*")) {
        // keep the fake simple: everything must arrive in a single, finalizing PUT
        return new DefaultFullHttpResponse(req.protocolVersion(), PERMANENT_REDIRECT);
      }
      return json(req, put(metadata, body));
    }

    private FullHttpResponse compose(HttpRequest req, String path, byte[] body) throws Exception {
      ComposeRequest composeRequest =
          gson.fromString(new String(body, StandardCharsets.UTF_8), ComposeRequest.class);
      ByteArrayOutputStream composed = new ByteArrayOutputStream();
      for (SourceObjects source : composeRequest.getSourceObjects()) {
        byte[] bytes = objects.get(source.getName());
        if (bytes == null) {
          return new DefaultFullHttpResponse(req.protocolVersion(), NOT_FOUND);
        }
        composed.write(bytes, 0, bytes.length);
      }
      String name =
          decode(path.substring(OBJECT_PREFIX.length(), path.length() - "/compose".length()));
      StorageObject destination = composeRequest.getDestination().setName(name);
      return json(req, put(destination, composed.toByteArray()));
    }

    /** Stores {@code bytes} under {@code metadata}'s name, echoing the custom metadata. */
    private StorageObject put(StorageObject metadata, byte[] bytes) {
      objects.put(metadata.getName(), bytes);
      return new StorageObject()
          .setBucket("b")
          .setName(metadata.getName())
          .setGeneration(generations.getAndIncrement())
          .setSize(BigInteger.valueOf(bytes.length))
          .setMetadata(metadata.getMetadata())
          .setCrc32c(Utils.crc32cCodec.encode(Hashing.crc32c().hashBytes(bytes).asInt()));
    }

    private static FullHttpResponse json(HttpRequest req, StorageObject object) throws Exception {
      ByteBuf buf = Unpooled.wrappedBuffer(gson.toByteArray(object));
      FullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
      resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
      return resp;
    }

    /** The request body, gunzipped when the client compressed it. */
    private static byte[] body(HttpRequest req) throws Exception {
      if (!(req instanceof FullHttpRequest)) {
        return new byte[0];
      }
      byte[] bytes = toBytes(((FullHttpRequest) req).content());
      if ("gzip".equals(req.headers().get(CONTENT_ENCODING))) {
        try (GZIPInputStream in = new GZIPInputStream(new ByteArrayInputStream(bytes))) {
          return ByteStreams.toByteArray(in);
        }
      }
      return bytes;
    }

    private static byte[] toBytes(ByteBuf content) {
      byte[] bytes = new byte[content.readableBytes()];
      content.getBytes(content.readerIndex(), bytes);
      return bytes;
    }

    private static String decode(String s) throws Exception {
      return URLDecoder.decode(s, StandardCharsets.UTF_8.name());
    }

    private static int indexOf(byte[] array, byte[] target, int fromIndex) {
      int idx = Bytes.indexOf(Arrays.copyOfRange(array, fromIndex, array.length), target);
      return idx < 0 ? -1 : idx + fromIndex;
    }
  }
}
