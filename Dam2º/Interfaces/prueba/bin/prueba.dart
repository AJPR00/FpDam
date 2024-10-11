import 'package:youtube_explode_dart/youtube_explode_dart.dart';
import 'package:email_validator/email_validator.dart';

void main(List<String> arguments) {
  var email = "fredrik@gmail.com";

  print((EmailValidator.validate(email)));
}
