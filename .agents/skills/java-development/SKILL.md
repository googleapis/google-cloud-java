---
name: java-development
description: Workflow guidance for performing Java development tasks in this repository.
---

# Java Development Workflow

Use this skill when tasked with modifying Java code, fixing bugs, or adding features. It guides you through the typical development lifecycle in this repo.

## Workflow Steps

### Step 1: Understand the Scope
- Determine if you are working on **Core Components** (`sdk-platform-java`) or a specific **Client Library** (`java-<service>`).
- Review the root [AGENTS.md](../../AGENTS.md) for the Style Guide and Dependency Management rules that apply repo-wide.

### Step 2: Make Changes and Build
- Apply your code changes.
- To build efficiently, use the recommended flags or scoped builds detailed in [AGENTS.md](../../AGENTS.md#building-the-project).

### Step 3: Determine and Run Tests
- If working on a **Client Library**, run its unit tests (`mvn test` in the module directory) and check its README for integration test procedures.
- If working on **Core Components** (`sdk-platform-java`), you **must** follow the testing heuristics in [sdk-platform-java/DEVELOPMENT.md](../../../sdk-platform-java/DEVELOPMENT.md#testing-guide) to know which tests are required.
- If golden files need updating, follow the specific procedures referenced in [AGENTS.md](../../AGENTS.md#specialized-development-guides).

### Step 4: Format Code
- You **must** ensure the code is formatted before completing a task. Use the formatting commands listed in [AGENTS.md](../../AGENTS.md#code-formatting).

### Step 5: Verify and Document
- Verify that all tests pass and formatting is correct.
- Follow the Contribution Guidelines in [AGENTS.md](../../AGENTS.md#7-contribution-guidelines) for creating commits and PRs.
