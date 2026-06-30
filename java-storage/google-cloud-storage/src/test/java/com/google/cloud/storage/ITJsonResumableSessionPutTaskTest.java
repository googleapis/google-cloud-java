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

import static com.google.cloud.storage.ByteSizeConstants._128KiBL;
import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.ByteSizeConstants._256KiBL;
import static com.google.cloud.storage.ByteSizeConstants._512KiBL;
import static com.google.cloud.storage.ByteSizeConstants._768KiBL;
import static com.google.common.truth.Truth.assertThat;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_RANGE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
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
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
@ParallelFriendly
public final class ITJsonResumableSessionPutTaskTest {
  private static final GsonFactory gson = GsonFactory.getDefaultInstance();
  private static final NetHttpTransport transport = new NetHttpTransport.Builder().build();
  private static final HttpResponseStatus RESUME_INCOMPLETE =
      HttpResponseStatus.valueOf(308, "Resume Incomplete");
  private static final HttpResponseStatus APPEND_GREATER_THAN_CURRENT_SIZE =
      HttpResponseStatus.valueOf(503, "");
  private HttpClientContext httpClientContext;

  @Rule public final TemporaryFolder temp = new TemporaryFolder();

  @Before
  public void setUp() throws Exception {
    httpClientContext =
        HttpClientContext.of(transport.createRequestFactory(), new JsonObjectParser(gson));
  }

  @Test
  public void emptyObjectHappyPath() throws Exception {

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

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(ByteRangeSpec.explicitClosed(0L, 0L), 0));

