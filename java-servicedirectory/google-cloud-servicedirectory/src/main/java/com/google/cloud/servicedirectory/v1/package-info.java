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
 * <p>======================= LookupServiceClient =======================
 *
 * <p>Service Description: Service Directory API for looking up service data at runtime.
 *
 * <p>Sample for LookupServiceClient:
 *
 * <pre>{@code
 * try (LookupServiceClient lookupServiceClient = LookupServiceClient.create()) {
 *   ResolveServiceRequest request =
 *       ResolveServiceRequest.newBuilder()
 *           .setName(
 *               ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
 *           .setMaxEndpoints(2074789987)
 *           .setEndpointFilter("endpointFilter-1834249875")
 *           .build();
 *   ResolveServiceResponse response = lookupServiceClient.resolveService(request);
 * }
 * }</pre>
 *
 * <p>======================= RegistrationServiceClient =======================
 *
 * <p>Service Description: Service Directory API for registering services. It defines the following
 * resource model:
 *
 * <p>- The API has a collection of [Namespace][google.cloud.servicedirectory.v1.Namespace]
 * resources, named `projects/&#42;/locations/&#42;/namespaces/&#42;`.
 *
 * <p>- Each Namespace has a collection of [Service][google.cloud.servicedirectory.v1.Service]
 * resources, named `projects/&#42;/locations/&#42;/namespaces/&#42;/services/&#42;`.
 *
 * <p>- Each Service has a collection of [Endpoint][google.cloud.servicedirectory.v1.Endpoint]
 * resources, named
 * `projects/&#42;/locations/&#42;/namespaces/&#42;/services/&#42;/endpoints/&#42;`.
 *
 * <p>Sample for RegistrationServiceClient:
 *
 * <pre>{@code
 * try (RegistrationServiceClient registrationServiceClient = RegistrationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Namespace namespace = Namespace.newBuilder().build();
 *   String namespaceId = "namespaceId790852566";
 *   Namespace response =
 *       registrationServiceClient.createNamespace(parent, namespace, namespaceId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.servicedirectory.v1;

import javax.annotation.Generated;
