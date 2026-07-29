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
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/** Utility class for Agent Identity token binding in Cloud Run. */
@InternalApi
public final class AgentIdentityUtils {

    /** Logger for this utility class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AgentIdentityUtils.class);

    // Environment variables
    /** Environment variable for overriding the certificate configuration path. */
    static final String GOOGLE_API_CERTIFICATE_CONFIG = "GOOGLE_API_CERTIFICATE_CONFIG";

    /** Environment variable for disabling token binding. */
    static final String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES =
            "GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES";

    /** Allowed SPIFFE trust domain patterns for agent identity. */
    private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =
            ImmutableList.of(
                    Pattern.compile("^agents\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
                    Pattern.compile("^agents\\.global\\.proj-\\d+\\.system\\.id\\.goog$"));

    /** Subject Alternative Name (SAN) type for URIs. */
    private static final int SAN_URI_TYPE = 6;

    /** Prefix for SPIFFE URIs. */
    private static final String SPIFFE_SCHEME_PREFIX = "spiffe://";

    /** Default well-known directory for spiffe credentials. */
    private static String wellKnownDir = "/var/run/secrets/workload-spiffe-credentials/";

    /**
     * Sets the well known directory for testing.
     *
     * @param dir the directory path
     */
    @VisibleForTesting
    static void setWellKnownDir(final String dir) {
        wellKnownDir = dir;
    }

    // Polling configuration
    /** Number of retries when checking for matching certificate and key. */
    private static final int CERT_KEY_MATCH_RETRIES = 3;

    /** Backoff interval for certificate matching retries. */
    private static final long CERT_KEY_MATCH_RETRY_INTERVAL_MS = 100;

    /** Number of fast polling cycles to use when fetching certs. */
    private static final int FAST_POLL_CYCLES = 50;

    /** Interval for fast polling cycles. */
    private static final long FAST_POLL_INTERVAL_MS = 100; // 0.1 seconds

    /** Interval for slow polling cycles. */
    private static final long SLOW_POLL_INTERVAL_MS = 500; // 0.5 seconds

    /** Total timeout across polling routines. */
    private static final long TOTAL_TIMEOUT_MS = 30000; // 30 seconds

    private static final List<Long> POLLING_INTERVALS;

    static {
        List<Long> intervals = new ArrayList<>();
        for (int i = 0; i < FAST_POLL_CYCLES; i++) {
            intervals.add(FAST_POLL_INTERVAL_MS);
        }
        long remainingTime = TOTAL_TIMEOUT_MS - (FAST_POLL_CYCLES * FAST_POLL_INTERVAL_MS);
        int slowPollCycles = (int) (remainingTime / SLOW_POLL_INTERVAL_MS);
        for (int i = 0; i < slowPollCycles; i++) {
            intervals.add(SLOW_POLL_INTERVAL_MS);
        }
        POLLING_INTERVALS = Collections.unmodifiableList(intervals);
    }

    public interface EnvReader {
        /**
         * Gets an environment variable by name.
         *
         * @param name the environment variable name
         * @return the value of the environment variable
         */
        String getEnv(final String name);
    }

    /** Reader for environment variables. */
    private static EnvReader envReader = System::getenv;

    @VisibleForTesting
    interface TimeService {
        long currentTimeMillis();

        /**
         * Suspends execution for the specified duration.
         *
         * @param millis the duration in milliseconds
         * @throws InterruptedException if any thread has interrupted the current thread
         */
        void sleep(final long millis) throws InterruptedException;
    }

    /** Service providing standard time and sleep operations. */
    private static TimeService timeService =
            new TimeService() {
                @Override
                public long currentTimeMillis() {
                    return System.currentTimeMillis();
                }

                @Override
                public void sleep(final long millis) throws InterruptedException {
                    Thread.sleep(millis);
                }
            };

    private AgentIdentityUtils() {}

    static class CertInfo {
        /** The parsed X.509 certificate. */
        private final X509Certificate certificate;

        /** The raw content of the certificate. */
        private final String certContent;

        CertInfo(final X509Certificate certificate, final String certContent) {
            this.certificate = certificate;
            this.certContent = certContent;
        }

        /**
         * Returns the certificate.
         *
         * @return the parsed X.509 certificate
         */
        public X509Certificate getCertificate() {
            return certificate;
        }

        /**
         * Returns the internal certificate content string.
         *
         * @return the raw content of the certificate
         */
        public String getCertContent() {
            return certContent;
        }
    }

    static class ResolvedCertAndKeyPaths {
        /** The resolved path to the certificate. */
        private final String certPath;

        /** The resolved path to the private key. */
        private final String keyPath;

        ResolvedCertAndKeyPaths(final String certPath, final String keyPath) {
            this.certPath = certPath;
            this.keyPath = keyPath;
        }

        /**
         * Returns the resolved path to the certificate.
         *
         * @return the actual path for the certificate on disk
         */
        public String getCertPath() {
            return certPath;
        }

        /**
         * Returns the resolved path to the private key.
         *
         * @return the actual path for the private key on disk
         */
        public String getKeyPath() {
            return keyPath;
        }
    }

    /**
     * Retrieves the certificate and path for the Agent Identity.
     *
     * <p>This method attempts to load the certificate and private key for the agent identity. It
     * first checks the location specified by the {@code GOOGLE_API_CERTIFICATE_CONFIG} environment
     * variable. If not set, it falls back to well-known default locations.
     *
     * <p>To handle transient race conditions during certificate rotation on disk, this method
     * employs a retry mechanism with backoff when reading the configuration and certificate files.
     *
     * @return A {@link CertInfo} object containing the loaded certificate and its path, or {@code
     *     null} if the agent identity features are disabled, opted out, or if no valid credentials
     *     could be loaded.
     * @throws IOException If an I/O error occurs while reading the files, or if the key-pair
     *     verification fails after retries.
     */
    static CertInfo getAgentIdentityCertInfo() throws IOException {
        if (!isTokenBindingEnabled()) {
            return null;
        }
        String certConfigPath = envReader.getEnv(GOOGLE_API_CERTIFICATE_CONFIG);
        boolean configExists =
                !Strings.isNullOrEmpty(certConfigPath) && Files.exists(Paths.get(certConfigPath));

        ResolvedCertAndKeyPaths paths = resolveCertAndKeyPaths(certConfigPath);
        boolean certsPresent = !Strings.isNullOrEmpty(paths.getCertPath());

        if (!shouldEnableMtls(certsPresent, configExists)) {
            return null;
        }

        return loadAndVerifyCredentials(paths.getCertPath(), paths.getKeyPath());
    }

    /**
     * Resolves the paths for the certificate and private key based on the config path or well-known
     * locations.
     *
     * @param certConfigPath the custom configuration path, if specified
     * @return the resolved certificate and key paths
     * @throws IOException if extracting from the configuration file encounters an error
     */
    static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(final String certConfigPath)
            throws IOException {
        String certPath = null;
        String keyPath = null;

        if (!Strings.isNullOrEmpty(certConfigPath)) {
            java.nio.file.Path configPath = Paths.get(certConfigPath);
            if (!Files.exists(configPath) && !Files.exists(Paths.get(wellKnownDir))) {
                // Fail-fast if config doesn't exist and we are not in a workload environment
                return new ResolvedCertAndKeyPaths(null, null);
            }
            // Read cert and key paths from config file. We use retry with backoff to handle
            // transient
            // race conditions where the config file might be being updated by a rotation process.
            ResolvedCertAndKeyPaths paths = getPathsFromConfigWithRetry(certConfigPath);
            if (paths != null) {
                certPath = paths.getCertPath();
                keyPath = paths.getKeyPath();
            }
        } else {
            if (!Files.exists(Paths.get(wellKnownDir))) {
                // Fail-fast if well-known dir doesn't exist (e.g. workstation)
                return new ResolvedCertAndKeyPaths(null, null);
            }
            // Fallback to well-known locations. We use retry with backoff here as well to handle
            // race conditions during file replacement by a rotation process.
            certPath = getWellKnownCertificatePathWithRetry();
            if (certPath != null) {
                if (certPath.endsWith("credentialbundle.pem")) {
                    keyPath = certPath; // Bundle contains both
                } else if (certPath.endsWith("certificates.pem")) {
                    keyPath = Paths.get(wellKnownDir, "private_key.pem").toString();
                }
            }
        }
        return new ResolvedCertAndKeyPaths(certPath, keyPath);
    }

    /**
     * Loads the certificate and private key, and verifies that they match if they are separate
     * files.
     *
     * @param certPath the path to the certificate
     * @param keyPath the path to the private key file
     * @return parsed CertInfo containing the certificate and plaintext content, or null if unbound
     * @throws IOException in case of a read or parse error
     */
    static CertInfo loadAndVerifyCredentials(final String certPath, final String keyPath) throws IOException {
        X509Certificate cert = null;
        PrivateKey privateKey = null;
        String certContent = null;

        if (!Strings.isNullOrEmpty(certPath)
                && !Strings.isNullOrEmpty(keyPath)
                && !certPath.equals(keyPath)
                && Files.exists(Paths.get(keyPath))) {
            // Separate files, verify match with retry
            int retries = 0;
            boolean matched = false;
            while (retries < CERT_KEY_MATCH_RETRIES) {
                try {
                    certContent = readCertificateChain(certPath);
                    cert = parseCertificateContent(certContent);
                    privateKey = readPrivateKey(keyPath, cert.getPublicKey().getAlgorithm());

                    if (verifyKeyPair(cert, privateKey)) {
                        matched = true;
                        break;
                    }
                    LOGGER.warn("Cert and key mismatch, retrying...");
                } catch (java.nio.file.AccessDeniedException e) {
                    Slf4jUtils.log(
                            LOGGER,
                            org.slf4j.event.Level.WARN,
                            Collections.emptyMap(),
                            "Permission denied reading certificate or key files. Falling back to"
                                + " unbound token.");
                    return null;
                } catch (Exception e) {
                    LOGGER.warn("Failed to read or verify cert/key, retrying...", e);
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

            if (!matched) {
                throw new IOException(
                        String.format(
                                "Agent Identity certificate and private key mismatch or read"
                                    + " failure after %d retries.",
                                CERT_KEY_MATCH_RETRIES));
            }
        } else if (!Strings.isNullOrEmpty(certPath)) {
            // Bundle or only cert available
            try {
                certContent = readCertificateChain(certPath);
                cert = parseCertificateContent(certContent);
            } catch (java.nio.file.AccessDeniedException e) {
                Slf4jUtils.log(
                        LOGGER,
                        org.slf4j.event.Level.WARN,
                        Collections.emptyMap(),
                        "Permission denied reading certificate files. Falling back to unbound"
                            + " token.");
                return null;
            }
        }

        return new CertInfo(cert, certContent);
    }

    /**
     * Checks if a file exists, throwing AccessDeniedException if permission is denied.
     *
     * @param path the file path to verify
     * @return true if the file exists and is accessible, false otherwise
     * @throws java.nio.file.AccessDeniedException if permission is denied when accessing the file
     */
    private static boolean checkExistsOrAccessDenied(final java.nio.file.Path path)
            throws java.nio.file.AccessDeniedException {
        try {
            Files.readAttributes(path, java.nio.file.attribute.BasicFileAttributes.class);
            return true;
        } catch (java.nio.file.AccessDeniedException e) {
            throw e;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Checks if the user has disabled token binding by setting the environment variable to false.
     *
     * @return true unless binding was explicitly disabled via environment configuration
     */
    private static boolean isTokenBindingEnabled() {
        String preventSharing = envReader.getEnv(GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES);
        return !("false".equalsIgnoreCase(preventSharing));
    }

    /**
     * Reads the certificate path from the config file with retry logic to handle rotation race
     * conditions.
     *
     * @param certConfigPath the path to the certificate configuration file to read from
     * @return the paths loaded and found from the config
     * @throws IOException if config cannot be parsed or certificate files remain missing after retries
     */
    private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(final String certConfigPath)
            throws IOException {
        boolean warned = false;
        for (long sleepInterval : POLLING_INTERVALS) {
            try {
                if (checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
                    ResolvedCertAndKeyPaths paths = extractPathsFromConfig(certConfigPath);
                    if (paths != null
                            && !Strings.isNullOrEmpty(paths.getCertPath())
                            && checkExistsOrAccessDenied(Paths.get(paths.getCertPath()))) {
                        return paths;
                    }
                }
            } catch (java.nio.file.AccessDeniedException e) {
                Slf4jUtils.log(
                        LOGGER,
                        org.slf4j.event.Level.WARN,
                        Collections.emptyMap(),
                        "Permission denied reading certificate config file. Falling back to unbound"
                            + " token.");
                return null;
            } catch (IOException e) {
                // Fall through to retry
            }
            if (!warned) {
                Slf4jUtils.log(
                        LOGGER,
                        org.slf4j.event.Level.WARN,
                        Collections.emptyMap(),
                        String.format(
                                "Certificate config file not found or invalid at %s (from %s"
                                    + " environment variable). Retrying for up to %d seconds.",
                                certConfigPath,
                                GOOGLE_API_CERTIFICATE_CONFIG,
                                TOTAL_TIMEOUT_MS / 1000));
                warned = true;
            }
            try {
                timeService.sleep(sleepInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException(
                        "Interrupted while waiting for Agent Identity certificate files for bound"
                            + " token request.",
                        e);
            }
        }
        throw new IOException(
                "Unable to find Agent Identity certificate config or file for bound token request"
                    + " after multiple retries. Token binding protection is failing. You can turn"
                    + " off this protection by setting "
                        + GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES
                        + " to false to fall back to unbound tokens.");
    }

    /**
     * Searches for certificates at well-known locations with retry logic.
     *
     * @return the well-known certificate path resolving to a file
     * @throws IOException if certificate files cannot be found after multiple retries
     */
    private static String getWellKnownCertificatePathWithRetry() throws IOException {
        String bundlePath = Paths.get(wellKnownDir, "credentialbundle.pem").toString();
        String certOnlyPath = Paths.get(wellKnownDir, "certificates.pem").toString();

        boolean warned = false;
        for (long sleepInterval : POLLING_INTERVALS) {
            try {
                if (checkExistsOrAccessDenied(Paths.get(bundlePath))) {
                    return bundlePath;
                }
                if (checkExistsOrAccessDenied(Paths.get(certOnlyPath))) {
                    return certOnlyPath;
                }
            } catch (java.nio.file.AccessDeniedException e) {
                Slf4jUtils.log(
                        LOGGER,
                        org.slf4j.event.Level.WARN,
                        Collections.emptyMap(),
                        "Permission denied reading well-known certificates. Falling back to unbound"
                            + " token.");
                return null;
            } catch (Exception e) {
                // Fall through to retry
            }
            if (!warned) {
                Slf4jUtils.log(
                        LOGGER,
                        org.slf4j.event.Level.WARN,
                        Collections.emptyMap(),
                        String.format(
                                "Well-known certificate file not found at %s. Retrying for up to %d"
                                    + " seconds.",
                                wellKnownDir, TOTAL_TIMEOUT_MS / 1000));
                warned = true;
            }
            try {
                timeService.sleep(sleepInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException(
                        "Interrupted while waiting for well-known certificate files.", e);
            }
        }
        throw new IOException(
                "Unable to find well-known certificate file for bound token request after multiple"
                        + " retries.");
    }

    /**
     * Reads the full certificate chain from the specified path as a string.
     *
     * @param certPath the path to read
     * @return the complete file contents as a UTF-8 string
     * @throws IOException if the file encounters a read error
     */
    static String readCertificateChain(final String certPath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(certPath)), StandardCharsets.UTF_8);
    }

    /**
     * Verifies that the private key corresponds to the public key in the certificate by performing
     * a test signature and verification.
     *
     * @param cert the loaded certificate with the public key
     * @param privateKey the private key to test against the public component
     * @return true if the private key properly belongs to the presented public certificate
     */
    static boolean verifyKeyPair(final X509Certificate cert, final PrivateKey privateKey) {
        try {
            byte[] data = "verification-data".getBytes(StandardCharsets.UTF_8);

            String keyAlgorithm = cert.getPublicKey().getAlgorithm();
            String sigAlg;
            if ("RSA".equals(keyAlgorithm)) {
                sigAlg = "SHA256withRSA";
            } else if ("EC".equals(keyAlgorithm)) {
                sigAlg = "SHA256withECDSA";
            } else {
                throw new IllegalArgumentException("Unsupported key algorithm: " + keyAlgorithm);
            }

            Signature signer = Signature.getInstance(sigAlg);
            signer.initSign(privateKey);
            signer.update(data);
            byte[] signature = signer.sign();

            Signature verifier = Signature.getInstance(sigAlg);
            verifier.initVerify(cert.getPublicKey());
            verifier.update(data);

            return verifier.verify(signature);
        } catch (Exception e) {
            LOGGER.warn("Key pair verification failed", e);
            return false;
        }
    }

    /**
     * Reads the private key from the specified path using PKCS8 format.
     *
     * @param keyPath the path location to fetch the key
     * @param algorithm the key's algorithm such as RSA or EC
     * @return the parsed PrivateKey object
     * @throws IOException if parsing PKCS8 encounters a formatting or reading issue
     */
    static PrivateKey readPrivateKey(final String keyPath, final String algorithm) throws IOException {
        String keyPem = new String(Files.readAllBytes(Paths.get(keyPath)), StandardCharsets.UTF_8);
        OAuth2Utils.Pkcs8Algorithm pkcs8Alg =
                "EC".equals(algorithm)
                        ? OAuth2Utils.Pkcs8Algorithm.EC
                        : OAuth2Utils.Pkcs8Algorithm.RSA;
        return OAuth2Utils.privateKeyFromPkcs8(keyPem, pkcs8Alg);
    }

    /**
     * Determines if mTLS should be enabled based on environment variables and certificate presence.
     *
     * @param certsPresent indicates if certificates were already materialized on disk
     * @param configExists indicates if a configuration path pointer was available
     * @return true if token bound operations are approved via environment configuration
     * @throws IOException if intents mismatch (explicit approval but missing files)
     */
    static boolean shouldEnableMtls(final boolean certsPresent, final boolean configExists) throws IOException {
        String useClientCert = envReader.getEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE");

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
        // Case 2: Explicitly disabled via environment variable
        else if ("false".equalsIgnoreCase(useClientCert)) {
            if (certsPresent) {
                // Warn that we are ignoring present certs because it was explicitly disabled
                Slf4jUtils.log(
                        LOGGER,
                        org.slf4j.event.Level.WARN,
                        Collections.emptyMap(),
                        "Token binding protection is disabled because mTLS was explicitly disabled"
                            + " via GOOGLE_API_USE_CLIENT_CERTIFICATE.");
                return false;
            }
            return false;
        }
        // Case 3: Environment variable is unset
        else {
            if (certsPresent) {
                // Infer mTLS is enabled because certs are present
                return true;
            }
            if (configExists) {
                // Config exists but files are missing - fail fast
                throw new IOException(
                        "Certificate intent inferred via config, but cert files are missing.");
            }
            // Neither cert-config nor certs exist, do not enable
            return false;
        }
    }

    /**
     * Retrieves the bound token payload (certificate chain) if applicable.
     *
     * @return the retrieved certificate and bounds string, or null if binding conditions are unmet
     * @throws IOException if loading Agent Identity constraints fails
     */
    static String getBoundTokenPayload() throws IOException {
        CertInfo info = getAgentIdentityCertInfo();
        if (info != null && shouldRequestBoundToken(info.getCertificate())) {
            return info.getCertContent();
        }
        return null;
    }

    /**
     * Extracts the certificate and private key paths from the JSON configuration file.
     *
     * @param certConfigPath the configuration file path intended to be parsed
     * @return an object encapsulating resolved paths mapped from the definition
     * @throws IOException if parsing JSON mapping encounters structural errors
     */
    @SuppressWarnings("unchecked")
    private static ResolvedCertAndKeyPaths extractPathsFromConfig(final String certConfigPath)
            throws IOException {
        try (InputStream stream = Files.newInputStream(Paths.get(certConfigPath))) {
            JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
            GenericJson config =
                    parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);
            Object certConfigsObj = config.get("cert_configs");
            if (certConfigsObj instanceof Map) {
                Map certConfigs = (Map) certConfigsObj;
                Object workloadObj = certConfigs.get("workload");
                if (workloadObj instanceof Map) {
                    Map workload = (Map) workloadObj;
                    String certPath = null;
                    String keyPath = null;
                    if (workload.get("cert_path") instanceof String) {
                        certPath = (String) workload.get("cert_path");
                    }
                    if (workload.get("key_path") instanceof String) {
                        keyPath = (String) workload.get("key_path");
                    }
                    return new ResolvedCertAndKeyPaths(certPath, keyPath);
                }
            }
        } catch (java.nio.file.AccessDeniedException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException("Failed to parse Agent Identity config JSON", e);
        }
        return null;
    }

    /**
     * Parses the X509 certificate from the specified content string.
     *
     * @param certContent raw certificate string representing the X509 stream
     * @return parsed resulting X509Certificate equivalent
     * @throws IOException if certificate generation from the standard factory fails
     */
    private static X509Certificate parseCertificateContent(final String certContent) throws IOException {
        try (InputStream stream =
                new java.io.ByteArrayInputStream(certContent.getBytes(StandardCharsets.UTF_8))) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509Certificate) cf.generateCertificate(stream);
        } catch (GeneralSecurityException e) {
            throw new IOException(
                    "Failed to parse Agent Identity certificate for bound token request.", e);
        }
    }

    /**
     * Determines if a bound token should be requested by checking if any of the certificate's
     * Subject Alternative Names (SANs) match allowed SPIFFE patterns.
     *
     * @param cert the loaded leaf certificate referencing SAN details
     * @return true if bindings dictate compliance with a verified SPIFFE pattern
     */
    static boolean shouldRequestBoundToken(final X509Certificate cert) {
        try {
            Collection<List<?>> sans = cert.getSubjectAlternativeNames();
            if (sans == null) {
                return false;
            }
            // Iterate through all Subject Alternative Names
            for (List<?> san : sans) {
                // Check if the SAN entry is a URI (type 6)
                if (san.size() >= 2
                        && san.get(0) instanceof Integer
                        && (Integer) san.get(0) == SAN_URI_TYPE) {
                    Object value = san.get(1);
                    if (value instanceof String) {
                        String uri = (String) value;
                        // Check if the URI starts with "spiffe://"
                        if (uri.startsWith(SPIFFE_SCHEME_PREFIX)) {
                            String withoutScheme = uri.substring(SPIFFE_SCHEME_PREFIX.length());
                            int slashIndex = withoutScheme.indexOf('/');
                            // Extract the trust domain (part before the first slash)
                            String trustDomain =
                                    (slashIndex == -1)
                                            ? withoutScheme
                                            : withoutScheme.substring(0, slashIndex);
                            // Match the trust domain against allowed agent patterns
                            for (Pattern pattern : AGENT_IDENTITY_SPIFFE_PATTERNS) {
                                if (pattern.matcher(trustDomain).matches()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (CertificateParsingException e) {
            LOGGER.warn("Failed to parse Subject Alternative Names from certificate", e);
        }
        return false;
    }

    /**
     * Sets the env reader for testing.
     *
     * @param reader the environment reader
     */
    @VisibleForTesting
    public static void setEnvReader(final EnvReader reader) {
        envReader = reader;
    }

    /**
     * Sets the time service for testing.
     *
     * @param service the time service
     */
    @VisibleForTesting
    static void setTimeService(final TimeService service) {
        timeService = service;
    }

    /**
     * Resets the time service.
     */
    @VisibleForTesting
    static void resetTimeService() {
        timeService =
                new TimeService() {
                    @Override
                    public long currentTimeMillis() {
                        return System.currentTimeMillis();
                    }

                    @Override
                    public void sleep(final long millis) throws InterruptedException {
                        Thread.sleep(millis);
                    }
                };
    }
}
