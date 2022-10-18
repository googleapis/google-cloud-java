/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.integration;

import com.google.cloud.ServiceOptions;
import java.util.UUID;

public class BaseTest {
  protected static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  protected static final String DEFAULT_ZONE = "us-central1-a";
  protected static final String DEFAULT_REGION = "us-west1";
  protected static final String COMPUTE_PREFIX = "gapic-";

  public static String generateRandomName(String placeholder) {
    return COMPUTE_PREFIX + placeholder + UUID.randomUUID().toString().substring(0, 8);
  }
}
