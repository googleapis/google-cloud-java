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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.ModelReference;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.Objects;

public final class ModelId implements Serializable {

  static final Function<ModelReference, ModelId> FROM_PB_FUNCTION =
      new Function<ModelReference, ModelId>() {
        @Override
        public ModelId apply(ModelReference pb) {
          return ModelId.fromPb(pb);
        }
      };
  static final Function<ModelId, ModelReference> TO_PB_FUNCTION =
      new Function<ModelId, ModelReference>() {
        @Override
        public ModelReference apply(ModelId modelId) {
          return modelId.toPb();
        }
      };

  private final String project;
  private final String dataset;
  private final String model;

  /** Return corresponding project ID for this model. * */
  public String getProject() {
    return project;
  }

  /** Return corresponding dataset ID for this model. * */
  public String getDataset() {
    return dataset;
  }

  /** Return corresponding model ID for this model. * */
  public String getModel() {
    return model;
  }

  private ModelId(String project, String dataset, String model) {
    this.project = project;
    this.dataset = dataset;
    this.model = model;
  }

  /** Creates a model identity given project, dataset, and model identifiers. * */
  public static ModelId of(String project, String dataset, String model) {
    return new ModelId(checkNotNull(project), checkNotNull(dataset), checkNotNull(model));
  }

  /** Creates a model identity given dataset and model identifiers. * */
  public static ModelId of(String dataset, String model) {
    return new ModelId(null, checkNotNull(dataset), checkNotNull(model));
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof ModelId && Objects.equals(toPb(), ((ModelId) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, dataset, model);
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  ModelId setProjectId(String projectId) {
    Preconditions.checkArgument(
        !Strings.isNullOrEmpty(projectId), "Provided projectId is null or empty");
    return ModelId.of(projectId, getDataset(), getModel());
  }

  ModelReference toPb() {
    return new ModelReference().setProjectId(project).setDatasetId(dataset).setModelId(model);
  }

  static ModelId fromPb(ModelReference modelRef) {
    return new ModelId(modelRef.getProjectId(), modelRef.getDatasetId(), modelRef.getModelId());
  }
}
