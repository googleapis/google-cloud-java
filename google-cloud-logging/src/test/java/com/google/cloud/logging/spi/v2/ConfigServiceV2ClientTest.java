/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.logging.spi.v2;

import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListSinksPagedResponse;

import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.ParentNameOneof;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.SinkName;
import com.google.logging.v2.SinkNameOneof;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
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
public class ConfigServiceV2ClientTest {
  private static MockLoggingServiceV2 mockLoggingServiceV2;
  private static MockConfigServiceV2 mockConfigServiceV2;
  private static MockMetricsServiceV2 mockMetricsServiceV2;
  private static MockServiceHelper serviceHelper;
  private ConfigServiceV2Client client;

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
    ConfigServiceV2Settings settings =
        ConfigServiceV2Settings.defaultBuilder()
            .setChannelProvider(serviceHelper.createChannelProvider())
            .build();
    client = ConfigServiceV2Client.create(settings);
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

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = (ListSinksRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
  }

  @Test
  @SuppressWarnings("all")
  public void listSinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));

      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkTest() {
    String name = "name3373707";
    ResourceName destination = ProjectName.create("[PROJECT]");
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestinationWithResourceName(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = (GetSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, actualRequest.getSinkNameAsSinkNameOneof());
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));

      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkTest() {
    String name = "name3373707";
    ResourceName destination = ProjectName.create("[PROJECT]");
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestinationWithResourceName(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = (CreateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsParentNameOneof());
    Assert.assertEquals(sink, actualRequest.getSink());
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
      LogSink sink = LogSink.newBuilder().build();

      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkTest() {
    String name = "name3373707";
    ResourceName destination = ProjectName.create("[PROJECT]");
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestinationWithResourceName(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = (UpdateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, actualRequest.getSinkNameAsSinkNameOneof());
    Assert.assertEquals(sink, actualRequest.getSink());
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
      LogSink sink = LogSink.newBuilder().build();

      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSinkTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));

    client.deleteSink(sinkName);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = (DeleteSinkRequest) actualRequests.get(0);

    Assert.assertEquals(sinkName, actualRequest.getSinkNameAsSinkNameOneof());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));

      client.deleteSink(sinkName);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }
}
