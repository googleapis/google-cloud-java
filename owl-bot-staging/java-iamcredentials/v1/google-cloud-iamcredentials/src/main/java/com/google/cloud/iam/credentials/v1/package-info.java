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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= IamCredentialsClient =======================
 *
 * <p>Service Description: A service account is a special type of Google account that belongs to
 * your application or a virtual machine (VM), instead of to an individual end user. Your
 * application assumes the identity of the service account to call Google APIs, so that the users
 * aren't directly involved.
 *
 * <p>Service account credentials are used to temporarily assume the identity of the service
 * account. Supported credential types include OAuth 2.0 access tokens, OpenID Connect ID tokens,
 * self-signed JSON Web Tokens (JWTs), and more.
 *
 * <p>Sample for IamCredentialsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
 *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
 *   List<String> delegates = new ArrayList<>();
 *   List<String> scope = new ArrayList<>();
 *   Duration lifetime = Duration.newBuilder().build();
 *   GenerateAccessTokenResponse response =
 *       iamCredentialsClient.generateAccessToken(name, delegates, scope, lifetime);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.iam.credentials.v1;

import javax.annotation.Generated;
