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
import com.google.shopping.merchant.accounts.v1beta.EmailPreferences;
import com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EmailPreferencesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEmailPreferencesServiceStub extends EmailPreferencesServiceStub {
  private static final MethodDescriptor<GetEmailPreferencesRequest, EmailPreferences>
      getEmailPreferencesMethodDescriptor =
          MethodDescriptor.<GetEmailPreferencesRequest, EmailPreferences>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.EmailPreferencesService/GetEmailPreferences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEmailPreferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EmailPreferences.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEmailPreferencesRequest, EmailPreferences>
      updateEmailPreferencesMethodDescriptor =
          MethodDescriptor.<UpdateEmailPreferencesRequest, EmailPreferences>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.EmailPreferencesService/UpdateEmailPreferences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEmailPreferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EmailPreferences.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetEmailPreferencesRequest, EmailPreferences>
      getEmailPreferencesCallable;
  private final UnaryCallable<UpdateEmailPreferencesRequest, EmailPreferences>
      updateEmailPreferencesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEmailPreferencesServiceStub create(
      EmailPreferencesServiceStubSettings settings) throws IOException {
    return new GrpcEmailPreferencesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEmailPreferencesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEmailPreferencesServiceStub(
        EmailPreferencesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEmailPreferencesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEmailPreferencesServiceStub(
        EmailPreferencesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEmailPreferencesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEmailPreferencesServiceStub(
      EmailPreferencesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEmailPreferencesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEmailPreferencesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEmailPreferencesServiceStub(
      EmailPreferencesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetEmailPreferencesRequest, EmailPreferences>
        getEmailPreferencesTransportSettings =
            GrpcCallSettings.<GetEmailPreferencesRequest, EmailPreferences>newBuilder()
                .setMethodDescriptor(getEmailPreferencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEmailPreferencesRequest, EmailPreferences>
        updateEmailPreferencesTransportSettings =
            GrpcCallSettings.<UpdateEmailPreferencesRequest, EmailPreferences>newBuilder()
                .setMethodDescriptor(updateEmailPreferencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "email_preferences.name",
                          String.valueOf(request.getEmailPreferences().getName()));
                      return builder.build();
                    })
                .build();

    this.getEmailPreferencesCallable =
        callableFactory.createUnaryCallable(
            getEmailPreferencesTransportSettings,
            settings.getEmailPreferencesSettings(),
            clientContext);
    this.updateEmailPreferencesCallable =
        callableFactory.createUnaryCallable(
            updateEmailPreferencesTransportSettings,
            settings.updateEmailPreferencesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetEmailPreferencesRequest, EmailPreferences> getEmailPreferencesCallable() {
    return getEmailPreferencesCallable;
  }

  @Override
  public UnaryCallable<UpdateEmailPreferencesRequest, EmailPreferences>
      updateEmailPreferencesCallable() {
    return updateEmailPreferencesCallable;
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
