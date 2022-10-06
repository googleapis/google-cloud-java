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

package com.google.protos.google.cloud.binaryauthorization.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Grpc.BinauthzManagementServiceV1ImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockBinauthzManagementServiceV1Impl extends BinauthzManagementServiceV1ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBinauthzManagementServiceV1Impl() {
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
  public void getPolicy(
      Service.GetPolicyRequest request, StreamObserver<Resources.Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Resources.Policy) {
      requests.add(request);
      responseObserver.onNext(((Resources.Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Resources.Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePolicy(
      Service.UpdatePolicyRequest request, StreamObserver<Resources.Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Resources.Policy) {
      requests.add(request);
      responseObserver.onNext(((Resources.Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Resources.Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAttestor(
      Service.CreateAttestorRequest request, StreamObserver<Resources.Attestor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Resources.Attestor) {
      requests.add(request);
      responseObserver.onNext(((Resources.Attestor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAttestor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Resources.Attestor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttestor(
      Service.GetAttestorRequest request, StreamObserver<Resources.Attestor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Resources.Attestor) {
      requests.add(request);
      responseObserver.onNext(((Resources.Attestor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttestor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Resources.Attestor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAttestor(
      Service.UpdateAttestorRequest request, StreamObserver<Resources.Attestor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Resources.Attestor) {
      requests.add(request);
      responseObserver.onNext(((Resources.Attestor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAttestor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Resources.Attestor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAttestors(
      Service.ListAttestorsRequest request,
      StreamObserver<Service.ListAttestorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Service.ListAttestorsResponse) {
      requests.add(request);
      responseObserver.onNext(((Service.ListAttestorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAttestors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Service.ListAttestorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAttestor(
      Service.DeleteAttestorRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAttestor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
