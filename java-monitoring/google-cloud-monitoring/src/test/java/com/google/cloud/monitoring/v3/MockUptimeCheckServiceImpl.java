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

import com.google.api.core.BetaApi;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.monitoring.v3.UptimeCheckServiceGrpc.UptimeCheckServiceImplBase;
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
public class MockUptimeCheckServiceImpl extends UptimeCheckServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockUptimeCheckServiceImpl() {
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
  public void listUptimeCheckConfigs(
      ListUptimeCheckConfigsRequest request,
      StreamObserver<ListUptimeCheckConfigsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListUptimeCheckConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUptimeCheckConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUptimeCheckConfigs, expected %s or %s",
                  response.getClass().getName(),
                  ListUptimeCheckConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUptimeCheckConfig(
      GetUptimeCheckConfigRequest request, StreamObserver<UptimeCheckConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UptimeCheckConfig) {
      requests.add(request);
      responseObserver.onNext(((UptimeCheckConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUptimeCheckConfig, expected %s or %s",
                  response.getClass().getName(),
                  UptimeCheckConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUptimeCheckConfig(
      CreateUptimeCheckConfigRequest request, StreamObserver<UptimeCheckConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UptimeCheckConfig) {
      requests.add(request);
      responseObserver.onNext(((UptimeCheckConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUptimeCheckConfig, expected %s or %s",
                  response.getClass().getName(),
                  UptimeCheckConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUptimeCheckConfig(
      UpdateUptimeCheckConfigRequest request, StreamObserver<UptimeCheckConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UptimeCheckConfig) {
      requests.add(request);
      responseObserver.onNext(((UptimeCheckConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUptimeCheckConfig, expected %s or %s",
                  response.getClass().getName(),
                  UptimeCheckConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUptimeCheckConfig(
      DeleteUptimeCheckConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUptimeCheckConfig, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUptimeCheckIps(
      ListUptimeCheckIpsRequest request,
      StreamObserver<ListUptimeCheckIpsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListUptimeCheckIpsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUptimeCheckIpsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUptimeCheckIps, expected %s or %s",
                  response.getClass().getName(),
                  ListUptimeCheckIpsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
