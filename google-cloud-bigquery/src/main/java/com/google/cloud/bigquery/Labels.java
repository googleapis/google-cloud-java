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

package com.google.cloud.bigquery;

import com.google.auto.value.AutoValue;

/**
Utility to help with labels. Since we need to deal with nulls a lot, static methods are preferred over
instance methods. Instance methods are suffixed with underscore to make you feel bad using them.
*/
@AutoValue
abstract class Labels {
  abstract Map<String,String> userMap_();

  @Memoized
  abstract Map<String, String> rpcMap_();
}
