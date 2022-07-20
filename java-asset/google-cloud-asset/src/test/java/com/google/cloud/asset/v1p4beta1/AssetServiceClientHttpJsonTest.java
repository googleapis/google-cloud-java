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

package com.google.cloud.asset.v1p4beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.asset.v1p4beta1.stub.HttpJsonAssetServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
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
public class AssetServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AssetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAssetServiceStub.getMethodDescriptors(),
            AssetServiceSettings.getDefaultEndpoint());
    AssetServiceSettings settings =
        AssetServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AssetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssetServiceClient.create(settings);
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
  public void analyzeIamPolicyTest() throws Exception {
    AnalyzeIamPolicyResponse expectedResponse =
        AnalyzeIamPolicyResponse.newBuilder()
            .setMainAnalysis(AnalyzeIamPolicyResponse.IamPolicyAnalysis.newBuilder().build())
            .addAllServiceAccountImpersonationAnalysis(
                new ArrayList<AnalyzeIamPolicyResponse.IamPolicyAnalysis>())
            .setFullyExplored(true)
            .addAllNonCriticalErrors(new ArrayList<IamPolicyAnalysisResult.AnalysisState>())
            .build();
    mockService.addResponse(expectedResponse);

    AnalyzeIamPolicyRequest request =
        AnalyzeIamPolicyRequest.newBuilder()
            .setAnalysisQuery(
                IamPolicyAnalysisQuery.newBuilder()
                    .setParent("parent-4715/parent-4715")
                    .setResourceSelector(
                        IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                    .setIdentitySelector(
                        IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                    .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                    .build())
            .setOptions(AnalyzeIamPolicyRequest.Options.newBuilder().build())
            .build();

    AnalyzeIamPolicyResponse actualResponse = client.analyzeIamPolicy(request);
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
  public void analyzeIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalyzeIamPolicyRequest request =
          AnalyzeIamPolicyRequest.newBuilder()
              .setAnalysisQuery(
                  IamPolicyAnalysisQuery.newBuilder()
                      .setParent("parent-4715/parent-4715")
                      .setResourceSelector(
                          IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                      .setIdentitySelector(
                          IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                      .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                      .build())
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
    mockService.addResponse(resultOperation);

    ExportIamPolicyAnalysisRequest request =
        ExportIamPolicyAnalysisRequest.newBuilder()
            .setAnalysisQuery(
                IamPolicyAnalysisQuery.newBuilder()
                    .setParent("parent-4715/parent-4715")
                    .setResourceSelector(
                        IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                    .setIdentitySelector(
                        IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                    .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                    .build())
            .setOptions(ExportIamPolicyAnalysisRequest.Options.newBuilder().build())
            .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
            .build();

    ExportIamPolicyAnalysisResponse actualResponse =
        client.exportIamPolicyAnalysisAsync(request).get();
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
  public void exportIamPolicyAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportIamPolicyAnalysisRequest request =
          ExportIamPolicyAnalysisRequest.newBuilder()
              .setAnalysisQuery(
                  IamPolicyAnalysisQuery.newBuilder()
                      .setParent("parent-4715/parent-4715")
                      .setResourceSelector(
                          IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                      .setIdentitySelector(
                          IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                      .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                      .build())
              .setOptions(ExportIamPolicyAnalysisRequest.Options.newBuilder().build())
              .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
              .build();
      client.exportIamPolicyAnalysisAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
