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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsServiceGrpc.SecuritySettingsServiceImplBase;
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
public class MockSecuritySettingsServiceImpl extends SecuritySettingsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSecuritySettingsServiceImpl() {
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
  public void createSecuritySettings(
      CreateSecuritySettingsRequest request, StreamObserver<SecuritySettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SecuritySettings) {
      requests.add(request);
      responseObserver.onNext(((SecuritySettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSecuritySettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecuritySettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSecuritySettings(
      GetSecuritySettingsRequest request, StreamObserver<SecuritySettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SecuritySettings) {
      requests.add(request);
      responseObserver.onNext(((SecuritySettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSecuritySettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecuritySettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSecuritySettings(
      UpdateSecuritySettingsRequest request, StreamObserver<SecuritySettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SecuritySettings) {
      requests.add(request);
      responseObserver.onNext(((SecuritySettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSecuritySettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecuritySettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSecuritySettings(
      ListSecuritySettingsRequest request,
      StreamObserver<ListSecuritySettingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSecuritySettingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSecuritySettingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSecuritySettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSecuritySettingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSecuritySettings(
      DeleteSecuritySettingsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSecuritySettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
