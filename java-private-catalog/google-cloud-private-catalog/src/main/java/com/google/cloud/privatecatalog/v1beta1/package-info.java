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
 * <p>======================= PrivateCatalogClient =======================
 *
 * <p>Service Description: `PrivateCatalog` allows catalog consumers to retrieve `Catalog`,
 * `Product` and `Version` resources under a target resource context.
 *
 * <p>`Catalog` is computed based on the [Association][]s linked to the target resource and its
 * ancestors. Each association's [google.cloud.privatecatalogproducer.v1beta.Catalog][] is
 * transformed into a `Catalog`. If multiple associations have the same parent
 * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are de-duplicated into one
 * `Catalog`. Users must have `cloudprivatecatalog.catalogTargets.get` IAM permission on the
 * resource context in order to access catalogs. `Catalog` contains the resource name and a subset
 * of data of the original [google.cloud.privatecatalogproducer.v1beta.Catalog][].
 *
 * <p>`Product` is child resource of the catalog. A `Product` contains the resource name and a
 * subset of the data of the original [google.cloud.privatecatalogproducer.v1beta.Product][].
 *
 * <p>`Version` is child resource of the product. A `Version` contains the resource name and a
 * subset of the data of the original [google.cloud.privatecatalogproducer.v1beta.Version][].
 *
 * <p>Sample for PrivateCatalogClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
 *   SearchCatalogsRequest request =
 *       SearchCatalogsRequest.newBuilder()
 *           .setResource("resource-341064690")
 *           .setQuery("query107944136")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (Catalog element : privateCatalogClient.searchCatalogs(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.privatecatalog.v1beta1;

import javax.annotation.Generated;
