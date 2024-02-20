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

package com.google.cloud.edgenetwork.v1.stub;

import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListLocationsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListNetworksPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListRoutersPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListSubnetsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListZonesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.CreateNetworkRequest;
import com.google.cloud.edgenetwork.v1.CreateRouterRequest;
import com.google.cloud.edgenetwork.v1.CreateSubnetRequest;
import com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.DeleteNetworkRequest;
import com.google.cloud.edgenetwork.v1.DeleteRouterRequest;
import com.google.cloud.edgenetwork.v1.DeleteSubnetRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse;
import com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse;
import com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.GetInterconnectRequest;
import com.google.cloud.edgenetwork.v1.GetNetworkRequest;
import com.google.cloud.edgenetwork.v1.GetRouterRequest;
import com.google.cloud.edgenetwork.v1.GetSubnetRequest;
import com.google.cloud.edgenetwork.v1.GetZoneRequest;
import com.google.cloud.edgenetwork.v1.InitializeZoneRequest;
import com.google.cloud.edgenetwork.v1.InitializeZoneResponse;
import com.google.cloud.edgenetwork.v1.Interconnect;
import com.google.cloud.edgenetwork.v1.InterconnectAttachment;
import com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest;
import com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse;
import com.google.cloud.edgenetwork.v1.ListInterconnectsRequest;
import com.google.cloud.edgenetwork.v1.ListInterconnectsResponse;
import com.google.cloud.edgenetwork.v1.ListNetworksRequest;
import com.google.cloud.edgenetwork.v1.ListNetworksResponse;
import com.google.cloud.edgenetwork.v1.ListRoutersRequest;
import com.google.cloud.edgenetwork.v1.ListRoutersResponse;
import com.google.cloud.edgenetwork.v1.ListSubnetsRequest;
import com.google.cloud.edgenetwork.v1.ListSubnetsResponse;
import com.google.cloud.edgenetwork.v1.ListZonesRequest;
import com.google.cloud.edgenetwork.v1.ListZonesResponse;
import com.google.cloud.edgenetwork.v1.Network;
import com.google.cloud.edgenetwork.v1.OperationMetadata;
import com.google.cloud.edgenetwork.v1.Router;
import com.google.cloud.edgenetwork.v1.Subnet;
import com.google.cloud.edgenetwork.v1.UpdateRouterRequest;
import com.google.cloud.edgenetwork.v1.UpdateSubnetRequest;
import com.google.cloud.edgenetwork.v1.Zone;
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
 * gRPC stub implementation for the EdgeNetwork service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEdgeNetworkStub extends EdgeNetworkStub {
  private static final MethodDescriptor<InitializeZoneRequest, InitializeZoneResponse>
      initializeZoneMethodDescriptor =
          MethodDescriptor.<InitializeZoneRequest, InitializeZoneResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/InitializeZone")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InitializeZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InitializeZoneResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListZonesRequest, ListZonesResponse>
      listZonesMethodDescriptor =
          MethodDescriptor.<ListZonesRequest, ListZonesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListZones")
              .setRequestMarshaller(ProtoUtils.marshaller(ListZonesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListZonesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetZoneRequest, Zone> getZoneMethodDescriptor =
      MethodDescriptor.<GetZoneRequest, Zone>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetZone")
          .setRequestMarshaller(ProtoUtils.marshaller(GetZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Zone.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListNetworksRequest, ListNetworksResponse>
      listNetworksMethodDescriptor =
          MethodDescriptor.<ListNetworksRequest, ListNetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListNetworks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNetworksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNetworkRequest, Network> getNetworkMethodDescriptor =
      MethodDescriptor.<GetNetworkRequest, Network>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetNetwork")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNetworkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Network.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkMethodDescriptor =
          MethodDescriptor.<DiagnoseNetworkRequest, DiagnoseNetworkResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DiagnoseNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiagnoseNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DiagnoseNetworkResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNetworkRequest, Operation>
      createNetworkMethodDescriptor =
          MethodDescriptor.<CreateNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/CreateNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNetworkRequest, Operation>
      deleteNetworkMethodDescriptor =
          MethodDescriptor.<DeleteNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DeleteNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSubnetsRequest, ListSubnetsResponse>
      listSubnetsMethodDescriptor =
          MethodDescriptor.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListSubnets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSubnetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubnetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSubnetRequest, Subnet> getSubnetMethodDescriptor =
      MethodDescriptor.<GetSubnetRequest, Subnet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetSubnet")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSubnetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Subnet.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSubnetRequest, Operation>
      createSubnetMethodDescriptor =
          MethodDescriptor.<CreateSubnetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/CreateSubnet")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSubnetRequest, Operation>
      updateSubnetMethodDescriptor =
          MethodDescriptor.<UpdateSubnetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/UpdateSubnet")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSubnetRequest, Operation>
      deleteSubnetMethodDescriptor =
          MethodDescriptor.<DeleteSubnetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DeleteSubnet")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsMethodDescriptor =
          MethodDescriptor.<ListInterconnectsRequest, ListInterconnectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListInterconnects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInterconnectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInterconnectsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInterconnectRequest, Interconnect>
      getInterconnectMethodDescriptor =
          MethodDescriptor.<GetInterconnectRequest, Interconnect>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetInterconnect")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInterconnectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Interconnect.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectMethodDescriptor =
          MethodDescriptor.<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DiagnoseInterconnect")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiagnoseInterconnectRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DiagnoseInterconnectResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsMethodDescriptor =
          MethodDescriptor
              .<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/ListInterconnectAttachments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInterconnectAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInterconnectAttachmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentMethodDescriptor =
          MethodDescriptor.<GetInterconnectAttachmentRequest, InterconnectAttachment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/GetInterconnectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInterconnectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InterconnectAttachment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentMethodDescriptor =
          MethodDescriptor.<CreateInterconnectAttachmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/CreateInterconnectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInterconnectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentMethodDescriptor =
          MethodDescriptor.<DeleteInterconnectAttachmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/DeleteInterconnectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInterconnectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRoutersRequest, ListRoutersResponse>
      listRoutersMethodDescriptor =
          MethodDescriptor.<ListRoutersRequest, ListRoutersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListRouters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRoutersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRoutersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRouterRequest, Router> getRouterMethodDescriptor =
      MethodDescriptor.<GetRouterRequest, Router>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetRouter")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRouterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Router.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DiagnoseRouterRequest, DiagnoseRouterResponse>
      diagnoseRouterMethodDescriptor =
          MethodDescriptor.<DiagnoseRouterRequest, DiagnoseRouterResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DiagnoseRouter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiagnoseRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DiagnoseRouterResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRouterRequest, Operation>
      createRouterMethodDescriptor =
          MethodDescriptor.<CreateRouterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/CreateRouter")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRouterRequest, Operation>
      updateRouterMethodDescriptor =
          MethodDescriptor.<UpdateRouterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/UpdateRouter")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRouterRequest, Operation>
      deleteRouterMethodDescriptor =
          MethodDescriptor.<DeleteRouterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DeleteRouter")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<InitializeZoneRequest, InitializeZoneResponse> initializeZoneCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable;
  private final UnaryCallable<GetZoneRequest, Zone> getZoneCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable;
  private final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable;
  private final UnaryCallable<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkCallable;
  private final UnaryCallable<CreateNetworkRequest, Operation> createNetworkCallable;
  private final OperationCallable<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationCallable;
  private final UnaryCallable<DeleteNetworkRequest, Operation> deleteNetworkCallable;
  private final OperationCallable<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable;
  private final UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable;
  private final UnaryCallable<CreateSubnetRequest, Operation> createSubnetCallable;
  private final OperationCallable<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationCallable;
  private final UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable;
  private final OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable;
  private final UnaryCallable<DeleteSubnetRequest, Operation> deleteSubnetCallable;
  private final OperationCallable<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationCallable;
  private final UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsCallable;
  private final UnaryCallable<ListInterconnectsRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable;
  private final UnaryCallable<GetInterconnectRequest, Interconnect> getInterconnectCallable;
  private final UnaryCallable<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectCallable;
  private final UnaryCallable<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsCallable;
  private final UnaryCallable<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable;
  private final UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable;
  private final UnaryCallable<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentCallable;
  private final OperationCallable<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationCallable;
  private final UnaryCallable<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentCallable;
  private final OperationCallable<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationCallable;
  private final UnaryCallable<ListRoutersRequest, ListRoutersResponse> listRoutersCallable;
  private final UnaryCallable<ListRoutersRequest, ListRoutersPagedResponse>
      listRoutersPagedCallable;
  private final UnaryCallable<GetRouterRequest, Router> getRouterCallable;
  private final UnaryCallable<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterCallable;
  private final UnaryCallable<CreateRouterRequest, Operation> createRouterCallable;
  private final OperationCallable<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationCallable;
  private final UnaryCallable<UpdateRouterRequest, Operation> updateRouterCallable;
  private final OperationCallable<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationCallable;
  private final UnaryCallable<DeleteRouterRequest, Operation> deleteRouterCallable;
  private final OperationCallable<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEdgeNetworkStub create(EdgeNetworkStubSettings settings)
      throws IOException {
    return new GrpcEdgeNetworkStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEdgeNetworkStub create(ClientContext clientContext) throws IOException {
    return new GrpcEdgeNetworkStub(EdgeNetworkStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEdgeNetworkStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEdgeNetworkStub(
        EdgeNetworkStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEdgeNetworkStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEdgeNetworkStub(EdgeNetworkStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEdgeNetworkCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEdgeNetworkStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEdgeNetworkStub(
      EdgeNetworkStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<InitializeZoneRequest, InitializeZoneResponse>
        initializeZoneTransportSettings =
            GrpcCallSettings.<InitializeZoneRequest, InitializeZoneResponse>newBuilder()
                .setMethodDescriptor(initializeZoneMethodDescriptor)
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
    GrpcCallSettings<ListNetworksRequest, ListNetworksResponse> listNetworksTransportSettings =
        GrpcCallSettings.<ListNetworksRequest, ListNetworksResponse>newBuilder()
            .setMethodDescriptor(listNetworksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNetworkRequest, Network> getNetworkTransportSettings =
        GrpcCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
        diagnoseNetworkTransportSettings =
            GrpcCallSettings.<DiagnoseNetworkRequest, DiagnoseNetworkResponse>newBuilder()
                .setMethodDescriptor(diagnoseNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateNetworkRequest, Operation> createNetworkTransportSettings =
        GrpcCallSettings.<CreateNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(createNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteNetworkRequest, Operation> deleteNetworkTransportSettings =
        GrpcCallSettings.<DeleteNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSubnetsRequest, ListSubnetsResponse> listSubnetsTransportSettings =
        GrpcCallSettings.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
            .setMethodDescriptor(listSubnetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSubnetRequest, Subnet> getSubnetTransportSettings =
        GrpcCallSettings.<GetSubnetRequest, Subnet>newBuilder()
            .setMethodDescriptor(getSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSubnetRequest, Operation> createSubnetTransportSettings =
        GrpcCallSettings.<CreateSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(createSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSubnetRequest, Operation> updateSubnetTransportSettings =
        GrpcCallSettings.<UpdateSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subnet.name", String.valueOf(request.getSubnet().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSubnetRequest, Operation> deleteSubnetTransportSettings =
        GrpcCallSettings.<DeleteSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListInterconnectsRequest, ListInterconnectsResponse>
        listInterconnectsTransportSettings =
            GrpcCallSettings.<ListInterconnectsRequest, ListInterconnectsResponse>newBuilder()
                .setMethodDescriptor(listInterconnectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetInterconnectRequest, Interconnect> getInterconnectTransportSettings =
        GrpcCallSettings.<GetInterconnectRequest, Interconnect>newBuilder()
            .setMethodDescriptor(getInterconnectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
        diagnoseInterconnectTransportSettings =
            GrpcCallSettings.<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>newBuilder()
                .setMethodDescriptor(diagnoseInterconnectMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
        listInterconnectAttachmentsTransportSettings =
            GrpcCallSettings
                .<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
                    newBuilder()
                .setMethodDescriptor(listInterconnectAttachmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetInterconnectAttachmentRequest, InterconnectAttachment>
        getInterconnectAttachmentTransportSettings =
            GrpcCallSettings.<GetInterconnectAttachmentRequest, InterconnectAttachment>newBuilder()
                .setMethodDescriptor(getInterconnectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateInterconnectAttachmentRequest, Operation>
        createInterconnectAttachmentTransportSettings =
            GrpcCallSettings.<CreateInterconnectAttachmentRequest, Operation>newBuilder()
                .setMethodDescriptor(createInterconnectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteInterconnectAttachmentRequest, Operation>
        deleteInterconnectAttachmentTransportSettings =
            GrpcCallSettings.<DeleteInterconnectAttachmentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterconnectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListRoutersRequest, ListRoutersResponse> listRoutersTransportSettings =
        GrpcCallSettings.<ListRoutersRequest, ListRoutersResponse>newBuilder()
            .setMethodDescriptor(listRoutersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRouterRequest, Router> getRouterTransportSettings =
        GrpcCallSettings.<GetRouterRequest, Router>newBuilder()
            .setMethodDescriptor(getRouterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DiagnoseRouterRequest, DiagnoseRouterResponse>
        diagnoseRouterTransportSettings =
            GrpcCallSettings.<DiagnoseRouterRequest, DiagnoseRouterResponse>newBuilder()
                .setMethodDescriptor(diagnoseRouterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateRouterRequest, Operation> createRouterTransportSettings =
        GrpcCallSettings.<CreateRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(createRouterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRouterRequest, Operation> updateRouterTransportSettings =
        GrpcCallSettings.<UpdateRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRouterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("router.name", String.valueOf(request.getRouter().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRouterRequest, Operation> deleteRouterTransportSettings =
        GrpcCallSettings.<DeleteRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRouterMethodDescriptor)
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

    this.initializeZoneCallable =
        callableFactory.createUnaryCallable(
            initializeZoneTransportSettings, settings.initializeZoneSettings(), clientContext);
    this.listZonesCallable =
        callableFactory.createUnaryCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.listZonesPagedCallable =
        callableFactory.createPagedCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.getZoneCallable =
        callableFactory.createUnaryCallable(
            getZoneTransportSettings, settings.getZoneSettings(), clientContext);
    this.listNetworksCallable =
        callableFactory.createUnaryCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.listNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.getNetworkCallable =
        callableFactory.createUnaryCallable(
            getNetworkTransportSettings, settings.getNetworkSettings(), clientContext);
    this.diagnoseNetworkCallable =
        callableFactory.createUnaryCallable(
            diagnoseNetworkTransportSettings, settings.diagnoseNetworkSettings(), clientContext);
    this.createNetworkCallable =
        callableFactory.createUnaryCallable(
            createNetworkTransportSettings, settings.createNetworkSettings(), clientContext);
    this.createNetworkOperationCallable =
        callableFactory.createOperationCallable(
            createNetworkTransportSettings,
            settings.createNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteNetworkCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkTransportSettings, settings.deleteNetworkSettings(), clientContext);
    this.deleteNetworkOperationCallable =
        callableFactory.createOperationCallable(
            deleteNetworkTransportSettings,
            settings.deleteNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.listSubnetsCallable =
        callableFactory.createUnaryCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.getSubnetCallable =
        callableFactory.createUnaryCallable(
            getSubnetTransportSettings, settings.getSubnetSettings(), clientContext);
    this.createSubnetCallable =
        callableFactory.createUnaryCallable(
            createSubnetTransportSettings, settings.createSubnetSettings(), clientContext);
    this.createSubnetOperationCallable =
        callableFactory.createOperationCallable(
            createSubnetTransportSettings,
            settings.createSubnetOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSubnetCallable =
        callableFactory.createUnaryCallable(
            updateSubnetTransportSettings, settings.updateSubnetSettings(), clientContext);
    this.updateSubnetOperationCallable =
        callableFactory.createOperationCallable(
            updateSubnetTransportSettings,
            settings.updateSubnetOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSubnetCallable =
        callableFactory.createUnaryCallable(
            deleteSubnetTransportSettings, settings.deleteSubnetSettings(), clientContext);
    this.deleteSubnetOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubnetTransportSettings,
            settings.deleteSubnetOperationSettings(),
            clientContext,
            operationsStub);
    this.listInterconnectsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectsTransportSettings,
            settings.listInterconnectsSettings(),
            clientContext);
    this.listInterconnectsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectsTransportSettings,
            settings.listInterconnectsSettings(),
            clientContext);
    this.getInterconnectCallable =
        callableFactory.createUnaryCallable(
            getInterconnectTransportSettings, settings.getInterconnectSettings(), clientContext);
    this.diagnoseInterconnectCallable =
        callableFactory.createUnaryCallable(
            diagnoseInterconnectTransportSettings,
            settings.diagnoseInterconnectSettings(),
            clientContext);
    this.listInterconnectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectAttachmentsTransportSettings,
            settings.listInterconnectAttachmentsSettings(),
            clientContext);
    this.listInterconnectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectAttachmentsTransportSettings,
            settings.listInterconnectAttachmentsSettings(),
            clientContext);
    this.getInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            getInterconnectAttachmentTransportSettings,
            settings.getInterconnectAttachmentSettings(),
            clientContext);
    this.createInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            createInterconnectAttachmentTransportSettings,
            settings.createInterconnectAttachmentSettings(),
            clientContext);
    this.createInterconnectAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            createInterconnectAttachmentTransportSettings,
            settings.createInterconnectAttachmentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteInterconnectAttachmentTransportSettings,
            settings.deleteInterconnectAttachmentSettings(),
            clientContext);
    this.deleteInterconnectAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteInterconnectAttachmentTransportSettings,
            settings.deleteInterconnectAttachmentOperationSettings(),
            clientContext,
            operationsStub);
    this.listRoutersCallable =
        callableFactory.createUnaryCallable(
            listRoutersTransportSettings, settings.listRoutersSettings(), clientContext);
    this.listRoutersPagedCallable =
        callableFactory.createPagedCallable(
            listRoutersTransportSettings, settings.listRoutersSettings(), clientContext);
    this.getRouterCallable =
        callableFactory.createUnaryCallable(
            getRouterTransportSettings, settings.getRouterSettings(), clientContext);
    this.diagnoseRouterCallable =
        callableFactory.createUnaryCallable(
            diagnoseRouterTransportSettings, settings.diagnoseRouterSettings(), clientContext);
    this.createRouterCallable =
        callableFactory.createUnaryCallable(
            createRouterTransportSettings, settings.createRouterSettings(), clientContext);
    this.createRouterOperationCallable =
        callableFactory.createOperationCallable(
            createRouterTransportSettings,
            settings.createRouterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRouterCallable =
        callableFactory.createUnaryCallable(
            updateRouterTransportSettings, settings.updateRouterSettings(), clientContext);
    this.updateRouterOperationCallable =
        callableFactory.createOperationCallable(
            updateRouterTransportSettings,
            settings.updateRouterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRouterCallable =
        callableFactory.createUnaryCallable(
            deleteRouterTransportSettings, settings.deleteRouterSettings(), clientContext);
    this.deleteRouterOperationCallable =
        callableFactory.createOperationCallable(
            deleteRouterTransportSettings,
            settings.deleteRouterOperationSettings(),
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
  public UnaryCallable<InitializeZoneRequest, InitializeZoneResponse> initializeZoneCallable() {
    return initializeZoneCallable;
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
  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return listNetworksCallable;
  }

  @Override
  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    return listNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return getNetworkCallable;
  }

  @Override
  public UnaryCallable<DiagnoseNetworkRequest, DiagnoseNetworkResponse> diagnoseNetworkCallable() {
    return diagnoseNetworkCallable;
  }

  @Override
  public UnaryCallable<CreateNetworkRequest, Operation> createNetworkCallable() {
    return createNetworkCallable;
  }

  @Override
  public OperationCallable<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationCallable() {
    return createNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkRequest, Operation> deleteNetworkCallable() {
    return deleteNetworkCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationCallable() {
    return deleteNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return listSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    return listSubnetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    return getSubnetCallable;
  }

  @Override
  public UnaryCallable<CreateSubnetRequest, Operation> createSubnetCallable() {
    return createSubnetCallable;
  }

  @Override
  public OperationCallable<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationCallable() {
    return createSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    return updateSubnetCallable;
  }

  @Override
  public OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    return updateSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSubnetRequest, Operation> deleteSubnetCallable() {
    return deleteSubnetCallable;
  }

  @Override
  public OperationCallable<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationCallable() {
    return deleteSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsCallable() {
    return listInterconnectsCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectsRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    return listInterconnectsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterconnectRequest, Interconnect> getInterconnectCallable() {
    return getInterconnectCallable;
  }

  @Override
  public UnaryCallable<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectCallable() {
    return diagnoseInterconnectCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsCallable() {
    return listInterconnectAttachmentsCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable() {
    return listInterconnectAttachmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable() {
    return getInterconnectAttachmentCallable;
  }

  @Override
  public UnaryCallable<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentCallable() {
    return createInterconnectAttachmentCallable;
  }

  @Override
  public OperationCallable<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationCallable() {
    return createInterconnectAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentCallable() {
    return deleteInterconnectAttachmentCallable;
  }

  @Override
  public OperationCallable<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationCallable() {
    return deleteInterconnectAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<ListRoutersRequest, ListRoutersResponse> listRoutersCallable() {
    return listRoutersCallable;
  }

  @Override
  public UnaryCallable<ListRoutersRequest, ListRoutersPagedResponse> listRoutersPagedCallable() {
    return listRoutersPagedCallable;
  }

  @Override
  public UnaryCallable<GetRouterRequest, Router> getRouterCallable() {
    return getRouterCallable;
  }

  @Override
  public UnaryCallable<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterCallable() {
    return diagnoseRouterCallable;
  }

  @Override
  public UnaryCallable<CreateRouterRequest, Operation> createRouterCallable() {
    return createRouterCallable;
  }

  @Override
  public OperationCallable<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationCallable() {
    return createRouterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRouterRequest, Operation> updateRouterCallable() {
    return updateRouterCallable;
  }

  @Override
  public OperationCallable<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationCallable() {
    return updateRouterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRouterRequest, Operation> deleteRouterCallable() {
    return deleteRouterCallable;
  }

  @Override
  public OperationCallable<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationCallable() {
    return deleteRouterOperationCallable;
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
