/*
 * Copyright 2024 Google LLC
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
import com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreServiceGrpc.FeatureOnlineStoreServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockFeatureOnlineStoreServiceImpl extends FeatureOnlineStoreServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFeatureOnlineStoreServiceImpl() {
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
  public void fetchFeatureValues(
      FetchFeatureValuesRequest request,
      StreamObserver<FetchFeatureValuesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchFeatureValuesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchFeatureValuesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchFeatureValues, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchFeatureValuesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamingFetchFeatureValuesRequest> streamingFetchFeatureValues(
      final StreamObserver<StreamingFetchFeatureValuesResponse> responseObserver) {
    StreamObserver<StreamingFetchFeatureValuesRequest> requestObserver =
        new StreamObserver<StreamingFetchFeatureValuesRequest>() {
          @Override
          public void onNext(StreamingFetchFeatureValuesRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingFetchFeatureValuesResponse) {
              responseObserver.onNext(((StreamingFetchFeatureValuesResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingFetchFeatureValues, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamingFetchFeatureValuesResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  @Override
  public void searchNearestEntities(
      SearchNearestEntitiesRequest request,
      StreamObserver<SearchNearestEntitiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchNearestEntitiesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchNearestEntitiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchNearestEntities, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchNearestEntitiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
