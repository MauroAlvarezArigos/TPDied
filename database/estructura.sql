CREATE TABLE Estacion (
	id int,
	nombre varchar(50),
	horarioApertura time,
	horarioCierre time,
	estado bit,
	CONSTRAINT id_pk PRIMARY KEY (id)
)

CREATE TABLE Boleto(
	numeroBoleto int NOT NULL,
	correo varchar(50),
	nombreCliente varchar(50),
	fechaVenta date,
	origen varchar(50),
	destino varchar(50),
	costo int,
	recorrido ??
	CONSTRAINT numeroBoleto_pk PRIMARY KEY (numeroBoleto)
)

CREATE TABLE Linea(
	nombre varchar(50),
	color varchar(50),
	estado bit,
	CONSTRAINT nombre_pk PRIMARY KEY (nombre)
)

CREATE TABLE Mantenimiento(
	estacion int,
	inicio time,
	fin time,
	observaciones varchar (100),
	CONSTRAINT estacion_fk FOREIGN KEY (estacion) REFERENCES Estacion (id),
	CONSTRAINT estacion_pk PRIMARY KEY (estacion)
)

CREATE TABLE Ruta(
	origen varchar(50),
	destino varchar(50),
	distancia int,
	tiempoViaje int,
	maxPasajeros int,
	estado bit,
	costo int
)