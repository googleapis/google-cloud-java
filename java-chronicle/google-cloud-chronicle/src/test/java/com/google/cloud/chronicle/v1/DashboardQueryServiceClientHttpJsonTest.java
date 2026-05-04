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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonDashboardQueryServiceStub;
import com.google.protobuf.Timestamp;
import com.google.type.Interval;
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
public class DashboardQueryServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DashboardQueryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDashboardQueryServiceStub.getMethodDescriptors(),
            DashboardQueryServiceSettings.getDefaultEndpoint());
    DashboardQueryServiceSettings settings =
        DashboardQueryServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DashboardQueryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DashboardQueryServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    DashboardQueryName name =
        DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]");

    DashboardQuery actualResponse = client.getDashboardQuery(name);
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
  public void getDashboardQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3032/locations/location-3032/instances/instance-3032/dashboardQueries/dashboardQuerie-3032";

    DashboardQuery actualResponse = client.getDashboardQuery(name);
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
  public void getDashboardQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3032/locations/location-3032/instances/instance-3032/dashboardQueries/dashboardQuerie-3032";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DashboardQuery query = DashboardQuery.newBuilder().build();

    ExecuteDashboardQueryResponse actualResponse = client.executeDashboardQuery(parent, query);
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
  public void executeDashboardQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    DashboardQuery query = DashboardQuery.newBuilder().build();

    ExecuteDashboardQueryResponse actualResponse = client.executeDashboardQuery(parent, query);
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
  public void executeDashboardQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      DashboardQuery query = DashboardQuery.newBuilder().build();
      client.executeDashboardQuery(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
