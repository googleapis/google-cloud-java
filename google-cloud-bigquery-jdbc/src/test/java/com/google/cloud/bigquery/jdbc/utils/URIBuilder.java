/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.utils;

public class URIBuilder {
  StringBuilder builder;

  public URIBuilder(String baseUri) {
    builder = new StringBuilder(baseUri);
  }

  public URIBuilder append(String key, Object value) {
    builder.append(String.format("%s=%s;", key, value.toString()));
    return this;
  }

  public String toString() {
    return builder.toString();
  }
}
