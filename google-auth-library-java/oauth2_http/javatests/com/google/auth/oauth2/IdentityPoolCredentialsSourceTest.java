/*
 * Copyright 2025 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.oauth2.IdentityPoolCredentialSource.IdentityPoolCredentialSourceType;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Tests for {@link IdentityPoolCredentialSource}. */
class IdentityPoolCredentialsSourceTest {

  @Test
  void constructor_certificateConfig() {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("certificate_config_location", "/path/to/certificate");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    assertEquals(
        IdentityPoolCredentialSourceType.CERTIFICATE, credentialSource.credentialSourceType);
    assertNotNull(credentialSource.getCertificateConfig());
    assertFalse(credentialSource.getCertificateConfig().useDefaultCertificateConfig());
    assertEquals(
        "/path/to/certificate",
        credentialSource.getCertificateConfig().getCertificateConfigLocation());
  }

  @Test
  void constructor_certificateConfig_useDefault() {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", true);

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    assertEquals(
        IdentityPoolCredentialSourceType.CERTIFICATE, credentialSource.credentialSourceType);
    assertNotNull(credentialSource.getCertificateConfig());
    assertTrue(credentialSource.getCertificateConfig().useDefaultCertificateConfig());
  }

  @Test
  void constructor_certificateConfig_missingRequiredFields_throws() {
    Map<String, Object> certificateMap = new HashMap<>();
    // Missing both use_default_certificate_config and certificate_config_location.
    certificateMap.put("trust_chain_path", "path/to/trust/chain");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));
    assertEquals(
        "Invalid 'certificate' configuration in credential source: Must specify either 'certificate_config_location' or set 'use_default_certificate_config' to true.",
        exception.getMessage());
  }

  @Test
  void constructor_certificateConfig_bothFieldsSet_throws() {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", true);
    certificateMap.put("certificate_config_location", "/path/to/certificate");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));

    assertEquals(
        "Invalid 'certificate' configuration in credential source: Cannot specify both 'certificate_config_location' and set 'use_default_certificate_config' to true.",
        exception.getMessage());
  }

  @Test
  void constructor_certificateConfig_trustChainPath() {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", true);
    certificateMap.put("trust_chain_path", "path/to/trust/chain");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    assertEquals(
        IdentityPoolCredentialSourceType.CERTIFICATE, credentialSource.credentialSourceType);
    assertNotNull(credentialSource.getCertificateConfig());
    assertEquals(
        "path/to/trust/chain", credentialSource.getCertificateConfig().getTrustChainPath());
  }

  @Test
  void constructor_certificateConfig_invalidType_throws() {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", "invalid-type");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));

    assertEquals(
        "Invalid type for 'use_default_certificate_config' in certificate configuration: expected Boolean, got String.",
        exception.getMessage());
  }
}
