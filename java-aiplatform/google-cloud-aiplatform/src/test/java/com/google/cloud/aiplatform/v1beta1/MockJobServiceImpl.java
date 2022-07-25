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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.JobServiceGrpc.JobServiceImplBase;
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
public class MockJobServiceImpl extends JobServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockJobServiceImpl() {
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
  public void createCustomJob(
      CreateCustomJobRequest request, StreamObserver<CustomJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomJob) {
      requests.add(request);
      responseObserver.onNext(((CustomJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomJob(
      GetCustomJobRequest request, StreamObserver<CustomJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomJob) {
      requests.add(request);
      responseObserver.onNext(((CustomJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomJobs(
      ListCustomJobsRequest request, StreamObserver<ListCustomJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomJob(
      DeleteCustomJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCustomJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelCustomJob(
      CancelCustomJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelCustomJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataLabelingJob(
      CreateDataLabelingJobRequest request, StreamObserver<DataLabelingJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataLabelingJob) {
      requests.add(request);
      responseObserver.onNext(((DataLabelingJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataLabelingJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataLabelingJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataLabelingJob(
      GetDataLabelingJobRequest request, StreamObserver<DataLabelingJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataLabelingJob) {
      requests.add(request);
      responseObserver.onNext(((DataLabelingJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataLabelingJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataLabelingJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataLabelingJobs(
      ListDataLabelingJobsRequest request,
      StreamObserver<ListDataLabelingJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataLabelingJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataLabelingJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataLabelingJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataLabelingJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataLabelingJob(
      DeleteDataLabelingJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataLabelingJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelDataLabelingJob(
      CancelDataLabelingJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelDataLabelingJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHyperparameterTuningJob(
      CreateHyperparameterTuningJobRequest request,
      StreamObserver<HyperparameterTuningJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HyperparameterTuningJob) {
      requests.add(request);
      responseObserver.onNext(((HyperparameterTuningJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateHyperparameterTuningJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HyperparameterTuningJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHyperparameterTuningJob(
      GetHyperparameterTuningJobRequest request,
      StreamObserver<HyperparameterTuningJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HyperparameterTuningJob) {
      requests.add(request);
      responseObserver.onNext(((HyperparameterTuningJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHyperparameterTuningJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HyperparameterTuningJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHyperparameterTuningJobs(
      ListHyperparameterTuningJobsRequest request,
      StreamObserver<ListHyperparameterTuningJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHyperparameterTuningJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHyperparameterTuningJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHyperparameterTuningJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHyperparameterTuningJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHyperparameterTuningJob(
      DeleteHyperparameterTuningJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHyperparameterTuningJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelHyperparameterTuningJob(
      CancelHyperparameterTuningJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelHyperparameterTuningJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBatchPredictionJob(
      CreateBatchPredictionJobRequest request,
      StreamObserver<BatchPredictionJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchPredictionJob) {
      requests.add(request);
      responseObserver.onNext(((BatchPredictionJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBatchPredictionJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchPredictionJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBatchPredictionJob(
      GetBatchPredictionJobRequest request, StreamObserver<BatchPredictionJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchPredictionJob) {
      requests.add(request);
      responseObserver.onNext(((BatchPredictionJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBatchPredictionJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchPredictionJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBatchPredictionJobs(
      ListBatchPredictionJobsRequest request,
      StreamObserver<ListBatchPredictionJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBatchPredictionJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBatchPredictionJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBatchPredictionJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBatchPredictionJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBatchPredictionJob(
      DeleteBatchPredictionJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteBatchPredictionJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelBatchPredictionJob(
      CancelBatchPredictionJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelBatchPredictionJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createModelDeploymentMonitoringJob(
      CreateModelDeploymentMonitoringJobRequest request,
      StreamObserver<ModelDeploymentMonitoringJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelDeploymentMonitoringJob) {
      requests.add(request);
      responseObserver.onNext(((ModelDeploymentMonitoringJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateModelDeploymentMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelDeploymentMonitoringJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchModelDeploymentMonitoringStatsAnomalies(
      SearchModelDeploymentMonitoringStatsAnomaliesRequest request,
      StreamObserver<SearchModelDeploymentMonitoringStatsAnomaliesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchModelDeploymentMonitoringStatsAnomaliesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchModelDeploymentMonitoringStatsAnomaliesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchModelDeploymentMonitoringStatsAnomalies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchModelDeploymentMonitoringStatsAnomaliesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModelDeploymentMonitoringJob(
      GetModelDeploymentMonitoringJobRequest request,
      StreamObserver<ModelDeploymentMonitoringJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelDeploymentMonitoringJob) {
      requests.add(request);
      responseObserver.onNext(((ModelDeploymentMonitoringJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModelDeploymentMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelDeploymentMonitoringJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelDeploymentMonitoringJobs(
      ListModelDeploymentMonitoringJobsRequest request,
      StreamObserver<ListModelDeploymentMonitoringJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelDeploymentMonitoringJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelDeploymentMonitoringJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModelDeploymentMonitoringJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelDeploymentMonitoringJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateModelDeploymentMonitoringJob(
      UpdateModelDeploymentMonitoringJobRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateModelDeploymentMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteModelDeploymentMonitoringJob(
      DeleteModelDeploymentMonitoringJobRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteModelDeploymentMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pauseModelDeploymentMonitoringJob(
      PauseModelDeploymentMonitoringJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method PauseModelDeploymentMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resumeModelDeploymentMonitoringJob(
      ResumeModelDeploymentMonitoringJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ResumeModelDeploymentMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
