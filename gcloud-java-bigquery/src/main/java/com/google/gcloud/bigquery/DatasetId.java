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

package com.google.gcloud.bigquery;

import com.google.api.services.bigquery.model.DatasetReference;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google BigQuery Dataset identity.
 */
public class DatasetId implements Serializable {

  private static final long serialVersionUID = -6186254820908152300L;

  private final String project;
  private final String dataset;

  /**
   * Returns project's user-defined id
   */
  public String project() {
    return project;
  }

  /**
   * Returns dataset's user-defined id.
   */
  public String dataset() {
    return dataset;
  }

  private DatasetId(String project, String dataset) {
    this.project = project;
    this.dataset = dataset;
  }

  /**
   * Creates a dataset identity given project's and dataset's user-defined ids.
   */
  public static DatasetId of(String project, String dataset) {
    return new DatasetId(checkNotNull(project), checkNotNull(dataset));
  }

  /**
   * Creates a dataset identity given only its user-defined id.
   */
  public static DatasetId of(String dataset) {
    return new DatasetId(null, checkNotNull(dataset));
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DatasetId && Objects.equals(toPb(), ((DatasetId) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, dataset);
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  public DatasetReference toPb() {
    return new DatasetReference().setProjectId(project).setDatasetId(dataset);
  }

  public static DatasetId fromPb(DatasetReference datasetRef) {
    return new DatasetId(
        datasetRef.getProjectId(),
        datasetRef.getDatasetId());
  }
}
