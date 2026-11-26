/*
 * Copyright 2021 Google LLC
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
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.Assert;
import org.junit.Test;

public final class ResumableMediaTest {
  private static final String SIGNED_URL_INVALID =
      "http://localhost/test-bucket/test1.txt?GoogAccessId=testClient-test@test.com&Expires=1553839761&Signature=MJUBXAZ7";
  private static final String SIGNED_URL_VALID =
      "http://localhost/test-bucket/test1.txt?GoogleAccessId=testClient-test@test.com&Expires=1553839761&Signature=MJUBXAZ7";

  @Test
  public void startUploadForSignedUrl_expectStorageException_whenUrlInvalid() throws Exception {
    try {
      ResumableMedia.startUploadForSignedUrl(
              HttpStorageOptions.newBuilder().build(),
              new URL(SIGNED_URL_INVALID),
              RetrierWithAlg.attemptOnce())
          .get();
      Assert.fail();
    } catch (StorageException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void startUploadForSignedUrl_whenUrlValid() throws Exception {
    StorageRpc rpc = mock(StorageRpc.class);
    HttpStorageOptions options =
        HttpStorageOptions.newBuilder().setServiceRpcFactory(opts -> rpc).build();

    URL url = new URL(SIGNED_URL_VALID);
    when(rpc.open(url.toString())).thenReturn("upload-id");

    Supplier<String> uploadIdSupplier =
        ResumableMedia.startUploadForSignedUrl(options, url, RetrierWithAlg.attemptOnce());
    assertThat(uploadIdSupplier.get()).isEqualTo("upload-id");
  }

  @Test
  public void writerUrl_requestsDoNotIncludeClientHeaders() throws Exception {
    RecordingTransport transport = new RecordingTransport();
    try (WriteChannel writer = newStorage(transport).writer(new URL(SIGNED_URL_VALID))) {
      writer.write(ByteBuffer.wrap(new byte[10]));
    }

    assertThat(transport.methods).containsExactly("POST", "PUT").inOrder();
    assertNoClientHeaders(transport);
  }

  @Test
  public void writerUrl_restoredWriterRequestsDoNotIncludeClientHeaders() throws Exception {
    RecordingTransport transport = new RecordingTransport();
    RestorableState<WriteChannel> state =
        newStorage(transport).writer(new URL(SIGNED_URL_VALID)).capture();
    try (WriteChannel writer = state.restore()) {
      writer.write(ByteBuffer.wrap(new byte[10]));
    }

    assertThat(transport.methods).containsExactly("POST", "PUT").inOrder();
    assertNoClientHeaders(transport);
  }

  @Test
  public void writerBlobInfo_requestsIncludeClientHeaders() throws Exception {
    RecordingTransport transport = new RecordingTransport();
    try (WriteChannel writer =
        newStorage(transport).writer(BlobInfo.newBuilder("b", "o").build())) {
      writer.write(ByteBuffer.wrap(new byte[10]));
    }

    assertThat(transport.methods).containsExactly("POST", "PUT").inOrder();
    for (Map<String, List<String>> headers : transport.headers) {
      assertThat(headers).containsKey("authorization");
      assertThat(headers).containsKey("x-goog-user-project");
      assertThat(headers).containsKey("x-custom");
    }
  }

  private static Storage newStorage(RecordingTransport transport) {
    return HttpStorageOptions.newBuilder()
        .setProjectId("p")
        .setHost("http://localhost")
        .setQuotaProjectId("q")
        .setHeaderProvider(FixedHeaderProvider.create("x-custom", "v"))
        .setCredentials(
            GoogleCredentials.create(
                new AccessToken("t", new Date(System.currentTimeMillis() + 3_600_000))))
        .setTransportOptions(
            HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build())
        .build()
        .getService();
  }

  private static void assertNoClientHeaders(RecordingTransport transport) {
    for (Map<String, List<String>> headers : transport.headers) {
      assertThat(headers).doesNotContainKey("authorization");
      assertThat(headers).doesNotContainKey("x-goog-user-project");
      assertThat(headers).doesNotContainKey("x-custom");
    }
  }

  private static final class RecordingTransport extends HttpTransport {
    private final List<String> methods = Collections.synchronizedList(new ArrayList<>());
    private final List<Map<String, List<String>>> headers =
        Collections.synchronizedList(new ArrayList<>());

    @Override
    protected LowLevelHttpRequest buildRequest(String method, String url) {
      return new MockLowLevelHttpRequest(url) {
        @Override
        public MockLowLevelHttpResponse execute() {
          methods.add(method);
          headers.add(getHeaders());
          if (method.equals("POST")) {
            return new MockLowLevelHttpResponse()
                .setStatusCode(url.contains("Signature=") ? 201 : 200)
                .addHeader("Location", "http://localhost/upload?upload_id=u");
          }
          return new MockLowLevelHttpResponse()
              .addHeader("Content-Type", "application/json; charset=UTF-8")
              .setContent("{\"bucket\":\"b\",\"name\":\"o\",\"size\":\"10\"}");
        }
      };
    }
  }
}
