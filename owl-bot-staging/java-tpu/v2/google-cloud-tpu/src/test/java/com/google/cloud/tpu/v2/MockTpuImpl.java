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

package com.google.cloud.tpu.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.tpu.v2.TpuGrpc.TpuImplBase;
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
public class MockTpuImpl extends TpuImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTpuImpl() {
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
  public void listNodes(
      ListNodesRequest request, StreamObserver<ListNodesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNodesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNodesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNodes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNodesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNode(GetNodeRequest request, StreamObserver<Node> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Node) {
      requests.add(request);
      responseObserver.onNext(((Node) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Node.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNode(CreateNodeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNode(DeleteNodeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopNode(StopNodeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StopNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startNode(StartNodeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNode(UpdateNodeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateServiceIdentity(
      GenerateServiceIdentityRequest request,
      StreamObserver<GenerateServiceIdentityResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateServiceIdentityResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateServiceIdentityResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateServiceIdentity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateServiceIdentityResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAcceleratorTypes(
      ListAcceleratorTypesRequest request,
      StreamObserver<ListAcceleratorTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAcceleratorTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAcceleratorTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAcceleratorTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAcceleratorTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAcceleratorType(
      GetAcceleratorTypeRequest request, StreamObserver<AcceleratorType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AcceleratorType) {
      requests.add(request);
      responseObserver.onNext(((AcceleratorType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAcceleratorType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AcceleratorType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRuntimeVersions(
      ListRuntimeVersionsRequest request,
      StreamObserver<ListRuntimeVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRuntimeVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRuntimeVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRuntimeVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRuntimeVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRuntimeVersion(
      GetRuntimeVersionRequest request, StreamObserver<RuntimeVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RuntimeVersion) {
      requests.add(request);
      responseObserver.onNext(((RuntimeVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRuntimeVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RuntimeVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGuestAttributes(
      GetGuestAttributesRequest request,
      StreamObserver<GetGuestAttributesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GetGuestAttributesResponse) {
      requests.add(request);
      responseObserver.onNext(((GetGuestAttributesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGuestAttributes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GetGuestAttributesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
