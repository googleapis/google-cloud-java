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
import java.security.MessageDigest;
import java.util.Locale;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Utility class for mTLS related operations.
 *
 * <p>For internal use only.
 */
@NullMarked
@InternalApi
public class MtlsUtils {
  static final String CERTIFICATE_CONFIGURATION_ENV_VARIABLE = "GOOGLE_API_CERTIFICATE_CONFIG";
  static final String WELL_KNOWN_CERTIFICATE_CONFIG_FILE = "certificate_config.json";
  static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";

  private MtlsUtils() {
    // Prevent instantiation for Utility class
  }

  /**
   * Returns if mutual TLS client certificate should be used.
   * Delegates directly to getWorkloadCertPath to avoid duplicate logic.
   */
  public static boolean useMtlsClientCertificate(
      EnvironmentProvider envProvider, PropertyProvider propProvider) {
    return getWorkloadCertPath(envProvider, propProvider) != null;
  }

  /**
   * Resolves and returns the path to the mutual TLS client certificate, or null if none should be used.
   */
  public static @Nullable String getWorkloadCertPath(
      EnvironmentProvider envProvider, PropertyProvider propProvider) {
    String useClientCertificate = envProvider.getEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE");
    if ("false".equalsIgnoreCase(useClientCertificate)) {
      return null;
    }

    String certConfigPath = envProvider.getEnv(CERTIFICATE_CONFIGURATION_ENV_VARIABLE);
    if (!Strings.isNullOrEmpty(certConfigPath)) {
      try {
        WorkloadCertificateConfiguration config =
            getWorkloadCertificateConfiguration(envProvider, propProvider, certConfigPath);

        File certFile = new File(config.getCertPath());
        File keyFile = new File(config.getPrivateKeyPath());
        if (!certFile.exists() || !keyFile.exists()) {
          throw new IllegalStateException(
              "Certificate config points to certificate/key files that do not exist on disk: "
                  + "cert_path="
                  + config.getCertPath()
                  + ", key_path="
                  + config.getPrivateKeyPath());
        }
        return config.getCertPath();
      } catch (CertificateSourceUnavailableException e) {
        // Certificate config file does not exist on disk -> safe fallback
      } catch (IllegalStateException e) {
        throw e;
      } catch (Exception e) {
        throw new IllegalStateException("Failed to parse certificate config: " + certConfigPath, e);
      }
    } else {
      try {
        WorkloadCertificateConfiguration config =
            getWorkloadCertificateConfiguration(envProvider, propProvider, null);
        File certFile = new File(config.getCertPath());
        File keyFile = new File(config.getPrivateKeyPath());
        if (certFile.exists() && keyFile.exists()) {
          return config.getCertPath();
        }
      } catch (CertificateSourceUnavailableException e) {
        // Well-known gcloud certificate_config.json does not exist. Safe fallback to SPIFFE/well-known paths.
      } catch (Exception e) {
        // Ignore parsing errors for well-known config fallback
      }
    }

    String gkeCertPath = getGkeWorkloadCertPath();
    if (gkeCertPath != null) {
      return gkeCertPath;
    }

    String gceCertPath = getGceWorkloadCertPath();
    if (gceCertPath != null) {
      return gceCertPath;
    }

    return null;
  }

  /** Dedicated GKE Fallback Resolution Path */
  public static @Nullable String getGkeWorkloadCertPath() {
    String gkePath = "/var/run/secrets/workload-spiffe-credentials";
    File bundleFile = new File(gkePath, "credentialbundle.pem");
    if (bundleFile.exists()) {
      return bundleFile.getAbsolutePath();
    }

    File certFile = new File(gkePath, "certificates.pem");
    File keyFile = new File(gkePath, "private_key.pem");
    if (certFile.exists() && keyFile.exists()) {
      return certFile.getAbsolutePath();
    }
    return null;
  }

  /** Dedicated GCE Fallback Resolution Path */
  public static @Nullable String getGceWorkloadCertPath() {
    // Isolated GCE workload credentials fallback for independent rollout phase
    return null;
  }

  /** Centralized SHA-256 Fingerprint Calculator */
  public static @Nullable String getCertificateFingerprint(@Nullable String certPath) {
    if (certPath == null) {
      return null;
    }
    File file = new File(certPath);
    if (!file.exists()) {
      return null;
    }
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      try (FileInputStream fis = new FileInputStream(file)) {
        byte[] byteArray = new byte[1024];
        int bytesCount;
        while ((bytesCount = fis.read(byteArray)) != -1) {
          digest.update(byteArray, 0, bytesCount);
        }
      }
      StringBuilder sb = new StringBuilder();
      for (byte b : digest.digest()) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Returns the path to the client certificate file specified by the loaded workload certificate
   * configuration.
   *
   * @return The path to the certificate file.
   * @throws IOException if the certificate configuration cannot be found or loaded.
   */
  public static String getCertificatePath(
      EnvironmentProvider envProvider, PropertyProvider propProvider, @Nullable String certConfigPathOverride)
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
   */
  static WorkloadCertificateConfiguration getWorkloadCertificateConfiguration(
      EnvironmentProvider envProvider, PropertyProvider propProvider, @Nullable String certConfigPathOverride)
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
