package com.google.gcloud.spi;

import static com.google.gcloud.spi.ResourceManagerRpc.Option.FIELDS;
import static com.google.gcloud.spi.ResourceManagerRpc.Option.FILTER;
import static com.google.gcloud.spi.ResourceManagerRpc.Option.PAGE_SIZE;
import static com.google.gcloud.spi.ResourceManagerRpc.Option.PAGE_TOKEN;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.cloudresourcemanager.Cloudresourcemanager;
import com.google.api.services.cloudresourcemanager.model.ListProjectsResponse;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.resourcemanager.ResourceManagerException;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DefaultResourceManagerRpc implements ResourceManagerRpc {

  // see https://cloud.google.com/resource-manager/v1/errors/core_errors
  private static final Set<Integer> RETRYABLE_CODES = ImmutableSet.of(503, 500, 429);

  private final Cloudresourcemanager resourceManager;

  public DefaultResourceManagerRpc(ResourceManagerOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    HttpRequestInitializer initializer = options.httpRequestInitializer();
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
    boolean retryable = RETRYABLE_CODES.contains(exception.getCode());
    return new ResourceManagerException(exception.getCode(), exception.getMessage(), retryable);
  }

  @Override
  public Project create(Project project) throws ResourceManagerException {
    try {
      return resourceManager.projects().create(project).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public void delete(String projectId) throws ResourceManagerException {
    try {
      resourceManager.projects().delete(projectId).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Project get(String projectId, Map<Option, ?> options) throws ResourceManagerException {
    try {
      return resourceManager.projects()
          .get(projectId)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      ResourceManagerException translated = translate(ex);
      if (translated.code() == HTTP_FORBIDDEN) {
        return null; // Project not found
      } else {
        throw translated;
      }
    }
  }

  @Override
  public Tuple<String, Iterable<Project>> list(Map<Option, ?> options)
      throws ResourceManagerException {
    try {
      ListProjectsResponse response = resourceManager.projects()
          .list()
          .setFields(FIELDS.getString(options))
          .setFilter(FILTER.getString(options))
          .setPageSize(PAGE_SIZE.getInt(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .execute();
      return Tuple.<String, Iterable<Project>>of(
          response.getNextPageToken(), response.getProjects());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public void undelete(String projectId) throws ResourceManagerException {
    try {
      resourceManager.projects().undelete(projectId).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Project replace(Project project) throws ResourceManagerException {
    try {
      return resourceManager.projects().update(project.getProjectId(), project).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }
}

