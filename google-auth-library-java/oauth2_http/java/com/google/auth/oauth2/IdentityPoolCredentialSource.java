/*
 * Copyright 2023 Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

import static com.google.common.base.Preconditions.checkArgument;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * The IdentityPool credential source. Dictates the retrieval method of the external credential,
 * which can either be through a metadata server or a local file.
 */
public class IdentityPoolCredentialSource extends ExternalAccountCredentials.CredentialSource {

  private static final long serialVersionUID = -745855247050085694L;
  IdentityPoolCredentialSourceType credentialSourceType;
  CredentialFormatType credentialFormatType;
  private String credentialLocation;
  @Nullable String subjectTokenFieldName;
  @Nullable Map<String, String> headers;
  @Nullable private CertificateConfig certificateConfig;

  /**
   * Gets the location of the credential source. This could be a file path or a URL, depending on
   * the {@link IdentityPoolCredentialSourceType}.
   *
   * @return The location of the credential source.
   */
  public String getCredentialLocation() {
    return credentialLocation;
  }

  /**
   * Sets the location of the credential source. This method should be used to update the credential
   * location.
   *
   * @param credentialLocation The new location of the credential source.
   */
  public void setCredentialLocation(String credentialLocation) {
    this.credentialLocation = credentialLocation;
  }

  /**
   * Gets the configuration for X.509-based workload credentials (mTLS), if configured.
   *
   * @return The {@link CertificateConfig} object, or {@code null} if not configured for
   *     certificate-based credentials.
   */
  @Nullable
  public CertificateConfig getCertificateConfig() {
    return certificateConfig;
  }

  /**
   * Extracts and configures the {@link CertificateConfig} from the provided credential source.
   *
   * @param credentialSourceMap A map containing the certificate configuration.
   * @return A new {@link CertificateConfig} instance.
   * @throws IllegalArgumentException if the 'certificate' entry is not a Map or if required fields
   *     within the certificate configuration have invalid types.
   */
  private CertificateConfig certificateConfigFromSourceMap(
      Map<String, Object> credentialSourceMap) {
    Object certValue = credentialSourceMap.get("certificate");
    if (!(certValue instanceof Map)) {
      throw new IllegalArgumentException(
          "The 'certificate' credential source must be a JSON object (Map).");
    }
    Map<String, Object> certificateMap = (Map<String, Object>) certValue;

    Boolean useDefaultCertificateConfig =
        getOptionalBoolean(certificateMap, "use_default_certificate_config");
    String trustChain = getOptionalString(certificateMap, "trust_chain_path");
    String certificateConfigLocation =
        getOptionalString(certificateMap, "certificate_config_location");

    return new CertificateConfig(
        useDefaultCertificateConfig, certificateConfigLocation, trustChain);
  }

