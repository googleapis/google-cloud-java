/*
 * Copyright 2019 Google LLC
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
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.SearchHashesRequest;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.SearchUrisRequest;
import com.google.webrisk.v1beta1.SearchUrisResponse;
import com.google.webrisk.v1beta1.ThreatType;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class WebRiskServiceV1Beta1ClientTest {
  private static MockWebRiskServiceV1Beta1 mockWebRiskServiceV1Beta1;
  private static MockServiceHelper serviceHelper;
  private WebRiskServiceV1Beta1Client client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWebRiskServiceV1Beta1 = new MockWebRiskServiceV1Beta1();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1", Arrays.<MockGrpcService>asList(mockWebRiskServiceV1Beta1));
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
  @SuppressWarnings("all")
  public void computeThreatListDiffTest() {
    ByteString newVersionToken = ByteString.copyFromUtf8("115");
    ComputeThreatListDiffResponse expectedResponse =
        ComputeThreatListDiffResponse.newBuilder().setNewVersionToken(newVersionToken).build();
    mockWebRiskServiceV1Beta1.addResponse(expectedResponse);

    ThreatType threatType = ThreatType.THREAT_TYPE_UNSPECIFIED;
    ByteString versionToken = ByteString.copyFromUtf8("-46");
    ComputeThreatListDiffRequest.Constraints constraints =
        ComputeThreatListDiffRequest.Constraints.newBuilder().build();

    ComputeThreatListDiffResponse actualResponse =
        client.computeThreatListDiff(threatType, versionToken, constraints);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeThreatListDiffRequest actualRequest =
        (ComputeThreatListDiffRequest) actualRequests.get(0);

    Assert.assertEquals(threatType, actualRequest.getThreatType());
    Assert.assertEquals(versionToken, actualRequest.getVersionToken());
    Assert.assertEquals(constraints, actualRequest.getConstraints());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void computeThreatListDiffExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebRiskServiceV1Beta1.addException(exception);

    try {
      ThreatType threatType = ThreatType.THREAT_TYPE_UNSPECIFIED;
      ByteString versionToken = ByteString.copyFromUtf8("-46");
      ComputeThreatListDiffRequest.Constraints constraints =
          ComputeThreatListDiffRequest.Constraints.newBuilder().build();

      client.computeThreatListDiff(threatType, versionToken, constraints);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchUrisTest() {
    SearchUrisResponse expectedResponse = SearchUrisResponse.newBuilder().build();
    mockWebRiskServiceV1Beta1.addResponse(expectedResponse);

    String uri = "uri116076";
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchUrisResponse actualResponse = client.searchUris(uri, threatTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchUrisRequest actualRequest = (SearchUrisRequest) actualRequests.get(0);

    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertEquals(threatTypes, actualRequest.getThreatTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchUrisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebRiskServiceV1Beta1.addException(exception);

    try {
      String uri = "uri116076";
      List<ThreatType> threatTypes = new ArrayList<>();

      client.searchUris(uri, threatTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchHashesTest() {
    SearchHashesResponse expectedResponse = SearchHashesResponse.newBuilder().build();
    mockWebRiskServiceV1Beta1.addResponse(expectedResponse);

    ByteString hashPrefix = ByteString.copyFromUtf8("-29");
    List<ThreatType> threatTypes = new ArrayList<>();

    SearchHashesResponse actualResponse = client.searchHashes(hashPrefix, threatTypes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebRiskServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchHashesRequest actualRequest = (SearchHashesRequest) actualRequests.get(0);

    Assert.assertEquals(hashPrefix, actualRequest.getHashPrefix());
    Assert.assertEquals(threatTypes, actualRequest.getThreatTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchHashesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebRiskServiceV1Beta1.addException(exception);

    try {
      ByteString hashPrefix = ByteString.copyFromUtf8("-29");
      List<ThreatType> threatTypes = new ArrayList<>();

      client.searchHashes(hashPrefix, threatTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
