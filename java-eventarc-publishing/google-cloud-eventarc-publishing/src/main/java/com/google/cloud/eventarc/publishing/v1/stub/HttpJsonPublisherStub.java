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

package com.google.cloud.eventarc.publishing.v1.stub;

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
import com.google.cloud.eventarc.publishing.v1.PublishChannelConnectionEventsRequest;
import com.google.cloud.eventarc.publishing.v1.PublishChannelConnectionEventsResponse;
import com.google.cloud.eventarc.publishing.v1.PublishEventsRequest;
import com.google.cloud.eventarc.publishing.v1.PublishEventsResponse;
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
 * REST stub implementation for the Publisher service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPublisherStub extends PublisherStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
      publishChannelConnectionEventsMethodDescriptor =
          ApiMethodDescriptor
              .<PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.eventarc.publishing.v1.Publisher/PublishChannelConnectionEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PublishChannelConnectionEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{channelConnection=projects/*/locations/*/channelConnections/*}:publishEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PublishChannelConnectionEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "channelConnection", request.getChannelConnection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PublishChannelConnectionEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearChannelConnection().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublishChannelConnectionEventsResponse>newBuilder()
                      .setDefaultInstance(
                          PublishChannelConnectionEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PublishEventsRequest, PublishEventsResponse>
      publishEventsMethodDescriptor =
          ApiMethodDescriptor.<PublishEventsRequest, PublishEventsResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.publishing.v1.Publisher/PublishEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PublishEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{channel=projects/*/locations/*/channels/*}:publishEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PublishEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "channel", request.getChannel());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PublishEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearChannel().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublishEventsResponse>newBuilder()
                      .setDefaultInstance(PublishEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
      publishChannelConnectionEventsCallable;
  private final UnaryCallable<PublishEventsRequest, PublishEventsResponse> publishEventsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPublisherStub create(PublisherStubSettings settings)
      throws IOException {
    return new HttpJsonPublisherStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPublisherStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonPublisherStub(
        PublisherStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPublisherStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPublisherStub(
        PublisherStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPublisherStub(PublisherStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPublisherCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPublisherStub(
      PublisherStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
        publishChannelConnectionEventsTransportSettings =
            HttpJsonCallSettings
                .<PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
                    newBuilder()
                .setMethodDescriptor(publishChannelConnectionEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PublishEventsRequest, PublishEventsResponse>
        publishEventsTransportSettings =
            HttpJsonCallSettings.<PublishEventsRequest, PublishEventsResponse>newBuilder()
                .setMethodDescriptor(publishEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.publishChannelConnectionEventsCallable =
        callableFactory.createUnaryCallable(
            publishChannelConnectionEventsTransportSettings,
            settings.publishChannelConnectionEventsSettings(),
            clientContext);
    this.publishEventsCallable =
        callableFactory.createUnaryCallable(
            publishEventsTransportSettings, settings.publishEventsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(publishChannelConnectionEventsMethodDescriptor);
    methodDescriptors.add(publishEventsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
      publishChannelConnectionEventsCallable() {
    return publishChannelConnectionEventsCallable;
  }

  @Override
  public UnaryCallable<PublishEventsRequest, PublishEventsResponse> publishEventsCallable() {
    return publishEventsCallable;
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
