/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsGrpc.SaasRolloutsImplBase;
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
public class MockSaasRolloutsImpl extends SaasRolloutsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSaasRolloutsImpl() {
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
  public void listRollouts(
      ListRolloutsRequest request, StreamObserver<ListRolloutsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRolloutsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRolloutsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRollouts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRolloutsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRollout(GetRolloutRequest request, StreamObserver<Rollout> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rollout) {
      requests.add(request);
      responseObserver.onNext(((Rollout) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rollout.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRollout(
      CreateRolloutRequest request, StreamObserver<Rollout> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rollout) {
      requests.add(request);
      responseObserver.onNext(((Rollout) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rollout.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRollout(
      UpdateRolloutRequest request, StreamObserver<Rollout> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rollout) {
      requests.add(request);
      responseObserver.onNext(((Rollout) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rollout.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRollout(DeleteRolloutRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRolloutKinds(
      ListRolloutKindsRequest request, StreamObserver<ListRolloutKindsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRolloutKindsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRolloutKindsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRolloutKinds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRolloutKindsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRolloutKind(
      GetRolloutKindRequest request, StreamObserver<RolloutKind> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RolloutKind) {
      requests.add(request);
      responseObserver.onNext(((RolloutKind) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRolloutKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RolloutKind.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRolloutKind(
      CreateRolloutKindRequest request, StreamObserver<RolloutKind> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RolloutKind) {
      requests.add(request);
      responseObserver.onNext(((RolloutKind) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRolloutKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RolloutKind.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRolloutKind(
      UpdateRolloutKindRequest request, StreamObserver<RolloutKind> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RolloutKind) {
      requests.add(request);
      responseObserver.onNext(((RolloutKind) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRolloutKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RolloutKind.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRolloutKind(
      DeleteRolloutKindRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRolloutKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
