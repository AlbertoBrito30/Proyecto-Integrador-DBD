-- Indicar al motor de MySQL que use este esquema 
USE control_estudios;


-- Creación de la Estructura de Almacenamiento
CREATE TABLE estudiantes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100),
    fecha_inscripcion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);