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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.cloudsecuritycompliance.v1.ConfigGrpc.ConfigImplBase;
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
public class MockConfigImpl extends ConfigImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConfigImpl() {
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
  public void listFrameworks(
      ListFrameworksRequest request, StreamObserver<ListFrameworksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFrameworksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFrameworksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFrameworks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFrameworksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFramework(
      GetFrameworkRequest request, StreamObserver<Framework> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Framework) {
      requests.add(request);
      responseObserver.onNext(((Framework) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFramework, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Framework.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFramework(
      CreateFrameworkRequest request, StreamObserver<Framework> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Framework) {
      requests.add(request);
      responseObserver.onNext(((Framework) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFramework, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Framework.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFramework(
      UpdateFrameworkRequest request, StreamObserver<Framework> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Framework) {
      requests.add(request);
      responseObserver.onNext(((Framework) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFramework, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Framework.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFramework(
      DeleteFrameworkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFramework, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCloudControls(
      ListCloudControlsRequest request,
      StreamObserver<ListCloudControlsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCloudControlsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCloudControlsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCloudControls, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCloudControlsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCloudControl(
      GetCloudControlRequest request, StreamObserver<CloudControl> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CloudControl) {
      requests.add(request);
      responseObserver.onNext(((CloudControl) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCloudControl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CloudControl.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCloudControl(
      CreateCloudControlRequest request, StreamObserver<CloudControl> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CloudControl) {
      requests.add(request);
      responseObserver.onNext(((CloudControl) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCloudControl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CloudControl.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCloudControl(
      UpdateCloudControlRequest request, StreamObserver<CloudControl> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CloudControl) {
      requests.add(request);
      responseObserver.onNext(((CloudControl) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCloudControl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CloudControl.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCloudControl(
      DeleteCloudControlRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCloudControl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
