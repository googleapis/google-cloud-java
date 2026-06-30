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

import static com.google.showcase.v1beta1.SequenceServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.AttemptSequenceRequest;
import com.google.showcase.v1beta1.AttemptStreamingSequenceRequest;
import com.google.showcase.v1beta1.AttemptStreamingSequenceResponse;
import com.google.showcase.v1beta1.CreateSequenceRequest;
import com.google.showcase.v1beta1.CreateStreamingSequenceRequest;
import com.google.showcase.v1beta1.GetSequenceReportRequest;
import com.google.showcase.v1beta1.GetStreamingSequenceReportRequest;
import com.google.showcase.v1beta1.Sequence;
import com.google.showcase.v1beta1.SequenceReport;
import com.google.showcase.v1beta1.StreamingSequence;
import com.google.showcase.v1beta1.StreamingSequenceReport;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SequenceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSequenceServiceStub extends SequenceServiceStub {
  private static final MethodDescriptor<CreateSequenceRequest, Sequence>
      createSequenceMethodDescriptor =
          MethodDescriptor.<CreateSequenceRequest, Sequence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.SequenceService/CreateSequence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSequenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Sequence.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateStreamingSequenceRequest, StreamingSequence>
      createStreamingSequenceMethodDescriptor =
          MethodDescriptor.<CreateStreamingSequenceRequest, StreamingSequence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.SequenceService/CreateStreamingSequence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateStreamingSequenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StreamingSequence.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSequenceReportRequest, SequenceReport>
      getSequenceReportMethodDescriptor =
          MethodDescriptor.<GetSequenceReportRequest, SequenceReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.SequenceService/GetSequenceReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSequenceReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SequenceReport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetStreamingSequenceReportRequest, StreamingSequenceReport>
      getStreamingSequenceReportMethodDescriptor =
          MethodDescriptor.<GetStreamingSequenceReportRequest, StreamingSequenceReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.showcase.v1beta1.SequenceService/GetStreamingSequenceReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStreamingSequenceReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingSequenceReport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AttemptSequenceRequest, Empty>
      attemptSequenceMethodDescriptor =
          MethodDescriptor.<AttemptSequenceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.SequenceService/AttemptSequence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AttemptSequenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>
      attemptStreamingSequenceMethodDescriptor =
          MethodDescriptor
              .<AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.showcase.v1beta1.SequenceService/AttemptStreamingSequence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AttemptStreamingSequenceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AttemptStreamingSequenceResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateSequenceRequest, Sequence> createSequenceCallable;
  private final UnaryCallable<CreateStreamingSequenceRequest, StreamingSequence>
      createStreamingSequenceCallable;
  private final UnaryCallable<GetSequenceReportRequest, SequenceReport> getSequenceReportCallable;
  private final UnaryCallable<GetStreamingSequenceReportRequest, StreamingSequenceReport>
      getStreamingSequenceReportCallable;
  private final UnaryCallable<AttemptSequenceRequest, Empty> attemptSequenceCallable;
  private final ServerStreamingCallable<
          AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>
      attemptStreamingSequenceCallable;
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

  public static final GrpcSequenceServiceStub create(SequenceServiceStubSettings settings)
      throws IOException {
    return new GrpcSequenceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSequenceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSequenceServiceStub(
        SequenceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSequenceServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSequenceServiceStub(
        SequenceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSequenceServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSequenceServiceStub(
      SequenceServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSequenceServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSequenceServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSequenceServiceStub(
      SequenceServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSequenceRequest, Sequence> createSequenceTransportSettings =
        GrpcCallSettings.<CreateSequenceRequest, Sequence>newBuilder()
            .setMethodDescriptor(createSequenceMethodDescriptor)
            .build();
    GrpcCallSettings<CreateStreamingSequenceRequest, StreamingSequence>
        createStreamingSequenceTransportSettings =
            GrpcCallSettings.<CreateStreamingSequenceRequest, StreamingSequence>newBuilder()
                .setMethodDescriptor(createStreamingSequenceMethodDescriptor)
                .build();
    GrpcCallSettings<GetSequenceReportRequest, SequenceReport> getSequenceReportTransportSettings =
        GrpcCallSettings.<GetSequenceReportRequest, SequenceReport>newBuilder()
            .setMethodDescriptor(getSequenceReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetStreamingSequenceReportRequest, StreamingSequenceReport>
        getStreamingSequenceReportTransportSettings =
            GrpcCallSettings
                .<GetStreamingSequenceReportRequest, StreamingSequenceReport>newBuilder()
                .setMethodDescriptor(getStreamingSequenceReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AttemptSequenceRequest, Empty> attemptSequenceTransportSettings =
        GrpcCallSettings.<AttemptSequenceRequest, Empty>newBuilder()
            .setMethodDescriptor(attemptSequenceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>
        attemptStreamingSequenceTransportSettings =
            GrpcCallSettings
                .<AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>newBuilder()
                .setMethodDescriptor(attemptStreamingSequenceMethodDescriptor)
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

    this.createSequenceCallable =
        callableFactory.createUnaryCallable(
            createSequenceTransportSettings, settings.createSequenceSettings(), clientContext);
    this.createStreamingSequenceCallable =
        callableFactory.createUnaryCallable(
            createStreamingSequenceTransportSettings,
            settings.createStreamingSequenceSettings(),
            clientContext);
    this.getSequenceReportCallable =
        callableFactory.createUnaryCallable(
            getSequenceReportTransportSettings,
            settings.getSequenceReportSettings(),
            clientContext);
    this.getStreamingSequenceReportCallable =
        callableFactory.createUnaryCallable(
            getStreamingSequenceReportTransportSettings,
            settings.getStreamingSequenceReportSettings(),
            clientContext);
    this.attemptSequenceCallable =
        callableFactory.createUnaryCallable(
            attemptSequenceTransportSettings, settings.attemptSequenceSettings(), clientContext);
    this.attemptStreamingSequenceCallable =
        callableFactory.createServerStreamingCallable(
            attemptStreamingSequenceTransportSettings,
            settings.attemptStreamingSequenceSettings(),
            clientContext);
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
  public UnaryCallable<CreateSequenceRequest, Sequence> createSequenceCallable() {
    return createSequenceCallable;
  }

  @Override
  public UnaryCallable<CreateStreamingSequenceRequest, StreamingSequence>
      createStreamingSequenceCallable() {
    return createStreamingSequenceCallable;
  }

  @Override
  public UnaryCallable<GetSequenceReportRequest, SequenceReport> getSequenceReportCallable() {
    return getSequenceReportCallable;
  }

  @Override
  public UnaryCallable<GetStreamingSequenceReportRequest, StreamingSequenceReport>
      getStreamingSequenceReportCallable() {
    return getStreamingSequenceReportCallable;
  }

  @Override
  public UnaryCallable<AttemptSequenceRequest, Empty> attemptSequenceCallable() {
    return attemptSequenceCallable;
  }

  @Override
  public ServerStreamingCallable<AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>
      attemptStreamingSequenceCallable() {
    return attemptStreamingSequenceCallable;
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
