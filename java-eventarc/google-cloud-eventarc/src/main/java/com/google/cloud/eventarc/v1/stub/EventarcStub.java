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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListGoogleApiSourcesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListPipelinesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.eventarc.v1.Channel;
import com.google.cloud.eventarc.v1.ChannelConnection;
import com.google.cloud.eventarc.v1.CreateChannelConnectionRequest;
import com.google.cloud.eventarc.v1.CreateChannelRequest;
import com.google.cloud.eventarc.v1.CreateEnrollmentRequest;
import com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.CreateMessageBusRequest;
import com.google.cloud.eventarc.v1.CreatePipelineRequest;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest;
import com.google.cloud.eventarc.v1.DeleteChannelRequest;
import com.google.cloud.eventarc.v1.DeleteEnrollmentRequest;
import com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.DeleteMessageBusRequest;
import com.google.cloud.eventarc.v1.DeletePipelineRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.Enrollment;
import com.google.cloud.eventarc.v1.GetChannelConnectionRequest;
import com.google.cloud.eventarc.v1.GetChannelRequest;
import com.google.cloud.eventarc.v1.GetEnrollmentRequest;
import com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.GetMessageBusRequest;
import com.google.cloud.eventarc.v1.GetPipelineRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.GoogleApiSource;
import com.google.cloud.eventarc.v1.GoogleChannelConfig;
import com.google.cloud.eventarc.v1.ListChannelConnectionsRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsResponse;
import com.google.cloud.eventarc.v1.ListChannelsRequest;
import com.google.cloud.eventarc.v1.ListChannelsResponse;
import com.google.cloud.eventarc.v1.ListEnrollmentsRequest;
import com.google.cloud.eventarc.v1.ListEnrollmentsResponse;
import com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest;
import com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse;
import com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest;
import com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse;
import com.google.cloud.eventarc.v1.ListMessageBusesRequest;
import com.google.cloud.eventarc.v1.ListMessageBusesResponse;
import com.google.cloud.eventarc.v1.ListPipelinesRequest;
import com.google.cloud.eventarc.v1.ListPipelinesResponse;
import com.google.cloud.eventarc.v1.ListProvidersRequest;
import com.google.cloud.eventarc.v1.ListProvidersResponse;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.MessageBus;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Pipeline;
import com.google.cloud.eventarc.v1.Provider;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateChannelRequest;
import com.google.cloud.eventarc.v1.UpdateEnrollmentRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.UpdateMessageBusRequest;
import com.google.cloud.eventarc.v1.UpdatePipelineRequest;
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

  public UnaryCallable<GetMessageBusRequest, MessageBus> getMessageBusCallable() {
    throw new UnsupportedOperationException("Not implemented: getMessageBusCallable()");
  }

  public UnaryCallable<ListMessageBusesRequest, ListMessageBusesPagedResponse>
      listMessageBusesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessageBusesPagedCallable()");
  }

  public UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessageBusesCallable()");
  }

  public UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMessageBusEnrollmentsPagedCallable()");
  }

  public UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessageBusEnrollmentsCallable()");
  }

  public OperationCallable<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMessageBusOperationCallable()");
  }

  public UnaryCallable<CreateMessageBusRequest, Operation> createMessageBusCallable() {
    throw new UnsupportedOperationException("Not implemented: createMessageBusCallable()");
  }

  public OperationCallable<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMessageBusOperationCallable()");
  }

  public UnaryCallable<UpdateMessageBusRequest, Operation> updateMessageBusCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMessageBusCallable()");
  }

  public OperationCallable<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMessageBusOperationCallable()");
  }

  public UnaryCallable<DeleteMessageBusRequest, Operation> deleteMessageBusCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMessageBusCallable()");
  }

  public UnaryCallable<GetEnrollmentRequest, Enrollment> getEnrollmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnrollmentCallable()");
  }

  public UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsPagedResponse>
      listEnrollmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnrollmentsPagedCallable()");
  }

  public UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse> listEnrollmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnrollmentsCallable()");
  }

  public OperationCallable<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEnrollmentOperationCallable()");
  }

  public UnaryCallable<CreateEnrollmentRequest, Operation> createEnrollmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createEnrollmentCallable()");
  }

  public OperationCallable<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEnrollmentOperationCallable()");
  }

  public UnaryCallable<UpdateEnrollmentRequest, Operation> updateEnrollmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEnrollmentCallable()");
  }

  public OperationCallable<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEnrollmentOperationCallable()");
  }

  public UnaryCallable<DeleteEnrollmentRequest, Operation> deleteEnrollmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEnrollmentCallable()");
  }

  public UnaryCallable<GetPipelineRequest, Pipeline> getPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: getPipelineCallable()");
  }

  public UnaryCallable<ListPipelinesRequest, ListPipelinesPagedResponse>
      listPipelinesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPipelinesPagedCallable()");
  }

  public UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> listPipelinesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPipelinesCallable()");
  }

  public OperationCallable<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createPipelineOperationCallable()");
  }

  public UnaryCallable<CreatePipelineRequest, Operation> createPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: createPipelineCallable()");
  }

  public OperationCallable<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePipelineOperationCallable()");
  }

  public UnaryCallable<UpdatePipelineRequest, Operation> updatePipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePipelineCallable()");
  }

  public OperationCallable<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePipelineOperationCallable()");
  }

  public UnaryCallable<DeletePipelineRequest, Operation> deletePipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePipelineCallable()");
  }

  public UnaryCallable<GetGoogleApiSourceRequest, GoogleApiSource> getGoogleApiSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getGoogleApiSourceCallable()");
  }

  public UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGoogleApiSourcesPagedCallable()");
  }

  public UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listGoogleApiSourcesCallable()");
  }

  public OperationCallable<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGoogleApiSourceOperationCallable()");
  }

  public UnaryCallable<CreateGoogleApiSourceRequest, Operation> createGoogleApiSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createGoogleApiSourceCallable()");
  }

  public OperationCallable<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGoogleApiSourceOperationCallable()");
  }

  public UnaryCallable<UpdateGoogleApiSourceRequest, Operation> updateGoogleApiSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGoogleApiSourceCallable()");
  }

  public OperationCallable<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGoogleApiSourceOperationCallable()");
  }

  public UnaryCallable<DeleteGoogleApiSourceRequest, Operation> deleteGoogleApiSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGoogleApiSourceCallable()");
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
