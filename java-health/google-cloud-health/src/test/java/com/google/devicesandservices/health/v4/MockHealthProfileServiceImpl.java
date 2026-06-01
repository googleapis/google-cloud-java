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

package com.google.devicesandservices.health.v4;

import com.google.api.core.BetaApi;
import com.google.devicesandservices.health.v4.HealthProfileServiceGrpc.HealthProfileServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockHealthProfileServiceImpl extends HealthProfileServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockHealthProfileServiceImpl() {
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
  public void getProfile(GetProfileRequest request, StreamObserver<Profile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Profile) {
      requests.add(request);
      responseObserver.onNext(((Profile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Profile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProfile(
      UpdateProfileRequest request, StreamObserver<Profile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Profile) {
      requests.add(request);
      responseObserver.onNext(((Profile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Profile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSettings(GetSettingsRequest request, StreamObserver<Settings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Settings) {
      requests.add(request);
      responseObserver.onNext(((Settings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSettings(
      UpdateSettingsRequest request, StreamObserver<Settings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Settings) {
      requests.add(request);
      responseObserver.onNext(((Settings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIdentity(GetIdentityRequest request, StreamObserver<Identity> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Identity) {
      requests.add(request);
      responseObserver.onNext(((Identity) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIdentity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Identity.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIrnProfile(
      GetIrnProfileRequest request, StreamObserver<IrnProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IrnProfile) {
      requests.add(request);
      responseObserver.onNext(((IrnProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIrnProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IrnProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPairedDevice(
      GetPairedDeviceRequest request, StreamObserver<PairedDevice> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PairedDevice) {
      requests.add(request);
      responseObserver.onNext(((PairedDevice) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPairedDevice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PairedDevice.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPairedDevices(
      ListPairedDevicesRequest request,
      StreamObserver<ListPairedDevicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPairedDevicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPairedDevicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPairedDevices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPairedDevicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
