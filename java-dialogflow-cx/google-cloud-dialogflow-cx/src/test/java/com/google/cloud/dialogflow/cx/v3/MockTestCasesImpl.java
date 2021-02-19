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

package com.google.cloud.dialogflow.cx.v3;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3.TestCasesGrpc.TestCasesImplBase;
import com.google.longrunning.Operation;
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
public class MockTestCasesImpl extends TestCasesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTestCasesImpl() {
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
  public void listTestCases(
      ListTestCasesRequest request, StreamObserver<ListTestCasesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTestCasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTestCasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTestCases, expected %s or %s",
                  response.getClass().getName(),
                  ListTestCasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteTestCases(
      BatchDeleteTestCasesRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method BatchDeleteTestCases, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTestCase(GetTestCaseRequest request, StreamObserver<TestCase> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TestCase) {
      requests.add(request);
      responseObserver.onNext(((TestCase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTestCase, expected %s or %s",
                  response.getClass().getName(),
                  TestCase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTestCase(
      CreateTestCaseRequest request, StreamObserver<TestCase> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TestCase) {
      requests.add(request);
      responseObserver.onNext(((TestCase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTestCase, expected %s or %s",
                  response.getClass().getName(),
                  TestCase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTestCase(
      UpdateTestCaseRequest request, StreamObserver<TestCase> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TestCase) {
      requests.add(request);
      responseObserver.onNext(((TestCase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTestCase, expected %s or %s",
                  response.getClass().getName(),
                  TestCase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runTestCase(RunTestCaseRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method RunTestCase, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchRunTestCases(
      BatchRunTestCasesRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method BatchRunTestCases, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void calculateCoverage(
      CalculateCoverageRequest request,
      StreamObserver<CalculateCoverageResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CalculateCoverageResponse) {
      requests.add(request);
      responseObserver.onNext(((CalculateCoverageResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CalculateCoverage, expected %s or %s",
                  response.getClass().getName(),
                  CalculateCoverageResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importTestCases(
      ImportTestCasesRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method ImportTestCases, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportTestCases(
      ExportTestCasesRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method ExportTestCases, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTestCaseResults(
      ListTestCaseResultsRequest request,
      StreamObserver<ListTestCaseResultsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTestCaseResultsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTestCaseResultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTestCaseResults, expected %s or %s",
                  response.getClass().getName(),
                  ListTestCaseResultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
