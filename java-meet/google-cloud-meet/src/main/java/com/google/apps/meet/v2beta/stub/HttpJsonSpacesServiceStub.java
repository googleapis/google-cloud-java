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

package com.google.apps.meet.v2beta.stub;

import static com.google.apps.meet.v2beta.SpacesServiceClient.ListMembersPagedResponse;

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
import com.google.apps.meet.v2beta.ConnectActiveConferenceRequest;
import com.google.apps.meet.v2beta.ConnectActiveConferenceResponse;
import com.google.apps.meet.v2beta.CreateMemberRequest;
import com.google.apps.meet.v2beta.CreateSpaceRequest;
import com.google.apps.meet.v2beta.DeleteMemberRequest;
import com.google.apps.meet.v2beta.EndActiveConferenceRequest;
import com.google.apps.meet.v2beta.GetMemberRequest;
import com.google.apps.meet.v2beta.GetSpaceRequest;
import com.google.apps.meet.v2beta.ListMembersRequest;
import com.google.apps.meet.v2beta.ListMembersResponse;
import com.google.apps.meet.v2beta.Member;
import com.google.apps.meet.v2beta.Space;
import com.google.apps.meet.v2beta.UpdateSpaceRequest;
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
 * REST stub implementation for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSpacesServiceStub extends SpacesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      ApiMethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/CreateSpace")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSpaceRequest>newBuilder()
                  .setPath(
                      "/v2beta/spaces",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      ApiMethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/GetSpace")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSpaceRequest>newBuilder()
                  .setPath(
                      "/v2beta/{name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      ApiMethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/UpdateSpace")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSpaceRequest>newBuilder()
                  .setPath(
                      "/v2beta/{space.name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "space.name", request.getSpace().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceMethodDescriptor =
          ApiMethodDescriptor
              .<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/ConnectActiveConference")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConnectActiveConferenceRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=spaces/*}:connectActiveConference",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectActiveConferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectActiveConferenceRequest> serializer =
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
                  ProtoMessageResponseParser.<ConnectActiveConferenceResponse>newBuilder()
                      .setDefaultInstance(ConnectActiveConferenceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EndActiveConferenceRequest, Empty>
      endActiveConferenceMethodDescriptor =
          ApiMethodDescriptor.<EndActiveConferenceRequest, Empty>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/EndActiveConference")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EndActiveConferenceRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=spaces/*}:endActiveConference",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EndActiveConferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EndActiveConferenceRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMemberRequest, Member>
      createMemberMethodDescriptor =
          ApiMethodDescriptor.<CreateMemberRequest, Member>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/CreateMember")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMemberRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=spaces/*}/members",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("member", request.getMember(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Member>newBuilder()
                      .setDefaultInstance(Member.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMemberRequest, Member> getMemberMethodDescriptor =
      ApiMethodDescriptor.<GetMemberRequest, Member>newBuilder()
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/GetMember")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetMemberRequest>newBuilder()
                  .setPath(
                      "/v2beta/{name=spaces/*/members/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetMemberRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetMemberRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Member>newBuilder()
                  .setDefaultInstance(Member.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListMembersRequest, ListMembersResponse>
      listMembersMethodDescriptor =
          ApiMethodDescriptor.<ListMembersRequest, ListMembersResponse>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/ListMembers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembersRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=spaces/*}/members",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMembersResponse>newBuilder()
                      .setDefaultInstance(ListMembersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMemberRequest, Empty>
      deleteMemberMethodDescriptor =
          ApiMethodDescriptor.<DeleteMemberRequest, Empty>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/DeleteMember")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMemberRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=spaces/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMemberRequest> serializer =
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

  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceCallable;
  private final UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable;
  private final UnaryCallable<CreateMemberRequest, Member> createMemberCallable;
  private final UnaryCallable<GetMemberRequest, Member> getMemberCallable;
  private final UnaryCallable<ListMembersRequest, ListMembersResponse> listMembersCallable;
  private final UnaryCallable<ListMembersRequest, ListMembersPagedResponse>
      listMembersPagedCallable;
  private final UnaryCallable<DeleteMemberRequest, Empty> deleteMemberCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSpacesServiceStub create(SpacesServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSpacesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSpacesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSpacesServiceStub(
        SpacesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSpacesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSpacesServiceStub(
        SpacesServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSpacesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSpacesServiceStub(
      SpacesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSpacesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSpacesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSpacesServiceStub(
      SpacesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        HttpJsonCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        HttpJsonCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        HttpJsonCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
        connectActiveConferenceTransportSettings =
            HttpJsonCallSettings
                .<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>newBuilder()
                .setMethodDescriptor(connectActiveConferenceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<EndActiveConferenceRequest, Empty> endActiveConferenceTransportSettings =
        HttpJsonCallSettings.<EndActiveConferenceRequest, Empty>newBuilder()
            .setMethodDescriptor(endActiveConferenceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateMemberRequest, Member> createMemberTransportSettings =
        HttpJsonCallSettings.<CreateMemberRequest, Member>newBuilder()
            .setMethodDescriptor(createMemberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetMemberRequest, Member> getMemberTransportSettings =
        HttpJsonCallSettings.<GetMemberRequest, Member>newBuilder()
            .setMethodDescriptor(getMemberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMembersRequest, ListMembersResponse> listMembersTransportSettings =
        HttpJsonCallSettings.<ListMembersRequest, ListMembersResponse>newBuilder()
            .setMethodDescriptor(listMembersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMemberRequest, Empty> deleteMemberTransportSettings =
        HttpJsonCallSettings.<DeleteMemberRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMemberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createSpaceCallable =
        callableFactory.createUnaryCallable(
            createSpaceTransportSettings, settings.createSpaceSettings(), clientContext);
    this.getSpaceCallable =
        callableFactory.createUnaryCallable(
            getSpaceTransportSettings, settings.getSpaceSettings(), clientContext);
    this.updateSpaceCallable =
        callableFactory.createUnaryCallable(
            updateSpaceTransportSettings, settings.updateSpaceSettings(), clientContext);
    this.connectActiveConferenceCallable =
        callableFactory.createUnaryCallable(
            connectActiveConferenceTransportSettings,
            settings.connectActiveConferenceSettings(),
            clientContext);
    this.endActiveConferenceCallable =
        callableFactory.createUnaryCallable(
            endActiveConferenceTransportSettings,
            settings.endActiveConferenceSettings(),
            clientContext);
    this.createMemberCallable =
        callableFactory.createUnaryCallable(
            createMemberTransportSettings, settings.createMemberSettings(), clientContext);
    this.getMemberCallable =
        callableFactory.createUnaryCallable(
            getMemberTransportSettings, settings.getMemberSettings(), clientContext);
    this.listMembersCallable =
        callableFactory.createUnaryCallable(
            listMembersTransportSettings, settings.listMembersSettings(), clientContext);
    this.listMembersPagedCallable =
        callableFactory.createPagedCallable(
            listMembersTransportSettings, settings.listMembersSettings(), clientContext);
    this.deleteMemberCallable =
        callableFactory.createUnaryCallable(
            deleteMemberTransportSettings, settings.deleteMemberSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSpaceMethodDescriptor);
    methodDescriptors.add(getSpaceMethodDescriptor);
    methodDescriptors.add(updateSpaceMethodDescriptor);
    methodDescriptors.add(connectActiveConferenceMethodDescriptor);
    methodDescriptors.add(endActiveConferenceMethodDescriptor);
    methodDescriptors.add(createMemberMethodDescriptor);
    methodDescriptors.add(getMemberMethodDescriptor);
    methodDescriptors.add(listMembersMethodDescriptor);
    methodDescriptors.add(deleteMemberMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return createSpaceCallable;
  }

  @Override
  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return getSpaceCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return updateSpaceCallable;
  }

  @Override
  public UnaryCallable<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceCallable() {
    return connectActiveConferenceCallable;
  }

  @Override
  public UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    return endActiveConferenceCallable;
  }

  @Override
  public UnaryCallable<CreateMemberRequest, Member> createMemberCallable() {
    return createMemberCallable;
  }

  @Override
  public UnaryCallable<GetMemberRequest, Member> getMemberCallable() {
    return getMemberCallable;
  }

  @Override
  public UnaryCallable<ListMembersRequest, ListMembersResponse> listMembersCallable() {
    return listMembersCallable;
  }

  @Override
  public UnaryCallable<ListMembersRequest, ListMembersPagedResponse> listMembersPagedCallable() {
    return listMembersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteMemberRequest, Empty> deleteMemberCallable() {
    return deleteMemberCallable;
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
