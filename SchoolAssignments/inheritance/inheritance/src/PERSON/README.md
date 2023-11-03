PERSON
- name: String
- address: String
+ Person(name: String, address: String)
+ getName(): String
+ getAddress(): String
+ setAddress(address: String): void
+ toString(): String "name(address)"

STUDENT --extends--> PERSON
- numCourses: int = 0
- courses: String[] = {}
- grades: int[] = {}
+ Student(name: String, address: String)
+ toString(): String
+ addCourseGrade(course: String, grade: int): void
+ printGrades(): void
+ getAverageGrade(): double
+ toString(): String "Student: name(address)"

TEACHER --extends--> PERSON
- numCourses: int = 0
- courses: String[] = {}
+ Teacher(name: String, address: String)
+ toString(): String
+ addCourse(course: String): boolean
+ removeCourse(course: String): boolean
+ toString(): String 