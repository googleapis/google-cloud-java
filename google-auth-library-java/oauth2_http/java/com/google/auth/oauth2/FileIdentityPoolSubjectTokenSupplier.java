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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.auth.oauth2.IdentityPoolCredentialSource.CredentialFormatType;
import com.google.common.io.CharStreams;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

/**
 * Internal provider for retrieving the subject tokens for {@link IdentityPoolCredentials} to
 * exchange for GCP access tokens via a local file.
 */
class FileIdentityPoolSubjectTokenSupplier implements IdentityPoolSubjectTokenSupplier {

  private final long serialVersionUID = 2475549052347431992L;

  private final IdentityPoolCredentialSource credentialSource;

  /**
   * Constructor for FileIdentitySubjectTokenProvider
   *
   * @param credentialSource the credential source to use.
   */
  FileIdentityPoolSubjectTokenSupplier(IdentityPoolCredentialSource credentialSource) {
    this.credentialSource = credentialSource;
  }

  @Override
  public String getSubjectToken(ExternalAccountSupplierContext context) throws IOException {
    String credentialFilePath = this.credentialSource.getCredentialLocation();
    if (!Files.exists(Paths.get(credentialFilePath), LinkOption.NOFOLLOW_LINKS)) {
      throw new IOException(
          String.format(
              "Invalid credential location. The file at %s does not exist.", credentialFilePath));
    }
    try {
      return parseToken(
          Files.newInputStream(new File(credentialFilePath).toPath()), this.credentialSource);
    } catch (IOException e) {
      throw new IOException(
          "Error when attempting to read the subject token from the credential file.", e);
    }
  }

  static String parseToken(InputStream inputStream, IdentityPoolCredentialSource credentialSource)
      throws IOException {
    if (credentialSource.credentialFormatType == CredentialFormatType.TEXT) {
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
      return CharStreams.toString(reader);
    }

    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    GenericJson fileContents =
        parser.parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class);

    if (!fileContents.containsKey(credentialSource.subjectTokenFieldName)) {
      throw new IOException("Invalid subject token field name. No subject token was found.");
    }
    return (String) fileContents.get(credentialSource.subjectTokenFieldName);
  }
}
