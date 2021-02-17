/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.accessapproval.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.accessapproval.v1.AccessApprovalGrpc.AccessApprovalImplBase;
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
public class MockAccessApprovalImpl extends AccessApprovalImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAccessApprovalImpl() {
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
  public void listApprovalRequests(
      ListApprovalRequestsMessage request,
      StreamObserver<ListApprovalRequestsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListApprovalRequestsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApprovalRequestsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApprovalRequests, expected %s or %s",
                  response.getClass().getName(),
                  ListApprovalRequestsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApprovalRequest(
      GetApprovalRequestMessage request, StreamObserver<ApprovalRequest> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ApprovalRequest) {
      requests.add(request);
      responseObserver.onNext(((ApprovalRequest) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApprovalRequest, expected %s or %s",
                  response.getClass().getName(),
                  ApprovalRequest.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveApprovalRequest(
      ApproveApprovalRequestMessage request, StreamObserver<ApprovalRequest> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ApprovalRequest) {
      requests.add(request);
      responseObserver.onNext(((ApprovalRequest) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApproveApprovalRequest, expected %s or %s",
                  response.getClass().getName(),
                  ApprovalRequest.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void dismissApprovalRequest(
      DismissApprovalRequestMessage request, StreamObserver<ApprovalRequest> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ApprovalRequest) {
      requests.add(request);
      responseObserver.onNext(((ApprovalRequest) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DismissApprovalRequest, expected %s or %s",
                  response.getClass().getName(),
                  ApprovalRequest.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAccessApprovalSettings(
      GetAccessApprovalSettingsMessage request,
      StreamObserver<AccessApprovalSettings> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AccessApprovalSettings) {
      requests.add(request);
      responseObserver.onNext(((AccessApprovalSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAccessApprovalSettings, expected %s or %s",
                  response.getClass().getName(),
                  AccessApprovalSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAccessApprovalSettings(
      UpdateAccessApprovalSettingsMessage request,
      StreamObserver<AccessApprovalSettings> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AccessApprovalSettings) {
      requests.add(request);
      responseObserver.onNext(((AccessApprovalSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAccessApprovalSettings, expected %s or %s",
                  response.getClass().getName(),
                  AccessApprovalSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAccessApprovalSettings(
      DeleteAccessApprovalSettingsMessage request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteAccessApprovalSettings, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