      ResumableOperationResult<@Nullable StorageObject> operationResult = task.call();
      StorageObject object = operationResult.getObject();
      assertThat(object).isNotNull();
      assertThat(operationResult.getPersistedSize()).isEqualTo(0L);
    }
  }

  /**
   *
   *
   * <h4>S.7</h4>
   *
   * GCS Acknowledges more bytes than were sent in the PUT
   *
   * <p>The client believes the server offset is N, it sends K bytes and the server responds that N
   * + 2K bytes are now committed.
   *
   * <p>The client has detected data loss and should raise an error and prevent sending of more
   * bytes.
   */
  @Test
  public void scenario7() throws Exception {

    HttpRequestHandler handler =
        req -> {
          String contentRangeString = req.headers().get(CONTENT_RANGE);
          HttpContentRange parse = HttpContentRange.parse(contentRangeString);
          long endInclusive = ((HttpContentRange.HasRange<?>) parse).range().endOffsetInclusive();
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
          ByteRangeSpec range = ByteRangeSpec.explicitClosed(0L, endInclusive + 1);
          resp.headers().set(HttpHeaderNames.RANGE, range.getHttpRangeHeader());
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(ByteRangeSpec.explicitClosed(0L, 10L)));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("dataLoss");
      assertThat(confirmedBytes.get()).isEqualTo(-1L);
    }
  }

  /**
   *
   *
   * <h4>S.1</h4>
   *
   * Attempting to append to a session which has already been finalized should raise an error
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = { name= obj, persisted_size = 524288 }
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 0, data = [0:262144]
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes 0-262143/*
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 200 OK
   * Content-Type: application/json; charset=utf-8
   *
   * {"name": "obj", "size": 524288}
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario1() throws Exception {
    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          URI uri = URI.create(req.uri());
          so.setName("object")
              .setBucket("bucket")
              .setGeneration(1L)
              .setMetageneration(1L)
              .setSize(BigInteger.valueOf(_512KiBL))
              .setMetadata(ImmutableMap.of("upload_id", uri.toString()));

          ByteBuf buf = Unpooled.wrappedBuffer(gson.toByteArray(so));
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler);
        TmpFile tmpFile =
            DataGenerator.base64Characters().tempFile(temp.newFolder().toPath(), _256KiBL)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.of(tmpFile.getPath()),
              HttpContentRange.of(ByteRangeSpec.explicit(0L, _256KiBL)));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("invalid");
      assertThat(confirmedBytes.get()).isEqualTo(-1L);
    }
  }

  /**
   *
   *
   * <h4>S.2</h4>
   *
   * Attempting to finalize a session with fewer bytes than GCS acknowledges.
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * persisted_size = 524288
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 262144, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes *&#47;262144
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 308 Resume Incomplete
   * Range: bytes=0-524287
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario2() throws Exception {

    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
          ByteRangeSpec range = ByteRangeSpec.explicit(0L, _512KiBL);
          resp.headers().set(HttpHeaderNames.RANGE, range.getHttpRangeHeader());
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(_256KiBL));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("invalid");
      assertThat(confirmedBytes.get()).isEqualTo(-1L);
    }
  }

  /**
   *
   *
   * <h4>S.3</h4>
   *
   * Attempting to finalize a session with more bytes than GCS acknowledges.
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * persisted_size = 262144
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes *&#47;524288
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 308 Resume Incomplete
   * Range: bytes=0-262143
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario3() throws Exception {

    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), RESUME_INCOMPLETE);
          ByteRangeSpec range = ByteRangeSpec.explicit(0L, _256KiBL);
          resp.headers().set(HttpHeaderNames.RANGE, range.getHttpRangeHeader());
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(_512KiBL));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("dataLoss");
      assertThat(confirmedBytes.get()).isEqualTo(-1L);
    }
  }

  /**
   *
   *
   * <h4>S.4</h4>
   *
   * Attempting to finalize an already finalized session
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = {name = obj1, size = 262114}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 262114, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes *&#47;262114
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 200 Ok
   * Content-Type: application/json; charset=utf-8
   *
   * {"name": "obj", "size": 262114}
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario4() throws Exception {

    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          URI uri = URI.create(req.uri());
          so.setName("object")
              .setBucket("bucket")
              .setGeneration(1L)
              .setMetageneration(1L)
              .setSize(BigInteger.valueOf(_256KiBL))
              .setMetadata(ImmutableMap.of("upload_id", uri.toString()));

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

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(_256KiBL));

      ResumableOperationResult<@Nullable StorageObject> operationResult = task.call();
      StorageObject call = operationResult.getObject();
      assertThat(call).isNotNull();
      assertThat(call.getMetadata()).containsEntry("upload_id", uri.getPath());
      assertThat(operationResult.getPersistedSize()).isEqualTo(_256KiBL);
    }
  }

  /**
   *
   *
   * <h4>S.4.1</h4>
   *
   * Attempting to finalize an already finalized session (ack &lt; expected)
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = {name = obj1, size = 262114}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes *&#47;524288
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 200 Ok
   * Content-Type: application/json; charset=utf-8
   *
   * {"name": "obj", "size": 262114}
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario4_1() throws Exception {

    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          URI uri = URI.create(req.uri());
          so.setName("object")
              .setBucket("bucket")
              .setGeneration(1L)
              .setMetageneration(1L)
              .setSize(BigInteger.valueOf(_256KiBL))
              .setMetadata(ImmutableMap.of("upload_id", uri.toString()));

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

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(_512KiBL));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("dataLoss");
      assertThat(confirmedBytes.get()).isEqualTo(-1);
    }
  }

  /**
   *
   *
   * <h4>S.4.2</h4>
   *
   * Attempting to finalize an already finalized session (ack > expected)
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = {name = obj1, size = 262114}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes *&#47;131072
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 200 Ok
   * Content-Type: application/json; charset=utf-8
   *
   * {"name": "obj", "size": 262114}
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario4_2() throws Exception {

    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          URI uri = URI.create(req.uri());
          so.setName("object")
              .setBucket("bucket")
              .setGeneration(1L)
              .setMetageneration(1L)
              .setSize(BigInteger.valueOf(_256KiBL))
              .setMetadata(ImmutableMap.of("upload_id", uri.toString()));

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

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(_128KiBL));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("dataLoss");
      assertThat(confirmedBytes.get()).isEqualTo(-1);
    }
  }

  /**
   *
   *
   * <h4>S.5</h4>
   *
   * Attempt to append to a resumable session with an offset higher than GCS expects
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * persisted_size = 262144
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, data = [524288:786432]
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * PUT $UPLOAD_ID
   * Content-Range: bytes 524288-786431&#47;*
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * 503
   * Content-Type: text/plain; charset=utf-8
   *
   * Invalid request. According to the Content-Range header, the upload offset is 524288 byte(s), which exceeds already uploaded size of 262144 byte(s).
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario5() throws Exception {

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

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler);
        TmpFile tmpFile =
            DataGenerator.base64Characters().tempFile(temp.newFolder().toPath(), _256KiBL)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.of(tmpFile.getPath()),
              HttpContentRange.of(ByteRangeSpec.explicit(_512KiBL, _768KiBL)));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo("dataLoss");
      assertThat(confirmedBytes.get()).isEqualTo(-1);
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

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler);
        TmpFile tmpFile =
            DataGenerator.base64Characters().tempFile(temp.newFolder().toPath(), _256KiBL)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.of(tmpFile.getPath()),
              HttpContentRange.of(ByteRangeSpec.explicit(_512KiBL, _768KiBL)));

      StorageException se = assertThrows(StorageException.class, task::call);
      assertThat(se.getCode()).isEqualTo(503);
      assertThat(confirmedBytes.get()).isEqualTo(-1);
    }
  }

  @Test
  public void jsonParseFailure() throws Exception {

    HttpRequestHandler handler =
        req -> {
          StorageObject so = new StorageObject();
          URI uri = URI.create(req.uri());
          so.setName("object")
              .setBucket("bucket")
              .setGeneration(1L)
              .setMetageneration(1L)
              .setSize(BigInteger.ZERO)
              .setMetadata(ImmutableMap.of("upload_id", uri.toString()));

          byte[] bytes = gson.toByteArray(so);
          ByteBuf buf = Unpooled.wrappedBuffer(bytes, 0, bytes.length / 2);
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      AtomicLong confirmedBytes = new AtomicLong(-1L);

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(0));

      StorageException se = assertThrows(StorageException.class, task::call);
      // the parse error happens while trying to read the success object, make sure we raise it as
      // a client side retryable exception
      assertThat(se.getCode()).isEqualTo(0);
      assertThat(se.getReason()).isEqualTo(null);
      // Finalization was successful, but we can't confirm the number of bytes due to the parse
      // error
      assertThat(confirmedBytes.get()).isEqualTo(-1);

      ResultRetryAlgorithm<?> idempotentHandler =
          StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler();
      boolean shouldRetry = idempotentHandler.shouldRetry(se, null);
      assertThat(shouldRetry).isTrue();
    }
  }

  @Test
  public void jsonDeserializationOnlyAttemptedWhenContentPresent() throws Exception {

    HttpRequestHandler handler =
        req -> {
          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
          resp.headers().set("x-goog-stored-content-length", "0");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      URI uri =
          fakeHttpServer.createUri(
              "/upload/{uploadId}", ImmutableMap.of("uploadId", UUID.randomUUID().toString()));

      JsonResumableSessionPutTask task =
          new JsonResumableSessionPutTask(
              httpClientContext,
              jsonResumableWrite(uri),
              RewindableContent.empty(),
              HttpContentRange.of(0));

      ResumableOperationResult<@Nullable StorageObject> operationResult = task.call();
      StorageObject call = operationResult.getObject();
      assertThat(call).isNull();
      assertThat(operationResult.getPersistedSize()).isEqualTo(0L);
    }
  }

  @Test
  public void attemptToRewindOutOfBoundsThrows_lower() {
    RewindableContent content = RewindableContent.of();
    JsonResumableSessionPutTask task =
        new JsonResumableSessionPutTask(
            null, null, content, HttpContentRange.of(ByteRangeSpec.relativeLength(10L, 10L)));

    IllegalArgumentException iae =
        assertThrows(IllegalArgumentException.class, () -> task.rewindTo(9));
    assertThat(iae).hasMessageThat().isEqualTo("Rewind offset is out of bounds. (10 <= 9 < 20)");
  }

  @Test
  public void attemptToRewindOutOfBoundsThrows_upper() {
    RewindableContent content = RewindableContent.of();
    JsonResumableSessionPutTask task =
        new JsonResumableSessionPutTask(
            null, null, content, HttpContentRange.of(ByteRangeSpec.relativeLength(10L, 10L)));

    IllegalArgumentException iae =
        assertThrows(IllegalArgumentException.class, () -> task.rewindTo(20));
    assertThat(iae).hasMessageThat().isEqualTo("Rewind offset is out of bounds. (10 <= 20 < 20)");
  }

  @Test
  public void repeatedRewindsToTheSameLocationWork() {
    ByteBuffer buf1 = DataGenerator.base64Characters().genByteBuffer(_256KiB);
    ByteBuffer buf2 = DataGenerator.base64Characters().genByteBuffer(_256KiB);
    RewindableContent content = RewindableContent.of(buf1, buf2);
    JsonResumableSessionPutTask task =
        new JsonResumableSessionPutTask(
            null, null, content, HttpContentRange.of(ByteRangeSpec.relativeLength(0L, _512KiBL)));

    task.rewindTo(0);
    assertThat(buf1.position()).isEqualTo(0);
    assertThat(buf2.position()).isEqualTo(0);

    int last = buf1.capacity();
    buf1.position(last);
    buf2.position(last);

    task.rewindTo(_256KiBL);
    assertThat(buf1.remaining()).isEqualTo(0);
    assertThat(buf2.position()).isEqualTo(0);

    task.rewindTo(_256KiBL);
    assertThat(buf1.remaining()).isEqualTo(0);
    assertThat(buf2.position()).isEqualTo(0);

    task.rewindTo(_256KiBL + 13);
    assertThat(buf1.remaining()).isEqualTo(0);
    assertThat(buf2.position()).isEqualTo(13);

    task.rewindTo(_256KiBL + 13);
    assertThat(buf1.remaining()).isEqualTo(0);
    assertThat(buf2.position()).isEqualTo(13);
  }

  static @NonNull JsonResumableWrite jsonResumableWrite(URI uploadUrl) {
    return JsonResumableWrite.of(new StorageObject(), ImmutableMap.of(), uploadUrl.toString(), 0);
  }
}
