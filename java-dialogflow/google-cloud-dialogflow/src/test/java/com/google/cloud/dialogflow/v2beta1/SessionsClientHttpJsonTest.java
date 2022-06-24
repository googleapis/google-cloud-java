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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2beta1.stub.HttpJsonSessionsStub;
import com.google.protobuf.ByteString;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SessionsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SessionsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSessionsStub.getMethodDescriptors(), SessionsSettings.getDefaultEndpoint());
    SessionsSettings settings =
        SessionsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SessionsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionsClient.create(settings);
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
  public void detectIntentTest() throws Exception {
    DetectIntentResponse expectedResponse =
        DetectIntentResponse.newBuilder()
            .setResponseId("responseId-633138884")
            .setQueryResult(QueryResult.newBuilder().build())
            .addAllAlternativeQueryResults(new ArrayList<QueryResult>())
            .setWebhookStatus(Status.newBuilder().build())
            .setOutputAudio(ByteString.EMPTY)
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SessionName session = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
    QueryInput queryInput = QueryInput.newBuilder().build();

    DetectIntentResponse actualResponse = client.detectIntent(session, queryInput);
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
  public void detectIntentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName session = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
      QueryInput queryInput = QueryInput.newBuilder().build();
      client.detectIntent(session, queryInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void detectIntentTest2() throws Exception {
    DetectIntentResponse expectedResponse =
        DetectIntentResponse.newBuilder()
            .setResponseId("responseId-633138884")
            .setQueryResult(QueryResult.newBuilder().build())
            .addAllAlternativeQueryResults(new ArrayList<QueryResult>())
            .setWebhookStatus(Status.newBuilder().build())
            .setOutputAudio(ByteString.EMPTY)
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String session = "projects/project-3462/agent/sessions/session-3462";
    QueryInput queryInput = QueryInput.newBuilder().build();

    DetectIntentResponse actualResponse = client.detectIntent(session, queryInput);
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
  public void detectIntentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String session = "projects/project-3462/agent/sessions/session-3462";
      QueryInput queryInput = QueryInput.newBuilder().build();
      client.detectIntent(session, queryInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingDetectIntentUnsupportedMethodTest() throws Exception {
    // The streamingDetectIntent() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }
}
