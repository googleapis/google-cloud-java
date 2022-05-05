/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.securitycenter.settings.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceGrpc.SecurityCenterSettingsServiceImplBase;
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
public class MockSecurityCenterSettingsServiceImpl extends SecurityCenterSettingsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSecurityCenterSettingsServiceImpl() {
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
  public void getServiceAccount(
      GetServiceAccountRequest request, StreamObserver<ServiceAccount> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceAccount) {
      requests.add(request);
      responseObserver.onNext(((ServiceAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceAccount.class.getName(),
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
  public void resetSettings(ResetSettingsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ResetSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchGetSettings(
      BatchGetSettingsRequest request, StreamObserver<BatchGetSettingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchGetSettingsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchGetSettingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchGetSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchGetSettingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void calculateEffectiveSettings(
      CalculateEffectiveSettingsRequest request, StreamObserver<Settings> responseObserver) {
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
                  "Unrecognized response type %s for method CalculateEffectiveSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCalculateEffectiveSettings(
      BatchCalculateEffectiveSettingsRequest request,
      StreamObserver<BatchCalculateEffectiveSettingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCalculateEffectiveSettingsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCalculateEffectiveSettingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCalculateEffectiveSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCalculateEffectiveSettingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getComponentSettings(
      GetComponentSettingsRequest request, StreamObserver<ComponentSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComponentSettings) {
      requests.add(request);
      responseObserver.onNext(((ComponentSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetComponentSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComponentSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateComponentSettings(
      UpdateComponentSettingsRequest request, StreamObserver<ComponentSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComponentSettings) {
      requests.add(request);
      responseObserver.onNext(((ComponentSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateComponentSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComponentSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetComponentSettings(
      ResetComponentSettingsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ResetComponentSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void calculateEffectiveComponentSettings(
      CalculateEffectiveComponentSettingsRequest request,
      StreamObserver<ComponentSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComponentSettings) {
      requests.add(request);
      responseObserver.onNext(((ComponentSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CalculateEffectiveComponentSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComponentSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDetectors(
      ListDetectorsRequest request, StreamObserver<ListDetectorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDetectorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDetectorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDetectors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDetectorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listComponents(
      ListComponentsRequest request, StreamObserver<ListComponentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListComponentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListComponentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListComponents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListComponentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
