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
import com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest;
import com.google.shopping.merchant.accounts.v1beta.RetrieveForApplicationTermsOfServiceAgreementStateRequest;
import com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TermsOfServiceAgreementStateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTermsOfServiceAgreementStateServiceStub
    extends TermsOfServiceAgreementStateServiceStub {
  private static final MethodDescriptor<
          GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      getTermsOfServiceAgreementStateMethodDescriptor =
          MethodDescriptor
              .<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementStateService/GetTermsOfServiceAgreementState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetTermsOfServiceAgreementStateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TermsOfServiceAgreementState.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      retrieveForApplicationTermsOfServiceAgreementStateMethodDescriptor =
          MethodDescriptor
              .<RetrieveForApplicationTermsOfServiceAgreementStateRequest,
                  TermsOfServiceAgreementState>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementStateService/RetrieveForApplicationTermsOfServiceAgreementState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveForApplicationTermsOfServiceAgreementStateRequest
                          .getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TermsOfServiceAgreementState.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      getTermsOfServiceAgreementStateCallable;
  private final UnaryCallable<
          RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      retrieveForApplicationTermsOfServiceAgreementStateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTermsOfServiceAgreementStateServiceStub create(
      TermsOfServiceAgreementStateServiceStubSettings settings) throws IOException {
    return new GrpcTermsOfServiceAgreementStateServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final GrpcTermsOfServiceAgreementStateServiceStub create(
      ClientContext clientContext) throws IOException {
    return new GrpcTermsOfServiceAgreementStateServiceStub(
        TermsOfServiceAgreementStateServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTermsOfServiceAgreementStateServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTermsOfServiceAgreementStateServiceStub(
        TermsOfServiceAgreementStateServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcTermsOfServiceAgreementStateServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcTermsOfServiceAgreementStateServiceStub(
      TermsOfServiceAgreementStateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTermsOfServiceAgreementStateServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTermsOfServiceAgreementStateServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcTermsOfServiceAgreementStateServiceStub(
      TermsOfServiceAgreementStateServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
        getTermsOfServiceAgreementStateTransportSettings =
            GrpcCallSettings
                .<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>newBuilder()
                .setMethodDescriptor(getTermsOfServiceAgreementStateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
        retrieveForApplicationTermsOfServiceAgreementStateTransportSettings =
            GrpcCallSettings
                .<RetrieveForApplicationTermsOfServiceAgreementStateRequest,
                    TermsOfServiceAgreementState>
                    newBuilder()
                .setMethodDescriptor(
                    retrieveForApplicationTermsOfServiceAgreementStateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getTermsOfServiceAgreementStateCallable =
        callableFactory.createUnaryCallable(
            getTermsOfServiceAgreementStateTransportSettings,
            settings.getTermsOfServiceAgreementStateSettings(),
            clientContext);
    this.retrieveForApplicationTermsOfServiceAgreementStateCallable =
        callableFactory.createUnaryCallable(
            retrieveForApplicationTermsOfServiceAgreementStateTransportSettings,
            settings.retrieveForApplicationTermsOfServiceAgreementStateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      getTermsOfServiceAgreementStateCallable() {
    return getTermsOfServiceAgreementStateCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      retrieveForApplicationTermsOfServiceAgreementStateCallable() {
    return retrieveForApplicationTermsOfServiceAgreementStateCallable;
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
