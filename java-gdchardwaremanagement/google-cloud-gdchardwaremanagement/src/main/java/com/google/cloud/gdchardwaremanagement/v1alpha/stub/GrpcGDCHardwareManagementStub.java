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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gdchardwaremanagement.v1alpha.CancelOrderRequest;
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
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest;
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
import com.google.cloud.gdchardwaremanagement.v1alpha.RequestOrderDateChangeRequest;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GDCHardwareManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGDCHardwareManagementStub extends GDCHardwareManagementStub {
  private static final MethodDescriptor<ListOrdersRequest, ListOrdersResponse>
      listOrdersMethodDescriptor =
          MethodDescriptor.<ListOrdersRequest, ListOrdersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListOrders")
              .setRequestMarshaller(ProtoUtils.marshaller(ListOrdersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListOrdersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetOrderRequest, Order> getOrderMethodDescriptor =
      MethodDescriptor.<GetOrderRequest, Order>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(GetOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Order.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateOrderRequest, Operation> createOrderMethodDescriptor =
      MethodDescriptor.<CreateOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateOrderRequest, Operation> updateOrderMethodDescriptor =
      MethodDescriptor.<UpdateOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteOrderRequest, Operation> deleteOrderMethodDescriptor =
      MethodDescriptor.<DeleteOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SubmitOrderRequest, Operation> submitOrderMethodDescriptor =
      MethodDescriptor.<SubmitOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/SubmitOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(SubmitOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CancelOrderRequest, Operation> cancelOrderMethodDescriptor =
      MethodDescriptor.<CancelOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CancelOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(CancelOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSitesRequest, ListSitesResponse>
      listSitesMethodDescriptor =
          MethodDescriptor.<ListSitesRequest, ListSitesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListSites")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSitesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSiteRequest, Site> getSiteMethodDescriptor =
      MethodDescriptor.<GetSiteRequest, Site>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetSite")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSiteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Site.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateSiteRequest, Operation> createSiteMethodDescriptor =
      MethodDescriptor.<CreateSiteRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateSite")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSiteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSiteRequest, Operation> updateSiteMethodDescriptor =
      MethodDescriptor.<UpdateSiteRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateSite")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSiteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteSiteRequest, Operation> deleteSiteMethodDescriptor =
      MethodDescriptor.<DeleteSiteRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteSite")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSiteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsMethodDescriptor =
          MethodDescriptor.<ListHardwareGroupsRequest, ListHardwareGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListHardwareGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHardwareGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHardwareGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHardwareGroupRequest, HardwareGroup>
      getHardwareGroupMethodDescriptor =
          MethodDescriptor.<GetHardwareGroupRequest, HardwareGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetHardwareGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHardwareGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HardwareGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateHardwareGroupRequest, Operation>
      createHardwareGroupMethodDescriptor =
          MethodDescriptor.<CreateHardwareGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateHardwareGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHardwareGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHardwareGroupRequest, Operation>
      updateHardwareGroupMethodDescriptor =
          MethodDescriptor.<UpdateHardwareGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateHardwareGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHardwareGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHardwareGroupRequest, Operation>
      deleteHardwareGroupMethodDescriptor =
          MethodDescriptor.<DeleteHardwareGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteHardwareGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHardwareGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHardwareRequest, ListHardwareResponse>
      listHardwareMethodDescriptor =
          MethodDescriptor.<ListHardwareRequest, ListHardwareResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListHardware")
              .setRequestMarshaller(ProtoUtils.marshaller(ListHardwareRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHardwareResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHardwareRequest, Hardware> getHardwareMethodDescriptor =
      MethodDescriptor.<GetHardwareRequest, Hardware>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetHardware")
          .setRequestMarshaller(ProtoUtils.marshaller(GetHardwareRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Hardware.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateHardwareRequest, Operation>
      createHardwareMethodDescriptor =
          MethodDescriptor.<CreateHardwareRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateHardware")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHardwareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHardwareRequest, Operation>
      updateHardwareMethodDescriptor =
          MethodDescriptor.<UpdateHardwareRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateHardware")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHardwareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHardwareRequest, Operation>
      deleteHardwareMethodDescriptor =
          MethodDescriptor.<DeleteHardwareRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteHardware")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHardwareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListCommentsRequest, ListCommentsResponse>
      listCommentsMethodDescriptor =
          MethodDescriptor.<ListCommentsRequest, ListCommentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListComments")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCommentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCommentRequest, Comment> getCommentMethodDescriptor =
      MethodDescriptor.<GetCommentRequest, Comment>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetComment")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCommentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Comment.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateCommentRequest, Operation>
      createCommentMethodDescriptor =
          MethodDescriptor.<CreateCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RecordActionOnCommentRequest, Comment>
      recordActionOnCommentMethodDescriptor =
          MethodDescriptor.<RecordActionOnCommentRequest, Comment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/RecordActionOnComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RecordActionOnCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Comment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesMethodDescriptor =
          MethodDescriptor.<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListChangeLogEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChangeLogEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChangeLogEntriesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetChangeLogEntryRequest, ChangeLogEntry>
      getChangeLogEntryMethodDescriptor =
          MethodDescriptor.<GetChangeLogEntryRequest, ChangeLogEntry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetChangeLogEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetChangeLogEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChangeLogEntry.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          MethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListSkus")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSkusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSkusResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSkuRequest, Sku> getSkuMethodDescriptor =
      MethodDescriptor.<GetSkuRequest, Sku>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetSku")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSkuRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Sku.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListZonesRequest, ListZonesResponse>
      listZonesMethodDescriptor =
          MethodDescriptor.<ListZonesRequest, ListZonesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListZones")
              .setRequestMarshaller(ProtoUtils.marshaller(ListZonesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListZonesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetZoneRequest, Zone> getZoneMethodDescriptor =
      MethodDescriptor.<GetZoneRequest, Zone>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetZone")
          .setRequestMarshaller(ProtoUtils.marshaller(GetZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Zone.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateZoneRequest, Operation> createZoneMethodDescriptor =
      MethodDescriptor.<CreateZoneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateZone")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateZoneRequest, Operation> updateZoneMethodDescriptor =
      MethodDescriptor.<UpdateZoneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateZone")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteZoneRequest, Operation> deleteZoneMethodDescriptor =
      MethodDescriptor.<DeleteZoneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteZone")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SignalZoneStateRequest, Operation>
      signalZoneStateMethodDescriptor =
          MethodDescriptor.<SignalZoneStateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/SignalZoneState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SignalZoneStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RequestOrderDateChangeRequest, Operation>
      requestOrderDateChangeMethodDescriptor =
          MethodDescriptor.<RequestOrderDateChangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/RequestOrderDateChange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RequestOrderDateChangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable;
  private final UnaryCallable<GetOrderRequest, Order> getOrderCallable;
  private final UnaryCallable<CreateOrderRequest, Operation> createOrderCallable;
  private final OperationCallable<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationCallable;
  private final UnaryCallable<UpdateOrderRequest, Operation> updateOrderCallable;
  private final OperationCallable<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationCallable;
  private final UnaryCallable<DeleteOrderRequest, Operation> deleteOrderCallable;
  private final OperationCallable<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationCallable;
  private final UnaryCallable<SubmitOrderRequest, Operation> submitOrderCallable;
  private final OperationCallable<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationCallable;
  private final UnaryCallable<CancelOrderRequest, Operation> cancelOrderCallable;
  private final OperationCallable<CancelOrderRequest, Order, OperationMetadata>
      cancelOrderOperationCallable;
  private final UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable;
  private final UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable;
  private final UnaryCallable<GetSiteRequest, Site> getSiteCallable;
  private final UnaryCallable<CreateSiteRequest, Operation> createSiteCallable;
  private final OperationCallable<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationCallable;
  private final UnaryCallable<UpdateSiteRequest, Operation> updateSiteCallable;
  private final OperationCallable<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationCallable;
  private final UnaryCallable<DeleteSiteRequest, Operation> deleteSiteCallable;
  private final OperationCallable<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationCallable;
  private final UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsCallable;
  private final UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsPagedResponse>
      listHardwareGroupsPagedCallable;
  private final UnaryCallable<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupCallable;
  private final UnaryCallable<CreateHardwareGroupRequest, Operation> createHardwareGroupCallable;
  private final OperationCallable<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationCallable;
  private final UnaryCallable<UpdateHardwareGroupRequest, Operation> updateHardwareGroupCallable;
  private final OperationCallable<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationCallable;
  private final UnaryCallable<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupCallable;
  private final OperationCallable<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationCallable;
  private final UnaryCallable<ListHardwareRequest, ListHardwareResponse> listHardwareCallable;
  private final UnaryCallable<ListHardwareRequest, ListHardwarePagedResponse>
      listHardwarePagedCallable;
  private final UnaryCallable<GetHardwareRequest, Hardware> getHardwareCallable;
  private final UnaryCallable<CreateHardwareRequest, Operation> createHardwareCallable;
  private final OperationCallable<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationCallable;
  private final UnaryCallable<UpdateHardwareRequest, Operation> updateHardwareCallable;
  private final OperationCallable<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationCallable;
  private final UnaryCallable<DeleteHardwareRequest, Operation> deleteHardwareCallable;
  private final OperationCallable<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationCallable;
  private final UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable;
  private final UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse>
      listCommentsPagedCallable;
  private final UnaryCallable<GetCommentRequest, Comment> getCommentCallable;
  private final UnaryCallable<CreateCommentRequest, Operation> createCommentCallable;
  private final OperationCallable<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationCallable;
  private final UnaryCallable<RecordActionOnCommentRequest, Comment> recordActionOnCommentCallable;
  private final UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesCallable;
  private final UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesPagedCallable;
  private final UnaryCallable<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable;
  private final UnaryCallable<GetSkuRequest, Sku> getSkuCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable;
  private final UnaryCallable<GetZoneRequest, Zone> getZoneCallable;
  private final UnaryCallable<CreateZoneRequest, Operation> createZoneCallable;
  private final OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable;
  private final UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable;
  private final OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable;
  private final UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable;
  private final OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable;
  private final UnaryCallable<SignalZoneStateRequest, Operation> signalZoneStateCallable;
  private final OperationCallable<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationCallable;
  private final UnaryCallable<RequestOrderDateChangeRequest, Operation>
      requestOrderDateChangeCallable;
  private final OperationCallable<RequestOrderDateChangeRequest, Order, OperationMetadata>
      requestOrderDateChangeOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGDCHardwareManagementStub create(
      GDCHardwareManagementStubSettings settings) throws IOException {
    return new GrpcGDCHardwareManagementStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGDCHardwareManagementStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGDCHardwareManagementStub(
        GDCHardwareManagementStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGDCHardwareManagementStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGDCHardwareManagementStub(
        GDCHardwareManagementStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGDCHardwareManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGDCHardwareManagementStub(
      GDCHardwareManagementStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcGDCHardwareManagementCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGDCHardwareManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGDCHardwareManagementStub(
      GDCHardwareManagementStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListOrdersRequest, ListOrdersResponse> listOrdersTransportSettings =
        GrpcCallSettings.<ListOrdersRequest, ListOrdersResponse>newBuilder()
            .setMethodDescriptor(listOrdersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetOrderRequest, Order> getOrderTransportSettings =
        GrpcCallSettings.<GetOrderRequest, Order>newBuilder()
            .setMethodDescriptor(getOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateOrderRequest, Operation> createOrderTransportSettings =
        GrpcCallSettings.<CreateOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(createOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateOrderRequest, Operation> updateOrderTransportSettings =
        GrpcCallSettings.<UpdateOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(updateOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("order.name", String.valueOf(request.getOrder().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteOrderRequest, Operation> deleteOrderTransportSettings =
        GrpcCallSettings.<DeleteOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SubmitOrderRequest, Operation> submitOrderTransportSettings =
        GrpcCallSettings.<SubmitOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(submitOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CancelOrderRequest, Operation> cancelOrderTransportSettings =
        GrpcCallSettings.<CancelOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSitesRequest, ListSitesResponse> listSitesTransportSettings =
        GrpcCallSettings.<ListSitesRequest, ListSitesResponse>newBuilder()
            .setMethodDescriptor(listSitesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSiteRequest, Site> getSiteTransportSettings =
        GrpcCallSettings.<GetSiteRequest, Site>newBuilder()
            .setMethodDescriptor(getSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSiteRequest, Operation> createSiteTransportSettings =
        GrpcCallSettings.<CreateSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(createSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSiteRequest, Operation> updateSiteTransportSettings =
        GrpcCallSettings.<UpdateSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("site.name", String.valueOf(request.getSite().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSiteRequest, Operation> deleteSiteTransportSettings =
        GrpcCallSettings.<DeleteSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
        listHardwareGroupsTransportSettings =
            GrpcCallSettings.<ListHardwareGroupsRequest, ListHardwareGroupsResponse>newBuilder()
                .setMethodDescriptor(listHardwareGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupTransportSettings =
        GrpcCallSettings.<GetHardwareGroupRequest, HardwareGroup>newBuilder()
            .setMethodDescriptor(getHardwareGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateHardwareGroupRequest, Operation> createHardwareGroupTransportSettings =
        GrpcCallSettings.<CreateHardwareGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createHardwareGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHardwareGroupRequest, Operation> updateHardwareGroupTransportSettings =
        GrpcCallSettings.<UpdateHardwareGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHardwareGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "hardware_group.name", String.valueOf(request.getHardwareGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupTransportSettings =
        GrpcCallSettings.<DeleteHardwareGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHardwareGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListHardwareRequest, ListHardwareResponse> listHardwareTransportSettings =
        GrpcCallSettings.<ListHardwareRequest, ListHardwareResponse>newBuilder()
            .setMethodDescriptor(listHardwareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetHardwareRequest, Hardware> getHardwareTransportSettings =
        GrpcCallSettings.<GetHardwareRequest, Hardware>newBuilder()
            .setMethodDescriptor(getHardwareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateHardwareRequest, Operation> createHardwareTransportSettings =
        GrpcCallSettings.<CreateHardwareRequest, Operation>newBuilder()
            .setMethodDescriptor(createHardwareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHardwareRequest, Operation> updateHardwareTransportSettings =
        GrpcCallSettings.<UpdateHardwareRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHardwareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hardware.name", String.valueOf(request.getHardware().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHardwareRequest, Operation> deleteHardwareTransportSettings =
        GrpcCallSettings.<DeleteHardwareRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHardwareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCommentsRequest, ListCommentsResponse> listCommentsTransportSettings =
        GrpcCallSettings.<ListCommentsRequest, ListCommentsResponse>newBuilder()
            .setMethodDescriptor(listCommentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCommentRequest, Comment> getCommentTransportSettings =
        GrpcCallSettings.<GetCommentRequest, Comment>newBuilder()
            .setMethodDescriptor(getCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCommentRequest, Operation> createCommentTransportSettings =
        GrpcCallSettings.<CreateCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(createCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RecordActionOnCommentRequest, Comment> recordActionOnCommentTransportSettings =
        GrpcCallSettings.<RecordActionOnCommentRequest, Comment>newBuilder()
            .setMethodDescriptor(recordActionOnCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
        listChangeLogEntriesTransportSettings =
            GrpcCallSettings.<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>newBuilder()
                .setMethodDescriptor(listChangeLogEntriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryTransportSettings =
        GrpcCallSettings.<GetChangeLogEntryRequest, ChangeLogEntry>newBuilder()
            .setMethodDescriptor(getChangeLogEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        GrpcCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSkuRequest, Sku> getSkuTransportSettings =
        GrpcCallSettings.<GetSkuRequest, Sku>newBuilder()
            .setMethodDescriptor(getSkuMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListZonesRequest, ListZonesResponse> listZonesTransportSettings =
        GrpcCallSettings.<ListZonesRequest, ListZonesResponse>newBuilder()
            .setMethodDescriptor(listZonesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetZoneRequest, Zone> getZoneTransportSettings =
        GrpcCallSettings.<GetZoneRequest, Zone>newBuilder()
            .setMethodDescriptor(getZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateZoneRequest, Operation> createZoneTransportSettings =
        GrpcCallSettings.<CreateZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(createZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateZoneRequest, Operation> updateZoneTransportSettings =
        GrpcCallSettings.<UpdateZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(updateZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("zone.name", String.valueOf(request.getZone().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteZoneRequest, Operation> deleteZoneTransportSettings =
        GrpcCallSettings.<DeleteZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SignalZoneStateRequest, Operation> signalZoneStateTransportSettings =
        GrpcCallSettings.<SignalZoneStateRequest, Operation>newBuilder()
            .setMethodDescriptor(signalZoneStateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RequestOrderDateChangeRequest, Operation>
        requestOrderDateChangeTransportSettings =
            GrpcCallSettings.<RequestOrderDateChangeRequest, Operation>newBuilder()
                .setMethodDescriptor(requestOrderDateChangeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listOrdersCallable =
        callableFactory.createUnaryCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.listOrdersPagedCallable =
        callableFactory.createPagedCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.getOrderCallable =
        callableFactory.createUnaryCallable(
            getOrderTransportSettings, settings.getOrderSettings(), clientContext);
    this.createOrderCallable =
        callableFactory.createUnaryCallable(
            createOrderTransportSettings, settings.createOrderSettings(), clientContext);
    this.createOrderOperationCallable =
        callableFactory.createOperationCallable(
            createOrderTransportSettings,
            settings.createOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.updateOrderCallable =
        callableFactory.createUnaryCallable(
            updateOrderTransportSettings, settings.updateOrderSettings(), clientContext);
    this.updateOrderOperationCallable =
        callableFactory.createOperationCallable(
            updateOrderTransportSettings,
            settings.updateOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteOrderCallable =
        callableFactory.createUnaryCallable(
            deleteOrderTransportSettings, settings.deleteOrderSettings(), clientContext);
    this.deleteOrderOperationCallable =
        callableFactory.createOperationCallable(
            deleteOrderTransportSettings,
            settings.deleteOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.submitOrderCallable =
        callableFactory.createUnaryCallable(
            submitOrderTransportSettings, settings.submitOrderSettings(), clientContext);
    this.submitOrderOperationCallable =
        callableFactory.createOperationCallable(
            submitOrderTransportSettings,
            settings.submitOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelOrderCallable =
        callableFactory.createUnaryCallable(
            cancelOrderTransportSettings, settings.cancelOrderSettings(), clientContext);
    this.cancelOrderOperationCallable =
        callableFactory.createOperationCallable(
            cancelOrderTransportSettings,
            settings.cancelOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.listSitesCallable =
        callableFactory.createUnaryCallable(
            listSitesTransportSettings, settings.listSitesSettings(), clientContext);
    this.listSitesPagedCallable =
        callableFactory.createPagedCallable(
            listSitesTransportSettings, settings.listSitesSettings(), clientContext);
    this.getSiteCallable =
        callableFactory.createUnaryCallable(
            getSiteTransportSettings, settings.getSiteSettings(), clientContext);
    this.createSiteCallable =
        callableFactory.createUnaryCallable(
            createSiteTransportSettings, settings.createSiteSettings(), clientContext);
    this.createSiteOperationCallable =
        callableFactory.createOperationCallable(
            createSiteTransportSettings,
            settings.createSiteOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSiteCallable =
        callableFactory.createUnaryCallable(
            updateSiteTransportSettings, settings.updateSiteSettings(), clientContext);
    this.updateSiteOperationCallable =
        callableFactory.createOperationCallable(
            updateSiteTransportSettings,
            settings.updateSiteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSiteCallable =
        callableFactory.createUnaryCallable(
            deleteSiteTransportSettings, settings.deleteSiteSettings(), clientContext);
    this.deleteSiteOperationCallable =
        callableFactory.createOperationCallable(
            deleteSiteTransportSettings,
            settings.deleteSiteOperationSettings(),
            clientContext,
            operationsStub);
    this.listHardwareGroupsCallable =
        callableFactory.createUnaryCallable(
            listHardwareGroupsTransportSettings,
            settings.listHardwareGroupsSettings(),
            clientContext);
    this.listHardwareGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listHardwareGroupsTransportSettings,
            settings.listHardwareGroupsSettings(),
            clientContext);
    this.getHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            getHardwareGroupTransportSettings, settings.getHardwareGroupSettings(), clientContext);
    this.createHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            createHardwareGroupTransportSettings,
            settings.createHardwareGroupSettings(),
            clientContext);
    this.createHardwareGroupOperationCallable =
        callableFactory.createOperationCallable(
            createHardwareGroupTransportSettings,
            settings.createHardwareGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            updateHardwareGroupTransportSettings,
            settings.updateHardwareGroupSettings(),
            clientContext);
    this.updateHardwareGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateHardwareGroupTransportSettings,
            settings.updateHardwareGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            deleteHardwareGroupTransportSettings,
            settings.deleteHardwareGroupSettings(),
            clientContext);
    this.deleteHardwareGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteHardwareGroupTransportSettings,
            settings.deleteHardwareGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listHardwareCallable =
        callableFactory.createUnaryCallable(
            listHardwareTransportSettings, settings.listHardwareSettings(), clientContext);
    this.listHardwarePagedCallable =
        callableFactory.createPagedCallable(
            listHardwareTransportSettings, settings.listHardwareSettings(), clientContext);
    this.getHardwareCallable =
        callableFactory.createUnaryCallable(
            getHardwareTransportSettings, settings.getHardwareSettings(), clientContext);
    this.createHardwareCallable =
        callableFactory.createUnaryCallable(
            createHardwareTransportSettings, settings.createHardwareSettings(), clientContext);
    this.createHardwareOperationCallable =
        callableFactory.createOperationCallable(
            createHardwareTransportSettings,
            settings.createHardwareOperationSettings(),
            clientContext,
            operationsStub);
    this.updateHardwareCallable =
        callableFactory.createUnaryCallable(
            updateHardwareTransportSettings, settings.updateHardwareSettings(), clientContext);
    this.updateHardwareOperationCallable =
        callableFactory.createOperationCallable(
            updateHardwareTransportSettings,
            settings.updateHardwareOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteHardwareCallable =
        callableFactory.createUnaryCallable(
            deleteHardwareTransportSettings, settings.deleteHardwareSettings(), clientContext);
    this.deleteHardwareOperationCallable =
        callableFactory.createOperationCallable(
            deleteHardwareTransportSettings,
            settings.deleteHardwareOperationSettings(),
            clientContext,
            operationsStub);
    this.listCommentsCallable =
        callableFactory.createUnaryCallable(
            listCommentsTransportSettings, settings.listCommentsSettings(), clientContext);
    this.listCommentsPagedCallable =
        callableFactory.createPagedCallable(
            listCommentsTransportSettings, settings.listCommentsSettings(), clientContext);
    this.getCommentCallable =
        callableFactory.createUnaryCallable(
            getCommentTransportSettings, settings.getCommentSettings(), clientContext);
    this.createCommentCallable =
        callableFactory.createUnaryCallable(
            createCommentTransportSettings, settings.createCommentSettings(), clientContext);
    this.createCommentOperationCallable =
        callableFactory.createOperationCallable(
            createCommentTransportSettings,
            settings.createCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.recordActionOnCommentCallable =
        callableFactory.createUnaryCallable(
            recordActionOnCommentTransportSettings,
            settings.recordActionOnCommentSettings(),
            clientContext);
    this.listChangeLogEntriesCallable =
        callableFactory.createUnaryCallable(
            listChangeLogEntriesTransportSettings,
            settings.listChangeLogEntriesSettings(),
            clientContext);
    this.listChangeLogEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listChangeLogEntriesTransportSettings,
            settings.listChangeLogEntriesSettings(),
            clientContext);
    this.getChangeLogEntryCallable =
        callableFactory.createUnaryCallable(
            getChangeLogEntryTransportSettings,
            settings.getChangeLogEntrySettings(),
            clientContext);
    this.listSkusCallable =
        callableFactory.createUnaryCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.listSkusPagedCallable =
        callableFactory.createPagedCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.getSkuCallable =
        callableFactory.createUnaryCallable(
            getSkuTransportSettings, settings.getSkuSettings(), clientContext);
    this.listZonesCallable =
        callableFactory.createUnaryCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.listZonesPagedCallable =
        callableFactory.createPagedCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.getZoneCallable =
        callableFactory.createUnaryCallable(
            getZoneTransportSettings, settings.getZoneSettings(), clientContext);
    this.createZoneCallable =
        callableFactory.createUnaryCallable(
            createZoneTransportSettings, settings.createZoneSettings(), clientContext);
    this.createZoneOperationCallable =
        callableFactory.createOperationCallable(
            createZoneTransportSettings,
            settings.createZoneOperationSettings(),
            clientContext,
            operationsStub);
    this.updateZoneCallable =
        callableFactory.createUnaryCallable(
            updateZoneTransportSettings, settings.updateZoneSettings(), clientContext);
    this.updateZoneOperationCallable =
        callableFactory.createOperationCallable(
            updateZoneTransportSettings,
            settings.updateZoneOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteZoneCallable =
        callableFactory.createUnaryCallable(
            deleteZoneTransportSettings, settings.deleteZoneSettings(), clientContext);
    this.deleteZoneOperationCallable =
        callableFactory.createOperationCallable(
            deleteZoneTransportSettings,
            settings.deleteZoneOperationSettings(),
            clientContext,
            operationsStub);
    this.signalZoneStateCallable =
        callableFactory.createUnaryCallable(
            signalZoneStateTransportSettings, settings.signalZoneStateSettings(), clientContext);
    this.signalZoneStateOperationCallable =
        callableFactory.createOperationCallable(
            signalZoneStateTransportSettings,
            settings.signalZoneStateOperationSettings(),
            clientContext,
            operationsStub);
    this.requestOrderDateChangeCallable =
        callableFactory.createUnaryCallable(
            requestOrderDateChangeTransportSettings,
            settings.requestOrderDateChangeSettings(),
            clientContext);
    this.requestOrderDateChangeOperationCallable =
        callableFactory.createOperationCallable(
            requestOrderDateChangeTransportSettings,
            settings.requestOrderDateChangeOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    return listOrdersCallable;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    return listOrdersPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return getOrderCallable;
  }

  @Override
  public UnaryCallable<CreateOrderRequest, Operation> createOrderCallable() {
    return createOrderCallable;
  }

  @Override
  public OperationCallable<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationCallable() {
    return createOrderOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateOrderRequest, Operation> updateOrderCallable() {
    return updateOrderCallable;
  }

  @Override
  public OperationCallable<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationCallable() {
    return updateOrderOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOrderRequest, Operation> deleteOrderCallable() {
    return deleteOrderCallable;
  }

  @Override
  public OperationCallable<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationCallable() {
    return deleteOrderOperationCallable;
  }

  @Override
  public UnaryCallable<SubmitOrderRequest, Operation> submitOrderCallable() {
    return submitOrderCallable;
  }

  @Override
  public OperationCallable<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationCallable() {
    return submitOrderOperationCallable;
  }

  @Override
  public UnaryCallable<CancelOrderRequest, Operation> cancelOrderCallable() {
    return cancelOrderCallable;
  }

  @Override
  public OperationCallable<CancelOrderRequest, Order, OperationMetadata>
      cancelOrderOperationCallable() {
    return cancelOrderOperationCallable;
  }

  @Override
  public UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    return listSitesCallable;
  }

  @Override
  public UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    return listSitesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    return getSiteCallable;
  }

  @Override
  public UnaryCallable<CreateSiteRequest, Operation> createSiteCallable() {
    return createSiteCallable;
  }

  @Override
  public OperationCallable<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationCallable() {
    return createSiteOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSiteRequest, Operation> updateSiteCallable() {
    return updateSiteCallable;
  }

  @Override
  public OperationCallable<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationCallable() {
    return updateSiteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSiteRequest, Operation> deleteSiteCallable() {
    return deleteSiteCallable;
  }

  @Override
  public OperationCallable<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationCallable() {
    return deleteSiteOperationCallable;
  }

  @Override
  public UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsCallable() {
    return listHardwareGroupsCallable;
  }

  @Override
  public UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsPagedResponse>
      listHardwareGroupsPagedCallable() {
    return listHardwareGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupCallable() {
    return getHardwareGroupCallable;
  }

  @Override
  public UnaryCallable<CreateHardwareGroupRequest, Operation> createHardwareGroupCallable() {
    return createHardwareGroupCallable;
  }

  @Override
  public OperationCallable<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationCallable() {
    return createHardwareGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHardwareGroupRequest, Operation> updateHardwareGroupCallable() {
    return updateHardwareGroupCallable;
  }

  @Override
  public OperationCallable<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationCallable() {
    return updateHardwareGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupCallable() {
    return deleteHardwareGroupCallable;
  }

  @Override
  public OperationCallable<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationCallable() {
    return deleteHardwareGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListHardwareRequest, ListHardwareResponse> listHardwareCallable() {
    return listHardwareCallable;
  }

  @Override
  public UnaryCallable<ListHardwareRequest, ListHardwarePagedResponse> listHardwarePagedCallable() {
    return listHardwarePagedCallable;
  }

  @Override
  public UnaryCallable<GetHardwareRequest, Hardware> getHardwareCallable() {
    return getHardwareCallable;
  }

  @Override
  public UnaryCallable<CreateHardwareRequest, Operation> createHardwareCallable() {
    return createHardwareCallable;
  }

  @Override
  public OperationCallable<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationCallable() {
    return createHardwareOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHardwareRequest, Operation> updateHardwareCallable() {
    return updateHardwareCallable;
  }

  @Override
  public OperationCallable<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationCallable() {
    return updateHardwareOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHardwareRequest, Operation> deleteHardwareCallable() {
    return deleteHardwareCallable;
  }

  @Override
  public OperationCallable<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationCallable() {
    return deleteHardwareOperationCallable;
  }

  @Override
  public UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    return listCommentsCallable;
  }

  @Override
  public UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse> listCommentsPagedCallable() {
    return listCommentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCommentRequest, Comment> getCommentCallable() {
    return getCommentCallable;
  }

  @Override
  public UnaryCallable<CreateCommentRequest, Operation> createCommentCallable() {
    return createCommentCallable;
  }

  @Override
  public OperationCallable<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationCallable() {
    return createCommentOperationCallable;
  }

  @Override
  public UnaryCallable<RecordActionOnCommentRequest, Comment> recordActionOnCommentCallable() {
    return recordActionOnCommentCallable;
  }

  @Override
  public UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesCallable() {
    return listChangeLogEntriesCallable;
  }

  @Override
  public UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesPagedCallable() {
    return listChangeLogEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryCallable() {
    return getChangeLogEntryCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return listSkusCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return listSkusPagedCallable;
  }

  @Override
  public UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    return getSkuCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    return listZonesCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return listZonesPagedCallable;
  }

  @Override
  public UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    return getZoneCallable;
  }

  @Override
  public UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    return createZoneCallable;
  }

  @Override
  public OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    return createZoneOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    return updateZoneCallable;
  }

  @Override
  public OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    return updateZoneOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    return deleteZoneCallable;
  }

  @Override
  public OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    return deleteZoneOperationCallable;
  }

  @Override
  public UnaryCallable<SignalZoneStateRequest, Operation> signalZoneStateCallable() {
    return signalZoneStateCallable;
  }

  @Override
  public OperationCallable<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationCallable() {
    return signalZoneStateOperationCallable;
  }

  @Override
  public UnaryCallable<RequestOrderDateChangeRequest, Operation> requestOrderDateChangeCallable() {
    return requestOrderDateChangeCallable;
  }

  @Override
  public OperationCallable<RequestOrderDateChangeRequest, Order, OperationMetadata>
      requestOrderDateChangeOperationCallable() {
    return requestOrderDateChangeOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
