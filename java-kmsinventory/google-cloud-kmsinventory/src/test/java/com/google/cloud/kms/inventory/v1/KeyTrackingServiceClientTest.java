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

package com.google.cloud.kms.inventory.v1;

import static com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient.SearchProtectedResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class KeyTrackingServiceClientTest {
  private static MockKeyTrackingService mockKeyTrackingService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private KeyTrackingServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockKeyTrackingService = new MockKeyTrackingService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockKeyTrackingService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    KeyTrackingServiceSettings settings =
        KeyTrackingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = KeyTrackingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProtectedResourcesSummaryTest() throws Exception {
    ProtectedResourcesSummary expectedResponse =
        ProtectedResourcesSummary.newBuilder()
            .setName(
                ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
                        "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setResourceCount(287552926)
            .setProjectCount(-953448343)
            .putAllResourceTypes(new HashMap<String, Long>())
            .putAllCloudProducts(new HashMap<String, Long>())
            .putAllLocations(new HashMap<String, Long>())
            .build();
    mockKeyTrackingService.addResponse(expectedResponse);

    ProtectedResourcesSummaryName name =
        ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    ProtectedResourcesSummary actualResponse = client.getProtectedResourcesSummary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKeyTrackingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProtectedResourcesSummaryRequest actualRequest =
        ((GetProtectedResourcesSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProtectedResourcesSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKeyTrackingService.addException(exception);

    try {
      ProtectedResourcesSummaryName name =
          ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      client.getProtectedResourcesSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProtectedResourcesSummaryTest2() throws Exception {
    ProtectedResourcesSummary expectedResponse =
        ProtectedResourcesSummary.newBuilder()
            .setName(
                ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
                        "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setResourceCount(287552926)
            .setProjectCount(-953448343)
            .putAllResourceTypes(new HashMap<String, Long>())
            .putAllCloudProducts(new HashMap<String, Long>())
            .putAllLocations(new HashMap<String, Long>())
            .build();
    mockKeyTrackingService.addResponse(expectedResponse);

    String name = "name3373707";

    ProtectedResourcesSummary actualResponse = client.getProtectedResourcesSummary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKeyTrackingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProtectedResourcesSummaryRequest actualRequest =
        ((GetProtectedResourcesSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProtectedResourcesSummaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKeyTrackingService.addException(exception);

    try {
      String name = "name3373707";
      client.getProtectedResourcesSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockKeyTrackingService.addResponse(expectedResponse);

    OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
    ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKeyTrackingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchProtectedResourcesRequest actualRequest =
        ((SearchProtectedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(scope.toString(), actualRequest.getScope());
    Assert.assertEquals(cryptoKey.toString(), actualRequest.getCryptoKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchProtectedResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKeyTrackingService.addException(exception);

    try {
      OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
      ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest2() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockKeyTrackingService.addResponse(expectedResponse);

    OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
    String cryptoKey = "cryptoKey1598288350";

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKeyTrackingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchProtectedResourcesRequest actualRequest =
        ((SearchProtectedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(scope.toString(), actualRequest.getScope());
    Assert.assertEquals(cryptoKey, actualRequest.getCryptoKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchProtectedResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKeyTrackingService.addException(exception);

    try {
      OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
      String cryptoKey = "cryptoKey1598288350";
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest3() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockKeyTrackingService.addResponse(expectedResponse);

    String scope = "scope109264468";
    ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKeyTrackingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchProtectedResourcesRequest actualRequest =
        ((SearchProtectedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(cryptoKey.toString(), actualRequest.getCryptoKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchProtectedResourcesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKeyTrackingService.addException(exception);

    try {
      String scope = "scope109264468";
      ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest4() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockKeyTrackingService.addResponse(expectedResponse);

    String scope = "scope109264468";
    String cryptoKey = "cryptoKey1598288350";

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKeyTrackingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchProtectedResourcesRequest actualRequest =
        ((SearchProtectedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(cryptoKey, actualRequest.getCryptoKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchProtectedResourcesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKeyTrackingService.addException(exception);

    try {
      String scope = "scope109264468";
      String cryptoKey = "cryptoKey1598288350";
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
