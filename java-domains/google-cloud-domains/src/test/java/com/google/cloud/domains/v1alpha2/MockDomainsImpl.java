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

package com.google.cloud.domains.v1alpha2;

import com.google.api.core.BetaApi;
import com.google.cloud.domains.v1alpha2.DomainsGrpc.DomainsImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDomainsImpl extends DomainsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDomainsImpl() {
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
  public void searchDomains(
      SearchDomainsRequest request, StreamObserver<SearchDomainsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchDomainsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchDomainsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchDomains, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchDomainsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveRegisterParameters(
      RetrieveRegisterParametersRequest request,
      StreamObserver<RetrieveRegisterParametersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveRegisterParametersResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveRegisterParametersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveRegisterParameters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveRegisterParametersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void registerDomain(
      RegisterDomainRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RegisterDomain, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveTransferParameters(
      RetrieveTransferParametersRequest request,
      StreamObserver<RetrieveTransferParametersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveTransferParametersResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveTransferParametersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveTransferParameters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveTransferParametersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void transferDomain(
      TransferDomainRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method TransferDomain, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRegistrations(
      ListRegistrationsRequest request,
      StreamObserver<ListRegistrationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRegistrationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRegistrationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRegistrations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRegistrationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRegistration(
      GetRegistrationRequest request, StreamObserver<Registration> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Registration) {
      requests.add(request);
      responseObserver.onNext(((Registration) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRegistration, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Registration.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRegistration(
      UpdateRegistrationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateRegistration, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void configureManagementSettings(
      ConfigureManagementSettingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ConfigureManagementSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void configureDnsSettings(
      ConfigureDnsSettingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ConfigureDnsSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void configureContactSettings(
      ConfigureContactSettingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ConfigureContactSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportRegistration(
      ExportRegistrationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportRegistration, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRegistration(
      DeleteRegistrationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRegistration, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveAuthorizationCode(
      RetrieveAuthorizationCodeRequest request,
      StreamObserver<AuthorizationCode> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthorizationCode) {
      requests.add(request);
      responseObserver.onNext(((AuthorizationCode) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveAuthorizationCode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthorizationCode.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetAuthorizationCode(
      ResetAuthorizationCodeRequest request, StreamObserver<AuthorizationCode> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthorizationCode) {
      requests.add(request);
      responseObserver.onNext(((AuthorizationCode) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ResetAuthorizationCode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthorizationCode.class.getName(),
                  Exception.class.getName())));
    }
  }
}
