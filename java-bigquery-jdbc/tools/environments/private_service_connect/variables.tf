variable "project_id" {
  type        = string
  description = "The GCP project ID where resources will be created."
}

variable "region" {
  type        = string
  description = "The region where resources will be created."
  default     = "us-central1"
}

variable "zone" {
  type        = string
  description = "The zone where the VM will be created."
  default     = "us-central1-a"
}

variable "env_name" {
  type        = string
  description = "Identifier used as prefix/suffix for resource names to easily identify them."
  default     = "demo"
}
