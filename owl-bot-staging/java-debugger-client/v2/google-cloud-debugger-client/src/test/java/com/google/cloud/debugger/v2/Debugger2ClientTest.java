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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.devtools.clouddebugger.v2.Breakpoint;
import com.google.devtools.clouddebugger.v2.Debuggee;
import com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesRequest;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class Debugger2ClientTest {
  private static MockDebugger2 mockDebugger2;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private Debugger2Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockDebugger2 = new MockDebugger2();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDebugger2));
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
    Debugger2Settings settings =
        Debugger2Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = Debugger2Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void setBreakpointTest() throws Exception {
    SetBreakpointResponse expectedResponse =
        SetBreakpointResponse.newBuilder().setBreakpoint(Breakpoint.newBuilder().build()).build();
    mockDebugger2.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-1833285553";
    Breakpoint breakpoint = Breakpoint.newBuilder().build();
    String clientVersion = "clientVersion771880589";

    SetBreakpointResponse actualResponse =
        client.setBreakpoint(debuggeeId, breakpoint, clientVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDebugger2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetBreakpointRequest actualRequest = ((SetBreakpointRequest) actualRequests.get(0));

    Assert.assertEquals(debuggeeId, actualRequest.getDebuggeeId());
    Assert.assertEquals(breakpoint, actualRequest.getBreakpoint());
    Assert.assertEquals(clientVersion, actualRequest.getClientVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setBreakpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDebugger2.addException(exception);

    try {
      String debuggeeId = "debuggeeId-1833285553";
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
    mockDebugger2.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-1833285553";
    String breakpointId = "breakpointId570266860";
    String clientVersion = "clientVersion771880589";

    GetBreakpointResponse actualResponse =
        client.getBreakpoint(debuggeeId, breakpointId, clientVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDebugger2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBreakpointRequest actualRequest = ((GetBreakpointRequest) actualRequests.get(0));

    Assert.assertEquals(debuggeeId, actualRequest.getDebuggeeId());
    Assert.assertEquals(breakpointId, actualRequest.getBreakpointId());
    Assert.assertEquals(clientVersion, actualRequest.getClientVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBreakpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDebugger2.addException(exception);

    try {
      String debuggeeId = "debuggeeId-1833285553";
      String breakpointId = "breakpointId570266860";
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
    mockDebugger2.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-1833285553";
    String breakpointId = "breakpointId570266860";
    String clientVersion = "clientVersion771880589";

    client.deleteBreakpoint(debuggeeId, breakpointId, clientVersion);

    List<AbstractMessage> actualRequests = mockDebugger2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBreakpointRequest actualRequest = ((DeleteBreakpointRequest) actualRequests.get(0));

    Assert.assertEquals(debuggeeId, actualRequest.getDebuggeeId());
    Assert.assertEquals(breakpointId, actualRequest.getBreakpointId());
    Assert.assertEquals(clientVersion, actualRequest.getClientVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBreakpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDebugger2.addException(exception);

    try {
      String debuggeeId = "debuggeeId-1833285553";
      String breakpointId = "breakpointId570266860";
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
    mockDebugger2.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-1833285553";
    String clientVersion = "clientVersion771880589";

    ListBreakpointsResponse actualResponse = client.listBreakpoints(debuggeeId, clientVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDebugger2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBreakpointsRequest actualRequest = ((ListBreakpointsRequest) actualRequests.get(0));

    Assert.assertEquals(debuggeeId, actualRequest.getDebuggeeId());
    Assert.assertEquals(clientVersion, actualRequest.getClientVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBreakpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDebugger2.addException(exception);

    try {
      String debuggeeId = "debuggeeId-1833285553";
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
    mockDebugger2.addResponse(expectedResponse);

    String project = "project-309310695";
    String clientVersion = "clientVersion771880589";

    ListDebuggeesResponse actualResponse = client.listDebuggees(project, clientVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDebugger2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDebuggeesRequest actualRequest = ((ListDebuggeesRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertEquals(clientVersion, actualRequest.getClientVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDebuggeesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDebugger2.addException(exception);

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
