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
 * <p>======================= TablesServiceClient =======================
 *
 * <p>Service Description: The Tables Service provides an API for reading and updating tables. It
 * defines the following resource model:
 *
 * <p>- The API has a collection of [Table][google.area120.tables.v1alpha1.Table] resources, named
 * `tables/&#42;`
 *
 * <p>- Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row] resources, named
 * `tables/&#42;/rows/&#42;`
 *
 * <p>Sample for TablesServiceClient:
 *
 * <pre>{@code
 * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
 *   String name = "name3373707";
 *   Table response = tablesServiceClient.getTable(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.area120.tables.v1alpha;

import javax.annotation.Generated;
