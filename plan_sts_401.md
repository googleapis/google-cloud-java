## Phase 4: STS 401 Interceptor and Certificate Rotation

**Goal:** Ensure that underlying mTLS transports reload rotating certificates when the STS endpoint returns a 401 Unauthorized, completing the second half of the bound-token design.

### 1. Code Changes
*   **Target:** `com.google.auth.oauth2.ExternalAccountCredentials` / `StsTokenExchangeRequest` pipeline.
*   **Implementation:** 
    *   Attach an `HttpUnsuccessfulResponseHandler` to the HTTP request that executes the STS token exchange.
    *   Inside the handler, if a `401 Unauthorized` is encountered, check if the transport is mTLS-enabled (e.g., check if the transport factory implements an interface or callback for reloading).
    *   If applicable, explicitly trigger the transport factory to clear its cache and reload the certificates (`KeyStore`) from disk.
    *   Return `true` from the handler to instruct `google-http-client` to automatically retry the STS request with the newly loaded certificates.

### 2. Test Updates
*   **Target:** `ExternalAccountCredentialsTest.java` (and related STS test classes).
*   **Implementation:** 
    *   Mock the STS transport to yield a `401 Unauthorized` response on the first execution and a `200 OK` on the successive retry.
    *   Assert that the STS exchange ultimately succeeds.
    *   Assert that the certificate reload callback was strictly invoked between the first and second mock responses by spying on the transport factory or using a counter.

### 3. Branching & PR Strategy
*   We will branch off `agentic-identities-bound-token` (the same target feature branch).
*   We'll create a dedicated PR focusing exclusively on the STS 401 Interceptor and its tests to keep reviews manageable.

### 4. Dependency Verification
*   You mentioned PRs #13901 and #13873. I've verified that **they are not hard dependencies** for this work to merge into the feature branch. 
*   **Reason:** Those PRs operate within the `GAX` layer (handling self-healing and retries for gRPC/HTTP channels during higher-level API calls). This STS rotation work operates entirely downstream inside `google-auth-library-java` using `google-http-client`. Since `GAX` depends on `google-auth-library-java` (and not vice versa), we can independently implement and merge this STS 401 handler without any blocked compilations or structural conflicts. The true value is realized when both land, but their development and merges can happen in parallel.
