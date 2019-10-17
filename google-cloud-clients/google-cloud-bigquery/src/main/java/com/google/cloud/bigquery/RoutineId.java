/*
 * Copyright 2019 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.api.services.bigquery.model.RoutineReference;
import com.google.common.base.Function;
import java.io.Serializable;
import java.util.Objects;

/** RoutineId represents the identifier for a given Routine. */
public final class RoutineId implements Serializable {

  static final Function<RoutineReference, RoutineId> FROM_PB_FUNCTION =
      new Function<RoutineReference, RoutineId>() {
        @Override
        public RoutineId apply(RoutineReference pb) {
          return RoutineId.fromPb(pb);
        }
      };
  static final Function<RoutineId, RoutineReference> TO_PB_FUNCTION =
      new Function<RoutineId, RoutineReference>() {
        @Override
        public RoutineReference apply(RoutineId routineId) {
          return routineId.toPb();
        }
      };

  private final String project;
  private final String dataset;
  private final String routine;

  /** Return corresponding project ID for this routine. * */
  public String getProject() {
    return project;
  }

  /** Return corresponding dataset ID for this routine. * */
  public String getDataset() {
    return dataset;
  }

  /** Return corresponding routine ID for this routine. * */
  public String getRoutine() {
    return routine;
  }

  private RoutineId(String project, String dataset, String routine) {
    checkArgument(!isNullOrEmpty(dataset), "Provided dataset is null or empty");
    checkArgument(!isNullOrEmpty(routine), "Provided routine is null or empty");
    this.project = project;
    this.dataset = dataset;
    this.routine = routine;
  }

  /** Creates a routine identity given project, dataset, and routine identifiers. * */
  public static RoutineId of(String project, String dataset, String routine) {
    return new RoutineId(project, dataset, routine);
  }

  /** Creates a routine identity given dataset and routine identifiers. * */
  public static RoutineId of(String dataset, String routine) {
    return new RoutineId(null, dataset, routine);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof RoutineId && Objects.equals(toPb(), ((RoutineId) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, dataset, routine);
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  RoutineId setProjectId(String projectId) {
    checkArgument(!isNullOrEmpty(projectId), "Provided projectId is null or empty");
    return RoutineId.of(projectId, getDataset(), getRoutine());
  }

  RoutineReference toPb() {
    return new RoutineReference().setProjectId(project).setDatasetId(dataset).setRoutineId(routine);
  }

  static RoutineId fromPb(RoutineReference routineRef) {
    return new RoutineId(
        routineRef.getProjectId(), routineRef.getDatasetId(), routineRef.getRoutineId());
  }
}
