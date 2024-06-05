/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.privilegedaccessmanager.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerGrpc.PrivilegedAccessManagerImplBase;
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
public class MockPrivilegedAccessManagerImpl extends PrivilegedAccessManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPrivilegedAccessManagerImpl() {
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
  public void checkOnboardingStatus(
      CheckOnboardingStatusRequest request,
      StreamObserver<CheckOnboardingStatusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CheckOnboardingStatusResponse) {
      requests.add(request);
      responseObserver.onNext(((CheckOnboardingStatusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CheckOnboardingStatus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CheckOnboardingStatusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntitlements(
      ListEntitlementsRequest request, StreamObserver<ListEntitlementsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntitlementsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntitlementsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntitlements, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntitlementsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchEntitlements(
      SearchEntitlementsRequest request,
      StreamObserver<SearchEntitlementsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchEntitlementsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchEntitlementsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchEntitlements, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchEntitlementsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntitlement(
      GetEntitlementRequest request, StreamObserver<Entitlement> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entitlement) {
      requests.add(request);
      responseObserver.onNext(((Entitlement) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entitlement.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEntitlement(
      CreateEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntitlement(
      DeleteEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntitlement(
      UpdateEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGrants(
      ListGrantsRequest request, StreamObserver<ListGrantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGrantsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGrantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGrants, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGrantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchGrants(
      SearchGrantsRequest request, StreamObserver<SearchGrantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchGrantsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchGrantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchGrants, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchGrantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGrant(GetGrantRequest request, StreamObserver<Grant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Grant) {
      requests.add(request);
      responseObserver.onNext(((Grant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGrant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Grant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGrant(CreateGrantRequest request, StreamObserver<Grant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Grant) {
      requests.add(request);
      responseObserver.onNext(((Grant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGrant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Grant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveGrant(ApproveGrantRequest request, StreamObserver<Grant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Grant) {
      requests.add(request);
      responseObserver.onNext(((Grant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApproveGrant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Grant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void denyGrant(DenyGrantRequest request, StreamObserver<Grant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Grant) {
      requests.add(request);
      responseObserver.onNext(((Grant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DenyGrant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Grant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void revokeGrant(RevokeGrantRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RevokeGrant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
