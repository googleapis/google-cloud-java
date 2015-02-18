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

package com.google.gcloud.datastore;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.gcloud.datastore.Validator.validateDataset;
import static com.google.gcloud.datastore.Validator.validateNamespace;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.EntityResult;
import com.google.api.services.datastore.DatastoreV1.LookupResponse;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreOptions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.gcloud.ServiceOptions;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class DatastoreServiceOptions extends ServiceOptions {

  private static final String DATASET_ENV_NAME = "DATASTORE_DATASET";
  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final String USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE, USERINFO_SCOPE);
  private final String dataset;
  private final String namespace;
  private final boolean force;
  private final Datastore datastore;
  private final boolean normalizeDataset;

  public static class Builder extends ServiceOptions.Builder<Builder> {

    private String dataset;
    private String namespace;
    private boolean force;
    private Datastore datastore;
    private boolean normalizeDataset = true;

    private Builder() {
    }

    private Builder(DatastoreServiceOptions options) {
      super(options);
      dataset = options.dataset;
      force = options.force;
      namespace = options.namespace;
      datastore = options.datastore;
      normalizeDataset = options.normalizeDataset;
    }

    @Override
    public DatastoreServiceOptions build() {
      return new DatastoreServiceOptions(this);
    }

    public Builder datastore(Datastore datastore) {
      this.datastore = datastore;
      return this;
    }

    public Builder dataset(String dataset) {
      this.dataset = validateDataset(dataset);
      return this;
    }

    public Builder namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }

    public Builder force(boolean force) {
      this.force = force;
      return this;
    }

    Builder normalizeDataset(boolean normalizeDataset) {
      this.normalizeDataset = normalizeDataset;
      return this;
    }
  }

  private DatastoreServiceOptions(Builder builder) {
    super(builder);
    normalizeDataset = builder.normalizeDataset;
    namespace = builder.namespace != null ? builder.namespace : defaultNamespace();
    force = builder.force;

    // Replace provided dataset with full dataset (s~xxx, e~xxx,...)
    String tempDataset = firstNonNull(builder.dataset, defaultDataset());
    Datastore tempDatastore = firstNonNull(builder.datastore,
        defaultDatastore(tempDataset, host(), httpRequestInitializer()));
    if (builder.normalizeDataset) {
      DatastoreV1.LookupRequest.Builder requestPb = DatastoreV1.LookupRequest.newBuilder();
      DatastoreV1.Key key = DatastoreV1.Key.newBuilder()
          .addPathElement(DatastoreV1.Key.PathElement.newBuilder().setKind("__foo__").setName("bar"))
          .build();
      requestPb.addKey(key);
      try {
        LookupResponse responsePb = tempDatastore.lookup(requestPb.build());
        if (responsePb.getDeferredCount() > 0) {
          key = responsePb.getDeferred(0);
        } else {
          Iterator<EntityResult> combinedIter =
              Iterables.concat(responsePb.getMissingList(), responsePb.getFoundList()).iterator();
          key = combinedIter.next().getEntity().getKey();
        }
        dataset = key.getPartitionId().getDatasetId();
        if (builder.datastore == null && !dataset.equals(tempDataset)) {
          datastore = defaultDatastore(dataset, host(), httpRequestInitializer());
        } else {
          datastore = tempDatastore;
        }
      } catch (DatastoreException e) {
        throw DatastoreServiceException.translateAndThrow(e);
      }
    } else {
      dataset = tempDataset;
      datastore = tempDatastore;
    }
  }

  private static Datastore defaultDatastore(
      String dataset, String host, HttpRequestInitializer initializer) {
    DatastoreOptions options = new DatastoreOptions.Builder()
        .dataset(dataset)
        .host(host)
        .initializer(initializer)
        .build();
    return DatastoreFactory.get().create(options);
  }

  private static String defaultDataset() {
    String dataset = System.getProperty(DATASET_ENV_NAME, System.getenv(DATASET_ENV_NAME));
    if (dataset == null) {
      dataset = appEngineAppId();
    }
    return dataset != null ? dataset : googleCloudProjectId();
  }

  public String dataset() {
    return dataset;
  }

  public String namespace() {
    return namespace;
  }

  private static String defaultNamespace() {
    // TODO(ozarov): An alternative to reflection would be to depend on AE api jar:
    // http://mvnrepository.com/artifact/com.google.appengine/appengine-api-1.0-sdk/1.2.0
    try {
      Class<?> clazz = Class.forName("com.google.appengine.api.NamespaceManager");
      Method method = clazz.getMethod("get");
      String namespace = (String) method.invoke(null);
      return namespace == null || namespace.isEmpty() ? null : namespace;
    } catch (Exception ignore) {
      // return null (Datastore default namespace) if could not automatically determine
      return null;
    }
  }

  public boolean force() {
    return force;
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public Datastore datastore() {
    return datastore;
  }

  public static Builder builder() {
    return new Builder();
  }
}
