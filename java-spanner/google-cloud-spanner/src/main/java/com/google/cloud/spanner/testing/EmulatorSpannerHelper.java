/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.testing;

import com.google.common.base.Strings;

/** Utility class for checking emulator state for tests */
public class EmulatorSpannerHelper {

  public static final String SPANNER_EMULATOR_HOST = "SPANNER_EMULATOR_HOST";

  /**
   * Checks whether the emulator is being used. This is done by checking if the
   * SPANNER_EMULATOR_HOST environment variable is set.
   *
   * @return true if the emulator is being used. Returns false otherwise.
   */
  public static boolean isUsingEmulator() {
    return !Strings.isNullOrEmpty(System.getenv(SPANNER_EMULATOR_HOST));
  }
}
