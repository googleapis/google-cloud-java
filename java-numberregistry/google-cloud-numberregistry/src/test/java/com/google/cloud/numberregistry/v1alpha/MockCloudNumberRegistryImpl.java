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

package com.google.cloud.numberregistry.v1alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryGrpc.CloudNumberRegistryImplBase;
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
public class MockCloudNumberRegistryImpl extends CloudNumberRegistryImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudNumberRegistryImpl() {
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
  public void listIpamAdminScopes(
      ListIpamAdminScopesRequest request,
      StreamObserver<ListIpamAdminScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIpamAdminScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIpamAdminScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIpamAdminScopes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIpamAdminScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIpamAdminScope(
      GetIpamAdminScopeRequest request, StreamObserver<IpamAdminScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IpamAdminScope) {
      requests.add(request);
      responseObserver.onNext(((IpamAdminScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIpamAdminScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IpamAdminScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void checkAvailabilityIpamAdminScopes(
      CheckAvailabilityIpamAdminScopesRequest request,
      StreamObserver<CheckAvailabilityIpamAdminScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CheckAvailabilityIpamAdminScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((CheckAvailabilityIpamAdminScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CheckAvailabilityIpamAdminScopes,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CheckAvailabilityIpamAdminScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIpamAdminScope(
      CreateIpamAdminScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateIpamAdminScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIpamAdminScope(
      UpdateIpamAdminScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateIpamAdminScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIpamAdminScope(
      DeleteIpamAdminScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIpamAdminScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableIpamAdminScope(
      DisableIpamAdminScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DisableIpamAdminScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cleanupIpamAdminScope(
      CleanupIpamAdminScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CleanupIpamAdminScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRegistryBooks(
      ListRegistryBooksRequest request,
      StreamObserver<ListRegistryBooksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRegistryBooksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRegistryBooksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRegistryBooks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRegistryBooksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRegistryBook(
      GetRegistryBookRequest request, StreamObserver<RegistryBook> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RegistryBook) {
      requests.add(request);
      responseObserver.onNext(((RegistryBook) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRegistryBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RegistryBook.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchIpResources(
      SearchIpResourcesRequest request,
      StreamObserver<SearchIpResourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchIpResourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchIpResourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchIpResources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchIpResourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRegistryBook(
      CreateRegistryBookRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRegistryBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRegistryBook(
      UpdateRegistryBookRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateRegistryBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRegistryBook(
      DeleteRegistryBookRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRegistryBook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRealms(
      ListRealmsRequest request, StreamObserver<ListRealmsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRealmsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRealmsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRealms, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRealmsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRealm(GetRealmRequest request, StreamObserver<Realm> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Realm) {
      requests.add(request);
      responseObserver.onNext(((Realm) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Realm.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRealm(CreateRealmRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRealm(UpdateRealmRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRealm(DeleteRealmRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRealm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDiscoveredRanges(
      ListDiscoveredRangesRequest request,
      StreamObserver<ListDiscoveredRangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDiscoveredRangesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDiscoveredRangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDiscoveredRanges, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDiscoveredRangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDiscoveredRange(
      GetDiscoveredRangeRequest request, StreamObserver<DiscoveredRange> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoveredRange) {
      requests.add(request);
      responseObserver.onNext(((DiscoveredRange) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDiscoveredRange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoveredRange.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void findDiscoveredRangeFreeIpRanges(
      FindDiscoveredRangeFreeIpRangesRequest request,
      StreamObserver<FindDiscoveredRangeFreeIpRangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindDiscoveredRangeFreeIpRangesResponse) {
      requests.add(request);
      responseObserver.onNext(((FindDiscoveredRangeFreeIpRangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FindDiscoveredRangeFreeIpRanges,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindDiscoveredRangeFreeIpRangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomRanges(
      ListCustomRangesRequest request, StreamObserver<ListCustomRangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomRangesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomRangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomRanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomRangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomRange(
      GetCustomRangeRequest request, StreamObserver<CustomRange> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomRange) {
      requests.add(request);
      responseObserver.onNext(((CustomRange) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomRange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomRange.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void showCustomRangeUtilization(
      ShowCustomRangeUtilizationRequest request,
      StreamObserver<ShowCustomRangeUtilizationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ShowCustomRangeUtilizationResponse) {
      requests.add(request);
      responseObserver.onNext(((ShowCustomRangeUtilizationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ShowCustomRangeUtilization, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ShowCustomRangeUtilizationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void showDiscoveredRangeUtilization(
      ShowDiscoveredRangeUtilizationRequest request,
      StreamObserver<ShowDiscoveredRangeUtilizationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ShowDiscoveredRangeUtilizationResponse) {
      requests.add(request);
      responseObserver.onNext(((ShowDiscoveredRangeUtilizationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ShowDiscoveredRangeUtilization,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ShowDiscoveredRangeUtilizationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void findCustomRangeFreeIpRanges(
      FindCustomRangeFreeIpRangesRequest request,
      StreamObserver<FindCustomRangeFreeIpRangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindCustomRangeFreeIpRangesResponse) {
      requests.add(request);
      responseObserver.onNext(((FindCustomRangeFreeIpRangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FindCustomRangeFreeIpRanges, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindCustomRangeFreeIpRangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomRange(
      CreateCustomRangeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCustomRange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomRange(
      UpdateCustomRangeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateCustomRange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomRange(
      DeleteCustomRangeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCustomRange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
