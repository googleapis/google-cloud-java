# Copyright 2021 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import synthtool as s
from synthtool.languages import java

IMPLEMENTS_RESOURCE_NAME = "implements ResourceName"
EXTENDS_KEY_NAME = "extends KeyName"

ENCRYPT_INSERTION_POINT = r'(\s+public final EncryptResponse encrypt\(ResourceName.*\) {\n.*\n.*\n.*\n.*\n.*\n.*return encrypt\(request\);\n\s+})'
SET_IAM_INSERTION_POINT = r'(\s+public final Policy setIamPolicy\(SetIamPolicyRequest request\) {\n\s+return.*\n\s+})'
GET_IAM_INSERTION_POINT = r'(\s+public final Policy getIamPolicy\(GetIamPolicyRequest request\) {\n\s+return.*\n\s+})'
TEST_IAM_INSERTION_POINT = r'(\s+public final TestIamPermissionsResponse testIamPermissions\(TestIamPermissionsRequest request\) {\n\s+return.*\n\s+})'

ENCRYPT_METHOD = """
  // ADDED BY SYNTH
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyPathName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString plaintext = ByteString.copyFromUtf8("");
   *   EncryptResponse response = keyManagementServiceClient.encrypt(name, plaintext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] or
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for encryption.
   *     <p>If a [CryptoKey][google.cloud.kms.v1.CryptoKey] is specified, the server will use its
   *     [primary version][google.cloud.kms.v1.CryptoKey.primary].
   * @param plaintext Required. The data to encrypt. Must be no larger than 64KiB.
   *     <p>The maximum size depends on the key version's
   *     [protection_level][google.cloud.kms.v1.CryptoKeyVersionTemplate.protection_level]. For
   *     [SOFTWARE][google.cloud.kms.v1.ProtectionLevel.SOFTWARE] keys, the plaintext must be no
   *     larger than 64KiB. For [HSM][google.cloud.kms.v1.ProtectionLevel.HSM] keys, the combined
   *     length of the plaintext and additional_authenticated_data fields must be no larger than
   *     8KiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(CryptoKeyPathName name, ByteString plaintext) {
    EncryptRequest request =
        EncryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPlaintext(plaintext)
            .build();
    return encrypt(request);
  }
"""


SET_IAM_METHODS = """
  // ADDED BY SYNTH
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(resource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(KeyName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // ADDED BY SYNTH
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(resource.toString(), policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }
"""

GET_IAM_METHODS = """
  // ADDED BY SYNTH
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy response = keyManagementServiceClient.getIamPolicy(resource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(KeyName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // ADDED BY SYNTH
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy response = keyManagementServiceClient.getIamPolicy(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }
"""

TEST_IAM_METHODS = """
  // ADDED BY SYNTH
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(resource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      KeyName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // ADDED BY SYNTH
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(resource.toString(), permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }
"""

for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.replace(
        "**/KeyManagementServiceClient.java",
        ENCRYPT_INSERTION_POINT,
        "\g<1>\n\n" + ENCRYPT_METHOD
    )

    s.replace(
        "**/KeyManagementServiceClient.java",
        GET_IAM_INSERTION_POINT,
        "\g<1>\n\n" + GET_IAM_METHODS
    )

    s.replace(
        "**/KeyManagementServiceClient.java",
        SET_IAM_INSERTION_POINT,
        "\g<1>\n\n" + SET_IAM_METHODS
    )

    s.replace(
        "**/KeyManagementServiceClient.java",
        TEST_IAM_INSERTION_POINT,
        "\g<1>\n\n" + TEST_IAM_METHODS
    )

    s.replace(
        "**/KeyRingName.java",
        IMPLEMENTS_RESOURCE_NAME,
        EXTENDS_KEY_NAME
    )

    s.replace(
        "**/CryptoKeyName.java",
        IMPLEMENTS_RESOURCE_NAME,
        EXTENDS_KEY_NAME)

    s.move(library)

s.remove_staging_dirs()
java.common_templates()
