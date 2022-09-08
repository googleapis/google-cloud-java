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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SecretManagerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecretManagerServiceStub extends SecretManagerServiceStub {
  private static final MethodDescriptor<ListSecretsRequest, ListSecretsResponse>
      listSecretsMethodDescriptor =
          MethodDescriptor.<ListSecretsRequest, ListSecretsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/ListSecrets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSecretsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSecretsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSecretRequest, Secret> createSecretMethodDescriptor =
      MethodDescriptor.<CreateSecretRequest, Secret>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/CreateSecret")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSecretRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Secret.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<AddSecretVersionRequest, SecretVersion>
      addSecretVersionMethodDescriptor =
          MethodDescriptor.<AddSecretVersionRequest, SecretVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/AddSecretVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecretVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSecretRequest, Secret> getSecretMethodDescriptor =
      MethodDescriptor.<GetSecretRequest, Secret>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/GetSecret")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSecretRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Secret.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSecretRequest, Secret> updateSecretMethodDescriptor =
      MethodDescriptor.<UpdateSecretRequest, Secret>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/UpdateSecret")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSecretRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Secret.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSecretRequest, Empty> deleteSecretMethodDescriptor =
      MethodDescriptor.<DeleteSecretRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/DeleteSecret")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSecretRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSecretVersionsRequest, ListSecretVersionsResponse>
      listSecretVersionsMethodDescriptor =
          MethodDescriptor.<ListSecretVersionsRequest, ListSecretVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/ListSecretVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSecretVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSecretVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSecretVersionRequest, SecretVersion>
      getSecretVersionMethodDescriptor =
          MethodDescriptor.<GetSecretVersionRequest, SecretVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/GetSecretVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecretVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionMethodDescriptor =
          MethodDescriptor.<AccessSecretVersionRequest, AccessSecretVersionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/AccessSecretVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AccessSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AccessSecretVersionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionMethodDescriptor =
          MethodDescriptor.<DisableSecretVersionRequest, SecretVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/DisableSecretVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecretVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionMethodDescriptor =
          MethodDescriptor.<EnableSecretVersionRequest, SecretVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/EnableSecretVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecretVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionMethodDescriptor =
          MethodDescriptor.<DestroySecretVersionRequest, SecretVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/DestroySecretVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DestroySecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecretVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.secretmanager.v1.SecretManagerService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.secretmanager.v1.SecretManagerService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecretManagerServiceStub create(SecretManagerServiceStubSettings settings)
      throws IOException {
    return new GrpcSecretManagerServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecretManagerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecretManagerServiceStub(
        SecretManagerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecretManagerServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecretManagerServiceStub(
        SecretManagerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecretManagerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecretManagerServiceStub(
      SecretManagerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSecretManagerServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecretManagerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecretManagerServiceStub(
      SecretManagerServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSecretsRequest, ListSecretsResponse> listSecretsTransportSettings =
        GrpcCallSettings.<ListSecretsRequest, ListSecretsResponse>newBuilder()
            .setMethodDescriptor(listSecretsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateSecretRequest, Secret> createSecretTransportSettings =
        GrpcCallSettings.<CreateSecretRequest, Secret>newBuilder()
            .setMethodDescriptor(createSecretMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AddSecretVersionRequest, SecretVersion> addSecretVersionTransportSettings =
        GrpcCallSettings.<AddSecretVersionRequest, SecretVersion>newBuilder()
            .setMethodDescriptor(addSecretVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSecretRequest, Secret> getSecretTransportSettings =
        GrpcCallSettings.<GetSecretRequest, Secret>newBuilder()
            .setMethodDescriptor(getSecretMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSecretRequest, Secret> updateSecretTransportSettings =
        GrpcCallSettings.<UpdateSecretRequest, Secret>newBuilder()
            .setMethodDescriptor(updateSecretMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("secret.name", String.valueOf(request.getSecret().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteSecretRequest, Empty> deleteSecretTransportSettings =
        GrpcCallSettings.<DeleteSecretRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSecretMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSecretVersionsRequest, ListSecretVersionsResponse>
        listSecretVersionsTransportSettings =
            GrpcCallSettings.<ListSecretVersionsRequest, ListSecretVersionsResponse>newBuilder()
                .setMethodDescriptor(listSecretVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetSecretVersionRequest, SecretVersion> getSecretVersionTransportSettings =
        GrpcCallSettings.<GetSecretVersionRequest, SecretVersion>newBuilder()
            .setMethodDescriptor(getSecretVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AccessSecretVersionRequest, AccessSecretVersionResponse>
        accessSecretVersionTransportSettings =
            GrpcCallSettings.<AccessSecretVersionRequest, AccessSecretVersionResponse>newBuilder()
                .setMethodDescriptor(accessSecretVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DisableSecretVersionRequest, SecretVersion>
        disableSecretVersionTransportSettings =
            GrpcCallSettings.<DisableSecretVersionRequest, SecretVersion>newBuilder()
                .setMethodDescriptor(disableSecretVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<EnableSecretVersionRequest, SecretVersion>
        enableSecretVersionTransportSettings =
            GrpcCallSettings.<EnableSecretVersionRequest, SecretVersion>newBuilder()
                .setMethodDescriptor(enableSecretVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DestroySecretVersionRequest, SecretVersion>
        destroySecretVersionTransportSettings =
            GrpcCallSettings.<DestroySecretVersionRequest, SecretVersion>newBuilder()
                .setMethodDescriptor(destroySecretVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
