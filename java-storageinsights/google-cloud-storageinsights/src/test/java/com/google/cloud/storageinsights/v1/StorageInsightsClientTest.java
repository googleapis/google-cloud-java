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

package com.google.cloud.storageinsights.v1;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListDatasetConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

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
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import com.google.type.DateTime;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class StorageInsightsClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockStorageInsights mockStorageInsights;
  private LocalChannelProvider channelProvider;
  private StorageInsightsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockStorageInsights = new MockStorageInsights();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockStorageInsights, mockLocations));
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
    StorageInsightsSettings settings =
        StorageInsightsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StorageInsightsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listReportConfigsTest() throws Exception {
    ReportConfig responsesElement = ReportConfig.newBuilder().build();
    ListReportConfigsResponse expectedResponse =
        ListReportConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReportConfigs(Arrays.asList(responsesElement))
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReportConfigsPagedResponse pagedListResponse = client.listReportConfigs(parent);

    List<ReportConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportConfigsRequest actualRequest = ((ListReportConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listReportConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportConfigsTest2() throws Exception {
    ReportConfig responsesElement = ReportConfig.newBuilder().build();
    ListReportConfigsResponse expectedResponse =
        ListReportConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReportConfigs(Arrays.asList(responsesElement))
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReportConfigsPagedResponse pagedListResponse = client.listReportConfigs(parent);

    List<ReportConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportConfigsRequest actualRequest = ((ListReportConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReportConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportConfigTest() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFrequencyOptions(FrequencyOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");

    ReportConfig actualResponse = client.getReportConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReportConfigRequest actualRequest = ((GetReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReportConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      client.getReportConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportConfigTest2() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFrequencyOptions(FrequencyOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String name = "name3373707";

    ReportConfig actualResponse = client.getReportConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReportConfigRequest actualRequest = ((GetReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReportConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.getReportConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReportConfigTest() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFrequencyOptions(FrequencyOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ReportConfig reportConfig = ReportConfig.newBuilder().build();

    ReportConfig actualResponse = client.createReportConfig(parent, reportConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReportConfigRequest actualRequest = ((CreateReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(reportConfig, actualRequest.getReportConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReportConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ReportConfig reportConfig = ReportConfig.newBuilder().build();
      client.createReportConfig(parent, reportConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReportConfigTest2() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFrequencyOptions(FrequencyOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ReportConfig reportConfig = ReportConfig.newBuilder().build();

    ReportConfig actualResponse = client.createReportConfig(parent, reportConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReportConfigRequest actualRequest = ((CreateReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(reportConfig, actualRequest.getReportConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReportConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      ReportConfig reportConfig = ReportConfig.newBuilder().build();
      client.createReportConfig(parent, reportConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReportConfigTest() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFrequencyOptions(FrequencyOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    ReportConfig reportConfig = ReportConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ReportConfig actualResponse = client.updateReportConfig(reportConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReportConfigRequest actualRequest = ((UpdateReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(reportConfig, actualRequest.getReportConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateReportConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      ReportConfig reportConfig = ReportConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReportConfig(reportConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReportConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageInsights.addResponse(expectedResponse);

    ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");

    client.deleteReportConfig(name);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReportConfigRequest actualRequest = ((DeleteReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReportConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      client.deleteReportConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReportConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorageInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteReportConfig(name);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReportConfigRequest actualRequest = ((DeleteReportConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReportConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.deleteReportConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportDetailsTest() throws Exception {
    ReportDetail responsesElement = ReportDetail.newBuilder().build();
    ListReportDetailsResponse expectedResponse =
        ListReportDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReportDetails(Arrays.asList(responsesElement))
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");

    ListReportDetailsPagedResponse pagedListResponse = client.listReportDetails(parent);

    List<ReportDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportDetailsRequest actualRequest = ((ListReportDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      client.listReportDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportDetailsTest2() throws Exception {
    ReportDetail responsesElement = ReportDetail.newBuilder().build();
    ListReportDetailsResponse expectedResponse =
        ListReportDetailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReportDetails(Arrays.asList(responsesElement))
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReportDetailsPagedResponse pagedListResponse = client.listReportDetails(parent);

    List<ReportDetail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportDetailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReportDetailsRequest actualRequest = ((ListReportDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReportDetailsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReportDetails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportDetailTest() throws Exception {
    ReportDetail expectedResponse =
        ReportDetail.newBuilder()
            .setName(
                ReportDetailName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]")
                    .toString())
            .setSnapshotTime(Timestamp.newBuilder().build())
            .setReportPathPrefix("reportPathPrefix-1434070165")
            .setShardsCount(-2027352923)
            .setStatus(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTargetDatetime(DateTime.newBuilder().build())
            .setReportMetrics(ReportDetail.Metrics.newBuilder().build())
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    ReportDetailName name =
        ReportDetailName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]");

    ReportDetail actualResponse = client.getReportDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReportDetailRequest actualRequest = ((GetReportDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReportDetailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      ReportDetailName name =
          ReportDetailName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]");
      client.getReportDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportDetailTest2() throws Exception {
    ReportDetail expectedResponse =
        ReportDetail.newBuilder()
            .setName(
                ReportDetailName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]")
                    .toString())
            .setSnapshotTime(Timestamp.newBuilder().build())
            .setReportPathPrefix("reportPathPrefix-1434070165")
            .setShardsCount(-2027352923)
            .setStatus(Status.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTargetDatetime(DateTime.newBuilder().build())
            .setReportMetrics(ReportDetail.Metrics.newBuilder().build())
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String name = "name3373707";

    ReportDetail actualResponse = client.getReportDetail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReportDetailRequest actualRequest = ((GetReportDetailRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReportDetailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.getReportDetail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetConfigsTest() throws Exception {
    DatasetConfig responsesElement = DatasetConfig.newBuilder().build();
    ListDatasetConfigsResponse expectedResponse =
        ListDatasetConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasetConfigs(Arrays.asList(responsesElement))
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDatasetConfigsPagedResponse pagedListResponse = client.listDatasetConfigs(parent);

    List<DatasetConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetConfigsRequest actualRequest = ((ListDatasetConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDatasetConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetConfigsTest2() throws Exception {
    DatasetConfig responsesElement = DatasetConfig.newBuilder().build();
    ListDatasetConfigsResponse expectedResponse =
        ListDatasetConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasetConfigs(Arrays.asList(responsesElement))
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatasetConfigsPagedResponse pagedListResponse = client.listDatasetConfigs(parent);

    List<DatasetConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetConfigsRequest actualRequest = ((ListDatasetConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatasetConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetConfigTest() throws Exception {
    DatasetConfig expectedResponse =
        DatasetConfig.newBuilder()
            .setName(DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .setOrganizationNumber(1902853077)
            .setIncludeNewlyCreatedBuckets(true)
            .setSkipVerificationAndIngest(true)
            .setRetentionPeriodDays(-2064636812)
            .setLink(DatasetConfig.Link.newBuilder().build())
            .setIdentity(Identity.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");

    DatasetConfig actualResponse = client.getDatasetConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetConfigRequest actualRequest = ((GetDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");
      client.getDatasetConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetConfigTest2() throws Exception {
    DatasetConfig expectedResponse =
        DatasetConfig.newBuilder()
            .setName(DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .setOrganizationNumber(1902853077)
            .setIncludeNewlyCreatedBuckets(true)
            .setSkipVerificationAndIngest(true)
            .setRetentionPeriodDays(-2064636812)
            .setLink(DatasetConfig.Link.newBuilder().build())
            .setIdentity(Identity.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockStorageInsights.addResponse(expectedResponse);

    String name = "name3373707";

    DatasetConfig actualResponse = client.getDatasetConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetConfigRequest actualRequest = ((GetDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.getDatasetConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatasetConfigTest() throws Exception {
    DatasetConfig expectedResponse =
        DatasetConfig.newBuilder()
            .setName(DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .setOrganizationNumber(1902853077)
            .setIncludeNewlyCreatedBuckets(true)
            .setSkipVerificationAndIngest(true)
            .setRetentionPeriodDays(-2064636812)
            .setLink(DatasetConfig.Link.newBuilder().build())
            .setIdentity(Identity.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DatasetConfig datasetConfig = DatasetConfig.newBuilder().build();
    String datasetConfigId = "datasetConfigId7070869";

    DatasetConfig actualResponse =
        client.createDatasetConfigAsync(parent, datasetConfig, datasetConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetConfigRequest actualRequest = ((CreateDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(datasetConfig, actualRequest.getDatasetConfig());
    Assert.assertEquals(datasetConfigId, actualRequest.getDatasetConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatasetConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DatasetConfig datasetConfig = DatasetConfig.newBuilder().build();
      String datasetConfigId = "datasetConfigId7070869";
      client.createDatasetConfigAsync(parent, datasetConfig, datasetConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDatasetConfigTest2() throws Exception {
    DatasetConfig expectedResponse =
        DatasetConfig.newBuilder()
            .setName(DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .setOrganizationNumber(1902853077)
            .setIncludeNewlyCreatedBuckets(true)
            .setSkipVerificationAndIngest(true)
            .setRetentionPeriodDays(-2064636812)
            .setLink(DatasetConfig.Link.newBuilder().build())
            .setIdentity(Identity.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    String parent = "parent-995424086";
    DatasetConfig datasetConfig = DatasetConfig.newBuilder().build();
    String datasetConfigId = "datasetConfigId7070869";

    DatasetConfig actualResponse =
        client.createDatasetConfigAsync(parent, datasetConfig, datasetConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetConfigRequest actualRequest = ((CreateDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(datasetConfig, actualRequest.getDatasetConfig());
    Assert.assertEquals(datasetConfigId, actualRequest.getDatasetConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatasetConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      DatasetConfig datasetConfig = DatasetConfig.newBuilder().build();
      String datasetConfigId = "datasetConfigId7070869";
      client.createDatasetConfigAsync(parent, datasetConfig, datasetConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDatasetConfigTest() throws Exception {
    DatasetConfig expectedResponse =
        DatasetConfig.newBuilder()
            .setName(DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .setOrganizationNumber(1902853077)
            .setIncludeNewlyCreatedBuckets(true)
            .setSkipVerificationAndIngest(true)
            .setRetentionPeriodDays(-2064636812)
            .setLink(DatasetConfig.Link.newBuilder().build())
            .setIdentity(Identity.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatasetConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    DatasetConfig datasetConfig = DatasetConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DatasetConfig actualResponse = client.updateDatasetConfigAsync(datasetConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatasetConfigRequest actualRequest = ((UpdateDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(datasetConfig, actualRequest.getDatasetConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatasetConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      DatasetConfig datasetConfig = DatasetConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatasetConfigAsync(datasetConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDatasetConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");

    client.deleteDatasetConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetConfigRequest actualRequest = ((DeleteDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatasetConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");
      client.deleteDatasetConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDatasetConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDatasetConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetConfigRequest actualRequest = ((DeleteDatasetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatasetConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDatasetConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void linkDatasetTest() throws Exception {
    LinkDatasetResponse expectedResponse = LinkDatasetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("linkDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");

    LinkDatasetResponse actualResponse = client.linkDatasetAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LinkDatasetRequest actualRequest = ((LinkDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void linkDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");
      client.linkDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void linkDatasetTest2() throws Exception {
    LinkDatasetResponse expectedResponse = LinkDatasetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("linkDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    String name = "name3373707";

    LinkDatasetResponse actualResponse = client.linkDatasetAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LinkDatasetRequest actualRequest = ((LinkDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void linkDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.linkDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void unlinkDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("unlinkDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");

    client.unlinkDatasetAsync(name).get();

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnlinkDatasetRequest actualRequest = ((UnlinkDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unlinkDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      DatasetConfigName name = DatasetConfigName.of("[PROJECT]", "[LOCATION]", "[DATASET_CONFIG]");
      client.unlinkDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void unlinkDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("unlinkDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStorageInsights.addResponse(resultOperation);

    String name = "name3373707";

    client.unlinkDatasetAsync(name).get();

    List<AbstractMessage> actualRequests = mockStorageInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnlinkDatasetRequest actualRequest = ((UnlinkDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unlinkDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorageInsights.addException(exception);

    try {
      String name = "name3373707";
      client.unlinkDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
}
