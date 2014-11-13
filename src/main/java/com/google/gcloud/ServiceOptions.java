package com.google.gcloud;

import com.google.api.client.auth.oauth2.Credential;
import com.google.common.base.MoreObjects;

public abstract class ServiceOptions {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";

  private final String host;
  private final Credential credential;

  protected ServiceOptions(Builder builder) {
    host = MoreObjects.firstNonNull(builder.host, DEFAULT_HOST);
    credential = builder.credential;
  }

  protected abstract static class Builder {

    private String host;
    private Credential credential;

    public Builder() {}

    public Builder(ServiceOptions options) {
      host = options.host;
      credential = options.credential;
    }

    protected abstract ServiceOptions build();

    public Builder setHost(String host) {
      this.host = host;
      return this;
    }

    public Builder setCredential(Credential credential) {
      this.credential = credential;
      return this;
    }
  }

  public String getHost() {
    return host;
  }

  public Credential getCredential() {
    return credential;
  }
}
