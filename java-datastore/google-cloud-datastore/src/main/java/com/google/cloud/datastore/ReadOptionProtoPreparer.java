/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore;

import com.google.api.core.InternalApi;
import com.google.cloud.datastore.ReadOption.EventualConsistency;
import com.google.cloud.datastore.ReadOption.ReadTime;
import com.google.cloud.datastore.ReadOption.TransactionId;
import com.google.cloud.datastore.execution.request.ProtoPreparer;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReadOptions.ReadConsistency;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@InternalApi
public class ReadOptionProtoPreparer
    implements ProtoPreparer<List<ReadOption>, Optional<ReadOptions>> {

  @Override
  public Optional<ReadOptions> prepare(List<ReadOption> options) {
    if (options == null || options.isEmpty()) {
      return Optional.empty();
    }
    com.google.datastore.v1.ReadOptions readOptionsPb = null;
    Map<Class<? extends ReadOption>, ReadOption> optionsByType = ReadOption.asImmutableMap(options);

    boolean moreThanOneReadOption = optionsByType.keySet().size() > 1;
    if (moreThanOneReadOption) {
      throw DatastoreException.throwInvalidRequest(
          String.format("Can not use %s together.", getInvalidOptions(optionsByType)));
    }

    if (optionsByType.containsKey(EventualConsistency.class)) {
      readOptionsPb = ReadOptions.newBuilder().setReadConsistency(ReadConsistency.EVENTUAL).build();
    }

    if (optionsByType.containsKey(ReadTime.class)) {
      readOptionsPb =
          ReadOptions.newBuilder()
              .setReadTime(((ReadTime) optionsByType.get(ReadTime.class)).time().toProto())
              .build();
    }

    if (optionsByType.containsKey(TransactionId.class)) {
      readOptionsPb =
          ReadOptions.newBuilder()
              .setTransaction(
                  ((TransactionId) optionsByType.get(TransactionId.class)).getTransactionId())
              .build();
    }
    return Optional.ofNullable(readOptionsPb);
  }

  private String getInvalidOptions(Map<Class<? extends ReadOption>, ReadOption> optionsByType) {
    String regex = "([a-z])([A-Z]+)";
    String replacement = "$1 $2";
    return optionsByType.keySet().stream()
        .map(Class::getSimpleName)
        .map(s -> s.replaceAll(regex, replacement).toLowerCase())
        .collect(Collectors.joining(", "));
  }
}
