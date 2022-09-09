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

package com.google.cloud.oslogin.v1.stub;

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
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1.DeletePosixAccountRequest;
import com.google.cloud.oslogin.v1.DeleteSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.GetLoginProfileRequest;
import com.google.cloud.oslogin.v1.GetSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyResponse;
import com.google.cloud.oslogin.v1.LoginProfile;
import com.google.cloud.oslogin.v1.UpdateSshPublicKeyRequest;
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
 * REST stub implementation for the OsLoginService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonOsLoginServiceStub extends OsLoginServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<DeletePosixAccountRequest, Empty>
      deletePosixAccountMethodDescriptor =
          ApiMethodDescriptor.<DeletePosixAccountRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/DeletePosixAccount")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePosixAccountRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/projects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePosixAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePosixAccountRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<DeleteSshPublicKeyRequest, Empty>
      deleteSshPublicKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSshPublicKeyRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/DeleteSshPublicKey")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSshPublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/sshPublicKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<GetLoginProfileRequest, LoginProfile>
      getLoginProfileMethodDescriptor =
          ApiMethodDescriptor.<GetLoginProfileRequest, LoginProfile>newBuilder()
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/GetLoginProfile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLoginProfileRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*}/loginProfile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLoginProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLoginProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "projectId", request.getProjectId());
                            serializer.putQueryParam(fields, "systemId", request.getSystemId());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LoginProfile>newBuilder()
                      .setDefaultInstance(LoginProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeyMethodDescriptor =
          ApiMethodDescriptor.<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/GetSshPublicKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSshPublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/sshPublicKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OsLoginProto.SshPublicKey>newBuilder()
                      .setDefaultInstance(OsLoginProto.SshPublicKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyMethodDescriptor =
          ApiMethodDescriptor.<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>newBuilder()
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/ImportSshPublicKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportSshPublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=users/*}:importSshPublicKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sshPublicKey", request.getSshPublicKey(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImportSshPublicKeyResponse>newBuilder()
                      .setDefaultInstance(ImportSshPublicKeyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeyMethodDescriptor =
          ApiMethodDescriptor.<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/UpdateSshPublicKey")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSshPublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/sshPublicKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSshPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sshPublicKey", request.getSshPublicKey(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OsLoginProto.SshPublicKey>newBuilder()
                      .setDefaultInstance(OsLoginProto.SshPublicKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable;
  private final UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable;
  private final UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable;
  private final UnaryCallable<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeyCallable;
  private final UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable;
  private final UnaryCallable<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeyCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOsLoginServiceStub create(OsLoginServiceStubSettings settings)
      throws IOException {
    return new HttpJsonOsLoginServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOsLoginServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOsLoginServiceStub(
        OsLoginServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOsLoginServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOsLoginServiceStub(
        OsLoginServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOsLoginServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOsLoginServiceStub(
      OsLoginServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonOsLoginServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOsLoginServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOsLoginServiceStub(
      OsLoginServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeletePosixAccountRequest, Empty> deletePosixAccountTransportSettings =
        HttpJsonCallSettings.<DeletePosixAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePosixAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyTransportSettings =
        HttpJsonCallSettings.<DeleteSshPublicKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSshPublicKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetLoginProfileRequest, LoginProfile> getLoginProfileTransportSettings =
        HttpJsonCallSettings.<GetLoginProfileRequest, LoginProfile>newBuilder()
            .setMethodDescriptor(getLoginProfileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        getSshPublicKeyTransportSettings =
            HttpJsonCallSettings.<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
                .setMethodDescriptor(getSshPublicKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
        importSshPublicKeyTransportSettings =
            HttpJsonCallSettings.<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>newBuilder()
                .setMethodDescriptor(importSshPublicKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        updateSshPublicKeyTransportSettings =
            HttpJsonCallSettings.<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
                .setMethodDescriptor(updateSshPublicKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.deletePosixAccountCallable =
        callableFactory.createUnaryCallable(
            deletePosixAccountTransportSettings,
            settings.deletePosixAccountSettings(),
            clientContext);
    this.deleteSshPublicKeyCallable =
        callableFactory.createUnaryCallable(
            deleteSshPublicKeyTransportSettings,
            settings.deleteSshPublicKeySettings(),
            clientContext);
    this.getLoginProfileCallable =
        callableFactory.createUnaryCallable(
            getLoginProfileTransportSettings, settings.getLoginProfileSettings(), clientContext);
    this.getSshPublicKeyCallable =
        callableFactory.createUnaryCallable(
            getSshPublicKeyTransportSettings, settings.getSshPublicKeySettings(), clientContext);
    this.importSshPublicKeyCallable =
        callableFactory.createUnaryCallable(
            importSshPublicKeyTransportSettings,
            settings.importSshPublicKeySettings(),
            clientContext);
    this.updateSshPublicKeyCallable =
        callableFactory.createUnaryCallable(
            updateSshPublicKeyTransportSettings,
            settings.updateSshPublicKeySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deletePosixAccountMethodDescriptor);
    methodDescriptors.add(deleteSshPublicKeyMethodDescriptor);
    methodDescriptors.add(getLoginProfileMethodDescriptor);
    methodDescriptors.add(getSshPublicKeyMethodDescriptor);
    methodDescriptors.add(importSshPublicKeyMethodDescriptor);
    methodDescriptors.add(updateSshPublicKeyMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable() {
    return deletePosixAccountCallable;
  }

  @Override
  public UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable() {
    return deleteSshPublicKeyCallable;
  }

  @Override
  public UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable() {
    return getLoginProfileCallable;
  }

  @Override
  public UnaryCallable<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeyCallable() {
    return getSshPublicKeyCallable;
  }

  @Override
  public UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable() {
    return importSshPublicKeyCallable;
  }

  @Override
  public UnaryCallable<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeyCallable() {
    return updateSshPublicKeyCallable;
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
