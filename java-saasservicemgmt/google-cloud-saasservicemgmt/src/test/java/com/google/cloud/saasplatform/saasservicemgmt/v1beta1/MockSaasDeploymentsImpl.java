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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsGrpc.SaasDeploymentsImplBase;
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
public class MockSaasDeploymentsImpl extends SaasDeploymentsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSaasDeploymentsImpl() {
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
  public void listSaas(ListSaasRequest request, StreamObserver<ListSaasResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSaasResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSaasResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSaas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSaasResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSaas(GetSaasRequest request, StreamObserver<Saas> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Saas) {
      requests.add(request);
      responseObserver.onNext(((Saas) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSaas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Saas.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSaas(CreateSaasRequest request, StreamObserver<Saas> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Saas) {
      requests.add(request);
      responseObserver.onNext(((Saas) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSaas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Saas.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSaas(UpdateSaasRequest request, StreamObserver<Saas> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Saas) {
      requests.add(request);
      responseObserver.onNext(((Saas) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSaas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Saas.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSaas(DeleteSaasRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSaas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTenants(
      ListTenantsRequest request, StreamObserver<ListTenantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTenantsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTenantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTenants, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTenantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTenant(GetTenantRequest request, StreamObserver<Tenant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tenant) {
      requests.add(request);
      responseObserver.onNext(((Tenant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTenant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tenant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTenant(CreateTenantRequest request, StreamObserver<Tenant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tenant) {
      requests.add(request);
      responseObserver.onNext(((Tenant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTenant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tenant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTenant(UpdateTenantRequest request, StreamObserver<Tenant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tenant) {
      requests.add(request);
      responseObserver.onNext(((Tenant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTenant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tenant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTenant(DeleteTenantRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTenant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUnitKinds(
      ListUnitKindsRequest request, StreamObserver<ListUnitKindsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUnitKindsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUnitKindsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUnitKinds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUnitKindsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUnitKind(GetUnitKindRequest request, StreamObserver<UnitKind> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnitKind) {
      requests.add(request);
      responseObserver.onNext(((UnitKind) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUnitKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnitKind.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUnitKind(
      CreateUnitKindRequest request, StreamObserver<UnitKind> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnitKind) {
      requests.add(request);
      responseObserver.onNext(((UnitKind) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUnitKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnitKind.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUnitKind(
      UpdateUnitKindRequest request, StreamObserver<UnitKind> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnitKind) {
      requests.add(request);
      responseObserver.onNext(((UnitKind) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUnitKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnitKind.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUnitKind(
      DeleteUnitKindRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUnitKind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUnits(
      ListUnitsRequest request, StreamObserver<ListUnitsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUnitsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUnitsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUnits, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUnitsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUnit(GetUnitRequest request, StreamObserver<Unit> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Unit) {
      requests.add(request);
      responseObserver.onNext(((Unit) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUnit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Unit.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUnit(CreateUnitRequest request, StreamObserver<Unit> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Unit) {
      requests.add(request);
      responseObserver.onNext(((Unit) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUnit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Unit.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUnit(UpdateUnitRequest request, StreamObserver<Unit> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Unit) {
      requests.add(request);
      responseObserver.onNext(((Unit) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUnit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Unit.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUnit(DeleteUnitRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUnit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUnitOperations(
      ListUnitOperationsRequest request,
      StreamObserver<ListUnitOperationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUnitOperationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUnitOperationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUnitOperations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUnitOperationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUnitOperation(
      GetUnitOperationRequest request, StreamObserver<UnitOperation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnitOperation) {
      requests.add(request);
      responseObserver.onNext(((UnitOperation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUnitOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnitOperation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUnitOperation(
      CreateUnitOperationRequest request, StreamObserver<UnitOperation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnitOperation) {
      requests.add(request);
      responseObserver.onNext(((UnitOperation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUnitOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnitOperation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUnitOperation(
      UpdateUnitOperationRequest request, StreamObserver<UnitOperation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnitOperation) {
      requests.add(request);
      responseObserver.onNext(((UnitOperation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUnitOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnitOperation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUnitOperation(
      DeleteUnitOperationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUnitOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReleases(
      ListReleasesRequest request, StreamObserver<ListReleasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReleasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReleasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReleases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReleasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRelease(GetReleaseRequest request, StreamObserver<Release> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Release) {
      requests.add(request);
      responseObserver.onNext(((Release) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Release.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRelease(
      CreateReleaseRequest request, StreamObserver<Release> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Release) {
      requests.add(request);
      responseObserver.onNext(((Release) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Release.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRelease(
      UpdateReleaseRequest request, StreamObserver<Release> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Release) {
      requests.add(request);
      responseObserver.onNext(((Release) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Release.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRelease(DeleteReleaseRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
