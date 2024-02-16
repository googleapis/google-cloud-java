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

package com.google.maps.places.v1;

import com.google.api.core.BetaApi;
import com.google.maps.places.v1.PlacesGrpc.PlacesImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockPlacesImpl extends PlacesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPlacesImpl() {
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
  public void searchNearby(
      SearchNearbyRequest request, StreamObserver<SearchNearbyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchNearbyResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchNearbyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchNearby, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchNearbyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchText(
      SearchTextRequest request, StreamObserver<SearchTextResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchTextResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchTextResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchText, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchTextResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPhotoMedia(
      GetPhotoMediaRequest request, StreamObserver<PhotoMedia> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhotoMedia) {
      requests.add(request);
      responseObserver.onNext(((PhotoMedia) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPhotoMedia, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhotoMedia.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPlace(GetPlaceRequest request, StreamObserver<Place> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Place) {
      requests.add(request);
      responseObserver.onNext(((Place) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPlace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Place.class.getName(),
                  Exception.class.getName())));
    }
  }
}
