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
import google.maps.fleetengine.v1.VehicleServiceGrpc.VehicleServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockVehicleServiceImpl extends VehicleServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockVehicleServiceImpl() {
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
  public void createVehicle(
      CreateVehicleRequest request, StreamObserver<Vehicle> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Vehicle) {
      requests.add(request);
      responseObserver.onNext(((Vehicle) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateVehicle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Vehicle.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVehicle(GetVehicleRequest request, StreamObserver<Vehicle> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Vehicle) {
      requests.add(request);
      responseObserver.onNext(((Vehicle) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVehicle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Vehicle.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVehicle(
      UpdateVehicleRequest request, StreamObserver<Vehicle> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Vehicle) {
      requests.add(request);
      responseObserver.onNext(((Vehicle) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateVehicle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Vehicle.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVehicleLocation(
      UpdateVehicleLocationRequest request, StreamObserver<VehicleLocation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VehicleLocation) {
      requests.add(request);
      responseObserver.onNext(((VehicleLocation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateVehicleLocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VehicleLocation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVehicleAttributes(
      UpdateVehicleAttributesRequest request,
      StreamObserver<UpdateVehicleAttributesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UpdateVehicleAttributesResponse) {
      requests.add(request);
      responseObserver.onNext(((UpdateVehicleAttributesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateVehicleAttributes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UpdateVehicleAttributesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVehicles(
      ListVehiclesRequest request, StreamObserver<ListVehiclesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVehiclesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVehiclesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVehicles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVehiclesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchVehicles(
      SearchVehiclesRequest request, StreamObserver<SearchVehiclesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchVehiclesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchVehiclesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchVehicles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchVehiclesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchFuzzedVehicles(
      SearchVehiclesRequest request, StreamObserver<SearchVehiclesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchVehiclesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchVehiclesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchFuzzedVehicles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchVehiclesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
