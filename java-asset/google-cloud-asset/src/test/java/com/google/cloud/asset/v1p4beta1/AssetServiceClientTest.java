/*
 * Copyright 2020 Google LLC
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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class AssetServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private AssetServiceClient client;
  private LocalChannelProvider channelProvider;
  private static MockAssetService mockAssetService;

  @BeforeClass
  public static void startStaticServer() {
    mockAssetService = new MockAssetService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAssetService));
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
  public void analyzeIamPolicyTest() throws Exception {
    AnalyzeIamPolicyResponse expectedResponse =
        AnalyzeIamPolicyResponse.newBuilder()
            .setMainAnalysis(AnalyzeIamPolicyResponse.IamPolicyAnalysis.newBuilder().build())
            .addAllServiceAccountImpersonationAnalysis(
                new ArrayList<AnalyzeIamPolicyResponse.IamPolicyAnalysis>())
            .setFullyExplored(true)
            .addAllNonCriticalErrors(new ArrayList<IamPolicyAnalysisResult.AnalysisState>())
            .build();
    mockAssetService.addResponse(expectedResponse);

    AnalyzeIamPolicyRequest request =
        AnalyzeIamPolicyRequest.newBuilder()
            .setAnalysisQuery(IamPolicyAnalysisQuery.newBuilder().build())
            .setOptions(AnalyzeIamPolicyRequest.Options.newBuilder().build())
            .build();

    AnalyzeIamPolicyResponse actualResponse = client.analyzeIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeIamPolicyRequest actualRequest = ((AnalyzeIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAnalysisQuery(), actualRequest.getAnalysisQuery());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      AnalyzeIamPolicyRequest request =
          AnalyzeIamPolicyRequest.newBuilder()
              .setAnalysisQuery(IamPolicyAnalysisQuery.newBuilder().build())
              .setOptions(AnalyzeIamPolicyRequest.Options.newBuilder().build())
              .build();
      client.analyzeIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportIamPolicyAnalysisTest() throws Exception {
    ExportIamPolicyAnalysisResponse expectedResponse =
        ExportIamPolicyAnalysisResponse.newBuilder()
            .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportIamPolicyAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAssetService.addResponse(resultOperation);

    ExportIamPolicyAnalysisRequest request =
        ExportIamPolicyAnalysisRequest.newBuilder()
            .setAnalysisQuery(IamPolicyAnalysisQuery.newBuilder().build())
            .setOptions(ExportIamPolicyAnalysisRequest.Options.newBuilder().build())
            .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
            .build();

    ExportIamPolicyAnalysisResponse actualResponse =
        client.exportIamPolicyAnalysisAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportIamPolicyAnalysisRequest actualRequest =
        ((ExportIamPolicyAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAnalysisQuery(), actualRequest.getAnalysisQuery());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportIamPolicyAnalysisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      ExportIamPolicyAnalysisRequest request =
          ExportIamPolicyAnalysisRequest.newBuilder()
              .setAnalysisQuery(IamPolicyAnalysisQuery.newBuilder().build())
              .setOptions(ExportIamPolicyAnalysisRequest.Options.newBuilder().build())
              .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
              .build();
      client.exportIamPolicyAnalysisAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
