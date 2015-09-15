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

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gcloud.datastore.BatchOption.ForceWrites;

import java.util.List;
import java.util.Map;


class BatchImpl extends BaseDatastoreBatchWriter implements Batch {

  private final DatastoreImpl datastore;
  private final boolean force;

  static class ResponseImpl implements Batch.Response {

    private final com.google.datastore.v1beta3.CommitResponse response;

    ResponseImpl(com.google.datastore.v1beta3.CommitResponse response) {
      this.response = response;
    }

    @Override
    public List<Key> generatedKeys() {
      return Lists.transform(response.getMutationResult().getInsertAutoIdKeyList(),
          new Function<com.google.datastore.v1beta3.Key, Key>() {
            @Override public Key apply(com.google.datastore.v1beta3.Key keyPb) {
              // TODO(ajaykannan): uncomment when possible in datastore v1beta3 transition
              //return Key.fromPb(keyPb);
              return Key.builder(null).build(); // TODO(ajaykannan): remove this line when possible
            }
          });
    }
  }

  BatchImpl(DatastoreImpl datastore, BatchOption... options) {
    super("batch");
    this.datastore = datastore;
    Map<Class<? extends BatchOption>, BatchOption> optionsMap = BatchOption.asImmutableMap(options);
    if (optionsMap.containsKey(ForceWrites.class)) {
      force = ((ForceWrites) optionsMap.get(ForceWrites.class)).force();
    } else {
      force = datastore.options().force();
    }
  }

  @Override
  public Batch.Response submit() {
    validateActive();
    com.google.datastore.v1beta3.Mutation.Builder mutationPb = toMutationPb();
    com.google.datastore.v1beta3.CommitRequest.Builder requestPb = com.google.datastore.v1beta3.CommitRequest.newBuilder();
    requestPb.setMode(com.google.datastore.v1beta3.CommitRequest.Mode.NON_TRANSACTIONAL);
    requestPb.setMutation(mutationPb);
    com.google.datastore.v1beta3.CommitResponse responsePb = datastore.commit(requestPb.build());
    deactivate();
    return new ResponseImpl(responsePb);
  }

  @Override
  public Datastore datastore() {
    return datastore;
  }
}
