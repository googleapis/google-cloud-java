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

package com.google.cloud.gdchardwaremanagement.v1alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementGrpc.GDCHardwareManagementImplBase;
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
public class MockGDCHardwareManagementImpl extends GDCHardwareManagementImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGDCHardwareManagementImpl() {
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
  public void listOrders(
      ListOrdersRequest request, StreamObserver<ListOrdersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOrdersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOrdersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOrders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOrdersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOrder(GetOrderRequest request, StreamObserver<Order> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Order) {
      requests.add(request);
      responseObserver.onNext(((Order) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Order.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createOrder(CreateOrderRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateOrder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateOrder(UpdateOrderRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateOrder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteOrder(DeleteOrderRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteOrder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void submitOrder(SubmitOrderRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SubmitOrder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelOrder(CancelOrderRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CancelOrder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSites(
      ListSitesRequest request, StreamObserver<ListSitesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSitesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSitesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSites, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSitesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSite(GetSiteRequest request, StreamObserver<Site> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Site) {
      requests.add(request);
      responseObserver.onNext(((Site) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Site.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSite(CreateSiteRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateSite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSite(UpdateSiteRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateSite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSite(DeleteSiteRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHardwareGroups(
      ListHardwareGroupsRequest request,
      StreamObserver<ListHardwareGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHardwareGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHardwareGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHardwareGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHardwareGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHardwareGroup(
      GetHardwareGroupRequest request, StreamObserver<HardwareGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HardwareGroup) {
      requests.add(request);
      responseObserver.onNext(((HardwareGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHardwareGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HardwareGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHardwareGroup(
      CreateHardwareGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateHardwareGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHardwareGroup(
      UpdateHardwareGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateHardwareGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHardwareGroup(
      DeleteHardwareGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHardwareGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHardware(
      ListHardwareRequest request, StreamObserver<ListHardwareResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHardwareResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHardwareResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHardware, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHardwareResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHardware(GetHardwareRequest request, StreamObserver<Hardware> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Hardware) {
      requests.add(request);
      responseObserver.onNext(((Hardware) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHardware, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Hardware.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHardware(
      CreateHardwareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateHardware, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHardware(
      UpdateHardwareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateHardware, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHardware(
      DeleteHardwareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHardware, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listComments(
      ListCommentsRequest request, StreamObserver<ListCommentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCommentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCommentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListComments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCommentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getComment(GetCommentRequest request, StreamObserver<Comment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Comment) {
      requests.add(request);
      responseObserver.onNext(((Comment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetComment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Comment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createComment(
      CreateCommentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateComment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void recordActionOnComment(
      RecordActionOnCommentRequest request, StreamObserver<Comment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Comment) {
      requests.add(request);
      responseObserver.onNext(((Comment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RecordActionOnComment, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Comment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChangeLogEntries(
      ListChangeLogEntriesRequest request,
      StreamObserver<ListChangeLogEntriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChangeLogEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChangeLogEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChangeLogEntries, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChangeLogEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChangeLogEntry(
      GetChangeLogEntryRequest request, StreamObserver<ChangeLogEntry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChangeLogEntry) {
      requests.add(request);
      responseObserver.onNext(((ChangeLogEntry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChangeLogEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChangeLogEntry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSkus(ListSkusRequest request, StreamObserver<ListSkusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSkusResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSkusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSkus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSkusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSku(GetSkuRequest request, StreamObserver<Sku> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Sku) {
      requests.add(request);
      responseObserver.onNext(((Sku) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSku, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Sku.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listZones(
      ListZonesRequest request, StreamObserver<ListZonesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListZonesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListZonesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListZones, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListZonesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getZone(GetZoneRequest request, StreamObserver<Zone> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Zone) {
      requests.add(request);
      responseObserver.onNext(((Zone) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Zone.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createZone(CreateZoneRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateZone(UpdateZoneRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteZone(DeleteZoneRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void signalZoneState(
      SignalZoneStateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SignalZoneState, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void requestOrderDateChange(
      RequestOrderDateChangeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RequestOrderDateChange, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
