/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.OperatingSystemVersionServiceClient.ListOperatingSystemVersionsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonOperatingSystemVersionServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class OperatingSystemVersionServiceClientTest {
  private static MockHttpService mockService;
  private static OperatingSystemVersionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOperatingSystemVersionServiceStub.getMethodDescriptors(),
            OperatingSystemVersionServiceSettings.getDefaultEndpoint());
    OperatingSystemVersionServiceSettings settings =
        OperatingSystemVersionServiceSettings.newBuilder()
            .setTransportChannelProvider(
                OperatingSystemVersionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OperatingSystemVersionServiceClient.create(settings);
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
  public void getOperatingSystemVersionTest() throws Exception {
    OperatingSystemVersion expectedResponse =
        OperatingSystemVersion.newBuilder()
            .setName(
                OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]")
                    .toString())
            .setMajorVersion(-1298026414)
            .setMinorVersion(1136764494)
            .setMicroVersion(-33751459)
            .build();
    mockService.addResponse(expectedResponse);

    OperatingSystemVersionName name =
        OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]");

    OperatingSystemVersion actualResponse = client.getOperatingSystemVersion(name);
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
  public void getOperatingSystemVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OperatingSystemVersionName name =
          OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]");
      client.getOperatingSystemVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOperatingSystemVersionTest2() throws Exception {
    OperatingSystemVersion expectedResponse =
        OperatingSystemVersion.newBuilder()
            .setName(
                OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]")
                    .toString())
            .setMajorVersion(-1298026414)
            .setMinorVersion(1136764494)
            .setMicroVersion(-33751459)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-5058/operatingSystemVersions/operatingSystemVersion-5058";

    OperatingSystemVersion actualResponse = client.getOperatingSystemVersion(name);
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
  public void getOperatingSystemVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-5058/operatingSystemVersions/operatingSystemVersion-5058";
      client.getOperatingSystemVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOperatingSystemVersionsTest() throws Exception {
    OperatingSystemVersion responsesElement = OperatingSystemVersion.newBuilder().build();
    ListOperatingSystemVersionsResponse expectedResponse =
        ListOperatingSystemVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperatingSystemVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListOperatingSystemVersionsPagedResponse pagedListResponse =
        client.listOperatingSystemVersions(parent);

    List<OperatingSystemVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperatingSystemVersionsList().get(0), resources.get(0));

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
  public void listOperatingSystemVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listOperatingSystemVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOperatingSystemVersionsTest2() throws Exception {
    OperatingSystemVersion responsesElement = OperatingSystemVersion.newBuilder().build();
    ListOperatingSystemVersionsResponse expectedResponse =
        ListOperatingSystemVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperatingSystemVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListOperatingSystemVersionsPagedResponse pagedListResponse =
        client.listOperatingSystemVersions(parent);

    List<OperatingSystemVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperatingSystemVersionsList().get(0), resources.get(0));

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
  public void listOperatingSystemVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listOperatingSystemVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
