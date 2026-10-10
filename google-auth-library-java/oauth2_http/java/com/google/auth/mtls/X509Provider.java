/*
 * Copyright 2025 Google LLC
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
import com.google.auth.oauth2.SystemEnvironmentProvider;
import com.google.auth.oauth2.SystemPropertyProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.security.KeyStore;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * This class implements {@link MtlsProvider} for the Google Auth library transport layer via {@link
 * WorkloadCertificateConfiguration}.
 */
@NullMarked
@InternalApi
public class X509Provider implements MtlsProvider {
  private final EnvironmentProvider envProvider;
  private final PropertyProvider propProvider;
  private final @Nullable String certConfigPathOverride;
  private final boolean allowGkeCredentialBundle;

  /**
   * Creates an X509 provider with an override path for the certificate configuration, bypassing the
   * normal checks for the well known certificate configuration file path and environment variable.
   * This is meant for internal Google Cloud usage and behavior may be changed without warning.
   *
   * @param envProvider environment provider used for environment variables
   * @param propProvider property provider used for system properties
   * @param certConfigPathOverride the path to read the certificate configuration from.
   */
  @InternalApi
  public X509Provider(
      EnvironmentProvider envProvider,
      PropertyProvider propProvider,
      String certConfigPathOverride) {
    this(envProvider, propProvider, certConfigPathOverride, false);
  }

  /**
   * Creates an X509 provider that optionally falls back to the GKE credential bundle when no
   * certificate configuration is present.
   *
   * @param envProvider environment provider used for environment variables
   * @param propProvider property provider used for system properties
   * @param certConfigPathOverride the path to read the certificate configuration from.
   * @param allowGkeCredentialBundle whether to fall back to the GKE credential bundle when no
   *     certificate configuration is present and {@code certConfigPathOverride} is null.
   */
  X509Provider(
      EnvironmentProvider envProvider,
      PropertyProvider propProvider,
      @Nullable String certConfigPathOverride,
      boolean allowGkeCredentialBundle) {
    this.envProvider = envProvider;
    this.propProvider = propProvider;
    this.certConfigPathOverride = certConfigPathOverride;
    this.allowGkeCredentialBundle = allowGkeCredentialBundle;
  }

  /**
   * Creates an X.509 provider for the client transport layer. In addition to the locations checked
   * by {@link #X509Provider()}, it falls back to the GKE credential bundle when no certificate
   * configuration is present, so that the transport uses the same certificate that {@link
   * MtlsUtils#getWorkloadCertPath} reports for certificate-bound tokens.
   */
  static X509Provider createForTransport() {
    return new X509Provider(
        SystemEnvironmentProvider.getInstance(), SystemPropertyProvider.getInstance(), null, true);
  }

  /**
   * Creates an X509 provider with an override path for the certificate configuration.
   *
   * @param certConfigPathOverride the path to read the certificate configuration from.
   */
  public X509Provider(@Nullable String certConfigPathOverride) {
    this(
        SystemEnvironmentProvider.getInstance(),
        SystemPropertyProvider.getInstance(),
        certConfigPathOverride);
  }

  /**
   * Creates a new X.509 provider that will check the environment variable path and the well known
   * Gcloud certificate configuration location. This is meant for internal Google Cloud usage and
   * behavior may be changed without warning.
   */
  public X509Provider() {
    this(null);
  }

  /**
   * Finds the certificate configuration file, then builds a Keystore using the X.509 certificate
   * and private key pointed to by the configuration. This will check the following locations in
   * order.
   *
   * <ul>
   *   <li>The certificate config override path, if set.
   *   <li>The path pointed to by the "GOOGLE_API_CERTIFICATE_CONFIG" environment variable
   *   <li>The well known gcloud location for the certificate configuration file.
   *   <li>If none of the above is configured or present, and this provider was created with {@link
   *       #createForTransport()}, the GKE credential bundle at {@code
   *       /var/run/secrets/workload-spiffe-credentials/x509.credential-bundle.private-key.pem},
   *       which contains both the certificate chain and the private key.
   * </ul>
   *
   * @return a KeyStore containing the X.509 certificate chain and private key from the certificate
   *     source above.
   * @throws CertificateSourceUnavailableException if the certificate source is unavailable (ex.
   *     missing configuration file)
   * @throws IOException if a general I/O error occurs while creating the KeyStore
   */
  @Override
  public KeyStore getKeyStore() throws CertificateSourceUnavailableException, IOException {
    if (allowGkeCredentialBundle && certConfigPathOverride == null) {
      String gkeCredentialBundlePath =
          MtlsUtils.getGkeCredentialBundlePath(envProvider, propProvider);
      if (gkeCredentialBundlePath != null) {
        try (InputStream bundleStream = new FileInputStream(new File(gkeCredentialBundlePath))) {
          return MtlsKeyStoreUtils.createMtlsKeyStore(bundleStream);
        } catch (FileNotFoundException e) {
          // The bundle was removed (e.g. mid-rotation) after the availability check.
          throw new CertificateSourceUnavailableException(
              "GKE credential bundle is no longer available: " + gkeCredentialBundlePath, e);
        } catch (Exception e) {
          throw new IOException(
              "X509Provider: Unable to load GKE credential bundle: " + gkeCredentialBundlePath, e);
        }
      }
    }

    WorkloadCertificateConfiguration workloadCertConfig =
        MtlsUtils.getWorkloadCertificateConfiguration(
            envProvider, propProvider, certConfigPathOverride);

    // Read the certificate and private key file paths into streams.
    try (InputStream certStream = new FileInputStream(new File(workloadCertConfig.getCertPath()));
        InputStream privateKeyStream =
            new FileInputStream(new File(workloadCertConfig.getPrivateKeyPath()));
        SequenceInputStream certAndPrivateKeyStream =
            new SequenceInputStream(certStream, privateKeyStream)) {

      // Build a key store using the combined stream.
      return MtlsKeyStoreUtils.createMtlsKeyStore(certAndPrivateKeyStream);
    } catch (CertificateSourceUnavailableException e) {
      // Throw the CertificateSourceUnavailableException without wrapping.
      throw e;
    } catch (Exception e) {
      // Wrap all other exception types to an IOException.
      throw new IOException("X509Provider: Unexpected IOException:", e);
    }
  }

  /**
   * Returns true if the X509 mTLS provider is available.
   *
   * @throws IOException if a general I/O error occurs while determining availability.
   */
  @Override
  public boolean isAvailable() throws IOException {
    try {
      this.getKeyStore();
    } catch (CertificateSourceUnavailableException e) {
      return false;
    }
    return true;
  }
}
