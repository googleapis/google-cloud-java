/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.bigquery.datatransfer.v1;

import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferRunsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class DataTransferServiceClientTest {
  private static MockDataTransferService mockDataTransferService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataTransferServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataTransferService = new MockDataTransferService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataTransferService));
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
    DataTransferServiceSettings settings =
        DataTransferServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTransferServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(
                DataSourceName.ofProjectLocationDataSourceName(
                        "[PROJECT]", "[LOCATION]", "[DATA_SOURCE]")
                    .toString())
            .setDataSourceId("dataSourceId-1221402528")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClientId("clientId908408390")
            .addAllScopes(new ArrayList<String>())
            .setTransferType(TransferType.forNumber(0))
            .setSupportsMultipleTransfers(true)
            .setUpdateDeadlineSeconds(991471694)
            .setDefaultSchedule("defaultSchedule1300167672")
            .setSupportsCustomSchedule(true)
            .addAllParameters(new ArrayList<DataSourceParameter>())
            .setHelpUrl("helpUrl805808750")
            .setDefaultDataRefreshWindowDays(-1804935157)
            .setManualRunsDisabled(true)
            .setMinimumScheduleInterval(Duration.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    DataSourceName name =
        DataSourceName.ofProjectLocationDataSourceName("[PROJECT]", "[LOCATION]", "[DATA_SOURCE]");

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = ((GetDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      DataSourceName name =
          DataSourceName.ofProjectLocationDataSourceName(
              "[PROJECT]", "[LOCATION]", "[DATA_SOURCE]");
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSourceTest2() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(
                DataSourceName.ofProjectLocationDataSourceName(
                        "[PROJECT]", "[LOCATION]", "[DATA_SOURCE]")
                    .toString())
            .setDataSourceId("dataSourceId-1221402528")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClientId("clientId908408390")
            .addAllScopes(new ArrayList<String>())
            .setTransferType(TransferType.forNumber(0))
            .setSupportsMultipleTransfers(true)
            .setUpdateDeadlineSeconds(991471694)
            .setDefaultSchedule("defaultSchedule1300167672")
            .setSupportsCustomSchedule(true)
            .addAllParameters(new ArrayList<DataSourceParameter>())
            .setHelpUrl("helpUrl805808750")
            .setDefaultDataRefreshWindowDays(-1804935157)
            .setManualRunsDisabled(true)
            .setMinimumScheduleInterval(Duration.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = ((GetDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest2() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest3() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTransferConfigTest() throws Exception {
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(
                TransferConfigName.ofProjectTransferConfigName("[PROJECT]", "[TRANSFER_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDataSourceId("dataSourceId-1221402528")
            .setParams(Struct.newBuilder().build())
            .setSchedule("schedule-697920873")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .setDataRefreshWindowDays(327632845)
            .setDisabled(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextRunTime(Timestamp.newBuilder().build())
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setDatasetRegion("datasetRegion1032293772")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .setOwnerInfo(UserInfo.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransferConfigRequest actualRequest =
        ((CreateTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(transferConfig, actualRequest.getTransferConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TransferConfig transferConfig = TransferConfig.newBuilder().build();
      client.createTransferConfig(parent, transferConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTransferConfigTest2() throws Exception {
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(
                TransferConfigName.ofProjectTransferConfigName("[PROJECT]", "[TRANSFER_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDataSourceId("dataSourceId-1221402528")
            .setParams(Struct.newBuilder().build())
            .setSchedule("schedule-697920873")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .setDataRefreshWindowDays(327632845)
            .setDisabled(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextRunTime(Timestamp.newBuilder().build())
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setDatasetRegion("datasetRegion1032293772")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .setOwnerInfo(UserInfo.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransferConfigRequest actualRequest =
        ((CreateTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(transferConfig, actualRequest.getTransferConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTransferConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      TransferConfig transferConfig = TransferConfig.newBuilder().build();
      client.createTransferConfig(parent, transferConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTransferConfigTest3() throws Exception {
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(
                TransferConfigName.ofProjectTransferConfigName("[PROJECT]", "[TRANSFER_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDataSourceId("dataSourceId-1221402528")
            .setParams(Struct.newBuilder().build())
            .setSchedule("schedule-697920873")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .setDataRefreshWindowDays(327632845)
            .setDisabled(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextRunTime(Timestamp.newBuilder().build())
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setDatasetRegion("datasetRegion1032293772")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .setOwnerInfo(UserInfo.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransferConfigRequest actualRequest =
        ((CreateTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(transferConfig, actualRequest.getTransferConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTransferConfigExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      TransferConfig transferConfig = TransferConfig.newBuilder().build();
      client.createTransferConfig(parent, transferConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTransferConfigTest() throws Exception {
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(
                TransferConfigName.ofProjectLocationTransferConfigName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDataSourceId("dataSourceId-1221402528")
            .setParams(Struct.newBuilder().build())
            .setSchedule("schedule-697920873")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .setDataRefreshWindowDays(327632845)
            .setDisabled(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextRunTime(Timestamp.newBuilder().build())
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setDatasetRegion("datasetRegion1032293772")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .setOwnerInfo(UserInfo.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfig transferConfig = TransferConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TransferConfig actualResponse = client.updateTransferConfig(transferConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTransferConfigRequest actualRequest =
        ((UpdateTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(transferConfig, actualRequest.getTransferConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfig transferConfig = TransferConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTransferConfig(transferConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTransferConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName name =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");

    client.deleteTransferConfig(name);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransferConfigRequest actualRequest =
        ((DeleteTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName name =
          TransferConfigName.ofProjectLocationTransferConfigName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");
      client.deleteTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTransferConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTransferConfig(name);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransferConfigRequest actualRequest =
        ((DeleteTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransferConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransferConfigTest() throws Exception {
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(
                TransferConfigName.ofProjectLocationTransferConfigName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDataSourceId("dataSourceId-1221402528")
            .setParams(Struct.newBuilder().build())
            .setSchedule("schedule-697920873")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .setDataRefreshWindowDays(327632845)
            .setDisabled(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextRunTime(Timestamp.newBuilder().build())
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setDatasetRegion("datasetRegion1032293772")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .setOwnerInfo(UserInfo.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName name =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");

    TransferConfig actualResponse = client.getTransferConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransferConfigRequest actualRequest = ((GetTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName name =
          TransferConfigName.ofProjectLocationTransferConfigName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");
      client.getTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransferConfigTest2() throws Exception {
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(
                TransferConfigName.ofProjectLocationTransferConfigName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDataSourceId("dataSourceId-1221402528")
            .setParams(Struct.newBuilder().build())
            .setSchedule("schedule-697920873")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .setDataRefreshWindowDays(327632845)
            .setDisabled(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNextRunTime(Timestamp.newBuilder().build())
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setDatasetRegion("datasetRegion1032293772")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .setOwnerInfo(UserInfo.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    TransferConfig actualResponse = client.getTransferConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransferConfigRequest actualRequest = ((GetTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransferConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferConfigsTest() throws Exception {
    TransferConfig responsesElement = TransferConfig.newBuilder().build();
    ListTransferConfigsResponse expectedResponse =
        ListTransferConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferConfigs(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferConfigsRequest actualRequest = ((ListTransferConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTransferConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferConfigsTest2() throws Exception {
    TransferConfig responsesElement = TransferConfig.newBuilder().build();
    ListTransferConfigsResponse expectedResponse =
        ListTransferConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferConfigs(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferConfigsRequest actualRequest = ((ListTransferConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listTransferConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferConfigsTest3() throws Exception {
    TransferConfig responsesElement = TransferConfig.newBuilder().build();
    ListTransferConfigsResponse expectedResponse =
        ListTransferConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferConfigs(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferConfigsRequest actualRequest = ((ListTransferConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferConfigsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTransferConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void scheduleTransferRunsTest() throws Exception {
    ScheduleTransferRunsResponse expectedResponse =
        ScheduleTransferRunsResponse.newBuilder().addAllRuns(new ArrayList<TransferRun>()).build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName parent =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    ScheduleTransferRunsResponse actualResponse =
        client.scheduleTransferRuns(parent, startTime, endTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ScheduleTransferRunsRequest actualRequest =
        ((ScheduleTransferRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void scheduleTransferRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName parent =
          TransferConfigName.ofProjectLocationTransferConfigName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      client.scheduleTransferRuns(parent, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void scheduleTransferRunsTest2() throws Exception {
    ScheduleTransferRunsResponse expectedResponse =
        ScheduleTransferRunsResponse.newBuilder().addAllRuns(new ArrayList<TransferRun>()).build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    ScheduleTransferRunsResponse actualResponse =
        client.scheduleTransferRuns(parent, startTime, endTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ScheduleTransferRunsRequest actualRequest =
        ((ScheduleTransferRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void scheduleTransferRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      client.scheduleTransferRuns(parent, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startManualTransferRunsTest() throws Exception {
    StartManualTransferRunsResponse expectedResponse =
        StartManualTransferRunsResponse.newBuilder()
            .addAllRuns(new ArrayList<TransferRun>())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    StartManualTransferRunsRequest request =
        StartManualTransferRunsRequest.newBuilder()
            .setParent(
                TransferConfigName.ofProjectLocationTransferConfigName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                    .toString())
            .build();

    StartManualTransferRunsResponse actualResponse = client.startManualTransferRuns(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartManualTransferRunsRequest actualRequest =
        ((StartManualTransferRunsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestedTimeRange(), actualRequest.getRequestedTimeRange());
    Assert.assertEquals(request.getRequestedRunTime(), actualRequest.getRequestedRunTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startManualTransferRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      StartManualTransferRunsRequest request =
          StartManualTransferRunsRequest.newBuilder()
              .setParent(
                  TransferConfigName.ofProjectLocationTransferConfigName(
                          "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                      .toString())
              .build();
      client.startManualTransferRuns(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransferRunTest() throws Exception {
    TransferRun expectedResponse =
        TransferRun.newBuilder()
            .setName(
                RunName.ofProjectLocationTransferConfigRunName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]")
                    .toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setRunTime(Timestamp.newBuilder().build())
            .setErrorStatus(Status.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParams(Struct.newBuilder().build())
            .setDataSourceId("dataSourceId-1221402528")
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setSchedule("schedule-697920873")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    RunName name =
        RunName.ofProjectLocationTransferConfigRunName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");

    TransferRun actualResponse = client.getTransferRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransferRunRequest actualRequest = ((GetTransferRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransferRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      RunName name =
          RunName.ofProjectLocationTransferConfigRunName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");
      client.getTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransferRunTest2() throws Exception {
    TransferRun expectedResponse =
        TransferRun.newBuilder()
            .setName(
                RunName.ofProjectLocationTransferConfigRunName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]")
                    .toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setRunTime(Timestamp.newBuilder().build())
            .setErrorStatus(Status.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setParams(Struct.newBuilder().build())
            .setDataSourceId("dataSourceId-1221402528")
            .setState(TransferState.forNumber(0))
            .setUserId(-147132913)
            .setSchedule("schedule-697920873")
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setEmailPreferences(EmailPreferences.newBuilder().build())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    TransferRun actualResponse = client.getTransferRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransferRunRequest actualRequest = ((GetTransferRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTransferRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTransferRunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    RunName name =
        RunName.ofProjectLocationTransferConfigRunName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");

    client.deleteTransferRun(name);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransferRunRequest actualRequest = ((DeleteTransferRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransferRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      RunName name =
          RunName.ofProjectLocationTransferConfigRunName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");
      client.deleteTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTransferRunTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTransferRun(name);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransferRunRequest actualRequest = ((DeleteTransferRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTransferRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferRunsTest() throws Exception {
    TransferRun responsesElement = TransferRun.newBuilder().build();
    ListTransferRunsResponse expectedResponse =
        ListTransferRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferRuns(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName parent =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");

    ListTransferRunsPagedResponse pagedListResponse = client.listTransferRuns(parent);

    List<TransferRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferRunsRequest actualRequest = ((ListTransferRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName parent =
          TransferConfigName.ofProjectLocationTransferConfigName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");
      client.listTransferRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferRunsTest2() throws Exception {
    TransferRun responsesElement = TransferRun.newBuilder().build();
    ListTransferRunsResponse expectedResponse =
        ListTransferRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferRuns(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTransferRunsPagedResponse pagedListResponse = client.listTransferRuns(parent);

    List<TransferRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferRunsRequest actualRequest = ((ListTransferRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTransferRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferLogsTest() throws Exception {
    TransferMessage responsesElement = TransferMessage.newBuilder().build();
    ListTransferLogsResponse expectedResponse =
        ListTransferLogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferMessages(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    RunName parent =
        RunName.ofProjectLocationTransferConfigRunName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");

    ListTransferLogsPagedResponse pagedListResponse = client.listTransferLogs(parent);

    List<TransferMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferLogsRequest actualRequest = ((ListTransferLogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferLogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      RunName parent =
          RunName.ofProjectLocationTransferConfigRunName(
              "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");
      client.listTransferLogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferLogsTest2() throws Exception {
    TransferMessage responsesElement = TransferMessage.newBuilder().build();
    ListTransferLogsResponse expectedResponse =
        ListTransferLogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferMessages(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTransferLogsPagedResponse pagedListResponse = client.listTransferLogs(parent);

    List<TransferMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferLogsRequest actualRequest = ((ListTransferLogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferLogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTransferLogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkValidCredsTest() throws Exception {
    CheckValidCredsResponse expectedResponse =
        CheckValidCredsResponse.newBuilder().setHasValidCreds(true).build();
    mockDataTransferService.addResponse(expectedResponse);

    DataSourceName name =
        DataSourceName.ofProjectLocationDataSourceName("[PROJECT]", "[LOCATION]", "[DATA_SOURCE]");

    CheckValidCredsResponse actualResponse = client.checkValidCreds(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckValidCredsRequest actualRequest = ((CheckValidCredsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkValidCredsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      DataSourceName name =
          DataSourceName.ofProjectLocationDataSourceName(
              "[PROJECT]", "[LOCATION]", "[DATA_SOURCE]");
      client.checkValidCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkValidCredsTest2() throws Exception {
    CheckValidCredsResponse expectedResponse =
        CheckValidCredsResponse.newBuilder().setHasValidCreds(true).build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    CheckValidCredsResponse actualResponse = client.checkValidCreds(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckValidCredsRequest actualRequest = ((CheckValidCredsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkValidCredsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.checkValidCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enrollDataSourcesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    EnrollDataSourcesRequest request =
        EnrollDataSourcesRequest.newBuilder()
            .setName("name3373707")
            .addAllDataSourceIds(new ArrayList<String>())
            .build();

    client.enrollDataSources(request);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnrollDataSourcesRequest actualRequest = ((EnrollDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getDataSourceIdsList(), actualRequest.getDataSourceIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enrollDataSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      EnrollDataSourcesRequest request =
          EnrollDataSourcesRequest.newBuilder()
              .setName("name3373707")
              .addAllDataSourceIds(new ArrayList<String>())
              .build();
      client.enrollDataSources(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
