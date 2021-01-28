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

package com.google.cloud.monitoring.v3;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.BetaApi;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DeleteMetricDescriptorRequest;
import com.google.monitoring.v3.GetMetricDescriptorRequest;
import com.google.monitoring.v3.GetMonitoredResourceDescriptorRequest;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.MetricServiceGrpc.MetricServiceImplBase;
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
public class MockMetricServiceImpl extends MetricServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetricServiceImpl() {
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
  public void listMonitoredResourceDescriptors(
      ListMonitoredResourceDescriptorsRequest request,
      StreamObserver<ListMonitoredResourceDescriptorsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListMonitoredResourceDescriptorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMonitoredResourceDescriptorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getMonitoredResourceDescriptor(
      GetMonitoredResourceDescriptorRequest request,
      StreamObserver<MonitoredResourceDescriptor> responseObserver) {
    Object response = responses.remove();
    if (response instanceof MonitoredResourceDescriptor) {
      requests.add(request);
      responseObserver.onNext(((MonitoredResourceDescriptor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listMetricDescriptors(
      ListMetricDescriptorsRequest request,
      StreamObserver<ListMetricDescriptorsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListMetricDescriptorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMetricDescriptorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getMetricDescriptor(
      GetMetricDescriptorRequest request, StreamObserver<MetricDescriptor> responseObserver) {
    Object response = responses.remove();
    if (response instanceof MetricDescriptor) {
      requests.add(request);
      responseObserver.onNext(((MetricDescriptor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createMetricDescriptor(
      CreateMetricDescriptorRequest request, StreamObserver<MetricDescriptor> responseObserver) {
    Object response = responses.remove();
    if (response instanceof MetricDescriptor) {
      requests.add(request);
      responseObserver.onNext(((MetricDescriptor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteMetricDescriptor(
      DeleteMetricDescriptorRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listTimeSeries(
      ListTimeSeriesRequest request, StreamObserver<ListTimeSeriesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTimeSeriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTimeSeriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createTimeSeries(
      CreateTimeSeriesRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
