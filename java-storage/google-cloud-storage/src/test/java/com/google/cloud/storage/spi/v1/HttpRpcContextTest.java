/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.cloud.NoCredentials;
import com.google.cloud.TransportOptions;
import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;

public class HttpRpcContextTest {
  @Test
  public void testNewInvocationId() {
    UUID uuid = UUID.fromString("28220dff-1e8b-4770-9e10-022c2a99d8f3");
    HttpRpcContext testContext = new HttpRpcContext(() -> uuid);

    try {
      assertThat(testContext.newInvocationId()).isEqualTo(uuid);
      assertThat(testContext.getInvocationId()).isEqualTo(uuid);
      // call again to ensure the id is consistent with our supplier
      assertThat(testContext.newInvocationId()).isEqualTo(uuid);
      assertThat(testContext.getInvocationId()).isEqualTo(uuid);
    } finally {
      testContext.clearInvocationId();
    }
  }

  @Test
  public void testInvocationIdIsPassedThrough() {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/json")
            .setContent(
                "{\n"
                    + "  \"kind\": \"storage#serviceAccount\",\n"
                    + "  \"email_address\":"
                    + " \"service-234234@gs-project-accounts.iam.gserviceaccount.com\"\n"
                    + "}\n")
            .setStatusCode(200);
    AuditingHttpTransport transport = new AuditingHttpTransport(response);
    TransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build();
    Storage service =
        StorageOptions.getDefaultInstance().toBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setTransportOptions(transportOptions)
            .build()
            .getService();
    service.getServiceAccount("test-project");
    Optional<Tuple<String, String>> anyXGoogApiClientWithGcclInvocationId =
        transport.getAddHeaderCalls().stream()
            .filter(t -> "x-goog-api-client".equals(t.x()) && t.y().contains("gccl-invocation-id/"))
            .findFirst();
    assertTrue(anyXGoogApiClientWithGcclInvocationId.isPresent());
    assertThat(transport.getBuildRequestCalls()).hasSize(1);
  }

  @Test
  public void testInvocationIdNotInSignedURL_v2() throws IOException {
    URL signedUrlV2 =
        new URL(
            "http://www.test.com/test-bucket/test1.txt?GoogleAccessId=testClient-test@test.com&Expires=1553839761&Signature=MJUBXAZ7");
    doTestInvocationIdNotInSignedURL(signedUrlV2);
  }

  @Test
  public void testInvocationIdNotInSignedURL_v4() throws IOException {
    URL signedUrlV4 =
        new URL(
            "http://www.test.com/test-bucket/test1.txt?X-Goog-Algorithm=&X-Goog-Credential=&X-Goog-Date=&X-Goog-Expires=&X-Goog-SignedHeaders=&X-Goog-Signature=MJUBXAZ7");
    doTestInvocationIdNotInSignedURL(signedUrlV4);
  }

  private void doTestInvocationIdNotInSignedURL(URL signedUrl) throws IOException {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("text/plain")
            .setHeaderNames(ImmutableList.of("Location"))
            .setHeaderValues(ImmutableList.of("http://test"))
            .setStatusCode(201);
    AuditingHttpTransport transport = new AuditingHttpTransport(response);
    TransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build();
    Storage service =
        StorageOptions.getDefaultInstance().toBuilder()
            .setTransportOptions(transportOptions)
            .build()
            .getService();
    WriteChannel writer = service.writer(signedUrl);
    writer.write(ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8)));
    Optional<Tuple<String, String>> anyXGoogApiClientWithGcclInvocationId =
        transport.getAddHeaderCalls().stream()
            .filter(t -> "x-goog-api-client".equals(t.x()) && t.y().contains("gccl-invocation-id/"))
            .findFirst();
    assertFalse(anyXGoogApiClientWithGcclInvocationId.isPresent());
    assertThat(transport.getBuildRequestCalls()).hasSize(1);
  }
}
