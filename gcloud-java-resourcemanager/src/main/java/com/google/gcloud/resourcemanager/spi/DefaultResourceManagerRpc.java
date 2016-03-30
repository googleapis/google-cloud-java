package com.google.gcloud.resourcemanager.spi;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.gcloud.resourcemanager.spi.ResourceManagerRpc.Option.FIELDS;
import static com.google.gcloud.resourcemanager.spi.ResourceManagerRpc.Option.FILTER;
import static com.google.gcloud.resourcemanager.spi.ResourceManagerRpc.Option.PAGE_SIZE;
import static com.google.gcloud.resourcemanager.spi.ResourceManagerRpc.Option.PAGE_TOKEN;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.cloudresourcemanager.Cloudresourcemanager;
import com.google.api.services.cloudresourcemanager.model.GetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.ListProjectsResponse;
import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.api.services.cloudresourcemanager.model.SetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsRequest;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.resourcemanager.ResourceManagerException;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
  public Project create(Project project) {
    try {
      return resourceManager.projects().create(project).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public void delete(String projectId) {
    try {
      resourceManager.projects().delete(projectId).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Project get(String projectId, Map<Option, ?> options) {
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
  public Tuple<String, Iterable<Project>> list(Map<Option, ?> options) {
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
  public void undelete(String projectId) {
    try {
      resourceManager.projects().undelete(projectId).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Project replace(Project project) {
    try {
      return resourceManager.projects().update(project.getProjectId(), project).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Policy getPolicy(String projectId) throws ResourceManagerException {
    try {
      return resourceManager.projects()
          .getIamPolicy(projectId, new GetIamPolicyRequest())
          .execute();
    } catch (IOException ex) {
      ResourceManagerException translated = translate(ex);
      if (translated.code() == HTTP_FORBIDDEN) {
        // Service returns permission denied if policy doesn't exist.
        return null;
      } else {
        throw translated;
      }
    }
  }

  @Override
  public Policy replacePolicy(String projectId, Policy newPolicy) throws ResourceManagerException {
    try {
      return resourceManager.projects()
          .setIamPolicy(projectId, new SetIamPolicyRequest().setPolicy(newPolicy)).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public List<Boolean> testPermissions(String projectId, List<String> permissions)
      throws ResourceManagerException {
    try {
      TestIamPermissionsResponse response = resourceManager.projects()
          .testIamPermissions(
              projectId, new TestIamPermissionsRequest().setPermissions(permissions))
          .execute();
      Set<String> permissionsOwned =
          ImmutableSet.copyOf(firstNonNull(response.getPermissions(), ImmutableList.<String>of()));
      ImmutableList.Builder<Boolean> answer = ImmutableList.builder();
      for (String p : permissions) {
        answer.add(permissionsOwned.contains(p));
      }
      return answer.build();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }
}
