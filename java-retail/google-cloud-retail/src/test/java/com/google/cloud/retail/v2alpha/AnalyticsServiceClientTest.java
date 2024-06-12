/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class AnalyticsServiceClientTest {
  private static MockAnalyticsService mockAnalyticsService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AnalyticsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAnalyticsService = new MockAnalyticsService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAnalyticsService, mockLocations));
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
    AnalyticsServiceSettings settings =
        AnalyticsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AnalyticsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void exportAnalyticsMetricsTest() throws Exception {
    ExportAnalyticsMetricsResponse expectedResponse =
        ExportAnalyticsMetricsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorsConfig(ExportErrorsConfig.newBuilder().build())
            .setOutputResult(OutputResult.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAnalyticsMetricsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsService.addResponse(resultOperation);

    ExportAnalyticsMetricsRequest request =
        ExportAnalyticsMetricsRequest.newBuilder()
            .setCatalog("catalog555704345")
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setFilter("filter-1274492040")
            .build();

    ExportAnalyticsMetricsResponse actualResponse =
        client.exportAnalyticsMetricsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAnalyticsMetricsRequest actualRequest =
        ((ExportAnalyticsMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getCatalog(), actualRequest.getCatalog());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAnalyticsMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsService.addException(exception);

    try {
      ExportAnalyticsMetricsRequest request =
          ExportAnalyticsMetricsRequest.newBuilder()
              .setCatalog("catalog555704345")
              .setOutputConfig(OutputConfig.newBuilder().build())
              .setFilter("filter-1274492040")
              .build();
      client.exportAnalyticsMetricsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
