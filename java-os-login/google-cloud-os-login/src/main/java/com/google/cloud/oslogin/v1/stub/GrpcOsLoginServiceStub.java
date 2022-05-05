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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OsLoginService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOsLoginServiceStub extends OsLoginServiceStub {
  private static final MethodDescriptor<DeletePosixAccountRequest, Empty>
      deletePosixAccountMethodDescriptor =
          MethodDescriptor.<DeletePosixAccountRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/DeletePosixAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePosixAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSshPublicKeyRequest, Empty>
      deleteSshPublicKeyMethodDescriptor =
          MethodDescriptor.<DeleteSshPublicKeyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/DeleteSshPublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSshPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLoginProfileRequest, LoginProfile>
      getLoginProfileMethodDescriptor =
          MethodDescriptor.<GetLoginProfileRequest, LoginProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/GetLoginProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLoginProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LoginProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeyMethodDescriptor =
          MethodDescriptor.<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/GetSshPublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSshPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OsLoginProto.SshPublicKey.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyMethodDescriptor =
          MethodDescriptor.<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/ImportSshPublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportSshPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ImportSshPublicKeyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeyMethodDescriptor =
          MethodDescriptor.<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/UpdateSshPublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSshPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OsLoginProto.SshPublicKey.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOsLoginServiceStub create(OsLoginServiceStubSettings settings)
      throws IOException {
    return new GrpcOsLoginServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOsLoginServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOsLoginServiceStub(
        OsLoginServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOsLoginServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOsLoginServiceStub(
        OsLoginServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOsLoginServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsLoginServiceStub(OsLoginServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOsLoginServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOsLoginServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsLoginServiceStub(
      OsLoginServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<DeletePosixAccountRequest, Empty> deletePosixAccountTransportSettings =
        GrpcCallSettings.<DeletePosixAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePosixAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyTransportSettings =
        GrpcCallSettings.<DeleteSshPublicKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSshPublicKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLoginProfileRequest, LoginProfile> getLoginProfileTransportSettings =
        GrpcCallSettings.<GetLoginProfileRequest, LoginProfile>newBuilder()
            .setMethodDescriptor(getLoginProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        getSshPublicKeyTransportSettings =
            GrpcCallSettings.<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
                .setMethodDescriptor(getSshPublicKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
        importSshPublicKeyTransportSettings =
            GrpcCallSettings.<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>newBuilder()
                .setMethodDescriptor(importSshPublicKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        updateSshPublicKeyTransportSettings =
            GrpcCallSettings.<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>newBuilder()
                .setMethodDescriptor(updateSshPublicKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
