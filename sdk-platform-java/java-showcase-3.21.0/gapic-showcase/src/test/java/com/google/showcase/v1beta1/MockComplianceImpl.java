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

package com.google.showcase.v1beta1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.showcase.v1beta1.ComplianceGrpc.ComplianceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockComplianceImpl extends ComplianceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockComplianceImpl() {
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
  public void repeatDataBody(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataBody, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataBodyInfo(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataBodyInfo, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataQuery(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataSimplePath(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataSimplePath, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataPathResource(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataPathResource, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataPathTrailingResource(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataPathTrailingResource,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataBodyPut(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataBodyPut, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repeatDataBodyPatch(
      RepeatRequest request, StreamObserver<RepeatResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RepeatResponse) {
      requests.add(request);
      responseObserver.onNext(((RepeatResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RepeatDataBodyPatch, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RepeatResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEnum(EnumRequest request, StreamObserver<EnumResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EnumResponse) {
      requests.add(request);
      responseObserver.onNext(((EnumResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEnum, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EnumResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void verifyEnum(EnumResponse request, StreamObserver<EnumResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EnumResponse) {
      requests.add(request);
      responseObserver.onNext(((EnumResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method VerifyEnum, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EnumResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
