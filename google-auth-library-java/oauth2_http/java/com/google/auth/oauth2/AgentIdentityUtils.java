package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for Agent Identity token binding in Cloud Run.
 */
class AgentIdentityUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(AgentIdentityUtils.class);

  // Environment variables
  static final String GOOGLE_API_CERTIFICATE_CONFIG = "GOOGLE_API_CERTIFICATE_CONFIG";
  static final String GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES =
      "GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES";

  private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =
      ImmutableList.of(
          Pattern.compile("^agents\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents\\.global\\.proj-\\d+\\.system\\.id\\.goog$"));

  private static final int SAN_URI_TYPE = 6;
  private static final String SPIFFE_SCHEME_PREFIX = "spiffe://";

  // Polling configuration
  private static final int FAST_POLL_CYCLES = 50;
  private static final long FAST_POLL_INTERVAL_MS = 100; // 0.1 seconds
  private static final long SLOW_POLL_INTERVAL_MS = 500; // 0.5 seconds
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

  interface EnvReader {
    String getEnv(String name);
  }

  private static EnvReader envReader = System::getenv;

  @VisibleForTesting
  interface TimeService {
    long currentTimeMillis();
    void sleep(long millis) throws InterruptedException;
  }

  private static TimeService timeService =
      new TimeService() {
        @Override
        public long currentTimeMillis() {
          return System.currentTimeMillis();
        }

        @Override
        public void sleep(long millis) throws InterruptedException {
          Thread.sleep(millis);
        }
      };

  private AgentIdentityUtils() {}

  static X509Certificate getAgentIdentityCertificate() throws IOException {
    if (isOptedOut()) {
      return null;
    }
    String certConfigPath = envReader.getEnv(GOOGLE_API_CERTIFICATE_CONFIG);
    if (Strings.isNullOrEmpty(certConfigPath)) {
      return null;
    }
    String certPath = getCertificatePathWithRetry(certConfigPath);
    return parseCertificate(certPath);
  }

  private static boolean isOptedOut() {
    String optOut = envReader.getEnv(GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES);
    return "false".equalsIgnoreCase(optOut);
  }

  private static String getCertificatePathWithRetry(String certConfigPath) throws IOException {
    boolean warned = false;
    for (long sleepInterval : POLLING_INTERVALS) {
      try {
        if (Files.exists(Paths.get(certConfigPath))) {
          String certPath = extractCertPathFromConfig(certConfigPath);
          if (!Strings.isNullOrEmpty(certPath) && Files.exists(Paths.get(certPath))) {
            return certPath;
          }
        }
      } catch (IOException e) {
        // Fall through to retry
      }
      if (!warned) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            String.format(
                "Certificate config file not found at %s (from %s environment variable). Retrying for up to %d seconds.",
                certConfigPath, GOOGLE_API_CERTIFICATE_CONFIG, TOTAL_TIMEOUT_MS / 1000));
        warned = true;
      }
      try {
        timeService.sleep(sleepInterval);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException(
            "Interrupted while waiting for Agent Identity certificate files for bound token request.",
            e);
      }
    }
    throw new IOException(
        "Unable to find Agent Identity certificate config or file for bound token request after multiple retries. Token binding protection is failing. You can turn off this protection by setting "
            + GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES
            + " to false to fall back to unbound tokens.");
  }

  @SuppressWarnings("unchecked")
  private static String extractCertPathFromConfig(String certConfigPath) throws IOException {
    try (InputStream stream = new FileInputStream(certConfigPath)) {
      JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
      GenericJson config = parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);
      Map certConfigs = (Map) config.get("cert_configs");
      if (certConfigs != null) {
        Map workload = (Map) certConfigs.get("workload");
        if (workload != null) {
          return (String) workload.get("cert_path");
        }
      }
    }
    return null;
  }

  private static X509Certificate parseCertificate(String certPath) throws IOException {
    try (InputStream stream = new FileInputStream(certPath)) {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      return (X509Certificate) cf.generateCertificate(stream);
    } catch (GeneralSecurityException e) {
      throw new IOException(
          "Failed to parse Agent Identity certificate for bound token request.", e);
    }
  }

  static boolean shouldRequestBoundToken(X509Certificate cert) {
    try {
      Collection<List<?>> sans = cert.getSubjectAlternativeNames();
      if (sans == null) {
        return false;
      }
      for (List<?> san : sans) {
        if (san.size() >= 2
            && san.get(0) instanceof Integer
            && (Integer) san.get(0) == SAN_URI_TYPE) {
          Object value = san.get(1);
          if (value instanceof String) {
            String uri = (String) value;
            if (uri.startsWith(SPIFFE_SCHEME_PREFIX)) {
              String withoutScheme = uri.substring(SPIFFE_SCHEME_PREFIX.length());
              int slashIndex = withoutScheme.indexOf('/');
              String trustDomain =
                  (slashIndex == -1) ? withoutScheme : withoutScheme.substring(0, slashIndex);
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

  static String calculateCertificateFingerprint(X509Certificate cert) throws IOException {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] der = cert.getEncoded();
      md.update(der);
      byte[] digest = md.digest();
      String base64Fingerprint = BaseEncoding.base64().omitPadding().encode(digest);
      return URLEncoder.encode(base64Fingerprint, "UTF-8");
    } catch (GeneralSecurityException e) {
      throw new IOException("Failed to calculate fingerprint for Agent Identity certificate.", e);
    }
  }

  @VisibleForTesting
  static void setEnvReader(EnvReader reader) {
    envReader = reader;
  }

  @VisibleForTesting
  static void setTimeService(TimeService service) {
    timeService = service;
  }

  @VisibleForTesting
  static void resetTimeService() {
    timeService =
        new TimeService() {
          @Override
          public long currentTimeMillis() {
            return System.currentTimeMillis();
          }

          @Override
          public void sleep(long millis) throws InterruptedException {
            Thread.sleep(millis);
          }
        };
  }
}
