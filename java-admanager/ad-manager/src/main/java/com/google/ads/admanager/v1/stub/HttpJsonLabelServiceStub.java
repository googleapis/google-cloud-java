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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.LabelServiceClient.ListLabelsPagedResponse;

import com.google.ads.admanager.v1.GetLabelRequest;
import com.google.ads.admanager.v1.Label;
import com.google.ads.admanager.v1.ListLabelsRequest;
import com.google.ads.admanager.v1.ListLabelsResponse;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LabelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLabelServiceStub extends LabelServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLabelRequest, Label> getLabelMethodDescriptor =
      ApiMethodDescriptor.<GetLabelRequest, Label>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.LabelService/GetLabel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetLabelRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/labels/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Label>newBuilder()
                  .setDefaultInstance(Label.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListLabelsRequest, ListLabelsResponse>
      listLabelsMethodDescriptor =
          ApiMethodDescriptor.<ListLabelsRequest, ListLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LabelService/ListLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/labels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLabelsResponse>newBuilder()
                      .setDefaultInstance(ListLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLabelRequest, Label> getLabelCallable;
  private final UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable;
  private final UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLabelServiceStub create(LabelServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLabelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLabelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLabelServiceStub(
        LabelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLabelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLabelServiceStub(
        LabelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLabelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLabelServiceStub(LabelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLabelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLabelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLabelServiceStub(
      LabelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLabelRequest, Label> getLabelTransportSettings =
        HttpJsonCallSettings.<GetLabelRequest, Label>newBuilder()
            .setMethodDescriptor(getLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLabelsRequest, ListLabelsResponse> listLabelsTransportSettings =
        HttpJsonCallSettings.<ListLabelsRequest, ListLabelsResponse>newBuilder()
            .setMethodDescriptor(listLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getLabelCallable =
        callableFactory.createUnaryCallable(
            getLabelTransportSettings, settings.getLabelSettings(), clientContext);
    this.listLabelsCallable =
        callableFactory.createUnaryCallable(
            listLabelsTransportSettings, settings.listLabelsSettings(), clientContext);
    this.listLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listLabelsTransportSettings, settings.listLabelsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLabelMethodDescriptor);
    methodDescriptors.add(listLabelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLabelRequest, Label> getLabelCallable() {
    return getLabelCallable;
  }

  @Override
  public UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable() {
    return listLabelsCallable;
  }

  @Override
  public UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable() {
    return listLabelsPagedCallable;
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
