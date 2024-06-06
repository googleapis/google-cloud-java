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

package com.google.shopping.merchant.accounts.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.Homepage;
import com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the HomepageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcHomepageServiceStub extends HomepageServiceStub {
  private static final MethodDescriptor<GetHomepageRequest, Homepage> getHomepageMethodDescriptor =
      MethodDescriptor.<GetHomepageRequest, Homepage>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.HomepageService/GetHomepage")
          .setRequestMarshaller(ProtoUtils.marshaller(GetHomepageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Homepage.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateHomepageRequest, Homepage>
      updateHomepageMethodDescriptor =
          MethodDescriptor.<UpdateHomepageRequest, Homepage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/UpdateHomepage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHomepageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Homepage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ClaimHomepageRequest, Homepage>
      claimHomepageMethodDescriptor =
          MethodDescriptor.<ClaimHomepageRequest, Homepage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/ClaimHomepage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ClaimHomepageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Homepage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UnclaimHomepageRequest, Homepage>
      unclaimHomepageMethodDescriptor =
          MethodDescriptor.<UnclaimHomepageRequest, Homepage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/UnclaimHomepage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnclaimHomepageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Homepage.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetHomepageRequest, Homepage> getHomepageCallable;
  private final UnaryCallable<UpdateHomepageRequest, Homepage> updateHomepageCallable;
  private final UnaryCallable<ClaimHomepageRequest, Homepage> claimHomepageCallable;
  private final UnaryCallable<UnclaimHomepageRequest, Homepage> unclaimHomepageCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcHomepageServiceStub create(HomepageServiceStubSettings settings)
      throws IOException {
    return new GrpcHomepageServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHomepageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcHomepageServiceStub(
        HomepageServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHomepageServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHomepageServiceStub(
        HomepageServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcHomepageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHomepageServiceStub(
      HomepageServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcHomepageServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHomepageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHomepageServiceStub(
      HomepageServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetHomepageRequest, Homepage> getHomepageTransportSettings =
        GrpcCallSettings.<GetHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(getHomepageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHomepageRequest, Homepage> updateHomepageTransportSettings =
        GrpcCallSettings.<UpdateHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(updateHomepageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("homepage.name", String.valueOf(request.getHomepage().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ClaimHomepageRequest, Homepage> claimHomepageTransportSettings =
        GrpcCallSettings.<ClaimHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(claimHomepageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UnclaimHomepageRequest, Homepage> unclaimHomepageTransportSettings =
        GrpcCallSettings.<UnclaimHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(unclaimHomepageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getHomepageCallable =
        callableFactory.createUnaryCallable(
            getHomepageTransportSettings, settings.getHomepageSettings(), clientContext);
    this.updateHomepageCallable =
        callableFactory.createUnaryCallable(
            updateHomepageTransportSettings, settings.updateHomepageSettings(), clientContext);
    this.claimHomepageCallable =
        callableFactory.createUnaryCallable(
            claimHomepageTransportSettings, settings.claimHomepageSettings(), clientContext);
    this.unclaimHomepageCallable =
        callableFactory.createUnaryCallable(
            unclaimHomepageTransportSettings, settings.unclaimHomepageSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetHomepageRequest, Homepage> getHomepageCallable() {
    return getHomepageCallable;
  }

  @Override
  public UnaryCallable<UpdateHomepageRequest, Homepage> updateHomepageCallable() {
    return updateHomepageCallable;
  }

  @Override
  public UnaryCallable<ClaimHomepageRequest, Homepage> claimHomepageCallable() {
    return claimHomepageCallable;
  }

  @Override
  public UnaryCallable<UnclaimHomepageRequest, Homepage> unclaimHomepageCallable() {
    return unclaimHomepageCallable;
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
