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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.LineItemCreativeAssociationServiceClient.ListLineItemCreativeAssociationsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchActivateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchCreateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchCreateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchDeactivateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchDeactivateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchDeleteLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.CreateLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.GetLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.LineItemCreativeAssociation;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.PreviewLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.PreviewLineItemCreativeAssociationResponse;
import com.google.ads.admanager.v1.UpdateLineItemCreativeAssociationRequest;
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
import com.google.protobuf.Empty;
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
 * REST stub implementation for the LineItemCreativeAssociationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLineItemCreativeAssociationServiceStub
    extends LineItemCreativeAssociationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/GetLineItemCreativeAssociation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLineItemCreativeAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/lineItems/*/creatives/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemCreativeAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemCreativeAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItemCreativeAssociation>newBuilder()
                      .setDefaultInstance(LineItemCreativeAssociation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
      listLineItemCreativeAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/ListLineItemCreativeAssociations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLineItemCreativeAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
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
                  ProtoMessageResponseParser.<ListLineItemCreativeAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          ListLineItemCreativeAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/CreateLineItemCreativeAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateLineItemCreativeAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLineItemCreativeAssociationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLineItemCreativeAssociationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "lineItemCreativeAssociation",
                                      request.getLineItemCreativeAssociation(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItemCreativeAssociation>newBuilder()
                      .setDefaultInstance(LineItemCreativeAssociation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateLineItemCreativeAssociationsRequest,
                  BatchCreateLineItemCreativeAssociationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/BatchCreateLineItemCreativeAssociations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchCreateLineItemCreativeAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchCreateLineItemCreativeAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateLineItemCreativeAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/UpdateLineItemCreativeAssociation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateLineItemCreativeAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{lineItemCreativeAssociation.name=networks/*/lineItems/*/creatives/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLineItemCreativeAssociationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "lineItemCreativeAssociation.name",
                                request.getLineItemCreativeAssociation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLineItemCreativeAssociationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "lineItemCreativeAssociation",
                                      request.getLineItemCreativeAssociation(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItemCreativeAssociation>newBuilder()
                      .setDefaultInstance(LineItemCreativeAssociation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateLineItemCreativeAssociationsRequest,
                  BatchUpdateLineItemCreativeAssociationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/BatchUpdateLineItemCreativeAssociations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchUpdateLineItemCreativeAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchUpdateLineItemCreativeAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateLineItemCreativeAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateLineItemCreativeAssociationsRequest,
                  BatchActivateLineItemCreativeAssociationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/BatchActivateLineItemCreativeAssociations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchActivateLineItemCreativeAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchActivateLineItemCreativeAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateLineItemCreativeAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateLineItemCreativeAssociationsRequest,
                  BatchDeactivateLineItemCreativeAssociationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/BatchDeactivateLineItemCreativeAssociations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDeactivateLineItemCreativeAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchDeactivateLineItemCreativeAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateLineItemCreativeAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteLineItemCreativeAssociationsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/BatchDeleteLineItemCreativeAssociations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDeleteLineItemCreativeAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/lineItems/*}/creatives:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteLineItemCreativeAssociationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<PreviewLineItemCreativeAssociationRequest,
                  PreviewLineItemCreativeAssociationResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemCreativeAssociationService/PreviewLineItemCreativeAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PreviewLineItemCreativeAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/lineItems/*/creatives/*}:preview",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewLineItemCreativeAssociationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewLineItemCreativeAssociationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<PreviewLineItemCreativeAssociationResponse>newBuilder()
                      .setDefaultInstance(
                          PreviewLineItemCreativeAssociationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationCallable;
  private final UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
      listLineItemCreativeAssociationsCallable;
  private final UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsPagedResponse>
      listLineItemCreativeAssociationsPagedCallable;
  private final UnaryCallable<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationCallable;
  private final UnaryCallable<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsCallable;
  private final UnaryCallable<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationCallable;
  private final UnaryCallable<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsCallable;
  private final UnaryCallable<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsCallable;
  private final UnaryCallable<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsCallable;
  private final UnaryCallable<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsCallable;
  private final UnaryCallable<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLineItemCreativeAssociationServiceStub create(
      LineItemCreativeAssociationServiceStubSettings settings) throws IOException {
    return new HttpJsonLineItemCreativeAssociationServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonLineItemCreativeAssociationServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonLineItemCreativeAssociationServiceStub(
        LineItemCreativeAssociationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLineItemCreativeAssociationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLineItemCreativeAssociationServiceStub(
        LineItemCreativeAssociationServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLineItemCreativeAssociationServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonLineItemCreativeAssociationServiceStub(
      LineItemCreativeAssociationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLineItemCreativeAssociationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLineItemCreativeAssociationServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonLineItemCreativeAssociationServiceStub(
      LineItemCreativeAssociationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        getLineItemCreativeAssociationTransportSettings =
            HttpJsonCallSettings
                .<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>newBuilder()
                .setMethodDescriptor(getLineItemCreativeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
        listLineItemCreativeAssociationsTransportSettings =
            HttpJsonCallSettings
                .<ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(listLineItemCreativeAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        createLineItemCreativeAssociationTransportSettings =
            HttpJsonCallSettings
                .<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>newBuilder()
                .setMethodDescriptor(createLineItemCreativeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchCreateLineItemCreativeAssociationsRequest,
            BatchCreateLineItemCreativeAssociationsResponse>
        batchCreateLineItemCreativeAssociationsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateLineItemCreativeAssociationsRequest,
                    BatchCreateLineItemCreativeAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateLineItemCreativeAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        updateLineItemCreativeAssociationTransportSettings =
            HttpJsonCallSettings
                .<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>newBuilder()
                .setMethodDescriptor(updateLineItemCreativeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "line_item_creative_association.name",
                          String.valueOf(request.getLineItemCreativeAssociation().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateLineItemCreativeAssociationsRequest,
            BatchUpdateLineItemCreativeAssociationsResponse>
        batchUpdateLineItemCreativeAssociationsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateLineItemCreativeAssociationsRequest,
                    BatchUpdateLineItemCreativeAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateLineItemCreativeAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchActivateLineItemCreativeAssociationsRequest,
            BatchActivateLineItemCreativeAssociationsResponse>
        batchActivateLineItemCreativeAssociationsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateLineItemCreativeAssociationsRequest,
                    BatchActivateLineItemCreativeAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateLineItemCreativeAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchDeactivateLineItemCreativeAssociationsRequest,
            BatchDeactivateLineItemCreativeAssociationsResponse>
        batchDeactivateLineItemCreativeAssociationsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateLineItemCreativeAssociationsRequest,
                    BatchDeactivateLineItemCreativeAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateLineItemCreativeAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
        batchDeleteLineItemCreativeAssociationsTransportSettings =
            HttpJsonCallSettings.<BatchDeleteLineItemCreativeAssociationsRequest, Empty>newBuilder()
                .setMethodDescriptor(batchDeleteLineItemCreativeAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
        previewLineItemCreativeAssociationTransportSettings =
            HttpJsonCallSettings
                .<PreviewLineItemCreativeAssociationRequest,
                    PreviewLineItemCreativeAssociationResponse>
                    newBuilder()
                .setMethodDescriptor(previewLineItemCreativeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.getLineItemCreativeAssociationCallable =
        callableFactory.createUnaryCallable(
            getLineItemCreativeAssociationTransportSettings,
            settings.getLineItemCreativeAssociationSettings(),
            clientContext);
    this.listLineItemCreativeAssociationsCallable =
        callableFactory.createUnaryCallable(
            listLineItemCreativeAssociationsTransportSettings,
            settings.listLineItemCreativeAssociationsSettings(),
            clientContext);
    this.listLineItemCreativeAssociationsPagedCallable =
        callableFactory.createPagedCallable(
            listLineItemCreativeAssociationsTransportSettings,
            settings.listLineItemCreativeAssociationsSettings(),
            clientContext);
    this.createLineItemCreativeAssociationCallable =
        callableFactory.createUnaryCallable(
            createLineItemCreativeAssociationTransportSettings,
            settings.createLineItemCreativeAssociationSettings(),
            clientContext);
    this.batchCreateLineItemCreativeAssociationsCallable =
        callableFactory.createUnaryCallable(
            batchCreateLineItemCreativeAssociationsTransportSettings,
            settings.batchCreateLineItemCreativeAssociationsSettings(),
            clientContext);
    this.updateLineItemCreativeAssociationCallable =
        callableFactory.createUnaryCallable(
            updateLineItemCreativeAssociationTransportSettings,
            settings.updateLineItemCreativeAssociationSettings(),
            clientContext);
    this.batchUpdateLineItemCreativeAssociationsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateLineItemCreativeAssociationsTransportSettings,
            settings.batchUpdateLineItemCreativeAssociationsSettings(),
            clientContext);
    this.batchActivateLineItemCreativeAssociationsCallable =
        callableFactory.createUnaryCallable(
            batchActivateLineItemCreativeAssociationsTransportSettings,
            settings.batchActivateLineItemCreativeAssociationsSettings(),
            clientContext);
    this.batchDeactivateLineItemCreativeAssociationsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateLineItemCreativeAssociationsTransportSettings,
            settings.batchDeactivateLineItemCreativeAssociationsSettings(),
            clientContext);
    this.batchDeleteLineItemCreativeAssociationsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteLineItemCreativeAssociationsTransportSettings,
            settings.batchDeleteLineItemCreativeAssociationsSettings(),
            clientContext);
    this.previewLineItemCreativeAssociationCallable =
        callableFactory.createUnaryCallable(
            previewLineItemCreativeAssociationTransportSettings,
            settings.previewLineItemCreativeAssociationSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLineItemCreativeAssociationMethodDescriptor);
    methodDescriptors.add(listLineItemCreativeAssociationsMethodDescriptor);
    methodDescriptors.add(createLineItemCreativeAssociationMethodDescriptor);
    methodDescriptors.add(batchCreateLineItemCreativeAssociationsMethodDescriptor);
    methodDescriptors.add(updateLineItemCreativeAssociationMethodDescriptor);
    methodDescriptors.add(batchUpdateLineItemCreativeAssociationsMethodDescriptor);
    methodDescriptors.add(batchActivateLineItemCreativeAssociationsMethodDescriptor);
    methodDescriptors.add(batchDeactivateLineItemCreativeAssociationsMethodDescriptor);
    methodDescriptors.add(batchDeleteLineItemCreativeAssociationsMethodDescriptor);
    methodDescriptors.add(previewLineItemCreativeAssociationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationCallable() {
    return getLineItemCreativeAssociationCallable;
  }

  @Override
  public UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
      listLineItemCreativeAssociationsCallable() {
    return listLineItemCreativeAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsPagedResponse>
      listLineItemCreativeAssociationsPagedCallable() {
    return listLineItemCreativeAssociationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationCallable() {
    return createLineItemCreativeAssociationCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsCallable() {
    return batchCreateLineItemCreativeAssociationsCallable;
  }

  @Override
  public UnaryCallable<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationCallable() {
    return updateLineItemCreativeAssociationCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsCallable() {
    return batchUpdateLineItemCreativeAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsCallable() {
    return batchActivateLineItemCreativeAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsCallable() {
    return batchDeactivateLineItemCreativeAssociationsCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsCallable() {
    return batchDeleteLineItemCreativeAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationCallable() {
    return previewLineItemCreativeAssociationCallable;
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
