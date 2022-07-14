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

package com.google.protos.google.cloud.binaryauthorization.v1.stub;

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
import com.google.protobuf.TypeRegistry;
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the SystemPolicyV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSystemPolicyV1Stub extends SystemPolicyV1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<Service.GetSystemPolicyRequest, Resources.Policy>
      getSystemPolicyMethodDescriptor =
          ApiMethodDescriptor.<Service.GetSystemPolicyRequest, Resources.Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.SystemPolicyV1/GetSystemPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.GetSystemPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=locations/*/policy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.GetSystemPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.GetSystemPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resources.Policy>newBuilder()
                      .setDefaultInstance(Resources.Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<Service.GetSystemPolicyRequest, Resources.Policy>
      getSystemPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSystemPolicyV1Stub create(SystemPolicyV1StubSettings settings)
      throws IOException {
    return new HttpJsonSystemPolicyV1Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSystemPolicyV1Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSystemPolicyV1Stub(
        SystemPolicyV1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSystemPolicyV1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSystemPolicyV1Stub(
        SystemPolicyV1StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSystemPolicyV1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSystemPolicyV1Stub(
      SystemPolicyV1StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSystemPolicyV1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSystemPolicyV1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSystemPolicyV1Stub(
      SystemPolicyV1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<Service.GetSystemPolicyRequest, Resources.Policy>
        getSystemPolicyTransportSettings =
            HttpJsonCallSettings.<Service.GetSystemPolicyRequest, Resources.Policy>newBuilder()
                .setMethodDescriptor(getSystemPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getSystemPolicyCallable =
        callableFactory.createUnaryCallable(
            getSystemPolicyTransportSettings, settings.getSystemPolicySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSystemPolicyMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<Service.GetSystemPolicyRequest, Resources.Policy> getSystemPolicyCallable() {
    return getSystemPolicyCallable;
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
