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
import com.google.shopping.merchant.accounts.v1beta.AutofeedSettings;
import com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AutofeedSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAutofeedSettingsServiceStub extends AutofeedSettingsServiceStub {
  private static final MethodDescriptor<GetAutofeedSettingsRequest, AutofeedSettings>
      getAutofeedSettingsMethodDescriptor =
          MethodDescriptor.<GetAutofeedSettingsRequest, AutofeedSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AutofeedSettingsService/GetAutofeedSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAutofeedSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AutofeedSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsMethodDescriptor =
          MethodDescriptor.<UpdateAutofeedSettingsRequest, AutofeedSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AutofeedSettingsService/UpdateAutofeedSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAutofeedSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AutofeedSettings.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAutofeedSettingsRequest, AutofeedSettings>
      getAutofeedSettingsCallable;
  private final UnaryCallable<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAutofeedSettingsServiceStub create(
      AutofeedSettingsServiceStubSettings settings) throws IOException {
    return new GrpcAutofeedSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAutofeedSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAutofeedSettingsServiceStub(
        AutofeedSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAutofeedSettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAutofeedSettingsServiceStub(
        AutofeedSettingsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAutofeedSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAutofeedSettingsServiceStub(
      AutofeedSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAutofeedSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAutofeedSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAutofeedSettingsServiceStub(
      AutofeedSettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAutofeedSettingsRequest, AutofeedSettings>
        getAutofeedSettingsTransportSettings =
            GrpcCallSettings.<GetAutofeedSettingsRequest, AutofeedSettings>newBuilder()
                .setMethodDescriptor(getAutofeedSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAutofeedSettingsRequest, AutofeedSettings>
        updateAutofeedSettingsTransportSettings =
            GrpcCallSettings.<UpdateAutofeedSettingsRequest, AutofeedSettings>newBuilder()
                .setMethodDescriptor(updateAutofeedSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "autofeed_settings.name",
                          String.valueOf(request.getAutofeedSettings().getName()));
                      return builder.build();
                    })
                .build();

    this.getAutofeedSettingsCallable =
        callableFactory.createUnaryCallable(
            getAutofeedSettingsTransportSettings,
            settings.getAutofeedSettingsSettings(),
            clientContext);
    this.updateAutofeedSettingsCallable =
        callableFactory.createUnaryCallable(
            updateAutofeedSettingsTransportSettings,
            settings.updateAutofeedSettingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAutofeedSettingsRequest, AutofeedSettings> getAutofeedSettingsCallable() {
    return getAutofeedSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsCallable() {
    return updateAutofeedSettingsCallable;
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
