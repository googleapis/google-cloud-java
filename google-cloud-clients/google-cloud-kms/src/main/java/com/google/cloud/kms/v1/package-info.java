/*
 * Copyright 2019 Google LLC
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

/**
 * A client to Cloud Key Management Service (KMS) API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>========================== KeyManagementServiceClient ==========================
 *
 * <p>Service Description: Google Cloud Key Management Service
 *
 * <p>Manages cryptographic keys and operations using those keys. Implements a REST model with the
 * following objects:
 *
 * <p>&#42; [KeyRing][google.cloud.kms.v1.KeyRing] &#42; [CryptoKey][google.cloud.kms.v1.CryptoKey]
 * &#42; [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
 *
 * <p>If you are using manual gRPC libraries, see [Using gRPC with Cloud
 * KMS](https://cloud.google.com/kms/docs/grpc).
 *
 * <p>Sample for KeyManagementServiceClient:
 *
 * <pre>
 * <code>
 * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
 *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
 *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.kms.v1;

import javax.annotation.Generated;
