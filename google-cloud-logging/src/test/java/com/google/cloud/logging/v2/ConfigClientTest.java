/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.logging.v2.PagedResponseWrappers.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.PagedResponseWrappers.ListSinksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.ExclusionName;
import com.google.logging.v2.ExclusionNameOneof;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.ParentNameOneof;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.SinkName;
import com.google.logging.v2.SinkNameOneof;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
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
public class ConfigClientTest {
  private static MockLoggingServiceV2 mockLoggingServiceV2;
  private static MockConfigServiceV2 mockConfigServiceV2;
  private static MockMetricsServiceV2 mockMetricsServiceV2;
  private static MockServiceHelper serviceHelper;
  private ConfigClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockLoggingServiceV2 = new MockLoggingServiceV2();
    mockConfigServiceV2 = new MockConfigServiceV2();
    mockMetricsServiceV2 = new MockMetricsServiceV2();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockLoggingServiceV2, mockConfigServiceV2, mockMetricsServiceV2));
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
  public void listSinksTest() {
    String nextPageToken = "";
    LogSink sinksElement = LogSink.newBuilder().build();
    List<LogSink> sinks = Arrays.asList(sinksElement);
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder().setNextPageToken(nextPageToken).addAllSinks(sinks).build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = (ListSinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
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
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));

      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkTest() {
    String name = "name3373707";
    ResourceName destination = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestinationWithResourceName(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SinkNameOneof sinkName = SinkNameOneof.from(SinkName.of("[PROJECT]", "[SINK]"));

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = (GetSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, actualRequest.getSinkNameAsSinkNameOneof());
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
      SinkNameOneof sinkName = SinkNameOneof.from(SinkName.of("[PROJECT]", "[SINK]"));

      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkTest() {
    String name = "name3373707";
    ResourceName destination = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestinationWithResourceName(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = (CreateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
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
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));
      LogSink sink = LogSink.newBuilder().build();

      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkTest() {
    String name = "name3373707";
    ResourceName destination = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    boolean includeChildren = true;
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestinationWithResourceName(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .setIncludeChildren(includeChildren)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SinkNameOneof sinkName = SinkNameOneof.from(SinkName.of("[PROJECT]", "[SINK]"));
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = (UpdateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, actualRequest.getSinkNameAsSinkNameOneof());
    Assert.assertEquals(sink, actualRequest.getSink());
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
      SinkNameOneof sinkName = SinkNameOneof.from(SinkName.of("[PROJECT]", "[SINK]"));
      LogSink sink = LogSink.newBuilder().build();

      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSinkTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SinkNameOneof sinkName = SinkNameOneof.from(SinkName.of("[PROJECT]", "[SINK]"));

    client.deleteSink(sinkName);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = (DeleteSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, actualRequest.getSinkNameAsSinkNameOneof());
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
      SinkNameOneof sinkName = SinkNameOneof.from(SinkName.of("[PROJECT]", "[SINK]"));

      client.deleteSink(sinkName);
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

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = (ListExclusionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
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
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));

      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getExclusionTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String filter = "filter-1274492040";
    boolean disabled = true;
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setFilter(filter)
            .setDisabled(disabled)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ExclusionNameOneof name = ExclusionNameOneof.from(ExclusionName.of("[PROJECT]", "[EXCLUSION]"));

    LogExclusion actualResponse = client.getExclusion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExclusionRequest actualRequest = (GetExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsExclusionNameOneof());
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
      ExclusionNameOneof name =
          ExclusionNameOneof.from(ExclusionName.of("[PROJECT]", "[EXCLUSION]"));

      client.getExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createExclusionTest() {
    String name = "name3373707";
    String description = "description-1724546052";
    String filter = "filter-1274492040";
    boolean disabled = true;
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(name)
            .setDescription(description)
            .setFilter(filter)
            .setDisabled(disabled)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = (CreateExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
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
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.of("[PROJECT]"));
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
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String filter = "filter-1274492040";
    boolean disabled = true;
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setFilter(filter)
            .setDisabled(disabled)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ExclusionNameOneof name = ExclusionNameOneof.from(ExclusionName.of("[PROJECT]", "[EXCLUSION]"));
    LogExclusion exclusion = LogExclusion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogExclusion actualResponse = client.updateExclusion(name, exclusion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExclusionRequest actualRequest = (UpdateExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsExclusionNameOneof());
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
      ExclusionNameOneof name =
          ExclusionNameOneof.from(ExclusionName.of("[PROJECT]", "[EXCLUSION]"));
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
  public void deleteExclusionTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ExclusionNameOneof name = ExclusionNameOneof.from(ExclusionName.of("[PROJECT]", "[EXCLUSION]"));

    client.deleteExclusion(name);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExclusionRequest actualRequest = (DeleteExclusionRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsExclusionNameOneof());
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
      ExclusionNameOneof name =
          ExclusionNameOneof.from(ExclusionName.of("[PROJECT]", "[EXCLUSION]"));

      client.deleteExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
