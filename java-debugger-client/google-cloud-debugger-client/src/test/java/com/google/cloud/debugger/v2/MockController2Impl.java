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

import com.google.api.core.BetaApi;
import com.google.devtools.clouddebugger.v2.Controller2Grpc.Controller2ImplBase;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockController2Impl extends Controller2ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockController2Impl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void registerDebuggee(
      RegisterDebuggeeRequest request, StreamObserver<RegisterDebuggeeResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RegisterDebuggeeResponse) {
      requests.add(request);
      responseObserver.onNext(((RegisterDebuggeeResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RegisterDebuggee, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RegisterDebuggeeResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listActiveBreakpoints(
      ListActiveBreakpointsRequest request,
      StreamObserver<ListActiveBreakpointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListActiveBreakpointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListActiveBreakpointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListActiveBreakpoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListActiveBreakpointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateActiveBreakpoint(
      UpdateActiveBreakpointRequest request,
      StreamObserver<UpdateActiveBreakpointResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UpdateActiveBreakpointResponse) {
      requests.add(request);
      responseObserver.onNext(((UpdateActiveBreakpointResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateActiveBreakpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UpdateActiveBreakpointResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
