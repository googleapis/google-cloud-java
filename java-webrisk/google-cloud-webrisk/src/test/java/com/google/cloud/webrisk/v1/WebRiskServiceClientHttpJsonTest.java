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

package com.google.cloud.webrisk.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.webrisk.v1.stub.HttpJsonWebRiskServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.ProjectName;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import com.google.webrisk.v1.ThreatEntryAdditions;
import com.google.webrisk.v1.ThreatEntryRemovals;
import com.google.webrisk.v1.ThreatType;
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
public class WebRiskServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WebRiskServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWebRiskServiceStub.getMethodDescriptors(),
            WebRiskServiceSettings.getDefaultEndpoint());
    WebRiskServiceSettings settings =
        WebRiskServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WebRiskServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WebRiskServiceClient.create(settings);
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
  public void computeThreatListDiffTest() throws Exception {
    ComputeThreatListDiffResponse expectedResponse =
        ComputeThreatListDiffResponse.newBuilder()
            .setAdditions(ThreatEntryAdditions.newBuilder().build())
            .setRemovals(ThreatEntryRemovals.newBuilder().build())
            .setNewVersionToken(ByteString.EMPTY)
            .setChecksum(ComputeThreatListDiffResponse.Checksum.newBuilder().build())
            .setRecommendedNextDiff(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ThreatType threatType = ThreatType.forNumber(0);
    ByteString versionToken = ByteString.EMPTY;
    ComputeThreatListDiffRequest.Constraints constraints =
        ComputeThreatListDiffRequest.Constraints.newBuilder().build();

    ComputeThreatListDiffResponse actualResponse =
        client.computeThreatListDiff(threatType, versionToken, constraints);
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
  public void computeThreatListDiffExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ThreatType threatType = ThreatType.forNumber(0);
      ByteString versionToken = ByteString.EMPTY;
      ComputeThreatListDiffRequest.Constraints constraints =
          ComputeThreatListDiffRequest.Constraints.newBuilder().build();
      client.computeThreatListDiff(threatType, versionToken, constraints);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchUrisTest() throws Exception {
    SearchUrisResponse expectedResponse =
        SearchUrisResponse.newBuilder()
            .setThreat(SearchUrisResponse.ThreatUri.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String uri = "uri116076";
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchUrisResponse actualResponse = client.searchUris(uri, threatTypes);
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
  public void searchUrisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String uri = "uri116076";
      List<ThreatType> threatTypes = new ArrayList<>();
      client.searchUris(uri, threatTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchHashesTest() throws Exception {
    SearchHashesResponse expectedResponse =
        SearchHashesResponse.newBuilder()
            .addAllThreats(new ArrayList<SearchHashesResponse.ThreatHash>())
            .setNegativeExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ByteString hashPrefix = ByteString.EMPTY;
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchHashesResponse actualResponse = client.searchHashes(hashPrefix, threatTypes);
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
  public void searchHashesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ByteString hashPrefix = ByteString.EMPTY;
      List<ThreatType> threatTypes = new ArrayList<>();
      client.searchHashes(hashPrefix, threatTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubmissionTest() throws Exception {
    Submission expectedResponse =
        Submission.newBuilder()
            .setUri("uri116076")
            .addAllThreatTypes(new ArrayList<ThreatType>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Submission submission = Submission.newBuilder().build();

    Submission actualResponse = client.createSubmission(parent, submission);
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
  public void createSubmissionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Submission submission = Submission.newBuilder().build();
      client.createSubmission(parent, submission);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubmissionTest2() throws Exception {
    Submission expectedResponse =
        Submission.newBuilder()
            .setUri("uri116076")
            .addAllThreatTypes(new ArrayList<ThreatType>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    Submission submission = Submission.newBuilder().build();

    Submission actualResponse = client.createSubmission(parent, submission);
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
  public void createSubmissionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      Submission submission = Submission.newBuilder().build();
      client.createSubmission(parent, submission);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitUriTest() throws Exception {
    Submission expectedResponse =
        Submission.newBuilder()
            .setUri("uri116076")
            .addAllThreatTypes(new ArrayList<ThreatType>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("submitUriTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Submission submission = Submission.newBuilder().build();

    Submission actualResponse = client.submitUriAsync(parent, submission).get();
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
  public void submitUriExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Submission submission = Submission.newBuilder().build();
      client.submitUriAsync(parent, submission).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void submitUriTest2() throws Exception {
    Submission expectedResponse =
        Submission.newBuilder()
            .setUri("uri116076")
            .addAllThreatTypes(new ArrayList<ThreatType>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("submitUriTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2353";
    Submission submission = Submission.newBuilder().build();

    Submission actualResponse = client.submitUriAsync(parent, submission).get();
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
  public void submitUriExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      Submission submission = Submission.newBuilder().build();
      client.submitUriAsync(parent, submission).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
