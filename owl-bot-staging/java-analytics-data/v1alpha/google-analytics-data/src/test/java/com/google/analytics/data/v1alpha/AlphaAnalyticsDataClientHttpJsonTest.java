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

import com.google.analytics.data.v1alpha.stub.HttpJsonAlphaAnalyticsDataStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AlphaAnalyticsDataClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AlphaAnalyticsDataClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAlphaAnalyticsDataStub.getMethodDescriptors(),
            AlphaAnalyticsDataSettings.getDefaultEndpoint());
    AlphaAnalyticsDataSettings settings =
        AlphaAnalyticsDataSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AlphaAnalyticsDataSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AlphaAnalyticsDataClient.create(settings);
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
  public void runFunnelReportTest() throws Exception {
    RunFunnelReportResponse expectedResponse =
        RunFunnelReportResponse.newBuilder()
            .setFunnelTable(FunnelSubReport.newBuilder().build())
            .setFunnelVisualization(FunnelSubReport.newBuilder().build())
            .setPropertyQuota(PropertyQuota.newBuilder().build())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    RunFunnelReportRequest request =
        RunFunnelReportRequest.newBuilder()
            .setProperty("properties/propertie-2179")
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
  public void runFunnelReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunFunnelReportRequest request =
          RunFunnelReportRequest.newBuilder()
              .setProperty("properties/propertie-2179")
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
