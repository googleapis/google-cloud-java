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

package com.google.dataflow.v1beta3;

import com.google.api.core.BetaApi;
import com.google.dataflow.v1beta3.SnapshotsV1Beta3Grpc.SnapshotsV1Beta3ImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSnapshotsV1Beta3Impl extends SnapshotsV1Beta3ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSnapshotsV1Beta3Impl() {
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
  public void getSnapshot(GetSnapshotRequest request, StreamObserver<Snapshot> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Snapshot) {
      requests.add(request);
      responseObserver.onNext(((Snapshot) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Snapshot.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSnapshot(
      DeleteSnapshotRequest request, StreamObserver<DeleteSnapshotResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeleteSnapshotResponse) {
      requests.add(request);
      responseObserver.onNext(((DeleteSnapshotResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeleteSnapshotResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSnapshots(
      ListSnapshotsRequest request, StreamObserver<ListSnapshotsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSnapshotsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSnapshotsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSnapshots, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSnapshotsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
