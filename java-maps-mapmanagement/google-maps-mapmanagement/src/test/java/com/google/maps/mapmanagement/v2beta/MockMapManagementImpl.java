/*
 * Copyright 2026 Google LLC
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

package com.google.maps.mapmanagement.v2beta;

import com.google.api.core.BetaApi;
import com.google.maps.mapmanagement.v2beta.MapManagementGrpc.MapManagementImplBase;
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
public class MockMapManagementImpl extends MapManagementImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMapManagementImpl() {
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
  public void createMapConfig(
      CreateMapConfigRequest request, StreamObserver<MapConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MapConfig) {
      requests.add(request);
      responseObserver.onNext(((MapConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMapConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MapConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMapConfig(
      GetMapConfigRequest request, StreamObserver<MapConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MapConfig) {
      requests.add(request);
      responseObserver.onNext(((MapConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMapConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MapConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMapConfigs(
      ListMapConfigsRequest request, StreamObserver<ListMapConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMapConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMapConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMapConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMapConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMapConfig(
      UpdateMapConfigRequest request, StreamObserver<MapConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MapConfig) {
      requests.add(request);
      responseObserver.onNext(((MapConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMapConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MapConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMapConfig(
      DeleteMapConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMapConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createStyleConfig(
      CreateStyleConfigRequest request, StreamObserver<StyleConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StyleConfig) {
      requests.add(request);
      responseObserver.onNext(((StyleConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateStyleConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StyleConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStyleConfig(
      GetStyleConfigRequest request, StreamObserver<StyleConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StyleConfig) {
      requests.add(request);
      responseObserver.onNext(((StyleConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStyleConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StyleConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listStyleConfigs(
      ListStyleConfigsRequest request, StreamObserver<ListStyleConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListStyleConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListStyleConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListStyleConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListStyleConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateStyleConfig(
      UpdateStyleConfigRequest request, StreamObserver<StyleConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StyleConfig) {
      requests.add(request);
      responseObserver.onNext(((StyleConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateStyleConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StyleConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteStyleConfig(
      DeleteStyleConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteStyleConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMapContextConfig(
      CreateMapContextConfigRequest request, StreamObserver<MapContextConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MapContextConfig) {
      requests.add(request);
      responseObserver.onNext(((MapContextConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMapContextConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  MapContextConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMapContextConfig(
      GetMapContextConfigRequest request, StreamObserver<MapContextConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MapContextConfig) {
      requests.add(request);
      responseObserver.onNext(((MapContextConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMapContextConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MapContextConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMapContextConfigs(
      ListMapContextConfigsRequest request,
      StreamObserver<ListMapContextConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMapContextConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMapContextConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMapContextConfigs, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMapContextConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMapContextConfig(
      UpdateMapContextConfigRequest request, StreamObserver<MapContextConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MapContextConfig) {
      requests.add(request);
      responseObserver.onNext(((MapContextConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMapContextConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  MapContextConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMapContextConfig(
      DeleteMapContextConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMapContextConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
