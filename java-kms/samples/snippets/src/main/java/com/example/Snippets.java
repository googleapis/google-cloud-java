/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState;
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.cloud.kms.v1.LocationName;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Snippets {

  // [START kms_create_keyring]

  /**
   * Creates a new key ring with the given id.
   */
  public static KeyRing createKeyRing(String projectId, String locationId, String keyRingId)
      throws IOException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the location associated with the KeyRing.
      String parent = LocationName.format(projectId, locationId);

      // Create the KeyRing for your project.
      KeyRing keyRing = client.createKeyRing(parent, keyRingId, KeyRing.newBuilder().build());

      return keyRing;
    }
  }
  // [END kms_create_keyring]

  // [START kms_create_cryptokey]

  /**
   * Creates a new crypto key with the given id.
   */
  public static CryptoKey createCryptoKey(String projectId, String locationId, String keyRingId,
      String cryptoKeyId)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // The resource name of the location associated with the KeyRing.
      String parent = KeyRingName.format(projectId, locationId, keyRingId);

      // This will allow the API access to the key for encryption and decryption.
      CryptoKey cryptoKey = CryptoKey.newBuilder()
          .setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
          .build();

      // Create the CryptoKey for your project.
      CryptoKey createdKey = client.createCryptoKey(parent, cryptoKeyId, cryptoKey);

      return createdKey;
    }
  }
  // [END kms_create_cryptokey]

  // [START kms_create_cryptokey_version]

  /**
   * Creates a new crypto key version for the given id.
   */
  public static CryptoKeyVersion createCryptoKeyVersion(
      String projectId, String locationId, String keyRingId, String cryptoKeyId)
      throws IOException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey
      String cryptoKey = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      CryptoKeyVersion version = CryptoKeyVersion.newBuilder().build();

      CryptoKeyVersion newVersion = client.createCryptoKeyVersion(cryptoKey, version);
      return newVersion;
    }
  }
  // [END kms_create_cryptokey_version]

  // [START kms_disable_cryptokey_version]

  /**
   * Disables the given version of the crypto key.
   */
  public static CryptoKeyVersion disableCryptoKeyVersion(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, String version)
      throws IOException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String versionName = CryptoKeyVersionName.format(
          projectId, locationId, keyRingId, cryptoKeyId, version);

      // Retrieve the current state
      CryptoKeyVersion current = client.getCryptoKeyVersion(versionName);

      // Build a copy that updates the state to disabled
      CryptoKeyVersion updated = CryptoKeyVersion.newBuilder()
          .setName(current.getName())
          .setState(CryptoKeyVersionState.DISABLED)
          .build();

      // Create a FieldMask that only allows 'state' to be updated
      FieldMask fieldMask = FieldMaskUtil.fromString(CryptoKeyVersion.class, "state");

      // Update the version state
      CryptoKeyVersion response = client.updateCryptoKeyVersion(updated, fieldMask);

      return response;
    }
  }
  // [END kms_disable_cryptokey_version]

  // [START kms_enable_cryptokey_version]
  /**
   * Enables the given version of the crypto key.
   */
  public static CryptoKeyVersion enableCryptoKeyVersion(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, String version)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String versionName = CryptoKeyVersionName.format(
          projectId, locationId, keyRingId, cryptoKeyId, version);

      // Retrieve the current state
      CryptoKeyVersion current = client.getCryptoKeyVersion(versionName);

      // Build a copy that updates the state to enabled
      CryptoKeyVersion updated = CryptoKeyVersion.newBuilder()
          .setName(current.getName())
          .setState(CryptoKeyVersionState.ENABLED)
          .build();

      // Create a FieldMask that only allows 'state' to be updated
      FieldMask fieldMask = FieldMaskUtil.fromString(CryptoKeyVersion.class, "state");

      // Update the version state
      CryptoKeyVersion response = client.updateCryptoKeyVersion(updated, fieldMask);

      return response;
    }
  }
  // [END kms_enable_cryptokey_version]

  // [START kms_destroy_cryptokey_version]

  /**
   * Marks the given version of a crypto key to be destroyed at a scheduled future point.
   */
  public static CryptoKeyVersion destroyCryptoKeyVersion(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, String version)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String versionName = CryptoKeyVersionName.format(
          projectId, locationId, keyRingId, cryptoKeyId, version);

      // Destroy the cryptoKey version
      CryptoKeyVersion destroyed = client.destroyCryptoKeyVersion(versionName);

      return destroyed;
    }
  }
  // [END kms_destroy_cryptokey_version]

  // [START kms_restore_cryptokey_version]

  /**
   * Restores the given version of a crypto key that is currently scheduled for destruction.
   */
  public static CryptoKeyVersion restoreCryptoKeyVersion(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, String version)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String versionName = CryptoKeyVersionName.format(
          projectId, locationId, keyRingId, cryptoKeyId, version);

      CryptoKeyVersion restored = client.restoreCryptoKeyVersion(versionName);

      return restored;
    }
  }
  // [END kms_restore_cryptokey_version]

  // [START kms_get_cryptokey_policy]

  /**
   * Retrieves the IAM policy for the given crypto key.
   */
  public static Policy getCryptoKeyPolicy(
      String projectId, String locationId, String keyRingId, String cryptoKeyId)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String keyName = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Get the current IAM policy and add the new account to it.
      Policy iamPolicy = client.getIamPolicy(keyName);

      return iamPolicy;
    }
  }
  // [END kms_get_cryptokey_policy]

  // [START kms_get_keyring_policy]

  /**
   * Retrieves the IAM policy for the given crypto key.
   */
  public static Policy getKeyRingPolicy(String projectId, String locationId, String keyRingId)
      throws IOException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String keyRingName = KeyRingName.format(projectId, locationId, keyRingId);

      // Get the current IAM policy and add the new account to it.
      Policy iamPolicy = client.getIamPolicy(keyRingName);

      return iamPolicy;
    }
  }
  // [END kms_get_keyring_policy]

  // [START kms_add_member_to_cryptokey_policy]

  /**
   * Adds the given member to the given key, with the given role.
   *
   * @param projectId The id of the project.
   * @param locationId The location id of the key.
   * @param keyRingId The id of the keyring.
   * @param cryptoKeyId The id of the crypto key.
   * @param member The member to add. Must be in the proper format, eg:
   *
   * allUsers user:$userEmail serviceAccount:$serviceAccountEmail
   *
   * See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding for more details.
   * @param role Must be in one of the following formats: roles/[role]
   * organizations/[organizationId]/roles/[role] projects/[projectId]/roles/[role]
   *
   * See https://g.co/cloud/iam/docs/understanding-roles for available values for [role].
   */
  public static Policy addMemberToCryptoKeyPolicy(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, String member,
      String role)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String keyName = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Get the current IAM policy
      Policy iamPolicy = client.getIamPolicy(keyName);

      // Create a new binding with the selected role and member
      Binding newBinding = Binding.newBuilder()
          .setRole(role)
          .addMembers(member)
          .build();

      // Create a new IAM policy containing the existing settings plus the new binding.
      Policy newPolicy = Policy.newBuilder()
          .mergeFrom(iamPolicy)
          .addBindings(newBinding)
          .build();

      // Set the new IAM Policy.
      Policy policyResult = client.setIamPolicy(keyName, newPolicy);

      return policyResult;
    }
  }
  // [END kms_add_member_to_cryptokey_policy]

  // [START kms_add_member_to_keyring_policy]

  /**
   * Adds the given member to the given keyring, with the given role.
   *
   * @param projectId The id of the project.
   * @param locationId The location id of the key.
   * @param keyRingId The id of the keyring.
   * @param member The member to add. Must be in the proper format, eg:
   *
   * allUsers user:$userEmail serviceAccount:$serviceAccountEmail
   *
   * See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding for more details.
   * @param role Must be in one of the following formats: roles/[role]
   * organizations/[organizationId]/roles/[role] projects/[projectId]/roles/[role]
   *
   * See https://g.co/cloud/iam/docs/understanding-roles for available values for [role].
   */
  public static Policy addMemberToKeyRingPolicy(
      String projectId, String locationId, String keyRingId, String member, String role)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String keyRingName = KeyRingName.format(projectId, locationId, keyRingId);

      // Get the current IAM policy
      Policy iamPolicy = client.getIamPolicy(keyRingName);

      // Create a new binding with the selected role and member
      Binding newBinding = Binding.newBuilder()
          .setRole(role)
          .addMembers(member)
          .build();

      // Create a new IAM policy containing the existing settings plus the new binding.
      Policy newPolicy = Policy.newBuilder()
          .mergeFrom(iamPolicy)
          .addBindings(newBinding)
          .build();

      // Set the new IAM Policy.
      Policy policyResult = client.setIamPolicy(keyRingName, newPolicy);

      return policyResult;
    }
  }
  // [END kms_add_member_to_keyring_policy]

  // [START kms_remove_member_from_cryptokey_policy]

  /**
   * Removes the given member from the given policy.
   */
  public static Policy removeMemberFromCryptoKeyPolicy(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, String member,
      String role)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String keyName = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Get the current IAM policy
      Policy iamPolicy = client.getIamPolicy(keyName);

      // Create a bindings list that filters out the provided member
      List<Binding> newBindings = new ArrayList<>();
      for (Binding binding : iamPolicy.getBindingsList()) {
        if (!binding.getRole().equals(role)) {
          newBindings.add(binding);
          continue;
        }

        Binding.Builder builder = Binding.newBuilder().setRole(binding.getRole());
        for (String bindingMember : binding.getMembersList()) {
          if (!member.equals(bindingMember)) {
            builder.addMembers(bindingMember);
          }
        }
        newBindings.add(builder.build());
      }

      Policy newIamPolicy = Policy.newBuilder()
          .addAllBindings(newBindings)
          .build();

      // Set the new IAM Policy.
      Policy result = client.setIamPolicy(keyName, newIamPolicy);

      return result;
    }
  }
  // [END kms_remove_member_from_cryptokey_policy]

  // [START kms_remove_member_from_keyring_policy]

  /**
   * Removes the given member from the given policy.
   */
  public static Policy removeMemberFromKeyRingPolicy(
      String projectId, String locationId, String keyRingId, String member, String role)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey version
      String keyRingName = KeyRingName.format(projectId, locationId, keyRingId);

      // Get the current IAM policy
      Policy iamPolicy = client.getIamPolicy(keyRingName);

      // Create a bindings list that filters out the provided member
      List<Binding> newBindings = new ArrayList<>();
      for (Binding binding : iamPolicy.getBindingsList()) {
        if (!binding.getRole().equals(role)) {
          newBindings.add(binding);
        } else {
          Binding.Builder builder = Binding.newBuilder().setRole(binding.getRole());
          for (String bindingMember : binding.getMembersList()) {
            if (!member.equals(bindingMember)) {
              builder.addMembers(bindingMember);
            }
          }
          newBindings.add(builder.build());
        }
      }

      Policy newIamPolicy = Policy.newBuilder()
          .addAllBindings(newBindings)
          .build();

      // Set the new IAM Policy.
      Policy result = client.setIamPolicy(keyRingName, newIamPolicy);

      return result;
    }
  }
  // [END kms_remove_member_from_keyring_policy]

  /**
   * Lists all the key rings in the given project.
   */
  public static List<KeyRing> listKeyRings(String projectId, String locationId) throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the location to search.
      String parent = LocationName.format(projectId, locationId);

      // Retrieve a paginated list of KeyRings
      ListKeyRingsPagedResponse response = client.listKeyRings(parent);

      ArrayList<KeyRing> results = new ArrayList<>();
      // Iterate over all KeyRings (subsequent pages are retrieved automatically)
      for (KeyRing keyRing : response.iterateAll()) {
        results.add(keyRing);
      }
      return results;
    }
  }

  /**
   * Lists all crypto keys in the given key ring.
   */
  public static List<CryptoKey> listCryptoKeys(
      String projectId, String locationId, String keyRingId)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the KeyRing to search.
      String parent = KeyRingName.format(projectId, locationId, keyRingId);

      // Retrieve a paginated list of CryptoKeys
      ListCryptoKeysPagedResponse response = client.listCryptoKeys(parent);

      ArrayList<CryptoKey> keys = new ArrayList<>();
      // Iterate over all CryptoKeys (subsequent pages are retrieved automatically)
      for (CryptoKey cryptoKey : response.iterateAll()) {
        keys.add(cryptoKey);
      }
      return keys;
    }
  }

  /**
   * Lists all the versions for the given crypto key.
   */
  public static List<CryptoKeyVersion> listCryptoKeyVersions(
      String projectId, String locationId, String keyRingId, String cryptoKeyId)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the CryptoKey to search.
      String parent = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Retrieve a paginated list of CryptoKeyVersions
      ListCryptoKeyVersionsPagedResponse response = client.listCryptoKeyVersions(parent);

      ArrayList<CryptoKeyVersion> results = new ArrayList<>();

      // Iterate over all CryptoKeyVersions (subsequent pages are retrieved automatically)
      for (CryptoKeyVersion version : response.iterateAll()) {
        results.add(version);
      }

      return results;
    }
  }

  /**
   * Sets a version as the primary version for a crypto key.
   */
  public static CryptoKey setPrimaryVersion(String projectId, String locationId, String keyRingId,
      String cryptoKeyId, String versionId) throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the CryptoKey to update.
      String resourceName = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Update the primary CryptoKey version
      CryptoKey key = client.updateCryptoKeyPrimaryVersion(resourceName, versionId);
      return key;
    }
  }


  public static void main(String[] args) throws IOException, CmdLineException {
    SnippetCommands commands = new SnippetCommands();
    CmdLineParser parser = new CmdLineParser(commands);

    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      System.out.println(e);
      System.out.println();
      e.getParser().printUsage(System.err);
      System.exit(1);
    }
    commands.command.run();
  }
}
