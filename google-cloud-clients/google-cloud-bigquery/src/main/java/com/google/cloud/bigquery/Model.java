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

import com.google.cloud.bigquery.BigQuery.ModelOption;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Objects;

/**
 * A Google BigQuery ML Model.
 *
 * <p>Objects of this class are immutable. Operations that modify the table like {@link #update}
 * return a new object. To get a {@code Model} object with the most recent information use {@link
 * #reload}.
 */
public class Model extends ModelInfo {

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  public static class Builder extends ModelInfo.Builder {

    private final BigQuery bigquery;
    private final ModelInfo.BuilderImpl infoBuilder;

    Builder(BigQuery bigquery, ModelId modelId) {
      this.bigquery = bigquery;
      this.infoBuilder = new ModelInfo.BuilderImpl();
      this.infoBuilder.setModelId(modelId);
    }

    Builder(Model model) {
      this.bigquery = model.bigquery;
      this.infoBuilder = new ModelInfo.BuilderImpl(model);
    }

    @Override
    Builder setCreationTime(Long creationTime) {
      infoBuilder.setCreationTime(creationTime);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    public Builder setExpirationTime(Long expirationTime) {
      infoBuilder.setExpirationTime(expirationTime);
      return this;
    }

    @Override
    public Builder setFriendlyName(String friendlyName) {
      infoBuilder.setFriendlyName(friendlyName);
      return this;
    }

    @Override
    Builder setLastModifiedTime(Long lastModifiedTime) {
      infoBuilder.setLastModifiedTime(lastModifiedTime);
      return this;
    }

    @Override
    public Builder setModelId(ModelId modelId) {
      infoBuilder.setModelId(modelId);
      return this;
    }

    @Override
    Builder setModelType(String modelType) {
      infoBuilder.setModelType(modelType);
      return this;
    }

    @Override
    public Builder setLabels(Map<String, String> labels) {
      infoBuilder.setLabels(labels);
      return this;
    }

    public Model build() {
      return new Model(bigquery, infoBuilder);
    }
  }

  Model(BigQuery bigquery, ModelInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.bigquery = checkNotNull(bigquery);
    this.options = bigquery.getOptions();
  }

  /**
   * Check if this model exists.
   *
   * @return {@code true} if this table exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getModel(getModelId(), ModelOption.fields()) != null;
  }

  /**
   * Fetches current model's state from the service. Returns {@code null} if the model does not
   * exist. A new {@code Model} is returned.
   *
   * @param options model options
   * @return a {@code Model} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Model reload(ModelOption... options) {
    return bigquery.getModel(getModelId(), options);
  }

  /**
   * Updates the model's information with this model's information. Dataset and model identifiers
   * cannot be updated. A new {@code Model} object is returned.
   *
   * @param options dataset options
   * @return a {@code Model} object with updated information
   * @throws BigQueryException upon failure
   */
  public Model update(ModelOption... options) {
    return bigquery.update(this, options);
  }

  /**
   * Deletes this model.
   *
   * @return {@code true} if model was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(getModelId());
  }

  /** Return's the model's {@code BigQuery} object used to issue requests. * */
  public BigQuery getBigQuery() {
    return bigquery;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Model.class)) {
      return false;
    }
    Model other = (Model) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.getService();
  }

  static Model fromPb(BigQuery bigquery, com.google.api.services.bigquery.model.Model modelPb) {
    return new Model(bigquery, new ModelInfo.BuilderImpl(modelPb));
  }
}
