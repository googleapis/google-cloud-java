variable "inputs" {
  type = object({
    # GCP Project ID of the project to be used
    project_id = string

    # GCP zone to deploy resources to. Must be a zone in the chosen region.
    zone = string
  })
}