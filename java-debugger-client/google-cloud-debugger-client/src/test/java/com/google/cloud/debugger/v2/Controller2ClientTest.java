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
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import com.google.protobuf.AbstractMessage;
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
public class Controller2ClientTest {
  private static MockController2 mockController2;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private Controller2Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockController2 = new MockController2();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockController2));
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
    Controller2Settings settings =
        Controller2Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = Controller2Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void registerDebuggeeTest() throws Exception {
    RegisterDebuggeeResponse expectedResponse =
        RegisterDebuggeeResponse.newBuilder().setDebuggee(Debuggee.newBuilder().build()).build();
    mockController2.addResponse(expectedResponse);

    Debuggee debuggee = Debuggee.newBuilder().build();

    RegisterDebuggeeResponse actualResponse = client.registerDebuggee(debuggee);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockController2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterDebuggeeRequest actualRequest = ((RegisterDebuggeeRequest) actualRequests.get(0));

    Assert.assertEquals(debuggee, actualRequest.getDebuggee());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerDebuggeeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockController2.addException(exception);

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
    mockController2.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-1833285553";

    ListActiveBreakpointsResponse actualResponse = client.listActiveBreakpoints(debuggeeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockController2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListActiveBreakpointsRequest actualRequest =
        ((ListActiveBreakpointsRequest) actualRequests.get(0));

    Assert.assertEquals(debuggeeId, actualRequest.getDebuggeeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listActiveBreakpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockController2.addException(exception);

    try {
      String debuggeeId = "debuggeeId-1833285553";
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
    mockController2.addResponse(expectedResponse);

    String debuggeeId = "debuggeeId-1833285553";
    Breakpoint breakpoint = Breakpoint.newBuilder().build();

    UpdateActiveBreakpointResponse actualResponse =
        client.updateActiveBreakpoint(debuggeeId, breakpoint);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockController2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateActiveBreakpointRequest actualRequest =
        ((UpdateActiveBreakpointRequest) actualRequests.get(0));

    Assert.assertEquals(debuggeeId, actualRequest.getDebuggeeId());
    Assert.assertEquals(breakpoint, actualRequest.getBreakpoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateActiveBreakpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockController2.addException(exception);

    try {
      String debuggeeId = "debuggeeId-1833285553";
      Breakpoint breakpoint = Breakpoint.newBuilder().build();
      client.updateActiveBreakpoint(debuggeeId, breakpoint);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
