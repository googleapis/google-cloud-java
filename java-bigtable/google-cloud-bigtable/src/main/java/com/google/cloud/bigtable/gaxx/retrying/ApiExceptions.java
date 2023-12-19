/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigtable.gaxx.retrying;

import com.google.api.core.InternalApi;

// TODO: move this to gax later
@InternalApi
public class ApiExceptions {

  private ApiExceptions() {}

  // TODO: this should replace the existing ApiException#isRetryable() method,
  //  but that cant be done in bigtable, so this lives here for now.
  public static boolean isRetryable2(Throwable e) {
    if (RetryInfoRetryAlgorithm.extractRetryDelay(e) != null) {
      return true;
    }
    return false;
  }
}
