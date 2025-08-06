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

package com.google.shopping.merchant.accounts.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.shopping.merchant.accounts.v1.OmnichannelSettingsServiceGrpc.OmnichannelSettingsServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockOmnichannelSettingsServiceImpl extends OmnichannelSettingsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockOmnichannelSettingsServiceImpl() {
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
  public void getOmnichannelSetting(
      GetOmnichannelSettingRequest request, StreamObserver<OmnichannelSetting> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OmnichannelSetting) {
      requests.add(request);
      responseObserver.onNext(((OmnichannelSetting) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOmnichannelSetting, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  OmnichannelSetting.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOmnichannelSettings(
      ListOmnichannelSettingsRequest request,
      StreamObserver<ListOmnichannelSettingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOmnichannelSettingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOmnichannelSettingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOmnichannelSettings, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOmnichannelSettingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createOmnichannelSetting(
      CreateOmnichannelSettingRequest request,
      StreamObserver<OmnichannelSetting> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OmnichannelSetting) {
      requests.add(request);
      responseObserver.onNext(((OmnichannelSetting) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateOmnichannelSetting, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OmnichannelSetting.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateOmnichannelSetting(
      UpdateOmnichannelSettingRequest request,
      StreamObserver<OmnichannelSetting> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OmnichannelSetting) {
      requests.add(request);
      responseObserver.onNext(((OmnichannelSetting) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateOmnichannelSetting, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OmnichannelSetting.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void requestInventoryVerification(
      RequestInventoryVerificationRequest request,
      StreamObserver<RequestInventoryVerificationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RequestInventoryVerificationResponse) {
      requests.add(request);
      responseObserver.onNext(((RequestInventoryVerificationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RequestInventoryVerification, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RequestInventoryVerificationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
