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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.EchoClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandLegacyMappedPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.base.Strings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoErrorDetailsRequest;
import com.google.showcase.v1beta1.EchoErrorDetailsResponse;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.ExpandRequest;
import com.google.showcase.v1beta1.FailEchoWithDetailsRequest;
import com.google.showcase.v1beta1.FailEchoWithDetailsResponse;
import com.google.showcase.v1beta1.PagedExpandLegacyMappedResponse;
import com.google.showcase.v1beta1.PagedExpandLegacyRequest;
import com.google.showcase.v1beta1.PagedExpandRequest;
import com.google.showcase.v1beta1.PagedExpandResponse;
import com.google.showcase.v1beta1.WaitMetadata;
import com.google.showcase.v1beta1.WaitRequest;
import com.google.showcase.v1beta1.WaitResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Echo service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEchoStub extends EchoStub {
  private static final MethodDescriptor<EchoRequest, EchoResponse> echoMethodDescriptor =
      MethodDescriptor.<EchoRequest, EchoResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Echo/Echo")
          .setRequestMarshaller(ProtoUtils.marshaller(EchoRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EchoResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsMethodDescriptor =
          MethodDescriptor.<EchoErrorDetailsRequest, EchoErrorDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Echo/EchoErrorDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EchoErrorDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EchoErrorDetailsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsMethodDescriptor =
          MethodDescriptor.<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Echo/FailEchoWithDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FailEchoWithDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FailEchoWithDetailsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExpandRequest, EchoResponse> expandMethodDescriptor =
      MethodDescriptor.<ExpandRequest, EchoResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName("google.showcase.v1beta1.Echo/Expand")
          .setRequestMarshaller(ProtoUtils.marshaller(ExpandRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EchoResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<EchoRequest, EchoResponse> collectMethodDescriptor =
      MethodDescriptor.<EchoRequest, EchoResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName("google.showcase.v1beta1.Echo/Collect")
          .setRequestMarshaller(ProtoUtils.marshaller(EchoRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EchoResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<EchoRequest, EchoResponse> chatMethodDescriptor =
      MethodDescriptor.<EchoRequest, EchoResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.showcase.v1beta1.Echo/Chat")
          .setRequestMarshaller(ProtoUtils.marshaller(EchoRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EchoResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<PagedExpandRequest, PagedExpandResponse>
      pagedExpandMethodDescriptor =
          MethodDescriptor.<PagedExpandRequest, PagedExpandResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Echo/PagedExpand")
              .setRequestMarshaller(ProtoUtils.marshaller(PagedExpandRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PagedExpandResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PagedExpandLegacyRequest, PagedExpandResponse>
      pagedExpandLegacyMethodDescriptor =
          MethodDescriptor.<PagedExpandLegacyRequest, PagedExpandResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Echo/PagedExpandLegacy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PagedExpandLegacyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PagedExpandResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedMethodDescriptor =
          MethodDescriptor.<PagedExpandRequest, PagedExpandLegacyMappedResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Echo/PagedExpandLegacyMapped")
              .setRequestMarshaller(ProtoUtils.marshaller(PagedExpandRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PagedExpandLegacyMappedResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<WaitRequest, Operation> waitMethodDescriptor =
      MethodDescriptor.<WaitRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Echo/Wait")
          .setRequestMarshaller(ProtoUtils.marshaller(WaitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<BlockRequest, BlockResponse> blockMethodDescriptor =
      MethodDescriptor.<BlockRequest, BlockResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Echo/Block")
          .setRequestMarshaller(ProtoUtils.marshaller(BlockRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(BlockResponse.getDefaultInstance()))
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

  private final UnaryCallable<EchoRequest, EchoResponse> echoCallable;
  private final UnaryCallable<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsCallable;
  private final UnaryCallable<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsCallable;
  private final ServerStreamingCallable<ExpandRequest, EchoResponse> expandCallable;
  private final ClientStreamingCallable<EchoRequest, EchoResponse> collectCallable;
  private final BidiStreamingCallable<EchoRequest, EchoResponse> chatCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandResponse> pagedExpandCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandPagedResponse>
      pagedExpandPagedCallable;
  private final UnaryCallable<PagedExpandLegacyRequest, PagedExpandResponse>
      pagedExpandLegacyCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedPagedResponse>
      pagedExpandLegacyMappedPagedCallable;
  private final UnaryCallable<WaitRequest, Operation> waitCallable;
  private final OperationCallable<WaitRequest, WaitResponse, WaitMetadata> waitOperationCallable;
  private final UnaryCallable<BlockRequest, BlockResponse> blockCallable;
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

  private static final PathTemplate ECHO_0_PATH_TEMPLATE = PathTemplate.create("{header=**}");
  private static final PathTemplate ECHO_1_PATH_TEMPLATE = PathTemplate.create("{routing_id=**}");
  private static final PathTemplate ECHO_2_PATH_TEMPLATE =
      PathTemplate.create("{table_name=regions/*/zones/*/**}");
  private static final PathTemplate ECHO_3_PATH_TEMPLATE =
      PathTemplate.create("{super_id=projects/*}/**");
  private static final PathTemplate ECHO_4_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/**}");
  private static final PathTemplate ECHO_5_PATH_TEMPLATE =
      PathTemplate.create("projects/*/{instance_id=instances/*}/**");
  private static final PathTemplate ECHO_6_PATH_TEMPLATE = PathTemplate.create("{baz=**}");
  private static final PathTemplate ECHO_7_PATH_TEMPLATE =
      PathTemplate.create("{qux=projects/*}/**");

  public static final GrpcEchoStub create(EchoStubSettings settings) throws IOException {
    return new GrpcEchoStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEchoStub create(ClientContext clientContext) throws IOException {
    return new GrpcEchoStub(EchoStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEchoStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEchoStub(EchoStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEchoStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEchoStub(EchoStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEchoCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEchoStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEchoStub(
      EchoStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<EchoRequest, EchoResponse> echoTransportSettings =
        GrpcCallSettings.<EchoRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(echoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getHeader(), "header", ECHO_0_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "routing_id", ECHO_1_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "table_name", ECHO_2_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "super_id", ECHO_3_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "table_name", ECHO_4_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "instance_id", ECHO_5_PATH_TEMPLATE);
                  builder.add(request.getOtherHeader(), "baz", ECHO_6_PATH_TEMPLATE);
                  builder.add(request.getOtherHeader(), "qux", ECHO_7_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  EchoRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  if (Strings.isNullOrEmpty(request.getOtherRequestId())) {
                    requestBuilder.setOtherRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .build();
    GrpcCallSettings<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
        echoErrorDetailsTransportSettings =
            GrpcCallSettings.<EchoErrorDetailsRequest, EchoErrorDetailsResponse>newBuilder()
                .setMethodDescriptor(echoErrorDetailsMethodDescriptor)
                .build();
    GrpcCallSettings<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
        failEchoWithDetailsTransportSettings =
            GrpcCallSettings.<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>newBuilder()
                .setMethodDescriptor(failEchoWithDetailsMethodDescriptor)
                .build();
    GrpcCallSettings<ExpandRequest, EchoResponse> expandTransportSettings =
        GrpcCallSettings.<ExpandRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(expandMethodDescriptor)
            .build();
    GrpcCallSettings<EchoRequest, EchoResponse> collectTransportSettings =
        GrpcCallSettings.<EchoRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(collectMethodDescriptor)
            .build();
    GrpcCallSettings<EchoRequest, EchoResponse> chatTransportSettings =
        GrpcCallSettings.<EchoRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(chatMethodDescriptor)
            .build();
    GrpcCallSettings<PagedExpandRequest, PagedExpandResponse> pagedExpandTransportSettings =
        GrpcCallSettings.<PagedExpandRequest, PagedExpandResponse>newBuilder()
            .setMethodDescriptor(pagedExpandMethodDescriptor)
            .build();
    GrpcCallSettings<PagedExpandLegacyRequest, PagedExpandResponse>
        pagedExpandLegacyTransportSettings =
            GrpcCallSettings.<PagedExpandLegacyRequest, PagedExpandResponse>newBuilder()
                .setMethodDescriptor(pagedExpandLegacyMethodDescriptor)
                .build();
    GrpcCallSettings<PagedExpandRequest, PagedExpandLegacyMappedResponse>
        pagedExpandLegacyMappedTransportSettings =
            GrpcCallSettings.<PagedExpandRequest, PagedExpandLegacyMappedResponse>newBuilder()
                .setMethodDescriptor(pagedExpandLegacyMappedMethodDescriptor)
                .build();
    GrpcCallSettings<WaitRequest, Operation> waitTransportSettings =
        GrpcCallSettings.<WaitRequest, Operation>newBuilder()
            .setMethodDescriptor(waitMethodDescriptor)
            .build();
    GrpcCallSettings<BlockRequest, BlockResponse> blockTransportSettings =
        GrpcCallSettings.<BlockRequest, BlockResponse>newBuilder()
            .setMethodDescriptor(blockMethodDescriptor)
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

    this.echoCallable =
        callableFactory.createUnaryCallable(
            echoTransportSettings, settings.echoSettings(), clientContext);
    this.echoErrorDetailsCallable =
        callableFactory.createUnaryCallable(
            echoErrorDetailsTransportSettings, settings.echoErrorDetailsSettings(), clientContext);
    this.failEchoWithDetailsCallable =
        callableFactory.createUnaryCallable(
            failEchoWithDetailsTransportSettings,
            settings.failEchoWithDetailsSettings(),
            clientContext);
    this.expandCallable =
        callableFactory.createServerStreamingCallable(
            expandTransportSettings, settings.expandSettings(), clientContext);
    this.collectCallable =
        callableFactory.createClientStreamingCallable(
            collectTransportSettings, settings.collectSettings(), clientContext);
    this.chatCallable =
        callableFactory.createBidiStreamingCallable(
            chatTransportSettings, settings.chatSettings(), clientContext);
    this.pagedExpandCallable =
        callableFactory.createUnaryCallable(
            pagedExpandTransportSettings, settings.pagedExpandSettings(), clientContext);
    this.pagedExpandPagedCallable =
        callableFactory.createPagedCallable(
            pagedExpandTransportSettings, settings.pagedExpandSettings(), clientContext);
    this.pagedExpandLegacyCallable =
        callableFactory.createUnaryCallable(
            pagedExpandLegacyTransportSettings,
            settings.pagedExpandLegacySettings(),
            clientContext);
    this.pagedExpandLegacyMappedCallable =
        callableFactory.createUnaryCallable(
            pagedExpandLegacyMappedTransportSettings,
            settings.pagedExpandLegacyMappedSettings(),
            clientContext);
    this.pagedExpandLegacyMappedPagedCallable =
        callableFactory.createPagedCallable(
            pagedExpandLegacyMappedTransportSettings,
            settings.pagedExpandLegacyMappedSettings(),
            clientContext);
    this.waitCallable =
        callableFactory.createUnaryCallable(
            waitTransportSettings, settings.waitSettings(), clientContext);
    this.waitOperationCallable =
        callableFactory.createOperationCallable(
            waitTransportSettings, settings.waitOperationSettings(), clientContext, operationsStub);
    this.blockCallable =
        callableFactory.createUnaryCallable(
            blockTransportSettings, settings.blockSettings(), clientContext);
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
  public UnaryCallable<EchoRequest, EchoResponse> echoCallable() {
    return echoCallable;
  }

  @Override
  public UnaryCallable<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsCallable() {
    return echoErrorDetailsCallable;
  }

  @Override
  public UnaryCallable<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsCallable() {
    return failEchoWithDetailsCallable;
  }

  @Override
  public ServerStreamingCallable<ExpandRequest, EchoResponse> expandCallable() {
    return expandCallable;
  }

  @Override
  public ClientStreamingCallable<EchoRequest, EchoResponse> collectCallable() {
    return collectCallable;
  }

  @Override
  public BidiStreamingCallable<EchoRequest, EchoResponse> chatCallable() {
    return chatCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandResponse> pagedExpandCallable() {
    return pagedExpandCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandPagedResponse> pagedExpandPagedCallable() {
    return pagedExpandPagedCallable;
  }

  @Override
  public UnaryCallable<PagedExpandLegacyRequest, PagedExpandResponse> pagedExpandLegacyCallable() {
    return pagedExpandLegacyCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedCallable() {
    return pagedExpandLegacyMappedCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedPagedResponse>
      pagedExpandLegacyMappedPagedCallable() {
    return pagedExpandLegacyMappedPagedCallable;
  }

  @Override
  public UnaryCallable<WaitRequest, Operation> waitCallable() {
    return waitCallable;
  }

  @Override
  public OperationCallable<WaitRequest, WaitResponse, WaitMetadata> waitOperationCallable() {
    return waitOperationCallable;
  }

  @Override
  public UnaryCallable<BlockRequest, BlockResponse> blockCallable() {
    return blockCallable;
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
