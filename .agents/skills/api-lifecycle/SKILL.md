---
name: api-lifecycle
description: Guidelines and playbooks for managing the API lifecycle (BetaApi, GA, ObsoleteApi, Deprecated, and Removal) in the Google Cloud Java SDK. Use this skill when modifying, deprecating, or introducing new public API surfaces.
---

# API Lifecycle & Stability Guide

This guide defines the lifecycle phases and stability annotations of public APIs inside the Google Cloud Java SDK. Use this to ensure all public methods, classes, and fields correctly adhere to Semantic Versioning (Semver) and safely transition through deprecation phases.

> [!IMPORTANT]
> **Scope & Visibility Rule**
> This guideline applies **ONLY to public API surfaces** (e.g., `public` classes, interfaces, methods, and fields) that are exposed to external/downstream consumers. It does **NOT** apply to private, package-private, or internal implementation details.

---

## Design Principle: Minimize Public API Surface

To reduce maintenance overhead and ensure long-term flexibility, developers should actively avoid creating public APIs unless absolutely necessary.

*   **Default to Restrictive Visibility**: Always default to the most restrictive access modifier (`private`, `package-private`, or `@InternalApi`) for new classes, methods, and fields. Only expose an API as `public` if there is a clear, justified requirement for external consumers.
*   **Exposing Public APIs Commits Us**: Every public class, method, or field represents a strict compatibility contract under Semantic Versioning. Once public, modifying or removing it requires a long, multi-phase deprecation cycle.
*   Prefer Internal Utilities: If functionality is only needed within the same package or module, keep it private or package-private. Do not make it public "just in case".

---

## The API Lifecycle Flow

An API does **not** have to start with `@BetaApi`. Stable, well-designed features can be introduced directly as General Availability (GA). The `@BetaApi` annotation is reserved for experimental, preview, or unstable APIs.

Below is the transition flow for public APIs:

**Standard Lifecycle (Direct to GA):**
`General Availability (GA) ──> @ObsoleteApi (Staged Deprecation) ──> @Deprecated (Official) ──> Removed`

**Experimental Lifecycle (Beta first):**
`@BetaApi (Experimental) ──> General Availability (GA) ──> @ObsoleteApi (Staged Deprecation) ──> @Deprecated (Official) ──> Removed`

---

## API Lifecycle Stages

### 1. `@BetaApi` (Experimental Phase)
*   **Purpose**: Used for experimental, preview, or unstable API surfaces.
*   **Semver Policy**: Treated as a **"0.x" feature inside a "1.x" library**. Subject to incompatible changes or removal between minor and patch releases at any time.
*   **Graduation Policy**: Not all APIs start here. Many APIs go directly to GA. If an API does start as `@BetaApi`, it is intended to eventually graduate to a GA feature by removing the `@BetaApi` annotation.
*   **Usage Rule**: Do **NOT** depend on `@BetaApi` features inside a public library `B` that has downstream consumers, *unless* the consuming components of library `B` are also marked with `@BetaApi`.
*   **Exception**: `google-cloud-java` is allowed to depend on `@BetaApi` features in `gax-java` without declaring the consuming code `@BetaApi`, as they move in lockstep.

### 2. General Availability (GA)
*   **Purpose**: Stable API surfaces intended for production use.
*   Policy: Deprecation or breaking changes to GA APIs are considered breaking changes and should generally not be performed under a minor version release using standard @Deprecated.

### 3. `@ObsoleteApi` (Staged Deprecation)
*   **Purpose**: Signals to users that an API will be deprecated in a future version, allowing them to transition to alternative methods before official deprecation.
*   **Policy**: Used during minor version releases.
*   **Usage Guidelines**:
    *   **Annotation**: Apply `@ObsoleteApi("Reason or alternative instructions")`. A descriptive reason is required.
    *   **Javadoc**: Detail the replacement or migration path, referencing alternative methods via `{@link}`.
    *   **IDE Impact**: Does not trigger IDE compilation/strike-through warnings, keeping downstream builds warning-free.

### 4. `@Deprecated` (Official Deprecation)
*   **Purpose**: Officially deprecates the API in the editor/IDE, producing compiler warnings and strike-throughs.
*   **Policy**: Strongly recommended to be applied during **Major Version Releases** (e.g., `v2.0.0`), or in rare emergency cases to fix critical security vulnerabilities. However, it can be acceptable in minor version releases if the library owners explicitly review and determine that the deprecation is low-risk for downstream consumers.
*   **Usage Guidelines**:
    *   **Annotation**: Apply Java's standard `@Deprecated` annotation to the code element.
    *   **Javadoc**: Add the standard `@deprecated` Javadoc tag describing alternative APIs or transition steps.

### 5. Removal
*   **Purpose**: Complete removal of the API from the codebase.
*   **Policy**: Performed in a subsequent major version release following official deprecation.
*   **Usage Guidelines**:
    *   **Action**: Completely delete the class, interface, method, or field, along with its Javadoc and annotations.
    *   **Validation**: Verify that all internal usages, references, and tests within the monorepo are fully cleaned up or migrated.

---

## API Stability & Visibility Annotations

While the standard **API Lifecycle Stages** section above defines how public APIs transition over time, the SDK also utilizes specialized stability annotations. These annotations serve as "exceptions" or "special contracts" that dictate how Semantic Versioning applies to public elements:

### 1. `@InternalApi`
*   **Definition**: Technically `public` because of Java's access modifier limitations, but intended **only** for internal use.
*   **Semver Policy**: For the purposes of semver, these are considered **private**. They can be modified or deleted in any minor or patch release without breaking compatibility.

### 2. `@InternalExtensionOnly`
*   **Definition**: A `public` interface that is only intended to be implemented by internal SDK classes, though it can be consumed publicly.
*   **Semver Policy**: We reserve the right to add new methods to these interfaces without providing default implementations in minor/patch releases. Downstream consumers should **not** write custom implementations of these interfaces.

*(Note: For experimental public APIs, see the `@BetaApi` stage in the Lifecycle Stages section above.)*

---

## Checklist for API Modifiers & Code Reviewers

- [ ] **Is the API GA?** If so, do **NOT** apply `@Deprecated` directly in a minor release. Apply `@ObsoleteApi` first.
- [ ] **Is it intended only for internal use?** If so, mark it `@InternalApi` so downstream users don't rely on it.
- [ ] **Is it an interface meant only for internal implementation?** Mark it `@InternalExtensionOnly` to protect future extensions.
- [ ] **Does `@ObsoleteApi` or `@Deprecated` have a `value` parameter?** The string must explain *why* and *what* the user should do instead.
- [ ] **Does the Javadoc link to alternatives?** Use `{@link #alternativeMethod()}` so the user can easily navigate in their IDE.
