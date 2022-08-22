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
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.services.cloudresourcemanager.CloudResourceManager;
import com.google.api.services.cloudresourcemanager.model.ClearOrgPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.Constraint;
import com.google.api.services.cloudresourcemanager.model.GetEffectiveOrgPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.GetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.GetOrgPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.ListAvailableOrgPolicyConstraintsRequest;
import com.google.api.services.cloudresourcemanager.model.ListAvailableOrgPolicyConstraintsResponse;
import com.google.api.services.cloudresourcemanager.model.ListOrgPoliciesRequest;
import com.google.api.services.cloudresourcemanager.model.ListOrgPoliciesResponse;
import com.google.api.services.cloudresourcemanager.model.ListProjectsResponse;
import com.google.api.services.cloudresourcemanager.model.Operation;
import com.google.api.services.cloudresourcemanager.model.OrgPolicy;
import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.api.services.cloudresourcemanager.model.SetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.SetOrgPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.Status;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsRequest;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsResponse;
import com.google.api.services.cloudresourcemanager.model.UndeleteProjectRequest;
import com.google.cloud.RetryHelper;
import com.google.cloud.Tuple;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.resourcemanager.ResourceManagerException;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.threeten.bp.Duration;

/** @deprecated v3 GAPIC client of ResourceManager is now available */
@Deprecated
public class HttpResourceManagerRpc implements ResourceManagerRpc {

  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

  // See doc of create() for more details:
  // https://developers.google.com/resources/api-libraries/documentation/cloudresourcemanager/v1/java/latest/com/google/api/services/cloudresourcemanager/CloudResourceManager.Projects.html#create(com.google.api.services.cloudresourcemanager.model.Project)
  private static final RetrySettings CREATE_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          // SLO permits 30s at 90th percentile, 4x it for total limit.
          // Observed latency is much lower: 11s at 95th percentile.
          .setTotalTimeout(Duration.ofMinutes(2))
          // Linked doc recommends polling at 5th second.
          .setInitialRetryDelay(Duration.ofSeconds(5))
          .setRetryDelayMultiplier(1.5)
          // Observed P95 latency is 11s. We probably shouldn't sleep longer than this.
          .setMaxRetryDelay(Duration.ofSeconds(11))
          .setJittered(true)
          .setInitialRpcTimeout(Duration.ofSeconds(5))
          .setMaxRpcTimeout(Duration.ofSeconds(5))
          .build();

  // reference: https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto
  private static final ImmutableMap<Integer, Integer> RPC_TO_HTTP_CODES =
      ImmutableMap.<Integer, Integer>builder()
          .put(0, 200)
          .put(1, 499)
          .put(2, 500)
          .put(3, 400)
          .put(4, 504)
          .put(5, 404)
          .put(6, 409)
          .put(7, 403)
          .put(16, 401)
          .put(8, 429)
          .put(9, 400)
          .put(10, 409)
          .put(11, 400)
          .put(12, 501)
          .put(13, 500)
          .put(14, 503)
          .put(15, 500)
          .build();

  private static final ResultRetryAlgorithm<Operation> OPERATION_HANDLER =
      new ResultRetryAlgorithm<Operation>() {
        @Override
        public TimedAttemptSettings createNextAttempt(
            Throwable prevThrowable, Operation prevResponse, TimedAttemptSettings prevSettings) {
          return null;
        }

        @Override
        public boolean shouldRetry(Throwable prevThrowable, Operation prevOp) {
          if (prevThrowable == null) {
            return prevOp.getDone() == null || !prevOp.getDone();
          }
          return prevThrowable instanceof ResourceManagerException
              && ((ResourceManagerException) prevThrowable).isRetryable();
        }
      };

  private final CloudResourceManager resourceManager;
  private final ApiClock clock;

  public HttpResourceManagerRpc(ResourceManagerOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    resourceManager =
        new CloudResourceManager.Builder(transport, JSON_FACTORY, initializer)
            .setRootUrl(options.getHost())
            .setApplicationName(options.getApplicationName())
            .build();
    clock = options.getClock();
  }

  private static ResourceManagerException translate(IOException exception) {
    return new ResourceManagerException(exception);
  }

  private static ResourceManagerException translate(Status status) {
    Integer code = RPC_TO_HTTP_CODES.get(status.getCode());
    if (code == null) {
      code = BaseHttpServiceException.UNKNOWN_CODE;
    }
    return new ResourceManagerException(code, status.getMessage());
  }

