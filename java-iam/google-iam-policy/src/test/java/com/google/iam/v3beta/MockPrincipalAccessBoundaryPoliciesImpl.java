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

package com.google.iam.v3beta;

import com.google.api.core.BetaApi;
import com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesGrpc.PrincipalAccessBoundaryPoliciesImplBase;
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
public class MockPrincipalAccessBoundaryPoliciesImpl
    extends PrincipalAccessBoundaryPoliciesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPrincipalAccessBoundaryPoliciesImpl() {
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
  public void createPrincipalAccessBoundaryPolicy(
      CreatePrincipalAccessBoundaryPolicyRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePrincipalAccessBoundaryPolicy,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrincipalAccessBoundaryPolicy(
      GetPrincipalAccessBoundaryPolicyRequest request,
      StreamObserver<PrincipalAccessBoundaryPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrincipalAccessBoundaryPolicy) {
      requests.add(request);
      responseObserver.onNext(((PrincipalAccessBoundaryPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrincipalAccessBoundaryPolicy,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrincipalAccessBoundaryPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePrincipalAccessBoundaryPolicy(
      UpdatePrincipalAccessBoundaryPolicyRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePrincipalAccessBoundaryPolicy,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrincipalAccessBoundaryPolicy(
      DeletePrincipalAccessBoundaryPolicyRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrincipalAccessBoundaryPolicy,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrincipalAccessBoundaryPolicies(
      ListPrincipalAccessBoundaryPoliciesRequest request,
      StreamObserver<ListPrincipalAccessBoundaryPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrincipalAccessBoundaryPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrincipalAccessBoundaryPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrincipalAccessBoundaryPolicies,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrincipalAccessBoundaryPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchPrincipalAccessBoundaryPolicyBindings(
      SearchPrincipalAccessBoundaryPolicyBindingsRequest request,
      StreamObserver<SearchPrincipalAccessBoundaryPolicyBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchPrincipalAccessBoundaryPolicyBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchPrincipalAccessBoundaryPolicyBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method"
                      + " SearchPrincipalAccessBoundaryPolicyBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchPrincipalAccessBoundaryPolicyBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
