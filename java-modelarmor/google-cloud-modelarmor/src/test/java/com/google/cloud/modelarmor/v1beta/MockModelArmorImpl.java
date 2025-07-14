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

package com.google.cloud.modelarmor.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.modelarmor.v1beta.ModelArmorGrpc.ModelArmorImplBase;
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
public class MockModelArmorImpl extends ModelArmorImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockModelArmorImpl() {
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
  public void listTemplates(
      ListTemplatesRequest request, StreamObserver<ListTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTemplate(GetTemplateRequest request, StreamObserver<Template> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Template) {
      requests.add(request);
      responseObserver.onNext(((Template) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Template.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTemplate(
      CreateTemplateRequest request, StreamObserver<Template> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Template) {
      requests.add(request);
      responseObserver.onNext(((Template) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Template.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTemplate(
      UpdateTemplateRequest request, StreamObserver<Template> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Template) {
      requests.add(request);
      responseObserver.onNext(((Template) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Template.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTemplate(
      DeleteTemplateRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFloorSetting(
      GetFloorSettingRequest request, StreamObserver<FloorSetting> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FloorSetting) {
      requests.add(request);
      responseObserver.onNext(((FloorSetting) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFloorSetting, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FloorSetting.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFloorSetting(
      UpdateFloorSettingRequest request, StreamObserver<FloorSetting> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FloorSetting) {
      requests.add(request);
      responseObserver.onNext(((FloorSetting) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFloorSetting, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FloorSetting.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void sanitizeUserPrompt(
      SanitizeUserPromptRequest request,
      StreamObserver<SanitizeUserPromptResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SanitizeUserPromptResponse) {
      requests.add(request);
      responseObserver.onNext(((SanitizeUserPromptResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SanitizeUserPrompt, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SanitizeUserPromptResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void sanitizeModelResponse(
      SanitizeModelResponseRequest request,
      StreamObserver<SanitizeModelResponseResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SanitizeModelResponseResponse) {
      requests.add(request);
      responseObserver.onNext(((SanitizeModelResponseResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SanitizeModelResponse, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  SanitizeModelResponseResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
