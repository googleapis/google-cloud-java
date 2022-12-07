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
 * <p>======================= OrgPolicyClient =======================
 *
 * <p>Service Description: An interface for managing organization policies.
 *
 * <p>The Cloud Org Policy service provides a simple mechanism for organizations to restrict the
 * allowed configurations across their entire Cloud Resource hierarchy.
 *
 * <p>You can use a `policy` to configure restrictions in Cloud resources. For example, you can
 * enforce a `policy` that restricts which Google Cloud Platform APIs can be activated in a certain
 * part of your resource hierarchy, or prevents serial port access to VM instances in a particular
 * folder.
 *
 * <p>`Policies` are inherited down through the resource hierarchy. A `policy` applied to a parent
 * resource automatically applies to all its child resources unless overridden with a `policy` lower
 * in the hierarchy.
 *
 * <p>A `constraint` defines an aspect of a resource's configuration that can be controlled by an
 * organization's policy administrator. `Policies` are a collection of `constraints` that defines
 * their allowable configuration on a particular resource and its child resources.
 *
 * <p>Sample for OrgPolicyClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
 *   PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
 *   Policy response = orgPolicyClient.getPolicy(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.orgpolicy.v2;

import javax.annotation.Generated;
