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
import com.google.devtools.clouddebugger.v2.Debugger2Grpc.Debugger2ImplBase;
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
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDebugger2Impl extends Debugger2ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDebugger2Impl() {
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
  public void setBreakpoint(
      SetBreakpointRequest request, StreamObserver<SetBreakpointResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SetBreakpointResponse) {
      requests.add(request);
      responseObserver.onNext(((SetBreakpointResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetBreakpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SetBreakpointResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBreakpoint(
      GetBreakpointRequest request, StreamObserver<GetBreakpointResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GetBreakpointResponse) {
      requests.add(request);
      responseObserver.onNext(((GetBreakpointResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBreakpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GetBreakpointResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBreakpoint(
      DeleteBreakpointRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBreakpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBreakpoints(
      ListBreakpointsRequest request, StreamObserver<ListBreakpointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBreakpointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBreakpointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBreakpoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBreakpointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDebuggees(
      ListDebuggeesRequest request, StreamObserver<ListDebuggeesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDebuggeesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDebuggeesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDebuggees, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDebuggeesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
