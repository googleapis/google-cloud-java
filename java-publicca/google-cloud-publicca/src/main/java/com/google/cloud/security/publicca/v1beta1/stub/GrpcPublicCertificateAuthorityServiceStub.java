/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.security.publicca.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest;
import com.google.cloud.security.publicca.v1beta1.ExternalAccountKey;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PublicCertificateAuthorityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPublicCertificateAuthorityServiceStub
    extends PublicCertificateAuthorityServiceStub {
  private static final MethodDescriptor<CreateExternalAccountKeyRequest, ExternalAccountKey>
      createExternalAccountKeyMethodDescriptor =
          MethodDescriptor.<CreateExternalAccountKeyRequest, ExternalAccountKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.publicca.v1beta1.PublicCertificateAuthorityService/CreateExternalAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExternalAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalAccountKey.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateExternalAccountKeyRequest, ExternalAccountKey>
      createExternalAccountKeyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPublicCertificateAuthorityServiceStub create(
      PublicCertificateAuthorityServiceStubSettings settings) throws IOException {
    return new GrpcPublicCertificateAuthorityServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPublicCertificateAuthorityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPublicCertificateAuthorityServiceStub(
        PublicCertificateAuthorityServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPublicCertificateAuthorityServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPublicCertificateAuthorityServiceStub(
        PublicCertificateAuthorityServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcPublicCertificateAuthorityServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcPublicCertificateAuthorityServiceStub(
      PublicCertificateAuthorityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPublicCertificateAuthorityServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPublicCertificateAuthorityServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcPublicCertificateAuthorityServiceStub(
      PublicCertificateAuthorityServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateExternalAccountKeyRequest, ExternalAccountKey>
        createExternalAccountKeyTransportSettings =
            GrpcCallSettings.<CreateExternalAccountKeyRequest, ExternalAccountKey>newBuilder()
                .setMethodDescriptor(createExternalAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.createExternalAccountKeyCallable =
        callableFactory.createUnaryCallable(
            createExternalAccountKeyTransportSettings,
            settings.createExternalAccountKeySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateExternalAccountKeyRequest, ExternalAccountKey>
      createExternalAccountKeyCallable() {
    return createExternalAccountKeyCallable;
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
