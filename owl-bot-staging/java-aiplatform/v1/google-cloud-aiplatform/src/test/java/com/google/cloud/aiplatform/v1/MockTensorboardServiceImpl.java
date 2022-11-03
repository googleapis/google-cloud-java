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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.TensorboardServiceGrpc.TensorboardServiceImplBase;
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
public class MockTensorboardServiceImpl extends TensorboardServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTensorboardServiceImpl() {
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
  public void createTensorboard(
      CreateTensorboardRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTensorboard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTensorboard(
      GetTensorboardRequest request, StreamObserver<Tensorboard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tensorboard) {
      requests.add(request);
      responseObserver.onNext(((Tensorboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTensorboard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tensorboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTensorboard(
      UpdateTensorboardRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTensorboard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTensorboards(
      ListTensorboardsRequest request, StreamObserver<ListTensorboardsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTensorboardsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTensorboardsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTensorboards, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTensorboardsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTensorboard(
      DeleteTensorboardRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTensorboard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTensorboardExperiment(
      CreateTensorboardExperimentRequest request,
      StreamObserver<TensorboardExperiment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardExperiment) {
      requests.add(request);
      responseObserver.onNext(((TensorboardExperiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTensorboardExperiment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardExperiment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTensorboardExperiment(
      GetTensorboardExperimentRequest request,
      StreamObserver<TensorboardExperiment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardExperiment) {
      requests.add(request);
      responseObserver.onNext(((TensorboardExperiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTensorboardExperiment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardExperiment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTensorboardExperiment(
      UpdateTensorboardExperimentRequest request,
      StreamObserver<TensorboardExperiment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardExperiment) {
      requests.add(request);
      responseObserver.onNext(((TensorboardExperiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTensorboardExperiment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardExperiment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTensorboardExperiments(
      ListTensorboardExperimentsRequest request,
      StreamObserver<ListTensorboardExperimentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTensorboardExperimentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTensorboardExperimentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTensorboardExperiments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTensorboardExperimentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTensorboardExperiment(
      DeleteTensorboardExperimentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTensorboardExperiment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTensorboardRun(
      CreateTensorboardRunRequest request, StreamObserver<TensorboardRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardRun) {
      requests.add(request);
      responseObserver.onNext(((TensorboardRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTensorboardRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateTensorboardRuns(
      BatchCreateTensorboardRunsRequest request,
      StreamObserver<BatchCreateTensorboardRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateTensorboardRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateTensorboardRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateTensorboardRuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateTensorboardRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTensorboardRun(
      GetTensorboardRunRequest request, StreamObserver<TensorboardRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardRun) {
      requests.add(request);
      responseObserver.onNext(((TensorboardRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTensorboardRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTensorboardRun(
      UpdateTensorboardRunRequest request, StreamObserver<TensorboardRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardRun) {
      requests.add(request);
      responseObserver.onNext(((TensorboardRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTensorboardRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTensorboardRuns(
      ListTensorboardRunsRequest request,
      StreamObserver<ListTensorboardRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTensorboardRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTensorboardRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTensorboardRuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTensorboardRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTensorboardRun(
      DeleteTensorboardRunRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTensorboardRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateTensorboardTimeSeries(
      BatchCreateTensorboardTimeSeriesRequest request,
      StreamObserver<BatchCreateTensorboardTimeSeriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateTensorboardTimeSeriesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateTensorboardTimeSeriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateTensorboardTimeSeries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateTensorboardTimeSeriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTensorboardTimeSeries(
      CreateTensorboardTimeSeriesRequest request,
      StreamObserver<TensorboardTimeSeries> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardTimeSeries) {
      requests.add(request);
      responseObserver.onNext(((TensorboardTimeSeries) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTensorboardTimeSeries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardTimeSeries.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTensorboardTimeSeries(
      GetTensorboardTimeSeriesRequest request,
      StreamObserver<TensorboardTimeSeries> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardTimeSeries) {
      requests.add(request);
      responseObserver.onNext(((TensorboardTimeSeries) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTensorboardTimeSeries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardTimeSeries.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTensorboardTimeSeries(
      UpdateTensorboardTimeSeriesRequest request,
      StreamObserver<TensorboardTimeSeries> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TensorboardTimeSeries) {
      requests.add(request);
      responseObserver.onNext(((TensorboardTimeSeries) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTensorboardTimeSeries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TensorboardTimeSeries.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTensorboardTimeSeries(
      ListTensorboardTimeSeriesRequest request,
      StreamObserver<ListTensorboardTimeSeriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTensorboardTimeSeriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTensorboardTimeSeriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTensorboardTimeSeries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTensorboardTimeSeriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTensorboardTimeSeries(
      DeleteTensorboardTimeSeriesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTensorboardTimeSeries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchReadTensorboardTimeSeriesData(
      BatchReadTensorboardTimeSeriesDataRequest request,
      StreamObserver<BatchReadTensorboardTimeSeriesDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchReadTensorboardTimeSeriesDataResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchReadTensorboardTimeSeriesDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchReadTensorboardTimeSeriesData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchReadTensorboardTimeSeriesDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void readTensorboardTimeSeriesData(
      ReadTensorboardTimeSeriesDataRequest request,
      StreamObserver<ReadTensorboardTimeSeriesDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReadTensorboardTimeSeriesDataResponse) {
      requests.add(request);
      responseObserver.onNext(((ReadTensorboardTimeSeriesDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReadTensorboardTimeSeriesData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReadTensorboardTimeSeriesDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void readTensorboardBlobData(
      ReadTensorboardBlobDataRequest request,
      StreamObserver<ReadTensorboardBlobDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReadTensorboardBlobDataResponse) {
      requests.add(request);
      responseObserver.onNext(((ReadTensorboardBlobDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReadTensorboardBlobData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReadTensorboardBlobDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void writeTensorboardExperimentData(
      WriteTensorboardExperimentDataRequest request,
      StreamObserver<WriteTensorboardExperimentDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WriteTensorboardExperimentDataResponse) {
      requests.add(request);
      responseObserver.onNext(((WriteTensorboardExperimentDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method WriteTensorboardExperimentData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WriteTensorboardExperimentDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void writeTensorboardRunData(
      WriteTensorboardRunDataRequest request,
      StreamObserver<WriteTensorboardRunDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WriteTensorboardRunDataResponse) {
      requests.add(request);
      responseObserver.onNext(((WriteTensorboardRunDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method WriteTensorboardRunData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WriteTensorboardRunDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportTensorboardTimeSeriesData(
      ExportTensorboardTimeSeriesDataRequest request,
      StreamObserver<ExportTensorboardTimeSeriesDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExportTensorboardTimeSeriesDataResponse) {
      requests.add(request);
      responseObserver.onNext(((ExportTensorboardTimeSeriesDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportTensorboardTimeSeriesData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExportTensorboardTimeSeriesDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
