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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class BranchServiceClientTest {
  private static MockBranchService mockBranchService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BranchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBranchService = new MockBranchService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBranchService, mockLocations));
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
    BranchServiceSettings settings =
        BranchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BranchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listBranchesTest() throws Exception {
    ListBranchesResponse expectedResponse =
        ListBranchesResponse.newBuilder().addAllBranches(new ArrayList<Branch>()).build();
    mockBranchService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListBranchesResponse actualResponse = client.listBranches(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBranchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBranchesRequest actualRequest = ((ListBranchesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBranchesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBranchService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listBranches(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBranchesTest2() throws Exception {
    ListBranchesResponse expectedResponse =
        ListBranchesResponse.newBuilder().addAllBranches(new ArrayList<Branch>()).build();
    mockBranchService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBranchesResponse actualResponse = client.listBranches(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBranchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBranchesRequest actualRequest = ((ListBranchesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBranchesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBranchService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBranches(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBranchTest() throws Exception {
    Branch expectedResponse =
        Branch.newBuilder()
            .setName(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setDisplayName("displayName1714148973")
            .setIsDefault(true)
            .setLastProductImportTime(Timestamp.newBuilder().build())
            .addAllProductCountStats(new ArrayList<Branch.ProductCountStatistic>())
            .addAllQualityMetrics(new ArrayList<Branch.QualityMetric>())
            .build();
    mockBranchService.addResponse(expectedResponse);

    BranchName name = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");

    Branch actualResponse = client.getBranch(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBranchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBranchRequest actualRequest = ((GetBranchRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBranchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBranchService.addException(exception);

    try {
      BranchName name = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
      client.getBranch(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBranchTest2() throws Exception {
    Branch expectedResponse =
        Branch.newBuilder()
            .setName(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setDisplayName("displayName1714148973")
            .setIsDefault(true)
            .setLastProductImportTime(Timestamp.newBuilder().build())
            .addAllProductCountStats(new ArrayList<Branch.ProductCountStatistic>())
            .addAllQualityMetrics(new ArrayList<Branch.QualityMetric>())
            .build();
    mockBranchService.addResponse(expectedResponse);

    String name = "name3373707";

    Branch actualResponse = client.getBranch(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBranchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBranchRequest actualRequest = ((GetBranchRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBranchExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBranchService.addException(exception);

    try {
      String name = "name3373707";
      client.getBranch(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
