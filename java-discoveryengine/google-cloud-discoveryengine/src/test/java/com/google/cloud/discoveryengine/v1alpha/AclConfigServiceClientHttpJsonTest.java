/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonAclConfigServiceStub;
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
public class AclConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AclConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAclConfigServiceStub.getMethodDescriptors(),
            AclConfigServiceSettings.getDefaultEndpoint());
    AclConfigServiceSettings settings =
        AclConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AclConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AclConfigServiceClient.create(settings);
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
  public void updateAclConfigTest() throws Exception {
    AclConfig expectedResponse =
        AclConfig.newBuilder()
            .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setIdpConfig(IdpConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    UpdateAclConfigRequest request =
        UpdateAclConfigRequest.newBuilder()
            .setAclConfig(
                AclConfig.newBuilder()
                    .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
                    .setIdpConfig(IdpConfig.newBuilder().build())
                    .build())
            .build();

    AclConfig actualResponse = client.updateAclConfig(request);
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
  public void updateAclConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateAclConfigRequest request =
          UpdateAclConfigRequest.newBuilder()
              .setAclConfig(
                  AclConfig.newBuilder()
                      .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
                      .setIdpConfig(IdpConfig.newBuilder().build())
                      .build())
              .build();
      client.updateAclConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAclConfigTest() throws Exception {
    AclConfig expectedResponse =
        AclConfig.newBuilder()
            .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setIdpConfig(IdpConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AclConfigName name = AclConfigName.of("[PROJECT]", "[LOCATION]");

    AclConfig actualResponse = client.getAclConfig(name);
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
  public void getAclConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AclConfigName name = AclConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAclConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAclConfigTest2() throws Exception {
    AclConfig expectedResponse =
        AclConfig.newBuilder()
            .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setIdpConfig(IdpConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-599/locations/location-599/aclConfig";

    AclConfig actualResponse = client.getAclConfig(name);
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
  public void getAclConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-599/locations/location-599/aclConfig";
      client.getAclConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
