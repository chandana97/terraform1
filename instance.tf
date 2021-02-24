resource "aws_key_pair" "mykey"{
key_name="mykey"
public_key=file(var.PATH_TO_PUBLIC_KEY)
}
resource "aws_instance" "example"{
ami = "ami-07f5c641c23596eb9"
instance_type ="t2.micro"
key_name = "${aws_key_pair.mykey.key_name}"
connection{
user = "${var.INSTANCE_USERNAME}"
private_key =file(var.PATH_TO_PRIVATE_KEY)
}
}
