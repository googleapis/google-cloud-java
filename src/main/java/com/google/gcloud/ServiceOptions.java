package com.google.gcloud;

import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;

public class ServiceOptions {

  private final String host;
  private static final String DEFAULT_HOST = "https://www.googleapis.com";
  private final HttpRequestInitializer initializer;
  private final Credential credential;
  private final HttpTransport transport;

  public static final List<String> SCOPES = Arrays.asList(
      "https://www.googleapis.com/auth/datastore",
      "https://www.googleapis.com/auth/userinfo.email");

  ServiceOptions(Builder b) {
    this.dataset = b.dataset;
    this.host = b.host != null ? b.host : DEFAULT_HOST;
    this.initializer = b.initializer;
    this.credential = b.credential;
    this.transport = b.transport;
  }

  /**
   * Builder for {@link ServiceOptions}.
   */
  protected static class Builder {
    private String dataset;
    private String host;
    private HttpRequestInitializer initializer;
    private Credential credential;
    private HttpTransport transport;

    public Builder() { }

    public Builder(ServiceOptions options) {
      this.dataset = options.dataset;
      this.host = options.host;
      this.initializer = options.initializer;
      this.credential = options.credential;
      this.transport = options.transport;
    }

    public ServiceOptions build() {
      return new ServiceOptions(this);
    }

    /**
     * Sets the dataset used to access the datastore.
     */
    public Builder dataset(String newDataset) {
      dataset = newDataset;
      return this;
    }

    /**
     * Sets the host used to access the datastore.
     */
    public Builder host(String newHost) {
      host = newHost;
      return this;
    }

    /**
     * Sets the (optional) initializer to run on HTTP requests to the API.
     */
    public Builder initializer(HttpRequestInitializer newInitializer) {
      initializer = newInitializer;
      return this;
    }

    /**
     * Sets the Google APIs credentials used to access the API.
     */
    public Builder credential(Credential newCredential) {
      credential = newCredential;
      return this;
    }

    /**
     * Sets the transport used to access the API.
     */
    public Builder transport(HttpTransport transport) {
      this.transport = transport;
      return this;
    }
  }

  // === getters ===

  public String getDataset() {
    return dataset;
  }

  public String getHost() {
    return host;
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