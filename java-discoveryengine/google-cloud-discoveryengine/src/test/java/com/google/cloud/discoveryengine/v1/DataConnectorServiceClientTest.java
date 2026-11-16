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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import com.google.type.DateTime;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DataConnectorServiceClientTest {
  private static MockDataConnectorService mockDataConnectorService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataConnectorServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataConnectorService = new MockDataConnectorService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataConnectorService, mockLocations));
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
    DataConnectorServiceSettings settings =
        DataConnectorServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataConnectorServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void setUpDataConnectorTest() throws Exception {
    DataConnector expectedResponse =
        DataConnector.newBuilder()
            .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDataSource("dataSource1272470629")
            .addAllRemoveParamKeys(new ArrayList<String>())
            .setRefreshInterval(Duration.newBuilder().build())
            .setNextSyncTime(DateTime.newBuilder().build())
            .addAllEntities(new ArrayList<DataConnector.SourceEntity>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestPauseTime(Timestamp.newBuilder().build())
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllErrors(new ArrayList<Status>())
            .setKmsKeyName("kmsKeyName412586233")
            .addAllDestinationConfigs(new ArrayList<DestinationConfig>())
            .setActionConfig(ActionConfig.newBuilder().build())
            .setEndUserConfig(DataConnector.EndUserConfig.newBuilder().build())
            .setFederatedConfig(DataConnector.FederatedConfig.newBuilder().build())
            .addAllConnectorModes(new ArrayList<DataConnector.ConnectorMode>())
            .setStaticIpEnabled(true)
            .addAllStaticIpAddresses(new ArrayList<String>())
            .addAllOauthStaticIpAddresses(new ArrayList<String>())
            .addAllBlockingReasons(new ArrayList<DataConnector.BlockingReason>())
            .setIdentityScheduleConfig(IdentityScheduleConfig.newBuilder().build())
            .setPrivateConnectivityProjectId("privateConnectivityProjectId57045082")
            .setBapConfig(BAPConfig.newBuilder().build())
            .setConnectorType(ConnectorType.forNumber(0))
            .addAllAlertPolicyConfigs(new ArrayList<AlertPolicyConfig>())
            .setRealtimeSyncConfig(DataConnector.RealtimeSyncConfig.newBuilder().build())
            .setAclEnabled(true)
            .setCreateEuaSaas(true)
            .setAutoRunDisabled(true)
            .setIncrementalSyncDisabled(true)
            .setIncrementalRefreshInterval(Duration.newBuilder().build())
            .setHybridIngestionDisabled(true)
            .setDataProtectionPolicy(DataProtectionPolicy.newBuilder().build())
            .addAllEgressFqdns(new ArrayList<String>())
            .setVpcscEnabled(true)
            .addAllDynamicTools(new ArrayList<DynamicTool>())
            .setCliConfig(CliConfig.newBuilder().build())
            .setConnectorSourceId("connectorSourceId-1832087037")
            .setTag("tag114586")
            .setMetadata(DataConnector.ConnectorMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setUpDataConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataConnectorService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String collectionId = "collectionId1636075609";
    String collectionDisplayName = "collectionDisplayName-330620689";
    DataConnector dataConnector = DataConnector.newBuilder().build();

    DataConnector actualResponse =
        client
            .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataConnectorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetUpDataConnectorRequest actualRequest = ((SetUpDataConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(collectionId, actualRequest.getCollectionId());
    Assert.assertEquals(collectionDisplayName, actualRequest.getCollectionDisplayName());
    Assert.assertEquals(dataConnector, actualRequest.getDataConnector());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setUpDataConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataConnectorService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String collectionId = "collectionId1636075609";
      String collectionDisplayName = "collectionDisplayName-330620689";
      DataConnector dataConnector = DataConnector.newBuilder().build();
      client
          .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void setUpDataConnectorTest2() throws Exception {
    DataConnector expectedResponse =
        DataConnector.newBuilder()
            .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDataSource("dataSource1272470629")
            .addAllRemoveParamKeys(new ArrayList<String>())
            .setRefreshInterval(Duration.newBuilder().build())
            .setNextSyncTime(DateTime.newBuilder().build())
            .addAllEntities(new ArrayList<DataConnector.SourceEntity>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestPauseTime(Timestamp.newBuilder().build())
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllErrors(new ArrayList<Status>())
            .setKmsKeyName("kmsKeyName412586233")
            .addAllDestinationConfigs(new ArrayList<DestinationConfig>())
            .setActionConfig(ActionConfig.newBuilder().build())
            .setEndUserConfig(DataConnector.EndUserConfig.newBuilder().build())
            .setFederatedConfig(DataConnector.FederatedConfig.newBuilder().build())
            .addAllConnectorModes(new ArrayList<DataConnector.ConnectorMode>())
            .setStaticIpEnabled(true)
            .addAllStaticIpAddresses(new ArrayList<String>())
            .addAllOauthStaticIpAddresses(new ArrayList<String>())
            .addAllBlockingReasons(new ArrayList<DataConnector.BlockingReason>())
            .setIdentityScheduleConfig(IdentityScheduleConfig.newBuilder().build())
            .setPrivateConnectivityProjectId("privateConnectivityProjectId57045082")
            .setBapConfig(BAPConfig.newBuilder().build())
            .setConnectorType(ConnectorType.forNumber(0))
            .addAllAlertPolicyConfigs(new ArrayList<AlertPolicyConfig>())
            .setRealtimeSyncConfig(DataConnector.RealtimeSyncConfig.newBuilder().build())
            .setAclEnabled(true)
            .setCreateEuaSaas(true)
            .setAutoRunDisabled(true)
            .setIncrementalSyncDisabled(true)
            .setIncrementalRefreshInterval(Duration.newBuilder().build())
            .setHybridIngestionDisabled(true)
            .setDataProtectionPolicy(DataProtectionPolicy.newBuilder().build())
            .addAllEgressFqdns(new ArrayList<String>())
            .setVpcscEnabled(true)
            .addAllDynamicTools(new ArrayList<DynamicTool>())
            .setCliConfig(CliConfig.newBuilder().build())
            .setConnectorSourceId("connectorSourceId-1832087037")
            .setTag("tag114586")
            .setMetadata(DataConnector.ConnectorMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setUpDataConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataConnectorService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String collectionId = "collectionId1636075609";
    String collectionDisplayName = "collectionDisplayName-330620689";
    DataConnector dataConnector = DataConnector.newBuilder().build();

    DataConnector actualResponse =
        client
            .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataConnectorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetUpDataConnectorRequest actualRequest = ((SetUpDataConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(collectionId, actualRequest.getCollectionId());
    Assert.assertEquals(collectionDisplayName, actualRequest.getCollectionDisplayName());
    Assert.assertEquals(dataConnector, actualRequest.getDataConnector());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setUpDataConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataConnectorService.addException(exception);

    try {
      String parent = "parent-995424086";
      String collectionId = "collectionId1636075609";
      String collectionDisplayName = "collectionDisplayName-330620689";
      DataConnector dataConnector = DataConnector.newBuilder().build();
      client
          .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataConnectorTest() throws Exception {
    DataConnector expectedResponse =
        DataConnector.newBuilder()
            .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDataSource("dataSource1272470629")
            .addAllRemoveParamKeys(new ArrayList<String>())
            .setRefreshInterval(Duration.newBuilder().build())
            .setNextSyncTime(DateTime.newBuilder().build())
            .addAllEntities(new ArrayList<DataConnector.SourceEntity>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestPauseTime(Timestamp.newBuilder().build())
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllErrors(new ArrayList<Status>())
            .setKmsKeyName("kmsKeyName412586233")
            .addAllDestinationConfigs(new ArrayList<DestinationConfig>())
            .setActionConfig(ActionConfig.newBuilder().build())
            .setEndUserConfig(DataConnector.EndUserConfig.newBuilder().build())
            .setFederatedConfig(DataConnector.FederatedConfig.newBuilder().build())
            .addAllConnectorModes(new ArrayList<DataConnector.ConnectorMode>())
            .setStaticIpEnabled(true)
            .addAllStaticIpAddresses(new ArrayList<String>())
            .addAllOauthStaticIpAddresses(new ArrayList<String>())
            .addAllBlockingReasons(new ArrayList<DataConnector.BlockingReason>())
            .setIdentityScheduleConfig(IdentityScheduleConfig.newBuilder().build())
            .setPrivateConnectivityProjectId("privateConnectivityProjectId57045082")
            .setBapConfig(BAPConfig.newBuilder().build())
            .setConnectorType(ConnectorType.forNumber(0))
            .addAllAlertPolicyConfigs(new ArrayList<AlertPolicyConfig>())
            .setRealtimeSyncConfig(DataConnector.RealtimeSyncConfig.newBuilder().build())
            .setAclEnabled(true)
            .setCreateEuaSaas(true)
            .setAutoRunDisabled(true)
            .setIncrementalSyncDisabled(true)
            .setIncrementalRefreshInterval(Duration.newBuilder().build())
            .setHybridIngestionDisabled(true)
            .setDataProtectionPolicy(DataProtectionPolicy.newBuilder().build())
            .addAllEgressFqdns(new ArrayList<String>())
            .setVpcscEnabled(true)
            .addAllDynamicTools(new ArrayList<DynamicTool>())
            .setCliConfig(CliConfig.newBuilder().build())
            .setConnectorSourceId("connectorSourceId-1832087037")
            .setTag("tag114586")
            .setMetadata(DataConnector.ConnectorMetadata.newBuilder().build())
            .build();
    mockDataConnectorService.addResponse(expectedResponse);

    DataConnectorName name = DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    DataConnector actualResponse = client.getDataConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataConnectorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataConnectorRequest actualRequest = ((GetDataConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataConnectorService.addException(exception);

    try {
      DataConnectorName name = DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      client.getDataConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataConnectorTest2() throws Exception {
    DataConnector expectedResponse =
        DataConnector.newBuilder()
            .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDataSource("dataSource1272470629")
            .addAllRemoveParamKeys(new ArrayList<String>())
            .setRefreshInterval(Duration.newBuilder().build())
            .setNextSyncTime(DateTime.newBuilder().build())
            .addAllEntities(new ArrayList<DataConnector.SourceEntity>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestPauseTime(Timestamp.newBuilder().build())
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllErrors(new ArrayList<Status>())
            .setKmsKeyName("kmsKeyName412586233")
            .addAllDestinationConfigs(new ArrayList<DestinationConfig>())
            .setActionConfig(ActionConfig.newBuilder().build())
            .setEndUserConfig(DataConnector.EndUserConfig.newBuilder().build())
            .setFederatedConfig(DataConnector.FederatedConfig.newBuilder().build())
            .addAllConnectorModes(new ArrayList<DataConnector.ConnectorMode>())
            .setStaticIpEnabled(true)
            .addAllStaticIpAddresses(new ArrayList<String>())
            .addAllOauthStaticIpAddresses(new ArrayList<String>())
            .addAllBlockingReasons(new ArrayList<DataConnector.BlockingReason>())
            .setIdentityScheduleConfig(IdentityScheduleConfig.newBuilder().build())
            .setPrivateConnectivityProjectId("privateConnectivityProjectId57045082")
            .setBapConfig(BAPConfig.newBuilder().build())
            .setConnectorType(ConnectorType.forNumber(0))
            .addAllAlertPolicyConfigs(new ArrayList<AlertPolicyConfig>())
            .setRealtimeSyncConfig(DataConnector.RealtimeSyncConfig.newBuilder().build())
            .setAclEnabled(true)
            .setCreateEuaSaas(true)
            .setAutoRunDisabled(true)
            .setIncrementalSyncDisabled(true)
            .setIncrementalRefreshInterval(Duration.newBuilder().build())
            .setHybridIngestionDisabled(true)
            .setDataProtectionPolicy(DataProtectionPolicy.newBuilder().build())
            .addAllEgressFqdns(new ArrayList<String>())
            .setVpcscEnabled(true)
            .addAllDynamicTools(new ArrayList<DynamicTool>())
            .setCliConfig(CliConfig.newBuilder().build())
            .setConnectorSourceId("connectorSourceId-1832087037")
            .setTag("tag114586")
            .setMetadata(DataConnector.ConnectorMetadata.newBuilder().build())
            .build();
    mockDataConnectorService.addResponse(expectedResponse);

    String name = "name3373707";

    DataConnector actualResponse = client.getDataConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataConnectorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataConnectorRequest actualRequest = ((GetDataConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataConnectorService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataConnectorTest() throws Exception {
    DataConnector expectedResponse =
        DataConnector.newBuilder()
            .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDataSource("dataSource1272470629")
            .addAllRemoveParamKeys(new ArrayList<String>())
            .setRefreshInterval(Duration.newBuilder().build())
            .setNextSyncTime(DateTime.newBuilder().build())
            .addAllEntities(new ArrayList<DataConnector.SourceEntity>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestPauseTime(Timestamp.newBuilder().build())
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllErrors(new ArrayList<Status>())
            .setKmsKeyName("kmsKeyName412586233")
            .addAllDestinationConfigs(new ArrayList<DestinationConfig>())
            .setActionConfig(ActionConfig.newBuilder().build())
            .setEndUserConfig(DataConnector.EndUserConfig.newBuilder().build())
            .setFederatedConfig(DataConnector.FederatedConfig.newBuilder().build())
            .addAllConnectorModes(new ArrayList<DataConnector.ConnectorMode>())
            .setStaticIpEnabled(true)
            .addAllStaticIpAddresses(new ArrayList<String>())
            .addAllOauthStaticIpAddresses(new ArrayList<String>())
            .addAllBlockingReasons(new ArrayList<DataConnector.BlockingReason>())
            .setIdentityScheduleConfig(IdentityScheduleConfig.newBuilder().build())
            .setPrivateConnectivityProjectId("privateConnectivityProjectId57045082")
            .setBapConfig(BAPConfig.newBuilder().build())
            .setConnectorType(ConnectorType.forNumber(0))
            .addAllAlertPolicyConfigs(new ArrayList<AlertPolicyConfig>())
            .setRealtimeSyncConfig(DataConnector.RealtimeSyncConfig.newBuilder().build())
            .setAclEnabled(true)
            .setCreateEuaSaas(true)
            .setAutoRunDisabled(true)
            .setIncrementalSyncDisabled(true)
            .setIncrementalRefreshInterval(Duration.newBuilder().build())
            .setHybridIngestionDisabled(true)
            .setDataProtectionPolicy(DataProtectionPolicy.newBuilder().build())
            .addAllEgressFqdns(new ArrayList<String>())
            .setVpcscEnabled(true)
            .addAllDynamicTools(new ArrayList<DynamicTool>())
            .setCliConfig(CliConfig.newBuilder().build())
            .setConnectorSourceId("connectorSourceId-1832087037")
            .setTag("tag114586")
            .setMetadata(DataConnector.ConnectorMetadata.newBuilder().build())
            .build();
    mockDataConnectorService.addResponse(expectedResponse);

    DataConnector dataConnector = DataConnector.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataConnector actualResponse = client.updateDataConnector(dataConnector, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataConnectorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataConnectorRequest actualRequest = ((UpdateDataConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(dataConnector, actualRequest.getDataConnector());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataConnectorService.addException(exception);

    try {
      DataConnector dataConnector = DataConnector.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataConnector(dataConnector, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
