/*
 * Copyright 2026 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Data;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Internal provider for retrieving the subject and actor tokens for {@link IdentityPoolCredentials}
 * to exchange for GCP access tokens via a local file.
 */
@NullMarked
class FileIdentityPoolTokenSupplier
    implements IdentityPoolSubjectTokenSupplier, IdentityPoolActorTokenSupplier {

  private static final long serialVersionUID = 2475549052347431993L;

  private final IdentityPoolCredentialSource credentialSource;

  private static class CachedFile {
    final long lastModified;
    final GenericJson parsedJson;

    CachedFile(long lastModified, GenericJson parsedJson) {
      this.lastModified = lastModified;
      this.parsedJson = parsedJson;
    }
  }

  private transient volatile CachedFile cachedFile;

  FileIdentityPoolTokenSupplier(IdentityPoolCredentialSource credentialSource) {
    this.credentialSource = checkNotNull(credentialSource, "credentialSource cannot be null");
  }

  @Override
  public String getSubjectToken(ExternalAccountSupplierContext context) throws IOException {
    return getToken(credentialSource.subjectTokenFieldName);
  }

  @Override
  public String getActorToken(ExternalAccountSupplierContext context) throws IOException {
    if (credentialSource.credentialFormatType == CredentialFormatType.TEXT) {
      throw new IllegalArgumentException(
          "Actor tokens are only supported for JSON-formatted credential files with distinct field names.");
    }
    return getToken(credentialSource.actorTokenFieldName);
  }

  private String getToken(@Nullable String targetFieldName) throws IOException {
    String credentialFilePath = credentialSource.getCredentialLocation();
    if (!Files.exists(Paths.get(credentialFilePath), LinkOption.NOFOLLOW_LINKS)) {
      throw new IOException(
          String.format(
              "Invalid credential location. The file at %s does not exist.", credentialFilePath));
    }

    if (credentialSource.credentialFormatType == CredentialFormatType.JSON) {
      if (targetFieldName == null) {
        throw new IOException("Target field name must be specified for JSON credentials.");
      }
      File file = new File(credentialFilePath);
      long lastModified = file.lastModified();

      CachedFile cached = this.cachedFile;

      if (cached == null || cached.lastModified < lastModified) {
        synchronized (this) {
          cached = this.cachedFile;
          if (cached == null || cached.lastModified < lastModified) {
            try (InputStream inputStream = Files.newInputStream(file.toPath())) {
              JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
              GenericJson parsedJson =
                  parser.parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class);
              cached = new CachedFile(lastModified, parsedJson);
              this.cachedFile = cached;
            } catch (Exception e) {
              throw new IOException(
                  "Error when attempting to read the token from the credential file.", e);
            }
          }
        }
      }

      Object value = cached.parsedJson.get(targetFieldName);
      if (value == null || Data.isNull(value)) {
        throw new IOException(
            "Invalid token field name. No token was found for field: " + targetFieldName);
      }
      return value.toString();
    }

    try (InputStream inputStream = Files.newInputStream(Paths.get(credentialFilePath))) {
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
      return CharStreams.toString(reader);
    } catch (IOException e) {
      throw new IOException("Error when attempting to read the token from the credential file.", e);
    }
  }

  /** Used primarily for UrlIdentityPoolSubjectTokenSupplier */
  static String parseToken(
      InputStream inputStream,
      IdentityPoolCredentialSource credentialSource,
      @Nullable String targetFieldName)
      throws IOException {
    try (InputStream in = inputStream;
        java.io.Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
      if (credentialSource.credentialFormatType == CredentialFormatType.TEXT) {
        return CharStreams.toString(new BufferedReader(reader));
      }

      if (targetFieldName == null) {
        throw new IOException("Target field name must be specified for JSON credentials.");
      }

      JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
      GenericJson fileContents =
          parser.parseAndClose(in, StandardCharsets.UTF_8, GenericJson.class);

      Object value = fileContents.get(targetFieldName);
      if (value == null || Data.isNull(value)) {
        throw new IOException(
            "Invalid token field name. No token was found for field: " + targetFieldName);
      }
      return value.toString();
    }
  }
}
