/*
 * Copyright 2026, Google Inc. All rights reserved.
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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.auth.mtls.MtlsUtils;
import com.google.auth.oauth2.AgentIdentityCacheUtils.CachedAgentIdentityInfo;
import com.google.auth.oauth2.AgentIdentityCacheUtils.FileMetadata;
import com.google.auth.oauth2.AgentIdentityCertificateValidationUtils.InvalidCertificateException;
import com.google.auth.oauth2.AgentIdentityCertificateValidationUtils.UnsupportedKeyAlgorithmException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** Utility class for Agent Identity runtime certificate discovery and token binding. */
@NullMarked
final class AgentIdentityUtils {

  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(AgentIdentityUtils.class);

  /**
   * Environment variable pointing to the client certificate configuration file.
   *
   * <p>If set, certificate and key paths are resolved from the configuration file specified by this
   * variable.
   */
  static final String GOOGLE_API_CERTIFICATE_CONFIG = "GOOGLE_API_CERTIFICATE_CONFIG";

  /**
   * Environment variable to explicitly enable or disable runtime token binding. Defaults to true if
   * unset.
   */
  static final String GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN =
      "GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN";

  /**
   * Legacy Cloud Run environment variable to prevent agent token sharing for GCP services. Used as
   * a fallback if {@link #GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN} is unset.
   */
  static final String GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES =
      "GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES";

  /**
   * Environment variable to explicitly enable or disable client certificate authentication (mTLS).
   *
   * <p>When set to {@code "true"}, mTLS is enforced. When set to any other non-empty value (such as
   * {@code "false"}), mTLS and token binding are disabled.
   */
  static final String GOOGLE_API_USE_CLIENT_CERTIFICATE = "GOOGLE_API_USE_CLIENT_CERTIFICATE";

  private static volatile String wellKnownDir = "/var/run/secrets/workload-spiffe-credentials/";

  /**
   * File name of the combined certificate chain and private key bundle that GKE delivers to the
   * well-known directory for pods with Agent Identity (Pod Certificates).
   *
   * <p>When {@link #GOOGLE_API_CERTIFICATE_CONFIG} is unset and no well-known gcloud certificate
   * configuration file exists, the presence of this bundle establishes mTLS intent on its own (no
   * {@link #GOOGLE_API_USE_CLIENT_CERTIFICATE} required). It is never polled for, because GKE
   * delivers it before the container starts and polling on its absence would delay every workload
   * without Agent Identity. It must be a readable, non-empty file. When present and allowed, it
   * takes precedence over the other well-known files, matching the certificate the transport
   * presents.
   */
  static final String GKE_CREDENTIAL_BUNDLE_FILE = "x509.credential-bundle.private-key.pem";

  // Retries for verifying certificate and private key matching during atomic key rotation.
  private static final int CERT_KEY_MATCH_RETRIES = 3;

  private static final long CERT_KEY_MATCH_RETRY_INTERVAL_MS = 100;

  // Polling configuration for initial container startup credential file readiness.
  // Matches Python google-auth implementation (_agent_identity_utils.py) for initial
  // asynchronous credential delivery (50 * 100ms + 50 * 500ms = 30 seconds total).
  private static final int FAST_POLL_CYCLES = 50;

  private static final long FAST_POLL_INTERVAL_MS = 100; // 0.1 seconds

  private static final long SLOW_POLL_INTERVAL_MS = 500; // 0.5 seconds

  private static final long TOTAL_TIMEOUT_MS = 30000; // 30 seconds

  private static final int TOTAL_POLL_CYCLES =
      FAST_POLL_CYCLES
          + (int)
              ((TOTAL_TIMEOUT_MS - (FAST_POLL_CYCLES * FAST_POLL_INTERVAL_MS))
                  / SLOW_POLL_INTERVAL_MS);

  private static volatile EnvironmentProvider environmentProvider =
      SystemEnvironmentProvider.getInstance();

  private static volatile PropertyProvider propertyProvider = SystemPropertyProvider.getInstance();

  private static volatile TimeService timeService = Thread::sleep;

  // Tracks whether initial container startup discovery has completed. The 30-second
  // polling loop (TOTAL_POLL_CYCLES) is strictly limited to initial startup so subsequent
  // token refreshes never block for 30 seconds.
  private static volatile boolean initialStartupCompleted = false;

  // Tracks whether the FINE-level message for explicitly disabled mTLS when certificates are
  // present has already been logged in this process to prevent log spam on repeated token
  // refreshes.
  private static volatile boolean mtlsDisabledLogged = false;

  // Tracks whether mTLS has already been evaluated as explicitly disabled via
  // GOOGLE_API_USE_CLIENT_CERTIFICATE, so later refreshes skip re-reading the config from disk.
  private static volatile boolean mtlsDisabledEvaluated = false;

  private AgentIdentityUtils() {}

