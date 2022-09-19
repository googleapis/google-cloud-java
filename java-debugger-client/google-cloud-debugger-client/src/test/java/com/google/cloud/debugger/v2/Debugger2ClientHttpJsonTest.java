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
import com.google.cloud.debugger.v2.stub.HttpJsonDebugger2Stub;
import com.google.devtools.clouddebugger.v2.Breakpoint;
import com.google.devtools.clouddebugger.v2.Debuggee;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.protobuf.Empty;
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
public class Debugger2ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static Debugger2Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDebugger2Stub.getMethodDescriptors(), Debugger2Settings.getDefaultEndpoint());
    Debugger2Settings settings =
        Debugger2Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                Debugger2Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = Debugger2Client.create(settings);
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
  public void setBreakpointTest() throws Exception {
    SetBreakpointResponse expectedResponse =
        SetBreakpointResponse.newBuilder().setBreakpoint(Breakpoint.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-7253";
    Breakpoint breakpoint = Breakpoint.newBuilder().build();
    String clientVersion = "clientVersion771880589";

    SetBreakpointResponse actualResponse =
        client.setBreakpoint(debuggeeId, breakpoint, clientVersion);
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
  public void setBreakpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String debuggeeId = "debuggeeId-7253";
      Breakpoint breakpoint = Breakpoint.newBuilder().build();
      String clientVersion = "clientVersion771880589";
      client.setBreakpoint(debuggeeId, breakpoint, clientVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBreakpointTest() throws Exception {
    GetBreakpointResponse expectedResponse =
        GetBreakpointResponse.newBuilder().setBreakpoint(Breakpoint.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-7253";
    String breakpointId = "breakpointId-3518";
    String clientVersion = "clientVersion771880589";

    GetBreakpointResponse actualResponse =
        client.getBreakpoint(debuggeeId, breakpointId, clientVersion);
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
  public void getBreakpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String debuggeeId = "debuggeeId-7253";
      String breakpointId = "breakpointId-3518";
      String clientVersion = "clientVersion771880589";
      client.getBreakpoint(debuggeeId, breakpointId, clientVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBreakpointTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-7253";
    String breakpointId = "breakpointId-3518";
    String clientVersion = "clientVersion771880589";

    client.deleteBreakpoint(debuggeeId, breakpointId, clientVersion);

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
  public void deleteBreakpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String debuggeeId = "debuggeeId-7253";
      String breakpointId = "breakpointId-3518";
      String clientVersion = "clientVersion771880589";
      client.deleteBreakpoint(debuggeeId, breakpointId, clientVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBreakpointsTest() throws Exception {
    ListBreakpointsResponse expectedResponse =
        ListBreakpointsResponse.newBuilder()
            .addAllBreakpoints(new ArrayList<Breakpoint>())
            .setNextWaitToken("nextWaitToken1051070417")
            .build();
    mockService.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-7253";
    String clientVersion = "clientVersion771880589";

    ListBreakpointsResponse actualResponse = client.listBreakpoints(debuggeeId, clientVersion);
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
  public void listBreakpointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String debuggeeId = "debuggeeId-7253";
      String clientVersion = "clientVersion771880589";
      client.listBreakpoints(debuggeeId, clientVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDebuggeesTest() throws Exception {
    ListDebuggeesResponse expectedResponse =
        ListDebuggeesResponse.newBuilder().addAllDebuggees(new ArrayList<Debuggee>()).build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String clientVersion = "clientVersion771880589";

    ListDebuggeesResponse actualResponse = client.listDebuggees(project, clientVersion);
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
  public void listDebuggeesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String clientVersion = "clientVersion771880589";
      client.listDebuggees(project, clientVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
