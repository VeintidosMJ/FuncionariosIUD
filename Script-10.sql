-- Crear la tabla de funcionarios
CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    telefono INT,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    numero_identificacion INT NOT NULL,
    direccion VARCHAR(200),
    sexo VARCHAR(20),
    tipo_identificacion VARCHAR(100) NOT NULL,
    estado_civil VARCHAR(100),
    fecha_nacimiento VARCHAR(100) NOT NULL
);
DROP TABLE funcionario;
drop table informacion_academica;


-- Crear la tabla de grupo familiar
CREATE TABLE grupo_familiar (
    id SERIAL PRIMARY KEY,
    funcionario_id INT NOT NULL REFERENCES funcionario(id) ON DELETE CASCADE,
    nombre_miembro VARCHAR(100) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

-- Crear la tabla de información académica
CREATE TABLE informacion_academica (
    id SERIAL PRIMARY KEY,
    funcionario_id INT NOT NULL REFERENCES funcionario(id) ON DELETE CASCADE,
    universidad VARCHAR(100) NOT NULL,
    nivel_estudio VARCHAR(50) NOT NULL,
    titulo_estudio VARCHAR(100) NOT NULL
);

-- Crear índices para mejorar la búsqueda
CREATE INDEX idx_funcionario_numero_identificacion ON funcionario (numero_identificacion);
CREATE INDEX idx_grupo_familiar_funcionario_id ON grupo_familiar (funcionario_id);
CREATE INDEX idx_informacion_academica_funcionario_id ON informacion_academica (funcionario_id);



INSERT INTO grupo_familiar (funcionario_id, nombre_miembro, rol)
VALUES 
(1, 'María Pérez', 'Esposa'),
(1, 'Carlos Pérez', 'Hijo'),
(2, 'Pedro García', 'Esposo');

INSERT INTO informacion_academica (funcionario_id, universidad, nivel_estudio, titulo_estudio)
VALUES 
(1, 'Universidad de Antioquia', 'Pregrado', 'Ingeniero de Sistemas'),
(2, 'Universidad Nacional', 'Maestría', 'Magíster en Administración');