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

package com.google.cloud.securitycentermanagement.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementGrpc.SecurityCenterManagementImplBase;
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
public class MockSecurityCenterManagementImpl extends SecurityCenterManagementImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSecurityCenterManagementImpl() {
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
  public void listEffectiveSecurityHealthAnalyticsCustomModules(
      ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request,
      StreamObserver<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEffectiveSecurityHealthAnalyticsCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(
          ((ListEffectiveSecurityHealthAnalyticsCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEffectiveSecurityHealthAnalyticsCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEffectiveSecurityHealthAnalyticsCustomModule(
      GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<EffectiveSecurityHealthAnalyticsCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EffectiveSecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((EffectiveSecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEffectiveSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EffectiveSecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSecurityHealthAnalyticsCustomModules(
      ListSecurityHealthAnalyticsCustomModulesRequest request,
      StreamObserver<ListSecurityHealthAnalyticsCustomModulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSecurityHealthAnalyticsCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSecurityHealthAnalyticsCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSecurityHealthAnalyticsCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSecurityHealthAnalyticsCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDescendantSecurityHealthAnalyticsCustomModules(
      ListDescendantSecurityHealthAnalyticsCustomModulesRequest request,
      StreamObserver<ListDescendantSecurityHealthAnalyticsCustomModulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDescendantSecurityHealthAnalyticsCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(
          ((ListDescendantSecurityHealthAnalyticsCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDescendantSecurityHealthAnalyticsCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDescendantSecurityHealthAnalyticsCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSecurityHealthAnalyticsCustomModule(
      GetSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SecurityHealthAnalyticsCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((SecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSecurityHealthAnalyticsCustomModule(
      CreateSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SecurityHealthAnalyticsCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((SecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSecurityHealthAnalyticsCustomModule(
      UpdateSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SecurityHealthAnalyticsCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((SecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSecurityHealthAnalyticsCustomModule(
      DeleteSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void simulateSecurityHealthAnalyticsCustomModule(
      SimulateSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SimulateSecurityHealthAnalyticsCustomModuleResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SimulateSecurityHealthAnalyticsCustomModuleResponse) {
      requests.add(request);
      responseObserver.onNext(((SimulateSecurityHealthAnalyticsCustomModuleResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SimulateSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SimulateSecurityHealthAnalyticsCustomModuleResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEffectiveEventThreatDetectionCustomModules(
      ListEffectiveEventThreatDetectionCustomModulesRequest request,
      StreamObserver<ListEffectiveEventThreatDetectionCustomModulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEffectiveEventThreatDetectionCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEffectiveEventThreatDetectionCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEffectiveEventThreatDetectionCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEffectiveEventThreatDetectionCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEffectiveEventThreatDetectionCustomModule(
      GetEffectiveEventThreatDetectionCustomModuleRequest request,
      StreamObserver<EffectiveEventThreatDetectionCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EffectiveEventThreatDetectionCustomModule) {
      requests.add(request);
      responseObserver.onNext(((EffectiveEventThreatDetectionCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEffectiveEventThreatDetectionCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EffectiveEventThreatDetectionCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEventThreatDetectionCustomModules(
      ListEventThreatDetectionCustomModulesRequest request,
      StreamObserver<ListEventThreatDetectionCustomModulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEventThreatDetectionCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEventThreatDetectionCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEventThreatDetectionCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEventThreatDetectionCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDescendantEventThreatDetectionCustomModules(
      ListDescendantEventThreatDetectionCustomModulesRequest request,
      StreamObserver<ListDescendantEventThreatDetectionCustomModulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDescendantEventThreatDetectionCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDescendantEventThreatDetectionCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDescendantEventThreatDetectionCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDescendantEventThreatDetectionCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEventThreatDetectionCustomModule(
      GetEventThreatDetectionCustomModuleRequest request,
      StreamObserver<EventThreatDetectionCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EventThreatDetectionCustomModule) {
      requests.add(request);
      responseObserver.onNext(((EventThreatDetectionCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEventThreatDetectionCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EventThreatDetectionCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEventThreatDetectionCustomModule(
      CreateEventThreatDetectionCustomModuleRequest request,
      StreamObserver<EventThreatDetectionCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EventThreatDetectionCustomModule) {
      requests.add(request);
      responseObserver.onNext(((EventThreatDetectionCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEventThreatDetectionCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EventThreatDetectionCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEventThreatDetectionCustomModule(
      UpdateEventThreatDetectionCustomModuleRequest request,
      StreamObserver<EventThreatDetectionCustomModule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EventThreatDetectionCustomModule) {
      requests.add(request);
      responseObserver.onNext(((EventThreatDetectionCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEventThreatDetectionCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EventThreatDetectionCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEventThreatDetectionCustomModule(
      DeleteEventThreatDetectionCustomModuleRequest request,
      StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEventThreatDetectionCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void validateEventThreatDetectionCustomModule(
      ValidateEventThreatDetectionCustomModuleRequest request,
      StreamObserver<ValidateEventThreatDetectionCustomModuleResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ValidateEventThreatDetectionCustomModuleResponse) {
      requests.add(request);
      responseObserver.onNext(((ValidateEventThreatDetectionCustomModuleResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ValidateEventThreatDetectionCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ValidateEventThreatDetectionCustomModuleResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
