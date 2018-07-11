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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Cloud Key Management Service (KMS) API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class KeyManagementServiceStub implements BackgroundResource {

  public UnaryCallable<ListKeyRingsRequest, ListKeyRingsPagedResponse> listKeyRingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listKeyRingsPagedCallable()");
  }

  public UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listKeyRingsCallable()");
  }

  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCryptoKeysPagedCallable()");
  }

  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listCryptoKeysCallable()");
  }

  public UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCryptoKeyVersionsPagedCallable()");
  }

  public UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCryptoKeyVersionsCallable()");
  }

  public UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable() {
    throw new UnsupportedOperationException("Not implemented: getKeyRingCallable()");
  }

  public UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getCryptoKeyCallable()");
  }

  public UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion> getCryptoKeyVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getCryptoKeyVersionCallable()");
  }

  public UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable() {
    throw new UnsupportedOperationException("Not implemented: createKeyRingCallable()");
  }

  public UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createCryptoKeyCallable()");
  }

  public UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createCryptoKeyVersionCallable()");
  }

  public UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCryptoKeyCallable()");
  }

  public UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCryptoKeyVersionCallable()");
  }

  public UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable() {
    throw new UnsupportedOperationException("Not implemented: encryptCallable()");
  }

  public UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable() {
    throw new UnsupportedOperationException("Not implemented: decryptCallable()");
  }

  public UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCryptoKeyPrimaryVersionCallable()");
  }

  public UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: destroyCryptoKeyVersionCallable()");
  }

  public UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreCryptoKeyVersionCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
