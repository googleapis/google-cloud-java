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

package com.google.cloud.video.livestream.v1.stub;

import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListChannelsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListEventsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListInputsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.video.livestream.v1.Asset;
import com.google.cloud.video.livestream.v1.Channel;
import com.google.cloud.video.livestream.v1.ChannelOperationResponse;
import com.google.cloud.video.livestream.v1.CreateAssetRequest;
import com.google.cloud.video.livestream.v1.CreateChannelRequest;
import com.google.cloud.video.livestream.v1.CreateEventRequest;
import com.google.cloud.video.livestream.v1.CreateInputRequest;
import com.google.cloud.video.livestream.v1.DeleteAssetRequest;
import com.google.cloud.video.livestream.v1.DeleteChannelRequest;
import com.google.cloud.video.livestream.v1.DeleteEventRequest;
import com.google.cloud.video.livestream.v1.DeleteInputRequest;
import com.google.cloud.video.livestream.v1.Event;
import com.google.cloud.video.livestream.v1.GetAssetRequest;
import com.google.cloud.video.livestream.v1.GetChannelRequest;
import com.google.cloud.video.livestream.v1.GetEventRequest;
import com.google.cloud.video.livestream.v1.GetInputRequest;
import com.google.cloud.video.livestream.v1.GetPoolRequest;
import com.google.cloud.video.livestream.v1.Input;
import com.google.cloud.video.livestream.v1.ListAssetsRequest;
import com.google.cloud.video.livestream.v1.ListAssetsResponse;
import com.google.cloud.video.livestream.v1.ListChannelsRequest;
import com.google.cloud.video.livestream.v1.ListChannelsResponse;
import com.google.cloud.video.livestream.v1.ListEventsRequest;
import com.google.cloud.video.livestream.v1.ListEventsResponse;
import com.google.cloud.video.livestream.v1.ListInputsRequest;
import com.google.cloud.video.livestream.v1.ListInputsResponse;
import com.google.cloud.video.livestream.v1.OperationMetadata;
import com.google.cloud.video.livestream.v1.Pool;
import com.google.cloud.video.livestream.v1.StartChannelRequest;
import com.google.cloud.video.livestream.v1.StopChannelRequest;
import com.google.cloud.video.livestream.v1.UpdateChannelRequest;
import com.google.cloud.video.livestream.v1.UpdateInputRequest;
import com.google.cloud.video.livestream.v1.UpdatePoolRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LivestreamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LivestreamServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelOperationCallable()");
  }

  public UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelCallable()");
  }

  public UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse> listChannelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelsPagedCallable()");
  }

  public UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelsCallable()");
  }

  public UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: getChannelCallable()");
  }

  public OperationCallable<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteChannelOperationCallable()");
  }

  public UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteChannelCallable()");
  }

  public OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChannelOperationCallable()");
  }

  public UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChannelCallable()");
  }

  public OperationCallable<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startChannelOperationCallable()");
  }

  public UnaryCallable<StartChannelRequest, Operation> startChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: startChannelCallable()");
  }

  public OperationCallable<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopChannelOperationCallable()");
  }

  public UnaryCallable<StopChannelRequest, Operation> stopChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: stopChannelCallable()");
  }

  public OperationCallable<CreateInputRequest, Input, OperationMetadata>
      createInputOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInputOperationCallable()");
  }

  public UnaryCallable<CreateInputRequest, Operation> createInputCallable() {
    throw new UnsupportedOperationException("Not implemented: createInputCallable()");
  }

  public UnaryCallable<ListInputsRequest, ListInputsPagedResponse> listInputsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInputsPagedCallable()");
  }

  public UnaryCallable<ListInputsRequest, ListInputsResponse> listInputsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInputsCallable()");
  }

  public UnaryCallable<GetInputRequest, Input> getInputCallable() {
    throw new UnsupportedOperationException("Not implemented: getInputCallable()");
  }

  public OperationCallable<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInputOperationCallable()");
  }

  public UnaryCallable<DeleteInputRequest, Operation> deleteInputCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInputCallable()");
  }

  public OperationCallable<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInputOperationCallable()");
  }

  public UnaryCallable<UpdateInputRequest, Operation> updateInputCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInputCallable()");
  }

  public UnaryCallable<CreateEventRequest, Event> createEventCallable() {
    throw new UnsupportedOperationException("Not implemented: createEventCallable()");
  }

  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventsPagedCallable()");
  }

  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventsCallable()");
  }

  public UnaryCallable<GetEventRequest, Event> getEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getEventCallable()");
  }

  public UnaryCallable<DeleteEventRequest, Empty> deleteEventCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEventCallable()");
  }

  public OperationCallable<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssetOperationCallable()");
  }

  public UnaryCallable<CreateAssetRequest, Operation> createAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssetCallable()");
  }

  public OperationCallable<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetOperationCallable()");
  }

  public UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetCallable()");
  }

  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssetCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsPagedCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsCallable()");
  }

  public UnaryCallable<GetPoolRequest, Pool> getPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getPoolCallable()");
  }

  public OperationCallable<UpdatePoolRequest, Pool, OperationMetadata>
      updatePoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePoolOperationCallable()");
  }

  public UnaryCallable<UpdatePoolRequest, Operation> updatePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePoolCallable()");
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
