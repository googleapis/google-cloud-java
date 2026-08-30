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

import static com.google.ads.admanager.v1.ChildPublisherServiceClient.ListChildPublishersPagedResponse;

import com.google.ads.admanager.v1.BatchCreateChildPublishersRequest;
import com.google.ads.admanager.v1.BatchCreateChildPublishersResponse;
import com.google.ads.admanager.v1.BatchRejectChildPublishersRequest;
import com.google.ads.admanager.v1.BatchRejectChildPublishersResponse;
import com.google.ads.admanager.v1.BatchRenegotiateChildPublisherAgreementsRequest;
import com.google.ads.admanager.v1.BatchRenegotiateChildPublisherAgreementsResponse;
import com.google.ads.admanager.v1.BatchResendChildPublisherInvitationEmailsRequest;
import com.google.ads.admanager.v1.BatchResendChildPublisherInvitationEmailsResponse;
import com.google.ads.admanager.v1.BatchUpdateChildPublishersRequest;
import com.google.ads.admanager.v1.BatchUpdateChildPublishersResponse;
import com.google.ads.admanager.v1.BatchWithdrawChildPublishersRequest;
import com.google.ads.admanager.v1.BatchWithdrawChildPublishersResponse;
import com.google.ads.admanager.v1.ChildPublisher;
import com.google.ads.admanager.v1.CreateChildPublisherRequest;
import com.google.ads.admanager.v1.GetChildPublisherRequest;
import com.google.ads.admanager.v1.ListChildPublishersRequest;
import com.google.ads.admanager.v1.ListChildPublishersResponse;
import com.google.ads.admanager.v1.UpdateChildPublisherRequest;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ChildPublisherService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonChildPublisherServiceStub extends ChildPublisherServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetChildPublisherRequest, ChildPublisher>
      getChildPublisherMethodDescriptor =
          ApiMethodDescriptor.<GetChildPublisherRequest, ChildPublisher>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ChildPublisherService/GetChildPublisher")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChildPublisherRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/childPublishers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChildPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChildPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChildPublisher>newBuilder()
                      .setDefaultInstance(ChildPublisher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListChildPublishersRequest, ListChildPublishersResponse>
      listChildPublishersMethodDescriptor =
          ApiMethodDescriptor.<ListChildPublishersRequest, ListChildPublishersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/ListChildPublishers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChildPublishersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChildPublishersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListChildPublishersResponse>newBuilder()
                      .setDefaultInstance(ListChildPublishersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateChildPublisherRequest, ChildPublisher>
      createChildPublisherMethodDescriptor =
          ApiMethodDescriptor.<CreateChildPublisherRequest, ChildPublisher>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/CreateChildPublisher")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateChildPublisherRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChildPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChildPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("childPublisher", request.getChildPublisher(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChildPublisher>newBuilder()
                      .setDefaultInstance(ChildPublisher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/BatchCreateChildPublishers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateChildPublishersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateChildPublishersResponse>newBuilder()
                      .setDefaultInstance(BatchCreateChildPublishersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateChildPublisherRequest, ChildPublisher>
      updateChildPublisherMethodDescriptor =
          ApiMethodDescriptor.<UpdateChildPublisherRequest, ChildPublisher>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/UpdateChildPublisher")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateChildPublisherRequest>newBuilder()
                      .setPath(
                          "/v1/{childPublisher.name=networks/*/childPublishers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChildPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "childPublisher.name",
                                request.getChildPublisher().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChildPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("childPublisher", request.getChildPublisher(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChildPublisher>newBuilder()
                      .setDefaultInstance(ChildPublisher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/BatchUpdateChildPublishers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateChildPublishersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateChildPublishersResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateChildPublishersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchResendChildPublisherInvitationEmailsRequest,
          BatchResendChildPublisherInvitationEmailsResponse>
      batchResendChildPublisherInvitationEmailsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchResendChildPublisherInvitationEmailsRequest,
                  BatchResendChildPublisherInvitationEmailsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/BatchResendChildPublisherInvitationEmails")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchResendChildPublisherInvitationEmailsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers:batchResendInvitationEmails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResendChildPublisherInvitationEmailsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResendChildPublisherInvitationEmailsRequest>
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
                      .<BatchResendChildPublisherInvitationEmailsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchResendChildPublisherInvitationEmailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRenegotiateChildPublisherAgreementsRequest,
          BatchRenegotiateChildPublisherAgreementsResponse>
      batchRenegotiateChildPublisherAgreementsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRenegotiateChildPublisherAgreementsRequest,
                  BatchRenegotiateChildPublisherAgreementsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/BatchRenegotiateChildPublisherAgreements")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchRenegotiateChildPublisherAgreementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers:batchRenegotiateAgreements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRenegotiateChildPublisherAgreementsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRenegotiateChildPublisherAgreementsRequest>
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
                      .<BatchRenegotiateChildPublisherAgreementsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchRenegotiateChildPublisherAgreementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>
      batchRejectChildPublishersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/BatchRejectChildPublishers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRejectChildPublishersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers:batchReject",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRejectChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRejectChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchRejectChildPublishersResponse>newBuilder()
                      .setDefaultInstance(BatchRejectChildPublishersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
      batchWithdrawChildPublishersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ChildPublisherService/BatchWithdrawChildPublishers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchWithdrawChildPublishersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/childPublishers:batchWithdraw",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWithdrawChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWithdrawChildPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchWithdrawChildPublishersResponse>newBuilder()
                      .setDefaultInstance(BatchWithdrawChildPublishersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetChildPublisherRequest, ChildPublisher> getChildPublisherCallable;
  private final UnaryCallable<ListChildPublishersRequest, ListChildPublishersResponse>
      listChildPublishersCallable;
  private final UnaryCallable<ListChildPublishersRequest, ListChildPublishersPagedResponse>
      listChildPublishersPagedCallable;
  private final UnaryCallable<CreateChildPublisherRequest, ChildPublisher>
      createChildPublisherCallable;
  private final UnaryCallable<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersCallable;
  private final UnaryCallable<UpdateChildPublisherRequest, ChildPublisher>
      updateChildPublisherCallable;
  private final UnaryCallable<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersCallable;
  private final UnaryCallable<
          BatchResendChildPublisherInvitationEmailsRequest,
          BatchResendChildPublisherInvitationEmailsResponse>
      batchResendChildPublisherInvitationEmailsCallable;
  private final UnaryCallable<
          BatchRenegotiateChildPublisherAgreementsRequest,
          BatchRenegotiateChildPublisherAgreementsResponse>
      batchRenegotiateChildPublisherAgreementsCallable;
  private final UnaryCallable<BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>
      batchRejectChildPublishersCallable;
  private final UnaryCallable<
          BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
      batchWithdrawChildPublishersCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonChildPublisherServiceStub create(
      ChildPublisherServiceStubSettings settings) throws IOException {
    return new HttpJsonChildPublisherServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonChildPublisherServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonChildPublisherServiceStub(
        ChildPublisherServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonChildPublisherServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonChildPublisherServiceStub(
        ChildPublisherServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonChildPublisherServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonChildPublisherServiceStub(
      ChildPublisherServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonChildPublisherServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonChildPublisherServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonChildPublisherServiceStub(
      ChildPublisherServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetChildPublisherRequest, ChildPublisher>
        getChildPublisherTransportSettings =
            HttpJsonCallSettings.<GetChildPublisherRequest, ChildPublisher>newBuilder()
                .setMethodDescriptor(getChildPublisherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListChildPublishersRequest, ListChildPublishersResponse>
        listChildPublishersTransportSettings =
            HttpJsonCallSettings
                .<ListChildPublishersRequest, ListChildPublishersResponse>newBuilder()
                .setMethodDescriptor(listChildPublishersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateChildPublisherRequest, ChildPublisher>
        createChildPublisherTransportSettings =
            HttpJsonCallSettings.<CreateChildPublisherRequest, ChildPublisher>newBuilder()
                .setMethodDescriptor(createChildPublisherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
        batchCreateChildPublishersTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>newBuilder()
                .setMethodDescriptor(batchCreateChildPublishersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateChildPublisherRequest, ChildPublisher>
        updateChildPublisherTransportSettings =
            HttpJsonCallSettings.<UpdateChildPublisherRequest, ChildPublisher>newBuilder()
                .setMethodDescriptor(updateChildPublisherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "child_publisher.name",
                          String.valueOf(request.getChildPublisher().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
        batchUpdateChildPublishersTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>newBuilder()
                .setMethodDescriptor(batchUpdateChildPublishersMethodDescriptor)
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
            BatchResendChildPublisherInvitationEmailsRequest,
            BatchResendChildPublisherInvitationEmailsResponse>
        batchResendChildPublisherInvitationEmailsTransportSettings =
            HttpJsonCallSettings
                .<BatchResendChildPublisherInvitationEmailsRequest,
                    BatchResendChildPublisherInvitationEmailsResponse>
                    newBuilder()
                .setMethodDescriptor(batchResendChildPublisherInvitationEmailsMethodDescriptor)
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
            BatchRenegotiateChildPublisherAgreementsRequest,
            BatchRenegotiateChildPublisherAgreementsResponse>
        batchRenegotiateChildPublisherAgreementsTransportSettings =
            HttpJsonCallSettings
                .<BatchRenegotiateChildPublisherAgreementsRequest,
                    BatchRenegotiateChildPublisherAgreementsResponse>
                    newBuilder()
                .setMethodDescriptor(batchRenegotiateChildPublisherAgreementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>
        batchRejectChildPublishersTransportSettings =
            HttpJsonCallSettings
                .<BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>newBuilder()
                .setMethodDescriptor(batchRejectChildPublishersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
        batchWithdrawChildPublishersTransportSettings =
            HttpJsonCallSettings
                .<BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
                    newBuilder()
                .setMethodDescriptor(batchWithdrawChildPublishersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getChildPublisherCallable =
        callableFactory.createUnaryCallable(
            getChildPublisherTransportSettings,
            settings.getChildPublisherSettings(),
            clientContext);
    this.listChildPublishersCallable =
        callableFactory.createUnaryCallable(
            listChildPublishersTransportSettings,
            settings.listChildPublishersSettings(),
            clientContext);
    this.listChildPublishersPagedCallable =
        callableFactory.createPagedCallable(
            listChildPublishersTransportSettings,
            settings.listChildPublishersSettings(),
            clientContext);
    this.createChildPublisherCallable =
        callableFactory.createUnaryCallable(
            createChildPublisherTransportSettings,
            settings.createChildPublisherSettings(),
            clientContext);
    this.batchCreateChildPublishersCallable =
        callableFactory.createUnaryCallable(
            batchCreateChildPublishersTransportSettings,
            settings.batchCreateChildPublishersSettings(),
            clientContext);
    this.updateChildPublisherCallable =
        callableFactory.createUnaryCallable(
            updateChildPublisherTransportSettings,
            settings.updateChildPublisherSettings(),
            clientContext);
    this.batchUpdateChildPublishersCallable =
        callableFactory.createUnaryCallable(
            batchUpdateChildPublishersTransportSettings,
            settings.batchUpdateChildPublishersSettings(),
            clientContext);
    this.batchResendChildPublisherInvitationEmailsCallable =
        callableFactory.createUnaryCallable(
            batchResendChildPublisherInvitationEmailsTransportSettings,
            settings.batchResendChildPublisherInvitationEmailsSettings(),
            clientContext);
    this.batchRenegotiateChildPublisherAgreementsCallable =
        callableFactory.createUnaryCallable(
            batchRenegotiateChildPublisherAgreementsTransportSettings,
            settings.batchRenegotiateChildPublisherAgreementsSettings(),
            clientContext);
    this.batchRejectChildPublishersCallable =
        callableFactory.createUnaryCallable(
            batchRejectChildPublishersTransportSettings,
            settings.batchRejectChildPublishersSettings(),
            clientContext);
    this.batchWithdrawChildPublishersCallable =
        callableFactory.createUnaryCallable(
            batchWithdrawChildPublishersTransportSettings,
            settings.batchWithdrawChildPublishersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getChildPublisherMethodDescriptor);
    methodDescriptors.add(listChildPublishersMethodDescriptor);
    methodDescriptors.add(createChildPublisherMethodDescriptor);
    methodDescriptors.add(batchCreateChildPublishersMethodDescriptor);
    methodDescriptors.add(updateChildPublisherMethodDescriptor);
    methodDescriptors.add(batchUpdateChildPublishersMethodDescriptor);
    methodDescriptors.add(batchResendChildPublisherInvitationEmailsMethodDescriptor);
    methodDescriptors.add(batchRenegotiateChildPublisherAgreementsMethodDescriptor);
    methodDescriptors.add(batchRejectChildPublishersMethodDescriptor);
    methodDescriptors.add(batchWithdrawChildPublishersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetChildPublisherRequest, ChildPublisher> getChildPublisherCallable() {
    return getChildPublisherCallable;
  }

  @Override
  public UnaryCallable<ListChildPublishersRequest, ListChildPublishersResponse>
      listChildPublishersCallable() {
    return listChildPublishersCallable;
  }

  @Override
  public UnaryCallable<ListChildPublishersRequest, ListChildPublishersPagedResponse>
      listChildPublishersPagedCallable() {
    return listChildPublishersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateChildPublisherRequest, ChildPublisher> createChildPublisherCallable() {
    return createChildPublisherCallable;
  }

  @Override
  public UnaryCallable<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersCallable() {
    return batchCreateChildPublishersCallable;
  }

  @Override
  public UnaryCallable<UpdateChildPublisherRequest, ChildPublisher> updateChildPublisherCallable() {
    return updateChildPublisherCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersCallable() {
    return batchUpdateChildPublishersCallable;
  }

  @Override
  public UnaryCallable<
          BatchResendChildPublisherInvitationEmailsRequest,
          BatchResendChildPublisherInvitationEmailsResponse>
      batchResendChildPublisherInvitationEmailsCallable() {
    return batchResendChildPublisherInvitationEmailsCallable;
  }

  @Override
  public UnaryCallable<
          BatchRenegotiateChildPublisherAgreementsRequest,
          BatchRenegotiateChildPublisherAgreementsResponse>
      batchRenegotiateChildPublisherAgreementsCallable() {
    return batchRenegotiateChildPublisherAgreementsCallable;
  }

  @Override
  public UnaryCallable<BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>
      batchRejectChildPublishersCallable() {
    return batchRejectChildPublishersCallable;
  }

  @Override
  public UnaryCallable<BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
      batchWithdrawChildPublishersCallable() {
    return batchWithdrawChildPublishersCallable;
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
