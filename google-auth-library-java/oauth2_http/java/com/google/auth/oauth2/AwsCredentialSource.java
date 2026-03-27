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

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** The AWS credential source. Stores data required to retrieve the AWS credential. */
public class AwsCredentialSource extends ExternalAccountCredentials.CredentialSource {

  static final String IMDSV2_SESSION_TOKEN_URL_FIELD_NAME = "imdsv2_session_token_url";
  static final long serialVersionUID = -4180558200808134436L;

  final String regionUrl;
  final String url;
  final String regionalCredentialVerificationUrl;
  final String imdsv2SessionTokenUrl;

  /**
   * The source of the AWS credential. The credential source map must contain the
   * `regional_cred_verification_url` field.
   *
   * <p>The `regional_cred_verification_url` is the regional GetCallerIdentity action URL, used to
   * determine the account ID and its roles.
   *
   * <p>The `environment_id` is the environment identifier, in the format “aws${version}”. This
   * indicates whether breaking changes were introduced to the underlying AWS implementation.
   *
   * <p>The `region_url` identifies the targeted region. Optional.
   *
   * <p>The `url` locates the metadata server used to retrieve the AWS credentials. Optional.
   */
  public AwsCredentialSource(Map<String, Object> credentialSourceMap) {
    super(credentialSourceMap);
    if (!credentialSourceMap.containsKey("regional_cred_verification_url")) {
      throw new IllegalArgumentException(
          "A regional_cred_verification_url representing the"
              + " GetCallerIdentity action URL must be specified.");
    }

    String environmentId = (String) credentialSourceMap.get("environment_id");

    // Environment version is prefixed by "aws". e.g. "aws1".
    Matcher matcher = Pattern.compile("(aws)([\\d]+)").matcher(environmentId);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid AWS environment ID.");
    }

    int environmentVersion = Integer.parseInt(matcher.group(2));
    if (environmentVersion != 1) {
      throw new IllegalArgumentException(
          String.format(
              "AWS version %s is not supported in the current build.", environmentVersion));
    }

    this.regionUrl = (String) credentialSourceMap.get("region_url");
    this.url = (String) credentialSourceMap.get("url");
    this.regionalCredentialVerificationUrl =
        (String) credentialSourceMap.get("regional_cred_verification_url");

    if (credentialSourceMap.containsKey(IMDSV2_SESSION_TOKEN_URL_FIELD_NAME)) {
      this.imdsv2SessionTokenUrl =
          (String) credentialSourceMap.get(IMDSV2_SESSION_TOKEN_URL_FIELD_NAME);
    } else {
      this.imdsv2SessionTokenUrl = null;
    }
  }
}
