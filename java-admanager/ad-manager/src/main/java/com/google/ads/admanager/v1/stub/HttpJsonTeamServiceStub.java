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

import static com.google.ads.admanager.v1.TeamServiceClient.ListTeamsPagedResponse;

import com.google.ads.admanager.v1.GetTeamRequest;
import com.google.ads.admanager.v1.ListTeamsRequest;
import com.google.ads.admanager.v1.ListTeamsResponse;
import com.google.ads.admanager.v1.Team;
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

  private final UnaryCallable<GetTeamRequest, Team> getTeamCallable;
  private final UnaryCallable<ListTeamsRequest, ListTeamsResponse> listTeamsCallable;
  private final UnaryCallable<ListTeamsRequest, ListTeamsPagedResponse> listTeamsPagedCallable;

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

    this.getTeamCallable =
        callableFactory.createUnaryCallable(
            getTeamTransportSettings, settings.getTeamSettings(), clientContext);
    this.listTeamsCallable =
        callableFactory.createUnaryCallable(
            listTeamsTransportSettings, settings.listTeamsSettings(), clientContext);
    this.listTeamsPagedCallable =
        callableFactory.createPagedCallable(
            listTeamsTransportSettings, settings.listTeamsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTeamMethodDescriptor);
    methodDescriptors.add(listTeamsMethodDescriptor);
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
