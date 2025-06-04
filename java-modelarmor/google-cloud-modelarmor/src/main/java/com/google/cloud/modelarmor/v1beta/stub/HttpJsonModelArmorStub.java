/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.modelarmor.v1beta.stub;

import static com.google.cloud.modelarmor.v1beta.ModelArmorClient.ListLocationsPagedResponse;
import static com.google.cloud.modelarmor.v1beta.ModelArmorClient.ListTemplatesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.modelarmor.v1beta.CreateTemplateRequest;
import com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest;
import com.google.cloud.modelarmor.v1beta.FloorSetting;
import com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest;
import com.google.cloud.modelarmor.v1beta.GetTemplateRequest;
import com.google.cloud.modelarmor.v1beta.ListTemplatesRequest;
import com.google.cloud.modelarmor.v1beta.ListTemplatesResponse;
import com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest;
import com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse;
import com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest;
import com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse;
import com.google.cloud.modelarmor.v1beta.Template;
import com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest;
import com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the ModelArmor service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonModelArmorStub extends ModelArmorStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListTemplatesRequest, ListTemplatesResponse>
      listTemplatesMethodDescriptor =
          ApiMethodDescriptor.<ListTemplatesRequest, ListTemplatesResponse>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/ListTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/templates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTemplateRequest, Template>
      getTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetTemplateRequest, Template>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/GetTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTemplateRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/templates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Template>newBuilder()
                      .setDefaultInstance(Template.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTemplateRequest, Template>
      createTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateTemplateRequest, Template>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/CreateTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTemplateRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/templates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "templateId", request.getTemplateId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("template", request.getTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Template>newBuilder()
                      .setDefaultInstance(Template.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTemplateRequest, Template>
      updateTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateTemplateRequest, Template>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/UpdateTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTemplateRequest>newBuilder()
                      .setPath(
                          "/v1beta/{template.name=projects/*/locations/*/templates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "template.name", request.getTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("template", request.getTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Template>newBuilder()
                      .setDefaultInstance(Template.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTemplateRequest, Empty>
      deleteTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteTemplateRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/DeleteTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTemplateRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/templates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFloorSettingRequest, FloorSetting>
      getFloorSettingMethodDescriptor =
          ApiMethodDescriptor.<GetFloorSettingRequest, FloorSetting>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/GetFloorSetting")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFloorSettingRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/floorSetting}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFloorSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{name=folders/*/locations/*/floorSetting}",
                          "/v1beta/{name=organizations/*/locations/*/floorSetting}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFloorSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FloorSetting>newBuilder()
                      .setDefaultInstance(FloorSetting.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFloorSettingRequest, FloorSetting>
      updateFloorSettingMethodDescriptor =
          ApiMethodDescriptor.<UpdateFloorSettingRequest, FloorSetting>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/UpdateFloorSetting")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFloorSettingRequest>newBuilder()
                      .setPath(
                          "/v1beta/{floorSetting.name=projects/*/locations/*/floorSetting}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFloorSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "floorSetting.name", request.getFloorSetting().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{floorSetting.name=folders/*/locations/*/floorSetting}",
                          "/v1beta/{floorSetting.name=organizations/*/locations/*/floorSetting}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFloorSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("floorSetting", request.getFloorSetting(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FloorSetting>newBuilder()
                      .setDefaultInstance(FloorSetting.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptMethodDescriptor =
          ApiMethodDescriptor.<SanitizeUserPromptRequest, SanitizeUserPromptResponse>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/SanitizeUserPrompt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SanitizeUserPromptRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/templates/*}:sanitizeUserPrompt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SanitizeUserPromptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SanitizeUserPromptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SanitizeUserPromptResponse>newBuilder()
                      .setDefaultInstance(SanitizeUserPromptResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseMethodDescriptor =
          ApiMethodDescriptor
              .<SanitizeModelResponseRequest, SanitizeModelResponseResponse>newBuilder()
              .setFullMethodName("google.cloud.modelarmor.v1beta.ModelArmor/SanitizeModelResponse")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SanitizeModelResponseRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/templates/*}:sanitizeModelResponse",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SanitizeModelResponseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SanitizeModelResponseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SanitizeModelResponseResponse>newBuilder()
                      .setDefaultInstance(SanitizeModelResponseResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable;
  private final UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable;
  private final UnaryCallable<GetTemplateRequest, Template> getTemplateCallable;
  private final UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable;
  private final UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable;
  private final UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable;
  private final UnaryCallable<GetFloorSettingRequest, FloorSetting> getFloorSettingCallable;
  private final UnaryCallable<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingCallable;
  private final UnaryCallable<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptCallable;
  private final UnaryCallable<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonModelArmorStub create(ModelArmorStubSettings settings)
      throws IOException {
    return new HttpJsonModelArmorStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonModelArmorStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonModelArmorStub(
        ModelArmorStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonModelArmorStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonModelArmorStub(
        ModelArmorStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonModelArmorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonModelArmorStub(ModelArmorStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonModelArmorCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonModelArmorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonModelArmorStub(
      ModelArmorStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListTemplatesRequest, ListTemplatesResponse>
        listTemplatesTransportSettings =
            HttpJsonCallSettings.<ListTemplatesRequest, ListTemplatesResponse>newBuilder()
                .setMethodDescriptor(listTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTemplateRequest, Template> getTemplateTransportSettings =
        HttpJsonCallSettings.<GetTemplateRequest, Template>newBuilder()
            .setMethodDescriptor(getTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTemplateRequest, Template> createTemplateTransportSettings =
        HttpJsonCallSettings.<CreateTemplateRequest, Template>newBuilder()
            .setMethodDescriptor(createTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTemplateRequest, Template> updateTemplateTransportSettings =
        HttpJsonCallSettings.<UpdateTemplateRequest, Template>newBuilder()
            .setMethodDescriptor(updateTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("template.name", String.valueOf(request.getTemplate().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTemplateRequest, Empty> deleteTemplateTransportSettings =
        HttpJsonCallSettings.<DeleteTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetFloorSettingRequest, FloorSetting> getFloorSettingTransportSettings =
        HttpJsonCallSettings.<GetFloorSettingRequest, FloorSetting>newBuilder()
            .setMethodDescriptor(getFloorSettingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFloorSettingRequest, FloorSetting>
        updateFloorSettingTransportSettings =
            HttpJsonCallSettings.<UpdateFloorSettingRequest, FloorSetting>newBuilder()
                .setMethodDescriptor(updateFloorSettingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "floor_setting.name",
                          String.valueOf(request.getFloorSetting().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
        sanitizeUserPromptTransportSettings =
            HttpJsonCallSettings.<SanitizeUserPromptRequest, SanitizeUserPromptResponse>newBuilder()
                .setMethodDescriptor(sanitizeUserPromptMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
        sanitizeModelResponseTransportSettings =
            HttpJsonCallSettings
                .<SanitizeModelResponseRequest, SanitizeModelResponseResponse>newBuilder()
                .setMethodDescriptor(sanitizeModelResponseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listTemplatesCallable =
        callableFactory.createUnaryCallable(
            listTemplatesTransportSettings, settings.listTemplatesSettings(), clientContext);
    this.listTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listTemplatesTransportSettings, settings.listTemplatesSettings(), clientContext);
    this.getTemplateCallable =
        callableFactory.createUnaryCallable(
            getTemplateTransportSettings, settings.getTemplateSettings(), clientContext);
    this.createTemplateCallable =
        callableFactory.createUnaryCallable(
            createTemplateTransportSettings, settings.createTemplateSettings(), clientContext);
    this.updateTemplateCallable =
        callableFactory.createUnaryCallable(
            updateTemplateTransportSettings, settings.updateTemplateSettings(), clientContext);
    this.deleteTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteTemplateTransportSettings, settings.deleteTemplateSettings(), clientContext);
    this.getFloorSettingCallable =
        callableFactory.createUnaryCallable(
            getFloorSettingTransportSettings, settings.getFloorSettingSettings(), clientContext);
    this.updateFloorSettingCallable =
        callableFactory.createUnaryCallable(
            updateFloorSettingTransportSettings,
            settings.updateFloorSettingSettings(),
            clientContext);
    this.sanitizeUserPromptCallable =
        callableFactory.createUnaryCallable(
            sanitizeUserPromptTransportSettings,
            settings.sanitizeUserPromptSettings(),
            clientContext);
    this.sanitizeModelResponseCallable =
        callableFactory.createUnaryCallable(
            sanitizeModelResponseTransportSettings,
            settings.sanitizeModelResponseSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listTemplatesMethodDescriptor);
    methodDescriptors.add(getTemplateMethodDescriptor);
    methodDescriptors.add(createTemplateMethodDescriptor);
    methodDescriptors.add(updateTemplateMethodDescriptor);
    methodDescriptors.add(deleteTemplateMethodDescriptor);
    methodDescriptors.add(getFloorSettingMethodDescriptor);
    methodDescriptors.add(updateFloorSettingMethodDescriptor);
    methodDescriptors.add(sanitizeUserPromptMethodDescriptor);
    methodDescriptors.add(sanitizeModelResponseMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable() {
    return listTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable() {
    return listTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTemplateRequest, Template> getTemplateCallable() {
    return getTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable() {
    return createTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable() {
    return updateTemplateCallable;
  }

  @Override
  public UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable() {
    return deleteTemplateCallable;
  }

  @Override
  public UnaryCallable<GetFloorSettingRequest, FloorSetting> getFloorSettingCallable() {
    return getFloorSettingCallable;
  }

  @Override
  public UnaryCallable<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingCallable() {
    return updateFloorSettingCallable;
  }

  @Override
  public UnaryCallable<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptCallable() {
    return sanitizeUserPromptCallable;
  }

  @Override
  public UnaryCallable<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseCallable() {
    return sanitizeModelResponseCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
