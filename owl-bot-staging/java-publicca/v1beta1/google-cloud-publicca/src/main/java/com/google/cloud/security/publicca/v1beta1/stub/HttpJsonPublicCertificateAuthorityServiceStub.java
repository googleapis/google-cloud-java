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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest;
import com.google.cloud.security.publicca.v1beta1.ExternalAccountKey;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the PublicCertificateAuthorityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPublicCertificateAuthorityServiceStub
    extends PublicCertificateAuthorityServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateExternalAccountKeyRequest, ExternalAccountKey>
      createExternalAccountKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateExternalAccountKeyRequest, ExternalAccountKey>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.publicca.v1beta1.PublicCertificateAuthorityService/CreateExternalAccountKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExternalAccountKeyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/externalAccountKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalAccountKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalAccountKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "externalAccountKey", request.getExternalAccountKey(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalAccountKey>newBuilder()
                      .setDefaultInstance(ExternalAccountKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateExternalAccountKeyRequest, ExternalAccountKey>
      createExternalAccountKeyCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPublicCertificateAuthorityServiceStub create(
      PublicCertificateAuthorityServiceStubSettings settings) throws IOException {
    return new HttpJsonPublicCertificateAuthorityServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonPublicCertificateAuthorityServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonPublicCertificateAuthorityServiceStub(
        PublicCertificateAuthorityServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPublicCertificateAuthorityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPublicCertificateAuthorityServiceStub(
        PublicCertificateAuthorityServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPublicCertificateAuthorityServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonPublicCertificateAuthorityServiceStub(
      PublicCertificateAuthorityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPublicCertificateAuthorityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPublicCertificateAuthorityServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonPublicCertificateAuthorityServiceStub(
      PublicCertificateAuthorityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateExternalAccountKeyRequest, ExternalAccountKey>
        createExternalAccountKeyTransportSettings =
            HttpJsonCallSettings.<CreateExternalAccountKeyRequest, ExternalAccountKey>newBuilder()
                .setMethodDescriptor(createExternalAccountKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createExternalAccountKeyCallable =
        callableFactory.createUnaryCallable(
            createExternalAccountKeyTransportSettings,
            settings.createExternalAccountKeySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createExternalAccountKeyMethodDescriptor);
    return methodDescriptors;
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
