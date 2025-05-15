/*
 * Copyright 2025 Google LLC
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
 * A client to Chronicle API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DataAccessControlServiceClient =======================
 *
 * <p>Service Description: DataAccessControlService exposes resources and endpoints related to data
 * access control.
 *
 * <p>Sample for DataAccessControlServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataAccessControlServiceClient dataAccessControlServiceClient =
 *     DataAccessControlServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
 *   String dataAccessLabelId = "dataAccessLabelId1775298977";
 *   DataAccessLabel response =
 *       dataAccessControlServiceClient.createDataAccessLabel(
 *           parent, dataAccessLabel, dataAccessLabelId);
 * }
 * }</pre>
 *
 * <p>======================= EntityServiceClient =======================
 *
 * <p>Service Description: EntityService contains apis for finding entities.
 *
 * <p>Sample for EntityServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
 *   WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
 *   Watchlist response = entityServiceClient.getWatchlist(name);
 * }
 * }</pre>
 *
 * <p>======================= InstanceServiceClient =======================
 *
 * <p>Service Description: InstanceService provides the entry interface for the Chronicle API.
 *
 * <p>Sample for InstanceServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstanceServiceClient instanceServiceClient = InstanceServiceClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = instanceServiceClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>======================= ReferenceListServiceClient =======================
 *
 * <p>Service Description: ReferenceListService provides an interface for managing reference lists.
 *
 * <p>Sample for ReferenceListServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReferenceListServiceClient referenceListServiceClient =
 *     ReferenceListServiceClient.create()) {
 *   ReferenceListName name =
 *       ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");
 *   ReferenceList response = referenceListServiceClient.getReferenceList(name);
 * }
 * }</pre>
 *
 * <p>======================= RuleServiceClient =======================
 *
 * <p>Service Description: RuleService provides interface for user-created rules.
 *
 * <p>Sample for RuleServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Rule rule = Rule.newBuilder().build();
 *   Rule response = ruleServiceClient.createRule(parent, rule);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.chronicle.v1;

import javax.annotation.Generated;
