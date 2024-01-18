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

package com.google.api.cloudquotas.v1;

import com.google.api.cloudquotas.v1.CloudQuotasGrpc.CloudQuotasImplBase;
import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudQuotasImpl extends CloudQuotasImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudQuotasImpl() {
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
  public void listQuotaInfos(
      ListQuotaInfosRequest request, StreamObserver<ListQuotaInfosResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListQuotaInfosResponse) {
      requests.add(request);
      responseObserver.onNext(((ListQuotaInfosResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListQuotaInfos, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListQuotaInfosResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getQuotaInfo(
      GetQuotaInfoRequest request, StreamObserver<QuotaInfo> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QuotaInfo) {
      requests.add(request);
      responseObserver.onNext(((QuotaInfo) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetQuotaInfo, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QuotaInfo.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listQuotaPreferences(
      ListQuotaPreferencesRequest request,
      StreamObserver<ListQuotaPreferencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListQuotaPreferencesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListQuotaPreferencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListQuotaPreferences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListQuotaPreferencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getQuotaPreference(
      GetQuotaPreferenceRequest request, StreamObserver<QuotaPreference> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QuotaPreference) {
      requests.add(request);
      responseObserver.onNext(((QuotaPreference) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetQuotaPreference, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QuotaPreference.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createQuotaPreference(
      CreateQuotaPreferenceRequest request, StreamObserver<QuotaPreference> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QuotaPreference) {
      requests.add(request);
      responseObserver.onNext(((QuotaPreference) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateQuotaPreference, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QuotaPreference.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateQuotaPreference(
      UpdateQuotaPreferenceRequest request, StreamObserver<QuotaPreference> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QuotaPreference) {
      requests.add(request);
      responseObserver.onNext(((QuotaPreference) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateQuotaPreference, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QuotaPreference.class.getName(),
                  Exception.class.getName())));
    }
  }
}
