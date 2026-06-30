/*
 * Copyright 2019, Google LLC
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

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/** Represents a temporary IdToken and its JsonWebSignature object */
public class IdToken extends AccessToken implements Serializable {

  private static final long serialVersionUID = -8514239465808977353L;

  private transient JsonWebSignature jsonWebSignature;

  /**
   * @param tokenValue String representation of the ID token.
   * @param jsonWebSignature JsonWebSignature as object
   */
  private IdToken(String tokenValue, JsonWebSignature jsonWebSignature) {
    super(tokenValue, new Date(jsonWebSignature.getPayload().getExpirationTimeSeconds() * 1000));
    this.jsonWebSignature = jsonWebSignature;
  }

  /**
   * Creates an IdToken given the encoded Json Web Signature.
   *
   * @param tokenValue String representation of the ID token.
   * @throws IOException if JWT token parsing fails
   * @return returns com.google.auth.oauth2.IdToken
   */
  public static IdToken create(String tokenValue) throws IOException {
    return create(tokenValue, OAuth2Utils.JSON_FACTORY);
  }

  /**
   * Creates an IdToken given the encoded Json Web Signature and JSON Factory
   *
   * @param jsonFactory JsonFactory to use for parsing the provided token.
   * @param tokenValue String representation of the ID token.
   * @throws IOException if JWT token parsing fails
   * @return returns com.google.auth.oauth2.IdToken
   */
  public static IdToken create(String tokenValue, JsonFactory jsonFactory) throws IOException {
    return new IdToken(tokenValue, JsonWebSignature.parse(jsonFactory, tokenValue));
  }

  /**
   * The JsonWebSignature as object
   *
   * @return returns com.google.api.client.json.webtoken.JsonWebSignature
   */
  JsonWebSignature getJsonWebSignature() {
    return jsonWebSignature;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.getTokenValue(), jsonWebSignature.getHeader(), jsonWebSignature.getPayload());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tokenValue", super.getTokenValue())
        .add("JsonWebSignature", jsonWebSignature)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof IdToken)) {
      return false;
    }
    IdToken other = (IdToken) obj;
    return Objects.equals(super.getTokenValue(), other.getTokenValue())
        && Objects.equals(this.jsonWebSignature.getHeader(), other.jsonWebSignature.getHeader())
        && Objects.equals(this.jsonWebSignature.getPayload(), other.jsonWebSignature.getPayload());
  }

  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.writeObject(this.getTokenValue());
  }

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    String signature = (String) ois.readObject();
    this.jsonWebSignature = JsonWebSignature.parse(OAuth2Utils.JSON_FACTORY, signature);
  }
}
