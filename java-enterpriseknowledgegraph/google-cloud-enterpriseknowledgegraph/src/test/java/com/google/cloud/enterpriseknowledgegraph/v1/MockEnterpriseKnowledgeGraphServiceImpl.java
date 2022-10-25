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

package com.google.cloud.enterpriseknowledgegraph.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceGrpc.EnterpriseKnowledgeGraphServiceImplBase;
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
public class MockEnterpriseKnowledgeGraphServiceImpl
    extends EnterpriseKnowledgeGraphServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEnterpriseKnowledgeGraphServiceImpl() {
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
  public void createEntityReconciliationJob(
      CreateEntityReconciliationJobRequest request,
      StreamObserver<EntityReconciliationJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntityReconciliationJob) {
      requests.add(request);
      responseObserver.onNext(((EntityReconciliationJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEntityReconciliationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntityReconciliationJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntityReconciliationJob(
      GetEntityReconciliationJobRequest request,
      StreamObserver<EntityReconciliationJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntityReconciliationJob) {
      requests.add(request);
      responseObserver.onNext(((EntityReconciliationJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntityReconciliationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntityReconciliationJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntityReconciliationJobs(
      ListEntityReconciliationJobsRequest request,
      StreamObserver<ListEntityReconciliationJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntityReconciliationJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntityReconciliationJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntityReconciliationJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntityReconciliationJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelEntityReconciliationJob(
      CancelEntityReconciliationJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelEntityReconciliationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntityReconciliationJob(
      DeleteEntityReconciliationJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEntityReconciliationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
