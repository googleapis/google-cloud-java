/*
 * Copyright 2023, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import java.io.File;

/**
 * This public class provides shared utilities for common OAuth2 utils or ADC. It also exposes
 * convenience methods such as a getter for well-known Application Default Credentials file path
 */
public class GoogleAuthUtils {

  /**
   * Gets the path to the well-known Application Default Credentials file location
   *
   * @return the path to the well-known Application Default Credentials file location
   */
  public static final String getWellKnownCredentialsPath() {
    return getWellKnownCredentialsFile(DefaultCredentialsProvider.DEFAULT).getAbsolutePath();
  }

  /**
   * Testing version of getWellKnownCredentialsPath() that uses a custom provider
   *
   * @return the path to the well-known Application Default Credentials file location
   */
  static final String getWellKnownCredentialsPath(DefaultCredentialsProvider provider) {
    return getWellKnownCredentialsFile(provider).getAbsolutePath();
  }

  /**
   * Platform-independent logic to obtain the well-known Application Default Credentials file
   *
   * @param provider the provider used to resolve env and system properties (exposed for testing
   *     purposes)
   * @return the well-known Application Default Credentials file
   */
  static final File getWellKnownCredentialsFile(DefaultCredentialsProvider provider) {
    File cloudConfigPath;
    String envPath = provider.getEnv("CLOUDSDK_CONFIG");
    if (envPath != null) {
      cloudConfigPath = new File(envPath);
    } else if (provider.getOsName().indexOf("windows") >= 0) {
      File appDataPath = new File(provider.getEnv("APPDATA"));
      cloudConfigPath = new File(appDataPath, provider.CLOUDSDK_CONFIG_DIRECTORY);
    } else {
      File configPath = new File(provider.getProperty("user.home", ""), ".config");
      cloudConfigPath = new File(configPath, provider.CLOUDSDK_CONFIG_DIRECTORY);
    }
    return new File(cloudConfigPath, provider.WELL_KNOWN_CREDENTIALS_FILE);
  }
}