  /**
   * Retrieves an optional boolean value from a map.
   *
   * @param map The map to retrieve from.
   * @param key The key of the boolean value.
   * @return The boolean value if present and of the correct type, otherwise null.
   * @throws IllegalArgumentException if the value is present but not a boolean.
   */
  private @Nullable Boolean getOptionalBoolean(Map<String, Object> map, String key) {
    Object value = map.get(key);
    if (value == null) {
      return null;
    }
    if (!(value instanceof Boolean)) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid type for '%s' in certificate configuration: expected Boolean, got %s.",
              key, value.getClass().getSimpleName()));
    }
    return (Boolean) value;
  }

  /**
   * Retrieves an optional string value from a map.
   *
   * @param map The map to retrieve from.
   * @param key The key of the string value.
   * @return The string value if present and of the correct type, otherwise null.
   * @throws IllegalArgumentException if the value is present but not a string.
   */
  private @Nullable String getOptionalString(Map<String, Object> map, String key) {
    Object value = map.get(key);
    if (value == null) {
      return null;
    }
    if (!(value instanceof String)) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid type for '%s' in certificate configuration: expected String, got %s.",
              key, value.getClass().getSimpleName()));
    }
    return (String) value;
  }

  /**
   * Represents the configuration options for X.509-based workload credentials (mTLS). It specifies
   * how to locate and use the client certificate, private key, and optional trust chain for mutual
   * TLS authentication.
   */
  public static class CertificateConfig implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * If true, attempts to load the default certificate configuration. It checks the
     * GOOGLE_API_CERTIFICATE_CONFIG environment variable first, then a conventional default file
     * location. Cannot be true if {@code certificateConfigLocation} is set.
     */
    private final boolean useDefaultCertificateConfig;

    /**
     * Specifies the path to the client certificate and private key file. This is used when {@code
     * useDefaultCertificateConfig} is false or unset. Must be set if {@code
     * useDefaultCertificateConfig} is false.
     */
    @Nullable private final String certificateConfigLocation;

    /**
     * Specifies the path to a PEM-formatted file containing the X.509 certificate trust chain. This
     * file should contain any intermediate certificates required to complete the trust chain
     * between the leaf certificate (used for mTLS) and the root certificate(s) in your workload
     * identity pool's trust store. The leaf certificate and any certificates already present in the
     * workload identity pool's trust store are optional in this file. Certificates should be
     * ordered with the leaf certificate (or the certificate which signed the leaf) first.
     */
    @Nullable private final String trustChainPath;

    /**
     * Constructor for {@code CertificateConfig}.
     *
     * @param useDefaultCertificateConfig Whether to use the default certificate configuration.
     * @param certificateConfigLocation Path to the client certificate and private key file.
     * @param trustChainPath Path to the trust chain file.
     * @throws IllegalArgumentException if the configuration is invalid (e.g., neither default nor
     *     location is specified, or both are specified).
     */
    CertificateConfig(
        @Nullable Boolean useDefaultCertificateConfig,
        @Nullable String certificateConfigLocation,
        @Nullable String trustChainPath) {

      boolean useDefault = useDefaultCertificateConfig != null && useDefaultCertificateConfig;
      boolean locationIsPresent =
          certificateConfigLocation != null && !certificateConfigLocation.isEmpty();

      checkArgument(
          (useDefault || locationIsPresent),
          "Invalid 'certificate' configuration in credential source: Must specify either 'certificate_config_location' or set 'use_default_certificate_config' to true.");

      checkArgument(
          !(useDefault && locationIsPresent),
          "Invalid 'certificate' configuration in credential source: Cannot specify both 'certificate_config_location' and set 'use_default_certificate_config' to true.");

      this.useDefaultCertificateConfig = useDefault;
      this.certificateConfigLocation = certificateConfigLocation;
      this.trustChainPath = trustChainPath;
    }

    /** Returns whether the default certificate configuration should be used. */
    public boolean useDefaultCertificateConfig() {
      return useDefaultCertificateConfig;
    }

    /** Returns the path to the client certificate file, or null if not set. */
    @Nullable
    public String getCertificateConfigLocation() {
      return certificateConfigLocation;
    }

    /** Returns the path to the trust chain file, or null if not set. */
    @Nullable
    public String getTrustChainPath() {
      return trustChainPath;
    }
  }

  /**
   * The source of the 3P credential.
   *
   * <p>If this is a file based 3P credential, the credentials file can be retrieved using the
   * `file` key.
   *
   * <p>If this is URL-based 3p credential, the metadata server URL can be retrieved using the `url`
   * key.
   *
   * <p>The third party credential can be provided in different formats, such as text or JSON. The
   * format can be specified using the `format` header, which returns a map with keys `type` and
   * `subject_token_field_name`. If the `type` is json, the `subject_token_field_name` must be
   * provided. If no format is provided, we expect the token to be in the raw text format.
   *
   * <p>Optional headers can be present, and should be keyed by `headers`.
   */
  @SuppressWarnings("unchecked")
  public IdentityPoolCredentialSource(Map<String, Object> credentialSourceMap) {
    super(credentialSourceMap);

    boolean filePresent = credentialSourceMap.containsKey("file");
    boolean urlPresent = credentialSourceMap.containsKey("url");
    boolean certificatePresent = credentialSourceMap.containsKey("certificate");

    if ((filePresent && urlPresent)
        || (filePresent && certificatePresent)
        || (urlPresent && certificatePresent)) {
      throw new IllegalArgumentException(
          "Only one credential source type can be set: 'file', 'url', or 'certificate'.");
    }

    if (filePresent) {
      credentialLocation = (String) credentialSourceMap.get("file");
      credentialSourceType = IdentityPoolCredentialSourceType.FILE;
    } else if (urlPresent) {
      credentialLocation = (String) credentialSourceMap.get("url");
      credentialSourceType = IdentityPoolCredentialSourceType.URL;
    } else if (certificatePresent) {
      credentialSourceType = IdentityPoolCredentialSourceType.CERTIFICATE;
      this.certificateConfig = certificateConfigFromSourceMap(credentialSourceMap);
    } else {
      throw new IllegalArgumentException(
          "Missing credential source file location, URL, or certificate. At least one must be specified.");
    }

    Map<String, String> headersMap = (Map<String, String>) credentialSourceMap.get("headers");
    if (headersMap != null && !headersMap.isEmpty()) {
      headers = new HashMap<>();
      headers.putAll(headersMap);
    }

    // If the format is not provided, we expect the token to be in the raw text format.
    credentialFormatType = CredentialFormatType.TEXT;

    Map<String, String> formatMap = (Map<String, String>) credentialSourceMap.get("format");
    if (formatMap != null && formatMap.containsKey("type")) {
      String type = formatMap.get("type");

      if (type != null && "json".equals(type.toLowerCase(Locale.US))) {
        // For JSON, the subject_token field name must be provided.
        if (!formatMap.containsKey("subject_token_field_name")) {
          throw new IllegalArgumentException(
              "When specifying a JSON credential type, the subject_token_field_name must be set.");
        }
        credentialFormatType = CredentialFormatType.JSON;
        subjectTokenFieldName = formatMap.get("subject_token_field_name");
      } else if (type != null && "text".equals(type.toLowerCase(Locale.US))) {
        credentialFormatType = CredentialFormatType.TEXT;
      } else {
        throw new IllegalArgumentException(
            String.format("Invalid credential source format type: %s.", type));
      }
    }
  }

  boolean hasHeaders() {
    return headers != null && !headers.isEmpty();
  }

  enum IdentityPoolCredentialSourceType {
    FILE,
    URL,
    CERTIFICATE
  }

  enum CredentialFormatType {
    TEXT,
    JSON
  }
}
