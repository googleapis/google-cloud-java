variable "inputs" {
  type = object({
    project_id                     = string
    # If true, creates the compute network to be used for integration testing.
    should_create_redis_network    = bool
    should_enable_apis_on_apply    = bool
    should_disable_apis_on_destroy = bool
  })
}
