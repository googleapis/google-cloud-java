/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.errorreporting.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class ReportErrorsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockReportErrorsService mockReportErrorsService;
  private ReportErrorsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockReportErrorsService = new MockReportErrorsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockReportErrorsService));
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
    ReportErrorsServiceSettings settings =
        ReportErrorsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReportErrorsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void reportErrorEventTest() throws Exception {
    ReportErrorEventResponse expectedResponse = ReportErrorEventResponse.newBuilder().build();
    mockReportErrorsService.addResponse(expectedResponse);

    ProjectName projectName = ProjectName.of("[PROJECT]");
    ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();

    ReportErrorEventResponse actualResponse = client.reportErrorEvent(projectName, event);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReportErrorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportErrorEventRequest actualRequest = ((ReportErrorEventRequest) actualRequests.get(0));

    Assert.assertEquals(projectName.toString(), actualRequest.getProjectName());
    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportErrorEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReportErrorsService.addException(exception);

    try {
      ProjectName projectName = ProjectName.of("[PROJECT]");
      ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
      client.reportErrorEvent(projectName, event);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportErrorEventTest2() throws Exception {
    ReportErrorEventResponse expectedResponse = ReportErrorEventResponse.newBuilder().build();
    mockReportErrorsService.addResponse(expectedResponse);

    String projectName = "project_name939388913";
    ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();

    ReportErrorEventResponse actualResponse = client.reportErrorEvent(projectName, event);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReportErrorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportErrorEventRequest actualRequest = ((ReportErrorEventRequest) actualRequests.get(0));

    Assert.assertEquals(projectName, actualRequest.getProjectName());
    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportErrorEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReportErrorsService.addException(exception);

    try {
      String projectName = "project_name939388913";
      ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
      client.reportErrorEvent(projectName, event);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
