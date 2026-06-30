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

import com.google.cloud.spanner.SpannerOptions;
import com.google.common.base.Strings;

public class SpannerOmniHelper {
  private static final String EXPERIMENTAL_HOST = "spanner.experimental_host";
  private static final String OMNI_HOST = "spanner.omni.host";
  private static final String USE_PLAIN_TEXT = "spanner.use_plain_text";
  private static final String USE_MTLS = "spanner.mtls";
  private static final String CLIENT_CERT_PATH = "spanner.client_cert_path";
  private static final String CLIENT_CERT_KEY_PATH = "spanner.client_cert_key_path";
  private static final String USERNAME = "spanner.username";
  private static final String PASSWORD = "spanner.password";

  /**
   * Checks whether the Spanner Omni host is being used. This is done by checking if the
   * spanner.omni.host or spanner.experimental_host (for compatibility) system property is set.
   *
   * @return true if the Spanner Omni host is being used. Returns false otherwise.
   */
  public static boolean isSpannerOmni() {
    return !Strings.isNullOrEmpty(System.getProperty(OMNI_HOST))
        || !Strings.isNullOrEmpty(System.getProperty(EXPERIMENTAL_HOST));
  }

  public static void appendSpannerOmniProperties(StringBuilder uri) {
    uri.append(";type=omni");
    String username = System.getProperty(USERNAME, "");
    String password = System.getProperty(PASSWORD, "");
    if (!Strings.isNullOrEmpty(username)) {
      uri.append(";username=").append(username);
    }
    if (!Strings.isNullOrEmpty(password)) {
      uri.append(";password=").append(password);
    }
    if (isMtlsSetup()) {
      String clientCertificate = System.getProperty(CLIENT_CERT_PATH, "");
      String clientKey = System.getProperty(CLIENT_CERT_KEY_PATH, "");
      uri.append(";clientCertificate=").append(clientCertificate);
      uri.append(";clientKey=").append(clientKey);
    }
  }

  public static boolean isMtlsSetup() {
    return Boolean.getBoolean(USE_MTLS);
  }

  public static void setSpannerOmniOptions(SpannerOptions.Builder builder) {
    String omniEndpoint = System.getProperty(OMNI_HOST, "");
    String experimentalHost = System.getProperty(EXPERIMENTAL_HOST, "");
    if (!Strings.isNullOrEmpty(experimentalHost)) {
      omniEndpoint = experimentalHost;
    }
    boolean usePlainText = Boolean.getBoolean(USE_PLAIN_TEXT);
    builder.setHost(omniEndpoint);
    builder.setType(SpannerOptions.InstanceType.OMNI);
    String username = System.getProperty(USERNAME, "");
    String password = System.getProperty(PASSWORD, "");
    if (!Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password)) {
      builder.login(username, password.toCharArray());
    }
    if (usePlainText) {
      builder.usePlainText();
    }
    if (isMtlsSetup()) {
      String clientCertificate = System.getProperty(CLIENT_CERT_PATH, "");
      String clientKey = System.getProperty(CLIENT_CERT_KEY_PATH, "");
      builder.useClientCert(clientCertificate, clientKey);
    }
  }
}
