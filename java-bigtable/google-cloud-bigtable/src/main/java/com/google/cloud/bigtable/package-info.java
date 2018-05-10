/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client for Cloud Bigtable.
 *
 * <p>This client is composed of two parts: the Data API and the Admin API. The Admin API provides
 * direct access to the protobuf based API, while the Data API has a higher level wrapper around the
 * raw GRPC stubs.
 *
 * @see com.google.cloud.bigtable.data.v2.BigtableDataClient For the data client.
 * @see com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient For instance instance admin
 *     client.
 * @see com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient For table admin client.
 */
package com.google.cloud.bigtable;
