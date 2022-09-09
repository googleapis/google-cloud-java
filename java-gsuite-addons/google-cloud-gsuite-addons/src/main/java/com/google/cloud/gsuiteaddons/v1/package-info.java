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
 * <p>======================= GSuiteAddOnsClient =======================
 *
 * <p>Service Description: A service for managing Google Workspace Add-ons deployments.
 *
 * <p>A Google Workspace Add-on is a third-party embedded component that can be installed in Google
 * Workspace Applications like Gmail, Calendar, Drive, and the Google Docs, Sheets, and Slides
 * editors. Google Workspace Add-ons can display UI cards, receive contextual information from the
 * host application, and perform actions in the host application (See:
 * https://developers.google.com/gsuite/add-ons/overview for more information).
 *
 * <p>A Google Workspace Add-on deployment resource specifies metadata about the add-on, including a
 * specification of the entry points in the host application that trigger add-on executions (see:
 * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests). Add-on deployments
 * defined via the Google Workspace Add-ons API define their entrypoints using HTTPS URLs (See:
 * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
 *
 * <p>A Google Workspace Add-on deployment can be installed in developer mode, which allows an
 * add-on developer to test the experience an end-user would see when installing and running the
 * add-on in their G Suite applications. When running in developer mode, more detailed error
 * messages are exposed in the add-on UI to aid in debugging.
 *
 * <p>A Google Workspace Add-on deployment can be published to Google Workspace Marketplace, which
 * allows other Google Workspace users to discover and install the add-on. See:
 * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview for details.
 *
 * <p>Sample for GSuiteAddOnsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
 *   AuthorizationName name = AuthorizationName.of("[PROJECT]");
 *   Authorization response = gSuiteAddOnsClient.getAuthorization(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.gsuiteaddons.v1;

import javax.annotation.Generated;
