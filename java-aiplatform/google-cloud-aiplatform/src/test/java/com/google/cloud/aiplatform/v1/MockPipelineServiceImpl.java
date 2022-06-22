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
import com.google.cloud.aiplatform.v1.PipelineServiceGrpc.PipelineServiceImplBase;
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
public class MockPipelineServiceImpl extends PipelineServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPipelineServiceImpl() {
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
  public void createTrainingPipeline(
      CreateTrainingPipelineRequest request, StreamObserver<TrainingPipeline> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TrainingPipeline) {
      requests.add(request);
      responseObserver.onNext(((TrainingPipeline) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTrainingPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TrainingPipeline.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTrainingPipeline(
      GetTrainingPipelineRequest request, StreamObserver<TrainingPipeline> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TrainingPipeline) {
      requests.add(request);
      responseObserver.onNext(((TrainingPipeline) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTrainingPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TrainingPipeline.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTrainingPipelines(
      ListTrainingPipelinesRequest request,
      StreamObserver<ListTrainingPipelinesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTrainingPipelinesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTrainingPipelinesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTrainingPipelines, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTrainingPipelinesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTrainingPipeline(
      DeleteTrainingPipelineRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTrainingPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelTrainingPipeline(
      CancelTrainingPipelineRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelTrainingPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPipelineJob(
      CreatePipelineJobRequest request, StreamObserver<PipelineJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PipelineJob) {
      requests.add(request);
      responseObserver.onNext(((PipelineJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePipelineJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PipelineJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPipelineJob(
      GetPipelineJobRequest request, StreamObserver<PipelineJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PipelineJob) {
      requests.add(request);
      responseObserver.onNext(((PipelineJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPipelineJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PipelineJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPipelineJobs(
      ListPipelineJobsRequest request, StreamObserver<ListPipelineJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPipelineJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPipelineJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPipelineJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPipelineJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePipelineJob(
      DeletePipelineJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePipelineJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelPipelineJob(
      CancelPipelineJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelPipelineJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
