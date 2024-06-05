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
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1beta.EmailPreferences;
import com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the EmailPreferencesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEmailPreferencesServiceStub extends EmailPreferencesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetEmailPreferencesRequest, EmailPreferences>
      getEmailPreferencesMethodDescriptor =
          ApiMethodDescriptor.<GetEmailPreferencesRequest, EmailPreferences>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.EmailPreferencesService/GetEmailPreferences")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEmailPreferencesRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/users/*/emailPreferences}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEmailPreferencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEmailPreferencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EmailPreferences>newBuilder()
                      .setDefaultInstance(EmailPreferences.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEmailPreferencesRequest, EmailPreferences>
      updateEmailPreferencesMethodDescriptor =
          ApiMethodDescriptor.<UpdateEmailPreferencesRequest, EmailPreferences>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.EmailPreferencesService/UpdateEmailPreferences")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEmailPreferencesRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{emailPreferences.name=accounts/*/users/*/emailPreferences}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEmailPreferencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "emailPreferences.name",
                                request.getEmailPreferences().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEmailPreferencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("emailPreferences", request.getEmailPreferences(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EmailPreferences>newBuilder()
                      .setDefaultInstance(EmailPreferences.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetEmailPreferencesRequest, EmailPreferences>
      getEmailPreferencesCallable;
  private final UnaryCallable<UpdateEmailPreferencesRequest, EmailPreferences>
      updateEmailPreferencesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEmailPreferencesServiceStub create(
      EmailPreferencesServiceStubSettings settings) throws IOException {
    return new HttpJsonEmailPreferencesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEmailPreferencesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEmailPreferencesServiceStub(
        EmailPreferencesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEmailPreferencesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEmailPreferencesServiceStub(
        EmailPreferencesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEmailPreferencesServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEmailPreferencesServiceStub(
      EmailPreferencesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEmailPreferencesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEmailPreferencesServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEmailPreferencesServiceStub(
      EmailPreferencesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetEmailPreferencesRequest, EmailPreferences>
        getEmailPreferencesTransportSettings =
            HttpJsonCallSettings.<GetEmailPreferencesRequest, EmailPreferences>newBuilder()
                .setMethodDescriptor(getEmailPreferencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEmailPreferencesRequest, EmailPreferences>
        updateEmailPreferencesTransportSettings =
            HttpJsonCallSettings.<UpdateEmailPreferencesRequest, EmailPreferences>newBuilder()
                .setMethodDescriptor(updateEmailPreferencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getEmailPreferencesMethodDescriptor);
    methodDescriptors.add(updateEmailPreferencesMethodDescriptor);
    return methodDescriptors;
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