  @VisibleForTesting
  @FunctionalInterface
  interface TimeService {
    /**
     * Causes the currently executing thread to sleep for the specified number of milliseconds.
     *
     * @param millis the length of time to sleep in milliseconds
     * @throws InterruptedException if interrupted while sleeping
     */
    void sleep(final long millis) throws InterruptedException;
  }

  /**
   * Holds the parsed {@link X509Certificate} and cached PEM certificate chain content for token
   * binding.
   *
   * <p>This class intentionally stores in-memory certificate content rather than file paths to
   * prevent redundant filesystem reads and race conditions when binding tokens to requests.
   */
  static class CertInfo {
    private final X509Certificate certificate;
    private final String certContent;

    CertInfo(final X509Certificate certificate, final String certContent) {
      this.certificate = certificate;
      this.certContent = certContent;
    }

    /** Returns the parsed {@link X509Certificate}. */
    X509Certificate getCertificate() {
      return certificate;
    }

    /** Returns the raw PEM certificate chain content. */
    String getCertContent() {
      return certContent;
    }
  }

  /** Holds the resolved filesystem paths for the certificate and private key. */
  private static final class ResolvedCertAndKeyPaths {
    private final @Nullable String certPath;
    private final @Nullable String keyPath;
    private final boolean hasWorkloadConfig;
    private final @Nullable FileMetadata configMetadata;

    ResolvedCertAndKeyPaths(
        final @Nullable String certPath,
        final @Nullable String keyPath,
        final boolean hasWorkloadConfig) {
      this(certPath, keyPath, hasWorkloadConfig, null);
    }

    ResolvedCertAndKeyPaths(
        final @Nullable String certPath,
        final @Nullable String keyPath,
        final boolean hasWorkloadConfig,
        final @Nullable FileMetadata configMetadata) {
      this.certPath = certPath;
      this.keyPath = keyPath;
      this.hasWorkloadConfig = hasWorkloadConfig;
      this.configMetadata = configMetadata;
    }

    /** Returns the path to the certificate or bundle file. */
    @Nullable String getCertPath() {
      return certPath;
    }

    /** Returns the path to the private key file, or bundle path if combined. */
    @Nullable String getKeyPath() {
      return keyPath;
    }

    /** Returns whether a workload configuration was parsed from the certificate config file. */
    boolean hasWorkloadConfig() {
      return hasWorkloadConfig;
    }

    /** Returns the filesystem metadata of the config file when it was parsed, or null. */
    @Nullable FileMetadata getConfigMetadata() {
      return configMetadata;
    }
  }

  /**
   * Thrown when a workload configuration block is present in the certificate config file but is
   * missing {@code cert_path} or {@code key_path}, so callers fail fast without polling.
   */
  private static final class IncompleteWorkloadConfigException extends IOException {
    private static final long serialVersionUID = 1L;

    IncompleteWorkloadConfigException(final String message) {
      super(message);
    }
  }

  private static long getSleepIntervalMs(final int cycle) {
    return (cycle < FAST_POLL_CYCLES) ? FAST_POLL_INTERVAL_MS : SLOW_POLL_INTERVAL_MS;
  }

  private static @Nullable String getTrimmedEnv(final String name) {
    String val = environmentProvider.getEnv(name);
    return val != null ? val.trim() : null;
  }

