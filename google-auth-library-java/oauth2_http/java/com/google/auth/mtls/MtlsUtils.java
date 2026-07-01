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
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.EnvironmentProvider;
import com.google.auth.oauth2.OAuth2Utils;
import com.google.auth.oauth2.PropertyProvider;
import com.google.common.base.Strings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Locale;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Utility class for mTLS related operations.
 *
 * <p>For internal use only.
 */
@InternalApi
public class MtlsUtils {
  private static final Logger LOGGER = Logger.getLogger(MtlsUtils.class.getName());

  static final String CERTIFICATE_CONFIGURATION_ENV_VARIABLE = "GOOGLE_API_CERTIFICATE_CONFIG";
  static final String WELL_KNOWN_CERTIFICATE_CONFIG_FILE = "certificate_config.json";
  static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";

  /**
   * The policy determining when to use mutual TLS (mTLS) endpoints.
   *
   * <p>See <a href="https://google.aip.dev/auth/4114">AIP-4114</a> for the specification on mTLS
   * endpoint usage.
   */
  public enum MtlsEndpointUsagePolicy {
    /** Always use the mTLS endpoint, and fail if client certificates are not configured. */
    ALWAYS,
    /** Never use the mTLS endpoint. */
    NEVER,
    /** Use the mTLS endpoint if client certificates are configured (auto-discovery). */
    AUTO
  }

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
   * Resolves and parses the workload certificate configuration.
   *
   * <p>This locates the certificate configuration file via {@link #resolveCertificateConfigFile}
   * and parses its contents into a {@link WorkloadCertificateConfiguration}.
   *
   * @param envProvider the environment provider to use for resolving environment variables
   * @param propProvider the property provider to use for resolving system properties
   * @param certConfigPathOverride optional override path for the configuration file
   * @return the loaded WorkloadCertificateConfiguration
   * @throws IOException if the configuration file cannot be resolved, read, or parsed
   */
  static WorkloadCertificateConfiguration getWorkloadCertificateConfiguration(
      EnvironmentProvider envProvider, PropertyProvider propProvider, String certConfigPathOverride)
      throws IOException {
    File certConfig =
        resolveCertificateConfigFile(envProvider, propProvider, certConfigPathOverride);
    if (certConfig == null) {
      try {
        File wellKnownConfig = getWellKnownCertificateConfigFile(envProvider, propProvider);
        throw new CertificateSourceUnavailableException(
            "Certificate configuration file does not exist or is not a file: "
                + wellKnownConfig.getAbsolutePath());
      } catch (IOException e) {
        if (e instanceof CertificateSourceUnavailableException) {
          throw (CertificateSourceUnavailableException) e;
        }
        throw new CertificateSourceUnavailableException(
            "Failed to get well-known certificate config file path", e);
      }
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

  /**
   * Centralized helper method to determine if mutual TLS (mTLS) can be enabled.
   *
   * @param envProvider the environment provider to use for resolving environment variables
   * @param propProvider the property provider to use for resolving system properties
   * @param certConfigPathOverride optional override path for the configuration file
   * @return true if mTLS should be enabled, false otherwise
   * @throws IOException if the configuration file is present but contains missing or malformed
   *     files
   */
  public static boolean canBeEnabled(
      EnvironmentProvider envProvider, PropertyProvider propProvider, String certConfigPathOverride)
      throws IOException {

    // Check if client certificate usage is allowed
    String useClientCertificate = envProvider.getEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE");
    MtlsEndpointUsagePolicy policy = getMtlsEndpointUsagePolicy(envProvider);
    if ("false".equalsIgnoreCase(useClientCertificate)) {
      if (policy == MtlsEndpointUsagePolicy.ALWAYS) {
        throw new CertificateSourceUnavailableException(
            "mTLS is configured to ALWAYS, but client certificate usage was explicitly disabled via GOOGLE_API_USE_CLIENT_CERTIFICATE=false.");
      }
      return false;
    }

    if (policy == MtlsEndpointUsagePolicy.NEVER) {
      return false;
    }

    if (policy == MtlsEndpointUsagePolicy.ALWAYS) {
      return true;
    }

    File certConfigFile =
        resolveCertificateConfigFile(envProvider, propProvider, certConfigPathOverride);
    return certConfigFile != null;
  }

  /**
   * Resolves the mutual TLS (mTLS) certificate configuration file.
   *
   * <p>The configuration file is resolved in the following order of precedence:
   *
   * <ol>
   *   <li>The developer-provided {@code certConfigPathOverride} (if not null).
   *   <li>The path specified by the {@code GOOGLE_API_CERTIFICATE_CONFIG} environment variable.
   *   <li>The well-known automatic gcloud workload identity provisioning location (via {@link
   *       #getWellKnownCertificateConfigFile}).
   * </ol>
   *
   * <p>If an explicit configuration file is specified (via override or environment variable) and it
   * is missing or invalid, an exception is thrown. If no explicit file is specified and the default
   * well-known file is missing, {@code null} is returned.
   *
   * @param envProvider the environment provider to use for resolving environment variables
   * @param propProvider the property provider to use for resolving system properties
   * @param certConfigPathOverride optional override path for the configuration file
   * @return the resolved File object, or null if no configuration was found
   * @throws IOException if an explicit configuration file is missing or malformed
   */
  @Nullable
  static File resolveCertificateConfigFile(
      EnvironmentProvider envProvider, PropertyProvider propProvider, String certConfigPathOverride)
      throws IOException {
    // 1. Check explicit developer override
    if (certConfigPathOverride != null) {
      File certConfigFile = new File(certConfigPathOverride);
      if (!certConfigFile.isFile()) {
        throw new CertificateSourceUnavailableException(
            "Certificate configuration file does not exist or is not a file: "
                + certConfigFile.getAbsolutePath());
      }
      return certConfigFile;
    }

    // 2. Check explicit environment variable
    String envPath = envProvider.getEnv(CERTIFICATE_CONFIGURATION_ENV_VARIABLE);
    if (!Strings.isNullOrEmpty(envPath)) {
      File certConfigFile = new File(envPath);
      if (!certConfigFile.isFile()) {
        throw new CertificateSourceUnavailableException(
            "Certificate configuration file does not exist or is not a file: "
                + certConfigFile.getAbsolutePath());
      }
      return certConfigFile;
    }

    // 3. Check optional well-known automatic provisioning location
    try {
      File wellKnownConfig = getWellKnownCertificateConfigFile(envProvider, propProvider);
      if (wellKnownConfig.isFile()) {
        return wellKnownConfig;
      }
    } catch (IOException e) {
      LOGGER.info(
          "Could not get the mutual TLS (mTLS) client certificate configuration. The library will fall back to making standard non-mTLS requests.");
    }

    return null;
  }

  /**
   * Returns the current mutual TLS endpoint usage policy.
   *
   * @param envProvider the environment provider to use for resolving environment variables
   * @return the MtlsEndpointUsagePolicy enum value
   */
  public static MtlsEndpointUsagePolicy getMtlsEndpointUsagePolicy(
      EnvironmentProvider envProvider) {
    String mtlsEndpointUsagePolicy = envProvider.getEnv("GOOGLE_API_USE_MTLS_ENDPOINT");
    if ("never".equalsIgnoreCase(mtlsEndpointUsagePolicy)) {
      return MtlsEndpointUsagePolicy.NEVER;
    } else if ("always".equalsIgnoreCase(mtlsEndpointUsagePolicy)) {
      return MtlsEndpointUsagePolicy.ALWAYS;
    }
    return MtlsEndpointUsagePolicy.AUTO;
  }

  /**
   * Prepares and upgrades the HTTP transport factory for mutual TLS (mTLS) if applicable.
   *
   * @param baseTransportFactory the base HTTP transport factory to upgrade
   * @param envProvider the environment provider to use for resolving environment variables
   * @param propProvider the property provider to use for resolving system properties
   * @param certConfigPathOverride optional override path for the configuration file
   * @return the mTLS-configured HTTP transport factory, or the base factory if mTLS is not enabled
   * @throws IOException if mTLS is required/enabled but certificate initialization fails or an
   *     incompatible transport factory was provided
   */
  public static HttpTransportFactory prepareTransportFactoryIfMtlsEnabled(
      HttpTransportFactory baseTransportFactory,
      EnvironmentProvider envProvider,
      PropertyProvider propProvider,
      String certConfigPathOverride)
      throws IOException {

    if (baseTransportFactory == null) {
      return null;
    }

    if (baseTransportFactory instanceof MtlsHttpTransportFactory) {
      // A custom MtlsHttpTransportFactory was already pre-configured by the user.
      // Keep using it as-is without re-initializing.
      return baseTransportFactory;
    }

    if (!canBeEnabled(envProvider, propProvider, certConfigPathOverride)) {
      return baseTransportFactory;
    }

    if (baseTransportFactory != OAuth2Utils.HTTP_TRANSPORT_FACTORY) {
      // A user configured non-mTLS HttpTransportFactory was explicitly injected.
      // Reject it to avoid bypassing mTLS enforcement or overriding the user's factory.
      throw new IOException(
          "mTLS is enabled on the system, but a user configured non-mTLS HttpTransportFactory was provided: "
              + baseTransportFactory.getClass().getName());
    }

    MtlsEndpointUsagePolicy mtlsPolicy = getMtlsEndpointUsagePolicy(envProvider);
    try {
      // This is the default HttpTransportFactory assigned by credentials.
      // Automatically discover and load client certificates to construct an mTLS factory.
      X509Provider x509Provider =
          new X509Provider(envProvider, propProvider, certConfigPathOverride);
      KeyStore mtlsKeyStore = x509Provider.getKeyStore();
      return new MtlsHttpTransportFactory(mtlsKeyStore);
    } catch (Exception e) {
      if (mtlsPolicy == MtlsEndpointUsagePolicy.ALWAYS) {
        throw new IOException(
            "mTLS is configured to ALWAYS, but initialization failed: " + e.getMessage(), e);
      }
      // Graceful fallback to standard transport if mTLS initialization fails under AUTO policy
      return baseTransportFactory;
    }
  }
}