  @Override
  public Project create(Project project) {
    final Operation operation;
    try {
      operation = resourceManager.projects().create(project).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }

    Operation finishedOp =
        runWithRetries(
            new Callable<Operation>() {
              @Override
              public Operation call() {
                try {
                  return resourceManager.operations().get(operation.getName()).execute();
                } catch (IOException ex) {
                  throw translate(ex);
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
    // 1. `(Project) finishedOp.getResponse()` doesn't work,
    // because JSON deserializer in execute() didn't know to create a Project object.
    // 2. `new Project().putAll(finishedOp.getResponse())` doesn't work either.
    // 64-bit integers are sent as strings in JSON,
    // so execute(), not knowing the type, parses it as String, not Long.
    try {
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
      return resourceManager
          .projects()
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
      ListProjectsResponse response =
          resourceManager
              .projects()
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
      return resourceManager
          .projects()
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
      return resourceManager
          .projects()
          .setIamPolicy(projectId, new SetIamPolicyRequest().setPolicy(newPolicy))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public List<Boolean> testPermissions(String projectId, List<String> permissions)
      throws ResourceManagerException {
    try {
      TestIamPermissionsResponse response =
          resourceManager
              .projects()
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

  @Override
  public Map<String, Boolean> testOrgPermissions(String resource, List<String> permissions)
      throws IOException {
    try {
      TestIamPermissionsResponse response =
          resourceManager
              .organizations()
              .testIamPermissions(
                  resource, new TestIamPermissionsRequest().setPermissions(permissions))
              .execute();
      Set<String> permissionsOwned =
          ImmutableSet.copyOf(firstNonNull(response.getPermissions(), ImmutableList.<String>of()));
      ImmutableMap.Builder<String, Boolean> answer = ImmutableMap.builder();
      for (String permission : permissions) {
        answer.put(permission, permissionsOwned.contains(permission));
      }
      return answer.build();
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public void clearOrgPolicy(String resource, OrgPolicy orgPolicy) throws IOException {
    try {
      resourceManager
          .folders()
          .clearOrgPolicy(
              resource,
              new ClearOrgPolicyRequest()
                  .setConstraint(orgPolicy.getConstraint())
                  .setEtag(orgPolicy.getEtag()))
          .execute();
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public OrgPolicy getEffectiveOrgPolicy(String resource, String constraint) throws IOException {
    try {
      return resourceManager
          .folders()
          .getEffectiveOrgPolicy(
              resource, new GetEffectiveOrgPolicyRequest().setConstraint(constraint))
          .execute();
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public OrgPolicy getOrgPolicy(String resource, String constraint) throws IOException {
    try {
      return resourceManager
          .folders()
          .getOrgPolicy(resource, new GetOrgPolicyRequest().setConstraint(constraint))
          .execute();
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public ListResult<Constraint> listAvailableOrgPolicyConstraints(
      String resource, Map<Option, ?> options) throws IOException {
    try {
      ListAvailableOrgPolicyConstraintsResponse response =
          resourceManager
              .folders()
              .listAvailableOrgPolicyConstraints(
                  resource,
                  new ListAvailableOrgPolicyConstraintsRequest()
                      .setPageSize(Option.PAGE_SIZE.getInt(options))
                      .setPageToken(Option.PAGE_TOKEN.getString(options)))
              .execute();
      return ListResult.of(response.getNextPageToken(), response.getConstraints());
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public ListResult<OrgPolicy> listOrgPolicies(String resource, Map<Option, ?> options)
      throws IOException {
    try {
      ListOrgPoliciesResponse response =
          resourceManager
              .folders()
              .listOrgPolicies(
                  resource,
                  new ListOrgPoliciesRequest()
                      .setPageSize(Option.PAGE_SIZE.getInt(options))
                      .setPageToken(Option.PAGE_TOKEN.getString(options)))
              .execute();
      return ListResult.of(response.getNextPageToken(), response.getPolicies());
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public OrgPolicy replaceOrgPolicy(String resource, OrgPolicy orgPolicy) throws IOException {
    try {
      return resourceManager
          .folders()
          .setOrgPolicy(resource, new SetOrgPolicyRequest().setPolicy(orgPolicy))
          .execute();
    } catch (RetryHelper.RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }
}
