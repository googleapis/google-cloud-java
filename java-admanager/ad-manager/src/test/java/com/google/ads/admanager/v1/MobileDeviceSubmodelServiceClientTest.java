/*
 * Copyright 2026 Google LLC
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

import static com.google.ads.admanager.v1.MobileDeviceSubmodelServiceClient.ListMobileDeviceSubmodelsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonMobileDeviceSubmodelServiceStub;
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
public class MobileDeviceSubmodelServiceClientTest {
  private static MockHttpService mockService;
  private static MobileDeviceSubmodelServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMobileDeviceSubmodelServiceStub.getMethodDescriptors(),
            MobileDeviceSubmodelServiceSettings.getDefaultEndpoint());
    MobileDeviceSubmodelServiceSettings settings =
        MobileDeviceSubmodelServiceSettings.newBuilder()
            .setTransportChannelProvider(
                MobileDeviceSubmodelServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MobileDeviceSubmodelServiceClient.create(settings);
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
  public void getMobileDeviceSubmodelTest() throws Exception {
    MobileDeviceSubmodel expectedResponse =
        MobileDeviceSubmodel.newBuilder()
            .setName(
                MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMobileDevice(MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    MobileDeviceSubmodelName name =
        MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]");

    MobileDeviceSubmodel actualResponse = client.getMobileDeviceSubmodel(name);
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
  public void getMobileDeviceSubmodelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MobileDeviceSubmodelName name =
          MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]");
      client.getMobileDeviceSubmodel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMobileDeviceSubmodelTest2() throws Exception {
    MobileDeviceSubmodel expectedResponse =
        MobileDeviceSubmodel.newBuilder()
            .setName(
                MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMobileDevice(MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4457/mobileDeviceSubmodels/mobileDeviceSubmodel-4457";

    MobileDeviceSubmodel actualResponse = client.getMobileDeviceSubmodel(name);
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
  public void getMobileDeviceSubmodelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4457/mobileDeviceSubmodels/mobileDeviceSubmodel-4457";
      client.getMobileDeviceSubmodel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMobileDeviceSubmodelsTest() throws Exception {
    MobileDeviceSubmodel responsesElement = MobileDeviceSubmodel.newBuilder().build();
    ListMobileDeviceSubmodelsResponse expectedResponse =
        ListMobileDeviceSubmodelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMobileDeviceSubmodels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListMobileDeviceSubmodelsPagedResponse pagedListResponse =
        client.listMobileDeviceSubmodels(parent);

    List<MobileDeviceSubmodel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMobileDeviceSubmodelsList().get(0), resources.get(0));

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
  public void listMobileDeviceSubmodelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listMobileDeviceSubmodels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMobileDeviceSubmodelsTest2() throws Exception {
    MobileDeviceSubmodel responsesElement = MobileDeviceSubmodel.newBuilder().build();
    ListMobileDeviceSubmodelsResponse expectedResponse =
        ListMobileDeviceSubmodelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMobileDeviceSubmodels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListMobileDeviceSubmodelsPagedResponse pagedListResponse =
        client.listMobileDeviceSubmodels(parent);

    List<MobileDeviceSubmodel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMobileDeviceSubmodelsList().get(0), resources.get(0));

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
  public void listMobileDeviceSubmodelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listMobileDeviceSubmodels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
