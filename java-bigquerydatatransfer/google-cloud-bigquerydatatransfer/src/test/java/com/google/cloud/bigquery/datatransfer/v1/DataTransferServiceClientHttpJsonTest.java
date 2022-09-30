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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.bigquery.datatransfer.v1.stub.HttpJsonDataTransferServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
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
public class DataTransferServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataTransferServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataTransferServiceStub.getMethodDescriptors(),
            DataTransferServiceSettings.getDefaultEndpoint());
    DataTransferServiceSettings settings =
        DataTransferServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataTransferServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTransferServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    DataSourceName name =
        DataSourceName.ofProjectLocationDataSourceName("[PROJECT]", "[LOCATION]", "[DATA_SOURCE]");

    DataSource actualResponse = client.getDataSource(name);
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
  public void getDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6044/locations/location-6044/dataSources/dataSource-6044";

    DataSource actualResponse = client.getDataSource(name);
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
  public void getDataSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6044/locations/location-6044/dataSources/dataSource-6044";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

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
  public void listDataSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

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
  public void listDataSourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

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
  public void listDataSourcesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
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
  public void createTransferConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
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
  public void createTransferConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    TransferConfig transferConfig = TransferConfig.newBuilder().build();

    TransferConfig actualResponse = client.createTransferConfig(parent, transferConfig);
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
  public void createTransferConfigExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    TransferConfig transferConfig =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    TransferConfig actualResponse = client.updateTransferConfig(transferConfig, updateMask);
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
  public void updateTransferConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferConfig transferConfig =
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
    mockService.addResponse(expectedResponse);

    TransferConfigName name =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");

    client.deleteTransferConfig(name);

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
  public void deleteTransferConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8868/locations/location-8868/transferConfigs/transferConfig-8868";

    client.deleteTransferConfig(name);

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
  public void deleteTransferConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8868/locations/location-8868/transferConfigs/transferConfig-8868";
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
    mockService.addResponse(expectedResponse);

    TransferConfigName name =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");

    TransferConfig actualResponse = client.getTransferConfig(name);
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
  public void getTransferConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8868/locations/location-8868/transferConfigs/transferConfig-8868";

    TransferConfig actualResponse = client.getTransferConfig(name);
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
  public void getTransferConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8868/locations/location-8868/transferConfigs/transferConfig-8868";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

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
  public void listTransferConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

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
  public void listTransferConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTransferConfigsPagedResponse pagedListResponse = client.listTransferConfigs(parent);

    List<TransferConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferConfigsList().get(0), resources.get(0));

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
  public void listTransferConfigsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    TransferConfigName parent =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    ScheduleTransferRunsResponse actualResponse =
        client.scheduleTransferRuns(parent, startTime, endTime);
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
  public void scheduleTransferRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3195/locations/location-3195/transferConfigs/transferConfig-3195";
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    ScheduleTransferRunsResponse actualResponse =
        client.scheduleTransferRuns(parent, startTime, endTime);
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
  public void scheduleTransferRunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3195/locations/location-3195/transferConfigs/transferConfig-3195";
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
    mockService.addResponse(expectedResponse);

    StartManualTransferRunsRequest request =
        StartManualTransferRunsRequest.newBuilder()
            .setParent(
                TransferConfigName.ofProjectLocationTransferConfigName(
                        "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                    .toString())
            .build();

    StartManualTransferRunsResponse actualResponse = client.startManualTransferRuns(request);
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
  public void startManualTransferRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RunName name =
        RunName.ofProjectLocationTransferConfigRunName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");

    TransferRun actualResponse = client.getTransferRun(name);
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
  public void getTransferRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9834/locations/location-9834/transferConfigs/transferConfig-9834/runs/run-9834";

    TransferRun actualResponse = client.getTransferRun(name);
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
  public void getTransferRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9834/locations/location-9834/transferConfigs/transferConfig-9834/runs/run-9834";
      client.getTransferRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTransferRunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RunName name =
        RunName.ofProjectLocationTransferConfigRunName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");

    client.deleteTransferRun(name);

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
  public void deleteTransferRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9834/locations/location-9834/transferConfigs/transferConfig-9834/runs/run-9834";

    client.deleteTransferRun(name);

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
  public void deleteTransferRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9834/locations/location-9834/transferConfigs/transferConfig-9834/runs/run-9834";
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
    mockService.addResponse(expectedResponse);

    TransferConfigName parent =
        TransferConfigName.ofProjectLocationTransferConfigName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]");

    ListTransferRunsPagedResponse pagedListResponse = client.listTransferRuns(parent);

    List<TransferRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferRunsList().get(0), resources.get(0));

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
  public void listTransferRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3195/locations/location-3195/transferConfigs/transferConfig-3195";

    ListTransferRunsPagedResponse pagedListResponse = client.listTransferRuns(parent);

    List<TransferRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferRunsList().get(0), resources.get(0));

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
  public void listTransferRunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3195/locations/location-3195/transferConfigs/transferConfig-3195";
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
    mockService.addResponse(expectedResponse);

    RunName parent =
        RunName.ofProjectLocationTransferConfigRunName(
            "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]");

    ListTransferLogsPagedResponse pagedListResponse = client.listTransferLogs(parent);

    List<TransferMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferMessagesList().get(0), resources.get(0));

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
  public void listTransferLogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-215/locations/location-215/transferConfigs/transferConfig-215/runs/run-215";

    ListTransferLogsPagedResponse pagedListResponse = client.listTransferLogs(parent);

    List<TransferMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferMessagesList().get(0), resources.get(0));

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
  public void listTransferLogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-215/locations/location-215/transferConfigs/transferConfig-215/runs/run-215";
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
    mockService.addResponse(expectedResponse);

    DataSourceName name =
        DataSourceName.ofProjectLocationDataSourceName("[PROJECT]", "[LOCATION]", "[DATA_SOURCE]");

    CheckValidCredsResponse actualResponse = client.checkValidCreds(name);
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
  public void checkValidCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6044/locations/location-6044/dataSources/dataSource-6044";

    CheckValidCredsResponse actualResponse = client.checkValidCreds(name);
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
  public void checkValidCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6044/locations/location-6044/dataSources/dataSource-6044";
      client.checkValidCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enrollDataSourcesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EnrollDataSourcesRequest request =
        EnrollDataSourcesRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .addAllDataSourceIds(new ArrayList<String>())
            .build();

    client.enrollDataSources(request);

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
  public void enrollDataSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnrollDataSourcesRequest request =
          EnrollDataSourcesRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .addAllDataSourceIds(new ArrayList<String>())
              .build();
      client.enrollDataSources(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
