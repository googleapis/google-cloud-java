CREATE TABLE GroupMgmt (
  group_id INT64,
  grpname STRING(MAX),
) PRIMARY KEY(group_id);

CREATE TABLE Users (
  user_id INT64,
  name STRING(MAX),
) PRIMARY KEY(user_id);

CREATE TABLE membership (
  user_id INT64,
  group_id INT64,
  enrolled TIMESTAMP NOT NULL OPTIONS (
    allow_commit_timestamp = true
  ),
) PRIMARY KEY(user_id, group_id);