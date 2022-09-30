/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.datastream.v1alpha1.stub;

import static com.google.cloud.datastream.v1alpha1.DatastreamClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListRoutesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListStreamsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datastream.v1alpha1.ConnectionProfile;
import com.google.cloud.datastream.v1alpha1.CreateConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.CreatePrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.CreateRouteRequest;
import com.google.cloud.datastream.v1alpha1.CreateStreamRequest;
import com.google.cloud.datastream.v1alpha1.DeleteConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.DeletePrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.DeleteRouteRequest;
import com.google.cloud.datastream.v1alpha1.DeleteStreamRequest;
import com.google.cloud.datastream.v1alpha1.DiscoverConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.DiscoverConnectionProfileResponse;
import com.google.cloud.datastream.v1alpha1.FetchErrorsRequest;
import com.google.cloud.datastream.v1alpha1.FetchErrorsResponse;
import com.google.cloud.datastream.v1alpha1.FetchStaticIpsRequest;
import com.google.cloud.datastream.v1alpha1.FetchStaticIpsResponse;
import com.google.cloud.datastream.v1alpha1.GetConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.GetPrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.GetRouteRequest;
import com.google.cloud.datastream.v1alpha1.GetStreamRequest;
import com.google.cloud.datastream.v1alpha1.ListConnectionProfilesRequest;
import com.google.cloud.datastream.v1alpha1.ListConnectionProfilesResponse;
import com.google.cloud.datastream.v1alpha1.ListPrivateConnectionsRequest;
import com.google.cloud.datastream.v1alpha1.ListPrivateConnectionsResponse;
import com.google.cloud.datastream.v1alpha1.ListRoutesRequest;
import com.google.cloud.datastream.v1alpha1.ListRoutesResponse;
import com.google.cloud.datastream.v1alpha1.ListStreamsRequest;
import com.google.cloud.datastream.v1alpha1.ListStreamsResponse;
import com.google.cloud.datastream.v1alpha1.OperationMetadata;
import com.google.cloud.datastream.v1alpha1.PrivateConnection;
import com.google.cloud.datastream.v1alpha1.Route;
import com.google.cloud.datastream.v1alpha1.Stream;
import com.google.cloud.datastream.v1alpha1.UpdateConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.UpdateStreamRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Datastream service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DatastreamStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConnectionProfilesPagedCallable()");
  }

  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionProfilesCallable()");
  }

  public UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectionProfileCallable()");
  }

  public OperationCallable<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConnectionProfileOperationCallable()");
  }

  public UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionProfileCallable()");
  }

  public OperationCallable<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConnectionProfileOperationCallable()");
  }

  public UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionProfileCallable()");
  }

  public OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConnectionProfileOperationCallable()");
  }

  public UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionProfileCallable()");
  }

  public UnaryCallable<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: discoverConnectionProfileCallable()");
  }

  public UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse> listStreamsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listStreamsPagedCallable()");
  }

  public UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listStreamsCallable()");
  }

  public UnaryCallable<GetStreamRequest, Stream> getStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getStreamCallable()");
  }

  public OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createStreamOperationCallable()");
  }

  public UnaryCallable<CreateStreamRequest, Operation> createStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createStreamCallable()");
  }

  public OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateStreamOperationCallable()");
  }

  public UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateStreamCallable()");
  }

  public OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStreamOperationCallable()");
  }

  public UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStreamCallable()");
  }

  public OperationCallable<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
      fetchErrorsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchErrorsOperationCallable()");
  }

  public UnaryCallable<FetchErrorsRequest, Operation> fetchErrorsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchErrorsCallable()");
  }

  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchStaticIpsPagedCallable()");
  }

  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchStaticIpsCallable()");
  }

  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrivateConnectionOperationCallable()");
  }

  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateConnectionCallable()");
  }

  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateConnectionCallable()");
  }

  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateConnectionsPagedCallable()");
  }

  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateConnectionsCallable()");
  }

  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrivateConnectionOperationCallable()");
  }

  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePrivateConnectionCallable()");
  }

  public OperationCallable<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRouteOperationCallable()");
  }

  public UnaryCallable<CreateRouteRequest, Operation> createRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: createRouteCallable()");
  }

  public UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouteCallable()");
  }

  public UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutesPagedCallable()");
  }

  public UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutesCallable()");
  }

  public OperationCallable<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRouteOperationCallable()");
  }

  public UnaryCallable<DeleteRouteRequest, Operation> deleteRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRouteCallable()");
  }

  @Override
  public abstract void close();
}
