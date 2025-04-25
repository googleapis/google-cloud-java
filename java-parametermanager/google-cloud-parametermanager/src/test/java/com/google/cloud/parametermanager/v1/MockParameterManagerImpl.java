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

package com.google.cloud.parametermanager.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.parametermanager.v1.ParameterManagerGrpc.ParameterManagerImplBase;
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
public class MockParameterManagerImpl extends ParameterManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockParameterManagerImpl() {
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
  public void listParameters(
      ListParametersRequest request, StreamObserver<ListParametersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListParametersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListParametersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListParameters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListParametersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getParameter(
      GetParameterRequest request, StreamObserver<Parameter> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Parameter) {
      requests.add(request);
      responseObserver.onNext(((Parameter) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetParameter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Parameter.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createParameter(
      CreateParameterRequest request, StreamObserver<Parameter> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Parameter) {
      requests.add(request);
      responseObserver.onNext(((Parameter) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateParameter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Parameter.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateParameter(
      UpdateParameterRequest request, StreamObserver<Parameter> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Parameter) {
      requests.add(request);
      responseObserver.onNext(((Parameter) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateParameter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Parameter.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteParameter(
      DeleteParameterRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteParameter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listParameterVersions(
      ListParameterVersionsRequest request,
      StreamObserver<ListParameterVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListParameterVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListParameterVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListParameterVersions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListParameterVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getParameterVersion(
      GetParameterVersionRequest request, StreamObserver<ParameterVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ParameterVersion) {
      requests.add(request);
      responseObserver.onNext(((ParameterVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetParameterVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ParameterVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renderParameterVersion(
      RenderParameterVersionRequest request,
      StreamObserver<RenderParameterVersionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RenderParameterVersionResponse) {
      requests.add(request);
      responseObserver.onNext(((RenderParameterVersionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenderParameterVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RenderParameterVersionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createParameterVersion(
      CreateParameterVersionRequest request, StreamObserver<ParameterVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ParameterVersion) {
      requests.add(request);
      responseObserver.onNext(((ParameterVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateParameterVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ParameterVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateParameterVersion(
      UpdateParameterVersionRequest request, StreamObserver<ParameterVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ParameterVersion) {
      requests.add(request);
      responseObserver.onNext(((ParameterVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateParameterVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ParameterVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteParameterVersion(
      DeleteParameterVersionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteParameterVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
