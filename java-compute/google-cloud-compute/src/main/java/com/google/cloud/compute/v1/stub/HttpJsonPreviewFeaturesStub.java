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

import static com.google.cloud.compute.v1.PreviewFeaturesClient.ListPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetPreviewFeatureRequest;
import com.google.cloud.compute.v1.ListPreviewFeaturesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PreviewFeature;
import com.google.cloud.compute.v1.PreviewFeatureList;
import com.google.cloud.compute.v1.UpdatePreviewFeatureRequest;
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
 * REST stub implementation for the PreviewFeatures service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPreviewFeaturesStub extends PreviewFeaturesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<GetPreviewFeatureRequest, PreviewFeature>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetPreviewFeatureRequest, PreviewFeature>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PreviewFeatures/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPreviewFeatureRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/previewFeatures/{previewFeature}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPreviewFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "previewFeature", request.getPreviewFeature());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPreviewFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreviewFeature>newBuilder()
                      .setDefaultInstance(PreviewFeature.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPreviewFeaturesRequest, PreviewFeatureList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListPreviewFeaturesRequest, PreviewFeatureList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PreviewFeatures/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPreviewFeaturesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/previewFeatures",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPreviewFeaturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPreviewFeaturesRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreviewFeatureList>newBuilder()
                      .setDefaultInstance(PreviewFeatureList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePreviewFeatureRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdatePreviewFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PreviewFeatures/Update")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePreviewFeatureRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/previewFeatures/{previewFeature}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePreviewFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "previewFeature", request.getPreviewFeature());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePreviewFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "previewFeatureResource",
                                      request.getPreviewFeatureResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePreviewFeatureRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<GetPreviewFeatureRequest, PreviewFeature> getCallable;
  private final UnaryCallable<ListPreviewFeaturesRequest, PreviewFeatureList> listCallable;
  private final UnaryCallable<ListPreviewFeaturesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<UpdatePreviewFeatureRequest, Operation> updateCallable;
  private final OperationCallable<UpdatePreviewFeatureRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPreviewFeaturesStub create(PreviewFeaturesStubSettings settings)
      throws IOException {
    return new HttpJsonPreviewFeaturesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPreviewFeaturesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPreviewFeaturesStub(
        PreviewFeaturesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPreviewFeaturesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPreviewFeaturesStub(
        PreviewFeaturesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPreviewFeaturesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPreviewFeaturesStub(
      PreviewFeaturesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPreviewFeaturesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPreviewFeaturesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPreviewFeaturesStub(
      PreviewFeaturesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<GetPreviewFeatureRequest, PreviewFeature> getTransportSettings =
        HttpJsonCallSettings.<GetPreviewFeatureRequest, PreviewFeature>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("preview_feature", String.valueOf(request.getPreviewFeature()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPreviewFeaturesRequest, PreviewFeatureList> listTransportSettings =
        HttpJsonCallSettings.<ListPreviewFeaturesRequest, PreviewFeatureList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePreviewFeatureRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdatePreviewFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("preview_feature", String.valueOf(request.getPreviewFeature()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.updateOperationCallable =
        callableFactory.createOperationCallable(
            updateTransportSettings,
            settings.updateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetPreviewFeatureRequest, PreviewFeature> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListPreviewFeaturesRequest, PreviewFeatureList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListPreviewFeaturesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePreviewFeatureRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdatePreviewFeatureRequest, Operation, Operation>
      updateOperationCallable() {
    return updateOperationCallable;
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
