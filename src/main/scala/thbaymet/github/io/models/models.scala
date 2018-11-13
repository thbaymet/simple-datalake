package thbaymet.github.io.models

case
class
User
(
  gender: String,
  name: Name,
  email: String,
  login: Login,
  dob: Dob,
  registered: Register,
  phone: String,
  cell: String,
  id: Id,
  picture: Picture,
  nat: String
)
{
  /**
    * Defines whether this user has american nationality
    */
  val isAmerican: Boolean = nat.equalsIgnoreCase("US")

  /**
    * Defines if that user is a male or not
    */
  val isMale: Boolean = gender.equalsIgnoreCase("male")


  val fullName: String = List(name.first, name.last).mkString(" ")

}

case
class
Name
(
  title: String,
  first: String,
  last: String
)

case
class
Location
(
  street: String,
  city: String,
  state: String,
  postcode: String,
  location: Location
)

case
class
Coordinates
(
  latitude: String,
  longitude: String,
  timezone: Timezone
)

case
class
Timezone
(
  offset: String,
  description: String
)

case
class
Login
(
  uuid: String,
  username: String,
  password: String,
  salt: String,
  md5: String,
  sha1: String,
  sha256: String
)

case
class
Dob
(
  date: String,
  age: String
)

case
class
Register
(
  date: String,
  age: String
)

case
class
Id
(
  name: String,
  value: String
)

case
class
Picture
(
  large: String,
  medium: String,
  thumbnail: String
)