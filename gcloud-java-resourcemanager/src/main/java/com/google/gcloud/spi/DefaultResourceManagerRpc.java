package com.google.gcloud.spi;

import static com.google.gcloud.spi.ResourceManagerRpc.Option.FIELDS;
import static com.google.gcloud.spi.ResourceManagerRpc.Option.FILTER;
import static com.google.gcloud.spi.ResourceManagerRpc.Option.PAGE_SIZE;
import static com.google.gcloud.spi.ResourceManagerRpc.Option.PAGE_TOKEN;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.cloudresourcemanager.Cloudresourcemanager;
import com.google.api.services.cloudresourcemanager.model.ListProjectsResponse;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.gcloud.resourcemanager.ResourceManagerException;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

import java.io.IOException;
import java.util.Map;

public class DefaultResourceManagerRpc implements ResourceManagerRpc {

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
    return new ResourceManagerException(exception);
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
      if (translated.code() == HTTP_FORBIDDEN || translated.code() == HTTP_NOT_FOUND) {
        // Service can return either 403 or 404 to signify that the project doesn't exist.
        return null;
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

