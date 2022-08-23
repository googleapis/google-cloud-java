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

package com.google.cloud.gkehub.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceGrpc.GkeHubMembershipServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockGkeHubMembershipServiceImpl extends GkeHubMembershipServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGkeHubMembershipServiceImpl() {
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
  public void listMemberships(
      ListMembershipsRequest request, StreamObserver<ListMembershipsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMembershipsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMembershipsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMemberships, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMembershipsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMembership(
      GetMembershipRequest request, StreamObserver<Membership> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Membership) {
      requests.add(request);
      responseObserver.onNext(((Membership) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Membership.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMembership(
      CreateMembershipRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMembership(
      DeleteMembershipRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMembership(
      UpdateMembershipRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateConnectManifest(
      GenerateConnectManifestRequest request,
      StreamObserver<GenerateConnectManifestResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateConnectManifestResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateConnectManifestResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateConnectManifest, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateConnectManifestResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void validateExclusivity(
      ValidateExclusivityRequest request,
      StreamObserver<ValidateExclusivityResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ValidateExclusivityResponse) {
      requests.add(request);
      responseObserver.onNext(((ValidateExclusivityResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ValidateExclusivity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ValidateExclusivityResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateExclusivityManifest(
      GenerateExclusivityManifestRequest request,
      StreamObserver<GenerateExclusivityManifestResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateExclusivityManifestResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateExclusivityManifestResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateExclusivityManifest, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateExclusivityManifestResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
