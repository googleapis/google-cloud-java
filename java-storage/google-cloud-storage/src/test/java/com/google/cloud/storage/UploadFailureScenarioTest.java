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

import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.ByteSizeConstants._512KiB;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.UploadFailureScenario.SCENARIO_1;
import static com.google.cloud.storage.UploadFailureScenario.isContinue;
import static com.google.cloud.storage.UploadFailureScenario.isOk;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import io.grpc.Metadata;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import org.junit.Test;

public final class UploadFailureScenarioTest {
  private static final GsonFactory gson = GsonFactory.getDefaultInstance();

  @Test
  public void isOk_200() {
    assertThat(isOk(200)).isTrue();
  }

  @Test
  public void isOk_201() {
    assertThat(isOk(201)).isTrue();
  }

  @Test
  public void isContinue_308() {
    assertThat(isContinue(308)).isTrue();
  }

  @Test
  public void toStorageException_ioExceptionDuringContentResolutionAddedAsSuppressed()
      throws IOException {
    HttpRequest req =
        new MockHttpTransport()
            .createRequestFactory()
            .buildPutRequest(new GenericUrl("http://localhost:80980"), new EmptyContent());
    req.getHeaders().setContentLength(0L).setContentRange(HttpContentRange.of(0).getHeaderValue());

    HttpResponse resp = req.execute();
    resp.getHeaders().setContentType("text/plain; charset=utf-8").setContentLength(5L);

    StorageException storageException =
        UploadFailureScenario.SCENARIO_1.toStorageException(
            "uploadId",
            resp,
            new Cause(),
            () -> {
              throw new Kaboom();
            });

    assertThat(storageException.getCode()).isEqualTo(0);
    assertThat(storageException).hasCauseThat().isInstanceOf(Cause.class);
    assertThat(storageException.getSuppressed()).isNotEmpty();
    assertThat(storageException.getSuppressed()[0]).isInstanceOf(StorageException.class);
    assertThat(storageException.getSuppressed()[0]).hasCauseThat().isInstanceOf(Kaboom.class);
  }

  @Test
  public void multilineResponseBodyIsProperlyPrefixed() throws Exception {
    StorageObject so = new StorageObject();
    so.setName("object-name")
        .setSize(BigInteger.ZERO)
        .setGeneration(1L)
        .setMetageneration(2L)
        .setMetadata(
            ImmutableMap.of(
                "k1", "v1",
                "k2", "v2"));
    final String json = gson.toPrettyString(so);

    byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
    HttpRequest req =
        new MockHttpTransport()
            .createRequestFactory()
            .buildPutRequest(new GenericUrl("http://localhost:80980"), new EmptyContent());
    req.getHeaders().setContentLength(0L);

    HttpResponse resp = req.execute();
    resp.getHeaders()
        .setContentType("application/json; charset=utf-8")
        .setContentLength((long) bytes.length);

    StorageException storageException =
        UploadFailureScenario.SCENARIO_0.toStorageException("uploadId", resp, null, () -> json);

    assertThat(storageException.getCode()).isEqualTo(0);
    assertThat(storageException).hasMessageThat().contains("\t|<   \"generation\": \"1\",\n");
  }

  @Test
  public void xGoogStoredHeadersIncludedIfPresent() throws IOException {
    HttpRequest req =
        new MockHttpTransport()
            .createRequestFactory()
            .buildPutRequest(new GenericUrl("http://localhost:80980"), new EmptyContent());
    req.getHeaders().setContentLength(0L);

    HttpResponse resp = req.execute();
    resp.getHeaders()
        .set("X-Goog-Stored-Content-Length", "5")
        .set("x-goog-stored-content-encoding", "identity")
        .set("X-GOOG-STORED-SOMETHING", "blah")
        .setContentLength(0L);

    StorageException storageException =
        UploadFailureScenario.SCENARIO_0.toStorageException("uploadId", resp, null, () -> null);

    assertThat(storageException.getCode()).isEqualTo(0);
    assertThat(storageException).hasMessageThat().contains("|< x-goog-stored-content-length: 5");
    assertThat(storageException)
        .hasMessageThat()
        .contains("|< x-goog-stored-content-encoding: identity");
    assertThat(storageException).hasMessageThat().contains("|< x-goog-stored-something: blah");
  }

  @Test
  public void xGoogGcsIdempotencyTokenHeadersIncludedIfPresent() throws IOException {
    HttpRequest req =
        new MockHttpTransport()
            .createRequestFactory()
            .buildPutRequest(new GenericUrl("http://localhost:80980"), new EmptyContent());
    req.getHeaders().setContentLength(0L);

    HttpResponse resp = req.execute();
    resp.getHeaders().set("X-Goog-Gcs-Idempotency-Token", "5").setContentLength(0L);

    StorageException storageException =
        UploadFailureScenario.SCENARIO_0.toStorageException("uploadId", resp, null, () -> null);

    assertThat(storageException.getCode()).isEqualTo(0);
    assertThat(storageException).hasMessageThat().contains("|< x-goog-gcs-idempotency-token: 5");
  }

