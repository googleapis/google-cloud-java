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

package com.google.shopping.merchant.accounts.v1beta;

import static com.google.shopping.merchant.accounts.v1beta.RegionsServiceClient.ListRegionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
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
public class RegionsServiceClientTest {
  private static MockRegionsService mockRegionsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RegionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRegionsService = new MockRegionsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRegionsService));
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
    RegionsServiceSettings settings =
        RegionsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegionsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getRegionTest() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockRegionsService.addResponse(expectedResponse);

    RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");

    Region actualResponse = client.getRegion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRegionRequest actualRequest = ((GetRegionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRegionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
      client.getRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegionTest2() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockRegionsService.addResponse(expectedResponse);

    String name = "name3373707";

    Region actualResponse = client.getRegion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRegionRequest actualRequest = ((GetRegionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRegionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      String name = "name3373707";
      client.getRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRegionTest() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockRegionsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    Region region = Region.newBuilder().build();
    String regionId = "regionId-690339025";

    Region actualResponse = client.createRegion(parent, region, regionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRegionRequest actualRequest = ((CreateRegionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(regionId, actualRequest.getRegionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRegionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      Region region = Region.newBuilder().build();
      String regionId = "regionId-690339025";
      client.createRegion(parent, region, regionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRegionTest2() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockRegionsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Region region = Region.newBuilder().build();
    String regionId = "regionId-690339025";

    Region actualResponse = client.createRegion(parent, region, regionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRegionRequest actualRequest = ((CreateRegionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(regionId, actualRequest.getRegionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRegionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Region region = Region.newBuilder().build();
      String regionId = "regionId-690339025";
      client.createRegion(parent, region, regionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRegionTest() throws Exception {
    Region expectedResponse =
        Region.newBuilder()
            .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
            .setDisplayName("displayName1714148973")
            .setPostalCodeArea(Region.PostalCodeArea.newBuilder().build())
            .setGeotargetArea(Region.GeoTargetArea.newBuilder().build())
            .setRegionalInventoryEligible(BoolValue.newBuilder().build())
            .setShippingEligible(BoolValue.newBuilder().build())
            .build();
    mockRegionsService.addResponse(expectedResponse);

    Region region = Region.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Region actualResponse = client.updateRegion(region, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRegionRequest actualRequest = ((UpdateRegionRequest) actualRequests.get(0));

    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRegionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      Region region = Region.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRegion(region, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRegionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRegionsService.addResponse(expectedResponse);

    RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");

    client.deleteRegion(name);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegionRequest actualRequest = ((DeleteRegionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
      client.deleteRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRegionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRegionsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRegion(name);

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegionRequest actualRequest = ((DeleteRegionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRegion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegionsTest() throws Exception {
    Region responsesElement = Region.newBuilder().build();
    ListRegionsResponse expectedResponse =
        ListRegionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegions(Arrays.asList(responsesElement))
            .build();
    mockRegionsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListRegionsPagedResponse pagedListResponse = client.listRegions(parent);

    List<Region> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegionsRequest actualRequest = ((ListRegionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listRegions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegionsTest2() throws Exception {
    Region responsesElement = Region.newBuilder().build();
    ListRegionsResponse expectedResponse =
        ListRegionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegions(Arrays.asList(responsesElement))
            .build();
    mockRegionsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRegionsPagedResponse pagedListResponse = client.listRegions(parent);

    List<Region> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegionsRequest actualRequest = ((ListRegionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRegions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
