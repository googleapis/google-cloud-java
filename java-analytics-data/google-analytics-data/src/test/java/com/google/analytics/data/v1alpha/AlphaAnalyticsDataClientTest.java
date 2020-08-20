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
package com.google.analytics.data.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class AlphaAnalyticsDataClientTest {
  private static MockAlphaAnalyticsData mockAlphaAnalyticsData;
  private static MockServiceHelper serviceHelper;
  private AlphaAnalyticsDataClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAlphaAnalyticsData = new MockAlphaAnalyticsData();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAlphaAnalyticsData));
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
    AlphaAnalyticsDataSettings settings =
        AlphaAnalyticsDataSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AlphaAnalyticsDataClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void runReportTest() {
    RunReportResponse expectedResponse = RunReportResponse.newBuilder().build();
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    RunReportRequest request = RunReportRequest.newBuilder().build();

    RunReportResponse actualResponse = client.runReport(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunReportRequest actualRequest = (RunReportRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void runReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      RunReportRequest request = RunReportRequest.newBuilder().build();

      client.runReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void runPivotReportTest() {
    RunPivotReportResponse expectedResponse = RunPivotReportResponse.newBuilder().build();
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    RunPivotReportRequest request = RunPivotReportRequest.newBuilder().build();

    RunPivotReportResponse actualResponse = client.runPivotReport(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunPivotReportRequest actualRequest = (RunPivotReportRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void runPivotReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      RunPivotReportRequest request = RunPivotReportRequest.newBuilder().build();

      client.runPivotReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchRunReportsTest() {
    BatchRunReportsResponse expectedResponse = BatchRunReportsResponse.newBuilder().build();
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    BatchRunReportsRequest request = BatchRunReportsRequest.newBuilder().build();

    BatchRunReportsResponse actualResponse = client.batchRunReports(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRunReportsRequest actualRequest = (BatchRunReportsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchRunReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      BatchRunReportsRequest request = BatchRunReportsRequest.newBuilder().build();

      client.batchRunReports(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchRunPivotReportsTest() {
    BatchRunPivotReportsResponse expectedResponse =
        BatchRunPivotReportsResponse.newBuilder().build();
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    BatchRunPivotReportsRequest request = BatchRunPivotReportsRequest.newBuilder().build();

    BatchRunPivotReportsResponse actualResponse = client.batchRunPivotReports(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRunPivotReportsRequest actualRequest = (BatchRunPivotReportsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchRunPivotReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      BatchRunPivotReportsRequest request = BatchRunPivotReportsRequest.newBuilder().build();

      client.batchRunPivotReports(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
