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

package com.google.cloud.retail.v2beta;

import com.google.api.core.BetaApi;
import com.google.cloud.retail.v2beta.ServingConfigServiceGrpc.ServingConfigServiceImplBase;
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
public class MockServingConfigServiceImpl extends ServingConfigServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockServingConfigServiceImpl() {
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
  public void createServingConfig(
      CreateServingConfigRequest request, StreamObserver<ServingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServingConfig) {
      requests.add(request);
      responseObserver.onNext(((ServingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateServingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServingConfig(
      DeleteServingConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServingConfig(
      UpdateServingConfigRequest request, StreamObserver<ServingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServingConfig) {
      requests.add(request);
      responseObserver.onNext(((ServingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateServingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServingConfig(
      GetServingConfigRequest request, StreamObserver<ServingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServingConfig) {
      requests.add(request);
      responseObserver.onNext(((ServingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServingConfigs(
      ListServingConfigsRequest request,
      StreamObserver<ListServingConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServingConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServingConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServingConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServingConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addControl(
      AddControlRequest request, StreamObserver<ServingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServingConfig) {
      requests.add(request);
      responseObserver.onNext(((ServingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddControl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeControl(
      RemoveControlRequest request, StreamObserver<ServingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServingConfig) {
      requests.add(request);
      responseObserver.onNext(((ServingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveControl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
