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

package com.google.cloud.webrisk.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.ProjectName;
import com.google.webrisk.v1.SearchHashesRequest;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import com.google.webrisk.v1.ThreatEntryAdditions;
import com.google.webrisk.v1.ThreatEntryRemovals;
import com.google.webrisk.v1.ThreatType;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class WebRiskServiceClientTest {
  private static MockWebRiskService mockWebRiskService;
  private static MockServiceHelper mockServiceHelper;
  private WebRiskServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWebRiskService = new MockWebRiskService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockWebRiskService));
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
    WebRiskServiceSettings settings =
        WebRiskServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WebRiskServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void computeThreatListDiffTest() throws Exception {
    ComputeThreatListDiffResponse expectedResponse =
        ComputeThreatListDiffResponse.newBuilder()
            .setAdditions(ThreatEntryAdditions.newBuilder().build())
            .setRemovals(ThreatEntryRemovals.newBuilder().build())
            .setNewVersionToken(ByteString.EMPTY)
            .setRecommendedNextDiff(Timestamp.newBuilder().build())
            .build();
    mockWebRiskService.addResponse(expectedResponse);

    ThreatType threatType = ThreatType.forNumber(0);
    ByteString versionToken = ByteString.EMPTY;
    ComputeThreatListDiffRequest.Constraints constraints =
        ComputeThreatListDiffRequest.Constraints.newBuilder().build();

    ComputeThreatListDiffResponse actualResponse =
        client.computeThreatListDiff(threatType, versionToken, constraints);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeThreatListDiffRequest actualRequest =
        ((ComputeThreatListDiffRequest) actualRequests.get(0));

    Assert.assertEquals(threatType, actualRequest.getThreatType());
    Assert.assertEquals(versionToken, actualRequest.getVersionToken());
    Assert.assertEquals(constraints, actualRequest.getConstraints());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeThreatListDiffExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebRiskService.addException(exception);

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
    SearchUrisResponse expectedResponse = SearchUrisResponse.newBuilder().build();
    mockWebRiskService.addResponse(expectedResponse);

    String uri = "uri116076";
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchUrisResponse actualResponse = client.searchUris(uri, threatTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchUrisRequest actualRequest = ((SearchUrisRequest) actualRequests.get(0));

    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertEquals(threatTypes, actualRequest.getThreatTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchUrisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebRiskService.addException(exception);

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
    mockWebRiskService.addResponse(expectedResponse);

    ByteString hashPrefix = ByteString.EMPTY;
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchHashesResponse actualResponse = client.searchHashes(hashPrefix, threatTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchHashesRequest actualRequest = ((SearchHashesRequest) actualRequests.get(0));

    Assert.assertEquals(hashPrefix, actualRequest.getHashPrefix());
    Assert.assertEquals(threatTypes, actualRequest.getThreatTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchHashesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebRiskService.addException(exception);

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
    Submission expectedResponse = Submission.newBuilder().setUri("uri116076").build();
    mockWebRiskService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Submission submission = Submission.newBuilder().build();

    Submission actualResponse = client.createSubmission(parent, submission);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubmissionRequest actualRequest = ((CreateSubmissionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(submission, actualRequest.getSubmission());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubmissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebRiskService.addException(exception);

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
    Submission expectedResponse = Submission.newBuilder().setUri("uri116076").build();
    mockWebRiskService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Submission submission = Submission.newBuilder().build();

    Submission actualResponse = client.createSubmission(parent, submission);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubmissionRequest actualRequest = ((CreateSubmissionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(submission, actualRequest.getSubmission());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubmissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebRiskService.addException(exception);

    try {
      String parent = "parent-995424086";
      Submission submission = Submission.newBuilder().build();
      client.createSubmission(parent, submission);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
