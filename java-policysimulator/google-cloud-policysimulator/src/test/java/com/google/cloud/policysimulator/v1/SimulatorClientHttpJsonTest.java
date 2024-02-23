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

package com.google.cloud.policysimulator.v1;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.policysimulator.v1.stub.HttpJsonSimulatorStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
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
public class SimulatorClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SimulatorClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSimulatorStub.getMethodDescriptors(), SimulatorSettings.getDefaultEndpoint());
    SimulatorSettings settings =
        SimulatorSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SimulatorSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SimulatorClient.create(settings);
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
  public void getReplayTest() throws Exception {
    Replay expectedResponse =
        Replay.newBuilder()
            .setName(
                ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
                    .toString())
            .setConfig(ReplayConfig.newBuilder().build())
            .setResultsSummary(Replay.ResultsSummary.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReplayName name = ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");

    Replay actualResponse = client.getReplay(name);
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
  public void getReplayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReplayName name =
          ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");
      client.getReplay(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReplayTest2() throws Exception {
    Replay expectedResponse =
        Replay.newBuilder()
            .setName(
                ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
                    .toString())
            .setConfig(ReplayConfig.newBuilder().build())
            .setResultsSummary(Replay.ResultsSummary.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9166/locations/location-9166/replays/replay-9166";

    Replay actualResponse = client.getReplay(name);
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
  public void getReplayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9166/locations/location-9166/replays/replay-9166";
      client.getReplay(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReplayTest() throws Exception {
    Replay expectedResponse =
        Replay.newBuilder()
            .setName(
                ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
                    .toString())
            .setConfig(ReplayConfig.newBuilder().build())
            .setResultsSummary(Replay.ResultsSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReplayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Replay replay = Replay.newBuilder().build();

    Replay actualResponse = client.createReplayAsync(parent, replay).get();
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
  public void createReplayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Replay replay = Replay.newBuilder().build();
      client.createReplayAsync(parent, replay).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listReplayResultsTest() throws Exception {
    ReplayResult responsesElement = ReplayResult.newBuilder().build();
    ListReplayResultsResponse expectedResponse =
        ListReplayResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReplayResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ReplayName parent =
        ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");

    ListReplayResultsPagedResponse pagedListResponse = client.listReplayResults(parent);

    List<ReplayResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReplayResultsList().get(0), resources.get(0));

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
  public void listReplayResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReplayName parent =
          ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");
      client.listReplayResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReplayResultsTest2() throws Exception {
    ReplayResult responsesElement = ReplayResult.newBuilder().build();
    ListReplayResultsResponse expectedResponse =
        ListReplayResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReplayResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4625/locations/location-4625/replays/replay-4625";

    ListReplayResultsPagedResponse pagedListResponse = client.listReplayResults(parent);

    List<ReplayResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReplayResultsList().get(0), resources.get(0));

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
  public void listReplayResultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4625/locations/location-4625/replays/replay-4625";
      client.listReplayResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
