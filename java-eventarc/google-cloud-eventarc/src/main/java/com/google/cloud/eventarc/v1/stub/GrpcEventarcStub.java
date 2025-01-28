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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Eventarc service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEventarcStub extends EventarcStub {
  private static final MethodDescriptor<GetTriggerRequest, Trigger> getTriggerMethodDescriptor =
      MethodDescriptor.<GetTriggerRequest, Trigger>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetTrigger")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTriggerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trigger.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTriggersRequest, ListTriggersResponse>
      listTriggersMethodDescriptor =
          MethodDescriptor.<ListTriggersRequest, ListTriggersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListTriggers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTriggersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTriggersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTriggerRequest, Operation>
      createTriggerMethodDescriptor =
          MethodDescriptor.<CreateTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTriggerRequest, Operation>
      updateTriggerMethodDescriptor =
          MethodDescriptor.<UpdateTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTriggerRequest, Operation>
      deleteTriggerMethodDescriptor =
          MethodDescriptor.<DeleteTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelRequest, Channel> getChannelMethodDescriptor =
      MethodDescriptor.<GetChannelRequest, Channel>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetChannel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetChannelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Channel.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListChannelsRequest, ListChannelsResponse>
      listChannelsMethodDescriptor =
          MethodDescriptor.<ListChannelsRequest, ListChannelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListChannels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateChannelRequest, Operation>
      createChannelMethodDescriptor =
          MethodDescriptor.<CreateChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateChannelRequest, Operation>
      updateChannelMethodDescriptor =
          MethodDescriptor.<UpdateChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteChannelRequest, Operation>
      deleteChannelMethodDescriptor =
          MethodDescriptor.<DeleteChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProviderRequest, Provider> getProviderMethodDescriptor =
      MethodDescriptor.<GetProviderRequest, Provider>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetProvider")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProviderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Provider.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProvidersRequest, ListProvidersResponse>
      listProvidersMethodDescriptor =
          MethodDescriptor.<ListProvidersRequest, ListProvidersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListProviders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProvidersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionMethodDescriptor =
          MethodDescriptor.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetChannelConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetChannelConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsMethodDescriptor =
          MethodDescriptor
              .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListChannelConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChannelConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateChannelConnectionRequest, Operation>
      createChannelConnectionMethodDescriptor =
          MethodDescriptor.<CreateChannelConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateChannelConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionMethodDescriptor =
          MethodDescriptor.<DeleteChannelConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteChannelConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteChannelConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigMethodDescriptor =
          MethodDescriptor.<GetGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetGoogleChannelConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGoogleChannelConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GoogleChannelConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigMethodDescriptor =
          MethodDescriptor.<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateGoogleChannelConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGoogleChannelConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GoogleChannelConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMessageBusRequest, MessageBus>
      getMessageBusMethodDescriptor =
          MethodDescriptor.<GetMessageBusRequest, MessageBus>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetMessageBus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMessageBusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MessageBus.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesMethodDescriptor =
          MethodDescriptor.<ListMessageBusesRequest, ListMessageBusesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListMessageBuses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMessageBusesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMessageBusesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsMethodDescriptor =
          MethodDescriptor
              .<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListMessageBusEnrollments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMessageBusEnrollmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMessageBusEnrollmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMessageBusRequest, Operation>
      createMessageBusMethodDescriptor =
          MethodDescriptor.<CreateMessageBusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateMessageBus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMessageBusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMessageBusRequest, Operation>
      updateMessageBusMethodDescriptor =
          MethodDescriptor.<UpdateMessageBusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateMessageBus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMessageBusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMessageBusRequest, Operation>
      deleteMessageBusMethodDescriptor =
          MethodDescriptor.<DeleteMessageBusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteMessageBus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMessageBusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEnrollmentRequest, Enrollment>
      getEnrollmentMethodDescriptor =
          MethodDescriptor.<GetEnrollmentRequest, Enrollment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetEnrollment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Enrollment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEnrollmentsRequest, ListEnrollmentsResponse>
      listEnrollmentsMethodDescriptor =
          MethodDescriptor.<ListEnrollmentsRequest, ListEnrollmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListEnrollments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEnrollmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnrollmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEnrollmentRequest, Operation>
      createEnrollmentMethodDescriptor =
          MethodDescriptor.<CreateEnrollmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateEnrollment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEnrollmentRequest, Operation>
      updateEnrollmentMethodDescriptor =
          MethodDescriptor.<UpdateEnrollmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateEnrollment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEnrollmentRequest, Operation>
      deleteEnrollmentMethodDescriptor =
          MethodDescriptor.<DeleteEnrollmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteEnrollment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPipelineRequest, Pipeline> getPipelineMethodDescriptor =
      MethodDescriptor.<GetPipelineRequest, Pipeline>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetPipeline")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPipelineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Pipeline.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListPipelinesRequest, ListPipelinesResponse>
      listPipelinesMethodDescriptor =
          MethodDescriptor.<ListPipelinesRequest, ListPipelinesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListPipelines")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPipelinesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPipelinesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePipelineRequest, Operation>
      createPipelineMethodDescriptor =
          MethodDescriptor.<CreatePipelineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreatePipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePipelineRequest, Operation>
      updatePipelineMethodDescriptor =
          MethodDescriptor.<UpdatePipelineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdatePipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePipelineRequest, Operation>
      deletePipelineMethodDescriptor =
          MethodDescriptor.<DeletePipelineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeletePipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceMethodDescriptor =
          MethodDescriptor.<GetGoogleApiSourceRequest, GoogleApiSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetGoogleApiSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGoogleApiSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GoogleApiSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesMethodDescriptor =
          MethodDescriptor.<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListGoogleApiSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGoogleApiSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGoogleApiSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceMethodDescriptor =
          MethodDescriptor.<CreateGoogleApiSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateGoogleApiSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGoogleApiSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceMethodDescriptor =
          MethodDescriptor.<UpdateGoogleApiSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateGoogleApiSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGoogleApiSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceMethodDescriptor =
          MethodDescriptor.<DeleteGoogleApiSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteGoogleApiSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGoogleApiSourceRequest.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable;
  private final UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable;
  private final UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse>
      listTriggersPagedCallable;
  private final UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable;
  private final OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable;
  private final UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable;
  private final OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable;
  private final UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable;
  private final OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable;
  private final UnaryCallable<GetChannelRequest, Channel> getChannelCallable;
  private final UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable;
  private final UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse>
      listChannelsPagedCallable;
  private final UnaryCallable<CreateChannelRequest, Operation> createChannelCallable;
  private final OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable;
  private final UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable;
  private final OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable;
  private final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable;
  private final OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable;
  private final UnaryCallable<GetProviderRequest, Provider> getProviderCallable;
  private final UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable;
  private final UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable;
  private final UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable;
  private final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable;
  private final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable;
  private final UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable;
  private final OperationCallable<
          CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable;
  private final UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable;
  private final OperationCallable<
          DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable;
  private final UnaryCallable<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigCallable;
  private final UnaryCallable<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigCallable;
  private final UnaryCallable<GetMessageBusRequest, MessageBus> getMessageBusCallable;
  private final UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesCallable;
  private final UnaryCallable<ListMessageBusesRequest, ListMessageBusesPagedResponse>
      listMessageBusesPagedCallable;
  private final UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsCallable;
  private final UnaryCallable<
          ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsPagedCallable;
  private final UnaryCallable<CreateMessageBusRequest, Operation> createMessageBusCallable;
  private final OperationCallable<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationCallable;
  private final UnaryCallable<UpdateMessageBusRequest, Operation> updateMessageBusCallable;
  private final OperationCallable<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationCallable;
  private final UnaryCallable<DeleteMessageBusRequest, Operation> deleteMessageBusCallable;
  private final OperationCallable<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationCallable;
  private final UnaryCallable<GetEnrollmentRequest, Enrollment> getEnrollmentCallable;
  private final UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse>
      listEnrollmentsCallable;
  private final UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsPagedResponse>
      listEnrollmentsPagedCallable;
  private final UnaryCallable<CreateEnrollmentRequest, Operation> createEnrollmentCallable;
  private final OperationCallable<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationCallable;
  private final UnaryCallable<UpdateEnrollmentRequest, Operation> updateEnrollmentCallable;
  private final OperationCallable<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationCallable;
  private final UnaryCallable<DeleteEnrollmentRequest, Operation> deleteEnrollmentCallable;
  private final OperationCallable<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationCallable;
  private final UnaryCallable<GetPipelineRequest, Pipeline> getPipelineCallable;
  private final UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> listPipelinesCallable;
  private final UnaryCallable<ListPipelinesRequest, ListPipelinesPagedResponse>
      listPipelinesPagedCallable;
  private final UnaryCallable<CreatePipelineRequest, Operation> createPipelineCallable;
  private final OperationCallable<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationCallable;
  private final UnaryCallable<UpdatePipelineRequest, Operation> updatePipelineCallable;
  private final OperationCallable<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationCallable;
  private final UnaryCallable<DeletePipelineRequest, Operation> deletePipelineCallable;
  private final OperationCallable<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationCallable;
  private final UnaryCallable<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceCallable;
  private final UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesCallable;
  private final UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesPagedCallable;
  private final UnaryCallable<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceCallable;
  private final OperationCallable<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationCallable;
  private final UnaryCallable<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceCallable;
  private final OperationCallable<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationCallable;
  private final UnaryCallable<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceCallable;
  private final OperationCallable<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEventarcStub create(EventarcStubSettings settings) throws IOException {
    return new GrpcEventarcStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEventarcStub create(ClientContext clientContext) throws IOException {
    return new GrpcEventarcStub(EventarcStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEventarcStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEventarcStub(
        EventarcStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEventarcStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEventarcStub(EventarcStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEventarcCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEventarcStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEventarcStub(
      EventarcStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetTriggerRequest, Trigger> getTriggerTransportSettings =
        GrpcCallSettings.<GetTriggerRequest, Trigger>newBuilder()
            .setMethodDescriptor(getTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTriggersRequest, ListTriggersResponse> listTriggersTransportSettings =
        GrpcCallSettings.<ListTriggersRequest, ListTriggersResponse>newBuilder()
            .setMethodDescriptor(listTriggersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTriggerRequest, Operation> createTriggerTransportSettings =
        GrpcCallSettings.<CreateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(createTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTriggerRequest, Operation> updateTriggerTransportSettings =
        GrpcCallSettings.<UpdateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("trigger.name", String.valueOf(request.getTrigger().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTriggerRequest, Operation> deleteTriggerTransportSettings =
        GrpcCallSettings.<DeleteTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetChannelRequest, Channel> getChannelTransportSettings =
        GrpcCallSettings.<GetChannelRequest, Channel>newBuilder()
            .setMethodDescriptor(getChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListChannelsRequest, ListChannelsResponse> listChannelsTransportSettings =
        GrpcCallSettings.<ListChannelsRequest, ListChannelsResponse>newBuilder()
            .setMethodDescriptor(listChannelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateChannelRequest, Operation> createChannelTransportSettings =
        GrpcCallSettings.<CreateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(createChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateChannelRequest, Operation> updateChannelTransportSettings =
        GrpcCallSettings.<UpdateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("channel.name", String.valueOf(request.getChannel().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteChannelRequest, Operation> deleteChannelTransportSettings =
        GrpcCallSettings.<DeleteChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetProviderRequest, Provider> getProviderTransportSettings =
        GrpcCallSettings.<GetProviderRequest, Provider>newBuilder()
            .setMethodDescriptor(getProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProvidersRequest, ListProvidersResponse> listProvidersTransportSettings =
        GrpcCallSettings.<ListProvidersRequest, ListProvidersResponse>newBuilder()
            .setMethodDescriptor(listProvidersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionTransportSettings =
            GrpcCallSettings.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
                .setMethodDescriptor(getChannelConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
        listChannelConnectionsTransportSettings =
            GrpcCallSettings
                .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
                .setMethodDescriptor(listChannelConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateChannelConnectionRequest, Operation>
        createChannelConnectionTransportSettings =
            GrpcCallSettings.<CreateChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createChannelConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionTransportSettings =
            GrpcCallSettings.<DeleteChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteChannelConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGoogleChannelConfigRequest, GoogleChannelConfig>
        getGoogleChannelConfigTransportSettings =
            GrpcCallSettings.<GetGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
                .setMethodDescriptor(getGoogleChannelConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
        updateGoogleChannelConfigTransportSettings =
            GrpcCallSettings.<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
                .setMethodDescriptor(updateGoogleChannelConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_channel_config.name",
                          String.valueOf(request.getGoogleChannelConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMessageBusRequest, MessageBus> getMessageBusTransportSettings =
        GrpcCallSettings.<GetMessageBusRequest, MessageBus>newBuilder()
            .setMethodDescriptor(getMessageBusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMessageBusesRequest, ListMessageBusesResponse>
        listMessageBusesTransportSettings =
            GrpcCallSettings.<ListMessageBusesRequest, ListMessageBusesResponse>newBuilder()
                .setMethodDescriptor(listMessageBusesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
        listMessageBusEnrollmentsTransportSettings =
            GrpcCallSettings
                .<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>newBuilder()
                .setMethodDescriptor(listMessageBusEnrollmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMessageBusRequest, Operation> createMessageBusTransportSettings =
        GrpcCallSettings.<CreateMessageBusRequest, Operation>newBuilder()
            .setMethodDescriptor(createMessageBusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMessageBusRequest, Operation> updateMessageBusTransportSettings =
        GrpcCallSettings.<UpdateMessageBusRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMessageBusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "message_bus.name", String.valueOf(request.getMessageBus().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMessageBusRequest, Operation> deleteMessageBusTransportSettings =
        GrpcCallSettings.<DeleteMessageBusRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMessageBusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEnrollmentRequest, Enrollment> getEnrollmentTransportSettings =
        GrpcCallSettings.<GetEnrollmentRequest, Enrollment>newBuilder()
            .setMethodDescriptor(getEnrollmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEnrollmentsRequest, ListEnrollmentsResponse>
        listEnrollmentsTransportSettings =
            GrpcCallSettings.<ListEnrollmentsRequest, ListEnrollmentsResponse>newBuilder()
                .setMethodDescriptor(listEnrollmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateEnrollmentRequest, Operation> createEnrollmentTransportSettings =
        GrpcCallSettings.<CreateEnrollmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnrollmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEnrollmentRequest, Operation> updateEnrollmentTransportSettings =
        GrpcCallSettings.<UpdateEnrollmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnrollmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("enrollment.name", String.valueOf(request.getEnrollment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEnrollmentRequest, Operation> deleteEnrollmentTransportSettings =
        GrpcCallSettings.<DeleteEnrollmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnrollmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPipelineRequest, Pipeline> getPipelineTransportSettings =
        GrpcCallSettings.<GetPipelineRequest, Pipeline>newBuilder()
            .setMethodDescriptor(getPipelineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPipelinesRequest, ListPipelinesResponse> listPipelinesTransportSettings =
        GrpcCallSettings.<ListPipelinesRequest, ListPipelinesResponse>newBuilder()
            .setMethodDescriptor(listPipelinesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePipelineRequest, Operation> createPipelineTransportSettings =
        GrpcCallSettings.<CreatePipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(createPipelineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePipelineRequest, Operation> updatePipelineTransportSettings =
        GrpcCallSettings.<UpdatePipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePipelineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("pipeline.name", String.valueOf(request.getPipeline().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePipelineRequest, Operation> deletePipelineTransportSettings =
        GrpcCallSettings.<DeletePipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePipelineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGoogleApiSourceRequest, GoogleApiSource>
        getGoogleApiSourceTransportSettings =
            GrpcCallSettings.<GetGoogleApiSourceRequest, GoogleApiSource>newBuilder()
                .setMethodDescriptor(getGoogleApiSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
        listGoogleApiSourcesTransportSettings =
            GrpcCallSettings.<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>newBuilder()
                .setMethodDescriptor(listGoogleApiSourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateGoogleApiSourceRequest, Operation>
        createGoogleApiSourceTransportSettings =
            GrpcCallSettings.<CreateGoogleApiSourceRequest, Operation>newBuilder()
                .setMethodDescriptor(createGoogleApiSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGoogleApiSourceRequest, Operation>
        updateGoogleApiSourceTransportSettings =
            GrpcCallSettings.<UpdateGoogleApiSourceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGoogleApiSourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_api_source.name",
                          String.valueOf(request.getGoogleApiSource().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGoogleApiSourceRequest, Operation>
        deleteGoogleApiSourceTransportSettings =
            GrpcCallSettings.<DeleteGoogleApiSourceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGoogleApiSourceMethodDescriptor)
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.getTriggerCallable =
        callableFactory.createUnaryCallable(
            getTriggerTransportSettings, settings.getTriggerSettings(), clientContext);
    this.listTriggersCallable =
        callableFactory.createUnaryCallable(
            listTriggersTransportSettings, settings.listTriggersSettings(), clientContext);
    this.listTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listTriggersTransportSettings, settings.listTriggersSettings(), clientContext);
    this.createTriggerCallable =
        callableFactory.createUnaryCallable(
            createTriggerTransportSettings, settings.createTriggerSettings(), clientContext);
    this.createTriggerOperationCallable =
        callableFactory.createOperationCallable(
            createTriggerTransportSettings,
            settings.createTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTriggerCallable =
        callableFactory.createUnaryCallable(
            updateTriggerTransportSettings, settings.updateTriggerSettings(), clientContext);
    this.updateTriggerOperationCallable =
        callableFactory.createOperationCallable(
            updateTriggerTransportSettings,
            settings.updateTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteTriggerTransportSettings, settings.deleteTriggerSettings(), clientContext);
    this.deleteTriggerOperationCallable =
        callableFactory.createOperationCallable(
            deleteTriggerTransportSettings,
            settings.deleteTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.getChannelCallable =
        callableFactory.createUnaryCallable(
            getChannelTransportSettings, settings.getChannelSettings(), clientContext);
    this.listChannelsCallable =
        callableFactory.createUnaryCallable(
            listChannelsTransportSettings, settings.listChannelsSettings(), clientContext);
    this.listChannelsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelsTransportSettings, settings.listChannelsSettings(), clientContext);
    this.createChannelCallable =
        callableFactory.createUnaryCallable(
            createChannelTransportSettings, settings.createChannelSettings(), clientContext);
    this.createChannelOperationCallable =
        callableFactory.createOperationCallable(
            createChannelTransportSettings,
            settings.createChannelOperationSettings(),
            clientContext,
            operationsStub);
    this.updateChannelCallable =
        callableFactory.createUnaryCallable(
            updateChannelTransportSettings, settings.updateChannelSettings(), clientContext);
    this.updateChannelOperationCallable =
        callableFactory.createOperationCallable(
            updateChannelTransportSettings,
            settings.updateChannelOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteChannelCallable =
        callableFactory.createUnaryCallable(
            deleteChannelTransportSettings, settings.deleteChannelSettings(), clientContext);
    this.deleteChannelOperationCallable =
        callableFactory.createOperationCallable(
            deleteChannelTransportSettings,
            settings.deleteChannelOperationSettings(),
            clientContext,
            operationsStub);
    this.getProviderCallable =
        callableFactory.createUnaryCallable(
            getProviderTransportSettings, settings.getProviderSettings(), clientContext);
    this.listProvidersCallable =
        callableFactory.createUnaryCallable(
            listProvidersTransportSettings, settings.listProvidersSettings(), clientContext);
    this.listProvidersPagedCallable =
        callableFactory.createPagedCallable(
            listProvidersTransportSettings, settings.listProvidersSettings(), clientContext);
    this.getChannelConnectionCallable =
        callableFactory.createUnaryCallable(
            getChannelConnectionTransportSettings,
            settings.getChannelConnectionSettings(),
            clientContext);
    this.listChannelConnectionsCallable =
        callableFactory.createUnaryCallable(
            listChannelConnectionsTransportSettings,
            settings.listChannelConnectionsSettings(),
            clientContext);
    this.listChannelConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelConnectionsTransportSettings,
            settings.listChannelConnectionsSettings(),
            clientContext);
    this.createChannelConnectionCallable =
        callableFactory.createUnaryCallable(
            createChannelConnectionTransportSettings,
            settings.createChannelConnectionSettings(),
            clientContext);
    this.createChannelConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createChannelConnectionTransportSettings,
            settings.createChannelConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteChannelConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteChannelConnectionTransportSettings,
            settings.deleteChannelConnectionSettings(),
            clientContext);
    this.deleteChannelConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteChannelConnectionTransportSettings,
            settings.deleteChannelConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.getGoogleChannelConfigCallable =
        callableFactory.createUnaryCallable(
            getGoogleChannelConfigTransportSettings,
            settings.getGoogleChannelConfigSettings(),
            clientContext);
    this.updateGoogleChannelConfigCallable =
        callableFactory.createUnaryCallable(
            updateGoogleChannelConfigTransportSettings,
            settings.updateGoogleChannelConfigSettings(),
            clientContext);
    this.getMessageBusCallable =
        callableFactory.createUnaryCallable(
            getMessageBusTransportSettings, settings.getMessageBusSettings(), clientContext);
    this.listMessageBusesCallable =
        callableFactory.createUnaryCallable(
            listMessageBusesTransportSettings, settings.listMessageBusesSettings(), clientContext);
    this.listMessageBusesPagedCallable =
        callableFactory.createPagedCallable(
            listMessageBusesTransportSettings, settings.listMessageBusesSettings(), clientContext);
    this.listMessageBusEnrollmentsCallable =
        callableFactory.createUnaryCallable(
            listMessageBusEnrollmentsTransportSettings,
            settings.listMessageBusEnrollmentsSettings(),
            clientContext);
    this.listMessageBusEnrollmentsPagedCallable =
        callableFactory.createPagedCallable(
            listMessageBusEnrollmentsTransportSettings,
            settings.listMessageBusEnrollmentsSettings(),
            clientContext);
    this.createMessageBusCallable =
        callableFactory.createUnaryCallable(
            createMessageBusTransportSettings, settings.createMessageBusSettings(), clientContext);
    this.createMessageBusOperationCallable =
        callableFactory.createOperationCallable(
            createMessageBusTransportSettings,
            settings.createMessageBusOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMessageBusCallable =
        callableFactory.createUnaryCallable(
            updateMessageBusTransportSettings, settings.updateMessageBusSettings(), clientContext);
    this.updateMessageBusOperationCallable =
        callableFactory.createOperationCallable(
            updateMessageBusTransportSettings,
            settings.updateMessageBusOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMessageBusCallable =
        callableFactory.createUnaryCallable(
            deleteMessageBusTransportSettings, settings.deleteMessageBusSettings(), clientContext);
    this.deleteMessageBusOperationCallable =
        callableFactory.createOperationCallable(
            deleteMessageBusTransportSettings,
            settings.deleteMessageBusOperationSettings(),
            clientContext,
            operationsStub);
    this.getEnrollmentCallable =
        callableFactory.createUnaryCallable(
            getEnrollmentTransportSettings, settings.getEnrollmentSettings(), clientContext);
    this.listEnrollmentsCallable =
        callableFactory.createUnaryCallable(
            listEnrollmentsTransportSettings, settings.listEnrollmentsSettings(), clientContext);
    this.listEnrollmentsPagedCallable =
        callableFactory.createPagedCallable(
            listEnrollmentsTransportSettings, settings.listEnrollmentsSettings(), clientContext);
    this.createEnrollmentCallable =
        callableFactory.createUnaryCallable(
            createEnrollmentTransportSettings, settings.createEnrollmentSettings(), clientContext);
    this.createEnrollmentOperationCallable =
        callableFactory.createOperationCallable(
            createEnrollmentTransportSettings,
            settings.createEnrollmentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEnrollmentCallable =
        callableFactory.createUnaryCallable(
            updateEnrollmentTransportSettings, settings.updateEnrollmentSettings(), clientContext);
    this.updateEnrollmentOperationCallable =
        callableFactory.createOperationCallable(
            updateEnrollmentTransportSettings,
            settings.updateEnrollmentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEnrollmentCallable =
        callableFactory.createUnaryCallable(
            deleteEnrollmentTransportSettings, settings.deleteEnrollmentSettings(), clientContext);
    this.deleteEnrollmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteEnrollmentTransportSettings,
            settings.deleteEnrollmentOperationSettings(),
            clientContext,
            operationsStub);
    this.getPipelineCallable =
        callableFactory.createUnaryCallable(
            getPipelineTransportSettings, settings.getPipelineSettings(), clientContext);
    this.listPipelinesCallable =
        callableFactory.createUnaryCallable(
            listPipelinesTransportSettings, settings.listPipelinesSettings(), clientContext);
    this.listPipelinesPagedCallable =
        callableFactory.createPagedCallable(
            listPipelinesTransportSettings, settings.listPipelinesSettings(), clientContext);
    this.createPipelineCallable =
        callableFactory.createUnaryCallable(
            createPipelineTransportSettings, settings.createPipelineSettings(), clientContext);
    this.createPipelineOperationCallable =
        callableFactory.createOperationCallable(
            createPipelineTransportSettings,
            settings.createPipelineOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePipelineCallable =
        callableFactory.createUnaryCallable(
            updatePipelineTransportSettings, settings.updatePipelineSettings(), clientContext);
    this.updatePipelineOperationCallable =
        callableFactory.createOperationCallable(
            updatePipelineTransportSettings,
            settings.updatePipelineOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePipelineCallable =
        callableFactory.createUnaryCallable(
            deletePipelineTransportSettings, settings.deletePipelineSettings(), clientContext);
    this.deletePipelineOperationCallable =
        callableFactory.createOperationCallable(
            deletePipelineTransportSettings,
            settings.deletePipelineOperationSettings(),
            clientContext,
            operationsStub);
    this.getGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            getGoogleApiSourceTransportSettings,
            settings.getGoogleApiSourceSettings(),
            clientContext);
    this.listGoogleApiSourcesCallable =
        callableFactory.createUnaryCallable(
            listGoogleApiSourcesTransportSettings,
            settings.listGoogleApiSourcesSettings(),
            clientContext);
    this.listGoogleApiSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listGoogleApiSourcesTransportSettings,
            settings.listGoogleApiSourcesSettings(),
            clientContext);
    this.createGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            createGoogleApiSourceTransportSettings,
            settings.createGoogleApiSourceSettings(),
            clientContext);
    this.createGoogleApiSourceOperationCallable =
        callableFactory.createOperationCallable(
            createGoogleApiSourceTransportSettings,
            settings.createGoogleApiSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            updateGoogleApiSourceTransportSettings,
            settings.updateGoogleApiSourceSettings(),
            clientContext);
    this.updateGoogleApiSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateGoogleApiSourceTransportSettings,
            settings.updateGoogleApiSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            deleteGoogleApiSourceTransportSettings,
            settings.deleteGoogleApiSourceSettings(),
            clientContext);
    this.deleteGoogleApiSourceOperationCallable =
        callableFactory.createOperationCallable(
            deleteGoogleApiSourceTransportSettings,
            settings.deleteGoogleApiSourceOperationSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    return getTriggerCallable;
  }

  @Override
  public UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    return listTriggersCallable;
  }

  @Override
  public UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse> listTriggersPagedCallable() {
    return listTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    return createTriggerCallable;
  }

  @Override
  public OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    return createTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    return updateTriggerCallable;
  }

  @Override
  public OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    return updateTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    return deleteTriggerCallable;
  }

  @Override
  public OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    return deleteTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    return getChannelCallable;
  }

  @Override
  public UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    return listChannelsCallable;
  }

  @Override
  public UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse> listChannelsPagedCallable() {
    return listChannelsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    return createChannelCallable;
  }

  @Override
  public OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    return createChannelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    return updateChannelCallable;
  }

  @Override
  public OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    return updateChannelOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return deleteChannelCallable;
  }

  @Override
  public OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable() {
    return deleteChannelOperationCallable;
  }

  @Override
  public UnaryCallable<GetProviderRequest, Provider> getProviderCallable() {
    return getProviderCallable;
  }

  @Override
  public UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable() {
    return listProvidersCallable;
  }

  @Override
  public UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable() {
    return listProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable() {
    return getChannelConnectionCallable;
  }

  @Override
  public UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable() {
    return listChannelConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable() {
    return listChannelConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable() {
    return createChannelConnectionCallable;
  }

  @Override
  public OperationCallable<CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable() {
    return createChannelConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable() {
    return deleteChannelConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable() {
    return deleteChannelConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigCallable() {
    return getGoogleChannelConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigCallable() {
    return updateGoogleChannelConfigCallable;
  }

  @Override
  public UnaryCallable<GetMessageBusRequest, MessageBus> getMessageBusCallable() {
    return getMessageBusCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesCallable() {
    return listMessageBusesCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusesRequest, ListMessageBusesPagedResponse>
      listMessageBusesPagedCallable() {
    return listMessageBusesPagedCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsCallable() {
    return listMessageBusEnrollmentsCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsPagedCallable() {
    return listMessageBusEnrollmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateMessageBusRequest, Operation> createMessageBusCallable() {
    return createMessageBusCallable;
  }

  @Override
  public OperationCallable<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationCallable() {
    return createMessageBusOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMessageBusRequest, Operation> updateMessageBusCallable() {
    return updateMessageBusCallable;
  }

  @Override
  public OperationCallable<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationCallable() {
    return updateMessageBusOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMessageBusRequest, Operation> deleteMessageBusCallable() {
    return deleteMessageBusCallable;
  }

  @Override
  public OperationCallable<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationCallable() {
    return deleteMessageBusOperationCallable;
  }

  @Override
  public UnaryCallable<GetEnrollmentRequest, Enrollment> getEnrollmentCallable() {
    return getEnrollmentCallable;
  }

  @Override
  public UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse> listEnrollmentsCallable() {
    return listEnrollmentsCallable;
  }

  @Override
  public UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsPagedResponse>
      listEnrollmentsPagedCallable() {
    return listEnrollmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEnrollmentRequest, Operation> createEnrollmentCallable() {
    return createEnrollmentCallable;
  }

  @Override
  public OperationCallable<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationCallable() {
    return createEnrollmentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEnrollmentRequest, Operation> updateEnrollmentCallable() {
    return updateEnrollmentCallable;
  }

  @Override
  public OperationCallable<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationCallable() {
    return updateEnrollmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEnrollmentRequest, Operation> deleteEnrollmentCallable() {
    return deleteEnrollmentCallable;
  }

  @Override
  public OperationCallable<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationCallable() {
    return deleteEnrollmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetPipelineRequest, Pipeline> getPipelineCallable() {
    return getPipelineCallable;
  }

  @Override
  public UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> listPipelinesCallable() {
    return listPipelinesCallable;
  }

  @Override
  public UnaryCallable<ListPipelinesRequest, ListPipelinesPagedResponse>
      listPipelinesPagedCallable() {
    return listPipelinesPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePipelineRequest, Operation> createPipelineCallable() {
    return createPipelineCallable;
  }

  @Override
  public OperationCallable<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationCallable() {
    return createPipelineOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePipelineRequest, Operation> updatePipelineCallable() {
    return updatePipelineCallable;
  }

  @Override
  public OperationCallable<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationCallable() {
    return updatePipelineOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePipelineRequest, Operation> deletePipelineCallable() {
    return deletePipelineCallable;
  }

  @Override
  public OperationCallable<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationCallable() {
    return deletePipelineOperationCallable;
  }

  @Override
  public UnaryCallable<GetGoogleApiSourceRequest, GoogleApiSource> getGoogleApiSourceCallable() {
    return getGoogleApiSourceCallable;
  }

  @Override
  public UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesCallable() {
    return listGoogleApiSourcesCallable;
  }

  @Override
  public UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesPagedCallable() {
    return listGoogleApiSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGoogleApiSourceRequest, Operation> createGoogleApiSourceCallable() {
    return createGoogleApiSourceCallable;
  }

  @Override
  public OperationCallable<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationCallable() {
    return createGoogleApiSourceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGoogleApiSourceRequest, Operation> updateGoogleApiSourceCallable() {
    return updateGoogleApiSourceCallable;
  }

  @Override
  public OperationCallable<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationCallable() {
    return updateGoogleApiSourceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGoogleApiSourceRequest, Operation> deleteGoogleApiSourceCallable() {
    return deleteGoogleApiSourceCallable;
  }

  @Override
  public OperationCallable<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationCallable() {
    return deleteGoogleApiSourceOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
