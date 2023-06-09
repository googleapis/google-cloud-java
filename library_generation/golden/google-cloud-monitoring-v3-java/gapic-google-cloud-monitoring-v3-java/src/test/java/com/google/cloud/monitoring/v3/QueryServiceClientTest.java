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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.QueryServiceClient.QueryTimeSeriesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.QueryTimeSeriesRequest;
import com.google.monitoring.v3.QueryTimeSeriesResponse;
import com.google.monitoring.v3.TimeSeriesData;
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
public class QueryServiceClientTest {
  private static MockQueryService mockQueryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private QueryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockQueryService = new MockQueryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockQueryService));
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
    QueryServiceSettings settings =
        QueryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = QueryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void queryTimeSeriesTest() throws Exception {
    TimeSeriesData responsesElement = TimeSeriesData.newBuilder().build();
    QueryTimeSeriesResponse expectedResponse =
        QueryTimeSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTimeSeriesData(Arrays.asList(responsesElement))
            .build();
    mockQueryService.addResponse(expectedResponse);

    QueryTimeSeriesRequest request =
        QueryTimeSeriesRequest.newBuilder()
            .setName("name3373707")
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryTimeSeriesPagedResponse pagedListResponse = client.queryTimeSeries(request);

    List<TimeSeriesData> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTimeSeriesDataList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryTimeSeriesRequest actualRequest = ((QueryTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQueryService.addException(exception);

    try {
      QueryTimeSeriesRequest request =
          QueryTimeSeriesRequest.newBuilder()
              .setName("name3373707")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryTimeSeries(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
