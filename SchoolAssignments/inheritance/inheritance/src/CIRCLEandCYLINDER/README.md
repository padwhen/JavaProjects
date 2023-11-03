CIRCLE [Superclass]

-radius: double = 1.0
-color: String = "red"

+ Circle()
+ Circle(radius: double)
+ Circle(radius: double, color: String)
+ getRadius(): double
+ setRadius(radius: double): void
+ getColor(): String
+ setColor(color: String): void
+ toString(): String
+ getArea(): double

CYLINDER [Subclass] -> extends(Circle)

-height: double = 1.0

+ Cylinder()
+ Cylinder(height: double)
+ Cylinder(height: double, radius: double)
+ Cylinder(height: double, radius: double, Color: String)
+ getHeight(): double
+ setHeight(height: double): void
+ toString(): String
+ getVolume(): double