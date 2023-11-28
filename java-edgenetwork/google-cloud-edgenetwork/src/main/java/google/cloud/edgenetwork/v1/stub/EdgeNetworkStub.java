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

package google.cloud.edgenetwork.v1.stub;

import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectAttachmentsPagedResponse;
import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectsPagedResponse;
import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListLocationsPagedResponse;
import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListNetworksPagedResponse;
import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListRoutersPagedResponse;
import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListSubnetsPagedResponse;
import static google.cloud.edgenetwork.v1.EdgeNetworkClient.ListZonesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest;
import google.cloud.edgenetwork.v1.CreateNetworkRequest;
import google.cloud.edgenetwork.v1.CreateRouterRequest;
import google.cloud.edgenetwork.v1.CreateSubnetRequest;
import google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest;
import google.cloud.edgenetwork.v1.DeleteNetworkRequest;
import google.cloud.edgenetwork.v1.DeleteRouterRequest;
import google.cloud.edgenetwork.v1.DeleteSubnetRequest;
import google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest;
import google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse;
import google.cloud.edgenetwork.v1.DiagnoseNetworkRequest;
import google.cloud.edgenetwork.v1.DiagnoseNetworkResponse;
import google.cloud.edgenetwork.v1.DiagnoseRouterRequest;
import google.cloud.edgenetwork.v1.DiagnoseRouterResponse;
import google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest;
import google.cloud.edgenetwork.v1.GetInterconnectRequest;
import google.cloud.edgenetwork.v1.GetNetworkRequest;
import google.cloud.edgenetwork.v1.GetRouterRequest;
import google.cloud.edgenetwork.v1.GetSubnetRequest;
import google.cloud.edgenetwork.v1.GetZoneRequest;
import google.cloud.edgenetwork.v1.InitializeZoneRequest;
import google.cloud.edgenetwork.v1.InitializeZoneResponse;
import google.cloud.edgenetwork.v1.Interconnect;
import google.cloud.edgenetwork.v1.InterconnectAttachment;
import google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest;
import google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse;
import google.cloud.edgenetwork.v1.ListInterconnectsRequest;
import google.cloud.edgenetwork.v1.ListInterconnectsResponse;
import google.cloud.edgenetwork.v1.ListNetworksRequest;
import google.cloud.edgenetwork.v1.ListNetworksResponse;
import google.cloud.edgenetwork.v1.ListRoutersRequest;
import google.cloud.edgenetwork.v1.ListRoutersResponse;
import google.cloud.edgenetwork.v1.ListSubnetsRequest;
import google.cloud.edgenetwork.v1.ListSubnetsResponse;
import google.cloud.edgenetwork.v1.ListZonesRequest;
import google.cloud.edgenetwork.v1.ListZonesResponse;
import google.cloud.edgenetwork.v1.Network;
import google.cloud.edgenetwork.v1.OperationMetadata;
import google.cloud.edgenetwork.v1.Router;
import google.cloud.edgenetwork.v1.Subnet;
import google.cloud.edgenetwork.v1.UpdateRouterRequest;
import google.cloud.edgenetwork.v1.UpdateSubnetRequest;
import google.cloud.edgenetwork.v1.Zone;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EdgeNetwork service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EdgeNetworkStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<InitializeZoneRequest, InitializeZoneResponse> initializeZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: initializeZoneCallable()");
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

  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksPagedCallable()");
  }

  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksCallable()");
  }

  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkCallable()");
  }

  public UnaryCallable<DiagnoseNetworkRequest, DiagnoseNetworkResponse> diagnoseNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseNetworkCallable()");
  }

  public OperationCallable<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createNetworkOperationCallable()");
  }

  public UnaryCallable<CreateNetworkRequest, Operation> createNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: createNetworkCallable()");
  }

  public OperationCallable<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNetworkOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkRequest, Operation> deleteNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNetworkCallable()");
  }

  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubnetsPagedCallable()");
  }

  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubnetsCallable()");
  }

  public UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: getSubnetCallable()");
  }

  public OperationCallable<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubnetOperationCallable()");
  }

  public UnaryCallable<CreateSubnetRequest, Operation> createSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubnetCallable()");
  }

  public OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubnetOperationCallable()");
  }

  public UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubnetCallable()");
  }

  public OperationCallable<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubnetOperationCallable()");
  }

  public UnaryCallable<DeleteSubnetRequest, Operation> deleteSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubnetCallable()");
  }

  public UnaryCallable<ListInterconnectsRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInterconnectsPagedCallable()");
  }

  public UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInterconnectsCallable()");
  }

  public UnaryCallable<GetInterconnectRequest, Interconnect> getInterconnectCallable() {
    throw new UnsupportedOperationException("Not implemented: getInterconnectCallable()");
  }

  public UnaryCallable<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseInterconnectCallable()");
  }

  public UnaryCallable<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterconnectAttachmentsPagedCallable()");
  }

  public UnaryCallable<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterconnectAttachmentsCallable()");
  }

  public UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getInterconnectAttachmentCallable()");
  }

  public OperationCallable<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterconnectAttachmentOperationCallable()");
  }

  public UnaryCallable<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterconnectAttachmentCallable()");
  }

  public OperationCallable<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterconnectAttachmentOperationCallable()");
  }

  public UnaryCallable<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterconnectAttachmentCallable()");
  }

  public UnaryCallable<ListRoutersRequest, ListRoutersPagedResponse> listRoutersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutersPagedCallable()");
  }

  public UnaryCallable<ListRoutersRequest, ListRoutersResponse> listRoutersCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutersCallable()");
  }

  public UnaryCallable<GetRouterRequest, Router> getRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouterCallable()");
  }

  public UnaryCallable<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseRouterCallable()");
  }

  public OperationCallable<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRouterOperationCallable()");
  }

  public UnaryCallable<CreateRouterRequest, Operation> createRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: createRouterCallable()");
  }

  public OperationCallable<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRouterOperationCallable()");
  }

  public UnaryCallable<UpdateRouterRequest, Operation> updateRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRouterCallable()");
  }

  public OperationCallable<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRouterOperationCallable()");
  }

  public UnaryCallable<DeleteRouterRequest, Operation> deleteRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRouterCallable()");
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
