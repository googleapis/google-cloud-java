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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybookVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybooksPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Playbook;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion;
import com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the Playbooks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPlaybooksStub extends PlaybooksStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreatePlaybookRequest, Playbook>
      createPlaybookMethodDescriptor =
          ApiMethodDescriptor.<CreatePlaybookRequest, Playbook>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/CreatePlaybook")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePlaybookRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/playbooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("playbook", request.getPlaybook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Playbook>newBuilder()
                      .setDefaultInstance(Playbook.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePlaybookRequest, Empty>
      deletePlaybookMethodDescriptor =
          ApiMethodDescriptor.<DeletePlaybookRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/DeletePlaybook")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePlaybookRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/playbooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePlaybookRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ListPlaybooksRequest, ListPlaybooksResponse>
      listPlaybooksMethodDescriptor =
          ApiMethodDescriptor.<ListPlaybooksRequest, ListPlaybooksResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/ListPlaybooks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPlaybooksRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/playbooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPlaybooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPlaybooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPlaybooksResponse>newBuilder()
                      .setDefaultInstance(ListPlaybooksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPlaybookRequest, Playbook>
      getPlaybookMethodDescriptor =
          ApiMethodDescriptor.<GetPlaybookRequest, Playbook>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/GetPlaybook")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPlaybookRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/playbooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Playbook>newBuilder()
                      .setDefaultInstance(Playbook.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePlaybookRequest, Playbook>
      updatePlaybookMethodDescriptor =
          ApiMethodDescriptor.<UpdatePlaybookRequest, Playbook>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/UpdatePlaybook")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePlaybookRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{playbook.name=projects/*/locations/*/agents/*/playbooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "playbook.name", request.getPlaybook().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePlaybookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("playbook", request.getPlaybook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Playbook>newBuilder()
                      .setDefaultInstance(Playbook.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionMethodDescriptor =
          ApiMethodDescriptor.<CreatePlaybookVersionRequest, PlaybookVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Playbooks/CreatePlaybookVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePlaybookVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/playbooks/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePlaybookVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePlaybookVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("playbookVersion", request.getPlaybookVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PlaybookVersion>newBuilder()
                      .setDefaultInstance(PlaybookVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionMethodDescriptor =
          ApiMethodDescriptor.<GetPlaybookVersionRequest, PlaybookVersion>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/GetPlaybookVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPlaybookVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/playbooks/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPlaybookVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPlaybookVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PlaybookVersion>newBuilder()
                      .setDefaultInstance(PlaybookVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Playbooks/ListPlaybookVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPlaybookVersionsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/playbooks/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPlaybookVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPlaybookVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPlaybookVersionsResponse>newBuilder()
                      .setDefaultInstance(ListPlaybookVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePlaybookVersionRequest, Empty>
      deletePlaybookVersionMethodDescriptor =
          ApiMethodDescriptor.<DeletePlaybookVersionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Playbooks/DeletePlaybookVersion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePlaybookVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/playbooks/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePlaybookVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePlaybookVersionRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*}/locations",
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
                          "/v3beta1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreatePlaybookRequest, Playbook> createPlaybookCallable;
  private final UnaryCallable<DeletePlaybookRequest, Empty> deletePlaybookCallable;
  private final UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksCallable;
  private final UnaryCallable<ListPlaybooksRequest, ListPlaybooksPagedResponse>
      listPlaybooksPagedCallable;
  private final UnaryCallable<GetPlaybookRequest, Playbook> getPlaybookCallable;
  private final UnaryCallable<UpdatePlaybookRequest, Playbook> updatePlaybookCallable;
  private final UnaryCallable<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionCallable;
  private final UnaryCallable<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionCallable;
  private final UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsCallable;
  private final UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsPagedCallable;
  private final UnaryCallable<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPlaybooksStub create(PlaybooksStubSettings settings)
      throws IOException {
    return new HttpJsonPlaybooksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPlaybooksStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonPlaybooksStub(
        PlaybooksStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPlaybooksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPlaybooksStub(
        PlaybooksStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPlaybooksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPlaybooksStub(PlaybooksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPlaybooksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPlaybooksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPlaybooksStub(
      PlaybooksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreatePlaybookRequest, Playbook> createPlaybookTransportSettings =
        HttpJsonCallSettings.<CreatePlaybookRequest, Playbook>newBuilder()
            .setMethodDescriptor(createPlaybookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePlaybookRequest, Empty> deletePlaybookTransportSettings =
        HttpJsonCallSettings.<DeletePlaybookRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePlaybookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPlaybooksRequest, ListPlaybooksResponse>
        listPlaybooksTransportSettings =
            HttpJsonCallSettings.<ListPlaybooksRequest, ListPlaybooksResponse>newBuilder()
                .setMethodDescriptor(listPlaybooksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPlaybookRequest, Playbook> getPlaybookTransportSettings =
        HttpJsonCallSettings.<GetPlaybookRequest, Playbook>newBuilder()
            .setMethodDescriptor(getPlaybookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePlaybookRequest, Playbook> updatePlaybookTransportSettings =
        HttpJsonCallSettings.<UpdatePlaybookRequest, Playbook>newBuilder()
            .setMethodDescriptor(updatePlaybookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("playbook.name", String.valueOf(request.getPlaybook().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePlaybookVersionRequest, PlaybookVersion>
        createPlaybookVersionTransportSettings =
            HttpJsonCallSettings.<CreatePlaybookVersionRequest, PlaybookVersion>newBuilder()
                .setMethodDescriptor(createPlaybookVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPlaybookVersionRequest, PlaybookVersion>
        getPlaybookVersionTransportSettings =
            HttpJsonCallSettings.<GetPlaybookVersionRequest, PlaybookVersion>newBuilder()
                .setMethodDescriptor(getPlaybookVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
        listPlaybookVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>newBuilder()
                .setMethodDescriptor(listPlaybookVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePlaybookVersionRequest, Empty>
        deletePlaybookVersionTransportSettings =
            HttpJsonCallSettings.<DeletePlaybookVersionRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePlaybookVersionMethodDescriptor)
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

    this.createPlaybookCallable =
        callableFactory.createUnaryCallable(
            createPlaybookTransportSettings, settings.createPlaybookSettings(), clientContext);
    this.deletePlaybookCallable =
        callableFactory.createUnaryCallable(
            deletePlaybookTransportSettings, settings.deletePlaybookSettings(), clientContext);
    this.listPlaybooksCallable =
        callableFactory.createUnaryCallable(
            listPlaybooksTransportSettings, settings.listPlaybooksSettings(), clientContext);
    this.listPlaybooksPagedCallable =
        callableFactory.createPagedCallable(
            listPlaybooksTransportSettings, settings.listPlaybooksSettings(), clientContext);
    this.getPlaybookCallable =
        callableFactory.createUnaryCallable(
            getPlaybookTransportSettings, settings.getPlaybookSettings(), clientContext);
    this.updatePlaybookCallable =
        callableFactory.createUnaryCallable(
            updatePlaybookTransportSettings, settings.updatePlaybookSettings(), clientContext);
    this.createPlaybookVersionCallable =
        callableFactory.createUnaryCallable(
            createPlaybookVersionTransportSettings,
            settings.createPlaybookVersionSettings(),
            clientContext);
    this.getPlaybookVersionCallable =
        callableFactory.createUnaryCallable(
            getPlaybookVersionTransportSettings,
            settings.getPlaybookVersionSettings(),
            clientContext);
    this.listPlaybookVersionsCallable =
        callableFactory.createUnaryCallable(
            listPlaybookVersionsTransportSettings,
            settings.listPlaybookVersionsSettings(),
            clientContext);
    this.listPlaybookVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listPlaybookVersionsTransportSettings,
            settings.listPlaybookVersionsSettings(),
            clientContext);
    this.deletePlaybookVersionCallable =
        callableFactory.createUnaryCallable(
            deletePlaybookVersionTransportSettings,
            settings.deletePlaybookVersionSettings(),
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
    methodDescriptors.add(createPlaybookMethodDescriptor);
    methodDescriptors.add(deletePlaybookMethodDescriptor);
    methodDescriptors.add(listPlaybooksMethodDescriptor);
    methodDescriptors.add(getPlaybookMethodDescriptor);
    methodDescriptors.add(updatePlaybookMethodDescriptor);
    methodDescriptors.add(createPlaybookVersionMethodDescriptor);
    methodDescriptors.add(getPlaybookVersionMethodDescriptor);
    methodDescriptors.add(listPlaybookVersionsMethodDescriptor);
    methodDescriptors.add(deletePlaybookVersionMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreatePlaybookRequest, Playbook> createPlaybookCallable() {
    return createPlaybookCallable;
  }

  @Override
  public UnaryCallable<DeletePlaybookRequest, Empty> deletePlaybookCallable() {
    return deletePlaybookCallable;
  }

  @Override
  public UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksCallable() {
    return listPlaybooksCallable;
  }

  @Override
  public UnaryCallable<ListPlaybooksRequest, ListPlaybooksPagedResponse>
      listPlaybooksPagedCallable() {
    return listPlaybooksPagedCallable;
  }

  @Override
  public UnaryCallable<GetPlaybookRequest, Playbook> getPlaybookCallable() {
    return getPlaybookCallable;
  }

  @Override
  public UnaryCallable<UpdatePlaybookRequest, Playbook> updatePlaybookCallable() {
    return updatePlaybookCallable;
  }

  @Override
  public UnaryCallable<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionCallable() {
    return createPlaybookVersionCallable;
  }

  @Override
  public UnaryCallable<GetPlaybookVersionRequest, PlaybookVersion> getPlaybookVersionCallable() {
    return getPlaybookVersionCallable;
  }

  @Override
  public UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsCallable() {
    return listPlaybookVersionsCallable;
  }

  @Override
  public UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsPagedCallable() {
    return listPlaybookVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionCallable() {
    return deletePlaybookVersionCallable;
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
