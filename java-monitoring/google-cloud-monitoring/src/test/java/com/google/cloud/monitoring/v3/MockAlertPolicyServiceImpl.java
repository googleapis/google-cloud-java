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

package com.google.cloud.monitoring.v3;

import com.google.api.core.BetaApi;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.AlertPolicyServiceGrpc.AlertPolicyServiceImplBase;
import com.google.monitoring.v3.CreateAlertPolicyRequest;
import com.google.monitoring.v3.DeleteAlertPolicyRequest;
import com.google.monitoring.v3.GetAlertPolicyRequest;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.ListAlertPoliciesResponse;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
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
public class MockAlertPolicyServiceImpl extends AlertPolicyServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAlertPolicyServiceImpl() {
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
  public void listAlertPolicies(
      ListAlertPoliciesRequest request,
      StreamObserver<ListAlertPoliciesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAlertPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAlertPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getAlertPolicy(
      GetAlertPolicyRequest request, StreamObserver<AlertPolicy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AlertPolicy) {
      requests.add(request);
      responseObserver.onNext(((AlertPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createAlertPolicy(
      CreateAlertPolicyRequest request, StreamObserver<AlertPolicy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AlertPolicy) {
      requests.add(request);
      responseObserver.onNext(((AlertPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteAlertPolicy(
      DeleteAlertPolicyRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateAlertPolicy(
      UpdateAlertPolicyRequest request, StreamObserver<AlertPolicy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AlertPolicy) {
      requests.add(request);
      responseObserver.onNext(((AlertPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
