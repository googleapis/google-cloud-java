package com.google.gcloud.spi;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.cloudresourcemanager.Cloudresourcemanager;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.resourcemanager.ResourceManagerException;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DefaultResourceManagerRpc implements ResourceManagerRpc {

  private static final Set<Integer> RETRYABLE_CODES = ImmutableSet.of(503, 500, 429, 417);

  private final ResourceManagerOptions options;
  private final Cloudresourcemanager resourceManager;

  public DefaultResourceManagerRpc(ResourceManagerOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    HttpRequestInitializer initializer = options.httpRequestInitializer();
    this.options = options;
    resourceManager =
        new Cloudresourcemanager.Builder(transport, new JacksonFactory(), initializer)
            .setRootUrl(options.host())
            .setApplicationName(options.applicationName())
            .build();
  }

  private static ResourceManagerException translate(IOException exception) {
    ResourceManagerException translated;
    if (exception instanceof GoogleJsonResponseException) {
      translated = translate(((GoogleJsonResponseException) exception).getDetails());
    } else {
      translated = new ResourceManagerException(0, exception.getMessage(), false);
    }
    translated.initCause(exception);
    return translated;
  }

  private static ResourceManagerException translate(GoogleJsonError exception) {
    boolean retryable =
        RETRYABLE_CODES.contains(exception.getCode())
        || "InternalError".equals(exception.getMessage());
    return new ResourceManagerException(exception.getCode(), exception.getMessage(), retryable);
  }

  @Override
  public Project create(Project project) throws ResourceManagerException {
    // TODO(ajaykannan): fix me!
    return null;
  }

  @Override
  public void delete(String projectId) throws ResourceManagerException {
    // TODO(ajaykannan): fix me!
  }

  @Override
  public Project get(String projectId) throws ResourceManagerException {
    // TODO(ajaykannan): fix me!
    return null;
  }

  @Override
  public Tuple<String, Iterable<Project>> list(Map<Option, ?> options)
      throws ResourceManagerException {
    // TODO(ajaykannan): fix me!
    return null;
  }

  @Override
  public void undelete(String projectId) throws ResourceManagerException {
    // TODO(ajaykannan): fix me!
  }

  @Override
  public Project replace(Project project) throws ResourceManagerException {
    // TODO(ajaykannan): fix me!
    return null;
  }
}