  @Test
  public void grpc_response() throws Exception {
    ChecksummedTestContent content =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(_256KiB));
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId("uploadId")
            .setChecksummedData(
                ChecksummedData.newBuilder()
                    .setContent(
                        ByteString.copyFrom(DataGenerator.base64Characters().genBytes(_256KiB)))
                    .build())
            .build();
    WriteObjectRequest req2 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(_256KiB)
            .setChecksummedData(
                ChecksummedData.newBuilder()
                    .setContent(ByteString.copyFrom(content.getBytes()))
                    .setCrc32C(content.getCrc32c())
                    .build())
            .build();
    WriteObjectRequest req3 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(_512KiB)
            .setFinishWrite(true)
            .setObjectChecksums(
                ObjectChecksums.newBuilder()
                    .setCrc32C(345)
                    .setMd5Hash(ByteString.copyFromUtf8("asdf"))
                    .build())
            .build();
    WriteObjectResponse resp1 =
        WriteObjectResponse.newBuilder()
            .setResource(Object.newBuilder().setName("obj").setSize(_512KiB).build())
            .build();
    GrpcCallContext context =
        GrpcCallContext.createDefault()
            .withExtraHeaders(
                ImmutableMap.of(
                    "x-goog-request-params",
                    ImmutableList.of("bucket=projects/_/bucket/bucket-name")));
    StorageException se =
        SCENARIO_1.toStorageException(ImmutableList.of(req1, req2, req3), resp1, context, null);
    assertAll(
        () ->
            assertThat(se)
                .hasMessageThat()
                .contains("x-goog-request-params: bucket=projects/_/bucket/bucket-name"),
        () -> assertThat(se).hasMessageThat().contains("upload_id: "),
        () -> assertThat(se).hasMessageThat().contains("0:262144"),
        () -> assertThat(se).hasMessageThat().contains(", crc32c: "), // from ChecksummedData
        () -> assertThat(se).hasMessageThat().contains("write_offset: "),
        () -> assertThat(se).hasMessageThat().contains("finish_write: "),
        () -> assertThat(se).hasMessageThat().contains("object_checksums: "),
        () -> assertThat(se).hasMessageThat().contains("crc32c: "), // from object_checksums
        () -> assertThat(se).hasMessageThat().contains("md5_hash: "),
        () -> assertThat(se).hasMessageThat().contains("resource {"));
  }

  @Test
  public void grpc_apiException() throws Exception {
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId("uploadId")
            .setChecksummedData(
                ChecksummedData.newBuilder()
                    .setContent(
                        ByteString.copyFrom(DataGenerator.base64Characters().genBytes(_256KiB)))
                    .build())
            .build();
    GrpcCallContext context = Retrying.newCallContext();
    Code code = Code.FAILED_PRECONDITION;
    Metadata trailers = new Metadata();
    trailers.put(GrpcUtil.USER_AGENT_KEY, "test-class/");
    StatusRuntimeException statusRuntimeException =
        code.toStatus().withDescription("precondition did not hold").asRuntimeException(trailers);
    ApiException apiException =
        ApiExceptionFactory.createException(statusRuntimeException, GrpcStatusCode.of(code), true);

    StorageException se =
        SCENARIO_1.toStorageException(ImmutableList.of(req1), null, context, apiException);
    assertAll(
        () -> assertThat(se).hasMessageThat().contains("upload_id: "),
        () -> assertThat(se).hasMessageThat().contains("0:262144"),
        () -> assertThat(se).hasMessageThat().doesNotContain("WriteObjectResponse"),
        () -> assertThat(se).hasMessageThat().contains("Status{code=FAILED_PRECONDITION"),
        () -> assertThat(se).hasMessageThat().contains("user-agent=test-class/"));
  }

  @Test
  public void grpc_nonApiException() throws Exception {
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId("uploadId")
            .setChecksummedData(
                ChecksummedData.newBuilder()
                    .setContent(
                        ByteString.copyFrom(DataGenerator.base64Characters().genBytes(_256KiB)))
                    .build())
            .build();
    GrpcCallContext context = Retrying.newCallContext();
    Cause cause = new Cause();
    StorageException se =
        SCENARIO_1.toStorageException(ImmutableList.of(req1), null, context, cause);
    assertAll(
        () -> assertThat(se).hasMessageThat().contains("upload_id: "),
        () -> assertThat(se).hasMessageThat().contains("0:262144"),
        () -> assertThat(se).hasMessageThat().doesNotContain("WriteObjectResponse"));
  }

  private static final class Cause extends RuntimeException {

    private Cause() {
      super("Cause");
    }
  }

  private static final class Kaboom extends IOException {

    private Kaboom() {
      super("Kaboom!!!");
    }
  }
}
