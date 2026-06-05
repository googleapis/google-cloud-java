# How to Contribute

We'd love to accept your patches and contributions to this project. There are
just a few small guidelines you need to follow.

## Contributor License Agreement

Contributions to this project must be accompanied by a Contributor License
Agreement. You (or your employer) retain the copyright to your contribution;
this simply gives us permission to use and redistribute your contributions as
part of the project. Head over to
[https://cla.developers.google.com/](https://cla.developers.google.com/) to see
your current agreements on file or to sign a new one.  You generally only need
to submit a CLA once, so if you've already submitted one (even if it was for a
different project), you probably don't need to do it again.

## Code Reviews

All submissions, including submissions by project members, require review. We
use GitHub pull requests for this purpose. Submissions by non-Googlers require
two reviewers. Consult [GitHub
Help](https://help.github.com/articles/about-pull-requests/) for more
information on using pull requests.

### Multi-Approvers Check

Each pull request must be approved by two Googlers. This is enforced by an
automated multi-approvers check. This check may not automatically re-run after
the second approval is added. If it remains in a failed state, you can manually
re-trigger it by:
- Clicking "View details" on the failed workflow to bring you to the "Actions"
  page.
- Clicking "Re-run failed jobs".

For more information, see
[Re-running failed jobs in a workflow](https://docs.github.com/en/actions/how-tos/managing-workflow-runs-and-deployments/managing-workflow-runs/re-running-workflows-and-jobs#re-running-failed-jobs-in-a-workflow).

## Community Guidelines

This project follows
[Google's Open Source Community Guidelines](https://opensource.google/conduct/).

## Before contributing code

Before doing any significant work, open an issue to propose your idea and
ensure alignment. You can either
[file a new issue](https://github.com/googleapis/google-cloud-java/issues/new/choose), or comment on an
[existing one](https://github.com/googleapis/google-cloud-java/issues).

A pull request (PR) that does not go through this coordination process may be
closed to avoid wasted effort.  Make sure your code follows the
[style guidelines](https://github.com/googleapis/librarian/blob/main/doc/howwewritego.md).

## Using the issue tracker

We use GitHub issues to track tasks, bugs, and discussions. Use the issue
tracker as your source of truth.

## Filing a new issue

All changes, except trivial ones, should start with a GitHub issue.

This process gives everyone a chance to validate the design, helps prevent
duplication of effort, and ensures that the idea fits inside the goals for the
language and tools. It also checks that the design is sound before code is
written; the code review tool is not the place for high-level discussions.
Always include a clear description in the body of the issue. The description
should provide enough context for any team member to understand the problem or
request without needing to contact you directly for clarification.

## Leaving a TODO

When adding a TODO to the codebase, always include a link to an issue, no
matter how small the task.

Use the format:

```
// TODO(https://github.com/googleapis/google-cloud-node/issues/<number>): explain what needs to be done
```

This helps provide context for future readers and keeps the TODO relevant and
actionable as the project evolves.

## Sending a pull request

All code changes must be submitted via a pull request. If you are a first-time
contributor, please review the
[GitHub flow](https://docs.github.com/en/get-started/using-github/github-flow)
before starting.

Before sending a pull request, make sure it includes tests if there are logic
changes, copyright headers in every file, and a commit message following the
conventions in the
[Commit messages](https://github.com/googleapis/librarian/blob/main/CONTRIBUTING.md#commit-messages)
section below.

### Open pull requests from a personal fork

Open pull requests from a personal fork. When opening your pull request, enable
"Allow edits from maintainers" to allow others to help you with minor tweaks or
merge conflicts directly.

For a step-by-step guide, see the official documentation on
[creating a pull request from a fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request-from-a-fork).

### Keep pull requests up to date with base branch

The repository is configured to not require branches to be up to date before
merging. This means that you do not have to have the latest changes from the
base branch integrated, unless GitHub detects merge conflicts.  To minimize the
risk of the pull request getting out of date with the base branch, enable
[auto-merge](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/automatically-merging-a-pull-request)
so that the pull request submits as soon as it is approved and the checks pass.

## Commit messages

Commit messages should follow the conventions below:

Here is an example:

```
feat(storage): add new storage bucket feature

A new feature is added to storage.

Fixes \#238
```

### First line

The first line of the change description is a short one-line summary of the
change, following the structure `<type>(<package>): <description>`:

#### type

A structural element defined by the conventions at
[https://www.conventionalcommits.org/en/v1.0.0/\#summary](https://www.conventionalcommits.org/en/v1.0.0/#summary).

Conventional commits are parsed by release tooling to generate release notes.

#### package

The name of the package affected by the change, and should be provided in
parentheses before the colon. (For example, storage or pubsub).

### description

A short one-line summary of the change, that it should be written so to
complete the sentence "This change modifies the codebase to ..." That means it
does not start with a capital letter, is not a complete sentence, and actually
summarizes the result of the change. Note that the verb after the colon is
lowercase, and there is no trailing period.  The first line should be kept as
short as possible (many git viewing tools prefer under ~76 characters).

Follow the first line by a blank line.

### Main content

The rest of the commit message should provide context for the change and
explain what it does. Write in complete sentences with correct punctuation.
Don't use HTML, Markdown, or any other markup language.

### Referencing issues

The special notation "Fixes \#12345" associates the change with issue 12345 in
the issue tracker. When this change is eventually applied, the issue tracker
will automatically mark the issue as fixed.  If the change is a partial step
towards the resolution of the issue, write "For \#12345" instead. This will
leave a comment in the issue linking back to the pull request, but it will not
close the issue when the change is applied.  Please don’t use alternate
GitHub-supported aliases like Close or Resolves instead of Fixes.

## The review process

This section explains the review process in detail and how to approach reviews
after a pull request has been sent for review.

### Getting a code review

Before creating a pull request, make sure that your commit message follows the
suggested format. Otherwise, it can be common for the pull request to be sent
back with that request without review.  After creating a pull request, request
a specific reviewer if relevant, or leave it for the default group.

### Merging a pull request

Pull request titles and descriptions must follow the
[commit messages](https://github.com/googleapis/google-cloud-node/blob/main/CONTRIBUTING.md#commit-messages)
conventions. This enables approvers to review the final commit message. Once
the pull request has been approved and all checks have passed, click the
[Squash and Merge](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/about-pull-request-merges#squash-and-merge-your-commits)
button. The resulting commit message will be based on the pull request's title
and description.

### Reverting a pull request

If a merged pull request needs to be undone, for reasons such as breaking the build, the standard process is to
[revert it through the GitHub interface](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/reverting-a-pull-request).

To revert a pull request:
- Navigate to the merged pull request on GitHub.
- Click the Revert button. This action automatically creates a new branch and a
  pull request containing the revert commit.
- Edit the pull request title and description to comply with the
  [commit message guidelines](https://github.com/googleapis/google-cloud-node/blob/main/CONTRIBUTING.md#commit-messages).
- The newly created revert pull request should be reviewed and merged following
  the same process as any other pull request.

Using the GitHub "Revert" button is the preferred method over manually creating
a revert commit using git revert.

### Keeping the pull request dashboard clean

We aim to keep the pull requests page clean so that we can quickly notice and
review incoming changes that require attention.  Given that goal, please do not
open a pull request unless you are ready for a code review. Draft pull requests
and ones without author activity for more than one business day may be closed
(they can always be reopened later).  If you're still working on something,
continue iterating on your branch without creating a pull request until it’s
ready for review.

### Addressing code review comments

Creating additional commits to address reviewer feedback is generally preferred
over amending and force-pushing. This makes it easier for reviewers to see what
has changed since their last review.  Pull requests are always squashed and
merged. Before merging, please review and edit the resulting commit message to
ensure it clearly describes the change.

After pushing,
[click the
button](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/requesting-a-pull-request-review#requesting-reviews-from-collaborators-and-organization-members)
to ask a reviewer to re-request your review.

## Expectations for the team

A lot of our communication will happen on GitHub issues. Team members are
expected to configure their inboxes to receive GitHub notifications alerts for
all issues and pull requests to ensure effective communication.  If a pull
request becomes inactive or misaligned with current priorities, we may close it
to respect contributor and reviewer time. If you’d like to revisit it, just
comment and reopen the conversation.  If your pull request or issue is stuck,
feel free to follow up over chat. We encourage it!

### Reviewing a pull request

When reviewing a pull request:
- Start by reading the PR description to understand the purpose and context. If
  the commit message doesn’t follow the
  [commit message guidelines](https://github.com/googleapis/google-cloud-node/blob/main/CONTRIBUTING.md#commit-messages),
  request changes.
- Use Approve or Request changes explicitly. Avoid leaving ambiguous feedback.
- Focus on what is in scope. If unrelated issues arise, suggest filing a
  separate PR or issue.
- If you’ve requested changes, approve the PR once the updates are
  satisfactory, even if the author forgot to click the re-request review.
- If a review has stalled or the context has shifted, leave a comment to
  clarify expectations, or close the PR. Keeping the dashboard clean is
  encouraged.

### Addressing Urgent Issues

We categorize issues into two primary levels of urgency:
- critical 🚨: requires immediate fix, should be treated as a p0 issue
- needs fix soon ❗: high priority issue, can be fixed during business hours

When an issue is labeled critical 🚨, the priority is to stabilize the system
enough to downgrade the severity to needs fix soon ❗.

### Maintaining a Healthy Main Branch

All pull requests require passing CI checks to be merged.

The main branch must always be stable, and tests should never fail at HEAD. A
red build on the main branch is a critical issue that must be fixed
immediately.  If tests become flaky or the main branch is not consistently
green, the team's top priority should shift to restoring stability. All feature
development should be deprioritized until green builds can be guaranteed.  When
you see a red x next to a commit on main, file an issue on your GitHub issue
tracker, and label it critical 🚨.  Create a PR to temporarily skip the test,
and verify that you have a green checkmark next to the commit on your main
branch. The issue can now be downgraded to needs fix soon ❗.

## Repository Structure

* `google-cloud-java` (`/pom.xml`)
  * The root aggregator POM that lists all of the modules.
  * Does not get released.
* `google-cloud-pom-parent`
  * Serves as the parent POM for the `gapic-libraries-bom` and module mini BOMs.
  * Should not have any dependency management so as not to impact the BOMs.
* `google-cloud-jar-parent`
  * The root POM for all modules.
  * The only POM where non-annotated versions should be managed using `dependencyManagement`.
  * Contains common configuration for `jar` projects.
* `generation`
  * A collection of scripts that are used to make updates across modules.
* `gapic-libraries-bom`
  * A BOM for all non-preview libraries in the monorepo.
* `java-*`
  * Individual client libraries.

## Using maven for build/test

To run the tests, you must have application default credentials in a JSON file on your development machine.
[Generate a JSON service account key](https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts)
in the cloud console and download they key to a secure location on your development box.
Then set the environment variable GOOGLE_APPLICATION_CREDENTIALS to the location of the JSON file.
For example:

  ```bash
  export GOOGLE_APPLICATION_CREDENTIALS=/path/to/my/key.json
   ```

After you clone the repository, use Maven for building and running the tests.

Integration tests run tests against real services and take a long time to run.
Consider `mvn install -DskipITs` to skip them when installing.
Maven 3.0+ is required.

It's also important to test that changes don't break compatibility with App/Compute Engine and when running elsewhere.
To run tests on different platforms, try deploying the apps available on the [google-cloud-examples](https://github.com/googleapis/google-cloud-examples) repository.
End-to-end tests should ensure that google-cloud-java works when running on the

* App Engine production environment (see the docs for [uploading your app to production App Engine](https://cloud.google.com/appengine/docs/java/tools/maven#uploading_your_app_to_production_app_engine))
* App Engine development server (see the docs for [testing your app with the development server](https://cloud.google.com/appengine/docs/java/tools/maven#testing_your_app_with_the_development_server))
* Compute Engine (see the [Getting Started Guide](https://cloud.google.com/compute/docs/quickstart), and be sure to [enable the appropriate APIs](https://github.com/googleapis/google-cloud-common/tree/master/authentication#on-google-compute-engine))
* Your desktop (using `mvn exec:java`, for example)

When changes are made to authentication and project ID-related code, authentication and project ID inference should be tested using all relevant methods detailed in the [authentication docs](https://github.com/googleapis/google-cloud-java#authentication) and [project ID docs](https://github.com/googleapis/google-cloud-java#specifying-a-project-id).

Known issue: If you have installed the Google Cloud SDK, be sure to log in (using `gcloud auth login`) before running tests. Though the Datastore tests use a local Datastore emulator that doesn't require authentication, they will not run if you have the Google Cloud SDK installed but aren't authenticated.

**Please, do not use your production projects for executing integration tests.** While we do our best to make our tests independent of your project's state and content, they do perform create, modify and deletes, and you do not want to have your production data accidentally modified.

## Adding Features

In order to add a feature to google-cloud-java:

The feature must be fully documented using Javadoc and examples should be provided.
The feature must work fully on Java 7 and above.
The feature must not add unnecessary dependencies (where "unnecessary" is of course subjective,
but new dependencies should be discussed).

## Adding Support for a New Service

See [SUPPORTING_NEW_SERVICES](./SUPPORTING_NEW_SERVICES.md) for guidelines on how to add support for a new Google Cloud service to `google-cloud-java`.

## Coding Style

Maintain the coding style in the project and in particular the modified files.
Follow the Google Java [style](https://google.github.io/styleguide/javaguide.html).

In pull requests, please run `mvn com.spotify.fmt:fmt-maven-plugin:format` to format your code diff.
