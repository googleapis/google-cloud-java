/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DataTransferServiceClientTest {
  private static MockDataTransferService mockDataTransferService;
  private static MockServiceHelper serviceHelper;
  private DataTransferServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataTransferService = new MockDataTransferService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1", Arrays.<MockGrpcService>asList(mockDataTransferService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void getDataSourceTest() {
    DataSourceName name2 = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
    String dataSourceId = "dataSourceId-1015796374";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String clientId = "clientId-1904089585";
    boolean supportsMultipleTransfers = true;
    int updateDeadlineSeconds = 991471694;
    String defaultSchedule = "defaultSchedule-800168235";
    boolean supportsCustomSchedule = true;
    String helpUrl = "helpUrl-789431439";
    int defaultDataRefreshWindowDays = 1804935157;
    boolean manualRunsDisabled = true;
    String partnerLegalName = "partnerLegalName-1307326424";
    String redirectUrl = "redirectUrl951230092";
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(name2.toString())
            .setDataSourceId(dataSourceId)
            .setDisplayName(displayName)
            .setDescription(description)
            .setClientId(clientId)
            .setSupportsMultipleTransfers(supportsMultipleTransfers)
            .setUpdateDeadlineSeconds(updateDeadlineSeconds)
            .setDefaultSchedule(defaultSchedule)
            .setSupportsCustomSchedule(supportsCustomSchedule)
            .setHelpUrl(helpUrl)
            .setDefaultDataRefreshWindowDays(defaultDataRefreshWindowDays)
            .setManualRunsDisabled(manualRunsDisabled)
            .setPartnerLegalName(partnerLegalName)
            .setRedirectUrl(redirectUrl)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = (GetDataSourceRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataSourceNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");

      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDataSourcesTest() {
    String nextPageToken = "";
    DataSource dataSourcesElement = DataSource.newBuilder().build();
    List<DataSource> dataSources = Arrays.asList(dataSourcesElement);
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDataSources(dataSources)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    ParentName parent = ProjectName.of("[PROJECT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = (ListDataSourcesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ParentNames.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDataSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      ParentName parent = ProjectName.of("[PROJECT]");

      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTransferConfigTest() {
    TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
    String destinationDatasetId = "destinationDatasetId1541564179";
    String displayName = "displayName1615086568";
    String dataSourceId = "dataSourceId-1015796374";
    String schedule = "schedule-697920873";
    int dataRefreshWindowDays = 327632845;
    boolean disabled = true;
    long userId = 147132913L;
    String datasetRegion = "datasetRegion959248539";
    String partnerToken = "partnerToken725173186";
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(name.toString())
            .setDestinationDatasetId(destinationDatasetId)
            .setDisplayName(displayName)
            .setDataSourceId(dataSourceId)
            .setSchedule(schedule)
            .setDataRefreshWindowDays(dataRefreshWindowDays)
            .setDisabled(disabled)
            .setUserId(userId)
            .setDatasetRegion(datasetRegion)
            .setPartnerToken(partnerToken)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    ParentName parent = ProjectName.of("[PROJECT]");
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransferConfigRequest actualRequest = (CreateTransferConfigRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ParentNames.parse(actualRequest.getParent()));
    Assert.assertEquals(transferConfig, actualRequest.getTransferConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      ParentName parent = ProjectName.of("[PROJECT]");
      TransferConfig transferConfig = TransferConfig.newBuilder().build();

      client.createTransferConfig(parent, transferConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTransferConfigTest() {
    TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
    String destinationDatasetId = "destinationDatasetId1541564179";
    String displayName = "displayName1615086568";
    String dataSourceId = "dataSourceId-1015796374";
    String schedule = "schedule-697920873";
    int dataRefreshWindowDays = 327632845;
    boolean disabled = true;
    long userId = 147132913L;
    String datasetRegion = "datasetRegion959248539";
    String partnerToken = "partnerToken725173186";
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(name.toString())
            .setDestinationDatasetId(destinationDatasetId)
            .setDisplayName(displayName)
            .setDataSourceId(dataSourceId)
            .setSchedule(schedule)
            .setDataRefreshWindowDays(dataRefreshWindowDays)
            .setDisabled(disabled)
            .setUserId(userId)
            .setDatasetRegion(datasetRegion)
            .setPartnerToken(partnerToken)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfig transferConfig = TransferConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TransferConfig actualResponse = client.updateTransferConfig(transferConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTransferConfigRequest actualRequest = (UpdateTransferConfigRequest) actualRequests.get(0);

    Assert.assertEquals(transferConfig, actualRequest.getTransferConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfig transferConfig = TransferConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateTransferConfig(transferConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTransferConfigTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");

    client.deleteTransferConfig(name);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransferConfigRequest actualRequest = (DeleteTransferConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, TransferConfigNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");

      client.deleteTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTransferConfigTest() {
    TransferConfigName name2 = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
    String destinationDatasetId = "destinationDatasetId1541564179";
    String displayName = "displayName1615086568";
    String dataSourceId = "dataSourceId-1015796374";
    String schedule = "schedule-697920873";
    int dataRefreshWindowDays = 327632845;
    boolean disabled = true;
    long userId = 147132913L;
    String datasetRegion = "datasetRegion959248539";
    String partnerToken = "partnerToken725173186";
    TransferConfig expectedResponse =
        TransferConfig.newBuilder()
            .setName(name2.toString())
            .setDestinationDatasetId(destinationDatasetId)
            .setDisplayName(displayName)
            .setDataSourceId(dataSourceId)
            .setSchedule(schedule)
            .setDataRefreshWindowDays(dataRefreshWindowDays)
            .setDisabled(disabled)
            .setUserId(userId)
            .setDatasetRegion(datasetRegion)
            .setPartnerToken(partnerToken)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");

    TransferConfig actualResponse = client.getTransferConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransferConfigRequest actualRequest = (GetTransferConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, TransferConfigNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");

      client.getTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTransferConfigsTest() {
    String nextPageToken = "";
    TransferConfig transferConfigsElement = TransferConfig.newBuilder().build();
    List<TransferConfig> transferConfigs = Arrays.asList(transferConfigsElement);
    ListTransferConfigsResponse expectedResponse =
        ListTransferConfigsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTransferConfigs(transferConfigs)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    ParentName parent = ProjectName.of("[PROJECT]");

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferConfigsRequest actualRequest = (ListTransferConfigsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ParentNames.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTransferConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      ParentName parent = ProjectName.of("[PROJECT]");

      client.listTransferConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void scheduleTransferRunsTest() {
    ScheduleTransferRunsResponse expectedResponse =
        ScheduleTransferRunsResponse.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    ScheduleTransferRunsResponse actualResponse =
        client.scheduleTransferRuns(parent, startTime, endTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ScheduleTransferRunsRequest actualRequest = (ScheduleTransferRunsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TransferConfigNames.parse(actualRequest.getParent()));
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void scheduleTransferRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();

      client.scheduleTransferRuns(parent, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTransferRunTest() {
    RunName name2 = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
    String destinationDatasetId = "destinationDatasetId1541564179";
    String dataSourceId = "dataSourceId-1015796374";
    long userId = 147132913L;
    String schedule = "schedule-697920873";
    String partnerToken = "partnerToken725173186";
    TransferRun expectedResponse =
        TransferRun.newBuilder()
            .setName(name2.toString())
            .setDestinationDatasetId(destinationDatasetId)
            .setDataSourceId(dataSourceId)
            .setUserId(userId)
            .setSchedule(schedule)
            .setPartnerToken(partnerToken)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");

    TransferRun actualResponse = client.getTransferRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransferRunRequest actualRequest = (GetTransferRunRequest) actualRequests.get(0);

    Assert.assertEquals(name, RunNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTransferRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");

      client.getTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTransferRunTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTransferService.addResponse(expectedResponse);

    RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");

    client.deleteTransferRun(name);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransferRunRequest actualRequest = (DeleteTransferRunRequest) actualRequests.get(0);

    Assert.assertEquals(name, RunNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTransferRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");

      client.deleteTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTransferRunsTest() {
    String nextPageToken = "";
    TransferRun transferRunsElement = TransferRun.newBuilder().build();
    List<TransferRun> transferRuns = Arrays.asList(transferRunsElement);
    ListTransferRunsResponse expectedResponse =
        ListTransferRunsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTransferRuns(transferRuns)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");

    ListTransferRunsPagedResponse pagedListResponse = client.listTransferRuns(parent);

    List<TransferRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferRunsRequest actualRequest = (ListTransferRunsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TransferConfigNames.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTransferRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");

      client.listTransferRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTransferLogsTest() {
    String nextPageToken = "";
    TransferMessage transferMessagesElement = TransferMessage.newBuilder().build();
    List<TransferMessage> transferMessages = Arrays.asList(transferMessagesElement);
    ListTransferLogsResponse expectedResponse =
        ListTransferLogsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTransferMessages(transferMessages)
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    RunName parent = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");

    ListTransferLogsPagedResponse pagedListResponse = client.listTransferLogs(parent);

    List<TransferMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferLogsRequest actualRequest = (ListTransferLogsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RunNames.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTransferLogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      RunName parent = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");

      client.listTransferLogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void checkValidCredsTest() {
    boolean hasValidCreds = false;
    CheckValidCredsResponse expectedResponse =
        CheckValidCredsResponse.newBuilder().setHasValidCreds(hasValidCreds).build();
    mockDataTransferService.addResponse(expectedResponse);

    DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");

    CheckValidCredsResponse actualResponse = client.checkValidCreds(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckValidCredsRequest actualRequest = (CheckValidCredsRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataSourceNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void checkValidCredsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");

      client.checkValidCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
