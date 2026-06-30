/*
 * Copyright 2024 Google LLC
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

import com.google.auth.oauth2.ExternalAccountCredentials.SubjectTokenTypes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;

/**
 * Context object to pass relevant variables from external account credentials to suppliers. This
 * will be passed on any call made to {@link IdentityPoolSubjectTokenSupplier} or {@link
 * AwsSecurityCredentialsSupplier}.
 */
public class ExternalAccountSupplierContext implements Serializable {

  private static final long serialVersionUID = -7852130853542313494L;

  private final String audience;
  private final String subjectTokenType;

  /** Internal constructor. See {@link ExternalAccountSupplierContext.Builder}. */
  private ExternalAccountSupplierContext(Builder builder) {
    this.audience = builder.audience;
    this.subjectTokenType = builder.subjectTokenType;
  }

  /**
   * Returns the credentials' expected audience.
   *
   * @return the requested audience. For example:
   *     "//iam.googleapis.com/locations/global/workforcePools/$WORKFORCE_POOL_ID/providers/$PROVIDER_ID".
   */
  public String getAudience() {
    return audience;
  }

  /**
   * Returns the credentials' expected Security Token Service subject token type based on the OAuth
   * 2.0 token exchange spec.
   *
   * <p>Expected values:
   *
   * <p>"urn:ietf:params:oauth:token-type:jwt" "urn:ietf:params:aws:token-type:aws4_request"
   * "urn:ietf:params:oauth:token-type:saml2" "urn:ietf:params:oauth:token-type:id_token"
   *
   * @return the requested subject token type. For example: "urn:ietf:params:oauth:token-type:jwt".
   */
  public String getSubjectTokenType() {
    return subjectTokenType;
  }

  static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for external account supplier context. */
  static class Builder {

    protected String audience;
    protected String subjectTokenType;

    /**
     * Sets the Audience.
     *
     * @param audience the audience to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    Builder setAudience(String audience) {
      this.audience = audience;
      return this;
    }

    /**
     * Sets the subject token type.
     *
     * @param subjectTokenType the subjectTokenType to set.
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    Builder setSubjectTokenType(String subjectTokenType) {
      this.subjectTokenType = subjectTokenType;
      return this;
    }

    /**
     * Sets the subject token type.
     *
     * @param subjectTokenType the subjectTokenType to set.
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    Builder setSubjectTokenType(SubjectTokenTypes subjectTokenType) {
      this.subjectTokenType = subjectTokenType.value;
      return this;
    }

    ExternalAccountSupplierContext build() {
      return new ExternalAccountSupplierContext(this);
    }
  }
}
