/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.osconfig.v1;

import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class OsConfigZonalServiceClientTest {
  private static MockOsConfigZonalService mockOsConfigZonalService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OsConfigZonalServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOsConfigZonalService = new MockOsConfigZonalService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockOsConfigZonalService));
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
    OsConfigZonalServiceSettings settings =
        OsConfigZonalServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsConfigZonalServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getInventoryTest() throws Exception {
    Inventory expectedResponse =
        Inventory.newBuilder()
            .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setOsInfo(Inventory.OsInfo.newBuilder().build())
            .putAllItems(new HashMap<String, Inventory.Item>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Inventory actualResponse = client.getInventory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInventoryRequest actualRequest = ((GetInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInventoryTest2() throws Exception {
    Inventory expectedResponse =
        Inventory.newBuilder()
            .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setOsInfo(Inventory.OsInfo.newBuilder().build())
            .putAllItems(new HashMap<String, Inventory.Item>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    Inventory actualResponse = client.getInventory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInventoryRequest actualRequest = ((GetInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInventoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.getInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInventoriesTest() throws Exception {
    Inventory responsesElement = Inventory.newBuilder().build();
    ListInventoriesResponse expectedResponse =
        ListInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInventories(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InstanceName parent =
        InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]");

    ListInventoriesPagedResponse pagedListResponse = client.listInventories(parent);

    List<Inventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInventoriesRequest actualRequest = ((ListInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInventoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InstanceName parent =
          InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]");
      client.listInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInventoriesTest2() throws Exception {
    Inventory responsesElement = Inventory.newBuilder().build();
    ListInventoriesResponse expectedResponse =
        ListInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInventories(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInventoriesPagedResponse pagedListResponse = client.listInventories(parent);

    List<Inventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInventoriesRequest actualRequest = ((ListInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInventoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVulnerabilityReportTest() throws Exception {
    VulnerabilityReport expectedResponse =
        VulnerabilityReport.newBuilder()
            .setName(VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .addAllVulnerabilities(new ArrayList<VulnerabilityReport.Vulnerability>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    VulnerabilityReportName name =
        VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    VulnerabilityReport actualResponse = client.getVulnerabilityReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityReportRequest actualRequest =
        ((GetVulnerabilityReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      VulnerabilityReportName name =
          VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getVulnerabilityReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVulnerabilityReportTest2() throws Exception {
    VulnerabilityReport expectedResponse =
        VulnerabilityReport.newBuilder()
            .setName(VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .addAllVulnerabilities(new ArrayList<VulnerabilityReport.Vulnerability>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    VulnerabilityReport actualResponse = client.getVulnerabilityReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityReportRequest actualRequest =
        ((GetVulnerabilityReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.getVulnerabilityReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVulnerabilityReportsTest() throws Exception {
    VulnerabilityReport responsesElement = VulnerabilityReport.newBuilder().build();
    ListVulnerabilityReportsResponse expectedResponse =
        ListVulnerabilityReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVulnerabilityReports(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InstanceName parent =
        InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]");

    ListVulnerabilityReportsPagedResponse pagedListResponse =
        client.listVulnerabilityReports(parent);

    List<VulnerabilityReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVulnerabilityReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVulnerabilityReportsRequest actualRequest =
        ((ListVulnerabilityReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVulnerabilityReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InstanceName parent =
          InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]");
      client.listVulnerabilityReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVulnerabilityReportsTest2() throws Exception {
    VulnerabilityReport responsesElement = VulnerabilityReport.newBuilder().build();
    ListVulnerabilityReportsResponse expectedResponse =
        ListVulnerabilityReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVulnerabilityReports(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVulnerabilityReportsPagedResponse pagedListResponse =
        client.listVulnerabilityReports(parent);

    List<VulnerabilityReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVulnerabilityReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVulnerabilityReportsRequest actualRequest =
        ((ListVulnerabilityReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVulnerabilityReportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVulnerabilityReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
