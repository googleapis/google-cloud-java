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

import static com.google.ads.admanager.v1.DaiEncodingProfileServiceClient.ListDaiEncodingProfilesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchActivateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchArchiveDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchArchiveDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchCreateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchCreateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchUpdateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchUpdateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.CreateDaiEncodingProfileRequest;
import com.google.ads.admanager.v1.DaiEncodingProfile;
import com.google.ads.admanager.v1.GetDaiEncodingProfileRequest;
import com.google.ads.admanager.v1.ListDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.ListDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.UpdateDaiEncodingProfileRequest;
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
 * REST stub implementation for the DaiEncodingProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonDaiEncodingProfileServiceStub extends DaiEncodingProfileServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileMethodDescriptor =
          ApiMethodDescriptor.<GetDaiEncodingProfileRequest, DaiEncodingProfile>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/GetDaiEncodingProfile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDaiEncodingProfileRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/daiEncodingProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDaiEncodingProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDaiEncodingProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DaiEncodingProfile>newBuilder()
                      .setDefaultInstance(DaiEncodingProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
      listDaiEncodingProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/ListDaiEncodingProfiles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDaiEncodingProfilesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiEncodingProfiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDaiEncodingProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDaiEncodingProfilesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDaiEncodingProfilesResponse>newBuilder()
                      .setDefaultInstance(ListDaiEncodingProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileMethodDescriptor =
          ApiMethodDescriptor.<CreateDaiEncodingProfileRequest, DaiEncodingProfile>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/CreateDaiEncodingProfile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDaiEncodingProfileRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiEncodingProfiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDaiEncodingProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDaiEncodingProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "daiEncodingProfile", request.getDaiEncodingProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DaiEncodingProfile>newBuilder()
                      .setDefaultInstance(DaiEncodingProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/BatchCreateDaiEncodingProfiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateDaiEncodingProfilesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiEncodingProfiles:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateDaiEncodingProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateDaiEncodingProfilesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateDaiEncodingProfilesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateDaiEncodingProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileMethodDescriptor =
          ApiMethodDescriptor.<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/UpdateDaiEncodingProfile")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDaiEncodingProfileRequest>newBuilder()
                      .setPath(
                          "/v1/{daiEncodingProfile.name=networks/*/daiEncodingProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDaiEncodingProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "daiEncodingProfile.name",
                                request.getDaiEncodingProfile().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDaiEncodingProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "daiEncodingProfile", request.getDaiEncodingProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DaiEncodingProfile>newBuilder()
                      .setDefaultInstance(DaiEncodingProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/BatchUpdateDaiEncodingProfiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateDaiEncodingProfilesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiEncodingProfiles:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateDaiEncodingProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateDaiEncodingProfilesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateDaiEncodingProfilesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateDaiEncodingProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/BatchActivateDaiEncodingProfiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateDaiEncodingProfilesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiEncodingProfiles:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateDaiEncodingProfilesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateDaiEncodingProfilesRequest>
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
                  ProtoMessageResponseParser.<BatchActivateDaiEncodingProfilesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateDaiEncodingProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiEncodingProfileService/BatchArchiveDaiEncodingProfiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveDaiEncodingProfilesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiEncodingProfiles:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveDaiEncodingProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveDaiEncodingProfilesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveDaiEncodingProfilesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchArchiveDaiEncodingProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileCallable;
  private final UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
      listDaiEncodingProfilesCallable;
  private final UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesPagedCallable;
  private final UnaryCallable<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileCallable;
  private final UnaryCallable<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesCallable;
  private final UnaryCallable<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileCallable;
  private final UnaryCallable<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesCallable;
  private final UnaryCallable<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesCallable;
  private final UnaryCallable<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDaiEncodingProfileServiceStub create(
      DaiEncodingProfileServiceStubSettings settings) throws IOException {
    return new HttpJsonDaiEncodingProfileServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDaiEncodingProfileServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDaiEncodingProfileServiceStub(
        DaiEncodingProfileServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDaiEncodingProfileServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDaiEncodingProfileServiceStub(
        DaiEncodingProfileServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDaiEncodingProfileServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDaiEncodingProfileServiceStub(
      DaiEncodingProfileServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDaiEncodingProfileServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDaiEncodingProfileServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDaiEncodingProfileServiceStub(
      DaiEncodingProfileServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDaiEncodingProfileRequest, DaiEncodingProfile>
        getDaiEncodingProfileTransportSettings =
            HttpJsonCallSettings.<GetDaiEncodingProfileRequest, DaiEncodingProfile>newBuilder()
                .setMethodDescriptor(getDaiEncodingProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
        listDaiEncodingProfilesTransportSettings =
            HttpJsonCallSettings
                .<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>newBuilder()
                .setMethodDescriptor(listDaiEncodingProfilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
        createDaiEncodingProfileTransportSettings =
            HttpJsonCallSettings.<CreateDaiEncodingProfileRequest, DaiEncodingProfile>newBuilder()
                .setMethodDescriptor(createDaiEncodingProfileMethodDescriptor)
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
            BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
        batchCreateDaiEncodingProfilesTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateDaiEncodingProfilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
        updateDaiEncodingProfileTransportSettings =
            HttpJsonCallSettings.<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>newBuilder()
                .setMethodDescriptor(updateDaiEncodingProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "dai_encoding_profile.name",
                          String.valueOf(request.getDaiEncodingProfile().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
        batchUpdateDaiEncodingProfilesTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateDaiEncodingProfilesMethodDescriptor)
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
            BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
        batchActivateDaiEncodingProfilesTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateDaiEncodingProfilesMethodDescriptor)
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
            BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
        batchArchiveDaiEncodingProfilesTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
                    newBuilder()
                .setMethodDescriptor(batchArchiveDaiEncodingProfilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getDaiEncodingProfileCallable =
        callableFactory.createUnaryCallable(
            getDaiEncodingProfileTransportSettings,
            settings.getDaiEncodingProfileSettings(),
            clientContext);
    this.listDaiEncodingProfilesCallable =
        callableFactory.createUnaryCallable(
            listDaiEncodingProfilesTransportSettings,
            settings.listDaiEncodingProfilesSettings(),
            clientContext);
    this.listDaiEncodingProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listDaiEncodingProfilesTransportSettings,
            settings.listDaiEncodingProfilesSettings(),
            clientContext);
    this.createDaiEncodingProfileCallable =
        callableFactory.createUnaryCallable(
            createDaiEncodingProfileTransportSettings,
            settings.createDaiEncodingProfileSettings(),
            clientContext);
    this.batchCreateDaiEncodingProfilesCallable =
        callableFactory.createUnaryCallable(
            batchCreateDaiEncodingProfilesTransportSettings,
            settings.batchCreateDaiEncodingProfilesSettings(),
            clientContext);
    this.updateDaiEncodingProfileCallable =
        callableFactory.createUnaryCallable(
            updateDaiEncodingProfileTransportSettings,
            settings.updateDaiEncodingProfileSettings(),
            clientContext);
    this.batchUpdateDaiEncodingProfilesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateDaiEncodingProfilesTransportSettings,
            settings.batchUpdateDaiEncodingProfilesSettings(),
            clientContext);
    this.batchActivateDaiEncodingProfilesCallable =
        callableFactory.createUnaryCallable(
            batchActivateDaiEncodingProfilesTransportSettings,
            settings.batchActivateDaiEncodingProfilesSettings(),
            clientContext);
    this.batchArchiveDaiEncodingProfilesCallable =
        callableFactory.createUnaryCallable(
            batchArchiveDaiEncodingProfilesTransportSettings,
            settings.batchArchiveDaiEncodingProfilesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDaiEncodingProfileMethodDescriptor);
    methodDescriptors.add(listDaiEncodingProfilesMethodDescriptor);
    methodDescriptors.add(createDaiEncodingProfileMethodDescriptor);
    methodDescriptors.add(batchCreateDaiEncodingProfilesMethodDescriptor);
    methodDescriptors.add(updateDaiEncodingProfileMethodDescriptor);
    methodDescriptors.add(batchUpdateDaiEncodingProfilesMethodDescriptor);
    methodDescriptors.add(batchActivateDaiEncodingProfilesMethodDescriptor);
    methodDescriptors.add(batchArchiveDaiEncodingProfilesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileCallable() {
    return getDaiEncodingProfileCallable;
  }

  @Override
  public UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
      listDaiEncodingProfilesCallable() {
    return listDaiEncodingProfilesCallable;
  }

  @Override
  public UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesPagedCallable() {
    return listDaiEncodingProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileCallable() {
    return createDaiEncodingProfileCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesCallable() {
    return batchCreateDaiEncodingProfilesCallable;
  }

  @Override
  public UnaryCallable<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileCallable() {
    return updateDaiEncodingProfileCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesCallable() {
    return batchUpdateDaiEncodingProfilesCallable;
  }

  @Override
  public UnaryCallable<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesCallable() {
    return batchActivateDaiEncodingProfilesCallable;
  }

  @Override
  public UnaryCallable<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesCallable() {
    return batchArchiveDaiEncodingProfilesCallable;
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
