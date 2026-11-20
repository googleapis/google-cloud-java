# Agents Guide for java-bigquery-jdbc

Applies to everything under `java-bigquery-jdbc/`, on top of the repo-wide
[AGENTS.md](../AGENTS.md).

Read [DEVELOPMENT.md](DEVELOPMENT.md) before you change code. It has the
architecture, the build and test commands, the logging conventions and the
pre-PR checklist. The guardrails below are the short form of its section 2;
DEVELOPMENT.md is the full text.

## Guardrails

1. **Visibility**: default to `private` or package-private. Make something
   `public` only when a JDBC interface requires it.
2. **Imports**: explicit imports only. No wildcard imports and no inline fully
   qualified names.
3. **Logging**: use `BigQueryJdbcCustomLogger`, not `java.util.logging.Logger`.
4. **Exceptions**: throw types from `com.google.cloud.bigquery.exception`.
5. **Tests**: don't mock final JDK types (`BigDecimal`, `LocalDate`, `Instant`,
   `UUID`) with Mockito. Construct real instances.

## Commands

Run these from `java-bigquery-jdbc/`:

- `make lint` formats the code in place.
- `make unittest` runs all unit tests. `make unittest test=<TestClass>` runs one
  class.
- `make integration-test test=<ITClass>` runs one integration test class. It
  needs `GOOGLE_APPLICATION_CREDENTIALS`.

## Skills

| Skill | Use it when |
| --- | --- |
| `bigquery-jdbc-testing` | Adding, reviewing or refactoring tests under `src/test`. |
| `bigquery-jdbc-prepare-pr` | About to open, update or finish a PR that touches this module. |

Shared skills live in `.agents/skills/<name>/SKILL.md`. To add one, create that
directory with a `SKILL.md` whose front matter has a `name` (the directory name,
prefixed `bigquery-jdbc-`) and a `description` (what the skill does and when to
use it), then add a row to the table above.

- `.claude/skills` is a symlink to `.agents/skills`, so Claude Code finds the
  same skills. On a Windows checkout without symlink support it is a plain text
  file and Claude Code will not see them.
- Only the skills are tracked. `.gitignore` ignores everything else under
  `.agents/` and `.claude/`, so personal rules and local settings stay local.
