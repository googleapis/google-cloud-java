/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.EntityServiceClient.ListWatchlistsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import google.cloud.chronicle.v1.CreateWatchlistRequest;
import google.cloud.chronicle.v1.DeleteWatchlistRequest;
import google.cloud.chronicle.v1.GetWatchlistRequest;
import google.cloud.chronicle.v1.ListWatchlistsRequest;
import google.cloud.chronicle.v1.ListWatchlistsResponse;
import google.cloud.chronicle.v1.UpdateWatchlistRequest;
import google.cloud.chronicle.v1.Watchlist;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EntityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EntityServiceStub implements BackgroundResource {

  public UnaryCallable<GetWatchlistRequest, Watchlist> getWatchlistCallable() {
    throw new UnsupportedOperationException("Not implemented: getWatchlistCallable()");
  }

  public UnaryCallable<ListWatchlistsRequest, ListWatchlistsPagedResponse>
      listWatchlistsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWatchlistsPagedCallable()");
  }

  public UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse> listWatchlistsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWatchlistsCallable()");
  }

  public UnaryCallable<CreateWatchlistRequest, Watchlist> createWatchlistCallable() {
    throw new UnsupportedOperationException("Not implemented: createWatchlistCallable()");
  }

  public UnaryCallable<UpdateWatchlistRequest, Watchlist> updateWatchlistCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWatchlistCallable()");
  }

  public UnaryCallable<DeleteWatchlistRequest, Empty> deleteWatchlistCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWatchlistCallable()");
  }

  @Override
  public abstract void close();
}
