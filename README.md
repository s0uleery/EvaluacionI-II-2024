# Primera Evaluación II-2024

### Asignatura: Patrones de Software y Programación <br> Profesor: Daniel San Martín <hr> 

Una empresa de gestión de eventos necesita desarrollar un sistema para administrar sus actividades. 
El sistema debe permitir registrar eventos (conciertos, conferencias, etc.), sus detalles (nombre, fecha, lugar) y 
los asistentes interesados. Además, cada vez que los detalles de un evento se actualicen, los asistentes interesados 
deben ser notificados.

El sistema actual ya tiene una estructura básica implementada, pero tiene algunos problemas de diseño que dificultan 
su mantenimiento y extensión. El código que se proporciona permite registrar eventos y manejar una lista de asistentes 
para cada evento, pero los métodos que manejan estas tareas están fuertemente acoplados entre sí. Además, la interacción
con la base de datos SQLite está distribuida en varias clases, lo que dificulta la modificación de la base de datos.

Se le pide que refactorice el código para mejorar su diseño y calidad, asegurando que las responsabilidades estén mejor
distribuidas, que el código sea más mantenible y escalable, y que el acceso a la base de datos sea más sencillo.