/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.resourcemanager.spi.v1beta1;

import static com.google.cloud.RetryHelper.runWithRetries;
import static com.google.common.base.MoreObjects.firstNonNull;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.services.cloudresourcemanager.CloudResourceManager;
import com.google.api.services.cloudresourcemanager.model.GetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.ListProjectsResponse;
import com.google.api.services.cloudresourcemanager.model.Operation;
import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.api.services.cloudresourcemanager.model.SetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.Status;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsRequest;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsResponse;
import com.google.api.services.cloudresourcemanager.model.UndeleteProjectRequest;
import com.google.cloud.Tuple;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.resourcemanager.ResourceManagerException;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import com.google.api.client.json.JsonFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.threeten.bp.Duration;

public class HttpResourceManagerRpc implements ResourceManagerRpc {

  private static final JsonFactory JSON_FACTORY =
      new com.google.api.client.json.jackson.JacksonFactory();

  // See doc of create() for more details:
  // https://developers.google.com/resources/api-libraries/documentation/cloudresourcemanager/v1/java/latest/com/google/api/services/cloudresourcemanager/CloudResourceManager.Projects.html#create(com.google.api.services.cloudresourcemanager.model.Project)
  private static final RetrySettings CREATE_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          // SLO permits 30s at 90th percentile, double it for total limit
          .setTotalTimeout(Duration.ofMinutes(1))
          .setInitialRetryDelay(Duration.ofSeconds(5))
          .setRetryDelayMultiplier(1.5)
          // Observed P95 latency is 11s. We probably shouldn't sleep longer than this.
          .setMaxRetryDelay(Duration.ofSeconds(11))
          .setJittered(false)
          .setInitialRpcTimeout(Duration.ofSeconds(5))
          .setMaxRpcTimeout(Duration.ofSeconds(5))
          .build();

  private static final ResultRetryAlgorithm<Operation> OPERATION_HANDLER =
      new ResultRetryAlgorithm<Operation>() {
        @Override
        public TimedAttemptSettings createNextAttempt(
            Throwable prevThrowable, Operation prevResponse, TimedAttemptSettings prevSettings) {
          return null;
        }

        @Override
        public boolean shouldRetry(Throwable prevThrowable, Operation prevOp)
            throws CancellationException {
          return prevThrowable != null || prevOp.getDone() == null || prevOp.getDone() == false;
        }
      };

  private final CloudResourceManager resourceManager;
  private final ApiClock clock;

  public HttpResourceManagerRpc(ResourceManagerOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    resourceManager =
        new CloudResourceManager.Builder(transport, new JacksonFactory(), initializer)
            .setRootUrl(options.getHost())
            .setApplicationName(options.getApplicationName())
            .build();
    clock = options.getClock();
  }

  private static ResourceManagerException translate(IOException exception) {
    return new ResourceManagerException(exception);
  }

  private static ResourceManagerException translate(Status status) {
    int code;
    // reference: https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto
    switch (status.getCode()) {
      case 0:
        code = 200;
        break;
      case 1:
        code = 499;
        break;
      case 2:
        code = 500;
        break;
      case 3:
        code = 400;
        break;
      case 4:
        code = 504;
        break;
      case 5:
        code = 404;
        break;
      case 6:
        code = 409;
        break;
      case 7:
        code = 403;
        break;
      case 16:
        code = 401;
        break;
      case 8:
        code = 429;
        break;
      case 9:
        code = 400;
        break;
      case 10:
        code = 409;
        break;
      case 11:
        code = 400;
        break;
      case 12:
        code = 501;
        break;
      case 13:
        code = 500;
        break;
      case 14:
        code = 503;
        break;
      case 15:
        code = 500;
        break;
      default:
        code = BaseHttpServiceException.UNKNOWN_CODE;
    }
    return new ResourceManagerException(code, status.getMessage());
  }

  @Override
  public Project create(Project project) {
    try {
      final Operation operation = resourceManager.projects().create(project).execute();

      Operation finishedOp =
          runWithRetries(
              new Callable<Operation>() {
                @Override
                public Operation call() {
                  try {
                    return resourceManager.operations().get(operation.getName()).execute();
                  } catch (IOException ex) {
                    throw translate(ex);
                  } catch (Exception ex) {
                    throw ex;
                  }
                }
              },
              CREATE_RETRY_SETTINGS,
              OPERATION_HANDLER,
              clock);
      if (finishedOp.getError() != null) {
        throw translate(finishedOp.getError());
      }

      // NOTE(pongad): Operation.getResponse() returns a Map<String, Object>.
      // `(Project) finishedOp.getResponse()` doesn't work,
      //   because JSON deserializer in execute() didn't know to create a Project object.
      // `new Project().putAll(finishedOp.getResponse())` doesn't work either.
      //   64-bit integers are sent as strings in JSON,
      //   so execute(), not knowing the type, parses it as String, not Long.
      String responseTxt = JSON_FACTORY.toString(finishedOp.getResponse());
      return JSON_FACTORY.fromString(responseTxt, Project.class);
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
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      ResourceManagerException translated = translate(ex);
      if (translated.getCode() == HTTP_FORBIDDEN || translated.getCode() == HTTP_NOT_FOUND) {
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
          .setFields(Option.FIELDS.getString(options))
          .setFilter(Option.FILTER.getString(options))
          .setPageSize(Option.PAGE_SIZE.getInt(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
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
      resourceManager.projects().undelete(projectId, new UndeleteProjectRequest()).execute();
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
      if (translated.getCode() == HTTP_FORBIDDEN) {
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
