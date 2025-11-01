/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListGeneratorEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class GeneratorEvaluationsClientTest {
  private static MockGeneratorEvaluations mockGeneratorEvaluations;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GeneratorEvaluationsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGeneratorEvaluations = new MockGeneratorEvaluations();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGeneratorEvaluations, mockLocations));
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
    GeneratorEvaluationsSettings settings =
        GeneratorEvaluationsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GeneratorEvaluationsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createGeneratorEvaluationTest() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGeneratorEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGeneratorEvaluations.addResponse(resultOperation);

    GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
    GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();

    GeneratorEvaluation actualResponse =
        client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGeneratorEvaluationRequest actualRequest =
        ((CreateGeneratorEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(generatorEvaluation, actualRequest.getGeneratorEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGeneratorEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
      GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();
      client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGeneratorEvaluationTest2() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGeneratorEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGeneratorEvaluations.addResponse(resultOperation);

    String parent = "parent-995424086";
    GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();

    GeneratorEvaluation actualResponse =
        client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGeneratorEvaluationRequest actualRequest =
        ((CreateGeneratorEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(generatorEvaluation, actualRequest.getGeneratorEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGeneratorEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      String parent = "parent-995424086";
      GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();
      client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getGeneratorEvaluationTest() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockGeneratorEvaluations.addResponse(expectedResponse);

    GeneratorEvaluationName name =
        GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");

    GeneratorEvaluation actualResponse = client.getGeneratorEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGeneratorEvaluationRequest actualRequest =
        ((GetGeneratorEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGeneratorEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      GeneratorEvaluationName name =
          GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
      client.getGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGeneratorEvaluationTest2() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockGeneratorEvaluations.addResponse(expectedResponse);

    String name = "name3373707";

    GeneratorEvaluation actualResponse = client.getGeneratorEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGeneratorEvaluationRequest actualRequest =
        ((GetGeneratorEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGeneratorEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      String name = "name3373707";
      client.getGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeneratorEvaluationsTest() throws Exception {
    GeneratorEvaluation responsesElement = GeneratorEvaluation.newBuilder().build();
    ListGeneratorEvaluationsResponse expectedResponse =
        ListGeneratorEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGeneratorEvaluations(Arrays.asList(responsesElement))
            .build();
    mockGeneratorEvaluations.addResponse(expectedResponse);

    GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");

    ListGeneratorEvaluationsPagedResponse pagedListResponse =
        client.listGeneratorEvaluations(parent);

    List<GeneratorEvaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeneratorEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGeneratorEvaluationsRequest actualRequest =
        ((ListGeneratorEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGeneratorEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
      client.listGeneratorEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeneratorEvaluationsTest2() throws Exception {
    GeneratorEvaluation responsesElement = GeneratorEvaluation.newBuilder().build();
    ListGeneratorEvaluationsResponse expectedResponse =
        ListGeneratorEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGeneratorEvaluations(Arrays.asList(responsesElement))
            .build();
    mockGeneratorEvaluations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGeneratorEvaluationsPagedResponse pagedListResponse =
        client.listGeneratorEvaluations(parent);

    List<GeneratorEvaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeneratorEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGeneratorEvaluationsRequest actualRequest =
        ((ListGeneratorEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGeneratorEvaluationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGeneratorEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGeneratorEvaluationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGeneratorEvaluations.addResponse(expectedResponse);

    GeneratorEvaluationName name =
        GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");

    client.deleteGeneratorEvaluation(name);

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGeneratorEvaluationRequest actualRequest =
        ((DeleteGeneratorEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGeneratorEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      GeneratorEvaluationName name =
          GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
      client.deleteGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGeneratorEvaluationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGeneratorEvaluations.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGeneratorEvaluation(name);

    List<AbstractMessage> actualRequests = mockGeneratorEvaluations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGeneratorEvaluationRequest actualRequest =
        ((DeleteGeneratorEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGeneratorEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeneratorEvaluations.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
