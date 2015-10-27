package com.google.gcloud;

/**
 * Implementation of this interface can persist their state and restore from it.
 *
 * <p>
 * A typical capture usage:
 * <pre>  {@code
 * X restorableObj; // X instanceof Restorable<X>
 * RestorableState<X> state = restorableObj.capture();
 * .. persist state
 * }</pre>
 *
 * A typical restore usage:
 * <pre>  {@code
 * RestorableState<X> state = ... // read from persistence
 * X restorableObj = state.restore();
 * ...
 * }</pre>
 */
public interface Restorable<T extends Restorable<T>> {

  /**
   * Captures the state of this object.
   *
   * @return a {@link RestorableState} instance that contains the state for this object and can
   *     restore it afterwards.
   */
  RestorableState<T> capture();
}
