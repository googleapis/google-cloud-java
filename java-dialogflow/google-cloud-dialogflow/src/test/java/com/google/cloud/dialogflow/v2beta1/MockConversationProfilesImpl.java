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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.v2beta1.ConversationProfilesGrpc.ConversationProfilesImplBase;
import com.google.longrunning.Operation;
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
public class MockConversationProfilesImpl extends ConversationProfilesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConversationProfilesImpl() {
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
  public void listConversationProfiles(
      ListConversationProfilesRequest request,
      StreamObserver<ListConversationProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversationProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversationProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversationProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversationProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversationProfile(
      GetConversationProfileRequest request, StreamObserver<ConversationProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversationProfile) {
      requests.add(request);
      responseObserver.onNext(((ConversationProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversationProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversationProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConversationProfile(
      CreateConversationProfileRequest request,
      StreamObserver<ConversationProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversationProfile) {
      requests.add(request);
      responseObserver.onNext(((ConversationProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConversationProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversationProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConversationProfile(
      UpdateConversationProfileRequest request,
      StreamObserver<ConversationProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversationProfile) {
      requests.add(request);
      responseObserver.onNext(((ConversationProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConversationProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversationProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConversationProfile(
      DeleteConversationProfileRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConversationProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setSuggestionFeatureConfig(
      SetSuggestionFeatureConfigRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetSuggestionFeatureConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void clearSuggestionFeatureConfig(
      ClearSuggestionFeatureConfigRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ClearSuggestionFeatureConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
