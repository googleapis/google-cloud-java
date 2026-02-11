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

package com.google.cloud.gkehub.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.gkehub.v1.GkeHubGrpc.GkeHubImplBase;
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
public class MockGkeHubImpl extends GkeHubImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGkeHubImpl() {
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
  public void listMemberships(
      ListMembershipsRequest request, StreamObserver<ListMembershipsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMembershipsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMembershipsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMemberships, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMembershipsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBoundMemberships(
      ListBoundMembershipsRequest request,
      StreamObserver<ListBoundMembershipsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBoundMembershipsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBoundMembershipsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBoundMemberships, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBoundMembershipsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeatures(
      ListFeaturesRequest request, StreamObserver<ListFeaturesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeaturesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeaturesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeatures, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeaturesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMembership(
      GetMembershipRequest request, StreamObserver<Membership> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Membership) {
      requests.add(request);
      responseObserver.onNext(((Membership) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Membership.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeature(GetFeatureRequest request, StreamObserver<Feature> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Feature) {
      requests.add(request);
      responseObserver.onNext(((Feature) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Feature.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMembership(
      CreateMembershipRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeature(
      CreateFeatureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMembership(
      DeleteMembershipRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeature(
      DeleteFeatureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMembership(
      UpdateMembershipRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeature(
      UpdateFeatureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFeature, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateConnectManifest(
      GenerateConnectManifestRequest request,
      StreamObserver<GenerateConnectManifestResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateConnectManifestResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateConnectManifestResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateConnectManifest, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateConnectManifestResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFleet(CreateFleetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFleet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFleet(GetFleetRequest request, StreamObserver<Fleet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Fleet) {
      requests.add(request);
      responseObserver.onNext(((Fleet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFleet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Fleet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFleet(UpdateFleetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFleet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFleet(DeleteFleetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFleet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFleets(
      ListFleetsRequest request, StreamObserver<ListFleetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFleetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFleetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFleets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFleetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getScopeNamespace(
      GetScopeNamespaceRequest request, StreamObserver<Namespace> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Namespace) {
      requests.add(request);
      responseObserver.onNext(((Namespace) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetScopeNamespace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Namespace.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createScopeNamespace(
      CreateScopeNamespaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateScopeNamespace, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateScopeNamespace(
      UpdateScopeNamespaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateScopeNamespace, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteScopeNamespace(
      DeleteScopeNamespaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteScopeNamespace, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listScopeNamespaces(
      ListScopeNamespacesRequest request,
      StreamObserver<ListScopeNamespacesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListScopeNamespacesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScopeNamespacesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListScopeNamespaces, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListScopeNamespacesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getScopeRBACRoleBinding(
      GetScopeRBACRoleBindingRequest request, StreamObserver<RBACRoleBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RBACRoleBinding) {
      requests.add(request);
      responseObserver.onNext(((RBACRoleBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetScopeRBACRoleBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RBACRoleBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createScopeRBACRoleBinding(
      CreateScopeRBACRoleBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateScopeRBACRoleBinding, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateScopeRBACRoleBinding(
      UpdateScopeRBACRoleBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateScopeRBACRoleBinding, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteScopeRBACRoleBinding(
      DeleteScopeRBACRoleBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteScopeRBACRoleBinding, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listScopeRBACRoleBindings(
      ListScopeRBACRoleBindingsRequest request,
      StreamObserver<ListScopeRBACRoleBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListScopeRBACRoleBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScopeRBACRoleBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListScopeRBACRoleBindings, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListScopeRBACRoleBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getScope(GetScopeRequest request, StreamObserver<Scope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Scope) {
      requests.add(request);
      responseObserver.onNext(((Scope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Scope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createScope(CreateScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateScope(UpdateScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteScope(DeleteScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listScopes(
      ListScopesRequest request, StreamObserver<ListScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListScopes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPermittedScopes(
      ListPermittedScopesRequest request,
      StreamObserver<ListPermittedScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPermittedScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPermittedScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPermittedScopes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPermittedScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMembershipBinding(
      GetMembershipBindingRequest request, StreamObserver<MembershipBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MembershipBinding) {
      requests.add(request);
      responseObserver.onNext(((MembershipBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMembershipBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  MembershipBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMembershipBinding(
      CreateMembershipBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMembershipBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMembershipBinding(
      UpdateMembershipBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMembershipBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMembershipBinding(
      DeleteMembershipBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMembershipBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMembershipBindings(
      ListMembershipBindingsRequest request,
      StreamObserver<ListMembershipBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMembershipBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMembershipBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMembershipBindings, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMembershipBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMembershipRBACRoleBinding(
      GetMembershipRBACRoleBindingRequest request,
      StreamObserver<RBACRoleBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RBACRoleBinding) {
      requests.add(request);
      responseObserver.onNext(((RBACRoleBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMembershipRBACRoleBinding, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RBACRoleBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMembershipRBACRoleBinding(
      CreateMembershipRBACRoleBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMembershipRBACRoleBinding,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMembershipRBACRoleBinding(
      UpdateMembershipRBACRoleBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMembershipRBACRoleBinding,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMembershipRBACRoleBinding(
      DeleteMembershipRBACRoleBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMembershipRBACRoleBinding,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMembershipRBACRoleBindings(
      ListMembershipRBACRoleBindingsRequest request,
      StreamObserver<ListMembershipRBACRoleBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMembershipRBACRoleBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMembershipRBACRoleBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMembershipRBACRoleBindings,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMembershipRBACRoleBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateMembershipRBACRoleBindingYAML(
      GenerateMembershipRBACRoleBindingYAMLRequest request,
      StreamObserver<GenerateMembershipRBACRoleBindingYAMLResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateMembershipRBACRoleBindingYAMLResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateMembershipRBACRoleBindingYAMLResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateMembershipRBACRoleBindingYAML,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateMembershipRBACRoleBindingYAMLResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
