/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.compute.v1.stub;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.GetGlobalFrontendSettingRequest;
import com.google.cloud.compute.v1.GlobalFrontendSettings;
import com.google.cloud.compute.v1.GlobalFrontendSettingsPatchResponse;
import com.google.cloud.compute.v1.PatchGlobalFrontendSettingRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GlobalFrontendSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonGlobalFrontendSettingsServiceStub extends GlobalFrontendSettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetGlobalFrontendSettingRequest, GlobalFrontendSettings>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalFrontendSettingRequest, GlobalFrontendSettings>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalFrontendSettingsService/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalFrontendSettingRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/globalFrontendSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalFrontendSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalFrontendSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlobalFrontendSettings>newBuilder()
                      .setDefaultInstance(GlobalFrontendSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchGlobalFrontendSettingRequest, GlobalFrontendSettingsPatchResponse>
      patchMethodDescriptor =
          ApiMethodDescriptor
              .<PatchGlobalFrontendSettingRequest, GlobalFrontendSettingsPatchResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalFrontendSettingsService/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchGlobalFrontendSettingRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/globalFrontendSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchGlobalFrontendSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchGlobalFrontendSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasUpdateMask()) {
                              serializer.putQueryParam(
                                  fields, "updateMask", request.getUpdateMask());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalFrontendSettingsResource",
                                      request.getGlobalFrontendSettingsResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlobalFrontendSettingsPatchResponse>newBuilder()
                      .setDefaultInstance(GlobalFrontendSettingsPatchResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetGlobalFrontendSettingRequest, GlobalFrontendSettings> getCallable;
  private final UnaryCallable<
          PatchGlobalFrontendSettingRequest, GlobalFrontendSettingsPatchResponse>
      patchCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate PATCH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");

  public static final HttpJsonGlobalFrontendSettingsServiceStub create(
      GlobalFrontendSettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonGlobalFrontendSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalFrontendSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalFrontendSettingsServiceStub(
        GlobalFrontendSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalFrontendSettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalFrontendSettingsServiceStub(
        GlobalFrontendSettingsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalFrontendSettingsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalFrontendSettingsServiceStub(
      GlobalFrontendSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalFrontendSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalFrontendSettingsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalFrontendSettingsServiceStub(
      GlobalFrontendSettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetGlobalFrontendSettingRequest, GlobalFrontendSettings>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalFrontendSettingRequest, GlobalFrontendSettings>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<PatchGlobalFrontendSettingRequest, GlobalFrontendSettingsPatchResponse>
        patchTransportSettings =
            HttpJsonCallSettings
                .<PatchGlobalFrontendSettingRequest, GlobalFrontendSettingsPatchResponse>
                    newBuilder()
                .setMethodDescriptor(patchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return PATCH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetGlobalFrontendSettingRequest, GlobalFrontendSettings> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<PatchGlobalFrontendSettingRequest, GlobalFrontendSettingsPatchResponse>
      patchCallable() {
    return patchCallable;
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
