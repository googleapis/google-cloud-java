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

package com.google.cloud.monitoring.v3;

import com.google.api.core.BetaApi;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.SnoozeServiceGrpc.SnoozeServiceImplBase;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSnoozeServiceImpl extends SnoozeServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSnoozeServiceImpl() {
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
  public void createSnooze(CreateSnoozeRequest request, StreamObserver<Snooze> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Snooze) {
      requests.add(request);
      responseObserver.onNext(((Snooze) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSnooze, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Snooze.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSnoozes(
      ListSnoozesRequest request, StreamObserver<ListSnoozesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSnoozesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSnoozesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSnoozes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSnoozesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSnooze(GetSnoozeRequest request, StreamObserver<Snooze> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Snooze) {
      requests.add(request);
      responseObserver.onNext(((Snooze) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSnooze, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Snooze.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSnooze(UpdateSnoozeRequest request, StreamObserver<Snooze> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Snooze) {
      requests.add(request);
      responseObserver.onNext(((Snooze) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSnooze, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Snooze.class.getName(),
                  Exception.class.getName())));
    }
  }
}
