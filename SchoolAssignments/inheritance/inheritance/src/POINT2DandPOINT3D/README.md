POINT2D
 - x:int = 0
 - y:int = 0
+ Point2D()
+ Point2D(x: int, y: int)
+ getX(): int
+ setX(x: int): void
+ getY(): int
+ setY(y: int): void
+ toString(): String

POINT3D --(extends)--> POINT2D
- z: int = 0
+ Point3D()
+ Point3D(x: int, y: int, z: int)
+ getZ(): int
+ setZ(z: int): void
+ toString(): String