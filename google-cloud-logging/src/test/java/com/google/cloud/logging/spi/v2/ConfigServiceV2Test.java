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
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
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
public class ConfigServiceV2Test {
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

    String formattedParent = ConfigServiceV2Client.formatParentName("[PROJECT]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(formattedParent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = (ListSinksRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
  }

  @Test
  @SuppressWarnings("all")
  public void listSinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      String formattedParent = ConfigServiceV2Client.formatParentName("[PROJECT]");

      client.listSinks(formattedParent);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkTest() {
    String name = "name3373707";
    String destination = "destination-1429847026";
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestination(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String formattedSinkName = ConfigServiceV2Client.formatSinkName("[PROJECT]", "[SINK]");

    LogSink actualResponse = client.getSink(formattedSinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = (GetSinkRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSinkName, actualRequest.getSinkName());
  }

  @Test
  @SuppressWarnings("all")
  public void getSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      String formattedSinkName = ConfigServiceV2Client.formatSinkName("[PROJECT]", "[SINK]");

      client.getSink(formattedSinkName);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkTest() {
    String name = "name3373707";
    String destination = "destination-1429847026";
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestination(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String formattedParent = ConfigServiceV2Client.formatParentName("[PROJECT]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(formattedParent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = (CreateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
  }

  @Test
  @SuppressWarnings("all")
  public void createSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      String formattedParent = ConfigServiceV2Client.formatParentName("[PROJECT]");
      LogSink sink = LogSink.newBuilder().build();

      client.createSink(formattedParent, sink);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkTest() {
    String name = "name3373707";
    String destination = "destination-1429847026";
    String filter = "filter-1274492040";
    String writerIdentity = "writerIdentity775638794";
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(name)
            .setDestination(destination)
            .setFilter(filter)
            .setWriterIdentity(writerIdentity)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String formattedSinkName = ConfigServiceV2Client.formatSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(formattedSinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = (UpdateSinkRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSinkName, actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
  }

  @Test
  @SuppressWarnings("all")
  public void updateSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      String formattedSinkName = ConfigServiceV2Client.formatSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();

      client.updateSink(formattedSinkName, sink);
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

    String formattedSinkName = ConfigServiceV2Client.formatSinkName("[PROJECT]", "[SINK]");

    client.deleteSink(formattedSinkName);

    List<GeneratedMessageV3> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = (DeleteSinkRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSinkName, actualRequest.getSinkName());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockConfigServiceV2.addException(exception);

    try {
      String formattedSinkName = ConfigServiceV2Client.formatSinkName("[PROJECT]", "[SINK]");

      client.deleteSink(formattedSinkName);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }
}
