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

package com.google.cloud.debugger.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.debugger.v2.stub.HttpJsonController2Stub;
import com.google.devtools.clouddebugger.v2.Breakpoint;
import com.google.devtools.clouddebugger.v2.Debuggee;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.SourceLocation;
import com.google.devtools.clouddebugger.v2.StackFrame;
import com.google.devtools.clouddebugger.v2.StatusMessage;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import com.google.devtools.clouddebugger.v2.Variable;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class Controller2ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static Controller2Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonController2Stub.getMethodDescriptors(),
            Controller2Settings.getDefaultEndpoint());
    Controller2Settings settings =
        Controller2Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                Controller2Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = Controller2Client.create(settings);
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
  public void registerDebuggeeTest() throws Exception {
    RegisterDebuggeeResponse expectedResponse =
        RegisterDebuggeeResponse.newBuilder().setDebuggee(Debuggee.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    Debuggee debuggee = Debuggee.newBuilder().build();

    RegisterDebuggeeResponse actualResponse = client.registerDebuggee(debuggee);
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
  public void registerDebuggeeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Debuggee debuggee = Debuggee.newBuilder().build();
      client.registerDebuggee(debuggee);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listActiveBreakpointsTest() throws Exception {
    ListActiveBreakpointsResponse expectedResponse =
        ListActiveBreakpointsResponse.newBuilder()
            .addAllBreakpoints(new ArrayList<Breakpoint>())
            .setNextWaitToken("nextWaitToken1051070417")
            .setWaitExpired(true)
            .build();
    mockService.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-7253";

    ListActiveBreakpointsResponse actualResponse = client.listActiveBreakpoints(debuggeeId);
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
  public void listActiveBreakpointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String debuggeeId = "debuggeeId-7253";
      client.listActiveBreakpoints(debuggeeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateActiveBreakpointTest() throws Exception {
    UpdateActiveBreakpointResponse expectedResponse =
        UpdateActiveBreakpointResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-7253";
    Breakpoint breakpoint =
        Breakpoint.newBuilder()
            .setId("id-4047")
            .setLocation(SourceLocation.newBuilder().build())
            .setCondition("condition-861311717")
            .addAllExpressions(new ArrayList<String>())
            .setLogMessageFormat("logMessageFormat-1136427526")
            .setIsFinalState(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setFinalTime(Timestamp.newBuilder().build())
            .setUserEmail("userEmail315299473")
            .setStatus(StatusMessage.newBuilder().build())
            .addAllStackFrames(new ArrayList<StackFrame>())
            .addAllEvaluatedExpressions(new ArrayList<Variable>())
            .addAllVariableTable(new ArrayList<Variable>())
            .putAllLabels(new HashMap<String, String>())
            .build();

    UpdateActiveBreakpointResponse actualResponse =
        client.updateActiveBreakpoint(debuggeeId, breakpoint);
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
  public void updateActiveBreakpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String debuggeeId = "debuggeeId-7253";
      Breakpoint breakpoint =
          Breakpoint.newBuilder()
              .setId("id-4047")
              .setLocation(SourceLocation.newBuilder().build())
              .setCondition("condition-861311717")
              .addAllExpressions(new ArrayList<String>())
              .setLogMessageFormat("logMessageFormat-1136427526")
              .setIsFinalState(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setFinalTime(Timestamp.newBuilder().build())
              .setUserEmail("userEmail315299473")
              .setStatus(StatusMessage.newBuilder().build())
              .addAllStackFrames(new ArrayList<StackFrame>())
              .addAllEvaluatedExpressions(new ArrayList<Variable>())
              .addAllVariableTable(new ArrayList<Variable>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.updateActiveBreakpoint(debuggeeId, breakpoint);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
