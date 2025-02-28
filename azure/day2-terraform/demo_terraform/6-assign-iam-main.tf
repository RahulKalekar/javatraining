provider "aws" {
  region = "ap-south-1" 
}

# creating users iam
resource "aws_iam_user" "raj_bca" {
  name = "raj-bca"
}

resource "aws_iam_user" "ekta_bca" {
  name = "ekta-bca"
}

resource "aws_iam_user" "gun_bca" {
  name = "gun-bca"
}

# policy for raj bca ec2
resource "aws_iam_policy" "ec2_list" {
  name        = "ec2-list-policy"
  description = "Allows EC2 list actions"
  policy      = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action   = "ec2:DescribeInstances"
        Effect   = "Allow"
        Resource = "*"
      }
    ]
  })
}

# s3 policy for ekta
resource "aws_iam_policy" "s3_list" {
  name        = "s3-list-policy"
  description = "Allows S3 list actions"
  policy      = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action   = "s3:ListBucket"
        Effect   = "Allow"
        Resource = "*"
      }
    ]
  })
}

# attaching the policies here
resource "aws_iam_policy_attachment" "raj_bca_policy_attachment" {
  name       = "raj-bca-policy-attachment"
  users      = [aws_iam_user.raj_bca.name]
  policy_arn = aws_iam_policy.ec2_list.arn
}

resource "aws_iam_policy_attachment" "ekta_bca_policy_attachment" {
  name       = "ekta-bca-policy-attachment"
  users      = [aws_iam_user.ekta_bca.name]
  policy_arn = aws_iam_policy.s3_list.arn
}

# default policy for gun
resource "aws_iam_policy_attachment" "gun_bca_policy_attachment" {
  name       = "gun-bca-policy-attachment"
  users      = [aws_iam_user.gun_bca.name]
  policy_arn = "arn:aws:iam::aws:policy/ReadOnlyAccess"  
}

