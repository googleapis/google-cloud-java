package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;

/**
 * An helper for creating keys for a specific {@link DatastoreService},
 * using its associated dataset and namespace.
 */
public final class KeyFactory extends BaseKey.Builder<KeyFactory> {

  private final DatastoreService service;

  public KeyFactory(DatastoreService service) {
    super(checkNotNull(service).options().dataset());
    this.service = service;
    namespace(service.options().namespace());
  }

  public PartialKey newKey() {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind)).build();
    return new PartialKey(dataset, namespace, path);
  }

  public Key newKey(String name) {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind, name)).build();
    return new Key(dataset, namespace, path);
  }

  public Key newKey(long id) {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind, id)).build();
    return new Key(dataset, namespace, path);
  }

  /**
   * Return a key with a newly allocated id.
   * @throws DatastoreServiceException if allocation failed.
   */
  public Key allocateId() {
    return service.allocateId(newKey());
  }

  @Override
  protected PartialKey build() {
    return newKey();
  }
}
