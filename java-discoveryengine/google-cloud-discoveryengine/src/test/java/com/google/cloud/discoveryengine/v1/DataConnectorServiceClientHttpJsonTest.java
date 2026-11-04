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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1.stub.HttpJsonDataConnectorServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import com.google.type.DateTime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DataConnectorServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataConnectorServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataConnectorServiceStub.getMethodDescriptors(),
            DataConnectorServiceSettings.getDefaultEndpoint());
    DataConnectorServiceSettings settings =
        DataConnectorServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataConnectorServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataConnectorServiceClient.create(settings);
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String collectionId = "collectionId1636075609";
    String collectionDisplayName = "collectionDisplayName-330620689";
    DataConnector dataConnector = DataConnector.newBuilder().build();

    DataConnector actualResponse =
        client
            .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
            .get();
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
  public void setUpDataConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String collectionId = "collectionId1636075609";
    String collectionDisplayName = "collectionDisplayName-330620689";
    DataConnector dataConnector = DataConnector.newBuilder().build();

    DataConnector actualResponse =
        client
            .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
            .get();
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
  public void setUpDataConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String collectionId = "collectionId1636075609";
      String collectionDisplayName = "collectionDisplayName-330620689";
      DataConnector dataConnector = DataConnector.newBuilder().build();
      client
          .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    DataConnectorName name = DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    DataConnector actualResponse = client.getDataConnector(name);
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
  public void getDataConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6289/locations/location-6289/collections/collection-6289/dataConnector";

    DataConnector actualResponse = client.getDataConnector(name);
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
  public void getDataConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6289/locations/location-6289/collections/collection-6289/dataConnector";
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
    mockService.addResponse(expectedResponse);

    DataConnector dataConnector =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataConnector actualResponse = client.updateDataConnector(dataConnector, updateMask);
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
  public void updateDataConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataConnector dataConnector =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataConnector(dataConnector, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
