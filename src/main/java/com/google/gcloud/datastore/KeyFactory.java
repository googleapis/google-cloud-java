package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;

/**
 * An helper for creating keys for a specific {@link DatastoreService},
 * using its associated dataset and namespace.
 */
public final class KeyFactory extends BaseKey.Builder<KeyFactory> {

  private final DatastoreService service;

  public KeyFactory(DatastoreService service, String kind) {
    super(checkNotNull(service).options().dataset(), kind);
    this.service = service;
    namespace(service.options().namespace());
  }

  @Override
  protected PartialKey build() {
    return new PartialKey(dataset, namespace, ImmutableList.copyOf(ancestors), kind);
  }

  public PartialKey newKey() {
    return build();
  }

  public Key newKey(String name) {
    return new Key(dataset, namespace, ImmutableList.copyOf(ancestors), kind, name);
  }

  public Key newKey(long id) {
    return new Key(dataset, namespace, ImmutableList.copyOf(ancestors), kind, id);
  }

  /**
   * Return a key with a newly allocated id.
   * @throws DatastoreServiceException if allocation failed.
   */
  public Key allocateId() {
    return service.allocateId(build());
  }
}
