/*
 * Copyright (c) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudkms.v1.CloudKMS;
import com.google.api.services.cloudkms.v1.CloudKMSScopes;
import com.google.api.services.cloudkms.v1.model.Binding;
import com.google.api.services.cloudkms.v1.model.CryptoKey;
import com.google.api.services.cloudkms.v1.model.CryptoKeyVersion;
import com.google.api.services.cloudkms.v1.model.DestroyCryptoKeyVersionRequest;
import com.google.api.services.cloudkms.v1.model.KeyRing;
import com.google.api.services.cloudkms.v1.model.ListCryptoKeyVersionsResponse;
import com.google.api.services.cloudkms.v1.model.ListCryptoKeysResponse;
import com.google.api.services.cloudkms.v1.model.ListKeyRingsResponse;
import com.google.api.services.cloudkms.v1.model.Policy;
import com.google.api.services.cloudkms.v1.model.SetIamPolicyRequest;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Snippets {

  /**
   * Creates an authorized CloudKMS client service using Application Default Credentials.
   *
   * @return an authorized CloudKMS client
   * @throws IOException if there's an error getting the default credentials.
   */
  public static CloudKMS createAuthorizedClient() throws IOException {
    // Create the credential
    HttpTransport transport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();
    // Authorize the client using Application Default Credentials
    // @see https://g.co/dv/identity/protocols/application-default-credentials
    GoogleCredential credential = GoogleCredential.getApplicationDefault(transport, jsonFactory);

    // Depending on the environment that provides the default credentials (e.g. Compute Engine, App
    // Engine), the credentials may require us to specify the scopes we need explicitly.
    // Check for this case, and inject the scope if required.
    if (credential.createScopedRequired()) {
      credential = credential.createScoped(CloudKMSScopes.all());
    }

    return new CloudKMS.Builder(transport, jsonFactory, credential)
        .setApplicationName("CloudKMS snippets")
        .build();
  }

  // [START kms_create_keyring]
  /**
   * Creates a new key ring with the given id.
   */
  public static KeyRing createKeyRing(String projectId, String ringId) throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the location associated with the KeyRing.
    String parent = String.format("projects/%s/locations/%s", projectId, location);
    // Create the KeyRing for your project.
    KeyRing keyring = kms.projects().locations().keyRings()
        .create(parent, new KeyRing())
        .setKeyRingId(ringId)
        .execute();

    System.out.println(keyring);
    return keyring;
  }
  // [END kms_create_keyring]

  // [START kms_create_cryptokey]
  /**
   * Creates a new crypto key with the given id.
   */
  public static CryptoKey createCryptoKey(String projectId, String ringId, String keyId)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the location associated with the KeyRing.
    String parent = String.format(
        "projects/%s/locations/%s/keyRings/%s", projectId, location, ringId);

    // This will allow the API access to the key for encryption and decryption.
    String purpose = "ENCRYPT_DECRYPT";
    CryptoKey cryptoKey = new CryptoKey();
    cryptoKey.setPurpose(purpose);

    // Create the CryptoKey for your project.
    CryptoKey createdKey = kms.projects().locations().keyRings().cryptoKeys()
        .create(parent, cryptoKey)
        .setCryptoKeyId(keyId)
        .execute();

    System.out.println(createdKey);
    return createdKey;
  }
  // [END kms_create_cryptokey]

  // [START kms_create_cryptokey_version]
  /**
   * Creates a new crypto key version for the given id.
   */
  public static void createCryptoKeyVersion(
      String projectId, String ringId, String keyId) throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String cryptoKeys = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, location, ringId, keyId);

    CryptoKeyVersion version = new CryptoKeyVersion();

    CryptoKeyVersion newVersion = kms.projects().locations().keyRings().cryptoKeys()
        .cryptoKeyVersions()
        .create(cryptoKeys, version)
        .execute();

    System.out.println(newVersion);
  }
  // [END kms_create_cryptokey_version]

  // [START kms_disable_cryptokey_version]
  /**
   * Disables the given version of the crypto key.
   */
  public static CryptoKeyVersion disableCryptoKeyVersion(
      String projectId, String ringId, String keyId, String version)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey version
    String cryptoKeyVersion = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s",
        projectId, location, ringId, keyId, version);

    CryptoKeyVersion newVersionState = new CryptoKeyVersion()
        .setState("DISABLED");

    CryptoKeyVersion response = kms.projects().locations().keyRings().cryptoKeys()
        .cryptoKeyVersions()
        .patch(cryptoKeyVersion, newVersionState)
        .setUpdateMask("state")
        .execute();

    System.out.println(response);
    return response;
  }
  // [END kms_disable_cryptokey_version]

  // [START kms_destroy_cryptokey_version]
  /**
   * Marks the given version of a crypto key to be destroyed at a scheduled future point.
   */
  public static CryptoKeyVersion destroyCryptoKeyVersion(
      String projectId, String ringId, String keyId, String version)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey version
    String cryptoKeyVersion = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s",
        projectId, location, ringId, keyId, version);

    DestroyCryptoKeyVersionRequest destroyRequest = new DestroyCryptoKeyVersionRequest();

    CryptoKeyVersion destroyed = kms.projects().locations().keyRings().cryptoKeys()
        .cryptoKeyVersions()
        .destroy(cryptoKeyVersion, destroyRequest)
        .execute();

    System.out.println(destroyed);
    return destroyed;
  }
  // [END kms_destroy_cryptokey_version]

  // [START kms_get_cryptokey_policy]
  /**
   * Retrieves the IAM policy for the given crypto key.
   */
  public static Policy getCryptoKeyPolicy(String projectId, String ringId, String keyId)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String cryptoKey = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, location, ringId, keyId);

    // Get the current IAM policy and add the new account to it.
    Policy iamPolicy = kms.projects().locations().keyRings().cryptoKeys()
        .getIamPolicy(cryptoKey)
        .execute();

    System.out.println(iamPolicy.getBindings());
    return iamPolicy;
  }
  // [END kms_get_cryptokey_policy]

  // [START kms_get_keyring_policy]
  /**
   * Retrieves the IAM policy for the given crypto key.
   */
  public static Policy getKeyRingPolicy(String projectId, String ringId) throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the keyring
    String keyring = String.format(
        "projects/%s/locations/%s/keyRings/%s",
        projectId, location, ringId);

    // Get the current IAM policy and add the new account to it.
    Policy iamPolicy = kms.projects().locations().keyRings()
        .getIamPolicy(keyring)
        .execute();

    System.out.println(iamPolicy.getBindings());
    return iamPolicy;
  }
  // [END kms_get_keyring_policy]

  // [START kms_add_member_to_cryptokey_policy]
  /**
   * Adds the given member to the given key, with the given role.
   *
   * @param ringId The id of the keyring.
   * @param keyId The id of the crypto key.
   * @param member The member to add. Must be in the proper format, eg:
   *
   *        allUsers
   *        user:$userEmail
   *        serviceAccount:$serviceAccountEmail
   *
   *        See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding
   *        for more details.
   *
   * @param role Must be in one of the following formats:
   *        roles/[role]
   *        organizations/[organizationId]/roles/[role]
   *        projects/[projectId]/roles/[role]
   *
   *        See https://g.co/cloud/iam/docs/understanding-roles
   *        for available values for [role].
   */
  public static Policy addMemberToCryptoKeyPolicy(
      String projectId, String ringId, String keyId, String member, String role)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey version
    String cryptoKey = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, location, ringId, keyId);

    // Get the current IAM policy
    Policy iamPolicy = getCryptoKeyPolicy(projectId, ringId, keyId);

    // Add the new account to it.
    Binding newBinding = new Binding()
        .setRole(role)
        .setMembers(Collections.singletonList(member));
    List<Binding> bindings = iamPolicy.getBindings();
    if (null == bindings) {
      bindings = Collections.singletonList(newBinding);
    } else {
      bindings.add(newBinding);
    }
    iamPolicy.setBindings(bindings);

    // Set the new IAM Policy.
    Policy newIamPolicy = kms.projects().locations().keyRings()
        .cryptoKeys()
        .setIamPolicy(cryptoKey, new SetIamPolicyRequest().setPolicy(iamPolicy))
        .execute();

    System.out.println("Response: " + newIamPolicy);
    return newIamPolicy;
  }
  // [END kms_add_member_to_cryptokey_policy]

  // [START kms_add_member_to_keyring_policy]
  /**
   * Adds the given member to the given keyring, with the given role.
   *
   * @param ringId The id of the keyring.
   * @param member The member to add. Must be in the proper format, eg:
   *
   *        allUsers
   *        user:$userEmail
   *        serviceAccount:$serviceAccountEmail
   *
   *        See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding
   *        for more details.
   *
   * @param role Must be in one of the following formats:
   *        roles/[role]
   *        organizations/[organizationId]/roles/[role]
   *        projects/[projectId]/roles/[role]
   *
   *        See https://g.co/cloud/iam/docs/understanding-roles
   *        for available values for [role].
   */
  public static Policy addMemberToKeyRingPolicy(
      String projectId, String ringId, String member, String role)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the keyring version
    String keyring = String.format(
        "projects/%s/locations/%s/keyRings/%s",
        projectId, location, ringId);

    // Get the current IAM policy
    Policy iamPolicy = getKeyRingPolicy(projectId, ringId);

    // Add the new account to it.
    Binding newBinding = new Binding()
        .setRole(role)
        .setMembers(Collections.singletonList(member));
    List<Binding> bindings = iamPolicy.getBindings();
    if (null == bindings) {
      bindings = Collections.singletonList(newBinding);
    } else {
      bindings.add(newBinding);
    }
    iamPolicy.setBindings(bindings);

    // Set the new IAM Policy.
    Policy newIamPolicy = kms.projects().locations()
        .keyRings()
        .setIamPolicy(keyring, new SetIamPolicyRequest().setPolicy(iamPolicy))
        .execute();

    System.out.println("Response: " + newIamPolicy);
    return newIamPolicy;
  }
  // [END kms_add_member_to_keyring_policy]

  // [START kms_remove_member_from_cryptokey_policy]
  /**
   * Removes the given member from the given policy.
   */
  public static Policy removeMemberFromCryptoKeyPolicy(
      String projectId, String ringId, String keyId, String member, String role)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String cryptoKey = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, location, ringId, keyId);

    // Get the current IAM policy and add the new account to it.
    Policy iamPolicy = getCryptoKeyPolicy(projectId, ringId, keyId);

    if (null == iamPolicy.getBindings()) {
      // Nothing to remove
      return null;
    }

    // Filter out the given member
    for (Binding b : iamPolicy.getBindings()) {
      if (role.equals(b.getRole()) && b.getMembers().contains(member)) {
        b.getMembers().removeAll(Collections.singletonList(member));
        break;
      }
    }

    // Set the new IAM Policy.
    Policy newIamPolicy = kms.projects().locations().keyRings()
        .cryptoKeys()
        .setIamPolicy(cryptoKey, new SetIamPolicyRequest().setPolicy(iamPolicy))
        .execute();

    System.out.println("Response: " + newIamPolicy);
    return newIamPolicy;
  }
  // [END kms_remove_member_from_cryptokey_policy]

  // [START kms_remove_member_from_keyring_policy]
  /**
   * Removes the given member from the given policy.
   */
  public static Policy removeMemberFromKeyRingPolicy(
      String projectId, String ringId, String member, String role)
      throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String cryptoKey = String.format(
        "projects/%s/locations/%s/keyRings/%s",
        projectId, location, ringId);

    // Get the current IAM policy and add the new account to it.
    Policy iamPolicy = getKeyRingPolicy(projectId, ringId);

    // Filter out the given member
    for (Binding b : iamPolicy.getBindings()) {
      if (role.equals(b.getRole()) && b.getMembers().contains(member)) {
        b.getMembers().remove(member);
        break;
      }
    }

    // Set the new IAM Policy.
    Policy newIamPolicy = kms.projects().locations()
        .keyRings()
        .setIamPolicy(cryptoKey, new SetIamPolicyRequest().setPolicy(iamPolicy))
        .execute();

    System.out.println("Response: " + newIamPolicy);
    return newIamPolicy;
  }
  // [END kms_remove_member_from_keyring_policy]

  /**
   * Prints all the keyrings in the given project.
   */
  public static void listKeyRings(String projectId) throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String keyRingPath = String.format(
        "projects/%s/locations/%s",
        projectId, location);

    // Make the RPC call
    ListKeyRingsResponse response = kms.projects().locations()
        .keyRings()
        .list(keyRingPath)
        .execute();

    // Print the returned key rings
    if (null != response.getKeyRings()) {
      System.out.println("Key Rings: ");
      for (KeyRing keyRing : response.getKeyRings()) {
        System.out.println(keyRing.getName());
      }
    } else {
      System.out.println("No keyrings defined.");
    }
  }

  /**
   * Prints all the keys in the given key ring.
   */
  public static void listCryptoKeys(String projectId, String ringId) throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String keyRingPath = String.format(
        "projects/%s/locations/%s/keyRings/%s",
        projectId, location, ringId);

    ListCryptoKeysResponse cryptoKeys = kms.projects().locations().keyRings()
        .cryptoKeys()
        .list(keyRingPath)
        .execute();

    for (CryptoKey key : cryptoKeys.getCryptoKeys()) {
      System.out.println(key);
    }
  }

  /**
   * Prints all the versions for the given crypto key.
   */
  public static void listCryptoKeyVersions(
      String projectId, String ringId, String keyId) throws IOException {
    String location = "global";
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String cryptoKeys = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, location, ringId, keyId);

    DestroyCryptoKeyVersionRequest destroyRequest = new DestroyCryptoKeyVersionRequest();

    ListCryptoKeyVersionsResponse versions = kms.projects().locations().keyRings().cryptoKeys()
        .cryptoKeyVersions()
        .list(cryptoKeys)
        .execute();

    for (CryptoKeyVersion version : versions.getCryptoKeyVersions()) {
      System.out.println(version);
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
