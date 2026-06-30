/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.core.InternalApi;

@InternalApi
class BigQueryErrorMessage {

  static final String CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED =
      "Customized Types are not supported yet.";
  static final String INVALID_ARRAY = "Invalid java.sql.Array instance.";
  static final String METHOD_NOT_IMPLEMENTED = "This method is not implemented.";
  static final String OAUTH_TYPE_ERROR_MESSAGE = "Invalid Auth type specified";
}
