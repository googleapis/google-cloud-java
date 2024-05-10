/*
 * Copyright 2024 Google LLC
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

/**
 * A client to Cloud Key Management Service (KMS) API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AutokeyClient =======================
 *
 * <p>Service Description: Provides interfaces for using Cloud KMS Autokey to provision new
 * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed Encryption Key (CMEK)
 * use, on-demand. To support certain client tooling, this feature is modeled around a
 * [KeyHandle][google.cloud.kms.v1.KeyHandle] resource: creating a
 * [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource project and given location triggers
 * Cloud KMS Autokey to provision a [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key
 * project and the same location.
 *
 * <p>Prior to use in a given resource project,
 * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig] should have been
 * called on an ancestor folder, setting the key project where Cloud KMS Autokey should create new
 * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional prerequisites. To
 * check what key project, if any, is currently configured on a resource project's ancestor folder,
 * see [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
 *
 * <p>Sample for AutokeyClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AutokeyClient autokeyClient = AutokeyClient.create()) {
 *   KeyHandleName name = KeyHandleName.of("[PROJECT]", "[LOCATION]", "[KEY_HANDLE]");
 *   KeyHandle response = autokeyClient.getKeyHandle(name);
 * }
 * }</pre>
 *
 * <p>======================= AutokeyAdminClient =======================
 *
 * <p>Service Description: Provides interfaces for managing Cloud KMS Autokey folder-level
 * configurations. A configuration is inherited by all descendent projects. A configuration at one
 * folder overrides any other configurations in its ancestry. Setting a configuration on a folder is
 * a prerequisite for Cloud KMS Autokey, so that users working in a descendant project can request
 * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed Encryption
 * Key (CMEK) use, on-demand.
 *
 * <p>Sample for AutokeyAdminClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
 *   AutokeyConfig autokeyConfig = AutokeyConfig.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   AutokeyConfig response = autokeyAdminClient.updateAutokeyConfig(autokeyConfig, updateMask);
 * }
 * }</pre>
 *
 * <p>======================= EkmServiceClient =======================
 *
 * <p>Service Description: Google Cloud Key Management EKM Service
 *
 * <p>Manages external cryptographic keys and operations using those keys. Implements a REST model
 * with the following objects:
 *
 * <ul>
 *   <li>[EkmConnection][google.cloud.kms.v1.EkmConnection]
 * </ul>
 *
 * <p>Sample for EkmServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
 *   EkmConnectionName name = EkmConnectionName.of("[PROJECT]", "[LOCATION]", "[EKM_CONNECTION]");
 *   EkmConnection response = ekmServiceClient.getEkmConnection(name);
 * }
 * }</pre>
 *
 * <p>======================= KeyManagementServiceClient =======================
 *
 * <p>Service Description: Google Cloud Key Management Service
 *
 * <p>Manages cryptographic keys and operations using those keys. Implements a REST model with the
 * following objects:
 *
 * <ul>
 *   <li>[KeyRing][google.cloud.kms.v1.KeyRing]
 *   <li>[CryptoKey][google.cloud.kms.v1.CryptoKey]
 *   <li>[CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
 *   <li>[ImportJob][google.cloud.kms.v1.ImportJob]
 * </ul>
 *
 * <p>If you are using manual gRPC libraries, see [Using gRPC with Cloud
 * KMS](https://cloud.google.com/kms/docs/grpc).
 *
 * <p>Sample for KeyManagementServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create()) {
 *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
 *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.kms.v1;

import javax.annotation.Generated;
