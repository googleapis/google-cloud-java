/*
 * Copyright 2026 Google LLC
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

package com.google.maps.geocode.v4;

import com.google.api.core.BetaApi;
import com.google.maps.geocode.v4.GeocodeServiceGrpc.GeocodeServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockGeocodeServiceImpl extends GeocodeServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGeocodeServiceImpl() {
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
  public void geocodeAddress(
      GeocodeAddressRequest request, StreamObserver<GeocodeAddressResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GeocodeAddressResponse) {
      requests.add(request);
      responseObserver.onNext(((GeocodeAddressResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GeocodeAddress, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GeocodeAddressResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void geocodeLocation(
      GeocodeLocationRequest request, StreamObserver<GeocodeLocationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GeocodeLocationResponse) {
      requests.add(request);
      responseObserver.onNext(((GeocodeLocationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GeocodeLocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GeocodeLocationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void geocodePlace(
      GeocodePlaceRequest request, StreamObserver<GeocodeResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GeocodeResult) {
      requests.add(request);
      responseObserver.onNext(((GeocodeResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GeocodePlace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GeocodeResult.class.getName(),
                  Exception.class.getName())));
    }
  }
}
