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

package com.google.cloud.webrisk.v1beta1;

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
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.SearchHashesRequest;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.SearchUrisRequest;
import com.google.webrisk.v1beta1.SearchUrisResponse;
import com.google.webrisk.v1beta1.ThreatEntryAdditions;
import com.google.webrisk.v1beta1.ThreatEntryRemovals;
import com.google.webrisk.v1beta1.ThreatType;
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
public class WebRiskServiceV1Beta1ClientTest {
  private static MockServiceHelper mockServiceHelper;
  private WebRiskServiceV1Beta1Client client;
  private static MockWebRiskServiceV1Beta1 mockWebRiskServiceV1Beta1;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWebRiskServiceV1Beta1 = new MockWebRiskServiceV1Beta1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWebRiskServiceV1Beta1));
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
    WebRiskServiceV1Beta1Settings settings =
        WebRiskServiceV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WebRiskServiceV1Beta1Client.create(settings);
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
            .setChecksum(ComputeThreatListDiffResponse.Checksum.newBuilder().build())
            .setRecommendedNextDiff(Timestamp.newBuilder().build())
            .build();
    mockWebRiskServiceV1Beta1.addResponse(expectedResponse);

    ThreatType threatType = ThreatType.forNumber(0);
    ByteString versionToken = ByteString.EMPTY;
    ComputeThreatListDiffRequest.Constraints constraints =
        ComputeThreatListDiffRequest.Constraints.newBuilder().build();

    ComputeThreatListDiffResponse actualResponse =
        client.computeThreatListDiff(threatType, versionToken, constraints);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskServiceV1Beta1.getRequests();
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
    mockWebRiskServiceV1Beta1.addException(exception);

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
    mockWebRiskServiceV1Beta1.addResponse(expectedResponse);

    String uri = "uri116076";
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchUrisResponse actualResponse = client.searchUris(uri, threatTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskServiceV1Beta1.getRequests();
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
    mockWebRiskServiceV1Beta1.addException(exception);

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
    mockWebRiskServiceV1Beta1.addResponse(expectedResponse);

    ByteString hashPrefix = ByteString.EMPTY;
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchHashesResponse actualResponse = client.searchHashes(hashPrefix, threatTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskServiceV1Beta1.getRequests();
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
    mockWebRiskServiceV1Beta1.addException(exception);

    try {
      ByteString hashPrefix = ByteString.EMPTY;
      List<ThreatType> threatTypes = new ArrayList<>();
      client.searchHashes(hashPrefix, threatTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
