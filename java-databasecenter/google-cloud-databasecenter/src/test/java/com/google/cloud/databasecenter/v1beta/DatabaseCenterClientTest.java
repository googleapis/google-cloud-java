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

package com.google.cloud.databasecenter.v1beta;

import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.AggregateFleetPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryDatabaseResourceGroupsPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryProductsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.type.Date;
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
public class DatabaseCenterClientTest {
  private static MockDatabaseCenter mockDatabaseCenter;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DatabaseCenterClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDatabaseCenter = new MockDatabaseCenter();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDatabaseCenter));
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
    DatabaseCenterSettings settings =
        DatabaseCenterSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatabaseCenterClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void queryProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    QueryProductsResponse expectedResponse =
        QueryProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockDatabaseCenter.addResponse(expectedResponse);

    QueryProductsRequest request =
        QueryProductsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryProductsPagedResponse pagedListResponse = client.queryProducts(request);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryProductsRequest actualRequest = ((QueryProductsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseCenter.addException(exception);

    try {
      QueryProductsRequest request =
          QueryProductsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryProducts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateFleetTest() throws Exception {
    AggregateFleetRow responsesElement = AggregateFleetRow.newBuilder().build();
    AggregateFleetResponse expectedResponse =
        AggregateFleetResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockDatabaseCenter.addResponse(expectedResponse);

    AggregateFleetRequest request =
        AggregateFleetRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .setGroupBy("groupBy293428022")
            .setOrderBy("orderBy-1207110587")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setBaselineDate(Date.newBuilder().build())
            .build();

    AggregateFleetPagedResponse pagedListResponse = client.aggregateFleet(request);

    List<AggregateFleetRow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateFleetRequest actualRequest = ((AggregateFleetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getGroupBy(), actualRequest.getGroupBy());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getBaselineDate(), actualRequest.getBaselineDate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateFleetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseCenter.addException(exception);

    try {
      AggregateFleetRequest request =
          AggregateFleetRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setGroupBy("groupBy293428022")
              .setOrderBy("orderBy-1207110587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setBaselineDate(Date.newBuilder().build())
              .build();
      client.aggregateFleet(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryDatabaseResourceGroupsTest() throws Exception {
    DatabaseResourceGroup responsesElement = DatabaseResourceGroup.newBuilder().build();
    QueryDatabaseResourceGroupsResponse expectedResponse =
        QueryDatabaseResourceGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceGroups(Arrays.asList(responsesElement))
            .build();
    mockDatabaseCenter.addResponse(expectedResponse);

    QueryDatabaseResourceGroupsRequest request =
        QueryDatabaseResourceGroupsRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
            .addAllSignalFilters(new ArrayList<SignalFilter>())
            .setOrderBy("orderBy-1207110587")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryDatabaseResourceGroupsPagedResponse pagedListResponse =
        client.queryDatabaseResourceGroups(request);

    List<DatabaseResourceGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryDatabaseResourceGroupsRequest actualRequest =
        ((QueryDatabaseResourceGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getSignalTypeGroupsList(), actualRequest.getSignalTypeGroupsList());
    Assert.assertEquals(request.getSignalFiltersList(), actualRequest.getSignalFiltersList());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryDatabaseResourceGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseCenter.addException(exception);

    try {
      QueryDatabaseResourceGroupsRequest request =
          QueryDatabaseResourceGroupsRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
              .addAllSignalFilters(new ArrayList<SignalFilter>())
              .setOrderBy("orderBy-1207110587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryDatabaseResourceGroups(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
