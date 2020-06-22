/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.logging.v2.BillingAccountName;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CmekSettingsName;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogBucketName;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogExclusionName;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogSinkName;
import com.google.logging.v2.OrganizationLocationName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ConfigClientTest {
  private static MockConfigServiceV2 mockConfigServiceV2;
  private static MockLoggingServiceV2 mockLoggingServiceV2;
  private static MockMetricsServiceV2 mockMetricsServiceV2;
  private static MockServiceHelper serviceHelper;
  private ConfigClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockConfigServiceV2 = new MockConfigServiceV2();
    mockLoggingServiceV2 = new MockLoggingServiceV2();
    mockMetricsServiceV2 = new MockMetricsServiceV2();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockConfigServiceV2, mockLoggingServiceV2, mockMetricsServiceV2));
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
    ConfigSettings settings =
        ConfigSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSinkTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

    client.deleteSink(sinkName);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = (DeleteSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, LogSinkName.parse(actualRequest.getSinkName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

      client.deleteSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkTest() {
    LogSinkName name = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    ResourceName destination = BillingAccountName.of("[BILLING_ACCOUNT]");
    String filter = "filter-1274492040";
    String description = "description-1724546052";
    boolean disabled = true;
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name.toString())
            .setDestination(destination.toString())
            .setFilter(filter)
            .setDescription(description)
            .setDisabled(disabled)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = (UpdateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, LogSinkName.parse(actualRequest.getSinkName()));
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateSink(sinkName, sink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkTest2() {
    LogSinkName name = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    ResourceName destination = BillingAccountName.of("[BILLING_ACCOUNT]");
    String filter = "filter-1274492040";
    String description = "description-1724546052";
    boolean disabled = true;
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name.toString())
            .setDestination(destination.toString())
            .setFilter(filter)
            .setDescription(description)
            .setDisabled(disabled)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = (UpdateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, LogSinkName.parse(actualRequest.getSinkName()));
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();

      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteExclusionTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

    client.deleteExclusion(name);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExclusionRequest actualRequest = (DeleteExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(name, LogExclusionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

      client.deleteExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listBucketsTest() {
    String nextPageToken = "";
    LogBucket bucketsElement = LogBucket.newBuilder().build();
    List<LogBucket> buckets = Arrays.asList(bucketsElement);
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllBuckets(buckets)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = (ListBucketsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listBucketsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBucketTest() {
    LogBucketName name2 =
        LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
    String description = "description-1724546052";
    int retentionDays = 1544391896;
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRetentionDays(retentionDays)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogBucketName name =
        LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
    GetBucketRequest request = GetBucketRequest.newBuilder().setName(name.toString()).build();

    LogBucket actualResponse = client.getBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = (GetBucketRequest) actualRequests.get(0);

    Assert.assertEquals(name, LogBucketName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogBucketName name =
          LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
      GetBucketRequest request = GetBucketRequest.newBuilder().setName(name.toString()).build();

      client.getBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateBucketTest() {
    LogBucketName name2 =
        LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
    String description = "description-1724546052";
    int retentionDays = 1544391896;
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRetentionDays(retentionDays)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogBucketName name =
        LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
    LogBucket bucket = LogBucket.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder()
            .setName(name.toString())
            .setBucket(bucket)
            .setUpdateMask(updateMask)
            .build();

    LogBucket actualResponse = client.updateBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBucketRequest actualRequest = (UpdateBucketRequest) actualRequests.get(0);

    Assert.assertEquals(name, LogBucketName.parse(actualRequest.getName()));
    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogBucketName name =
          LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
      LogBucket bucket = LogBucket.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      UpdateBucketRequest request =
          UpdateBucketRequest.newBuilder()
              .setName(name.toString())
              .setBucket(bucket)
              .setUpdateMask(updateMask)
              .build();

      client.updateBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSinksTest() {
    String nextPageToken = "";
    LogSink sinksElement = LogSink.newBuilder().build();
    List<LogSink> sinks = Arrays.asList(sinksElement);
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder().setNextPageToken(nextPageToken).addAllSinks(sinks).build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = (ListSinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkTest() {
    LogSinkName name = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    ResourceName destination = BillingAccountName.of("[BILLING_ACCOUNT]");
    String filter = "filter-1274492040";
    String description = "description-1724546052";
    boolean disabled = true;
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name.toString())
            .setDestination(destination.toString())
            .setFilter(filter)
            .setDescription(description)
            .setDisabled(disabled)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = (GetSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, LogSinkName.parse(actualRequest.getSinkName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkTest() {
    LogSinkName name = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    ResourceName destination = BillingAccountName.of("[BILLING_ACCOUNT]");
    String filter = "filter-1274492040";
    String description = "description-1724546052";
    boolean disabled = true;
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name.toString())
            .setDestination(destination.toString())
            .setFilter(filter)
            .setDescription(description)
            .setDisabled(disabled)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = (CreateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogSink sink = LogSink.newBuilder().build();

      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listExclusionsTest() {
    String nextPageToken = "";
    LogExclusion exclusionsElement = LogExclusion.newBuilder().build();
    List<LogExclusion> exclusions = Arrays.asList(exclusionsElement);
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllExclusions(exclusions)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = (ListExclusionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listExclusionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getExclusionTest() {
    LogExclusionName name2 = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
    String description = "description-1724546052";
    String filter = "filter-1274492040";
    boolean disabled = true;
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setFilter(filter)
            .setDisabled(disabled)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

    LogExclusion actualResponse = client.getExclusion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExclusionRequest actualRequest = (GetExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(name, LogExclusionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

      client.getExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createExclusionTest() {
    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
    String description = "description-1724546052";
    String filter = "filter-1274492040";
    boolean disabled = true;
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setFilter(filter)
            .setDisabled(disabled)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = (CreateExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();

      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateExclusionTest() {
    LogExclusionName name2 = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
    String description = "description-1724546052";
    String filter = "filter-1274492040";
    boolean disabled = true;
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setFilter(filter)
            .setDisabled(disabled)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogExclusion actualResponse = client.updateExclusion(name, exclusion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExclusionRequest actualRequest = (UpdateExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(name, LogExclusionName.parse(actualRequest.getName()));
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateExclusion(name, exclusion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCmekSettingsTest() {
    CmekSettingsName name2 = CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]");
    String kmsKeyName = "kmsKeyName2094986649";
    String serviceAccountId = "serviceAccountId-111486921";
    CmekSettings expectedResponse =
        CmekSettings.newBuilder()
            .setName(name2.toString())
            .setKmsKeyName(kmsKeyName)
            .setServiceAccountId(serviceAccountId)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    CmekSettingsName name = CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]");
    GetCmekSettingsRequest request =
        GetCmekSettingsRequest.newBuilder().setName(name.toString()).build();

    CmekSettings actualResponse = client.getCmekSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCmekSettingsRequest actualRequest = (GetCmekSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, CmekSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCmekSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      CmekSettingsName name = CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]");
      GetCmekSettingsRequest request =
          GetCmekSettingsRequest.newBuilder().setName(name.toString()).build();

      client.getCmekSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCmekSettingsTest() {
    CmekSettingsName name2 = CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]");
    String kmsKeyName = "kmsKeyName2094986649";
    String serviceAccountId = "serviceAccountId-111486921";
    CmekSettings expectedResponse =
        CmekSettings.newBuilder()
            .setName(name2.toString())
            .setKmsKeyName(kmsKeyName)
            .setServiceAccountId(serviceAccountId)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";
    CmekSettings cmekSettings = CmekSettings.newBuilder().build();
    UpdateCmekSettingsRequest request =
        UpdateCmekSettingsRequest.newBuilder().setName(name).setCmekSettings(cmekSettings).build();

    CmekSettings actualResponse = client.updateCmekSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCmekSettingsRequest actualRequest = (UpdateCmekSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(cmekSettings, actualRequest.getCmekSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCmekSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      CmekSettings cmekSettings = CmekSettings.newBuilder().build();
      UpdateCmekSettingsRequest request =
          UpdateCmekSettingsRequest.newBuilder()
              .setName(name)
              .setCmekSettings(cmekSettings)
              .build();

      client.updateCmekSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
