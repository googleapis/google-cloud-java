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

package com.google.cloud.gkerecommender.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartGrpc.GkeInferenceQuickstartImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockGkeInferenceQuickstartImpl extends GkeInferenceQuickstartImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGkeInferenceQuickstartImpl() {
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
  public void fetchModels(
      FetchModelsRequest request, StreamObserver<FetchModelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchModelsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchModelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchModels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchModelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchModelServers(
      FetchModelServersRequest request,
      StreamObserver<FetchModelServersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchModelServersResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchModelServersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchModelServers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchModelServersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchModelServerVersions(
      FetchModelServerVersionsRequest request,
      StreamObserver<FetchModelServerVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchModelServerVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchModelServerVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchModelServerVersions, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchModelServerVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchProfiles(
      FetchProfilesRequest request, StreamObserver<FetchProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateOptimizedManifest(
      GenerateOptimizedManifestRequest request,
      StreamObserver<GenerateOptimizedManifestResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateOptimizedManifestResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateOptimizedManifestResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateOptimizedManifest, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateOptimizedManifestResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchBenchmarkingData(
      FetchBenchmarkingDataRequest request,
      StreamObserver<FetchBenchmarkingDataResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchBenchmarkingDataResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchBenchmarkingDataResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchBenchmarkingData, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchBenchmarkingDataResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
