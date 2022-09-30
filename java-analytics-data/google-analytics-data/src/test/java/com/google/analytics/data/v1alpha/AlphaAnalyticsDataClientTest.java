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

package com.google.analytics.data.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class AlphaAnalyticsDataClientTest {
  private static MockAlphaAnalyticsData mockAlphaAnalyticsData;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AlphaAnalyticsDataClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAlphaAnalyticsData = new MockAlphaAnalyticsData();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAlphaAnalyticsData));
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
  public void runFunnelReportTest() throws Exception {
    RunFunnelReportResponse expectedResponse =
        RunFunnelReportResponse.newBuilder()
            .setFunnelTable(FunnelSubReport.newBuilder().build())
            .setFunnelVisualization(FunnelSubReport.newBuilder().build())
            .setPropertyQuota(PropertyQuota.newBuilder().build())
            .setKind("kind3292052")
            .build();
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    RunFunnelReportRequest request =
        RunFunnelReportRequest.newBuilder()
            .setProperty("property-993141291")
            .addAllDateRanges(new ArrayList<DateRange>())
            .setFunnel(Funnel.newBuilder().build())
            .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
            .setFunnelNextAction(FunnelNextAction.newBuilder().build())
            .addAllSegments(new ArrayList<Segment>())
            .setLimit(102976443)
            .setDimensionFilter(FilterExpression.newBuilder().build())
            .setReturnPropertyQuota(true)
            .build();

    RunFunnelReportResponse actualResponse = client.runFunnelReport(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunFunnelReportRequest actualRequest = ((RunFunnelReportRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProperty(), actualRequest.getProperty());
    Assert.assertEquals(request.getDateRangesList(), actualRequest.getDateRangesList());
    Assert.assertEquals(request.getFunnel(), actualRequest.getFunnel());
    Assert.assertEquals(request.getFunnelBreakdown(), actualRequest.getFunnelBreakdown());
    Assert.assertEquals(request.getFunnelNextAction(), actualRequest.getFunnelNextAction());
    Assert.assertEquals(
        request.getFunnelVisualizationType(), actualRequest.getFunnelVisualizationType());
    Assert.assertEquals(request.getSegmentsList(), actualRequest.getSegmentsList());
    Assert.assertEquals(request.getLimit(), actualRequest.getLimit());
    Assert.assertEquals(request.getDimensionFilter(), actualRequest.getDimensionFilter());
    Assert.assertEquals(request.getReturnPropertyQuota(), actualRequest.getReturnPropertyQuota());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runFunnelReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      RunFunnelReportRequest request =
          RunFunnelReportRequest.newBuilder()
              .setProperty("property-993141291")
              .addAllDateRanges(new ArrayList<DateRange>())
              .setFunnel(Funnel.newBuilder().build())
              .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
              .setFunnelNextAction(FunnelNextAction.newBuilder().build())
              .addAllSegments(new ArrayList<Segment>())
              .setLimit(102976443)
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setReturnPropertyQuota(true)
              .build();
      client.runFunnelReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
