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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.eventarc.v1.Channel;
import com.google.cloud.eventarc.v1.ChannelConnection;
import com.google.cloud.eventarc.v1.CreateChannelConnectionRequest;
import com.google.cloud.eventarc.v1.CreateChannelRequest;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest;
import com.google.cloud.eventarc.v1.DeleteChannelRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.GetChannelConnectionRequest;
import com.google.cloud.eventarc.v1.GetChannelRequest;
import com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.GoogleChannelConfig;
import com.google.cloud.eventarc.v1.ListChannelConnectionsRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsResponse;
import com.google.cloud.eventarc.v1.ListChannelsRequest;
import com.google.cloud.eventarc.v1.ListChannelsResponse;
import com.google.cloud.eventarc.v1.ListProvidersRequest;
import com.google.cloud.eventarc.v1.ListProvidersResponse;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Provider;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateChannelRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.UpdateTriggerRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Eventarc service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EventarcStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: getTriggerCallable()");
  }

  public UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse> listTriggersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTriggersPagedCallable()");
  }

  public UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    throw new UnsupportedOperationException("Not implemented: listTriggersCallable()");
  }

  public OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTriggerOperationCallable()");
  }

  public UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: createTriggerCallable()");
  }

  public OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTriggerOperationCallable()");
  }

  public UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTriggerCallable()");
  }

  public OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTriggerOperationCallable()");
  }

  public UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTriggerCallable()");
  }

  public UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: getChannelCallable()");
  }

  public UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse> listChannelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelsPagedCallable()");
  }

  public UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelsCallable()");
  }

  public OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelOperationCallable()");
  }

  public UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelCallable()");
  }

  public OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChannelOperationCallable()");
  }

  public UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChannelCallable()");
  }

  public OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteChannelOperationCallable()");
  }

  public UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteChannelCallable()");
  }

  public UnaryCallable<GetProviderRequest, Provider> getProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: getProviderCallable()");
  }

  public UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProvidersPagedCallable()");
  }

  public UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable() {
    throw new UnsupportedOperationException("Not implemented: listProvidersCallable()");
  }

  public UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getChannelConnectionCallable()");
  }

  public UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listChannelConnectionsPagedCallable()");
  }

  public UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelConnectionsCallable()");
  }

  public OperationCallable<CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createChannelConnectionOperationCallable()");
  }

  public UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelConnectionCallable()");
  }

  public OperationCallable<DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteChannelConnectionOperationCallable()");
  }

  public UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteChannelConnectionCallable()");
  }

  public UnaryCallable<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getGoogleChannelConfigCallable()");
  }

  public UnaryCallable<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGoogleChannelConfigCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
