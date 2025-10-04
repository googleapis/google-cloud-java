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

package com.google.cloud.networkmanagement.v1beta1;

import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.QueryOrgVpcFlowLogsConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class VpcFlowLogsServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockVpcFlowLogsService mockVpcFlowLogsService;
  private LocalChannelProvider channelProvider;
  private VpcFlowLogsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVpcFlowLogsService = new MockVpcFlowLogsService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVpcFlowLogsService, mockLocations, mockIAMPolicy));
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
    VpcFlowLogsServiceSettings settings =
        VpcFlowLogsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VpcFlowLogsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listVpcFlowLogsConfigsTest() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    ListVpcFlowLogsConfigsResponse expectedResponse =
        ListVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockVpcFlowLogsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVpcFlowLogsConfigsPagedResponse pagedListResponse = client.listVpcFlowLogsConfigs(parent);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVpcFlowLogsConfigsRequest actualRequest =
        ((ListVpcFlowLogsConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVpcFlowLogsConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVpcFlowLogsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVpcFlowLogsConfigsTest2() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    ListVpcFlowLogsConfigsResponse expectedResponse =
        ListVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockVpcFlowLogsService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListVpcFlowLogsConfigsPagedResponse pagedListResponse = client.listVpcFlowLogsConfigs(parent);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVpcFlowLogsConfigsRequest actualRequest =
        ((ListVpcFlowLogsConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVpcFlowLogsConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listVpcFlowLogsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVpcFlowLogsConfigsTest3() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    ListVpcFlowLogsConfigsResponse expectedResponse =
        ListVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockVpcFlowLogsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVpcFlowLogsConfigsPagedResponse pagedListResponse = client.listVpcFlowLogsConfigs(parent);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVpcFlowLogsConfigsRequest actualRequest =
        ((ListVpcFlowLogsConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVpcFlowLogsConfigsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVpcFlowLogsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVpcFlowLogsConfigTest() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockVpcFlowLogsService.addResponse(expectedResponse);

    VpcFlowLogsConfigName name =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse = client.getVpcFlowLogsConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVpcFlowLogsConfigRequest actualRequest =
        ((GetVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVpcFlowLogsConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      VpcFlowLogsConfigName name =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.getVpcFlowLogsConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVpcFlowLogsConfigTest2() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockVpcFlowLogsService.addResponse(expectedResponse);

    String name = "name3373707";

    VpcFlowLogsConfig actualResponse = client.getVpcFlowLogsConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVpcFlowLogsConfigRequest actualRequest =
        ((GetVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVpcFlowLogsConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      String name = "name3373707";
      client.getVpcFlowLogsConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    VpcFlowLogsConfigName vpcFlowLogsConfigId =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpcFlowLogsConfigRequest actualRequest =
        ((CreateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(vpcFlowLogsConfigId.toString(), actualRequest.getVpcFlowLogsConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpcFlowLogsConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      VpcFlowLogsConfigName vpcFlowLogsConfigId =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest2() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpcFlowLogsConfigRequest actualRequest =
        ((CreateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(vpcFlowLogsConfigId, actualRequest.getVpcFlowLogsConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpcFlowLogsConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest3() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    VpcFlowLogsConfigName vpcFlowLogsConfigId =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpcFlowLogsConfigRequest actualRequest =
        ((CreateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(vpcFlowLogsConfigId.toString(), actualRequest.getVpcFlowLogsConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpcFlowLogsConfigExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      VpcFlowLogsConfigName vpcFlowLogsConfigId =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest4() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpcFlowLogsConfigRequest actualRequest =
        ((CreateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(vpcFlowLogsConfigId, actualRequest.getVpcFlowLogsConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpcFlowLogsConfigExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest5() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    VpcFlowLogsConfigName vpcFlowLogsConfigId =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpcFlowLogsConfigRequest actualRequest =
        ((CreateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(vpcFlowLogsConfigId.toString(), actualRequest.getVpcFlowLogsConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpcFlowLogsConfigExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      String parent = "parent-995424086";
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      VpcFlowLogsConfigName vpcFlowLogsConfigId =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest6() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpcFlowLogsConfigRequest actualRequest =
        ((CreateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(vpcFlowLogsConfigId, actualRequest.getVpcFlowLogsConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpcFlowLogsConfigExceptionTest6() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      String parent = "parent-995424086";
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateVpcFlowLogsConfigTest() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    VpcFlowLogsConfig actualResponse =
        client.updateVpcFlowLogsConfigAsync(vpcFlowLogsConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVpcFlowLogsConfigRequest actualRequest =
        ((UpdateVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(vpcFlowLogsConfig, actualRequest.getVpcFlowLogsConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVpcFlowLogsConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVpcFlowLogsConfigAsync(vpcFlowLogsConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVpcFlowLogsConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    VpcFlowLogsConfigName name =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    client.deleteVpcFlowLogsConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVpcFlowLogsConfigRequest actualRequest =
        ((DeleteVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVpcFlowLogsConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      VpcFlowLogsConfigName name =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.deleteVpcFlowLogsConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVpcFlowLogsConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcFlowLogsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteVpcFlowLogsConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVpcFlowLogsConfigRequest actualRequest =
        ((DeleteVpcFlowLogsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVpcFlowLogsConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVpcFlowLogsConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void queryOrgVpcFlowLogsConfigsTest() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    QueryOrgVpcFlowLogsConfigsResponse expectedResponse =
        QueryOrgVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockVpcFlowLogsService.addResponse(expectedResponse);

    QueryOrgVpcFlowLogsConfigsRequest request =
        QueryOrgVpcFlowLogsConfigsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    QueryOrgVpcFlowLogsConfigsPagedResponse pagedListResponse =
        client.queryOrgVpcFlowLogsConfigs(request);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVpcFlowLogsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryOrgVpcFlowLogsConfigsRequest actualRequest =
        ((QueryOrgVpcFlowLogsConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryOrgVpcFlowLogsConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcFlowLogsService.addException(exception);

    try {
      QueryOrgVpcFlowLogsConfigsRequest request =
          QueryOrgVpcFlowLogsConfigsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.queryOrgVpcFlowLogsConfigs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
