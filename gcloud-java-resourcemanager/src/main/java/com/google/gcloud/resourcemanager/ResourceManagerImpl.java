/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.resourcemanager;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.gcloud.RetryHelper.runWithRetries;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.gcloud.BaseService;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.PageImpl.NextPageFetcher;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.spi.ResourceManagerRpc;
import com.google.gcloud.spi.ResourceManagerRpc.Tuple;

import java.util.Map;
import java.util.concurrent.Callable;

final class ResourceManagerImpl
    extends BaseService<ResourceManagerOptions> implements ResourceManager {

  private final ResourceManagerRpc resourceManagerRpc;

  ResourceManagerImpl(ResourceManagerOptions options) {
    super(options);
    resourceManagerRpc = options.rpc();
  }

  @Override
  public Project create(final ProjectInfo project) {
    try {
      return Project.fromPb(this, runWithRetries(
          new Callable<com.google.api.services.cloudresourcemanager.model.Project>() {
            @Override
            public com.google.api.services.cloudresourcemanager.model.Project call() {
              return resourceManagerRpc.create(project.toPb());
            }
          }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelperException e) {
      throw ResourceManagerException.translateAndThrow(e);
    }
  }

  @Override
  public void delete(final String projectId) {
    try {
      runWithRetries(new Callable<Void>() {
        @Override
        public Void call() {
          resourceManagerRpc.delete(projectId);
          return null;
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw ResourceManagerException.translateAndThrow(e);
    }
  }

  @Override
  public Project get(final String projectId, ProjectGetOption... options) {
    final Map<ResourceManagerRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.cloudresourcemanager.model.Project answer = runWithRetries(
          new Callable<com.google.api.services.cloudresourcemanager.model.Project>() {
            @Override
            public com.google.api.services.cloudresourcemanager.model.Project call() {
              return resourceManagerRpc.get(projectId, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : Project.fromPb(this, answer);
    } catch (RetryHelperException e) {
      throw ResourceManagerException.translateAndThrow(e);
    }
  }

  private static class ProjectPageFetcher implements NextPageFetcher<Project> {

    private static final long serialVersionUID = 2158209410430566961L;
    private final Map<ResourceManagerRpc.Option, ?> requestOptions;
    private final ResourceManagerOptions serviceOptions;

    ProjectPageFetcher(ResourceManagerOptions serviceOptions, String cursor,
        Map<ResourceManagerRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ResourceManagerRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Project> nextPage() {
      return listProjects(serviceOptions, requestOptions);
    }
  }

  @Override
  public Page<Project> list(ProjectListOption... options) {
    return listProjects(options(), optionMap(options));
  }

  private static Page<Project> listProjects(final ResourceManagerOptions serviceOptions,
      final Map<ResourceManagerRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> result =
          runWithRetries(new Callable<Tuple<String,
              Iterable<com.google.api.services.cloudresourcemanager.model.Project>>>() {
                @Override
                public Tuple<String,
                    Iterable<com.google.api.services.cloudresourcemanager.model.Project>> call() {
                  return serviceOptions.rpc().list(optionsMap);
                }
              },
              serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.x();
      Iterable<Project> projects =
          result.y() == null
              ? ImmutableList.<Project>of() : Iterables.transform(
                  result.y(),
                  new Function<com.google.api.services.cloudresourcemanager.model.Project,
                      Project>() {
                    @Override
                    public Project apply(
                        com.google.api.services.cloudresourcemanager.model.Project projectPb) {
                      return new Project(
                          serviceOptions.service(), new ProjectInfo.BuilderImpl(ProjectInfo.fromPb(projectPb)));
                    }
                  });
      return new PageImpl<>(
          new ProjectPageFetcher(serviceOptions, cursor, optionsMap), cursor, projects);
    } catch (RetryHelperException e) {
      throw ResourceManagerException.translateAndThrow(e);
    }
  }

  @Override
  public Project replace(final ProjectInfo newProject) {
    try {
      return Project.fromPb(this, runWithRetries(
          new Callable<com.google.api.services.cloudresourcemanager.model.Project>() {
            @Override
            public com.google.api.services.cloudresourcemanager.model.Project call() {
              return resourceManagerRpc.replace(newProject.toPb());
            }
          }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelperException e) {
      throw ResourceManagerException.translateAndThrow(e);
    }
  }

  @Override
  public void undelete(final String projectId) {
    try {
      runWithRetries(new Callable<Void>() {
        @Override
        public Void call() {
          resourceManagerRpc.undelete(projectId);
          return null;
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw ResourceManagerException.translateAndThrow(e);
    }
  }

  private Map<ResourceManagerRpc.Option, ?> optionMap(Option... options) {
    Map<ResourceManagerRpc.Option, Object> temp = Maps.newEnumMap(ResourceManagerRpc.Option.class);
    for (Option option : options) {
      Object prev = temp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return ImmutableMap.copyOf(temp);
  }
}
