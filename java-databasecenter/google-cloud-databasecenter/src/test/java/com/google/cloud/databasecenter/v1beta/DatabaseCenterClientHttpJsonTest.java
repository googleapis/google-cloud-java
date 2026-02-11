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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.databasecenter.v1beta.stub.HttpJsonDatabaseCenterStub;
import com.google.common.collect.Lists;
import com.google.type.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DatabaseCenterClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DatabaseCenterClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDatabaseCenterStub.getMethodDescriptors(),
            DatabaseCenterSettings.getDefaultEndpoint());
    DatabaseCenterSettings settings =
        DatabaseCenterSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DatabaseCenterSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatabaseCenterClient.create(settings);
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
  public void queryProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    QueryProductsResponse expectedResponse =
        QueryProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

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
  public void queryProductsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void aggregateFleetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void queryDatabaseResourceGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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

  @Test
  public void aggregateIssueStatsTest() throws Exception {
    AggregateIssueStatsResponse expectedResponse =
        AggregateIssueStatsResponse.newBuilder()
            .addAllIssueGroupStats(new ArrayList<IssueGroupStats>())
            .setTotalResourcesCount(-1148081286)
            .setTotalResourceGroupsCount(-1586193222)
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AggregateIssueStatsRequest request =
        AggregateIssueStatsRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
            .setBaselineDate(Date.newBuilder().build())
            .build();

    AggregateIssueStatsResponse actualResponse = client.aggregateIssueStats(request);
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
  public void aggregateIssueStatsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AggregateIssueStatsRequest request =
          AggregateIssueStatsRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
              .setBaselineDate(Date.newBuilder().build())
              .build();
      client.aggregateIssueStats(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
