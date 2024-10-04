-- Insertar algunos eventos
INSERT INTO evento (nombre, fecha, lugar) VALUES ('Concierto de Rock', '2024-12-15', 'Estadio Nacional');
INSERT INTO evento (nombre, fecha, lugar) VALUES ('Conferencia de Tecnología', '2024-10-20', 'Centro de Convenciones');
INSERT INTO evento (nombre, fecha, lugar) VALUES ('Festival de Jazz', '2024-11-05', 'Parque Central');

-- Insertar algunos asistentes (si también deseas guardarlos en la BD)
-- Suponiendo que tienes una tabla Asistente (nombre, email)
INSERT INTO asistente (nombre, email) VALUES ('Juan Pérez', 'juan.perez@ucn.cl');
INSERT INTO asistente (nombre, email) VALUES ('María López', 'maria.lopez@ucn.cl');
INSERT INTO asistente (nombre, email) VALUES ('Carlos Sánchez', 'carlos.sanchez@ucn.cl');

-- Insertar la relación entre asistentes y eventos
-- Si tienes una tabla intermedia Evento_Asistente (id_evento, id_asistente)
INSERT INTO evento_asistente (id_evento, id_asistente) VALUES (1, 1);
INSERT INTO evento_asistente (id_evento, id_asistente) VALUES (1, 2);
INSERT INTO evento_asistente (id_evento, id_asistente) VALUES (2, 3);
INSERT INTO evento_asistente (id_evento, id_asistente) VALUES (3, 1);