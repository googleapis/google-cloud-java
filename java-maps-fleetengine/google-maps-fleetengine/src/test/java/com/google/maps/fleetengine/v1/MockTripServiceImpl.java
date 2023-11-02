/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import google.maps.fleetengine.v1.TripServiceGrpc.TripServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockTripServiceImpl extends TripServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTripServiceImpl() {
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
  public void createTrip(CreateTripRequest request, StreamObserver<Trip> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trip) {
      requests.add(request);
      responseObserver.onNext(((Trip) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTrip, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trip.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTrip(GetTripRequest request, StreamObserver<Trip> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trip) {
      requests.add(request);
      responseObserver.onNext(((Trip) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTrip, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trip.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reportBillableTrip(
      ReportBillableTripRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ReportBillableTrip, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchTrips(
      SearchTripsRequest request, StreamObserver<SearchTripsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchTripsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchTripsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchTrips, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchTripsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTrip(UpdateTripRequest request, StreamObserver<Trip> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trip) {
      requests.add(request);
      responseObserver.onNext(((Trip) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTrip, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trip.class.getName(),
                  Exception.class.getName())));
    }
  }
}
