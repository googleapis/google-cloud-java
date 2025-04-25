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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceGrpc.FeatureRegistryServiceImplBase;
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
public class MockFeatureRegistryServiceImpl extends FeatureRegistryServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFeatureRegistryServiceImpl() {
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
  public void createFeatureGroup(
      CreateFeatureGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFeatureGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeatureGroup(
      GetFeatureGroupRequest request, StreamObserver<FeatureGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureGroup) {
      requests.add(request);
      responseObserver.onNext(((FeatureGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeatureGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatureGroups(
      ListFeatureGroupsRequest request,
      StreamObserver<ListFeatureGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeatureGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeatureGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatureGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeatureGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeatureGroup(
      UpdateFeatureGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFeatureGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeatureGroup(
      DeleteFeatureGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeatureGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeature(
      CreateFeatureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateFeatures(
      BatchCreateFeaturesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchCreateFeatures, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeature(GetFeatureRequest request, StreamObserver<Feature> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feature) {
      requests.add(request);
      responseObserver.onNext(((Feature) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feature.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatures(
      ListFeaturesRequest request, StreamObserver<ListFeaturesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeaturesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeaturesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatures, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeaturesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeature(
      UpdateFeatureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeature(
      DeleteFeatureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeatureMonitor(
      CreateFeatureMonitorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFeatureMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeatureMonitor(
      GetFeatureMonitorRequest request, StreamObserver<FeatureMonitor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureMonitor) {
      requests.add(request);
      responseObserver.onNext(((FeatureMonitor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeatureMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureMonitor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatureMonitors(
      ListFeatureMonitorsRequest request,
      StreamObserver<ListFeatureMonitorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeatureMonitorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeatureMonitorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatureMonitors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeatureMonitorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeatureMonitor(
      UpdateFeatureMonitorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFeatureMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeatureMonitor(
      DeleteFeatureMonitorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeatureMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeatureMonitorJob(
      CreateFeatureMonitorJobRequest request, StreamObserver<FeatureMonitorJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureMonitorJob) {
      requests.add(request);
      responseObserver.onNext(((FeatureMonitorJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFeatureMonitorJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureMonitorJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeatureMonitorJob(
      GetFeatureMonitorJobRequest request, StreamObserver<FeatureMonitorJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeatureMonitorJob) {
      requests.add(request);
      responseObserver.onNext(((FeatureMonitorJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeatureMonitorJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeatureMonitorJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatureMonitorJobs(
      ListFeatureMonitorJobsRequest request,
      StreamObserver<ListFeatureMonitorJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeatureMonitorJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeatureMonitorJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatureMonitorJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeatureMonitorJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
