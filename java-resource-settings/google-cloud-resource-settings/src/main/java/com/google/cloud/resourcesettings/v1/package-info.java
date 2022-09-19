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
 * <p>======================= ResourceSettingsServiceClient =======================
 *
 * <p>Service Description: An interface to interact with resource settings and setting values
 * throughout the resource hierarchy.
 *
 * <p>Services may surface a number of settings for users to control how their resources behave.
 * Values of settings applied on a given Cloud resource are evaluated hierarchically and inherited
 * by all descendants of that resource.
 *
 * <p>For all requests, returns a `google.rpc.Status` with `google.rpc.Code.PERMISSION_DENIED` if
 * the IAM check fails or the `parent` resource is not in a Cloud Organization. For all requests,
 * returns a `google.rpc.Status` with `google.rpc.Code.INVALID_ARGUMENT` if the request is
 * malformed.
 *
 * <p>Sample for ResourceSettingsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ResourceSettingsServiceClient resourceSettingsServiceClient =
 *     ResourceSettingsServiceClient.create()) {
 *   SettingName name =
 *       SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]");
 *   Setting response = resourceSettingsServiceClient.getSetting(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.resourcesettings.v1;

import javax.annotation.Generated;
