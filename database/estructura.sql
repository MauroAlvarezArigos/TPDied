CREATE TABLE Estacion (
	id serial,
	nombre varchar(50),
	horarioApertura time,
	horarioCierre time,
	estado varchar(1),
	CONSTRAINT id_pk PRIMARY KEY (id)
);

CREATE TABLE Boleto(
	numeroBoleto serial,
	correo varchar(50),
	nombreCliente varchar(50),
	fechaVenta date,
	origen varchar(50),
	destino varchar(50),
	costo int,
	CONSTRAINT numeroBoleto_pk PRIMARY KEY (numeroBoleto)
);

CREATE TABLE Linea(
	idlinea serial,
	nombre varchar(50),
	color varchar(50),
	estado varchar(1),
	CONSTRAINT idlinea_pk PRIMARY KEY (idlinea)
);

CREATE TABLE Mantenimiento(
	estacion int,
	inicio timestamp,
	fin timestamp,
	observaciones varchar (100),
	CONSTRAINT estacion_fk FOREIGN KEY (estacion) REFERENCES Estacion (id),
	CONSTRAINT estacion_pk PRIMARY KEY (estacion)
);

CREATE TABLE Ruta(
	origen int,
	destino int,
	distancia int,
	tiempoViaje int,
	maxPasajeros int,
	estado varchar(1),
	costo int,
	orden int,
	linea int
);