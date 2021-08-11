//Estaciones

INSERT INTO ESTACION (nombre, horarioApertura, horarioCierre, estado)
VALUES ('estacion1', '08:00:00', '12:00:00', '1');

INSERT INTO ESTACION (nombre, horarioApertura, horarioCierre, estado)
VALUES ('estacion2', '09:00:00', '13:00:00', '1');

INSERT INTO ESTACION (nombre, horarioApertura, horarioCierre, estado)
VALUES ('estacion3', '08:00:00', '12:30:00', '0');

INSERT INTO ESTACION (nombre, horarioApertura, horarioCierre, estado)
VALUES ('estacion4', '12:00:00', '17:30:00', '1');

INSERT INTO ESTACION (nombre, horarioApertura, horarioCierre, estado)
VALUES ('estacion5', '10:00:00', '15:00:00', '1');

//Lineas

INSERT INTO LINEA (nombre, color, estado)
VALUES ('linea16', 'verde', '1')

INSERT INTO LINEA (nombre, color, estado)
VALUES ('linea2', 'amarillo', '1')

INSERT INTO LINEA (nombre, color, estado)
VALUES ('linea10', 'rojo', '1')

INSERT INTO LINEA (nombre, color, estado)
VALUES ('linea11', 'azul', '1')

INSERT INTO LINEA (nombre, color, estado)
VALUES ('linea5', 'negro', '0')

//BOLETOS

INSERT INTO BOLETO (correo, nombreCliente, fechaVenta, origen, destino, costo)
VALUES ('fulanito1@died.com', 'Narella', '2021-08-01', 'origen1', 'destino1', 50)

INSERT INTO BOLETO (correo, nombreCliente, fechaVenta, origen, destino, costo)
VALUES ('fulanito2@died.com', 'Federico', '2021-08-02', 'origen2', 'destino2', 60)

INSERT INTO BOLETO (correo, nombreCliente, fechaVenta, origen, destino, costo)
VALUES ('fulanito3@died.com', 'Mauro', '2021-08-03', 'origen3', 'destino2', 40)

INSERT INTO BOLETO (correo, nombreCliente, fechaVenta, origen, destino, costo)
VALUES ('fulanito4@died.com', 'Nahuel', '2021-08-04', 'origen3', 'destino1', 100)

//Rutas

INSERT INTO RUTA (origen, destino, distancia, tiempoViaje, maxPasajeros, estado, costo, orden, linea)
VALUES (1 , 2, 120, 50, 30, '1', 50, 1, 10)

INSERT INTO RUTA (origen, destino, distancia, tiempoViaje, maxPasajeros, estado, costo, orden, linea)
VALUES ( 2, 3, 70, 40, 20,  '1', 30, 2, 11)

INSERT INTO RUTA (origen, destino, distancia, tiempoViaje, maxPasajeros, estado, costo, orden, linea)
VALUES ( 1, 3, 35, 30, 40, '1', 25, 3, 2)

INSERT INTO RUTA (origen, destino, distancia, tiempoViaje, maxPasajeros, estado, costo, orden, linea)
VALUES ( 2, 4, 100, 50, 25, '1', 45, 1, 16)







