/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.secretmanager.v1.stub;

import static com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretVersionsPagedResponse;
import static com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.secretmanager.v1.AccessSecretVersionRequest;
import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1.CreateSecretRequest;
import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.DestroySecretVersionRequest;
import com.google.cloud.secretmanager.v1.DisableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.EnableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.GetSecretRequest;
import com.google.cloud.secretmanager.v1.GetSecretVersionRequest;
import com.google.cloud.secretmanager.v1.ListSecretVersionsRequest;
import com.google.cloud.secretmanager.v1.ListSecretVersionsResponse;
import com.google.cloud.secretmanager.v1.ListSecretsRequest;
import com.google.cloud.secretmanager.v1.ListSecretsResponse;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.cloud.secretmanager.v1.UpdateSecretRequest;
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
 * REST stub implementation for the SecretManagerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSecretManagerServiceStub extends SecretManagerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListSecretsRequest, ListSecretsResponse>
      listSecretsMethodDescriptor =
          ApiMethodDescriptor.<ListSecretsRequest, ListSecretsResponse>newBuilder()
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/ListSecrets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSecretsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/secrets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecretsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecretsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSecretsResponse>newBuilder()
                      .setDefaultInstance(ListSecretsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSecretRequest, Secret>
      createSecretMethodDescriptor =
          ApiMethodDescriptor.<CreateSecretRequest, Secret>newBuilder()
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/CreateSecret")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/secrets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "secretId", request.getSecretId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("secret", request.getSecret(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Secret>newBuilder()
                      .setDefaultInstance(Secret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddSecretVersionRequest, SecretVersion>
      addSecretVersionMethodDescriptor =
          ApiMethodDescriptor.<AddSecretVersionRequest, SecretVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/AddSecretVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddSecretVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/secrets/*}:addVersion",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecretVersion>newBuilder()
                      .setDefaultInstance(SecretVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSecretRequest, Secret> getSecretMethodDescriptor =
      ApiMethodDescriptor.<GetSecretRequest, Secret>newBuilder()
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/GetSecret")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSecretRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/secrets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSecretRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSecretRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Secret>newBuilder()
                  .setDefaultInstance(Secret.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSecretRequest, Secret>
      updateSecretMethodDescriptor =
          ApiMethodDescriptor.<UpdateSecretRequest, Secret>newBuilder()
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/UpdateSecret")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{secret.name=projects/*/secrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "secret.name", request.getSecret().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("secret", request.getSecret(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Secret>newBuilder()
                      .setDefaultInstance(Secret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSecretRequest, Empty>
      deleteSecretMethodDescriptor =
          ApiMethodDescriptor.<DeleteSecretRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/DeleteSecret")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/secrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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

  private static final ApiMethodDescriptor<ListSecretVersionsRequest, ListSecretVersionsResponse>
      listSecretVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListSecretVersionsRequest, ListSecretVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/ListSecretVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSecretVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/secrets/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecretVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecretVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSecretVersionsResponse>newBuilder()
                      .setDefaultInstance(ListSecretVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSecretVersionRequest, SecretVersion>
      getSecretVersionMethodDescriptor =
          ApiMethodDescriptor.<GetSecretVersionRequest, SecretVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/GetSecretVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSecretVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/secrets/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecretVersion>newBuilder()
                      .setDefaultInstance(SecretVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionMethodDescriptor =
          ApiMethodDescriptor.<AccessSecretVersionRequest, AccessSecretVersionResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/AccessSecretVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AccessSecretVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/secrets/*/versions/*}:access",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AccessSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AccessSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessSecretVersionResponse>newBuilder()
                      .setDefaultInstance(AccessSecretVersionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionMethodDescriptor =
          ApiMethodDescriptor.<DisableSecretVersionRequest, SecretVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/DisableSecretVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableSecretVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/secrets/*/versions/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecretVersion>newBuilder()
                      .setDefaultInstance(SecretVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionMethodDescriptor =
          ApiMethodDescriptor.<EnableSecretVersionRequest, SecretVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/EnableSecretVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableSecretVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/secrets/*/versions/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableSecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecretVersion>newBuilder()
                      .setDefaultInstance(SecretVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionMethodDescriptor =
          ApiMethodDescriptor.<DestroySecretVersionRequest, SecretVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/DestroySecretVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DestroySecretVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/secrets/*/versions/*}:destroy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DestroySecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DestroySecretVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecretVersion>newBuilder()
                      .setDefaultInstance(SecretVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/secrets/*}:setIamPolicy",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
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
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/secrets/*}:getIamPolicy",
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
                            serializer.putQueryParam(fields, "options", request.getOptions());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
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
                  "google.cloud.secretmanager.v1.SecretManagerService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/secrets/*}:testIamPermissions",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListSecretsRequest, ListSecretsResponse> listSecretsCallable;
  private final UnaryCallable<ListSecretsRequest, ListSecretsPagedResponse>
      listSecretsPagedCallable;
  private final UnaryCallable<CreateSecretRequest, Secret> createSecretCallable;
  private final UnaryCallable<AddSecretVersionRequest, SecretVersion> addSecretVersionCallable;
  private final UnaryCallable<GetSecretRequest, Secret> getSecretCallable;
  private final UnaryCallable<UpdateSecretRequest, Secret> updateSecretCallable;
  private final UnaryCallable<DeleteSecretRequest, Empty> deleteSecretCallable;
  private final UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsResponse>
      listSecretVersionsCallable;
  private final UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsPagedResponse>
      listSecretVersionsPagedCallable;
  private final UnaryCallable<GetSecretVersionRequest, SecretVersion> getSecretVersionCallable;
  private final UnaryCallable<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionCallable;
  private final UnaryCallable<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionCallable;
  private final UnaryCallable<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionCallable;
  private final UnaryCallable<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecretManagerServiceStub create(
      SecretManagerServiceStubSettings settings) throws IOException {
    return new HttpJsonSecretManagerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecretManagerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecretManagerServiceStub(
        SecretManagerServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSecretManagerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecretManagerServiceStub(
        SecretManagerServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecretManagerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecretManagerServiceStub(
      SecretManagerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSecretManagerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecretManagerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecretManagerServiceStub(
      SecretManagerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListSecretsRequest, ListSecretsResponse> listSecretsTransportSettings =
        HttpJsonCallSettings.<ListSecretsRequest, ListSecretsResponse>newBuilder()
            .setMethodDescriptor(listSecretsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateSecretRequest, Secret> createSecretTransportSettings =
        HttpJsonCallSettings.<CreateSecretRequest, Secret>newBuilder()
            .setMethodDescriptor(createSecretMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AddSecretVersionRequest, SecretVersion> addSecretVersionTransportSettings =
        HttpJsonCallSettings.<AddSecretVersionRequest, SecretVersion>newBuilder()
            .setMethodDescriptor(addSecretVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSecretRequest, Secret> getSecretTransportSettings =
        HttpJsonCallSettings.<GetSecretRequest, Secret>newBuilder()
            .setMethodDescriptor(getSecretMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSecretRequest, Secret> updateSecretTransportSettings =
        HttpJsonCallSettings.<UpdateSecretRequest, Secret>newBuilder()
            .setMethodDescriptor(updateSecretMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSecretRequest, Empty> deleteSecretTransportSettings =
        HttpJsonCallSettings.<DeleteSecretRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSecretMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSecretVersionsRequest, ListSecretVersionsResponse>
        listSecretVersionsTransportSettings =
            HttpJsonCallSettings.<ListSecretVersionsRequest, ListSecretVersionsResponse>newBuilder()
                .setMethodDescriptor(listSecretVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSecretVersionRequest, SecretVersion> getSecretVersionTransportSettings =
        HttpJsonCallSettings.<GetSecretVersionRequest, SecretVersion>newBuilder()
            .setMethodDescriptor(getSecretVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AccessSecretVersionRequest, AccessSecretVersionResponse>
        accessSecretVersionTransportSettings =
            HttpJsonCallSettings
                .<AccessSecretVersionRequest, AccessSecretVersionResponse>newBuilder()
                .setMethodDescriptor(accessSecretVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DisableSecretVersionRequest, SecretVersion>
        disableSecretVersionTransportSettings =
            HttpJsonCallSettings.<DisableSecretVersionRequest, SecretVersion>newBuilder()
                .setMethodDescriptor(disableSecretVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<EnableSecretVersionRequest, SecretVersion>
        enableSecretVersionTransportSettings =
            HttpJsonCallSettings.<EnableSecretVersionRequest, SecretVersion>newBuilder()
                .setMethodDescriptor(enableSecretVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DestroySecretVersionRequest, SecretVersion>
        destroySecretVersionTransportSettings =
            HttpJsonCallSettings.<DestroySecretVersionRequest, SecretVersion>newBuilder()
                .setMethodDescriptor(destroySecretVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listSecretsCallable =
        callableFactory.createUnaryCallable(
            listSecretsTransportSettings, settings.listSecretsSettings(), clientContext);
    this.listSecretsPagedCallable =
        callableFactory.createPagedCallable(
            listSecretsTransportSettings, settings.listSecretsSettings(), clientContext);
    this.createSecretCallable =
        callableFactory.createUnaryCallable(
            createSecretTransportSettings, settings.createSecretSettings(), clientContext);
    this.addSecretVersionCallable =
        callableFactory.createUnaryCallable(
            addSecretVersionTransportSettings, settings.addSecretVersionSettings(), clientContext);
    this.getSecretCallable =
        callableFactory.createUnaryCallable(
            getSecretTransportSettings, settings.getSecretSettings(), clientContext);
    this.updateSecretCallable =
        callableFactory.createUnaryCallable(
            updateSecretTransportSettings, settings.updateSecretSettings(), clientContext);
    this.deleteSecretCallable =
        callableFactory.createUnaryCallable(
            deleteSecretTransportSettings, settings.deleteSecretSettings(), clientContext);
    this.listSecretVersionsCallable =
        callableFactory.createUnaryCallable(
            listSecretVersionsTransportSettings,
            settings.listSecretVersionsSettings(),
            clientContext);
    this.listSecretVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listSecretVersionsTransportSettings,
            settings.listSecretVersionsSettings(),
            clientContext);
    this.getSecretVersionCallable =
        callableFactory.createUnaryCallable(
            getSecretVersionTransportSettings, settings.getSecretVersionSettings(), clientContext);
    this.accessSecretVersionCallable =
        callableFactory.createUnaryCallable(
            accessSecretVersionTransportSettings,
            settings.accessSecretVersionSettings(),
            clientContext);
    this.disableSecretVersionCallable =
        callableFactory.createUnaryCallable(
            disableSecretVersionTransportSettings,
            settings.disableSecretVersionSettings(),
            clientContext);
    this.enableSecretVersionCallable =
        callableFactory.createUnaryCallable(
            enableSecretVersionTransportSettings,
            settings.enableSecretVersionSettings(),
            clientContext);
    this.destroySecretVersionCallable =
        callableFactory.createUnaryCallable(
            destroySecretVersionTransportSettings,
            settings.destroySecretVersionSettings(),
            clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listSecretsMethodDescriptor);
    methodDescriptors.add(createSecretMethodDescriptor);
    methodDescriptors.add(addSecretVersionMethodDescriptor);
    methodDescriptors.add(getSecretMethodDescriptor);
    methodDescriptors.add(updateSecretMethodDescriptor);
    methodDescriptors.add(deleteSecretMethodDescriptor);
    methodDescriptors.add(listSecretVersionsMethodDescriptor);
    methodDescriptors.add(getSecretVersionMethodDescriptor);
    methodDescriptors.add(accessSecretVersionMethodDescriptor);
    methodDescriptors.add(disableSecretVersionMethodDescriptor);
    methodDescriptors.add(enableSecretVersionMethodDescriptor);
    methodDescriptors.add(destroySecretVersionMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListSecretsRequest, ListSecretsResponse> listSecretsCallable() {
    return listSecretsCallable;
  }

  @Override
  public UnaryCallable<ListSecretsRequest, ListSecretsPagedResponse> listSecretsPagedCallable() {
    return listSecretsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSecretRequest, Secret> createSecretCallable() {
    return createSecretCallable;
  }

  @Override
  public UnaryCallable<AddSecretVersionRequest, SecretVersion> addSecretVersionCallable() {
    return addSecretVersionCallable;
  }

  @Override
  public UnaryCallable<GetSecretRequest, Secret> getSecretCallable() {
    return getSecretCallable;
  }

  @Override
  public UnaryCallable<UpdateSecretRequest, Secret> updateSecretCallable() {
    return updateSecretCallable;
  }

  @Override
  public UnaryCallable<DeleteSecretRequest, Empty> deleteSecretCallable() {
    return deleteSecretCallable;
  }

  @Override
  public UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsResponse>
      listSecretVersionsCallable() {
    return listSecretVersionsCallable;
  }

  @Override
  public UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsPagedResponse>
      listSecretVersionsPagedCallable() {
    return listSecretVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSecretVersionRequest, SecretVersion> getSecretVersionCallable() {
    return getSecretVersionCallable;
  }

  @Override
  public UnaryCallable<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionCallable() {
    return accessSecretVersionCallable;
  }

  @Override
  public UnaryCallable<DisableSecretVersionRequest, SecretVersion> disableSecretVersionCallable() {
    return disableSecretVersionCallable;
  }

  @Override
  public UnaryCallable<EnableSecretVersionRequest, SecretVersion> enableSecretVersionCallable() {
    return enableSecretVersionCallable;
  }

  @Override
  public UnaryCallable<DestroySecretVersionRequest, SecretVersion> destroySecretVersionCallable() {
    return destroySecretVersionCallable;
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
