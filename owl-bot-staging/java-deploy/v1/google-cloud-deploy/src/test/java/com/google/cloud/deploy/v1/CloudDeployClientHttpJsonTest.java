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

package com.google.cloud.deploy.v1;

import static com.google.cloud.deploy.v1.CloudDeployClient.ListDeliveryPipelinesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListReleasesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListRolloutsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListTargetsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.deploy.v1.stub.HttpJsonCloudDeployStub;
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
public class CloudDeployClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudDeployClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudDeployStub.getMethodDescriptors(),
            CloudDeploySettings.getDefaultEndpoint());
    CloudDeploySettings settings =
        CloudDeploySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudDeploySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudDeployClient.create(settings);
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
  public void listDeliveryPipelinesTest() throws Exception {
    DeliveryPipeline responsesElement = DeliveryPipeline.newBuilder().build();
    ListDeliveryPipelinesResponse expectedResponse =
        ListDeliveryPipelinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeliveryPipelines(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeliveryPipelinesPagedResponse pagedListResponse = client.listDeliveryPipelines(parent);

    List<DeliveryPipeline> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeliveryPipelinesList().get(0), resources.get(0));

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
  public void listDeliveryPipelinesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDeliveryPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeliveryPipelinesTest2() throws Exception {
    DeliveryPipeline responsesElement = DeliveryPipeline.newBuilder().build();
    ListDeliveryPipelinesResponse expectedResponse =
        ListDeliveryPipelinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeliveryPipelines(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDeliveryPipelinesPagedResponse pagedListResponse = client.listDeliveryPipelines(parent);

    List<DeliveryPipeline> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeliveryPipelinesList().get(0), resources.get(0));

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
  public void listDeliveryPipelinesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDeliveryPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeliveryPipelineTest() throws Exception {
    DeliveryPipeline expectedResponse =
        DeliveryPipeline.newBuilder()
            .setName(
                DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCondition(PipelineCondition.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    DeliveryPipelineName name =
        DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");

    DeliveryPipeline actualResponse = client.getDeliveryPipeline(name);
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
  public void getDeliveryPipelineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeliveryPipelineName name =
          DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
      client.getDeliveryPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeliveryPipelineTest2() throws Exception {
    DeliveryPipeline expectedResponse =
        DeliveryPipeline.newBuilder()
            .setName(
                DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCondition(PipelineCondition.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2531/locations/location-2531/deliveryPipelines/deliveryPipeline-2531";

    DeliveryPipeline actualResponse = client.getDeliveryPipeline(name);
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
  public void getDeliveryPipelineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2531/locations/location-2531/deliveryPipelines/deliveryPipeline-2531";
      client.getDeliveryPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeliveryPipelineTest() throws Exception {
    DeliveryPipeline expectedResponse =
        DeliveryPipeline.newBuilder()
            .setName(
                DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCondition(PipelineCondition.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDeliveryPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
    String deliveryPipelineId = "deliveryPipelineId-632411535";

    DeliveryPipeline actualResponse =
        client.createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId).get();
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
  public void createDeliveryPipelineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
      String deliveryPipelineId = "deliveryPipelineId-632411535";
      client.createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDeliveryPipelineTest2() throws Exception {
    DeliveryPipeline expectedResponse =
        DeliveryPipeline.newBuilder()
            .setName(
                DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCondition(PipelineCondition.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDeliveryPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
    String deliveryPipelineId = "deliveryPipelineId-632411535";

    DeliveryPipeline actualResponse =
        client.createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId).get();
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
  public void createDeliveryPipelineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
      String deliveryPipelineId = "deliveryPipelineId-632411535";
      client.createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDeliveryPipelineTest() throws Exception {
    DeliveryPipeline expectedResponse =
        DeliveryPipeline.newBuilder()
            .setName(
                DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCondition(PipelineCondition.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDeliveryPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeliveryPipeline deliveryPipeline =
        DeliveryPipeline.newBuilder()
            .setName(
                DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCondition(PipelineCondition.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeliveryPipeline actualResponse =
        client.updateDeliveryPipelineAsync(deliveryPipeline, updateMask).get();
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
  public void updateDeliveryPipelineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeliveryPipeline deliveryPipeline =
          DeliveryPipeline.newBuilder()
              .setName(
                  DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
                      .toString())
              .setUid("uid115792")
              .setDescription("description-1724546052")
              .putAllAnnotations(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setCondition(PipelineCondition.newBuilder().build())
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeliveryPipelineAsync(deliveryPipeline, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDeliveryPipelineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDeliveryPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeliveryPipelineName name =
        DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");

    client.deleteDeliveryPipelineAsync(name).get();

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
  public void deleteDeliveryPipelineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeliveryPipelineName name =
          DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
      client.deleteDeliveryPipelineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDeliveryPipelineTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDeliveryPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2531/locations/location-2531/deliveryPipelines/deliveryPipeline-2531";

    client.deleteDeliveryPipelineAsync(name).get();

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
  public void deleteDeliveryPipelineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2531/locations/location-2531/deliveryPipelines/deliveryPipeline-2531";
      client.deleteDeliveryPipelineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTargetsTest() throws Exception {
    Target responsesElement = Target.newBuilder().build();
    ListTargetsResponse expectedResponse =
        ListTargetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTargetsPagedResponse pagedListResponse = client.listTargets(parent);

    List<Target> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetsList().get(0), resources.get(0));

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
  public void listTargetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTargets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTargetsTest2() throws Exception {
    Target responsesElement = Target.newBuilder().build();
    ListTargetsResponse expectedResponse =
        ListTargetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTargetsPagedResponse pagedListResponse = client.listTargets(parent);

    List<Target> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetsList().get(0), resources.get(0));

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
  public void listTargetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listTargets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetTest() throws Exception {
    Target expectedResponse =
        Target.newBuilder()
            .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
            .setTargetId("targetId-441951604")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setRequireApproval(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");

    Target actualResponse = client.getTarget(name);
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
  public void getTargetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");
      client.getTarget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetTest2() throws Exception {
    Target expectedResponse =
        Target.newBuilder()
            .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
            .setTargetId("targetId-441951604")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setRequireApproval(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8104/locations/location-8104/targets/target-8104";

    Target actualResponse = client.getTarget(name);
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
  public void getTargetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8104/locations/location-8104/targets/target-8104";
      client.getTarget(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTargetTest() throws Exception {
    Target expectedResponse =
        Target.newBuilder()
            .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
            .setTargetId("targetId-441951604")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setRequireApproval(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Target target = Target.newBuilder().build();
    String targetId = "targetId-441951604";

    Target actualResponse = client.createTargetAsync(parent, target, targetId).get();
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
  public void createTargetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Target target = Target.newBuilder().build();
      String targetId = "targetId-441951604";
      client.createTargetAsync(parent, target, targetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createTargetTest2() throws Exception {
    Target expectedResponse =
        Target.newBuilder()
            .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
            .setTargetId("targetId-441951604")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setRequireApproval(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Target target = Target.newBuilder().build();
    String targetId = "targetId-441951604";

    Target actualResponse = client.createTargetAsync(parent, target, targetId).get();
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
  public void createTargetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Target target = Target.newBuilder().build();
      String targetId = "targetId-441951604";
      client.createTargetAsync(parent, target, targetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTargetTest() throws Exception {
    Target expectedResponse =
        Target.newBuilder()
            .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
            .setTargetId("targetId-441951604")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setRequireApproval(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTargetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Target target =
        Target.newBuilder()
            .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
            .setTargetId("targetId-441951604")
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setRequireApproval(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Target actualResponse = client.updateTargetAsync(target, updateMask).get();
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
  public void updateTargetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Target target =
          Target.newBuilder()
              .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
              .setTargetId("targetId-441951604")
              .setUid("uid115792")
              .setDescription("description-1724546052")
              .putAllAnnotations(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .setRequireApproval(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .addAllExecutionConfigs(new ArrayList<ExecutionConfig>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTargetAsync(target, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTargetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");

    client.deleteTargetAsync(name).get();

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
  public void deleteTargetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");
      client.deleteTargetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTargetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-8104/locations/location-8104/targets/target-8104";

    client.deleteTargetAsync(name).get();

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
  public void deleteTargetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8104/locations/location-8104/targets/target-8104";
      client.deleteTargetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listReleasesTest() throws Exception {
    Release responsesElement = Release.newBuilder().build();
    ListReleasesResponse expectedResponse =
        ListReleasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DeliveryPipelineName parent =
        DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

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
  public void listReleasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeliveryPipelineName parent =
          DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
      client.listReleases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReleasesTest2() throws Exception {
    Release responsesElement = Release.newBuilder().build();
    ListReleasesResponse expectedResponse =
        ListReleasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-5586/locations/location-5586/deliveryPipelines/deliveryPipeline-5586";

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

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
  public void listReleasesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5586/locations/location-5586/deliveryPipelines/deliveryPipeline-5586";
      client.listReleases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRenderStartTime(Timestamp.newBuilder().build())
            .setRenderEndTime(Timestamp.newBuilder().build())
            .setSkaffoldConfigUri("skaffoldConfigUri1907228268")
            .setSkaffoldConfigPath("skaffoldConfigPath-1005630683")
            .addAllBuildArtifacts(new ArrayList<BuildArtifact>())
            .setDeliveryPipelineSnapshot(DeliveryPipeline.newBuilder().build())
            .addAllTargetSnapshots(new ArrayList<Target>())
            .setEtag("etag3123477")
            .setSkaffoldVersion("skaffoldVersion229290234")
            .putAllTargetArtifacts(new HashMap<String, TargetArtifact>())
            .putAllTargetRenders(new HashMap<String, Release.TargetRender>())
            .build();
    mockService.addResponse(expectedResponse);

    ReleaseName name =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");

    Release actualResponse = client.getRelease(name);
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
  public void getReleaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName name =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
      client.getRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseTest2() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRenderStartTime(Timestamp.newBuilder().build())
            .setRenderEndTime(Timestamp.newBuilder().build())
            .setSkaffoldConfigUri("skaffoldConfigUri1907228268")
            .setSkaffoldConfigPath("skaffoldConfigPath-1005630683")
            .addAllBuildArtifacts(new ArrayList<BuildArtifact>())
            .setDeliveryPipelineSnapshot(DeliveryPipeline.newBuilder().build())
            .addAllTargetSnapshots(new ArrayList<Target>())
            .setEtag("etag3123477")
            .setSkaffoldVersion("skaffoldVersion229290234")
            .putAllTargetArtifacts(new HashMap<String, TargetArtifact>())
            .putAllTargetRenders(new HashMap<String, Release.TargetRender>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-835/locations/location-835/deliveryPipelines/deliveryPipeline-835/releases/release-835";

    Release actualResponse = client.getRelease(name);
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
  public void getReleaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-835/locations/location-835/deliveryPipelines/deliveryPipeline-835/releases/release-835";
      client.getRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRenderStartTime(Timestamp.newBuilder().build())
            .setRenderEndTime(Timestamp.newBuilder().build())
            .setSkaffoldConfigUri("skaffoldConfigUri1907228268")
            .setSkaffoldConfigPath("skaffoldConfigPath-1005630683")
            .addAllBuildArtifacts(new ArrayList<BuildArtifact>())
            .setDeliveryPipelineSnapshot(DeliveryPipeline.newBuilder().build())
            .addAllTargetSnapshots(new ArrayList<Target>())
            .setEtag("etag3123477")
            .setSkaffoldVersion("skaffoldVersion229290234")
            .putAllTargetArtifacts(new HashMap<String, TargetArtifact>())
            .putAllTargetRenders(new HashMap<String, Release.TargetRender>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeliveryPipelineName parent =
        DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createReleaseAsync(parent, release, releaseId).get();
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
  public void createReleaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeliveryPipelineName parent =
          DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createReleaseAsync(parent, release, releaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createReleaseTest2() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRenderStartTime(Timestamp.newBuilder().build())
            .setRenderEndTime(Timestamp.newBuilder().build())
            .setSkaffoldConfigUri("skaffoldConfigUri1907228268")
            .setSkaffoldConfigPath("skaffoldConfigPath-1005630683")
            .addAllBuildArtifacts(new ArrayList<BuildArtifact>())
            .setDeliveryPipelineSnapshot(DeliveryPipeline.newBuilder().build())
            .addAllTargetSnapshots(new ArrayList<Target>())
            .setEtag("etag3123477")
            .setSkaffoldVersion("skaffoldVersion229290234")
            .putAllTargetArtifacts(new HashMap<String, TargetArtifact>())
            .putAllTargetRenders(new HashMap<String, Release.TargetRender>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-5586/locations/location-5586/deliveryPipelines/deliveryPipeline-5586";
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createReleaseAsync(parent, release, releaseId).get();
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
  public void createReleaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5586/locations/location-5586/deliveryPipelines/deliveryPipeline-5586";
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createReleaseAsync(parent, release, releaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void approveRolloutTest() throws Exception {
    ApproveRolloutResponse expectedResponse = ApproveRolloutResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RolloutName name =
        RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");

    ApproveRolloutResponse actualResponse = client.approveRollout(name);
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
  public void approveRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RolloutName name =
          RolloutName.of(
              "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
      client.approveRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveRolloutTest2() throws Exception {
    ApproveRolloutResponse expectedResponse = ApproveRolloutResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2057/locations/location-2057/deliveryPipelines/deliveryPipeline-2057/releases/release-2057/rollouts/rollout-2057";

    ApproveRolloutResponse actualResponse = client.approveRollout(name);
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
  public void approveRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2057/locations/location-2057/deliveryPipelines/deliveryPipeline-2057/releases/release-2057/rollouts/rollout-2057";
      client.approveRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolloutsTest() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListRolloutsResponse expectedResponse =
        ListRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ReleaseName parent =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

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
  public void listRolloutsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName parent =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
      client.listRollouts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolloutsTest2() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListRolloutsResponse expectedResponse =
        ListRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2532/locations/location-2532/deliveryPipelines/deliveryPipeline-2532/releases/release-2532";

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

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
  public void listRolloutsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2532/locations/location-2532/deliveryPipelines/deliveryPipeline-2532/releases/release-2532";
      client.listRollouts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of(
                        "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproveTime(Timestamp.newBuilder().build())
            .setEnqueueTime(Timestamp.newBuilder().build())
            .setDeployStartTime(Timestamp.newBuilder().build())
            .setDeployEndTime(Timestamp.newBuilder().build())
            .setTargetId("targetId-441951604")
            .setFailureReason("failureReason-1990598546")
            .setDeployingBuild("deployingBuild-1935837805")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    RolloutName name =
        RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");

    Rollout actualResponse = client.getRollout(name);
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
  public void getRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RolloutName name =
          RolloutName.of(
              "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
      client.getRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of(
                        "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproveTime(Timestamp.newBuilder().build())
            .setEnqueueTime(Timestamp.newBuilder().build())
            .setDeployStartTime(Timestamp.newBuilder().build())
            .setDeployEndTime(Timestamp.newBuilder().build())
            .setTargetId("targetId-441951604")
            .setFailureReason("failureReason-1990598546")
            .setDeployingBuild("deployingBuild-1935837805")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2057/locations/location-2057/deliveryPipelines/deliveryPipeline-2057/releases/release-2057/rollouts/rollout-2057";

    Rollout actualResponse = client.getRollout(name);
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
  public void getRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2057/locations/location-2057/deliveryPipelines/deliveryPipeline-2057/releases/release-2057/rollouts/rollout-2057";
      client.getRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of(
                        "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproveTime(Timestamp.newBuilder().build())
            .setEnqueueTime(Timestamp.newBuilder().build())
            .setDeployStartTime(Timestamp.newBuilder().build())
            .setDeployEndTime(Timestamp.newBuilder().build())
            .setTargetId("targetId-441951604")
            .setFailureReason("failureReason-1990598546")
            .setDeployingBuild("deployingBuild-1935837805")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReleaseName parent =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
    Rollout rollout = Rollout.newBuilder().build();
    String rolloutId = "rolloutId551248556";

    Rollout actualResponse = client.createRolloutAsync(parent, rollout, rolloutId).get();
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
  public void createRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName parent =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
      Rollout rollout = Rollout.newBuilder().build();
      String rolloutId = "rolloutId551248556";
      client.createRolloutAsync(parent, rollout, rolloutId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of(
                        "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
                    .toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproveTime(Timestamp.newBuilder().build())
            .setEnqueueTime(Timestamp.newBuilder().build())
            .setDeployStartTime(Timestamp.newBuilder().build())
            .setDeployEndTime(Timestamp.newBuilder().build())
            .setTargetId("targetId-441951604")
            .setFailureReason("failureReason-1990598546")
            .setDeployingBuild("deployingBuild-1935837805")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-2532/locations/location-2532/deliveryPipelines/deliveryPipeline-2532/releases/release-2532";
    Rollout rollout = Rollout.newBuilder().build();
    String rolloutId = "rolloutId551248556";

    Rollout actualResponse = client.createRolloutAsync(parent, rollout, rolloutId).get();
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
  public void createRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2532/locations/location-2532/deliveryPipelines/deliveryPipeline-2532/releases/release-2532";
      Rollout rollout = Rollout.newBuilder().build();
      String rolloutId = "rolloutId551248556";
      client.createRolloutAsync(parent, rollout, rolloutId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getConfigTest() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllSupportedVersions(new ArrayList<SkaffoldVersion>())
            .setDefaultSkaffoldVersion("defaultSkaffoldVersion-1555289991")
            .build();
    mockService.addResponse(expectedResponse);

    ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");

    Config actualResponse = client.getConfig(name);
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
  public void getConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");
      client.getConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConfigTest2() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllSupportedVersions(new ArrayList<SkaffoldVersion>())
            .setDefaultSkaffoldVersion("defaultSkaffoldVersion-1555289991")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-505/locations/location-505/config";

    Config actualResponse = client.getConfig(name);
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
  public void getConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-505/locations/location-505/config";
      client.getConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
