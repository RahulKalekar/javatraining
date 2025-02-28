output "raj_bca_user" {
  value = aws_iam_user.raj_bca.name
}

output "ekta_bca_user" {
  value = aws_iam_user.ekta_bca.name
}

output "gun_bca_user" {
  value = aws_iam_user.gun_bca.name
}

output "ec2_list_policy_arn" {
  value = aws_iam_policy.ec2_list.arn
}

output "s3_list_policy_arn" {
  value = aws_iam_policy.s3_list.arn
}
