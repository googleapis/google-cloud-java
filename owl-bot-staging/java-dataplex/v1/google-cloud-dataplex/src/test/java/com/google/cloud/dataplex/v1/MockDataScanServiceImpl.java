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

package com.google.cloud.dataplex.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataplex.v1.DataScanServiceGrpc.DataScanServiceImplBase;
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
public class MockDataScanServiceImpl extends DataScanServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataScanServiceImpl() {
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
  public void createDataScan(
      CreateDataScanRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDataScan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataScan(
      UpdateDataScanRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDataScan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataScan(
      DeleteDataScanRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataScan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataScan(GetDataScanRequest request, StreamObserver<DataScan> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataScan) {
      requests.add(request);
      responseObserver.onNext(((DataScan) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataScan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataScan.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataScans(
      ListDataScansRequest request, StreamObserver<ListDataScansResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataScansResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataScansResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataScans, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataScansResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runDataScan(
      RunDataScanRequest request, StreamObserver<RunDataScanResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunDataScanResponse) {
      requests.add(request);
      responseObserver.onNext(((RunDataScanResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunDataScan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunDataScanResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataScanJob(
      GetDataScanJobRequest request, StreamObserver<DataScanJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataScanJob) {
      requests.add(request);
      responseObserver.onNext(((DataScanJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataScanJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataScanJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataScanJobs(
      ListDataScanJobsRequest request, StreamObserver<ListDataScanJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataScanJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataScanJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataScanJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataScanJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
