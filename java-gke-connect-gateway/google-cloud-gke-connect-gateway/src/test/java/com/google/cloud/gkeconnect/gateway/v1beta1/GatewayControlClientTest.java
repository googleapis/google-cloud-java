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

package com.google.cloud.gkeconnect.gateway.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gkeconnect.gateway.v1beta1.stub.HttpJsonGatewayControlStub;
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
public class GatewayControlClientTest {
  private static MockHttpService mockService;
  private static GatewayControlClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGatewayControlStub.getMethodDescriptors(),
            GatewayControlSettings.getDefaultEndpoint());
    GatewayControlSettings settings =
        GatewayControlSettings.newBuilder()
            .setTransportChannelProvider(
                GatewayControlSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GatewayControlClient.create(settings);
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
  public void generateCredentialsTest() throws Exception {
    GenerateCredentialsResponse expectedResponse =
        GenerateCredentialsResponse.newBuilder()
            .setKubeconfig(ByteString.EMPTY)
            .setEndpoint("endpoint1741102485")
            .build();
    mockService.addResponse(expectedResponse);

    GenerateCredentialsRequest request =
        GenerateCredentialsRequest.newBuilder()
            .setName("projects/project-883/locations/location-883/memberships/membership-883")
            .setForceUseAgent(true)
            .setVersion("version351608024")
            .setKubernetesNamespace("kubernetesNamespace-1862862667")
            .build();

    GenerateCredentialsResponse actualResponse = client.generateCredentials(request);
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
  public void generateCredentialsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateCredentialsRequest request =
          GenerateCredentialsRequest.newBuilder()
              .setName("projects/project-883/locations/location-883/memberships/membership-883")
              .setForceUseAgent(true)
              .setVersion("version351608024")
              .setKubernetesNamespace("kubernetesNamespace-1862862667")
              .build();
      client.generateCredentials(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
