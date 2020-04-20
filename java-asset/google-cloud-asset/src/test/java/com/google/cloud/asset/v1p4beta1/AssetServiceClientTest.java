/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.asset.v1p4beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class AssetServiceClientTest {
  private static MockAssetService mockAssetService;
  private static MockServiceHelper serviceHelper;
  private AssetServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAssetService = new MockAssetService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAssetService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    AssetServiceSettings settings =
        AssetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void exportIamPolicyAnalysisTest() throws Exception {
    ExportIamPolicyAnalysisResponse expectedResponse =
        ExportIamPolicyAnalysisResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportIamPolicyAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAssetService.addResponse(resultOperation);

    IamPolicyAnalysisQuery analysisQuery = IamPolicyAnalysisQuery.newBuilder().build();
    IamPolicyAnalysisOutputConfig outputConfig = IamPolicyAnalysisOutputConfig.newBuilder().build();
    ExportIamPolicyAnalysisRequest request =
        ExportIamPolicyAnalysisRequest.newBuilder()
            .setAnalysisQuery(analysisQuery)
            .setOutputConfig(outputConfig)
            .build();

    ExportIamPolicyAnalysisResponse actualResponse =
        client.exportIamPolicyAnalysisAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportIamPolicyAnalysisRequest actualRequest =
        (ExportIamPolicyAnalysisRequest) actualRequests.get(0);

    Assert.assertEquals(analysisQuery, actualRequest.getAnalysisQuery());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void exportIamPolicyAnalysisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      IamPolicyAnalysisQuery analysisQuery = IamPolicyAnalysisQuery.newBuilder().build();
      IamPolicyAnalysisOutputConfig outputConfig =
          IamPolicyAnalysisOutputConfig.newBuilder().build();
      ExportIamPolicyAnalysisRequest request =
          ExportIamPolicyAnalysisRequest.newBuilder()
              .setAnalysisQuery(analysisQuery)
              .setOutputConfig(outputConfig)
              .build();

      client.exportIamPolicyAnalysisAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeIamPolicyTest() {
    boolean fullyExplored = true;
    AnalyzeIamPolicyResponse expectedResponse =
        AnalyzeIamPolicyResponse.newBuilder().setFullyExplored(fullyExplored).build();
    mockAssetService.addResponse(expectedResponse);

    IamPolicyAnalysisQuery analysisQuery = IamPolicyAnalysisQuery.newBuilder().build();
    AnalyzeIamPolicyRequest request =
        AnalyzeIamPolicyRequest.newBuilder().setAnalysisQuery(analysisQuery).build();

    AnalyzeIamPolicyResponse actualResponse = client.analyzeIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeIamPolicyRequest actualRequest = (AnalyzeIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(analysisQuery, actualRequest.getAnalysisQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      IamPolicyAnalysisQuery analysisQuery = IamPolicyAnalysisQuery.newBuilder().build();
      AnalyzeIamPolicyRequest request =
          AnalyzeIamPolicyRequest.newBuilder().setAnalysisQuery(analysisQuery).build();

      client.analyzeIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
