/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.gdchardwaremanagement.v1alpha.stub;

import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListChangeLogEntriesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListCommentsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwareGroupsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwarePagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListOrdersPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSitesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSkusPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListZonesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry;
import com.google.cloud.gdchardwaremanagement.v1alpha.Comment;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Hardware;
import com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.OperationMetadata;
import com.google.cloud.gdchardwaremanagement.v1alpha.Order;
import com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Site;
import com.google.cloud.gdchardwaremanagement.v1alpha.Sku;
import com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Zone;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GDCHardwareManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class GDCHardwareManagementStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrdersPagedCallable()");
  }

  public UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrdersCallable()");
  }

  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrderCallable()");
  }

  public OperationCallable<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createOrderOperationCallable()");
  }

  public UnaryCallable<CreateOrderRequest, Operation> createOrderCallable() {
    throw new UnsupportedOperationException("Not implemented: createOrderCallable()");
  }

  public OperationCallable<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOrderOperationCallable()");
  }

  public UnaryCallable<UpdateOrderRequest, Operation> updateOrderCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOrderCallable()");
  }

  public OperationCallable<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOrderOperationCallable()");
  }

  public UnaryCallable<DeleteOrderRequest, Operation> deleteOrderCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOrderCallable()");
  }

  public OperationCallable<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: submitOrderOperationCallable()");
  }

  public UnaryCallable<SubmitOrderRequest, Operation> submitOrderCallable() {
    throw new UnsupportedOperationException("Not implemented: submitOrderCallable()");
  }

  public UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSitesPagedCallable()");
  }

  public UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSitesCallable()");
  }

  public UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: getSiteCallable()");
  }

  public OperationCallable<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSiteOperationCallable()");
  }

  public UnaryCallable<CreateSiteRequest, Operation> createSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: createSiteCallable()");
  }

  public OperationCallable<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSiteOperationCallable()");
  }

  public UnaryCallable<UpdateSiteRequest, Operation> updateSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSiteCallable()");
  }

  public UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsPagedResponse>
      listHardwareGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHardwareGroupsPagedCallable()");
  }

  public UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listHardwareGroupsCallable()");
  }

  public UnaryCallable<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getHardwareGroupCallable()");
  }

  public OperationCallable<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createHardwareGroupOperationCallable()");
  }

  public UnaryCallable<CreateHardwareGroupRequest, Operation> createHardwareGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createHardwareGroupCallable()");
  }

  public OperationCallable<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateHardwareGroupOperationCallable()");
  }

  public UnaryCallable<UpdateHardwareGroupRequest, Operation> updateHardwareGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHardwareGroupCallable()");
  }

  public OperationCallable<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteHardwareGroupOperationCallable()");
  }

  public UnaryCallable<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHardwareGroupCallable()");
  }

  public UnaryCallable<ListHardwareRequest, ListHardwarePagedResponse> listHardwarePagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHardwarePagedCallable()");
  }

  public UnaryCallable<ListHardwareRequest, ListHardwareResponse> listHardwareCallable() {
    throw new UnsupportedOperationException("Not implemented: listHardwareCallable()");
  }

  public UnaryCallable<GetHardwareRequest, Hardware> getHardwareCallable() {
    throw new UnsupportedOperationException("Not implemented: getHardwareCallable()");
  }

  public OperationCallable<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createHardwareOperationCallable()");
  }

  public UnaryCallable<CreateHardwareRequest, Operation> createHardwareCallable() {
    throw new UnsupportedOperationException("Not implemented: createHardwareCallable()");
  }

  public OperationCallable<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHardwareOperationCallable()");
  }

  public UnaryCallable<UpdateHardwareRequest, Operation> updateHardwareCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHardwareCallable()");
  }

  public OperationCallable<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHardwareOperationCallable()");
  }

  public UnaryCallable<DeleteHardwareRequest, Operation> deleteHardwareCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHardwareCallable()");
  }

  public UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse> listCommentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCommentsPagedCallable()");
  }

  public UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCommentsCallable()");
  }

  public UnaryCallable<GetCommentRequest, Comment> getCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: getCommentCallable()");
  }

  public OperationCallable<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCommentOperationCallable()");
  }

  public UnaryCallable<CreateCommentRequest, Operation> createCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: createCommentCallable()");
  }

  public UnaryCallable<RecordActionOnCommentRequest, Comment> recordActionOnCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: recordActionOnCommentCallable()");
  }

  public UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChangeLogEntriesPagedCallable()");
  }

  public UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listChangeLogEntriesCallable()");
  }

  public UnaryCallable<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: getChangeLogEntryCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusPagedCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusCallable()");
  }

  public UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    throw new UnsupportedOperationException("Not implemented: getSkuCallable()");
  }

  public UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listZonesPagedCallable()");
  }

  public UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    throw new UnsupportedOperationException("Not implemented: listZonesCallable()");
  }

  public UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: getZoneCallable()");
  }

  public OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createZoneOperationCallable()");
  }

  public UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: createZoneCallable()");
  }

  public OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateZoneOperationCallable()");
  }

  public UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: updateZoneCallable()");
  }

  public OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteZoneOperationCallable()");
  }

  public UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteZoneCallable()");
  }

  public OperationCallable<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: signalZoneStateOperationCallable()");
  }

  public UnaryCallable<SignalZoneStateRequest, Operation> signalZoneStateCallable() {
    throw new UnsupportedOperationException("Not implemented: signalZoneStateCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
