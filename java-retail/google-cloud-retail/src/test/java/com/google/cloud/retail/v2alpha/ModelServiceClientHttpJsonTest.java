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

package com.google.cloud.retail.v2alpha;

import static com.google.cloud.retail.v2alpha.ModelServiceClient.ListModelsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2alpha.stub.HttpJsonModelServiceStub;
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
public class ModelServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ModelServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonModelServiceStub.getMethodDescriptors(),
            ModelServiceSettings.getDefaultEndpoint());
    ModelServiceSettings settings =
        ModelServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ModelServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ModelServiceClient.create(settings);
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
  public void createModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    Model model = Model.newBuilder().build();

    Model actualResponse = client.createModelAsync(parent, model).get();
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
  public void createModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      Model model = Model.newBuilder().build();
      client.createModelAsync(parent, model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    Model model = Model.newBuilder().build();

    Model actualResponse = client.createModelAsync(parent, model).get();
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
  public void createModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      Model model = Model.newBuilder().build();
      client.createModelAsync(parent, model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void pauseModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    mockService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");

    Model actualResponse = client.pauseModel(name);
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
  public void pauseModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");
      client.pauseModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";

    Model actualResponse = client.pauseModel(name);
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
  public void pauseModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";
      client.pauseModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";

    Model actualResponse = client.resumeModel(name);
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
  public void resumeModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";
      client.resumeModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");

    client.deleteModel(name);

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
  public void deleteModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");
      client.deleteModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";

    client.deleteModel(name);

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
  public void deleteModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";
      client.deleteModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

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
  public void listModelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest2() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

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
  public void listModelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    mockService.addResponse(expectedResponse);

    Model model =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setType("type3575610")
            .setOptimizationObjective("optimizationObjective-1014459828")
            .setLastTuneTime(Timestamp.newBuilder().build())
            .setTuningOperation("tuningOperation-1269747150")
            .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
            .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Model actualResponse = client.updateModel(model, updateMask);
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
  public void updateModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Model model =
          Model.newBuilder()
              .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setType("type3575610")
              .setOptimizationObjective("optimizationObjective-1014459828")
              .setLastTuneTime(Timestamp.newBuilder().build())
              .setTuningOperation("tuningOperation-1269747150")
              .setFilteringOption(RecommendationsFilteringOption.forNumber(0))
              .addAllServingConfigLists(new ArrayList<Model.ServingConfigList>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateModel(model, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void tuneModelTest() throws Exception {
    TuneModelResponse expectedResponse = TuneModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("tuneModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");

    TuneModelResponse actualResponse = client.tuneModelAsync(name).get();
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
  public void tuneModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");
      client.tuneModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void tuneModelTest2() throws Exception {
    TuneModelResponse expectedResponse = TuneModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("tuneModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";

    TuneModelResponse actualResponse = client.tuneModelAsync(name).get();
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
  public void tuneModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7594/locations/location-7594/catalogs/catalog-7594/models/model-7594";
      client.tuneModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
