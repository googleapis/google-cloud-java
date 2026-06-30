/*
 * Copyright 2021 Google LLC
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

import javax.annotation.Nullable;

/**
 * Defines AWS security credentials. These are either retrieved from the AWS security_credentials
 * endpoint or AWS environment variables.
 */
public class AwsSecurityCredentials {

  private final String accessKeyId;
  private final String secretAccessKey;

  @Nullable private final String sessionToken;

  /**
   * Constructor for AWSSecurityCredentials.
   *
   * @param accessKeyId the AWS access Key Id.
   * @param secretAccessKey the AWS secret access key.
   * @param sessionToken the AWS session token. Optional.
   */
  public AwsSecurityCredentials(
      String accessKeyId, String secretAccessKey, @Nullable String sessionToken) {
    this.accessKeyId = accessKeyId;
    this.secretAccessKey = secretAccessKey;
    this.sessionToken = sessionToken;
  }

  /**
   * Gets the AWS access key id.
   *
   * @return the AWS access key id.
   */
  public String getAccessKeyId() {
    return accessKeyId;
  }

  /**
   * Gets the AWS secret access key.
   *
   * @return the AWS secret access key.
   */
  public String getSecretAccessKey() {
    return secretAccessKey;
  }

  /**
   * Gets the AWS session token.
   *
   * @return the AWS session token.
   */
  @Nullable
  public String getSessionToken() {
    return sessionToken;
  }
}
