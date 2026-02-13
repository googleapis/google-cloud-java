/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BatchImpl extends BaseDatastoreBatchWriter implements Batch {

  private final DatastoreImpl datastore;

  static class ResponseImpl implements Batch.Response {

    private final com.google.datastore.v1.CommitResponse response;
    private final int numAutoAllocatedIds;

    ResponseImpl(com.google.datastore.v1.CommitResponse response, int numAutoAllocatedIds) {
      this.response = response;
      this.numAutoAllocatedIds = numAutoAllocatedIds;
    }

    @Override
    public List<Key> getGeneratedKeys() {
      Iterator<com.google.datastore.v1.MutationResult> results =
          response.getMutationResultsList().iterator();
      List<Key> generated = new ArrayList<>(numAutoAllocatedIds);
      for (int i = 0; i < numAutoAllocatedIds; i++) {
        generated.add(Key.fromPb(results.next().getKey()));
      }
      return generated;
    }
  }

  BatchImpl(DatastoreImpl datastore) {
    super("batch");
    this.datastore = datastore;
  }

  @Override
  public Batch.Response submit() {
    validateActive();
    List<com.google.datastore.v1.Mutation> mutationsPb = toMutationPbList();
    com.google.datastore.v1.CommitRequest.Builder requestPb =
        com.google.datastore.v1.CommitRequest.newBuilder();
    requestPb.setMode(com.google.datastore.v1.CommitRequest.Mode.NON_TRANSACTIONAL);
    requestPb.addAllMutations(mutationsPb);
    requestPb.setProjectId(datastore.getOptions().getProjectId());
    requestPb.setDatabaseId(datastore.getOptions().getDatabaseId());
    com.google.datastore.v1.CommitResponse responsePb = datastore.commit(requestPb.build());
    deactivate();
    return new ResponseImpl(responsePb, toAddAutoId().size());
  }

  @Override
  public Datastore getDatastore() {
    return datastore;
  }
}
