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

package com.google.cloud.cloudcontrolspartner.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreGrpc.CloudControlsPartnerCoreImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudControlsPartnerCoreImpl extends CloudControlsPartnerCoreImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudControlsPartnerCoreImpl() {
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
  public void getWorkload(GetWorkloadRequest request, StreamObserver<Workload> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workload) {
      requests.add(request);
      responseObserver.onNext(((Workload) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workload.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkloads(
      ListWorkloadsRequest request, StreamObserver<ListWorkloadsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkloadsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkloadsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkloads, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkloadsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomer(GetCustomerRequest request, StreamObserver<Customer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Customer) {
      requests.add(request);
      responseObserver.onNext(((Customer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Customer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomers(
      ListCustomersRequest request, StreamObserver<ListCustomersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEkmConnections(
      GetEkmConnectionsRequest request, StreamObserver<EkmConnections> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EkmConnections) {
      requests.add(request);
      responseObserver.onNext(((EkmConnections) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEkmConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EkmConnections.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPartnerPermissions(
      GetPartnerPermissionsRequest request, StreamObserver<PartnerPermissions> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PartnerPermissions) {
      requests.add(request);
      responseObserver.onNext(((PartnerPermissions) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPartnerPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PartnerPermissions.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccessApprovalRequests(
      ListAccessApprovalRequestsRequest request,
      StreamObserver<ListAccessApprovalRequestsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccessApprovalRequestsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccessApprovalRequestsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccessApprovalRequests, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccessApprovalRequestsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPartner(GetPartnerRequest request, StreamObserver<Partner> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Partner) {
      requests.add(request);
      responseObserver.onNext(((Partner) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPartner, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Partner.class.getName(),
                  Exception.class.getName())));
    }
  }
}
