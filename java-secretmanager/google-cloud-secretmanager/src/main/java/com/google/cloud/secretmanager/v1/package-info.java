/*
 * Copyright 2020 Google LLC
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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SecretManagerServiceClient =======================
 *
 * <p>Service Description: Secret Manager Service
 *
 * <p>Manages secrets and operations using those secrets. Implements a REST model with the following
 * objects:
 *
 * <ul>
 *   <li>[Secret][google.cloud.secretmanager.v1.Secret]
 *   <li>[SecretVersion][google.cloud.secretmanager.v1.SecretVersion]
 * </ul>
 *
 * <p>Sample for SecretManagerServiceClient:
 *
 * <pre>{@code
 * try (SecretManagerServiceClient secretManagerServiceClient =
 *     SecretManagerServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   String secretId = "secretId945974251";
 *   Secret secret = Secret.newBuilder().build();
 *   Secret response = secretManagerServiceClient.createSecret(parent, secretId, secret);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.secretmanager.v1;

import javax.annotation.Generated;
