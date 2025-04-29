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

package com.google.cloud.networkmanagement.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networkmanagement.v1.VpcFlowLogsServiceGrpc.VpcFlowLogsServiceImplBase;
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
public class MockVpcFlowLogsServiceImpl extends VpcFlowLogsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockVpcFlowLogsServiceImpl() {
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
  public void listVpcFlowLogsConfigs(
      ListVpcFlowLogsConfigsRequest request,
      StreamObserver<ListVpcFlowLogsConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVpcFlowLogsConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVpcFlowLogsConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVpcFlowLogsConfigs, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVpcFlowLogsConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVpcFlowLogsConfig(
      GetVpcFlowLogsConfigRequest request, StreamObserver<VpcFlowLogsConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VpcFlowLogsConfig) {
      requests.add(request);
      responseObserver.onNext(((VpcFlowLogsConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVpcFlowLogsConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  VpcFlowLogsConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createVpcFlowLogsConfig(
      CreateVpcFlowLogsConfigRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateVpcFlowLogsConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVpcFlowLogsConfig(
      UpdateVpcFlowLogsConfigRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateVpcFlowLogsConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteVpcFlowLogsConfig(
      DeleteVpcFlowLogsConfigRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteVpcFlowLogsConfig, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
