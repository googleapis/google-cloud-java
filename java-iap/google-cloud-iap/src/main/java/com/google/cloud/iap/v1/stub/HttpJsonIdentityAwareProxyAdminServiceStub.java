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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceClient.ListTunnelDestGroupsPagedResponse;

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
import com.google.cloud.iap.v1.CreateTunnelDestGroupRequest;
import com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest;
import com.google.cloud.iap.v1.GetIapSettingsRequest;
import com.google.cloud.iap.v1.GetTunnelDestGroupRequest;
import com.google.cloud.iap.v1.IapSettings;
import com.google.cloud.iap.v1.ListTunnelDestGroupsRequest;
import com.google.cloud.iap.v1.ListTunnelDestGroupsResponse;
import com.google.cloud.iap.v1.TunnelDestGroup;
import com.google.cloud.iap.v1.UpdateIapSettingsRequest;
import com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the IdentityAwareProxyAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonIdentityAwareProxyAdminServiceStub extends IdentityAwareProxyAdminServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyAdminService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=**}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyAdminService/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=**}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=**}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIapSettingsRequest, IapSettings>
      getIapSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetIapSettingsRequest, IapSettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/GetIapSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIapSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=**}:iapSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIapSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIapSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IapSettings>newBuilder()
                      .setDefaultInstance(IapSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIapSettingsRequest, IapSettings>
      updateIapSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateIapSettingsRequest, IapSettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/UpdateIapSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIapSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{iapSettings.name=**}:iapSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIapSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "iapSettings.name", request.getIapSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIapSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("iapSettings", request.getIapSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IapSettings>newBuilder()
                      .setDefaultInstance(IapSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/ListTunnelDestGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTunnelDestGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/iap_tunnel/locations/*}/destGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTunnelDestGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTunnelDestGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTunnelDestGroupsResponse>newBuilder()
                      .setDefaultInstance(ListTunnelDestGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/CreateTunnelDestGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTunnelDestGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/iap_tunnel/locations/*}/destGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "tunnelDestGroupId", request.getTunnelDestGroupId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tunnelDestGroup", request.getTunnelDestGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TunnelDestGroup>newBuilder()
                      .setDefaultInstance(TunnelDestGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupMethodDescriptor =
          ApiMethodDescriptor.<GetTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/GetTunnelDestGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTunnelDestGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/iap_tunnel/locations/*/destGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TunnelDestGroup>newBuilder()
                      .setDefaultInstance(TunnelDestGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTunnelDestGroupRequest, Empty>
      deleteTunnelDestGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteTunnelDestGroupRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/DeleteTunnelDestGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTunnelDestGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/iap_tunnel/locations/*/destGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTunnelDestGroupRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/UpdateTunnelDestGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTunnelDestGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{tunnelDestGroup.name=projects/*/iap_tunnel/locations/*/destGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "tunnelDestGroup.name",
                                request.getTunnelDestGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTunnelDestGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tunnelDestGroup", request.getTunnelDestGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TunnelDestGroup>newBuilder()
                      .setDefaultInstance(TunnelDestGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<GetIapSettingsRequest, IapSettings> getIapSettingsCallable;
  private final UnaryCallable<UpdateIapSettingsRequest, IapSettings> updateIapSettingsCallable;
  private final UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsCallable;
  private final UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsPagedCallable;
  private final UnaryCallable<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupCallable;
  private final UnaryCallable<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupCallable;
  private final UnaryCallable<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupCallable;
  private final UnaryCallable<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIdentityAwareProxyAdminServiceStub create(
      IdentityAwareProxyAdminServiceStubSettings settings) throws IOException {
    return new HttpJsonIdentityAwareProxyAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIdentityAwareProxyAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIdentityAwareProxyAdminServiceStub(
        IdentityAwareProxyAdminServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIdentityAwareProxyAdminServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIdentityAwareProxyAdminServiceStub(
        IdentityAwareProxyAdminServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIdentityAwareProxyAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonIdentityAwareProxyAdminServiceStub(
      IdentityAwareProxyAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonIdentityAwareProxyAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIdentityAwareProxyAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonIdentityAwareProxyAdminServiceStub(
      IdentityAwareProxyAdminServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIapSettingsRequest, IapSettings> getIapSettingsTransportSettings =
        HttpJsonCallSettings.<GetIapSettingsRequest, IapSettings>newBuilder()
            .setMethodDescriptor(getIapSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateIapSettingsRequest, IapSettings> updateIapSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateIapSettingsRequest, IapSettings>newBuilder()
            .setMethodDescriptor(updateIapSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "iap_settings.name", String.valueOf(request.getIapSettings().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
        listTunnelDestGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>newBuilder()
                .setMethodDescriptor(listTunnelDestGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateTunnelDestGroupRequest, TunnelDestGroup>
        createTunnelDestGroupTransportSettings =
            HttpJsonCallSettings.<CreateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
                .setMethodDescriptor(createTunnelDestGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTunnelDestGroupRequest, TunnelDestGroup>
        getTunnelDestGroupTransportSettings =
            HttpJsonCallSettings.<GetTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
                .setMethodDescriptor(getTunnelDestGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteTunnelDestGroupRequest, Empty>
        deleteTunnelDestGroupTransportSettings =
            HttpJsonCallSettings.<DeleteTunnelDestGroupRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteTunnelDestGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateTunnelDestGroupRequest, TunnelDestGroup>
        updateTunnelDestGroupTransportSettings =
            HttpJsonCallSettings.<UpdateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
                .setMethodDescriptor(updateTunnelDestGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "tunnel_dest_group.name",
                          String.valueOf(request.getTunnelDestGroup().getName()));
                      return builder.build();
                    })
                .build();

    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.getIapSettingsCallable =
        callableFactory.createUnaryCallable(
            getIapSettingsTransportSettings, settings.getIapSettingsSettings(), clientContext);
    this.updateIapSettingsCallable =
        callableFactory.createUnaryCallable(
            updateIapSettingsTransportSettings,
            settings.updateIapSettingsSettings(),
            clientContext);
    this.listTunnelDestGroupsCallable =
        callableFactory.createUnaryCallable(
            listTunnelDestGroupsTransportSettings,
            settings.listTunnelDestGroupsSettings(),
            clientContext);
    this.listTunnelDestGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listTunnelDestGroupsTransportSettings,
            settings.listTunnelDestGroupsSettings(),
            clientContext);
    this.createTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            createTunnelDestGroupTransportSettings,
            settings.createTunnelDestGroupSettings(),
            clientContext);
    this.getTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            getTunnelDestGroupTransportSettings,
            settings.getTunnelDestGroupSettings(),
            clientContext);
    this.deleteTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            deleteTunnelDestGroupTransportSettings,
            settings.deleteTunnelDestGroupSettings(),
            clientContext);
    this.updateTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            updateTunnelDestGroupTransportSettings,
            settings.updateTunnelDestGroupSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(getIapSettingsMethodDescriptor);
    methodDescriptors.add(updateIapSettingsMethodDescriptor);
    methodDescriptors.add(listTunnelDestGroupsMethodDescriptor);
    methodDescriptors.add(createTunnelDestGroupMethodDescriptor);
    methodDescriptors.add(getTunnelDestGroupMethodDescriptor);
    methodDescriptors.add(deleteTunnelDestGroupMethodDescriptor);
    methodDescriptors.add(updateTunnelDestGroupMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<GetIapSettingsRequest, IapSettings> getIapSettingsCallable() {
    return getIapSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateIapSettingsRequest, IapSettings> updateIapSettingsCallable() {
    return updateIapSettingsCallable;
  }

  @Override
  public UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsCallable() {
    return listTunnelDestGroupsCallable;
  }

  @Override
  public UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsPagedCallable() {
    return listTunnelDestGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupCallable() {
    return createTunnelDestGroupCallable;
  }

  @Override
  public UnaryCallable<GetTunnelDestGroupRequest, TunnelDestGroup> getTunnelDestGroupCallable() {
    return getTunnelDestGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupCallable() {
    return deleteTunnelDestGroupCallable;
  }

  @Override
  public UnaryCallable<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupCallable() {
    return updateTunnelDestGroupCallable;
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
