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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListImportJobsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.AsymmetricDecryptRequest;
import com.google.cloud.kms.v1.AsymmetricDecryptResponse;
import com.google.cloud.kms.v1.AsymmetricSignRequest;
import com.google.cloud.kms.v1.AsymmetricSignResponse;
import com.google.cloud.kms.v1.CreateCryptoKeyRequest;
import com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.CreateImportJobRequest;
import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.DecryptRequest;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.EncryptRequest;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.GenerateRandomBytesRequest;
import com.google.cloud.kms.v1.GenerateRandomBytesResponse;
import com.google.cloud.kms.v1.GetCryptoKeyRequest;
import com.google.cloud.kms.v1.GetCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.GetImportJobRequest;
import com.google.cloud.kms.v1.GetKeyRingRequest;
import com.google.cloud.kms.v1.GetPublicKeyRequest;
import com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.ImportJob;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse;
import com.google.cloud.kms.v1.ListCryptoKeysRequest;
import com.google.cloud.kms.v1.ListCryptoKeysResponse;
import com.google.cloud.kms.v1.ListImportJobsRequest;
import com.google.cloud.kms.v1.ListImportJobsResponse;
import com.google.cloud.kms.v1.ListKeyRingsRequest;
import com.google.cloud.kms.v1.ListKeyRingsResponse;
import com.google.cloud.kms.v1.MacSignRequest;
import com.google.cloud.kms.v1.MacSignResponse;
import com.google.cloud.kms.v1.MacVerifyRequest;
import com.google.cloud.kms.v1.MacVerifyResponse;
import com.google.cloud.kms.v1.PublicKey;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the KeyManagementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
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

  private static final MethodDescriptor<ListImportJobsRequest, ListImportJobsResponse>
      listImportJobsMethodDescriptor =
          MethodDescriptor.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListImportJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListImportJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListImportJobsResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<GetPublicKeyRequest, PublicKey>
      getPublicKeyMethodDescriptor =
          MethodDescriptor.<GetPublicKeyRequest, PublicKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetPublicKey")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PublicKey.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetImportJobRequest, ImportJob>
      getImportJobMethodDescriptor =
          MethodDescriptor.<GetImportJobRequest, ImportJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetImportJob")
              .setRequestMarshaller(ProtoUtils.marshaller(GetImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ImportJob.getDefaultInstance()))
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

  private static final MethodDescriptor<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionMethodDescriptor =
          MethodDescriptor.<ImportCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ImportCryptoKeyVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CryptoKeyVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateImportJobRequest, ImportJob>
      createImportJobMethodDescriptor =
          MethodDescriptor.<CreateImportJobRequest, ImportJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateImportJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ImportJob.getDefaultInstance()))
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

  private static final MethodDescriptor<AsymmetricSignRequest, AsymmetricSignResponse>
      asymmetricSignMethodDescriptor =
          MethodDescriptor.<AsymmetricSignRequest, AsymmetricSignResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/AsymmetricSign")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AsymmetricSignRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AsymmetricSignResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptMethodDescriptor =
          MethodDescriptor.<AsymmetricDecryptRequest, AsymmetricDecryptResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/AsymmetricDecrypt")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AsymmetricDecryptRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AsymmetricDecryptResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MacSignRequest, MacSignResponse> macSignMethodDescriptor =
      MethodDescriptor.<MacSignRequest, MacSignResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.kms.v1.KeyManagementService/MacSign")
          .setRequestMarshaller(ProtoUtils.marshaller(MacSignRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(MacSignResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<MacVerifyRequest, MacVerifyResponse>
      macVerifyMethodDescriptor =
          MethodDescriptor.<MacVerifyRequest, MacVerifyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/MacVerify")
              .setRequestMarshaller(ProtoUtils.marshaller(MacVerifyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MacVerifyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesMethodDescriptor =
          MethodDescriptor.<GenerateRandomBytesRequest, GenerateRandomBytesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GenerateRandomBytes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateRandomBytesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateRandomBytesResponse.getDefaultInstance()))
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
  private final UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> listImportJobsCallable;
  private final UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable;
  private final UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable;
  private final UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable;
  private final UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionCallable;
  private final UnaryCallable<GetPublicKeyRequest, PublicKey> getPublicKeyCallable;
  private final UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable;
  private final UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable;
  private final UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable;
  private final UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable;
  private final UnaryCallable<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionCallable;
  private final UnaryCallable<CreateImportJobRequest, ImportJob> createImportJobCallable;
  private final UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable;
  private final UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable;
  private final UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable;
  private final UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable;
  private final UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable;
  private final UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable;
  private final UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable;
  private final UnaryCallable<AsymmetricSignRequest, AsymmetricSignResponse> asymmetricSignCallable;
  private final UnaryCallable<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptCallable;
  private final UnaryCallable<MacSignRequest, MacSignResponse> macSignCallable;
  private final UnaryCallable<MacVerifyRequest, MacVerifyResponse> macVerifyCallable;
  private final UnaryCallable<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
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
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsTransportSettings =
        GrpcCallSettings.<ListKeyRingsRequest, ListKeyRingsResponse>newBuilder()
            .setMethodDescriptor(listKeyRingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCryptoKeysRequest, ListCryptoKeysResponse>
        listCryptoKeysTransportSettings =
            GrpcCallSettings.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
        listCryptoKeyVersionsTransportSettings =
            GrpcCallSettings
                .<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeyVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListImportJobsRequest, ListImportJobsResponse>
        listImportJobsTransportSettings =
            GrpcCallSettings.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
                .setMethodDescriptor(listImportJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetKeyRingRequest, KeyRing> getKeyRingTransportSettings =
        GrpcCallSettings.<GetKeyRingRequest, KeyRing>newBuilder()
            .setMethodDescriptor(getKeyRingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCryptoKeyRequest, CryptoKey> getCryptoKeyTransportSettings =
        GrpcCallSettings.<GetCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(getCryptoKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCryptoKeyVersionRequest, CryptoKeyVersion>
        getCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<GetCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(getCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetPublicKeyRequest, PublicKey> getPublicKeyTransportSettings =
        GrpcCallSettings.<GetPublicKeyRequest, PublicKey>newBuilder()
            .setMethodDescriptor(getPublicKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetImportJobRequest, ImportJob> getImportJobTransportSettings =
        GrpcCallSettings.<GetImportJobRequest, ImportJob>newBuilder()
            .setMethodDescriptor(getImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateKeyRingRequest, KeyRing> createKeyRingTransportSettings =
        GrpcCallSettings.<CreateKeyRingRequest, KeyRing>newBuilder()
            .setMethodDescriptor(createKeyRingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyTransportSettings =
        GrpcCallSettings.<CreateCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(createCryptoKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
        createCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<CreateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(createCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
        importCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<ImportCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(importCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateImportJobRequest, ImportJob> createImportJobTransportSettings =
        GrpcCallSettings.<CreateImportJobRequest, ImportJob>newBuilder()
            .setMethodDescriptor(createImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyTransportSettings =
        GrpcCallSettings.<UpdateCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(updateCryptoKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("crypto_key.name", String.valueOf(request.getCryptoKey().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
        updateCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(updateCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "crypto_key_version.name",
                          String.valueOf(request.getCryptoKeyVersion().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
        updateCryptoKeyPrimaryVersionTransportSettings =
            GrpcCallSettings.<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>newBuilder()
                .setMethodDescriptor(updateCryptoKeyPrimaryVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
        destroyCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(destroyCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
        restoreCryptoKeyVersionTransportSettings =
            GrpcCallSettings.<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(restoreCryptoKeyVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<EncryptRequest, EncryptResponse> encryptTransportSettings =
        GrpcCallSettings.<EncryptRequest, EncryptResponse>newBuilder()
            .setMethodDescriptor(encryptMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DecryptRequest, DecryptResponse> decryptTransportSettings =
        GrpcCallSettings.<DecryptRequest, DecryptResponse>newBuilder()
            .setMethodDescriptor(decryptMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AsymmetricSignRequest, AsymmetricSignResponse>
        asymmetricSignTransportSettings =
            GrpcCallSettings.<AsymmetricSignRequest, AsymmetricSignResponse>newBuilder()
                .setMethodDescriptor(asymmetricSignMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
        asymmetricDecryptTransportSettings =
            GrpcCallSettings.<AsymmetricDecryptRequest, AsymmetricDecryptResponse>newBuilder()
                .setMethodDescriptor(asymmetricDecryptMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<MacSignRequest, MacSignResponse> macSignTransportSettings =
        GrpcCallSettings.<MacSignRequest, MacSignResponse>newBuilder()
            .setMethodDescriptor(macSignMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<MacVerifyRequest, MacVerifyResponse> macVerifyTransportSettings =
        GrpcCallSettings.<MacVerifyRequest, MacVerifyResponse>newBuilder()
            .setMethodDescriptor(macVerifyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
        generateRandomBytesTransportSettings =
            GrpcCallSettings.<GenerateRandomBytesRequest, GenerateRandomBytesResponse>newBuilder()
                .setMethodDescriptor(generateRandomBytesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("location", String.valueOf(request.getLocation()));
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
    this.listImportJobsCallable =
        callableFactory.createUnaryCallable(
            listImportJobsTransportSettings, settings.listImportJobsSettings(), clientContext);
    this.listImportJobsPagedCallable =
        callableFactory.createPagedCallable(
            listImportJobsTransportSettings, settings.listImportJobsSettings(), clientContext);
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
    this.getPublicKeyCallable =
        callableFactory.createUnaryCallable(
            getPublicKeyTransportSettings, settings.getPublicKeySettings(), clientContext);
    this.getImportJobCallable =
        callableFactory.createUnaryCallable(
            getImportJobTransportSettings, settings.getImportJobSettings(), clientContext);
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
    this.importCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            importCryptoKeyVersionTransportSettings,
            settings.importCryptoKeyVersionSettings(),
            clientContext);
    this.createImportJobCallable =
        callableFactory.createUnaryCallable(
            createImportJobTransportSettings, settings.createImportJobSettings(), clientContext);
    this.updateCryptoKeyCallable =
        callableFactory.createUnaryCallable(
            updateCryptoKeyTransportSettings, settings.updateCryptoKeySettings(), clientContext);
    this.updateCryptoKeyVersionCallable =
        callableFactory.createUnaryCallable(
            updateCryptoKeyVersionTransportSettings,
            settings.updateCryptoKeyVersionSettings(),
            clientContext);
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
    this.encryptCallable =
        callableFactory.createUnaryCallable(
            encryptTransportSettings, settings.encryptSettings(), clientContext);
    this.decryptCallable =
        callableFactory.createUnaryCallable(
            decryptTransportSettings, settings.decryptSettings(), clientContext);
    this.asymmetricSignCallable =
        callableFactory.createUnaryCallable(
            asymmetricSignTransportSettings, settings.asymmetricSignSettings(), clientContext);
    this.asymmetricDecryptCallable =
        callableFactory.createUnaryCallable(
            asymmetricDecryptTransportSettings,
            settings.asymmetricDecryptSettings(),
            clientContext);
    this.macSignCallable =
        callableFactory.createUnaryCallable(
            macSignTransportSettings, settings.macSignSettings(), clientContext);
    this.macVerifyCallable =
        callableFactory.createUnaryCallable(
            macVerifyTransportSettings, settings.macVerifySettings(), clientContext);
    this.generateRandomBytesCallable =
        callableFactory.createUnaryCallable(
            generateRandomBytesTransportSettings,
            settings.generateRandomBytesSettings(),
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
  public UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsCallable() {
    return listKeyRingsCallable;
  }

  @Override
  public UnaryCallable<ListKeyRingsRequest, ListKeyRingsPagedResponse> listKeyRingsPagedCallable() {
    return listKeyRingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable() {
    return listCryptoKeysCallable;
  }

  @Override
  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    return listCryptoKeysPagedCallable;
  }

  @Override
  public UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsCallable() {
    return listCryptoKeyVersionsCallable;
  }

  @Override
  public UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsPagedCallable() {
    return listCryptoKeyVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> listImportJobsCallable() {
    return listImportJobsCallable;
  }

  @Override
  public UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable() {
    return listImportJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable() {
    return getKeyRingCallable;
  }

  @Override
  public UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable() {
    return getCryptoKeyCallable;
  }

  @Override
  public UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion> getCryptoKeyVersionCallable() {
    return getCryptoKeyVersionCallable;
  }

  @Override
  public UnaryCallable<GetPublicKeyRequest, PublicKey> getPublicKeyCallable() {
    return getPublicKeyCallable;
  }

  @Override
  public UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable() {
    return getImportJobCallable;
  }

  @Override
  public UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable() {
    return createKeyRingCallable;
  }

  @Override
  public UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable() {
    return createCryptoKeyCallable;
  }

  @Override
  public UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable() {
    return createCryptoKeyVersionCallable;
  }

  @Override
  public UnaryCallable<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionCallable() {
    return importCryptoKeyVersionCallable;
  }

  @Override
  public UnaryCallable<CreateImportJobRequest, ImportJob> createImportJobCallable() {
    return createImportJobCallable;
  }

  @Override
  public UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable() {
    return updateCryptoKeyCallable;
  }

  @Override
  public UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable() {
    return updateCryptoKeyVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable() {
    return updateCryptoKeyPrimaryVersionCallable;
  }

  @Override
  public UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable() {
    return destroyCryptoKeyVersionCallable;
  }

  @Override
  public UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable() {
    return restoreCryptoKeyVersionCallable;
  }

  @Override
  public UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable() {
    return encryptCallable;
  }

  @Override
  public UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable() {
    return decryptCallable;
  }

  @Override
  public UnaryCallable<AsymmetricSignRequest, AsymmetricSignResponse> asymmetricSignCallable() {
    return asymmetricSignCallable;
  }

  @Override
  public UnaryCallable<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptCallable() {
    return asymmetricDecryptCallable;
  }

  @Override
  public UnaryCallable<MacSignRequest, MacSignResponse> macSignCallable() {
    return macSignCallable;
  }

  @Override
  public UnaryCallable<MacVerifyRequest, MacVerifyResponse> macVerifyCallable() {
    return macVerifyCallable;
  }

  @Override
  public UnaryCallable<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesCallable() {
    return generateRandomBytesCallable;
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
