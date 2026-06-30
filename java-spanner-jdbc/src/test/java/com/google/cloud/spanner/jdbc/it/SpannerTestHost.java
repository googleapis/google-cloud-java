/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import com.google.cloud.spanner.GceTestEnvConfig;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import java.net.URL;
import java.util.Optional;

class SpannerTestHost {

  static final String DEFAULT_HOST = "spanner.googleapis.com:443";

  static String getHost() {
    if (EmulatorSpannerHelper.isUsingEmulator()) {
      return System.getenv(EmulatorSpannerHelper.SPANNER_EMULATOR_HOST);
    } else {
      return Optional.ofNullable(System.getProperty(GceTestEnvConfig.GCE_SERVER_URL))
          .map(SpannerTestHost::hostFromUrl)
          .orElse(DEFAULT_HOST);
    }
  }

  private static String hostFromUrl(String serverUrl) {
    try {
      final URL url = new URL(serverUrl);
      return url.getHost() + ":" + url.getPort();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
