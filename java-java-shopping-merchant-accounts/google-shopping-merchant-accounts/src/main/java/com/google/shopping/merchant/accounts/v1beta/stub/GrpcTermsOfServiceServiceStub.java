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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1beta.TermsOfService;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TermsOfServiceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTermsOfServiceServiceStub extends TermsOfServiceServiceStub {
  private static final MethodDescriptor<GetTermsOfServiceRequest, TermsOfService>
      getTermsOfServiceMethodDescriptor =
          MethodDescriptor.<GetTermsOfServiceRequest, TermsOfService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.TermsOfServiceService/GetTermsOfService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTermsOfServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TermsOfService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceMethodDescriptor =
          MethodDescriptor.<RetrieveLatestTermsOfServiceRequest, TermsOfService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.TermsOfServiceService/RetrieveLatestTermsOfService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveLatestTermsOfServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TermsOfService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AcceptTermsOfServiceRequest, Empty>
      acceptTermsOfServiceMethodDescriptor =
          MethodDescriptor.<AcceptTermsOfServiceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.TermsOfServiceService/AcceptTermsOfService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AcceptTermsOfServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceCallable;
  private final UnaryCallable<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceCallable;
  private final UnaryCallable<AcceptTermsOfServiceRequest, Empty> acceptTermsOfServiceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTermsOfServiceServiceStub create(
      TermsOfServiceServiceStubSettings settings) throws IOException {
    return new GrpcTermsOfServiceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTermsOfServiceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTermsOfServiceServiceStub(
        TermsOfServiceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTermsOfServiceServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTermsOfServiceServiceStub(
        TermsOfServiceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTermsOfServiceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTermsOfServiceServiceStub(
      TermsOfServiceServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTermsOfServiceServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTermsOfServiceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTermsOfServiceServiceStub(
      TermsOfServiceServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceTransportSettings =
        GrpcCallSettings.<GetTermsOfServiceRequest, TermsOfService>newBuilder()
            .setMethodDescriptor(getTermsOfServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RetrieveLatestTermsOfServiceRequest, TermsOfService>
        retrieveLatestTermsOfServiceTransportSettings =
            GrpcCallSettings.<RetrieveLatestTermsOfServiceRequest, TermsOfService>newBuilder()
                .setMethodDescriptor(retrieveLatestTermsOfServiceMethodDescriptor)
                .build();
    GrpcCallSettings<AcceptTermsOfServiceRequest, Empty> acceptTermsOfServiceTransportSettings =
        GrpcCallSettings.<AcceptTermsOfServiceRequest, Empty>newBuilder()
            .setMethodDescriptor(acceptTermsOfServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getTermsOfServiceCallable =
        callableFactory.createUnaryCallable(
            getTermsOfServiceTransportSettings,
            settings.getTermsOfServiceSettings(),
            clientContext);
    this.retrieveLatestTermsOfServiceCallable =
        callableFactory.createUnaryCallable(
            retrieveLatestTermsOfServiceTransportSettings,
            settings.retrieveLatestTermsOfServiceSettings(),
            clientContext);
    this.acceptTermsOfServiceCallable =
        callableFactory.createUnaryCallable(
            acceptTermsOfServiceTransportSettings,
            settings.acceptTermsOfServiceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceCallable() {
    return getTermsOfServiceCallable;
  }

  @Override
  public UnaryCallable<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceCallable() {
    return retrieveLatestTermsOfServiceCallable;
  }

  @Override
  public UnaryCallable<AcceptTermsOfServiceRequest, Empty> acceptTermsOfServiceCallable() {
    return acceptTermsOfServiceCallable;
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
