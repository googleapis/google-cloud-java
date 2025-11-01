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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.TeamServiceClient.ListTeamsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateTeamsRequest;
import com.google.ads.admanager.v1.BatchActivateTeamsResponse;
import com.google.ads.admanager.v1.BatchCreateTeamsRequest;
import com.google.ads.admanager.v1.BatchCreateTeamsResponse;
import com.google.ads.admanager.v1.BatchDeactivateTeamsRequest;
import com.google.ads.admanager.v1.BatchDeactivateTeamsResponse;
import com.google.ads.admanager.v1.BatchUpdateTeamsRequest;
import com.google.ads.admanager.v1.BatchUpdateTeamsResponse;
import com.google.ads.admanager.v1.CreateTeamRequest;
import com.google.ads.admanager.v1.GetTeamRequest;
import com.google.ads.admanager.v1.ListTeamsRequest;
import com.google.ads.admanager.v1.ListTeamsResponse;
import com.google.ads.admanager.v1.Team;
import com.google.ads.admanager.v1.UpdateTeamRequest;
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
 * REST stub implementation for the TeamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonTeamServiceStub extends TeamServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetTeamRequest, Team> getTeamMethodDescriptor =
      ApiMethodDescriptor.<GetTeamRequest, Team>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.TeamService/GetTeam")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTeamRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/teams/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTeamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTeamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Team>newBuilder()
                  .setDefaultInstance(Team.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListTeamsRequest, ListTeamsResponse>
      listTeamsMethodDescriptor =
          ApiMethodDescriptor.<ListTeamsRequest, ListTeamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.TeamService/ListTeams")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTeamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/teams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTeamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTeamsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTeamsResponse>newBuilder()
                      .setDefaultInstance(ListTeamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTeamRequest, Team> createTeamMethodDescriptor =
      ApiMethodDescriptor.<CreateTeamRequest, Team>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.TeamService/CreateTeam")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateTeamRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=networks/*}/teams",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTeamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTeamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("team", request.getTeam(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Team>newBuilder()
                  .setDefaultInstance(Team.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
      batchCreateTeamsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateTeamsRequest, BatchCreateTeamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.TeamService/BatchCreateTeams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateTeamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/teams:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTeamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTeamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateTeamsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateTeamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTeamRequest, Team> updateTeamMethodDescriptor =
      ApiMethodDescriptor.<UpdateTeamRequest, Team>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.TeamService/UpdateTeam")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateTeamRequest>newBuilder()
                  .setPath(
                      "/v1/{team.name=networks/*/teams/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTeamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "team.name", request.getTeam().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTeamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("team", request.getTeam(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Team>newBuilder()
                  .setDefaultInstance(Team.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
      batchUpdateTeamsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.TeamService/BatchUpdateTeams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateTeamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/teams:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateTeamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateTeamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateTeamsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateTeamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
      batchActivateTeamsMethodDescriptor =
          ApiMethodDescriptor.<BatchActivateTeamsRequest, BatchActivateTeamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.TeamService/BatchActivateTeams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateTeamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/teams:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateTeamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateTeamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateTeamsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateTeamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
      batchDeactivateTeamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.TeamService/BatchDeactivateTeams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateTeamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/teams:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateTeamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateTeamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateTeamsResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateTeamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetTeamRequest, Team> getTeamCallable;
  private final UnaryCallable<ListTeamsRequest, ListTeamsResponse> listTeamsCallable;
  private final UnaryCallable<ListTeamsRequest, ListTeamsPagedResponse> listTeamsPagedCallable;
  private final UnaryCallable<CreateTeamRequest, Team> createTeamCallable;
  private final UnaryCallable<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
      batchCreateTeamsCallable;
  private final UnaryCallable<UpdateTeamRequest, Team> updateTeamCallable;
  private final UnaryCallable<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
      batchUpdateTeamsCallable;
  private final UnaryCallable<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
      batchActivateTeamsCallable;
  private final UnaryCallable<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
      batchDeactivateTeamsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTeamServiceStub create(TeamServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTeamServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTeamServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTeamServiceStub(TeamServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTeamServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTeamServiceStub(
        TeamServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTeamServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTeamServiceStub(TeamServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTeamServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTeamServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTeamServiceStub(
      TeamServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetTeamRequest, Team> getTeamTransportSettings =
        HttpJsonCallSettings.<GetTeamRequest, Team>newBuilder()
            .setMethodDescriptor(getTeamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTeamsRequest, ListTeamsResponse> listTeamsTransportSettings =
        HttpJsonCallSettings.<ListTeamsRequest, ListTeamsResponse>newBuilder()
            .setMethodDescriptor(listTeamsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTeamRequest, Team> createTeamTransportSettings =
        HttpJsonCallSettings.<CreateTeamRequest, Team>newBuilder()
            .setMethodDescriptor(createTeamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
        batchCreateTeamsTransportSettings =
            HttpJsonCallSettings.<BatchCreateTeamsRequest, BatchCreateTeamsResponse>newBuilder()
                .setMethodDescriptor(batchCreateTeamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateTeamRequest, Team> updateTeamTransportSettings =
        HttpJsonCallSettings.<UpdateTeamRequest, Team>newBuilder()
            .setMethodDescriptor(updateTeamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("team.name", String.valueOf(request.getTeam().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
        batchUpdateTeamsTransportSettings =
            HttpJsonCallSettings.<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateTeamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
        batchActivateTeamsTransportSettings =
            HttpJsonCallSettings.<BatchActivateTeamsRequest, BatchActivateTeamsResponse>newBuilder()
                .setMethodDescriptor(batchActivateTeamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
        batchDeactivateTeamsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateTeamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getTeamCallable =
        callableFactory.createUnaryCallable(
            getTeamTransportSettings, settings.getTeamSettings(), clientContext);
    this.listTeamsCallable =
        callableFactory.createUnaryCallable(
            listTeamsTransportSettings, settings.listTeamsSettings(), clientContext);
    this.listTeamsPagedCallable =
        callableFactory.createPagedCallable(
            listTeamsTransportSettings, settings.listTeamsSettings(), clientContext);
    this.createTeamCallable =
        callableFactory.createUnaryCallable(
            createTeamTransportSettings, settings.createTeamSettings(), clientContext);
    this.batchCreateTeamsCallable =
        callableFactory.createUnaryCallable(
            batchCreateTeamsTransportSettings, settings.batchCreateTeamsSettings(), clientContext);
    this.updateTeamCallable =
        callableFactory.createUnaryCallable(
            updateTeamTransportSettings, settings.updateTeamSettings(), clientContext);
    this.batchUpdateTeamsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateTeamsTransportSettings, settings.batchUpdateTeamsSettings(), clientContext);
    this.batchActivateTeamsCallable =
        callableFactory.createUnaryCallable(
            batchActivateTeamsTransportSettings,
            settings.batchActivateTeamsSettings(),
            clientContext);
    this.batchDeactivateTeamsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateTeamsTransportSettings,
            settings.batchDeactivateTeamsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTeamMethodDescriptor);
    methodDescriptors.add(listTeamsMethodDescriptor);
    methodDescriptors.add(createTeamMethodDescriptor);
    methodDescriptors.add(batchCreateTeamsMethodDescriptor);
    methodDescriptors.add(updateTeamMethodDescriptor);
    methodDescriptors.add(batchUpdateTeamsMethodDescriptor);
    methodDescriptors.add(batchActivateTeamsMethodDescriptor);
    methodDescriptors.add(batchDeactivateTeamsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetTeamRequest, Team> getTeamCallable() {
    return getTeamCallable;
  }

  @Override
  public UnaryCallable<ListTeamsRequest, ListTeamsResponse> listTeamsCallable() {
    return listTeamsCallable;
  }

  @Override
  public UnaryCallable<ListTeamsRequest, ListTeamsPagedResponse> listTeamsPagedCallable() {
    return listTeamsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTeamRequest, Team> createTeamCallable() {
    return createTeamCallable;
  }

  @Override
  public UnaryCallable<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
      batchCreateTeamsCallable() {
    return batchCreateTeamsCallable;
  }

  @Override
  public UnaryCallable<UpdateTeamRequest, Team> updateTeamCallable() {
    return updateTeamCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
      batchUpdateTeamsCallable() {
    return batchUpdateTeamsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
      batchActivateTeamsCallable() {
    return batchActivateTeamsCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
      batchDeactivateTeamsCallable() {
    return batchDeactivateTeamsCallable;
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
