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
 * A client to Certificate Manager API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CertificateManagerClient =======================
 *
 * <p>Service Description: API Overview
 *
 * <p>Certificates Manager API allows customers to see and manage all their TLS certificates.
 *
 * <p>Certificates Manager API service provides methods to manage certificates, group them into
 * collections, and create serving configuration that can be easily applied to other Cloud resources
 * e.g. Target Proxies.
 *
 * <p>Data Model
 *
 * <p>The Certificates Manager service exposes the following resources:
 *
 * <ul>
 *   <li>`Certificate` which describes a single TLS certificate.
 *   <li>`CertificateMap` which describes a collection of certificates that can be attached to a
 *       target resource.
 *   <li>`CertificateMapEntry` which describes a single configuration entry that consists of a SNI
 *       and a group of certificates. It's a subresource of CertificateMap.
 * </ul>
 *
 * <p>Certificate, CertificateMap and CertificateMapEntry IDs have to match "^[a-z0-9-]{1,63}$"
 * regexp, which means that - only lower case letters, digits, and hyphen are allowed - length of
 * the resource ID has to be in [1,63] range.
 *
 * <p>Provides methods to manage Cloud Certificate Manager entities.
 *
 * <p>Sample for CertificateManagerClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
 *   CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");
 *   Certificate response = certificateManagerClient.getCertificate(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.certificatemanager.v1;

import javax.annotation.Generated;