  /**
   * Reads the trimmed {@link #GOOGLE_API_USE_CLIENT_CERTIFICATE} value from {@link
   * #environmentProvider}. Queried via {@code environmentProvider} rather than cached in a {@code
   * static final} field so test overrides via {@link #setEnvironmentProvider} take effect.
   */
  private static @Nullable String getUseClientCertificateEnv() {
    return getTrimmedEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE);
  }

  /**
   * Returns {@code true} if {@link #GOOGLE_API_USE_CLIENT_CERTIFICATE} is set to {@code "true"}
   * (case-insensitive).
   */
  private static boolean isMtlsExplicitlyEnabled() {
    return "true".equalsIgnoreCase(getUseClientCertificateEnv());
  }

  /**
   * Returns {@code true} if {@link #GOOGLE_API_USE_CLIENT_CERTIFICATE} is set to a non-empty value
   * other than {@code "true"} (case-insensitive).
   */
  private static boolean isMtlsExplicitlyDisabled() {
    String useClientCert = getUseClientCertificateEnv();
    return !Strings.isNullOrEmpty(useClientCert) && !"true".equalsIgnoreCase(useClientCert);
  }

  /** Checks whether the given path resides within the well-known certificate directory. */
  private static boolean isPathInWellKnownDir(final @Nullable String pathStr) {
    if (Strings.isNullOrEmpty(pathStr)) {
      return false;
    }
    try {
      Path path = Paths.get(pathStr).toAbsolutePath().normalize();
      Path wellKnown = Paths.get(wellKnownDir).toAbsolutePath().normalize();
      return path.startsWith(wellKnown);
    } catch (Exception e) {
      return false;
    }
  }

  /** Returns the path of the GKE credential bundle in the well-known directory. */
  private static String getGkeCredentialBundlePath() {
    return Paths.get(wellKnownDir, GKE_CREDENTIAL_BUNDLE_FILE).toString();
  }

  /** Returns {@code true} if {@code path} is the GKE credential bundle in the well-known dir. */
  private static boolean isGkeCredentialBundle(final @Nullable String path) {
    return path != null && getGkeCredentialBundlePath().equals(path);
  }

  /**
   * Returns {@code true} if the GKE credential bundle is a readable, non-empty regular file.
   * Mirrors the readiness check the transport uses (see {@link MtlsUtils#getWorkloadCertPath}).
   */
  private static boolean isGkeCredentialBundleReady(final String path) {
    Path bundle = Paths.get(path);
    try {
      return Files.isRegularFile(bundle) && Files.isReadable(bundle) && Files.size(bundle) > 0;
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * Returns {@code true} if the GKE credential bundle may be used: no well-known gcloud certificate
   * configuration file exists (it would otherwise be the transport's mTLS certificate source, see
   * {@link MtlsUtils#hasCertificateConfiguration}). Callers only reach this when {@link
   * #GOOGLE_API_CERTIFICATE_CONFIG} is unset.
   */
  private static boolean isGkeCredentialBundleAllowed() {
    return !MtlsUtils.hasCertificateConfiguration(environmentProvider, propertyProvider);
  }

  /**
   * Returns whether mTLS intent is established for resolved certificate paths: either they came
   * from a workload certificate config, or they point at the GKE credential bundle (whose presence
   * establishes intent on its own).
   */
  private static boolean isMtlsIntentEstablished(
      final boolean hasWorkloadConfig, final @Nullable String certPath) {
    return hasWorkloadConfig || isGkeCredentialBundle(certPath);
  }

  /**
   * Retrieves the certificate and raw PEM content for the Agent Identity.
   *
   * <p>This method attempts to load the certificate and private key for the agent identity. It
   * first checks the location specified by the {@code GOOGLE_API_CERTIFICATE_CONFIG} environment
   * variable. If not set, it falls back to well-known default locations.
   *
   * <p>To handle transient race conditions during certificate rotation on disk, this method employs
   * a retry mechanism with backoff when reading the configuration and certificate files. Note that
   * callers such as {@link ComputeEngineCredentials#refreshAccessToken()} invoke this method via
   * {@link #getBoundTokenPayload()} under {@link OAuth2Credentials}'s token refresh coalescing,
   * which already serializes concurrent token refreshes to mitigate thundering herd contention.
   *
   * @return A {@link CertInfo} object containing the parsed {@link X509Certificate} and its raw PEM
   *     chain content, or {@code null} if the agent identity features are disabled, opted out, or
   *     if no valid credentials could be loaded.
   * @throws IOException If an I/O error occurs while reading the files, or if the key-pair
   *     verification fails after retries.
   */
  static @Nullable CertInfo getAgentIdentityCertInfo() throws IOException {
    if (!isTokenBindingEnabled()) {
      return null;
    }
    if (mtlsDisabledEvaluated && isMtlsExplicitlyDisabled()) {
      return null;
    }
    CachedAgentIdentityInfo initialCached = AgentIdentityCacheUtils.getCachedAgentIdentityInfo();
    String certConfigPath = getTrimmedEnv(GOOGLE_API_CERTIFICATE_CONFIG);

    // Fast-path: check cached info and file metadata before parsing JSON config or paths
    if (initialCached != null
        && AgentIdentityCacheUtils.isCachedInfoValid(initialCached, certConfigPath)) {
      if (!initialCached.shouldRequestBoundToken) {
        return null;
      }
      // isCachedInfoValid() verified that the cached certificate file still exists on disk with
      // matching metadata, so certsPresent is guaranteed to be true here.
      if (!shouldEnableMtls(
          /* certsPresent= */ true,
          /* configExists= */ isMtlsIntentEstablished(
              initialCached.configMetadata != null, initialCached.certMetadata.getPath()))) {
        return null;
      }
      return initialCached.certInfo;
    }

    ResolvedCertAndKeyPaths paths = resolveCertAndKeyPaths(certConfigPath, initialCached);
    boolean configExists = isMtlsIntentEstablished(paths.hasWorkloadConfig(), paths.getCertPath());
    boolean certsPresent = !Strings.isNullOrEmpty(paths.getCertPath());

    if (!shouldEnableMtls(certsPresent, configExists)) {
      if (isMtlsExplicitlyDisabled()) {
        mtlsDisabledEvaluated = true;
      }
      return null;
    }

    return loadAndVerifyCredentials(
        paths.getCertPath(), paths.getKeyPath(), paths.getConfigMetadata(), initialCached);
  }

  /**
   * Resolves the paths for the certificate and private key based on the config path or well-known
   * locations.
   */
  private static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(
      final @Nullable String certConfigPath, final @Nullable CachedAgentIdentityInfo cached)
      throws IOException {
    if (!Strings.isNullOrEmpty(certConfigPath)) {
      // Read cert and key paths from config file. We use retry with backoff to handle
      // startup delivery (when in well-known directory) and transient rotation race conditions.
      return getPathsFromConfigWithRetry(certConfigPath, cached);
    }
    // Fallback to well-known locations. We use retry with backoff here as well to handle
    // startup delivery (when explicit mTLS is enabled) and race conditions during file
    // replacement by a rotation process.
    return getWellKnownCertificatePathWithRetry(cached);
  }

  /**
   * Loads the certificate and private key, and verifies that they form a valid cryptographic
   * key-pair, supporting both separate files and combined bundle files.
   *
   * <p>Checks {@link AgentIdentityCertificateValidationUtils#shouldRequestBoundToken} right after
   * parsing the certificate content before reading the private key or running signature
   * verification. Caches verified results in memory so unchanged files are not re-read and
   * re-verified on every token refresh.
   *
   * @param certPath The path to the certificate or bundle file.
   * @param keyPath The path to the private key or bundle file.
   * @return A {@link CertInfo} object containing the parsed {@link X509Certificate} and the raw PEM
   *     certificate chain (with private keys stripped), or {@code null} if the certificate does not
   *     match agent SPIFFE patterns.
   * @throws IOException If the files cannot be read or parsed, or if key-pair verification fails
   *     after retries.
   */
  static @Nullable CertInfo loadAndVerifyCredentials(
      final @Nullable String certPath, final @Nullable String keyPath) throws IOException {
    return loadAndVerifyCredentials(
        certPath, keyPath, null, AgentIdentityCacheUtils.getCachedAgentIdentityInfo());
  }

  private static @Nullable CertInfo loadAndVerifyCredentials(
      final @Nullable String certPath,
      final @Nullable String keyPath,
      final @Nullable FileMetadata configMetaBefore,
      final @Nullable CachedAgentIdentityInfo initialCached)
      throws IOException {
    if (Strings.isNullOrEmpty(certPath)) {
      return null;
    }

    // Even when isCachedInfoValid() in getAgentIdentityCertInfo() returned false, the cache can
    // still match here in three cases:
    // 1. The config file was deleted after caching while the cert/key files on disk remain
    //    unchanged (getPathsFromConfigWithRetry fell back to cached paths + configMetadata).
    // 2. Another thread completed rotation and updated the cache while this thread was resolving
    //    paths in resolveCertAndKeyPaths().
    // 3. Package-private loadAndVerifyCredentials(certPath, keyPath) was invoked directly.
    CachedAgentIdentityInfo cached = AgentIdentityCacheUtils.getLatestOrInitialCache(initialCached);
    if (AgentIdentityCacheUtils.isPostResolutionCacheHit(
        cached, certPath, keyPath, configMetaBefore)) {
      return cached.shouldRequestBoundToken ? cached.certInfo : null;
    }

    Exception lastException = null;
    int retries = 0;
    while (retries < CERT_KEY_MATCH_RETRIES) {
      try {
        FileMetadata certMeta = FileMetadata.of(certPath);
        String certContent = AgentIdentityCertificateValidationUtils.readCertificateChain(certPath);
        X509Certificate cert =
            AgentIdentityCertificateValidationUtils.parseCertificateContent(certContent);

        if (!AgentIdentityCertificateValidationUtils.shouldRequestBoundToken(cert)) {
          if (AgentIdentityCacheUtils.tryUpdateCache(
              configMetaBefore, certMeta, null, false, null)) {
            return null;
          }
          lastException = new IOException("Certificate file modified during read.");
        } else {
          FileMetadata keyMeta = FileMetadata.of(keyPath);
          PrivateKey privateKey =
              AgentIdentityCertificateValidationUtils.readPrivateKey(
                  keyPath, cert.getPublicKey().getAlgorithm());

          if (AgentIdentityCertificateValidationUtils.verifyKeyPair(cert, privateKey)) {
            CertInfo info = new CertInfo(cert, certContent);
            if (AgentIdentityCacheUtils.tryUpdateCache(
                configMetaBefore, certMeta, keyMeta, true, info)) {
              return info;
            }
            lastException = new IOException("Certificate or key file modified during read.");
            LoggingUtils.log(
                LOGGER_PROVIDER,
                Level.FINE,
                Collections.emptyMap(),
                "Cert or key file modified during read, retrying...");
          } else {
            lastException = new IOException("Certificate and private key do not match.");
            LoggingUtils.log(
                LOGGER_PROVIDER,
                Level.FINE,
                Collections.emptyMap(),
                "Cert and key mismatch, retrying...");
          }
        }
      } catch (AccessDeniedException e) {
        throw new IOException(
            "Permission denied reading certificate or key files for Agent Identity.", e);
      } catch (UnsupportedKeyAlgorithmException | InvalidCertificateException e) {
        throw e;
      } catch (Exception e) {
        lastException = e;
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.FINE,
            Collections.emptyMap(),
            "Failed to read or verify cert/key, retrying: " + e.getMessage());
      }

      retries++;
      if (retries < CERT_KEY_MATCH_RETRIES) {
        try {
          timeService.sleep(CERT_KEY_MATCH_RETRY_INTERVAL_MS); // 0.1 seconds backoff
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IOException("Interrupted while waiting for cert/key match.", e);
        }
      }
    }

    // If files were transiently missing, unreadable, or mid-rotation (lastException != null)
    // and we already have a verified credential cached in memory, fall back to cached credentials
    // rather than failing or caching an unbound token. Re-read cachedAgentIdentityInfo in case
    // another thread completed rotation while this thread was sleeping.
    CachedAgentIdentityInfo fallbackCached =
        AgentIdentityCacheUtils.getLatestOrInitialCache(initialCached);
    if (lastException != null
        && fallbackCached != null
        && fallbackCached.shouldRequestBoundToken
        && fallbackCached.certInfo != null) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.FINE,
          Collections.emptyMap(),
          "Agent Identity certificate/key files transiently unavailable during rotation; falling"
              + " back to cached credentials.");
      return fallbackCached.certInfo;
    }

    throw new GoogleAuthException(
        true,
        CERT_KEY_MATCH_RETRIES,
        String.format(
            "Agent Identity certificate and private key mismatch or read"
                + " failure after %d attempts.",
            CERT_KEY_MATCH_RETRIES),
        lastException);
  }

  /**
   * Checks if runtime token binding is enabled.
   *
   * <p>Checks {@link #GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN} first; if unset, falls back to the
   * legacy {@link #GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES}. Defaults to {@code
   * true} if neither is set.
   */
  private static boolean isTokenBindingEnabled() {
    String enableRuntimeBoundToken = getTrimmedEnv(GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN);
    if (!Strings.isNullOrEmpty(enableRuntimeBoundToken)) {
      return !"false".equalsIgnoreCase(enableRuntimeBoundToken);
    }
    String legacyPreventSharing =
        getTrimmedEnv(GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES);
    if (!Strings.isNullOrEmpty(legacyPreventSharing)) {
      return !"false".equalsIgnoreCase(legacyPreventSharing);
    }
    return true;
  }

  /**
   * Reads the certificate path from the config file with retry logic to handle startup delivery and
   * rotation race conditions.
   */
  private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(
      final String certConfigPath, final @Nullable CachedAgentIdentityInfo initialCached)
      throws IOException {
    if (isMtlsExplicitlyDisabled()) {
      try {
        if (AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
          ResolvedCertAndKeyPaths paths = extractPathsFromConfig(certConfigPath);
          if (paths.hasWorkloadConfig() && Files.exists(Paths.get(paths.getCertPath()))) {
            return paths;
          }
        }
      } catch (Exception ignored) {
        // Do not fail when mTLS is explicitly disabled
      }
      return new ResolvedCertAndKeyPaths(null, null, false);
    }

    boolean inWellKnownDir = isPathInWellKnownDir(certConfigPath);
    boolean shouldPoll = !initialStartupCompleted && inWellKnownDir;
    int maxCycles = shouldPoll ? TOTAL_POLL_CYCLES : 1;
    boolean warned = false;
    IOException lastParseException = null;

    for (int cycle = 0; cycle < maxCycles; cycle++) {
      try {
        if (AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
          ResolvedCertAndKeyPaths paths = extractPathsFromConfig(certConfigPath);
          if (!paths.hasWorkloadConfig()) {
            // Valid non-workload config (e.g. enterprise certs) - exit early without polling!
            initialStartupCompleted = true;
            return paths;
          }
          // The config file itself may reside outside wellKnownDir while referencing cert_path or
          // key_path inside wellKnownDir that are still being delivered at startup.
          if (!initialStartupCompleted
              && !shouldPoll
              && (isPathInWellKnownDir(paths.getCertPath())
                  || isPathInWellKnownDir(paths.getKeyPath()))) {
            shouldPoll = true;
            maxCycles = TOTAL_POLL_CYCLES;
          }
          boolean certReady =
              AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(paths.getCertPath()));
          boolean keyReady =
              AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(paths.getKeyPath()));
          if (certReady && keyReady) {
            initialStartupCompleted = true;
            return paths;
          }
        }
      } catch (AccessDeniedException e) {
        String failedFile = e.getFile() != null ? e.getFile() : certConfigPath;
        throw new IOException(
            "Permission denied reading certificate config file: " + failedFile, e);
      } catch (IncompleteWorkloadConfigException e) {
        // Incomplete workload config (missing cert_path or key_path) will not become ready via
        // startup polling; break out of the polling loop immediately so initial startup throws
        // without waiting 30s (or falls back to a previously cached config in steady state).
        lastParseException = e;
        break;
      } catch (IOException e) {
        CachedAgentIdentityInfo latestCached =
            AgentIdentityCacheUtils.getLatestOrInitialCache(initialCached);
        if (!shouldPoll && cycle + 1 >= maxCycles && latestCached == null) {
          initialStartupCompleted = true;
          throw e; // Fail fast on malformed JSON syntax errors when not polling
        }
        lastParseException = e;
        // When polling is active, fall through to retry (handles partial/empty JSON during startup)
      }
      if (cycle + 1 < maxCycles) {
        if (shouldPoll && !warned) {
          LoggingUtils.log(
              LOGGER_PROVIDER,
              Level.FINE,
              Collections.emptyMap(),
              String.format(
                  "Agent Identity certificate config or referenced credential files not yet ready"
                      + " at %s (from %s environment variable). Retrying for up to %d seconds.",
                  certConfigPath, GOOGLE_API_CERTIFICATE_CONFIG, TOTAL_TIMEOUT_MS / 1000));
          warned = true;
        }
        try {
          timeService.sleep(getSleepIntervalMs(cycle));
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IOException(
              "Interrupted while waiting for Agent Identity certificate files for bound"
                  + " token request.",
              e);
        }
      }
    }
    initialStartupCompleted = true;

    CachedAgentIdentityInfo fallbackCached =
        AgentIdentityCacheUtils.getLatestOrInitialCache(initialCached);
    if (fallbackCached != null
        && fallbackCached.configMetadata != null
        && fallbackCached.certMetadata != null
        && fallbackCached.keyMetadata != null) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.FINE,
          Collections.emptyMap(),
          String.format(
              "Agent Identity certificate config at %s is unavailable; falling back to cached"
                  + " certificate and key paths.",
              certConfigPath));
      return new ResolvedCertAndKeyPaths(
          fallbackCached.certMetadata.getPath(),
          fallbackCached.keyMetadata.getPath(),
          true,
          fallbackCached.configMetadata);
    }

    throw new IOException(
        "Unable to find Agent Identity certificate config or file for bound token request"
            + " after multiple retries. Token binding protection is failing. You can turn"
            + " off this protection by setting "
            + GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN
            + " to false to fall back to unbound tokens.",
        lastParseException);
  }

  /** Searches for certificates at well-known locations with retry logic. */
  private static ResolvedCertAndKeyPaths getWellKnownCertificatePathWithRetry(
      final @Nullable CachedAgentIdentityInfo initialCached) throws IOException {
    if (!isMtlsExplicitlyEnabled()) {
      // Without a config file (configExists == false), mTLS is only enabled when
      // GOOGLE_API_USE_CLIENT_CERTIFICATE is explicitly "true", or, when it is unset, implicitly by
      // the presence of the GKE credential bundle.
      initialStartupCompleted = true;
      if (isMtlsExplicitlyDisabled()) {
        return new ResolvedCertAndKeyPaths(null, null, false);
      }
      return getGkeCredentialBundlePathIfPresent(initialCached);
    }

    // The GKE bundle is checked once, without polling, and before the other well-known files: when
    // allowed, it is the certificate the transport presents for mTLS (see
    // MtlsUtils#getWorkloadCertPath).
    String gkeBundlePath = getGkeCredentialBundlePath();
    if (isGkeCredentialBundleAllowed() && isGkeCredentialBundleReady(gkeBundlePath)) {
      initialStartupCompleted = true;
      // GKE combined bundle file contains both certificate chain and private key
      return new ResolvedCertAndKeyPaths(gkeBundlePath, gkeBundlePath, false);
    }

    String bundlePath = Paths.get(wellKnownDir, "credentialbundle.pem").toString();
    String certOnlyPath = Paths.get(wellKnownDir, "certificates.pem").toString();
    String keyOnlyPath = Paths.get(wellKnownDir, "private_key.pem").toString();

    boolean shouldPoll = !initialStartupCompleted;
    int maxCycles = shouldPoll ? TOTAL_POLL_CYCLES : 1;

    boolean warned = false;
    for (int cycle = 0; cycle < maxCycles; cycle++) {
      try {
        if (AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(bundlePath))) {
          initialStartupCompleted = true;
          // Combined bundle file contains both certificate chain and private key
          return new ResolvedCertAndKeyPaths(bundlePath, bundlePath, false);
        }
        if (AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(certOnlyPath))
            && AgentIdentityCacheUtils.checkExistsOrAccessDenied(Paths.get(keyOnlyPath))) {
          initialStartupCompleted = true;
          return new ResolvedCertAndKeyPaths(certOnlyPath, keyOnlyPath, false);
        }
      } catch (AccessDeniedException e) {
        initialStartupCompleted = true;
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.FINE,
            Collections.emptyMap(),
            "Permission denied reading well-known certificates. Falling back to unbound token.");
        return new ResolvedCertAndKeyPaths(null, null, false);
      } catch (Exception e) {
        // Fall through to retry
      }

      if (cycle + 1 < maxCycles) {
        if (shouldPoll && !warned) {
          LoggingUtils.log(
              LOGGER_PROVIDER,
              Level.FINE,
              Collections.emptyMap(),
              String.format(
                  "Well-known certificate file not found at %s. Retrying for up to %d seconds.",
                  wellKnownDir, TOTAL_TIMEOUT_MS / 1000));
          warned = true;
        }
        try {
          timeService.sleep(getSleepIntervalMs(cycle));
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IOException("Interrupted while waiting for well-known certificate files.", e);
        }
      }
    }
    initialStartupCompleted = true;

    CachedAgentIdentityInfo fallbackCached =
        AgentIdentityCacheUtils.getLatestOrInitialCache(initialCached);
    if (fallbackCached != null
        && fallbackCached.configMetadata == null
        && fallbackCached.certMetadata != null
        && fallbackCached.keyMetadata != null) {
      return new ResolvedCertAndKeyPaths(
          fallbackCached.certMetadata.getPath(), fallbackCached.keyMetadata.getPath(), false);
    }

    throw new IOException(
        String.format(
            "Unable to find well-known Agent Identity certificate file at %s for bound token"
                + " request. Token binding protection is failing. You can turn off this"
                + " protection by setting %s to false to fall back to unbound tokens.",
            wellKnownDir, GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN));
  }

  /**
   * Implicit GKE discovery used when {@link #GOOGLE_API_CERTIFICATE_CONFIG} and {@link
   * #GOOGLE_API_USE_CLIENT_CERTIFICATE} are both unset: returns the GKE credential bundle as both
   * certificate and key if it is a readable, non-empty file and no well-known gcloud certificate
   * configuration file exists. Checked once without polling (see {@link
   * #GKE_CREDENTIAL_BUNDLE_FILE}).
   *
   * <p>The readability and precedence rules mirror {@link MtlsUtils#getWorkloadCertPath}, so tokens
   * are only bound to the GKE certificate when the transport also uses it for mTLS. If the bundle
   * is transiently unavailable (e.g. mid-rotation) after a GKE credential was cached, the cached
   * paths are returned so {@link #loadAndVerifyCredentials} can fall back to the cached credential.
   */
  private static ResolvedCertAndKeyPaths getGkeCredentialBundlePathIfPresent(
      final @Nullable CachedAgentIdentityInfo initialCached) {
    String gkeBundlePath = getGkeCredentialBundlePath();
    if (isGkeCredentialBundleReady(gkeBundlePath)) {
      return isGkeCredentialBundleAllowed()
          ? new ResolvedCertAndKeyPaths(gkeBundlePath, gkeBundlePath, false)
          : new ResolvedCertAndKeyPaths(null, null, false);
    }
    CachedAgentIdentityInfo fallbackCached =
        AgentIdentityCacheUtils.getLatestOrInitialCache(initialCached);
    if (fallbackCached != null
        && fallbackCached.configMetadata == null
        && fallbackCached.certMetadata != null
        && fallbackCached.keyMetadata != null
        && isGkeCredentialBundle(fallbackCached.certMetadata.getPath())) {
      return new ResolvedCertAndKeyPaths(
          fallbackCached.certMetadata.getPath(), fallbackCached.keyMetadata.getPath(), false);
    }
    return new ResolvedCertAndKeyPaths(null, null, false);
  }

  /**
   * Determines if mTLS should be enabled based on environment variables and certificate presence.
   *
   * <p>Note that {@code configExists} is required even when {@code certsPresent} is {@code true}:
   * when {@code GOOGLE_API_USE_CLIENT_CERTIFICATE} is unset (Case 3), mTLS is only inferred if a
   * workload config exists ({@code configExists == true}), whereas when {@code
   * GOOGLE_API_USE_CLIENT_CERTIFICATE="true"} (Case 1), mTLS is enabled whenever {@code
   * certsPresent == true} even from the well-known directory ({@code configExists == false}).
   *
   * <p>Callers pass {@code configExists == true} for the GKE credential bundle as well (see {@link
   * #GKE_CREDENTIAL_BUNDLE_FILE}), since its presence establishes mTLS intent on its own.
   */
  static boolean shouldEnableMtls(final boolean certsPresent, final boolean configExists)
      throws IOException {
    String useClientCert = getUseClientCertificateEnv();

    // Case 1: Explicitly enabled via environment variable
    if ("true".equalsIgnoreCase(useClientCert)) {
      if (certsPresent) {
        // Certs are available, enable mTLS
        return true;
      }
      if (configExists) {
        // Config exists but files are missing - fail fast
        throw new IOException(
            "Certificate intent established via config, but cert files are missing.");
      }
      // Neither exist, do not enable
      return false;
    }
    // Case 2: Explicitly disabled via environment variable (any non-empty value other than "true")
    else if (!Strings.isNullOrEmpty(useClientCert)) {
      if (certsPresent && !mtlsDisabledLogged) {
        mtlsDisabledLogged = true;
        // Log that we are ignoring present certs because it was explicitly disabled
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.FINE,
            Collections.emptyMap(),
            "Token binding protection is disabled because mTLS was explicitly disabled"
                + " via GOOGLE_API_USE_CLIENT_CERTIFICATE.");
      }
      return false;
    }
    // Case 3: Environment variable is unset
    else {
      if (configExists) {
        if (certsPresent) {
          // Infer mTLS is enabled because workload config and certs are present
          return true;
        }
        // Config exists but files are missing - fail fast
        throw new IOException(
            "Certificate intent inferred via config, but cert files are missing.");
      }
      // No workload config to infer mTLS from, do not enable
      return false;
    }
  }

  /** Retrieves the bound token payload (certificate chain) if applicable. */
  static @Nullable String getBoundTokenPayload() throws IOException {
    CertInfo info = getAgentIdentityCertInfo();
    return info != null ? info.getCertContent() : null;
  }

  /** Extracts the certificate and private key paths from the JSON configuration file. */
  private static ResolvedCertAndKeyPaths extractPathsFromConfig(final String certConfigPath)
      throws IOException {
    try {
      FileMetadata configMetadata = FileMetadata.of(certConfigPath);
      try (InputStream stream = Files.newInputStream(Paths.get(certConfigPath))) {
        JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
        GenericJson config =
            parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);
        Object certConfigsObj = config.get("cert_configs");
        if (certConfigsObj instanceof Map<?, ?>) {
          Map<?, ?> certConfigs = (Map<?, ?>) certConfigsObj;
          Object workloadObj = certConfigs.get("workload");
          if (workloadObj instanceof Map<?, ?>) {
            Map<?, ?> workload = (Map<?, ?>) workloadObj;
            String certPath =
                workload.get("cert_path") instanceof String
                    ? (String) workload.get("cert_path")
                    : null;
            String keyPath =
                workload.get("key_path") instanceof String
                    ? (String) workload.get("key_path")
                    : null;
            if (Strings.isNullOrEmpty(certPath) || Strings.isNullOrEmpty(keyPath)) {
              throw new IncompleteWorkloadConfigException(
                  "Workload certificate config is missing cert_path or key_path.");
            }
            return new ResolvedCertAndKeyPaths(certPath, keyPath, true, configMetadata);
          }
        }
        return new ResolvedCertAndKeyPaths(null, null, false, configMetadata);
      }
    } catch (AccessDeniedException | IncompleteWorkloadConfigException e) {
      throw e;
    } catch (Exception e) {
      throw new IOException("Failed to parse Agent Identity config JSON", e);
    }
  }

  /** Resets all static state and overrides for testing. */
  @VisibleForTesting
  static void resetForTest() {
    wellKnownDir = "/var/run/secrets/workload-spiffe-credentials/";
    environmentProvider = SystemEnvironmentProvider.getInstance();
    propertyProvider = SystemPropertyProvider.getInstance();
    timeService = Thread::sleep;
    resetCachedState();
  }

  private static void resetCachedState() {
    AgentIdentityCacheUtils.clearCachedAgentIdentityInfo();
    initialStartupCompleted = false;
    mtlsDisabledLogged = false;
    mtlsDisabledEvaluated = false;
  }

  /** Returns the current well-known certificate directory path. */
  static String getWellKnownDir() {
    return wellKnownDir;
  }

  /** Sets the well-known certificate directory path for testing. */
  @VisibleForTesting
  static void setWellKnownDir(final String dir) {
    wellKnownDir = dir;
    resetCachedState();
  }

  /** Sets the environment variable provider for testing. */
  @VisibleForTesting
  static void setEnvironmentProvider(final EnvironmentProvider provider) {
    environmentProvider = provider;
    resetCachedState();
  }

  /**
   * Sets the system property provider for testing. Used to resolve the well-known gcloud
   * certificate configuration file location.
   */
  @VisibleForTesting
  static void setPropertyProvider(final PropertyProvider provider) {
    propertyProvider = provider;
    resetCachedState();
  }

  /** Sets the time and sleep service for testing. */
  @VisibleForTesting
  static void setTimeService(final TimeService service) {
    timeService = service;
    resetCachedState();
  }

  /** Returns whether the message for explicitly disabled mTLS has been logged. */
  @VisibleForTesting
  static boolean isMtlsDisabledLogged() {
    return mtlsDisabledLogged;
  }
}
