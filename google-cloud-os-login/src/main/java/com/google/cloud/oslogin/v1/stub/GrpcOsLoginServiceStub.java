/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.oslogin.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.oslogin.common.OsLoginProto.SshPublicKey;
import com.google.cloud.oslogin.v1.DeletePosixAccountRequest;
import com.google.cloud.oslogin.v1.DeleteSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.GetLoginProfileRequest;
import com.google.cloud.oslogin.v1.GetSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyResponse;
import com.google.cloud.oslogin.v1.LoginProfile;
import com.google.cloud.oslogin.v1.OsLoginServiceSettings;
import com.google.cloud.oslogin.v1.UpdateSshPublicKeyRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud OS Login API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
  private static final MethodDescriptor<GetSshPublicKeyRequest, SshPublicKey>
      getSshPublicKeyMethodDescriptor =
          MethodDescriptor.<GetSshPublicKeyRequest, SshPublicKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/GetSshPublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSshPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SshPublicKey.getDefaultInstance()))
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
  private static final MethodDescriptor<UpdateSshPublicKeyRequest, SshPublicKey>
      updateSshPublicKeyMethodDescriptor =
          MethodDescriptor.<UpdateSshPublicKeyRequest, SshPublicKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oslogin.v1.OsLoginService/UpdateSshPublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSshPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SshPublicKey.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable;
  private final UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable;
  private final UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable;
  private final UnaryCallable<GetSshPublicKeyRequest, SshPublicKey> getSshPublicKeyCallable;
  private final UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable;
  private final UnaryCallable<UpdateSshPublicKeyRequest, SshPublicKey> updateSshPublicKeyCallable;

  public static final GrpcOsLoginServiceStub create(OsLoginServiceSettings settings)
      throws IOException {
    return new GrpcOsLoginServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOsLoginServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOsLoginServiceStub(OsLoginServiceSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcOsLoginServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsLoginServiceStub(OsLoginServiceSettings settings, ClientContext clientContext)
      throws IOException {

    GrpcCallSettings<DeletePosixAccountRequest, Empty> deletePosixAccountTransportSettings =
        GrpcCallSettings.<DeletePosixAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePosixAccountMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyTransportSettings =
        GrpcCallSettings.<DeleteSshPublicKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSshPublicKeyMethodDescriptor)
            .build();
    GrpcCallSettings<GetLoginProfileRequest, LoginProfile> getLoginProfileTransportSettings =
        GrpcCallSettings.<GetLoginProfileRequest, LoginProfile>newBuilder()
            .setMethodDescriptor(getLoginProfileMethodDescriptor)
            .build();
    GrpcCallSettings<GetSshPublicKeyRequest, SshPublicKey> getSshPublicKeyTransportSettings =
        GrpcCallSettings.<GetSshPublicKeyRequest, SshPublicKey>newBuilder()
            .setMethodDescriptor(getSshPublicKeyMethodDescriptor)
            .build();
    GrpcCallSettings<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
        importSshPublicKeyTransportSettings =
            GrpcCallSettings.<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>newBuilder()
                .setMethodDescriptor(importSshPublicKeyMethodDescriptor)
                .build();
    GrpcCallSettings<UpdateSshPublicKeyRequest, SshPublicKey> updateSshPublicKeyTransportSettings =
        GrpcCallSettings.<UpdateSshPublicKeyRequest, SshPublicKey>newBuilder()
            .setMethodDescriptor(updateSshPublicKeyMethodDescriptor)
            .build();

    this.deletePosixAccountCallable =
        GrpcCallableFactory.createUnaryCallable(
            deletePosixAccountTransportSettings,
            settings.deletePosixAccountSettings(),
            clientContext);
    this.deleteSshPublicKeyCallable =
        GrpcCallableFactory.createUnaryCallable(
            deleteSshPublicKeyTransportSettings,
            settings.deleteSshPublicKeySettings(),
            clientContext);
    this.getLoginProfileCallable =
        GrpcCallableFactory.createUnaryCallable(
            getLoginProfileTransportSettings, settings.getLoginProfileSettings(), clientContext);
    this.getSshPublicKeyCallable =
        GrpcCallableFactory.createUnaryCallable(
            getSshPublicKeyTransportSettings, settings.getSshPublicKeySettings(), clientContext);
    this.importSshPublicKeyCallable =
        GrpcCallableFactory.createUnaryCallable(
            importSshPublicKeyTransportSettings,
            settings.importSshPublicKeySettings(),
            clientContext);
    this.updateSshPublicKeyCallable =
        GrpcCallableFactory.createUnaryCallable(
            updateSshPublicKeyTransportSettings,
            settings.updateSshPublicKeySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable() {
    return deletePosixAccountCallable;
  }

  public UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable() {
    return deleteSshPublicKeyCallable;
  }

  public UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable() {
    return getLoginProfileCallable;
  }

  public UnaryCallable<GetSshPublicKeyRequest, SshPublicKey> getSshPublicKeyCallable() {
    return getSshPublicKeyCallable;
  }

  public UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable() {
    return importSshPublicKeyCallable;
  }

  public UnaryCallable<UpdateSshPublicKeyRequest, SshPublicKey> updateSshPublicKeyCallable() {
    return updateSshPublicKeyCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
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
