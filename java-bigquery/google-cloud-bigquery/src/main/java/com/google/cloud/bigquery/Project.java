/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery;

import com.google.api.core.BetaApi;
import java.io.Serializable;
import java.util.Objects;

@BetaApi
public class Project implements Serializable {
  private static final long serialVersionUID = 1L;

  private final String id;
  private final String numericId;
  private final String projectId;
  private final String friendlyName;

  public Project(String id, String numericId, String projectId, String friendlyName) {
    this.id = id;
    this.numericId = numericId;
    this.projectId = projectId;
    this.friendlyName = friendlyName;
  }

  public String getId() {
    return id;
  }

  public String getNumericId() {
    return numericId;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getFriendlyName() {
    return friendlyName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Project project = (Project) o;
    return Objects.equals(id, project.id) &&
           Objects.equals(numericId, project.numericId) &&
           Objects.equals(projectId, project.projectId) &&
           Objects.equals(friendlyName, project.friendlyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numericId, projectId, friendlyName);
  }

  @Override
  public String toString() {
    return "Project{" +
        "id='" + id + '\'' +
        ", numericId='" + numericId + '\'' +
        ", projectId='" + projectId + '\'' +
        ", friendlyName='" + friendlyName + '\'' +
        '}';
  }
}
