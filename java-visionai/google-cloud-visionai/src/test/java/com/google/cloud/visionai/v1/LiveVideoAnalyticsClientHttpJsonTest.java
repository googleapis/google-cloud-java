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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListAnalysesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListOperatorsPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListProcessesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListPublicOperatorsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.visionai.v1.stub.HttpJsonLiveVideoAnalyticsStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LiveVideoAnalyticsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LiveVideoAnalyticsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLiveVideoAnalyticsStub.getMethodDescriptors(),
            LiveVideoAnalyticsSettings.getDefaultEndpoint());
    LiveVideoAnalyticsSettings settings =
        LiveVideoAnalyticsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LiveVideoAnalyticsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LiveVideoAnalyticsClient.create(settings);
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
  public void listPublicOperatorsTest() throws Exception {
    Operator responsesElement = Operator.newBuilder().build();
    ListPublicOperatorsResponse expectedResponse =
        ListPublicOperatorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperators(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPublicOperatorsPagedResponse pagedListResponse = client.listPublicOperators(parent);

    List<Operator> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperatorsList().get(0), resources.get(0));

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
  public void listPublicOperatorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPublicOperators(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPublicOperatorsTest2() throws Exception {
    Operator responsesElement = Operator.newBuilder().build();
    ListPublicOperatorsResponse expectedResponse =
        ListPublicOperatorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperators(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPublicOperatorsPagedResponse pagedListResponse = client.listPublicOperators(parent);

    List<Operator> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperatorsList().get(0), resources.get(0));

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
  public void listPublicOperatorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPublicOperators(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resolveOperatorInfoTest() throws Exception {
    ResolveOperatorInfoResponse expectedResponse =
        ResolveOperatorInfoResponse.newBuilder().addAllOperators(new ArrayList<Operator>()).build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<OperatorQuery> queries = new ArrayList<>();

    ResolveOperatorInfoResponse actualResponse = client.resolveOperatorInfo(parent, queries);
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
  public void resolveOperatorInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<OperatorQuery> queries = new ArrayList<>();
      client.resolveOperatorInfo(parent, queries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resolveOperatorInfoTest2() throws Exception {
    ResolveOperatorInfoResponse expectedResponse =
        ResolveOperatorInfoResponse.newBuilder().addAllOperators(new ArrayList<Operator>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    List<OperatorQuery> queries = new ArrayList<>();

    ResolveOperatorInfoResponse actualResponse = client.resolveOperatorInfo(parent, queries);
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
  public void resolveOperatorInfoExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      List<OperatorQuery> queries = new ArrayList<>();
      client.resolveOperatorInfo(parent, queries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOperatorsTest() throws Exception {
    Operator responsesElement = Operator.newBuilder().build();
    ListOperatorsResponse expectedResponse =
        ListOperatorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperators(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOperatorsPagedResponse pagedListResponse = client.listOperators(parent);

    List<Operator> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperatorsList().get(0), resources.get(0));

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
  public void listOperatorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listOperators(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOperatorsTest2() throws Exception {
    Operator responsesElement = Operator.newBuilder().build();
    ListOperatorsResponse expectedResponse =
        ListOperatorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperators(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListOperatorsPagedResponse pagedListResponse = client.listOperators(parent);

    List<Operator> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperatorsList().get(0), resources.get(0));

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
  public void listOperatorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listOperators(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOperatorTest() throws Exception {
    Operator expectedResponse =
        Operator.newBuilder()
            .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOperatorDefinition(OperatorDefinition.newBuilder().build())
            .setDockerImage("dockerImage2086149915")
            .build();
    mockService.addResponse(expectedResponse);

    OperatorName name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]");

    Operator actualResponse = client.getOperator(name);
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
  public void getOperatorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OperatorName name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]");
      client.getOperator(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOperatorTest2() throws Exception {
    Operator expectedResponse =
        Operator.newBuilder()
            .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOperatorDefinition(OperatorDefinition.newBuilder().build())
            .setDockerImage("dockerImage2086149915")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1387/locations/location-1387/operators/operator-1387";

    Operator actualResponse = client.getOperator(name);
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
  public void getOperatorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1387/locations/location-1387/operators/operator-1387";
      client.getOperator(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOperatorTest() throws Exception {
    Operator expectedResponse =
        Operator.newBuilder()
            .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOperatorDefinition(OperatorDefinition.newBuilder().build())
            .setDockerImage("dockerImage2086149915")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOperatorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Operator operator = Operator.newBuilder().build();
    String operatorId = "operatorId4364511";

    Operator actualResponse = client.createOperatorAsync(parent, operator, operatorId).get();
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
  public void createOperatorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Operator operator = Operator.newBuilder().build();
      String operatorId = "operatorId4364511";
      client.createOperatorAsync(parent, operator, operatorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createOperatorTest2() throws Exception {
    Operator expectedResponse =
        Operator.newBuilder()
            .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOperatorDefinition(OperatorDefinition.newBuilder().build())
            .setDockerImage("dockerImage2086149915")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOperatorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Operator operator = Operator.newBuilder().build();
    String operatorId = "operatorId4364511";

    Operator actualResponse = client.createOperatorAsync(parent, operator, operatorId).get();
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
  public void createOperatorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Operator operator = Operator.newBuilder().build();
      String operatorId = "operatorId4364511";
      client.createOperatorAsync(parent, operator, operatorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateOperatorTest() throws Exception {
    Operator expectedResponse =
        Operator.newBuilder()
            .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOperatorDefinition(OperatorDefinition.newBuilder().build())
            .setDockerImage("dockerImage2086149915")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateOperatorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Operator operator =
        Operator.newBuilder()
            .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOperatorDefinition(OperatorDefinition.newBuilder().build())
            .setDockerImage("dockerImage2086149915")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Operator actualResponse = client.updateOperatorAsync(operator, updateMask).get();
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
  public void updateOperatorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Operator operator =
          Operator.newBuilder()
              .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setOperatorDefinition(OperatorDefinition.newBuilder().build())
              .setDockerImage("dockerImage2086149915")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOperatorAsync(operator, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteOperatorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOperatorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OperatorName name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]");

    client.deleteOperatorAsync(name).get();

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
  public void deleteOperatorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OperatorName name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]");
      client.deleteOperatorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteOperatorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOperatorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1387/locations/location-1387/operators/operator-1387";

    client.deleteOperatorAsync(name).get();

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
  public void deleteOperatorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1387/locations/location-1387/operators/operator-1387";
      client.deleteOperatorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listAnalysesTest() throws Exception {
    Analysis responsesElement = Analysis.newBuilder().build();
    ListAnalysesResponse expectedResponse =
        ListAnalysesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListAnalysesPagedResponse pagedListResponse = client.listAnalyses(parent);

    List<Analysis> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysesList().get(0), resources.get(0));

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
  public void listAnalysesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listAnalyses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalysesTest2() throws Exception {
    Analysis responsesElement = Analysis.newBuilder().build();
    ListAnalysesResponse expectedResponse =
        ListAnalysesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";

    ListAnalysesPagedResponse pagedListResponse = client.listAnalyses(parent);

    List<Analysis> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysesList().get(0), resources.get(0));

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
  public void listAnalysesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      client.listAnalyses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalysisTest() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
            .putAllInputStreamsMapping(new HashMap<String, String>())
            .putAllOutputStreamsMapping(new HashMap<String, String>())
            .setDisableEventWatch(true)
            .build();
    mockService.addResponse(expectedResponse);

    AnalysisName name = AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]");

    Analysis actualResponse = client.getAnalysis(name);
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
  public void getAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisName name = AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]");
      client.getAnalysis(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalysisTest2() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
            .putAllInputStreamsMapping(new HashMap<String, String>())
            .putAllOutputStreamsMapping(new HashMap<String, String>())
            .setDisableEventWatch(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7631/locations/location-7631/clusters/cluster-7631/analyses/analyse-7631";

    Analysis actualResponse = client.getAnalysis(name);
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
  public void getAnalysisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7631/locations/location-7631/clusters/cluster-7631/analyses/analyse-7631";
      client.getAnalysis(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalysisTest() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
            .putAllInputStreamsMapping(new HashMap<String, String>())
            .putAllOutputStreamsMapping(new HashMap<String, String>())
            .setDisableEventWatch(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Analysis analysis = Analysis.newBuilder().build();
    String analysisId = "analysisId-944835305";

    Analysis actualResponse = client.createAnalysisAsync(parent, analysis, analysisId).get();
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
  public void createAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Analysis analysis = Analysis.newBuilder().build();
      String analysisId = "analysisId-944835305";
      client.createAnalysisAsync(parent, analysis, analysisId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAnalysisTest2() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
            .putAllInputStreamsMapping(new HashMap<String, String>())
            .putAllOutputStreamsMapping(new HashMap<String, String>())
            .setDisableEventWatch(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
    Analysis analysis = Analysis.newBuilder().build();
    String analysisId = "analysisId-944835305";

    Analysis actualResponse = client.createAnalysisAsync(parent, analysis, analysisId).get();
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
  public void createAnalysisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      Analysis analysis = Analysis.newBuilder().build();
      String analysisId = "analysisId-944835305";
      client.createAnalysisAsync(parent, analysis, analysisId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAnalysisTest() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
            .putAllInputStreamsMapping(new HashMap<String, String>())
            .putAllOutputStreamsMapping(new HashMap<String, String>())
            .setDisableEventWatch(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Analysis analysis =
        Analysis.newBuilder()
            .setName(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
            .putAllInputStreamsMapping(new HashMap<String, String>())
            .putAllOutputStreamsMapping(new HashMap<String, String>())
            .setDisableEventWatch(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Analysis actualResponse = client.updateAnalysisAsync(analysis, updateMask).get();
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
  public void updateAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Analysis analysis =
          Analysis.newBuilder()
              .setName(
                  AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setAnalysisDefinition(AnalysisDefinition.newBuilder().build())
              .putAllInputStreamsMapping(new HashMap<String, String>())
              .putAllOutputStreamsMapping(new HashMap<String, String>())
              .setDisableEventWatch(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAnalysisAsync(analysis, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAnalysisTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AnalysisName name = AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]");

    client.deleteAnalysisAsync(name).get();

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
  public void deleteAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisName name = AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]");
      client.deleteAnalysisAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAnalysisTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7631/locations/location-7631/clusters/cluster-7631/analyses/analyse-7631";

    client.deleteAnalysisAsync(name).get();

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
  public void deleteAnalysisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7631/locations/location-7631/clusters/cluster-7631/analyses/analyse-7631";
      client.deleteAnalysisAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listProcessesTest() throws Exception {
    Process responsesElement = Process.newBuilder().build();
    ListProcessesResponse expectedResponse =
        ListProcessesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcesses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListProcessesPagedResponse pagedListResponse = client.listProcesses(parent);

    List<Process> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessesList().get(0), resources.get(0));

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
  public void listProcessesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listProcesses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessesTest2() throws Exception {
    Process responsesElement = Process.newBuilder().build();
    ListProcessesResponse expectedResponse =
        ListProcessesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcesses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";

    ListProcessesPagedResponse pagedListResponse = client.listProcesses(parent);

    List<Process> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessesList().get(0), resources.get(0));

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
  public void listProcessesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      client.listProcesses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessTest() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAnalysis(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .addAllAttributeOverrides(new ArrayList<String>())
            .setRunStatus(RunStatus.newBuilder().build())
            .setRunMode(RunMode.forNumber(0))
            .setEventId("eventId-1376502443")
            .setBatchId("batchId-331744779")
            .setRetryCount(-928040776)
            .build();
    mockService.addResponse(expectedResponse);

    ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]");

    Process actualResponse = client.getProcess(name);
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
  public void getProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]");
      client.getProcess(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessTest2() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAnalysis(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .addAllAttributeOverrides(new ArrayList<String>())
            .setRunStatus(RunStatus.newBuilder().build())
            .setRunMode(RunMode.forNumber(0))
            .setEventId("eventId-1376502443")
            .setBatchId("batchId-331744779")
            .setRetryCount(-928040776)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2622/locations/location-2622/clusters/cluster-2622/processes/processe-2622";

    Process actualResponse = client.getProcess(name);
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
  public void getProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2622/locations/location-2622/clusters/cluster-2622/processes/processe-2622";
      client.getProcess(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProcessTest() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAnalysis(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .addAllAttributeOverrides(new ArrayList<String>())
            .setRunStatus(RunStatus.newBuilder().build())
            .setRunMode(RunMode.forNumber(0))
            .setEventId("eventId-1376502443")
            .setBatchId("batchId-331744779")
            .setRetryCount(-928040776)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Process process = Process.newBuilder().build();
    String processId = "processId-1094760470";

    Process actualResponse = client.createProcessAsync(parent, process, processId).get();
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
  public void createProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Process process = Process.newBuilder().build();
      String processId = "processId-1094760470";
      client.createProcessAsync(parent, process, processId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createProcessTest2() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAnalysis(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .addAllAttributeOverrides(new ArrayList<String>())
            .setRunStatus(RunStatus.newBuilder().build())
            .setRunMode(RunMode.forNumber(0))
            .setEventId("eventId-1376502443")
            .setBatchId("batchId-331744779")
            .setRetryCount(-928040776)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
    Process process = Process.newBuilder().build();
    String processId = "processId-1094760470";

    Process actualResponse = client.createProcessAsync(parent, process, processId).get();
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
  public void createProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      Process process = Process.newBuilder().build();
      String processId = "processId-1094760470";
      client.createProcessAsync(parent, process, processId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateProcessTest() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAnalysis(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .addAllAttributeOverrides(new ArrayList<String>())
            .setRunStatus(RunStatus.newBuilder().build())
            .setRunMode(RunMode.forNumber(0))
            .setEventId("eventId-1376502443")
            .setBatchId("batchId-331744779")
            .setRetryCount(-928040776)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Process process =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAnalysis(
                AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
            .addAllAttributeOverrides(new ArrayList<String>())
            .setRunStatus(RunStatus.newBuilder().build())
            .setRunMode(RunMode.forNumber(0))
            .setEventId("eventId-1376502443")
            .setBatchId("batchId-331744779")
            .setRetryCount(-928040776)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Process actualResponse = client.updateProcessAsync(process, updateMask).get();
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
  public void updateProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Process process =
          Process.newBuilder()
              .setName(
                  ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setAnalysis(
                  AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
              .addAllAttributeOverrides(new ArrayList<String>())
              .setRunStatus(RunStatus.newBuilder().build())
              .setRunMode(RunMode.forNumber(0))
              .setEventId("eventId-1376502443")
              .setBatchId("batchId-331744779")
              .setRetryCount(-928040776)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProcessAsync(process, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteProcessTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]");

    client.deleteProcessAsync(name).get();

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
  public void deleteProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]");
      client.deleteProcessAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteProcessTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2622/locations/location-2622/clusters/cluster-2622/processes/processe-2622";

    client.deleteProcessAsync(name).get();

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
  public void deleteProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2622/locations/location-2622/clusters/cluster-2622/processes/processe-2622";
      client.deleteProcessAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchRunProcessTest() throws Exception {
    BatchRunProcessResponse expectedResponse =
        BatchRunProcessResponse.newBuilder()
            .setBatchId("batchId-331744779")
            .addAllProcesses(new ArrayList<Process>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchRunProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    List<CreateProcessRequest> requests = new ArrayList<>();

    BatchRunProcessResponse actualResponse = client.batchRunProcessAsync(parent, requests).get();
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
  public void batchRunProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      List<CreateProcessRequest> requests = new ArrayList<>();
      client.batchRunProcessAsync(parent, requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchRunProcessTest2() throws Exception {
    BatchRunProcessResponse expectedResponse =
        BatchRunProcessResponse.newBuilder()
            .setBatchId("batchId-331744779")
            .addAllProcesses(new ArrayList<Process>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchRunProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
    List<CreateProcessRequest> requests = new ArrayList<>();

    BatchRunProcessResponse actualResponse = client.batchRunProcessAsync(parent, requests).get();
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
  public void batchRunProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      List<CreateProcessRequest> requests = new ArrayList<>();
      client.batchRunProcessAsync(parent, requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
