package com.google.gcloud;

/**
 * Implementation of this interface can persist their state and restore from it.
 */
public interface Restorable<T extends Restorable<T>> {

  /**
   * Capture the state of this object.
   *
   * @return a {@link RestorableState} instance that contains the state for this object and can
   *     restore it afterwards.
   */
  RestorableState<T> capture();
}
