/*
 * Copyright 2015, Google Inc. All rights reserved.
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

import com.google.api.client.json.JsonParser;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** OAuth2 credentials representing the built-in service account for Google Cloud Shell. */
public class CloudShellCredentials extends GoogleCredentials {

  private static final long serialVersionUID = -2133257318957488451L;
  private static final int ACCESS_TOKEN_INDEX = 2;
  private static final int READ_TIMEOUT_MS = 5000;

  /**
   * The Cloud Shell back authorization channel uses serialized Javascript Protobuffers, preceded by
   * the message length and a new line character. However, the request message has no content, so a
   * token request consists of an empty JsPb, and its 2 character length prefix.
   */
  protected static final String GET_AUTH_TOKEN_REQUEST = "2\n[]";

  protected static final byte[] GET_AUTH_TOKEN_REQUEST_BYTES =
      (GET_AUTH_TOKEN_REQUEST + "\n").getBytes(StandardCharsets.UTF_8);

  private final int authPort;

  public static CloudShellCredentials create(int authPort) {
    return CloudShellCredentials.newBuilder().setAuthPort(authPort).build();
  }

  private CloudShellCredentials(Builder builder) {
    super(builder);
    this.authPort = builder.getAuthPort();
    this.name = GoogleCredentialsInfo.CLOUD_SHELL_CREDENTIALS.getCredentialName();
  }

  protected int getAuthPort() {
    return this.authPort;
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    Socket socket = new Socket("localhost", this.getAuthPort());
    socket.setSoTimeout(READ_TIMEOUT_MS);
    AccessToken token;
    try {
      OutputStream os = socket.getOutputStream();
      os.write(GET_AUTH_TOKEN_REQUEST_BYTES);

      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      input.readLine(); // Skip over the first line
      JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(input);
      List<Object> messageArray = (List<Object>) parser.parseArray(ArrayList.class, Object.class);
      String accessToken = messageArray.get(ACCESS_TOKEN_INDEX).toString();
      token = new AccessToken(accessToken, null);
    } finally {
      socket.close();
    }
    return token;
  }

  @Override
  public int hashCode() {
    return Objects.hash(authPort);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("authPort", authPort).toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof CloudShellCredentials)) {
      return false;
    }
    CloudShellCredentials other = (CloudShellCredentials) obj;
    return this.authPort == other.authPort;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder extends GoogleCredentials.Builder {
    private int authPort;

    protected Builder() {}

    protected Builder(CloudShellCredentials credentials) {
      this.authPort = credentials.authPort;
    }

    @CanIgnoreReturnValue
    public Builder setAuthPort(int authPort) {
      this.authPort = authPort;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      super.quotaProjectId = quotaProjectId;
      return this;
    }

    public int getAuthPort() {
      return authPort;
    }

    @Override
    public CloudShellCredentials build() {
      return new CloudShellCredentials(this);
    }
  }
}
