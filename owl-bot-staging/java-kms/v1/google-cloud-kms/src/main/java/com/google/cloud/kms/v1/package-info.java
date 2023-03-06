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

/**
 * A client to Cloud Key Management Service (KMS) API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
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
