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
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the KeyManagementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonKeyManagementServiceStub extends KeyManagementServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListKeyRingsRequest, ListKeyRingsResponse>
      listKeyRingsMethodDescriptor =
          ApiMethodDescriptor.<ListKeyRingsRequest, ListKeyRingsResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListKeyRings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListKeyRingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/keyRings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListKeyRingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListKeyRingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListKeyRingsResponse>newBuilder()
                      .setDefaultInstance(ListKeyRingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCryptoKeysRequest, ListCryptoKeysResponse>
      listCryptoKeysMethodDescriptor =
          ApiMethodDescriptor.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListCryptoKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCryptoKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*}/cryptoKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCryptoKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCryptoKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "versionView", request.getVersionView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCryptoKeysResponse>newBuilder()
                      .setDefaultInstance(ListCryptoKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListCryptoKeyVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCryptoKeyVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*/cryptoKeys/*}/cryptoKeyVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCryptoKeyVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCryptoKeyVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCryptoKeyVersionsResponse>newBuilder()
                      .setDefaultInstance(ListCryptoKeyVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListImportJobsRequest, ListImportJobsResponse>
      listImportJobsMethodDescriptor =
          ApiMethodDescriptor.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ListImportJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListImportJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*}/importJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListImportJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListImportJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListImportJobsResponse>newBuilder()
                      .setDefaultInstance(ListImportJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetKeyRingRequest, KeyRing> getKeyRingMethodDescriptor =
      ApiMethodDescriptor.<GetKeyRingRequest, KeyRing>newBuilder()
          .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetKeyRing")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetKeyRingRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/keyRings/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetKeyRingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetKeyRingRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<KeyRing>newBuilder()
                  .setDefaultInstance(KeyRing.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetCryptoKeyRequest, CryptoKey>
      getCryptoKeyMethodDescriptor =
          ApiMethodDescriptor.<GetCryptoKeyRequest, CryptoKey>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetCryptoKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCryptoKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCryptoKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCryptoKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKey>newBuilder()
                      .setDefaultInstance(CryptoKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionMethodDescriptor =
          ApiMethodDescriptor.<GetCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetCryptoKeyVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCryptoKeyVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKeyVersion>newBuilder()
                      .setDefaultInstance(CryptoKeyVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPublicKeyRequest, PublicKey>
      getPublicKeyMethodDescriptor =
          ApiMethodDescriptor.<GetPublicKeyRequest, PublicKey>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetPublicKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}/publicKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicKey>newBuilder()
                      .setDefaultInstance(PublicKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetImportJobRequest, ImportJob>
      getImportJobMethodDescriptor =
          ApiMethodDescriptor.<GetImportJobRequest, ImportJob>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GetImportJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/importJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImportJob>newBuilder()
                      .setDefaultInstance(ImportJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateKeyRingRequest, KeyRing>
      createKeyRingMethodDescriptor =
          ApiMethodDescriptor.<CreateKeyRingRequest, KeyRing>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateKeyRing")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateKeyRingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/keyRings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKeyRingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKeyRingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "keyRingId", request.getKeyRingId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("keyRing", request.getKeyRing(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KeyRing>newBuilder()
                      .setDefaultInstance(KeyRing.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCryptoKeyRequest, CryptoKey>
      createCryptoKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateCryptoKeyRequest, CryptoKey>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateCryptoKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCryptoKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*}/cryptoKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCryptoKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCryptoKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cryptoKeyId", request.getCryptoKeyId());
                            serializer.putQueryParam(
                                fields,
                                "skipInitialVersionCreation",
                                request.getSkipInitialVersionCreation());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cryptoKey", request.getCryptoKey(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKey>newBuilder()
                      .setDefaultInstance(CryptoKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionMethodDescriptor =
          ApiMethodDescriptor.<CreateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateCryptoKeyVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCryptoKeyVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*/cryptoKeys/*}/cryptoKeyVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cryptoKeyVersion", request.getCryptoKeyVersion(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKeyVersion>newBuilder()
                      .setDefaultInstance(CryptoKeyVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionMethodDescriptor =
          ApiMethodDescriptor.<ImportCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/ImportCryptoKeyVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportCryptoKeyVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*/cryptoKeys/*}/cryptoKeyVersions:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKeyVersion>newBuilder()
                      .setDefaultInstance(CryptoKeyVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateImportJobRequest, ImportJob>
      createImportJobMethodDescriptor =
          ApiMethodDescriptor.<CreateImportJobRequest, ImportJob>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/CreateImportJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/keyRings/*}/importJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "importJobId", request.getImportJobId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("importJob", request.getImportJob(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImportJob>newBuilder()
                      .setDefaultInstance(ImportJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCryptoKeyRequest, CryptoKey>
      updateCryptoKeyMethodDescriptor =
          ApiMethodDescriptor.<UpdateCryptoKeyRequest, CryptoKey>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/UpdateCryptoKey")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCryptoKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{cryptoKey.name=projects/*/locations/*/keyRings/*/cryptoKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCryptoKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "cryptoKey.name", request.getCryptoKey().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCryptoKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cryptoKey", request.getCryptoKey(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKey>newBuilder()
                      .setDefaultInstance(CryptoKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionMethodDescriptor =
          ApiMethodDescriptor.<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/UpdateCryptoKeyVersion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCryptoKeyVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{cryptoKeyVersion.name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "cryptoKeyVersion.name",
                                request.getCryptoKeyVersion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cryptoKeyVersion", request.getCryptoKeyVersion(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKeyVersion>newBuilder()
                      .setDefaultInstance(CryptoKeyVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionMethodDescriptor =
          ApiMethodDescriptor.<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.KeyManagementService/UpdateCryptoKeyPrimaryVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCryptoKeyPrimaryVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*}:updatePrimaryVersion",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCryptoKeyPrimaryVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCryptoKeyPrimaryVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKey>newBuilder()
                      .setDefaultInstance(CryptoKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionMethodDescriptor =
          ApiMethodDescriptor.<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/DestroyCryptoKeyVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DestroyCryptoKeyVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}:destroy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DestroyCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DestroyCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKeyVersion>newBuilder()
                      .setDefaultInstance(CryptoKeyVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionMethodDescriptor =
          ApiMethodDescriptor.<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/RestoreCryptoKeyVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreCryptoKeyVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreCryptoKeyVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CryptoKeyVersion>newBuilder()
                      .setDefaultInstance(CryptoKeyVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EncryptRequest, EncryptResponse>
      encryptMethodDescriptor =
          ApiMethodDescriptor.<EncryptRequest, EncryptResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/Encrypt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EncryptRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/**}:encrypt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EncryptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EncryptRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EncryptResponse>newBuilder()
                      .setDefaultInstance(EncryptResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DecryptRequest, DecryptResponse>
      decryptMethodDescriptor =
          ApiMethodDescriptor.<DecryptRequest, DecryptResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/Decrypt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DecryptRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*}:decrypt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DecryptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DecryptRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DecryptResponse>newBuilder()
                      .setDefaultInstance(DecryptResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AsymmetricSignRequest, AsymmetricSignResponse>
      asymmetricSignMethodDescriptor =
          ApiMethodDescriptor.<AsymmetricSignRequest, AsymmetricSignResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/AsymmetricSign")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AsymmetricSignRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}:asymmetricSign",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AsymmetricSignRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AsymmetricSignRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AsymmetricSignResponse>newBuilder()
                      .setDefaultInstance(AsymmetricSignResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptMethodDescriptor =
          ApiMethodDescriptor.<AsymmetricDecryptRequest, AsymmetricDecryptResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/AsymmetricDecrypt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AsymmetricDecryptRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}:asymmetricDecrypt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AsymmetricDecryptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AsymmetricDecryptRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AsymmetricDecryptResponse>newBuilder()
                      .setDefaultInstance(AsymmetricDecryptResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MacSignRequest, MacSignResponse>
      macSignMethodDescriptor =
          ApiMethodDescriptor.<MacSignRequest, MacSignResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/MacSign")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MacSignRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}:macSign",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MacSignRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MacSignRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MacSignResponse>newBuilder()
                      .setDefaultInstance(MacSignResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MacVerifyRequest, MacVerifyResponse>
      macVerifyMethodDescriptor =
          ApiMethodDescriptor.<MacVerifyRequest, MacVerifyResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/MacVerify")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MacVerifyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*}:macVerify",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MacVerifyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MacVerifyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MacVerifyResponse>newBuilder()
                      .setDefaultInstance(MacVerifyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesMethodDescriptor =
          ApiMethodDescriptor.<GenerateRandomBytesRequest, GenerateRandomBytesResponse>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.KeyManagementService/GenerateRandomBytes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateRandomBytesRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}:generateRandomBytes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateRandomBytesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateRandomBytesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearLocation().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateRandomBytesResponse>newBuilder()
                      .setDefaultInstance(GenerateRandomBytesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/keyRings/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/keyRings/*/cryptoKeys/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/keyRings/*/importJobs/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/ekmConnections/*}:setIamPolicy")
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
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/keyRings/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/keyRings/*/cryptoKeys/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/keyRings/*/importJobs/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/ekmConnections/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/keyRings/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/keyRings/*/cryptoKeys/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/keyRings/*/importJobs/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/ekmConnections/*}:testIamPermissions")
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
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonKeyManagementServiceStub create(
      KeyManagementServiceStubSettings settings) throws IOException {
    return new HttpJsonKeyManagementServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonKeyManagementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonKeyManagementServiceStub(
        KeyManagementServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonKeyManagementServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonKeyManagementServiceStub(
        KeyManagementServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonKeyManagementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonKeyManagementServiceStub(
      KeyManagementServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonKeyManagementServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonKeyManagementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonKeyManagementServiceStub(
      KeyManagementServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsTransportSettings =
        HttpJsonCallSettings.<ListKeyRingsRequest, ListKeyRingsResponse>newBuilder()
            .setMethodDescriptor(listKeyRingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCryptoKeysRequest, ListCryptoKeysResponse>
        listCryptoKeysTransportSettings =
            HttpJsonCallSettings.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
        listCryptoKeyVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeyVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListImportJobsRequest, ListImportJobsResponse>
        listImportJobsTransportSettings =
            HttpJsonCallSettings.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
                .setMethodDescriptor(listImportJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetKeyRingRequest, KeyRing> getKeyRingTransportSettings =
        HttpJsonCallSettings.<GetKeyRingRequest, KeyRing>newBuilder()
            .setMethodDescriptor(getKeyRingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCryptoKeyRequest, CryptoKey> getCryptoKeyTransportSettings =
        HttpJsonCallSettings.<GetCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(getCryptoKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCryptoKeyVersionRequest, CryptoKeyVersion>
        getCryptoKeyVersionTransportSettings =
            HttpJsonCallSettings.<GetCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(getCryptoKeyVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPublicKeyRequest, PublicKey> getPublicKeyTransportSettings =
        HttpJsonCallSettings.<GetPublicKeyRequest, PublicKey>newBuilder()
            .setMethodDescriptor(getPublicKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetImportJobRequest, ImportJob> getImportJobTransportSettings =
        HttpJsonCallSettings.<GetImportJobRequest, ImportJob>newBuilder()
            .setMethodDescriptor(getImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateKeyRingRequest, KeyRing> createKeyRingTransportSettings =
        HttpJsonCallSettings.<CreateKeyRingRequest, KeyRing>newBuilder()
            .setMethodDescriptor(createKeyRingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyTransportSettings =
        HttpJsonCallSettings.<CreateCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(createCryptoKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
        createCryptoKeyVersionTransportSettings =
            HttpJsonCallSettings.<CreateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(createCryptoKeyVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
        importCryptoKeyVersionTransportSettings =
            HttpJsonCallSettings.<ImportCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(importCryptoKeyVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateImportJobRequest, ImportJob> createImportJobTransportSettings =
        HttpJsonCallSettings.<CreateImportJobRequest, ImportJob>newBuilder()
            .setMethodDescriptor(createImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyTransportSettings =
        HttpJsonCallSettings.<UpdateCryptoKeyRequest, CryptoKey>newBuilder()
            .setMethodDescriptor(updateCryptoKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
        updateCryptoKeyVersionTransportSettings =
            HttpJsonCallSettings.<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(updateCryptoKeyVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
        updateCryptoKeyPrimaryVersionTransportSettings =
            HttpJsonCallSettings.<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>newBuilder()
                .setMethodDescriptor(updateCryptoKeyPrimaryVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
        destroyCryptoKeyVersionTransportSettings =
            HttpJsonCallSettings.<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(destroyCryptoKeyVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
        restoreCryptoKeyVersionTransportSettings =
            HttpJsonCallSettings.<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>newBuilder()
                .setMethodDescriptor(restoreCryptoKeyVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<EncryptRequest, EncryptResponse> encryptTransportSettings =
        HttpJsonCallSettings.<EncryptRequest, EncryptResponse>newBuilder()
            .setMethodDescriptor(encryptMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DecryptRequest, DecryptResponse> decryptTransportSettings =
        HttpJsonCallSettings.<DecryptRequest, DecryptResponse>newBuilder()
            .setMethodDescriptor(decryptMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AsymmetricSignRequest, AsymmetricSignResponse>
        asymmetricSignTransportSettings =
            HttpJsonCallSettings.<AsymmetricSignRequest, AsymmetricSignResponse>newBuilder()
                .setMethodDescriptor(asymmetricSignMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
        asymmetricDecryptTransportSettings =
            HttpJsonCallSettings.<AsymmetricDecryptRequest, AsymmetricDecryptResponse>newBuilder()
                .setMethodDescriptor(asymmetricDecryptMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<MacSignRequest, MacSignResponse> macSignTransportSettings =
        HttpJsonCallSettings.<MacSignRequest, MacSignResponse>newBuilder()
            .setMethodDescriptor(macSignMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<MacVerifyRequest, MacVerifyResponse> macVerifyTransportSettings =
        HttpJsonCallSettings.<MacVerifyRequest, MacVerifyResponse>newBuilder()
            .setMethodDescriptor(macVerifyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
        generateRandomBytesTransportSettings =
            HttpJsonCallSettings
                .<GenerateRandomBytesRequest, GenerateRandomBytesResponse>newBuilder()
                .setMethodDescriptor(generateRandomBytesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
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
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
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
    methodDescriptors.add(listKeyRingsMethodDescriptor);
    methodDescriptors.add(listCryptoKeysMethodDescriptor);
    methodDescriptors.add(listCryptoKeyVersionsMethodDescriptor);
    methodDescriptors.add(listImportJobsMethodDescriptor);
    methodDescriptors.add(getKeyRingMethodDescriptor);
    methodDescriptors.add(getCryptoKeyMethodDescriptor);
    methodDescriptors.add(getCryptoKeyVersionMethodDescriptor);
    methodDescriptors.add(getPublicKeyMethodDescriptor);
    methodDescriptors.add(getImportJobMethodDescriptor);
    methodDescriptors.add(createKeyRingMethodDescriptor);
    methodDescriptors.add(createCryptoKeyMethodDescriptor);
    methodDescriptors.add(createCryptoKeyVersionMethodDescriptor);
    methodDescriptors.add(importCryptoKeyVersionMethodDescriptor);
    methodDescriptors.add(createImportJobMethodDescriptor);
    methodDescriptors.add(updateCryptoKeyMethodDescriptor);
    methodDescriptors.add(updateCryptoKeyVersionMethodDescriptor);
    methodDescriptors.add(updateCryptoKeyPrimaryVersionMethodDescriptor);
    methodDescriptors.add(destroyCryptoKeyVersionMethodDescriptor);
    methodDescriptors.add(restoreCryptoKeyVersionMethodDescriptor);
    methodDescriptors.add(encryptMethodDescriptor);
    methodDescriptors.add(decryptMethodDescriptor);
    methodDescriptors.add(asymmetricSignMethodDescriptor);
    methodDescriptors.add(asymmetricDecryptMethodDescriptor);
    methodDescriptors.add(macSignMethodDescriptor);
    methodDescriptors.add(macVerifyMethodDescriptor);
    methodDescriptors.add(generateRandomBytesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
