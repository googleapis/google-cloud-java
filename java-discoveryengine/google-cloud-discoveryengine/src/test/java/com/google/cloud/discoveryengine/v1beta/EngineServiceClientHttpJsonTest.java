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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.EngineServiceClient.ListEnginesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonEngineServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class EngineServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EngineServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEngineServiceStub.getMethodDescriptors(),
            EngineServiceSettings.getDefaultEndpoint());
    EngineServiceSettings settings =
        EngineServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EngineServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EngineServiceClient.create(settings);
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
  public void createEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    Engine engine = Engine.newBuilder().build();
    String engineId = "engineId1820490493";

    Engine actualResponse = client.createEngineAsync(parent, engine, engineId).get();
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
  public void createEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      Engine engine = Engine.newBuilder().build();
      String engineId = "engineId1820490493";
      client.createEngineAsync(parent, engine, engineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEngineTest2() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-566/locations/location-566/collections/collection-566";
    Engine engine = Engine.newBuilder().build();
    String engineId = "engineId1820490493";

    Engine actualResponse = client.createEngineAsync(parent, engine, engineId).get();
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
  public void createEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-566/locations/location-566/collections/collection-566";
      Engine engine = Engine.newBuilder().build();
      String engineId = "engineId1820490493";
      client.createEngineAsync(parent, engine, engineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEngineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    client.deleteEngineAsync(name).get();

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
  public void deleteEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.deleteEngineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEngineTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";

    client.deleteEngineAsync(name).get();

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
  public void deleteEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";
      client.deleteEngineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Engine engine =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Engine actualResponse = client.updateEngine(engine, updateMask);
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
  public void updateEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Engine engine =
          Engine.newBuilder()
              .setName(
                  EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllDataStoreIds(new ArrayList<String>())
              .setSolutionType(SolutionType.forNumber(0))
              .setIndustryVertical(IndustryVertical.forNumber(0))
              .setCommonConfig(Engine.CommonConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEngine(engine, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    Engine actualResponse = client.getEngine(name);
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
  public void getEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.getEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineTest2() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";

    Engine actualResponse = client.getEngine(name);
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
  public void getEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";
      client.getEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnginesTest() throws Exception {
    Engine responsesElement = Engine.newBuilder().build();
    ListEnginesResponse expectedResponse =
        ListEnginesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngines(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    ListEnginesPagedResponse pagedListResponse = client.listEngines(parent);

    List<Engine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnginesList().get(0), resources.get(0));

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
  public void listEnginesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      client.listEngines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnginesTest2() throws Exception {
    Engine responsesElement = Engine.newBuilder().build();
    ListEnginesResponse expectedResponse =
        ListEnginesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngines(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-566/locations/location-566/collections/collection-566";

    ListEnginesPagedResponse pagedListResponse = client.listEngines(parent);

    List<Engine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnginesList().get(0), resources.get(0));

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
  public void listEnginesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-566/locations/location-566/collections/collection-566";
      client.listEngines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    Engine actualResponse = client.pauseEngine(name);
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
  public void pauseEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.pauseEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseEngineTest2() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";

    Engine actualResponse = client.pauseEngine(name);
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
  public void pauseEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";
      client.pauseEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    Engine actualResponse = client.resumeEngine(name);
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
  public void resumeEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.resumeEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeEngineTest2() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";

    Engine actualResponse = client.resumeEngine(name);
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
  public void resumeEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";
      client.resumeEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void tuneEngineTest() throws Exception {
    TuneEngineResponse expectedResponse = TuneEngineResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("tuneEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    TuneEngineResponse actualResponse = client.tuneEngineAsync(name).get();
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
  public void tuneEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.tuneEngineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void tuneEngineTest2() throws Exception {
    TuneEngineResponse expectedResponse = TuneEngineResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("tuneEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";

    TuneEngineResponse actualResponse = client.tuneEngineAsync(name).get();
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
  public void tuneEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5624/locations/location-5624/collections/collection-5624/engines/engine-5624";
      client.tuneEngineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
