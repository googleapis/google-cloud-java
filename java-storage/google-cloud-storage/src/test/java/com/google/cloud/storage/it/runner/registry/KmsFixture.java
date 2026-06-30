/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.it.runner.registry;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.kms.v1.CreateCryptoKeyRequest;
import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.cloud.kms.v1.LocationName;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import io.grpc.StatusRuntimeException;
import java.io.IOException;

public class KmsFixture implements ManagedLifecycle {

  private final Storage storage;
  private final String keyRingLocation;
  private final String keyRingName;
  private final String key1Name;
  private final String key2Name;

  private KeyRing keyRing;
  private CryptoKey key1;
  private CryptoKey key2;

  private KmsFixture(
      Storage storage,
      String keyRingLocation,
      String keyRingName,
      String key1Name,
      String key2Name) {
    this.storage = storage;
    this.keyRingLocation = keyRingLocation;
    this.keyRingName = keyRingName;
    this.key1Name = key1Name;
    this.key2Name = key2Name;
  }

  public String getKeyRingLocation() {
    return keyRingLocation;
  }

  public KeyRing getKeyRing() {
    return keyRing;
  }

  public CryptoKey getKey1() {
    return key1;
  }

  public CryptoKey getKey2() {
    return key2;
  }

  @Override
  public Object get() {
    return this;
  }

  @Override
  public void start() {
    try (KeyManagementServiceClient kms = KeyManagementServiceClient.create()) {
      keyRing = resolveKeyRing(kms);
      Policy ignore = grantStorageServiceAccountRolesToKeyRing(kms);
      key1 = resolveKey(kms, key1Name);
      key2 = resolveKey(kms, key2Name);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void stop() {
    // KMS prevents key and ring deletion, https://cloud.google.com/kms/docs/faq#cannot_delete
  }

  static KmsFixture of(Storage s, Zone zone) {
    // KMS prevents key and ring deletion, https://cloud.google.com/kms/docs/faq#cannot_delete
    // therefore we instead prefer stable names to not blow out the number of keys and rings
    // in a project.
    return new KmsFixture(
        s, zone.getRegion(), "gcs_test_kms_key_ring", "gcs_kms_key_one", "gcs_kms_key_two");
  }

  private KeyRing resolveKeyRing(KeyManagementServiceClient kms) throws StatusRuntimeException {
    String projectId = storage.getOptions().getProjectId();
    KeyRingName ringName = KeyRingName.of(projectId, keyRingLocation, keyRingName);
    try {
      return kms.getKeyRing(ringName.toString());
    } catch (NotFoundException ex) {
      CreateKeyRingRequest req =
          CreateKeyRingRequest.newBuilder()
              .setParent(LocationName.of(projectId, keyRingLocation).toString())
              .setKeyRingId(keyRingName)
              .setKeyRing(KeyRing.newBuilder().build())
              .build();
      System.out.println("req = " + req);
      return kms.createKeyRing(req);
    }
  }

  private Policy grantStorageServiceAccountRolesToKeyRing(KeyManagementServiceClient kms) {
    String projectId = storage.getOptions().getProjectId();
    ServiceAccount serviceAccount = storage.getServiceAccount(projectId);
    Binding binding =
        Binding.newBuilder()
            .setRole("roles/cloudkms.cryptoKeyEncrypterDecrypter")
            .addMembers("serviceAccount:" + serviceAccount.getEmail())
            .build();
    SetIamPolicyRequest setIamPolicyRequest =
        SetIamPolicyRequest.newBuilder()
            .setResource(keyRing.getName())
            .setPolicy(Policy.newBuilder().addBindings(binding).build())
            .build();

    return kms.setIamPolicy(setIamPolicyRequest);
  }

  private CryptoKey resolveKey(KeyManagementServiceClient kms, String keyName) {
    CryptoKeyName cryptoKeyName = cryptoKeyNameOnRing(keyRing, keyName);
    try {
      return kms.getCryptoKey(cryptoKeyName);
    } catch (NotFoundException ex) {
      CreateCryptoKeyRequest req =
          CreateCryptoKeyRequest.newBuilder()
              .setParent(keyRing.getName())
              .setCryptoKeyId(keyName)
              .setCryptoKey(
                  CryptoKey.newBuilder()
                      .setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
                      .setVersionTemplate(
                          CryptoKeyVersionTemplate.newBuilder()
                              .setAlgorithm(CryptoKeyVersionAlgorithm.GOOGLE_SYMMETRIC_ENCRYPTION)))
              .build();
      return kms.createCryptoKey(req);
    }
  }

  private static CryptoKeyName cryptoKeyNameOnRing(KeyRing keyRing, String keyName) {
    KeyRingName krn = KeyRingName.parse(keyRing.getName());
    return CryptoKeyName.of(krn.getProject(), krn.getLocation(), krn.getKeyRing(), keyName);
  }
}
