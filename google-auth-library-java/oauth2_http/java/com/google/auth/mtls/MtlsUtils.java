/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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

package com.google.auth.mtls;

import com.google.api.core.InternalApi;
import com.google.auth.oauth2.EnvironmentProvider;
import com.google.auth.oauth2.PropertyProvider;
import com.google.common.base.Strings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * Utility class for mTLS related operations.
 *
 * <p>For internal use only.
 */
@InternalApi
public class MtlsUtils {
  static final String CERTIFICATE_CONFIGURATION_ENV_VARIABLE = "GOOGLE_API_CERTIFICATE_CONFIG";
  static final String WELL_KNOWN_CERTIFICATE_CONFIG_FILE = "certificate_config.json";
  static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";

  private MtlsUtils() {
    // Prevent instantiation for Utility class
  }

  /**
   * Returns the path to the client certificate file specified by the loaded workload certificate
   * configuration.
   *
   * @return The path to the certificate file.
   * @throws IOException if the certificate configuration cannot be found or loaded.
   */
  public static String getCertificatePath(
      EnvironmentProvider envProvider, PropertyProvider propProvider, String certConfigPathOverride)
      throws IOException {
    String certPath =
        getWorkloadCertificateConfiguration(envProvider, propProvider, certConfigPathOverride)
            .getCertPath();
    if (Strings.isNullOrEmpty(certPath)) {
      throw new CertificateSourceUnavailableException(
          "Certificate configuration loaded successfully, but does not contain a 'certificate_file' path.");
    }
    return certPath;
  }

  /**
   * Resolves and loads the workload certificate configuration.
   *
   * <p>The configuration file is resolved in the following order of precedence: 1. The provided
   * certConfigPathOverride (if not null). 2. The path specified by the
   * GOOGLE_API_CERTIFICATE_CONFIG environment variable. 3. The well-known certificate configuration
   * file in the gcloud config directory.
   *
   * @param envProvider the environment provider to use for resolving environment variables
   * @param propProvider the property provider to use for resolving system properties
   * @param certConfigPathOverride optional override path for the configuration file
   * @return the loaded WorkloadCertificateConfiguration
   * @throws IOException if the configuration file cannot be found, read, or parsed
   */
  static WorkloadCertificateConfiguration getWorkloadCertificateConfiguration(
      EnvironmentProvider envProvider, PropertyProvider propProvider, String certConfigPathOverride)
      throws IOException {
    File certConfig;
    if (certConfigPathOverride != null) {
      certConfig = new File(certConfigPathOverride);
    } else {
      String envCredentialsPath = envProvider.getEnv(CERTIFICATE_CONFIGURATION_ENV_VARIABLE);
      if (!Strings.isNullOrEmpty(envCredentialsPath)) {
        certConfig = new File(envCredentialsPath);
      } else {
        certConfig = getWellKnownCertificateConfigFile(envProvider, propProvider);
      }
    }

    if (!certConfig.isFile()) {
      throw new CertificateSourceUnavailableException(
          "Certificate configuration file does not exist or is not a file: "
              + certConfig.getAbsolutePath());
    }
    try (InputStream certConfigStream = new FileInputStream(certConfig)) {
      return WorkloadCertificateConfiguration.fromCertificateConfigurationStream(certConfigStream);
    }
  }

  private static File getWellKnownCertificateConfigFile(
      EnvironmentProvider envProvider, PropertyProvider propProvider) throws IOException {
    File cloudConfigPath;
    String envPath = envProvider.getEnv("CLOUDSDK_CONFIG");
    if (envPath != null) {
      cloudConfigPath = new File(envPath);
    } else {
      String osName = propProvider.getProperty("os.name", "").toLowerCase(Locale.US);
      if (osName.indexOf("windows") >= 0) {
        String appData = envProvider.getEnv("APPDATA");
        if (Strings.isNullOrEmpty(appData)) {
          throw new CertificateSourceUnavailableException(
              "APPDATA environment variable is not set on Windows.");
        }
        File appDataPath = new File(appData);
        cloudConfigPath = new File(appDataPath, CLOUDSDK_CONFIG_DIRECTORY);
      } else {
        File configPath = new File(propProvider.getProperty("user.home", ""), ".config");
        cloudConfigPath = new File(configPath, CLOUDSDK_CONFIG_DIRECTORY);
      }
    }
    return new File(cloudConfigPath, WELL_KNOWN_CERTIFICATE_CONFIG_FILE);
  }
}
