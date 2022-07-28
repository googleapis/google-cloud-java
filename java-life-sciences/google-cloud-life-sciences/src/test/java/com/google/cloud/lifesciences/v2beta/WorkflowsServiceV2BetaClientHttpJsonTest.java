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

package com.google.cloud.lifesciences.v2beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.lifesciences.v2beta.stub.HttpJsonWorkflowsServiceV2BetaStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
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
public class WorkflowsServiceV2BetaClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WorkflowsServiceV2BetaClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWorkflowsServiceV2BetaStub.getMethodDescriptors(),
            WorkflowsServiceV2BetaSettings.getDefaultEndpoint());
    WorkflowsServiceV2BetaSettings settings =
        WorkflowsServiceV2BetaSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WorkflowsServiceV2BetaSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkflowsServiceV2BetaClient.create(settings);
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
  public void runPipelineTest() throws Exception {
    RunPipelineResponse expectedResponse = RunPipelineResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RunPipelineRequest request =
        RunPipelineRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setPipeline(Pipeline.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPubSubTopic("pubSubTopic320524524")
            .build();

    RunPipelineResponse actualResponse = client.runPipelineAsync(request).get();
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
  public void runPipelineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunPipelineRequest request =
          RunPipelineRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setPipeline(Pipeline.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setPubSubTopic("pubSubTopic320524524")
              .build();
      client.runPipelineAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
