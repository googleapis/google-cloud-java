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
package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.CreateCryptoKeyRequest;
import com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.DecryptRequest;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.EncryptRequest;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.GetCryptoKeyRequest;
import com.google.cloud.kms.v1.GetCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.GetKeyRingRequest;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse;
import com.google.cloud.kms.v1.ListCryptoKeysRequest;
import com.google.cloud.kms.v1.ListCryptoKeysResponse;
import com.google.cloud.kms.v1.ListKeyRingsRequest;
import com.google.cloud.kms.v1.ListKeyRingsResponse;
import com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest;
import com.google.cloud.kms.v1.UpdateCryptoKeyRequest;
import com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Key Management Service (KMS) API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcKeyManagementServiceStub extends KeyManagementServiceStub {

  private static final MethodDescriptor<ListKeyRingsRequest, ListKeyRingsResponse>
      listKeyRingsMethodDescriptor =
          MethodDescriptor.<ListKeyRingsRequest, ListKeyRingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListKeyRings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListKeyRingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListKeyRingsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListCryptoKeysRequest, ListCryptoKeysResponse>
      listCryptoKeysMethodDescriptor =
          MethodDescriptor.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListCryptoKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCryptoKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCryptoKeysResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsMethodDescriptor =
          MethodDescriptor.<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListCryptoKeyVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCryptoKeyVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCryptoKeyVersionsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetKeyRingRequest, KeyRing> getKeyRingMethodDescriptor =
      MethodDescriptor.<GetKeyRingRequest, KeyRing>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetKeyRing")
          .setRequestMarshaller(ProtoUtils.marshaller(GetKeyRingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(KeyRing.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetCryptoKeyRequest, CryptoKey>
      getCryptoKeyMethodDescriptor =
          MethodDescriptor.<GetCryptoKeyRequest, CryptoKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetCryptoKey")
              .setRequestMarshaller(ProtoUtils.marshaller(GetCryptoKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKey.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionMethodDescriptor =
          MethodDescriptor.<GetCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetCryptoKeyVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKeyVersion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateKeyRingRequest, KeyRing>
      createKeyRingMethodDescriptor =
          MethodDescriptor.<CreateKeyRingRequest, KeyRing>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateKeyRing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateKeyRingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(KeyRing.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateCryptoKeyRequest, CryptoKey>
      createCryptoKeyMethodDescriptor =
          MethodDescriptor.<CreateCryptoKeyRequest, CryptoKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateCryptoKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCryptoKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKey.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionMethodDescriptor =
          MethodDescriptor.<CreateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateCryptoKeyVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKeyVersion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateCryptoKeyRequest, CryptoKey>
      updateCryptoKeyMethodDescriptor =
          MethodDescriptor.<UpdateCryptoKeyRequest, CryptoKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/UpdateCryptoKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCryptoKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKey.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionMethodDescriptor =
          MethodDescriptor.<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/UpdateCryptoKeyVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKeyVersion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<EncryptRequest, EncryptResponse> encryptMethodDescriptor =
      MethodDescriptor.<EncryptRequest, EncryptResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.kms.v1.KeyManagementService/Encrypt")
          .setRequestMarshaller(ProtoUtils.marshaller(EncryptRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EncryptResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DecryptRequest, DecryptResponse> decryptMethodDescriptor =
      MethodDescriptor.<DecryptRequest, DecryptResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.kms.v1.KeyManagementService/Decrypt")
          .setRequestMarshaller(ProtoUtils.marshaller(DecryptRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DecryptResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionMethodDescriptor =
          MethodDescriptor.<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.KeyManagementService/UpdateCryptoKeyPrimaryVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCryptoKeyPrimaryVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKey.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionMethodDescriptor =
          MethodDescriptor.<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/DestroyCryptoKeyVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DestroyCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKeyVersion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionMethodDescriptor =
          MethodDescriptor.<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/RestoreCryptoKeyVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKeyVersion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsCallable;
  private final UnaryCallable<ListKeyRingsRequest, ListKeyRingsPagedResponse>
      listKeyRingsPagedCallable;
  private final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable;
  private final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable;
  private final UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsCallable;
  private final UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsPagedCallable;
  private final UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable;
  private final UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable;
  private final UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionCallable;
  private final UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable;
  private final UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable;
  private final UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable;
  private final UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable;
  private final UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable;
  private final UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable;
  private final UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable;
  private final UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable;
  private final UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable;
  private final UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcKeyManagementServiceStub create(KeyManagementServiceStubSettings settings)
      throws IOException {
    return new GrpcKeyManagementServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcKeyManagementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcKeyManagementServiceStub(
        KeyManagementServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcKeyManagementServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcKeyManagementServiceStub(
        KeyManagementServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcKeyManagementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcKeyManagementServiceStub(
      KeyManagementServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcKeyManagementServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcKeyManagementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcKeyManagementServiceStub(
      KeyManagementServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsTransportSettings =
        GrpcCallSettings.<ListKeyRingsRequest, ListKeyRingsResponse>newBuilder()
            .setMethodDescriptor(listKeyRingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListKeyRingsRequest>() {
                  @Override
                  public Map<String, String> extract(ListKeyRingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListCryptoKeysRequest, ListCryptoKeysResponse>
        listCryptoKeysTransportSettings =
            GrpcCallSettings.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeysMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListCryptoKeysRequest>() {
                      @Override
                      public Map<String, String> extract(ListCryptoKeysRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
        listCryptoKeyVersionsTransportSettings =
            GrpcCallSettings
                .<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeyVersionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListCryptoKeyVersionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListCryptoKeyVersionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetKeyRingRequest, KeyRing> getKeyRingTransportSettings =
        GrpcCallSettings.<GetKeyRingRequest, KeyRing>newBuilder()
            .setMethodDescriptor(getKeyRingMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetKeyRingRequest>() {
                  @Override
                  public Map<String, String> extract(GetKeyRingRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetCryptoKeyRequest, CryptoKey> getCryptoKeyTransportSettings =
        GrpcCallSettings.<GetCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(getCryptoKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetCryptoKeyRequest>() {
                  @Override
                  public Map<String, String> extract(GetCryptoKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetCryptoKeyVersionRequest, CryptoKeyVersion>
        getCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<GetCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(getCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetCryptoKeyVersionRequest>() {
                      @Override
                      public Map<String, String> extract(GetCryptoKeyVersionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateKeyRingRequest, KeyRing> createKeyRingTransportSettings =
        GrpcCallSettings.<CreateKeyRingRequest, KeyRing>newBuilder()
            .setMethodDescriptor(createKeyRingMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateKeyRingRequest>() {
                  @Override
                  public Map<String, String> extract(CreateKeyRingRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyTransportSettings =
        GrpcCallSettings.<CreateCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(createCryptoKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateCryptoKeyRequest>() {
                  @Override
                  public Map<String, String> extract(CreateCryptoKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
        createCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<CreateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(createCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateCryptoKeyVersionRequest>() {
                      @Override
                      public Map<String, String> extract(CreateCryptoKeyVersionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyTransportSettings =
        GrpcCallSettings.<UpdateCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(updateCryptoKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateCryptoKeyRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateCryptoKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("crypto_key.name", String.valueOf(request.getCryptoKey().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
        updateCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(updateCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateCryptoKeyVersionRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateCryptoKeyVersionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "crypto_key_version.name",
                            String.valueOf(request.getCryptoKeyVersion().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<EncryptRequest, EncryptResponse> encryptTransportSettings =
        GrpcCallSettings.<EncryptRequest, EncryptResponse>newBuilder()
            .setMethodDescriptor(encryptMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<EncryptRequest>() {
                  @Override
                  public Map<String, String> extract(EncryptRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DecryptRequest, DecryptResponse> decryptTransportSettings =
        GrpcCallSettings.<DecryptRequest, DecryptResponse>newBuilder()
            .setMethodDescriptor(decryptMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DecryptRequest>() {
                  @Override
                  public Map<String, String> extract(DecryptRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
        updateCryptoKeyPrimaryVersionTransportSettings =
            GrpcCallSettings.<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>newBuilder()
                .setMethodDescriptor(updateCryptoKeyPrimaryVersionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateCryptoKeyPrimaryVersionRequest>() {
                      @Override
                      public Map<String, String> extract(
                          UpdateCryptoKeyPrimaryVersionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
        destroyCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(destroyCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DestroyCryptoKeyVersionRequest>() {
                      @Override
                      public Map<String, String> extract(DestroyCryptoKeyVersionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
        restoreCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(restoreCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<RestoreCryptoKeyVersionRequest>() {
                      @Override
                      public Map<String, String> extract(RestoreCryptoKeyVersionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();

    this.listKeyRingsCallable =
        callableFactory.createUnaryCallable(
            listKeyRingsTransportSettings, settings.listKeyRingsSettings(), clientContext);
    this.listKeyRingsPagedCallable =
        callableFactory.createPagedCallable(
            listKeyRingsTransportSettings, settings.listKeyRingsSettings(), clientContext);
    this.listCryptoKeysCallable =
        callableFactory.createUnaryCallable(
            listCryptoKeysTransportSettings, settings.listCryptoKeysSettings(), clientContext);
    this.listCryptoKeysPagedCallable =
        callableFactory.createPagedCallable(
            listCryptoKeysTransportSettings, settings.listCryptoKeysSettings(), clientContext);
    this.listCryptoKeyVersionsCallable =
        callableFactory.createUnaryCallable(
            listCryptoKeyVersionsTransportSettings,
            settings.listCryptoKeyVersionsSettings(),
            clientContext);
    this.listCryptoKeyVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listCryptoKeyVersionsTransportSettings,
            settings.listCryptoKeyVersionsSettings(),
            clientContext);
    this.getKeyRingCallable =
        callableFactory.createUnaryCallable(
            getKeyRingTransportSettings, settings.getKeyRingSettings(), clientContext);
    this.getCryptoKeyCallable =
        callableFactory.createUnaryCallable(
            getCryptoKeyTransportSettings, settings.getCryptoKeySettings(), clientContext);
    this.getCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            getCryptoKeyVersionTransportSettings,
            settings.getCryptoKeyVersionSettings(),
            clientContext);
    this.createKeyRingCallable =
        callableFactory.createUnaryCallable(
            createKeyRingTransportSettings, settings.createKeyRingSettings(), clientContext);
    this.createCryptoKeyCallable =
        callableFactory.createUnaryCallable(
            createCryptoKeyTransportSettings, settings.createCryptoKeySettings(), clientContext);
    this.createCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            createCryptoKeyVersionTransportSettings,
            settings.createCryptoKeyVersionSettings(),
            clientContext);
    this.updateCryptoKeyCallable =
        callableFactory.createUnaryCallable(
            updateCryptoKeyTransportSettings, settings.updateCryptoKeySettings(), clientContext);
    this.updateCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            updateCryptoKeyVersionTransportSettings,
            settings.updateCryptoKeyVersionSettings(),
            clientContext);
    this.encryptCallable =
        callableFactory.createUnaryCallable(
            encryptTransportSettings, settings.encryptSettings(), clientContext);
    this.decryptCallable =
        callableFactory.createUnaryCallable(
            decryptTransportSettings, settings.decryptSettings(), clientContext);
    this.updateCryptoKeyPrimaryVersionCallable =
        callableFactory.createUnaryCallable(
            updateCryptoKeyPrimaryVersionTransportSettings,
            settings.updateCryptoKeyPrimaryVersionSettings(),
            clientContext);
    this.destroyCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            destroyCryptoKeyVersionTransportSettings,
            settings.destroyCryptoKeyVersionSettings(),
            clientContext);
    this.restoreCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            restoreCryptoKeyVersionTransportSettings,
            settings.restoreCryptoKeyVersionSettings(),
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListKeyRingsRequest, ListKeyRingsPagedResponse> listKeyRingsPagedCallable() {
    return listKeyRingsPagedCallable;
  }

  public UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsCallable() {
    return listKeyRingsCallable;
  }

  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    return listCryptoKeysPagedCallable;
  }

  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable() {
    return listCryptoKeysCallable;
  }

  public UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsPagedCallable() {
    return listCryptoKeyVersionsPagedCallable;
  }

  public UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsCallable() {
    return listCryptoKeyVersionsCallable;
  }

  public UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable() {
    return getKeyRingCallable;
  }

  public UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable() {
    return getCryptoKeyCallable;
  }

  public UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion> getCryptoKeyVersionCallable() {
    return getCryptoKeyVersionCallable;
  }

  public UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable() {
    return createKeyRingCallable;
  }

  public UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable() {
    return createCryptoKeyCallable;
  }

  public UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable() {
    return createCryptoKeyVersionCallable;
  }

  public UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable() {
    return updateCryptoKeyCallable;
  }

  public UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable() {
    return updateCryptoKeyVersionCallable;
  }

  public UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable() {
    return encryptCallable;
  }

  public UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable() {
    return decryptCallable;
  }

  public UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable() {
    return updateCryptoKeyPrimaryVersionCallable;
  }

  public UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable() {
    return destroyCryptoKeyVersionCallable;
  }

  public UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable() {
    return restoreCryptoKeyVersionCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
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
