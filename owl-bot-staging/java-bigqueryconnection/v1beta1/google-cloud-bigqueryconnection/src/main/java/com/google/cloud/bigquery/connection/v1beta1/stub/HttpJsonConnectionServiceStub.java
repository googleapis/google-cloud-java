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

package com.google.cloud.bigquery.connection.v1beta1.stub;

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
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto;
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
 * REST stub implementation for the ConnectionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonConnectionServiceStub extends ConnectionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionMethodDescriptor =
          ApiMethodDescriptor
              .<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/CreateConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConnectionProto.CreateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/connections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.CreateConnectionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.CreateConnectionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectionId", request.getConnectionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connection", request.getConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectionProto.Connection>newBuilder()
                      .setDefaultInstance(ConnectionProto.Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionMethodDescriptor =
          ApiMethodDescriptor
              .<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/GetConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConnectionProto.GetConnectionRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.GetConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.GetConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectionProto.Connection>newBuilder()
                      .setDefaultInstance(ConnectionProto.Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          ApiMethodDescriptor
              .<ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/ListConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConnectionProto.ListConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/connections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.ListConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.ListConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectionProto.ListConnectionsResponse>newBuilder()
                      .setDefaultInstance(
                          ConnectionProto.ListConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionMethodDescriptor =
          ApiMethodDescriptor
              .<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/UpdateConnection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConnectionProto.UpdateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.UpdateConnectionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.UpdateConnectionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connection", request.getConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectionProto.Connection>newBuilder()
                      .setDefaultInstance(ConnectionProto.Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialMethodDescriptor =
          ApiMethodDescriptor.<ConnectionProto.UpdateConnectionCredentialRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/UpdateConnectionCredential")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ConnectionProto.UpdateConnectionCredentialRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/connections/*/credential}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.UpdateConnectionCredentialRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.UpdateConnectionCredentialRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("credential", request.getCredential(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ConnectionProto.DeleteConnectionRequest, Empty>
      deleteConnectionMethodDescriptor =
          ApiMethodDescriptor.<ConnectionProto.DeleteConnectionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/DeleteConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConnectionProto.DeleteConnectionRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.DeleteConnectionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConnectionProto.DeleteConnectionRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/connections/*}:getIamPolicy",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/connections/*}:setIamPolicy",
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/connections/*}:testIamPermissions",
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

  private final UnaryCallable<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionCallable;
  private final UnaryCallable<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionCallable;
  private final UnaryCallable<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionCallable;
  private final UnaryCallable<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialCallable;
  private final UnaryCallable<ConnectionProto.DeleteConnectionRequest, Empty>
      deleteConnectionCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConnectionServiceStub create(ConnectionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonConnectionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConnectionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConnectionServiceStub(
        ConnectionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConnectionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConnectionServiceStub(
        ConnectionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConnectionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConnectionServiceStub(
      ConnectionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonConnectionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConnectionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConnectionServiceStub(
      ConnectionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
        createConnectionTransportSettings =
            HttpJsonCallSettings
                .<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>newBuilder()
                .setMethodDescriptor(createConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
        getConnectionTransportSettings =
            HttpJsonCallSettings
                .<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>newBuilder()
                .setMethodDescriptor(getConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
        listConnectionsTransportSettings =
            HttpJsonCallSettings
                .<ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
                    newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
        updateConnectionTransportSettings =
            HttpJsonCallSettings
                .<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>newBuilder()
                .setMethodDescriptor(updateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
        updateConnectionCredentialTransportSettings =
            HttpJsonCallSettings
                .<ConnectionProto.UpdateConnectionCredentialRequest, Empty>newBuilder()
                .setMethodDescriptor(updateConnectionCredentialMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ConnectionProto.DeleteConnectionRequest, Empty>
        deleteConnectionTransportSettings =
            HttpJsonCallSettings.<ConnectionProto.DeleteConnectionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.updateConnectionCallable =
        callableFactory.createUnaryCallable(
            updateConnectionTransportSettings, settings.updateConnectionSettings(), clientContext);
    this.updateConnectionCredentialCallable =
        callableFactory.createUnaryCallable(
            updateConnectionCredentialTransportSettings,
            settings.updateConnectionCredentialSettings(),
            clientContext);
    this.deleteConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionTransportSettings, settings.deleteConnectionSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
    methodDescriptors.add(createConnectionMethodDescriptor);
    methodDescriptors.add(getConnectionMethodDescriptor);
    methodDescriptors.add(listConnectionsMethodDescriptor);
    methodDescriptors.add(updateConnectionMethodDescriptor);
    methodDescriptors.add(updateConnectionCredentialMethodDescriptor);
    methodDescriptors.add(deleteConnectionMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionCallable() {
    return createConnectionCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionCallable() {
    return getConnectionCallable;
  }

  @Override
  public UnaryCallable<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionCallable() {
    return updateConnectionCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialCallable() {
    return updateConnectionCredentialCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    return deleteConnectionCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
