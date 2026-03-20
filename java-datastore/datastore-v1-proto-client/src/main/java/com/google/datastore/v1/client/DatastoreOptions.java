/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import java.util.Arrays;
import java.util.List;

/**
 * An immutable object containing settings for the datastore.
 *
 * <p>Example for connecting to a datastore:
 *
 * <pre>
 * DatastoreOptions options = new DatastoreOptions.Builder()
 *     .projectId("my-project-id")
 *     .credential(DatastoreHelper.getComputeEngineCredential())
 *     .build();
 * DatastoreFactory.get().create(options);
 * </pre>
 *
 * <p>The options should be passed to {@link DatastoreFactory#create}.
 */
public class DatastoreOptions {
  private final String projectId;

  private final String projectEndpoint;
  private final String host;
  private final String localHost;

  private final HttpRequestInitializer initializer;

  private final Credential credential;
  private final HttpTransport transport;
  public static final List<String> SCOPES =
      Arrays.asList("https://www.googleapis.com/auth/datastore");

  DatastoreOptions(Builder b) {
    checkArgument(
        b.projectId != null || b.projectEndpoint != null,
        "Either project ID or project endpoint must be provided.");
    this.projectId = b.projectId;
    this.projectEndpoint = b.projectEndpoint;
    this.host = b.host;
    this.localHost = b.localHost;
    this.initializer = b.initializer;
    this.credential = b.credential;
    this.transport = b.transport;
  }

  /** Builder for {@link DatastoreOptions}. */
  public static class Builder {
    private static final String PROJECT_ENDPOINT_AND_PROJECT_ID_ERROR =
        "Cannot set both project endpoint and project ID.";
    private static final String PROJECT_ENDPOINT_AND_HOST_ERROR =
        "Can set at most one of project endpoint, host, and local host.";

    private String projectId;

    private String projectEndpoint;
    private String host;
    private String localHost;
    private HttpRequestInitializer initializer;
    private Credential credential;
    private HttpTransport transport;

    public Builder() {}

    public Builder(DatastoreOptions options) {
      this.projectId = options.projectId;
      this.projectEndpoint = options.projectEndpoint;
      this.host = options.host;
      this.localHost = options.localHost;
      this.initializer = options.initializer;
      this.credential = options.credential;
      this.transport = options.transport;
    }

    public DatastoreOptions build() {
      return new DatastoreOptions(this);
    }

    /** Sets the project ID used to access Cloud Datastore. */
    public Builder projectId(String projectId) {
      checkArgument(projectEndpoint == null, PROJECT_ENDPOINT_AND_PROJECT_ID_ERROR);
      this.projectId = projectId;
      return this;
    }

    /**
     * Sets the host used to access Cloud Datastore. To connect to the Cloud Datastore Emulator, use
     * {@link #localHost} instead.
     */
    public Builder host(String host) {
      checkArgument(projectEndpoint == null && localHost == null, PROJECT_ENDPOINT_AND_HOST_ERROR);
      if (includesScheme(host)) {
        throw new IllegalArgumentException(
            String.format("Host \"%s\" must not include scheme.", host));
      }
      this.host = host;
      return this;
    }

    /**
     * Configures the client to access Cloud Datastore on a local host (typically a Cloud Datastore
     * Emulator instance). Call this method also configures the client not to attach credentials to
     * requests.
     */
    public Builder localHost(String localHost) {
      checkArgument(projectEndpoint == null && host == null, PROJECT_ENDPOINT_AND_HOST_ERROR);
      if (includesScheme(localHost)) {
        throw new IllegalArgumentException(
            String.format("Local host \"%s\" must not include scheme.", localHost));
      }
      this.localHost = localHost;
      return this;
    }

    /**
     * Sets the project endpoint used to access Cloud Datastore. Prefer using {@link #projectId}
     * and/or {@link #host}/{@link #localHost} when possible.
     *
     * @deprecated Use {@link #projectId} and/or {@link #host}/{@link #localHost} instead.
     */
    @Deprecated
    public Builder projectEndpoint(String projectEndpoint) {
      checkArgument(projectId == null, PROJECT_ENDPOINT_AND_PROJECT_ID_ERROR);
      checkArgument(localHost == null && host == null, PROJECT_ENDPOINT_AND_HOST_ERROR);
      if (!includesScheme(projectEndpoint)) {
        throw new IllegalArgumentException(
            String.format("Project endpoint \"%s\" must include scheme.", projectEndpoint));
      }
      this.projectEndpoint = projectEndpoint;
      return this;
    }

    /** Sets the (optional) initializer to run on HTTP requests to Cloud Datastore. */
    public Builder initializer(HttpRequestInitializer initializer) {
      this.initializer = initializer;
      return this;
    }

    /** Sets the Google APIs {@link Credential} used to access Cloud Datastore. */
    public Builder credential(Credential credential) {
      this.credential = credential;
      return this;
    }

    /** Sets the transport used to access Cloud Datastore. */
    public Builder transport(HttpTransport transport) {
      this.transport = transport;
      return this;
    }

    private static boolean includesScheme(String url) {
      return url.startsWith("http://") || url.startsWith("https://");
    }
  }

  public String getProjectId() {
    return projectId;
  }

  public String getProjectEndpoint() {
    return projectEndpoint;
  }

  public String getHost() {
    return host;
  }

  public String getLocalHost() {
    return localHost;
  }

  public HttpRequestInitializer getInitializer() {
    return initializer;
  }

  public Credential getCredential() {
    return credential;
  }

  public HttpTransport getTransport() {
    return transport;
  }
}
