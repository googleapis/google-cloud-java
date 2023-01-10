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

package com.google.cloud.functions.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.functions.v2.FunctionServiceGrpc.FunctionServiceImplBase;
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
public class MockFunctionServiceImpl extends FunctionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFunctionServiceImpl() {
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
  public void getFunction(GetFunctionRequest request, StreamObserver<Function> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Function) {
      requests.add(request);
      responseObserver.onNext(((Function) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFunction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Function.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFunctions(
      ListFunctionsRequest request, StreamObserver<ListFunctionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFunctionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFunctionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFunctions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFunctionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFunction(
      CreateFunctionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFunction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFunction(
      UpdateFunctionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFunction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFunction(
      DeleteFunctionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFunction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateUploadUrl(
      GenerateUploadUrlRequest request,
      StreamObserver<GenerateUploadUrlResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateUploadUrlResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateUploadUrlResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateUploadUrl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateUploadUrlResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateDownloadUrl(
      GenerateDownloadUrlRequest request,
      StreamObserver<GenerateDownloadUrlResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateDownloadUrlResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateDownloadUrlResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateDownloadUrl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateDownloadUrlResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRuntimes(
      ListRuntimesRequest request, StreamObserver<ListRuntimesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRuntimesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRuntimesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRuntimes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRuntimesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
