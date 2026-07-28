/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import com.google.type.Interval;
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
public class DashboardQueryServiceClientTest {
  private static MockDashboardQueryService mockDashboardQueryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DashboardQueryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDashboardQueryService = new MockDashboardQueryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDashboardQueryService));
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
    DashboardQueryServiceSettings settings =
        DashboardQueryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DashboardQueryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDashboardQueryTest() throws Exception {
    DashboardQuery expectedResponse =
        DashboardQuery.newBuilder()
            .setName(
                DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]")
                    .toString())
            .setQuery("query107944136")
            .setInput(DashboardQuery.Input.newBuilder().build())
            .setDashboardChart(
                DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
                    .toString())
            .setEtag("etag3123477")
            .build();
    mockDashboardQueryService.addResponse(expectedResponse);

    DashboardQueryName name =
        DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]");

    DashboardQuery actualResponse = client.getDashboardQuery(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardQueryRequest actualRequest = ((GetDashboardQueryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDashboardQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardQueryService.addException(exception);

    try {
      DashboardQueryName name =
          DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]");
      client.getDashboardQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDashboardQueryTest2() throws Exception {
    DashboardQuery expectedResponse =
        DashboardQuery.newBuilder()
            .setName(
                DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]")
                    .toString())
            .setQuery("query107944136")
            .setInput(DashboardQuery.Input.newBuilder().build())
            .setDashboardChart(
                DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
                    .toString())
            .setEtag("etag3123477")
            .build();
    mockDashboardQueryService.addResponse(expectedResponse);

    String name = "name3373707";

    DashboardQuery actualResponse = client.getDashboardQuery(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardQueryRequest actualRequest = ((GetDashboardQueryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDashboardQueryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardQueryService.addException(exception);

    try {
      String name = "name3373707";
      client.getDashboardQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void executeDashboardQueryTest() throws Exception {
    ExecuteDashboardQueryResponse expectedResponse =
        ExecuteDashboardQueryResponse.newBuilder()
            .addAllResults(new ArrayList<ExecuteDashboardQueryResponse.ColumnData>())
            .addAllDataSources(new ArrayList<DataSource>())
            .setLastBackendCacheRefreshedTime(Timestamp.newBuilder().build())
            .setTimeWindow(Interval.newBuilder().build())
            .addAllQueryRuntimeErrors(new ArrayList<QueryRuntimeError>())
            .addAllLanguageFeatures(new ArrayList<LanguageFeature>())
            .build();
    mockDashboardQueryService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DashboardQuery query = DashboardQuery.newBuilder().build();

    ExecuteDashboardQueryResponse actualResponse = client.executeDashboardQuery(parent, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecuteDashboardQueryRequest actualRequest =
        ((ExecuteDashboardQueryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeDashboardQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardQueryService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DashboardQuery query = DashboardQuery.newBuilder().build();
      client.executeDashboardQuery(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void executeDashboardQueryTest2() throws Exception {
    ExecuteDashboardQueryResponse expectedResponse =
        ExecuteDashboardQueryResponse.newBuilder()
            .addAllResults(new ArrayList<ExecuteDashboardQueryResponse.ColumnData>())
            .addAllDataSources(new ArrayList<DataSource>())
            .setLastBackendCacheRefreshedTime(Timestamp.newBuilder().build())
            .setTimeWindow(Interval.newBuilder().build())
            .addAllQueryRuntimeErrors(new ArrayList<QueryRuntimeError>())
            .addAllLanguageFeatures(new ArrayList<LanguageFeature>())
            .build();
    mockDashboardQueryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DashboardQuery query = DashboardQuery.newBuilder().build();

    ExecuteDashboardQueryResponse actualResponse = client.executeDashboardQuery(parent, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecuteDashboardQueryRequest actualRequest =
        ((ExecuteDashboardQueryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeDashboardQueryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardQueryService.addException(exception);

    try {
      String parent = "parent-995424086";
      DashboardQuery query = DashboardQuery.newBuilder().build();
      client.executeDashboardQuery(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
