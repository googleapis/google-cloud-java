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

import static com.google.ads.admanager.v1.MobileDeviceServiceClient.ListMobileDevicesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonMobileDeviceServiceStub;
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
public class MobileDeviceServiceClientTest {
  private static MockHttpService mockService;
  private static MobileDeviceServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMobileDeviceServiceStub.getMethodDescriptors(),
            MobileDeviceServiceSettings.getDefaultEndpoint());
    MobileDeviceServiceSettings settings =
        MobileDeviceServiceSettings.newBuilder()
            .setTransportChannelProvider(
                MobileDeviceServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MobileDeviceServiceClient.create(settings);
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
  public void getMobileDeviceTest() throws Exception {
    MobileDevice expectedResponse =
        MobileDevice.newBuilder()
            .setName(MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setManufacturer(
                DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    MobileDeviceName name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]");

    MobileDevice actualResponse = client.getMobileDevice(name);
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
  public void getMobileDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MobileDeviceName name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]");
      client.getMobileDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMobileDeviceTest2() throws Exception {
    MobileDevice expectedResponse =
        MobileDevice.newBuilder()
            .setName(MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setManufacturer(
                DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4206/mobileDevices/mobileDevice-4206";

    MobileDevice actualResponse = client.getMobileDevice(name);
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
  public void getMobileDeviceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4206/mobileDevices/mobileDevice-4206";
      client.getMobileDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMobileDevicesTest() throws Exception {
    MobileDevice responsesElement = MobileDevice.newBuilder().build();
    ListMobileDevicesResponse expectedResponse =
        ListMobileDevicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMobileDevices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListMobileDevicesPagedResponse pagedListResponse = client.listMobileDevices(parent);

    List<MobileDevice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMobileDevicesList().get(0), resources.get(0));

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
  public void listMobileDevicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listMobileDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMobileDevicesTest2() throws Exception {
    MobileDevice responsesElement = MobileDevice.newBuilder().build();
    ListMobileDevicesResponse expectedResponse =
        ListMobileDevicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMobileDevices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListMobileDevicesPagedResponse pagedListResponse = client.listMobileDevices(parent);

    List<MobileDevice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMobileDevicesList().get(0), resources.get(0));

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
  public void listMobileDevicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listMobileDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
