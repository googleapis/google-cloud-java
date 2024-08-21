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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.LintingServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.GetStyleGuideContentsRequest;
import com.google.cloud.apihub.v1.GetStyleGuideRequest;
import com.google.cloud.apihub.v1.LintSpecRequest;
import com.google.cloud.apihub.v1.StyleGuide;
import com.google.cloud.apihub.v1.StyleGuideContents;
import com.google.cloud.apihub.v1.UpdateStyleGuideRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LintingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLintingServiceStub extends LintingServiceStub {
  private static final MethodDescriptor<GetStyleGuideRequest, StyleGuide>
      getStyleGuideMethodDescriptor =
          MethodDescriptor.<GetStyleGuideRequest, StyleGuide>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.LintingService/GetStyleGuide")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStyleGuideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StyleGuide.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateStyleGuideRequest, StyleGuide>
      updateStyleGuideMethodDescriptor =
          MethodDescriptor.<UpdateStyleGuideRequest, StyleGuide>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.LintingService/UpdateStyleGuide")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateStyleGuideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StyleGuide.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStyleGuideContentsRequest, StyleGuideContents>
      getStyleGuideContentsMethodDescriptor =
          MethodDescriptor.<GetStyleGuideContentsRequest, StyleGuideContents>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.LintingService/GetStyleGuideContents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStyleGuideContentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StyleGuideContents.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LintSpecRequest, Empty> lintSpecMethodDescriptor =
      MethodDescriptor.<LintSpecRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.LintingService/LintSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(LintSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private final UnaryCallable<GetStyleGuideRequest, StyleGuide> getStyleGuideCallable;
  private final UnaryCallable<UpdateStyleGuideRequest, StyleGuide> updateStyleGuideCallable;
  private final UnaryCallable<GetStyleGuideContentsRequest, StyleGuideContents>
      getStyleGuideContentsCallable;
  private final UnaryCallable<LintSpecRequest, Empty> lintSpecCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLintingServiceStub create(LintingServiceStubSettings settings)
      throws IOException {
    return new GrpcLintingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLintingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLintingServiceStub(
        LintingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLintingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLintingServiceStub(
        LintingServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLintingServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLintingServiceStub(LintingServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLintingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLintingServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLintingServiceStub(
      LintingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetStyleGuideRequest, StyleGuide> getStyleGuideTransportSettings =
        GrpcCallSettings.<GetStyleGuideRequest, StyleGuide>newBuilder()
            .setMethodDescriptor(getStyleGuideMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateStyleGuideRequest, StyleGuide> updateStyleGuideTransportSettings =
        GrpcCallSettings.<UpdateStyleGuideRequest, StyleGuide>newBuilder()
            .setMethodDescriptor(updateStyleGuideMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "style_guide.name", String.valueOf(request.getStyleGuide().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetStyleGuideContentsRequest, StyleGuideContents>
        getStyleGuideContentsTransportSettings =
            GrpcCallSettings.<GetStyleGuideContentsRequest, StyleGuideContents>newBuilder()
                .setMethodDescriptor(getStyleGuideContentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<LintSpecRequest, Empty> lintSpecTransportSettings =
        GrpcCallSettings.<LintSpecRequest, Empty>newBuilder()
            .setMethodDescriptor(lintSpecMethodDescriptor)
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

    this.getStyleGuideCallable =
        callableFactory.createUnaryCallable(
            getStyleGuideTransportSettings, settings.getStyleGuideSettings(), clientContext);
    this.updateStyleGuideCallable =
        callableFactory.createUnaryCallable(
            updateStyleGuideTransportSettings, settings.updateStyleGuideSettings(), clientContext);
    this.getStyleGuideContentsCallable =
        callableFactory.createUnaryCallable(
            getStyleGuideContentsTransportSettings,
            settings.getStyleGuideContentsSettings(),
            clientContext);
    this.lintSpecCallable =
        callableFactory.createUnaryCallable(
            lintSpecTransportSettings, settings.lintSpecSettings(), clientContext);
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
  public UnaryCallable<GetStyleGuideRequest, StyleGuide> getStyleGuideCallable() {
    return getStyleGuideCallable;
  }

  @Override
  public UnaryCallable<UpdateStyleGuideRequest, StyleGuide> updateStyleGuideCallable() {
    return updateStyleGuideCallable;
  }

  @Override
  public UnaryCallable<GetStyleGuideContentsRequest, StyleGuideContents>
      getStyleGuideContentsCallable() {
    return getStyleGuideContentsCallable;
  }

  @Override
  public UnaryCallable<LintSpecRequest, Empty> lintSpecCallable() {
    return lintSpecCallable;
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
