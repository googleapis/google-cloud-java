/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.security.publicca.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.security.publicca.v1beta1.stub.HttpJsonPublicCertificateAuthorityServiceStub;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PublicCertificateAuthorityServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PublicCertificateAuthorityServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPublicCertificateAuthorityServiceStub.getMethodDescriptors(),
            PublicCertificateAuthorityServiceSettings.getDefaultEndpoint());
    PublicCertificateAuthorityServiceSettings settings =
        PublicCertificateAuthorityServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PublicCertificateAuthorityServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PublicCertificateAuthorityServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void createExternalAccountKeyTest() throws Exception {
    ExternalAccountKey expectedResponse =
        ExternalAccountKey.newBuilder()
            .setName(
                ExternalAccountKeyName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_ACCOUNT_KEY]")
                    .toString())
            .setKeyId("keyId101944282")
            .setB64MacKey(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();

    ExternalAccountKey actualResponse = client.createExternalAccountKey(parent, externalAccountKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createExternalAccountKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
      client.createExternalAccountKey(parent, externalAccountKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExternalAccountKeyTest2() throws Exception {
    ExternalAccountKey expectedResponse =
        ExternalAccountKey.newBuilder()
            .setName(
                ExternalAccountKeyName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_ACCOUNT_KEY]")
                    .toString())
            .setKeyId("keyId101944282")
            .setB64MacKey(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();

    ExternalAccountKey actualResponse = client.createExternalAccountKey(parent, externalAccountKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createExternalAccountKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
      client.createExternalAccountKey(parent, externalAccountKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
