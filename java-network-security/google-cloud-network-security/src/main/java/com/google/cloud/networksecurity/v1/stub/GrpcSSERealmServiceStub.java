/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACAttachmentsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACRealmsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.CreateSACRealmRequest;
import com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.DeleteSACRealmRequest;
import com.google.cloud.networksecurity.v1.GetSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.GetSACRealmRequest;
import com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest;
import com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse;
import com.google.cloud.networksecurity.v1.ListSACRealmsRequest;
import com.google.cloud.networksecurity.v1.ListSACRealmsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SACAttachment;
import com.google.cloud.networksecurity.v1.SACRealm;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SSERealmService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcSSERealmServiceStub extends SSERealmServiceStub {
  private static final MethodDescriptor<ListSACRealmsRequest, ListSACRealmsResponse>
      listSACRealmsMethodDescriptor =
          MethodDescriptor.<ListSACRealmsRequest, ListSACRealmsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.SSERealmService/ListSACRealms")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSACRealmsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSACRealmsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSACRealmRequest, SACRealm> getSACRealmMethodDescriptor =
      MethodDescriptor.<GetSACRealmRequest, SACRealm>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networksecurity.v1.SSERealmService/GetSACRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSACRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SACRealm.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateSACRealmRequest, Operation>
      createSACRealmMethodDescriptor =
          MethodDescriptor.<CreateSACRealmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.SSERealmService/CreateSACRealm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSACRealmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSACRealmRequest, Operation>
      deleteSACRealmMethodDescriptor =
          MethodDescriptor.<DeleteSACRealmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.SSERealmService/DeleteSACRealm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSACRealmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSACAttachmentsRequest, ListSACAttachmentsResponse>
      listSACAttachmentsMethodDescriptor =
          MethodDescriptor.<ListSACAttachmentsRequest, ListSACAttachmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.SSERealmService/ListSACAttachments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSACAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSACAttachmentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSACAttachmentRequest, SACAttachment>
      getSACAttachmentMethodDescriptor =
          MethodDescriptor.<GetSACAttachmentRequest, SACAttachment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.SSERealmService/GetSACAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSACAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SACAttachment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSACAttachmentRequest, Operation>
      createSACAttachmentMethodDescriptor =
          MethodDescriptor.<CreateSACAttachmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.SSERealmService/CreateSACAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSACAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSACAttachmentRequest, Operation>
      deleteSACAttachmentMethodDescriptor =
          MethodDescriptor.<DeleteSACAttachmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.SSERealmService/DeleteSACAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSACAttachmentRequest.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListSACRealmsRequest, ListSACRealmsResponse> listSACRealmsCallable;
  private final UnaryCallable<ListSACRealmsRequest, ListSACRealmsPagedResponse>
      listSACRealmsPagedCallable;
  private final UnaryCallable<GetSACRealmRequest, SACRealm> getSACRealmCallable;
  private final UnaryCallable<CreateSACRealmRequest, Operation> createSACRealmCallable;
  private final OperationCallable<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationCallable;
  private final UnaryCallable<DeleteSACRealmRequest, Operation> deleteSACRealmCallable;
  private final OperationCallable<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationCallable;
  private final UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsResponse>
      listSACAttachmentsCallable;
  private final UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsPagedResponse>
      listSACAttachmentsPagedCallable;
  private final UnaryCallable<GetSACAttachmentRequest, SACAttachment> getSACAttachmentCallable;
  private final UnaryCallable<CreateSACAttachmentRequest, Operation> createSACAttachmentCallable;
  private final OperationCallable<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationCallable;
  private final UnaryCallable<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentCallable;
  private final OperationCallable<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationCallable;
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

  public static final GrpcSSERealmServiceStub create(SSERealmServiceStubSettings settings)
      throws IOException {
    return new GrpcSSERealmServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSSERealmServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSSERealmServiceStub(
        SSERealmServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSSERealmServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSSERealmServiceStub(
        SSERealmServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSSERealmServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSSERealmServiceStub(
      SSERealmServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSSERealmServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSSERealmServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSSERealmServiceStub(
      SSERealmServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSACRealmsRequest, ListSACRealmsResponse> listSACRealmsTransportSettings =
        GrpcCallSettings.<ListSACRealmsRequest, ListSACRealmsResponse>newBuilder()
            .setMethodDescriptor(listSACRealmsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetSACRealmRequest, SACRealm> getSACRealmTransportSettings =
        GrpcCallSettings.<GetSACRealmRequest, SACRealm>newBuilder()
            .setMethodDescriptor(getSACRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateSACRealmRequest, Operation> createSACRealmTransportSettings =
        GrpcCallSettings.<CreateSACRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(createSACRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<DeleteSACRealmRequest, Operation> deleteSACRealmTransportSettings =
        GrpcCallSettings.<DeleteSACRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSACRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSACAttachmentsRequest, ListSACAttachmentsResponse>
        listSACAttachmentsTransportSettings =
            GrpcCallSettings.<ListSACAttachmentsRequest, ListSACAttachmentsResponse>newBuilder()
                .setMethodDescriptor(listSACAttachmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetSACAttachmentRequest, SACAttachment> getSACAttachmentTransportSettings =
        GrpcCallSettings.<GetSACAttachmentRequest, SACAttachment>newBuilder()
            .setMethodDescriptor(getSACAttachmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateSACAttachmentRequest, Operation> createSACAttachmentTransportSettings =
        GrpcCallSettings.<CreateSACAttachmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createSACAttachmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentTransportSettings =
        GrpcCallSettings.<DeleteSACAttachmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSACAttachmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getResource())
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
            .setResourceNameExtractor(request -> request.getResource())
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
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.listSACRealmsCallable =
        callableFactory.createUnaryCallable(
            listSACRealmsTransportSettings, settings.listSACRealmsSettings(), clientContext);
    this.listSACRealmsPagedCallable =
        callableFactory.createPagedCallable(
            listSACRealmsTransportSettings, settings.listSACRealmsSettings(), clientContext);
    this.getSACRealmCallable =
        callableFactory.createUnaryCallable(
            getSACRealmTransportSettings, settings.getSACRealmSettings(), clientContext);
    this.createSACRealmCallable =
        callableFactory.createUnaryCallable(
            createSACRealmTransportSettings, settings.createSACRealmSettings(), clientContext);
    this.createSACRealmOperationCallable =
        callableFactory.createOperationCallable(
            createSACRealmTransportSettings,
            settings.createSACRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSACRealmCallable =
        callableFactory.createUnaryCallable(
            deleteSACRealmTransportSettings, settings.deleteSACRealmSettings(), clientContext);
    this.deleteSACRealmOperationCallable =
        callableFactory.createOperationCallable(
            deleteSACRealmTransportSettings,
            settings.deleteSACRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.listSACAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listSACAttachmentsTransportSettings,
            settings.listSACAttachmentsSettings(),
            clientContext);
    this.listSACAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listSACAttachmentsTransportSettings,
            settings.listSACAttachmentsSettings(),
            clientContext);
    this.getSACAttachmentCallable =
        callableFactory.createUnaryCallable(
            getSACAttachmentTransportSettings, settings.getSACAttachmentSettings(), clientContext);
    this.createSACAttachmentCallable =
        callableFactory.createUnaryCallable(
            createSACAttachmentTransportSettings,
            settings.createSACAttachmentSettings(),
            clientContext);
    this.createSACAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            createSACAttachmentTransportSettings,
            settings.createSACAttachmentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSACAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteSACAttachmentTransportSettings,
            settings.deleteSACAttachmentSettings(),
            clientContext);
    this.deleteSACAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteSACAttachmentTransportSettings,
            settings.deleteSACAttachmentOperationSettings(),
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
  public UnaryCallable<ListSACRealmsRequest, ListSACRealmsResponse> listSACRealmsCallable() {
    return listSACRealmsCallable;
  }

  @Override
  public UnaryCallable<ListSACRealmsRequest, ListSACRealmsPagedResponse>
      listSACRealmsPagedCallable() {
    return listSACRealmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSACRealmRequest, SACRealm> getSACRealmCallable() {
    return getSACRealmCallable;
  }

  @Override
  public UnaryCallable<CreateSACRealmRequest, Operation> createSACRealmCallable() {
    return createSACRealmCallable;
  }

  @Override
  public OperationCallable<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationCallable() {
    return createSACRealmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSACRealmRequest, Operation> deleteSACRealmCallable() {
    return deleteSACRealmCallable;
  }

  @Override
  public OperationCallable<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationCallable() {
    return deleteSACRealmOperationCallable;
  }

  @Override
  public UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsResponse>
      listSACAttachmentsCallable() {
    return listSACAttachmentsCallable;
  }

  @Override
  public UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsPagedResponse>
      listSACAttachmentsPagedCallable() {
    return listSACAttachmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSACAttachmentRequest, SACAttachment> getSACAttachmentCallable() {
    return getSACAttachmentCallable;
  }

  @Override
  public UnaryCallable<CreateSACAttachmentRequest, Operation> createSACAttachmentCallable() {
    return createSACAttachmentCallable;
  }

  @Override
  public OperationCallable<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationCallable() {
    return createSACAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentCallable() {
    return deleteSACAttachmentCallable;
  }

  @Override
  public OperationCallable<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationCallable() {
    return deleteSACAttachmentOperationCallable;
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
